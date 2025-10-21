import React, { useCallback, useContext, useMemo, useState } from "react";
import {
  View,
  Text,
  StyleSheet,
  FlatList,
  TouchableOpacity,
  Image,
  RefreshControl,
  TextInput,
  Modal,
  Alert,
  ActivityIndicator,
  Platform,
} from "react-native";
import { useFocusEffect } from "@react-navigation/native";
import * as ImagePicker from "expo-image-picker";
import * as ImageManipulator from "expo-image-manipulator";
import { Ionicons, MaterialCommunityIcons } from "@expo/vector-icons";
import { Video } from "expo-av";
import api from "./services/api";
import { AppContext } from "../Ecrans/context/AppContext";

// ------------------------------------------------
// 🔧 Cloudinary credentials
// ------------------------------------------------
const CLOUD_NAME = "ton_cloud_name"; // ← change ici (ex: "biosphereapp")
const UPLOAD_PRESET = "biosphere_uploads"; // ← ton preset unsigned Cloudinary

// ------------------------------------------------
// 🔧 Type de filtres
// ------------------------------------------------
const FILTERS = [
  { label: "Tous", value: "all", icon: "earth" },
  { label: "Eau douce", value: "eau_douce", icon: "fish" },
  { label: "Eau de mer", value: "eau_de_mer", icon: "waves" },
  { label: "Terrarium", value: "terrarium", icon: "leaf" },
  { label: "Bassin", value: "bassin", icon: "water" },
  { label: "Plante", value: "plante", icon: "sprout" },
];

// ------------------------------------------------
// 🧩 Conversion HEIC → JPEG
// ------------------------------------------------
async function convertHeicToJpeg(uri) {
  if (!uri.toLowerCase().endsWith(".heic")) return uri;
  try {
    const manipulated = await ImageManipulator.manipulateAsync(
      uri,
      [],
      { compress: 0.9, format: ImageManipulator.SaveFormat.JPEG }
    );
    console.log("🧩 Converti HEIC → JPEG :", manipulated.uri);
    return manipulated.uri;
  } catch (e) {
    console.warn("⚠️ Erreur conversion HEIC → JPEG :", e.message);
    return uri;
  }
}

// ------------------------------------------------
// 🚀 Upload vers Cloudinary (image ou vidéo)
// ------------------------------------------------
async function uploadMediaToCloudinary(uri) {
  uri = await convertHeicToJpeg(uri);

  const ext = uri.split(".").pop().toLowerCase();
  const isVideo = ["mp4", "mov", "webm"].includes(ext);
  const type = isVideo ? `video/${ext}` : "image/jpeg";

  const data = new FormData();
  data.append("file", { uri, type, name: `upload.${ext}` });
  data.append("upload_preset", UPLOAD_PRESET);
  data.append("cloud_name", CLOUD_NAME);

  try {
    const res = await fetch(
      `https://api.cloudinary.com/v1_1/${CLOUD_NAME}/${isVideo ? "video" : "image"}/upload`,
      { method: "POST", body: data }
    );
    const json = await res.json();
    if (!json.secure_url) throw new Error(JSON.stringify(json));
    console.log("✅ Upload Cloudinary réussi :", json.secure_url);
    return json.secure_url;
  } catch (err) {
    console.error("❌ Erreur upload Cloudinary :", err);
    throw err;
  }
}

// ------------------------------------------------
// 🧱 Carte d’un post
// ------------------------------------------------
function PostCard({ post, onOpenComments, onOpenChat, onOpenProfile, colors }) {
  return (
    <View style={[styles.card, { backgroundColor: colors.card, borderColor: colors.border }]}>
      {/* Auteur */}
      <TouchableOpacity style={styles.cardHeader} onPress={() => onOpenProfile(post.author)}>
        <Image
          source={{ uri: post.author?.photoUrl || "https://cdn-icons-png.flaticon.com/512/149/149071.png" }}
          style={styles.avatar}
        />
        <View style={{ flex: 1 }}>
          <Text style={[styles.author, { color: colors.text }]}>{post.author?.username || "Anonyme"}</Text>
          <Text style={[styles.meta, { color: colors.muted }]}>
            {post.typeLabel} · {new Date(post.createdAt).toLocaleString("fr-FR", { dateStyle: "short", timeStyle: "short" })}
          </Text>
        </View>
      </TouchableOpacity>

      {/* Texte */}
      {!!post.text && <Text style={[styles.postText, { color: colors.text }]}>{post.text}</Text>}

      {/* Médias */}
      {post.images?.length > 0 && (
        <View style={styles.imagesRow}>
          {post.images.map((uri, idx) => {
            const isVideo = uri.includes("/video/") || uri.endsWith(".mp4");
            return isVideo ? (
              <Video
                key={`${post.id}-${idx}`}
                source={{ uri }}
                style={styles.postImage}
                resizeMode="cover"
                useNativeControls
              />
            ) : (
              <Image
                key={`${post.id}-${idx}`}
                source={{ uri }}
                style={styles.postImage}
                resizeMode="cover"
                onError={(e) => console.warn("❌ Erreur image :", uri, e.nativeEvent.error)}
              />
            );
          })}
        </View>
      )}

      {/* Actions */}
      <View style={styles.actionsRow}>
        <TouchableOpacity style={styles.actionBtn} onPress={() => onOpenComments(post)}>
          <Ionicons name="chatbubble-ellipses-outline" size={20} color={colors.accent} />
          <Text style={[styles.actionText, { color: colors.accent }]}>Commentaires</Text>
        </TouchableOpacity>
        <TouchableOpacity style={styles.actionBtn} onPress={() => onOpenChat(post.author)}>
          <Ionicons name="paper-plane-outline" size={20} color={colors.accent} />
          <Text style={[styles.actionText, { color: colors.accent }]}>MP</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

// ------------------------------------------------
// 🧠 Écran principal
// ------------------------------------------------
export default function CommunauteScreen({ route, navigation }) {
  const user = route?.params?.user;
  const { theme } = useContext(AppContext);
  const isDark = theme === "dark";

  const colors = useMemo(() => ({
    bg: isDark ? "#0f1113" : "#fff",
    text: isDark ? "#fff" : "#222",
    muted: isDark ? "#a7a7a7" : "#666",
    card: isDark ? "#171a1d" : "#f7f7f9",
    border: isDark ? "#2b2f34" : "#e5e5ea",
    chip: isDark ? "#1f2327" : "#eef2f5",
    accent: "#2a9d8f",
  }), [isDark]);

  const [filter, setFilter] = useState("all");
  const [posts, setPosts] = useState([]);
  const [refreshing, setRefreshing] = useState(false);
  const [composerVisible, setComposerVisible] = useState(false);
  const [composerType, setComposerType] = useState("eau_de_mer");
  const [composerText, setComposerText] = useState("");
  const [composerImages, setComposerImages] = useState([]);
  const [sending, setSending] = useState(false);

  const removeImage = (i) => setComposerImages((p) => p.filter((_, x) => x !== i));

  const typeLabel = (t) => ({
    eau_de_mer: "Aquarium (eau de mer)",
    eau_douce: "Aquarium (eau douce)",
    terrarium: "Terrarium",
    bassin: "Bassin",
    plante: "Plante",
  }[t] || "Autre");

  // 🔁 Charger les posts
  const fetchPosts = async () => {
    try {
      const res = await api.get("/community/posts", { params: { type: filter } });
      const data = Array.isArray(res.data) ? res.data : [];
      setPosts(data.map((p) => ({ ...p, typeLabel: typeLabel(p.type) })));
    } catch (err) {
      console.log("❌ Erreur fetchPosts :", err.message);
      Alert.alert("Erreur", "Impossible de charger les publications.");
    }
  };

  useFocusEffect(useCallback(() => { fetchPosts(); }, [filter]));

  // ✍️ Publier un post
  const submitPost = async () => {
    if (!user?.id) return Alert.alert("Erreur", "Utilisateur introuvable.");
    if (!composerText.trim() && composerImages.length === 0)
      return Alert.alert("Erreur", "Ajoute une image, une vidéo ou un texte.");

    try {
      setSending(true);
      const uploadedUrls = [];
      for (const uri of composerImages) {
        const url = await uploadMediaToCloudinary(uri);
        uploadedUrls.push(url);
      }

      const payload = {
        userId: user.id,
        type: composerType,
        text: composerText.trim(),
        images: uploadedUrls,
      };

      await api.post("/community/posts", payload);
      setComposerVisible(false);
      setComposerText("");
      setComposerImages([]);
      fetchPosts();
    } catch (err) {
      console.log("❌ Erreur post :", err.message);
      Alert.alert("Erreur", "Impossible de publier.");
    } finally {
      setSending(false);
    }
  };

  // 📸 Caméra
  const takePhoto = async () => {
    const { status } = await ImagePicker.requestCameraPermissionsAsync();
    if (status !== "granted") {
      Alert.alert("Permission refusée", "Autorise l'accès à la caméra.");
      return;
    }

    const result = await ImagePicker.launchCameraAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      quality: 0.8,
    });

    if (!result.canceled) {
      const uri = result.assets?.[0]?.uri ?? result.uri;
      if (uri) setComposerImages((p) => [...p, uri].slice(0, 4));
    }
  };

  // 🖼️ Galerie
  const pickMedias = async () => {
    const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (status !== "granted") {
      Alert.alert("Permission refusée", "Autorise l'accès à la galerie.");
      return;
    }

    const res = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.All,
      allowsMultipleSelection: true,
      selectionLimit: 4,
      quality: 0.8,
    });

    if (!res.canceled && res.assets?.length) {
      const uris = res.assets.map((a) => a.uri);
      setComposerImages((prev) => [...prev, ...uris].slice(0, 4));
    }
  };

  const renderPost = ({ item }) => (
    <PostCard
      post={item}
      onOpenComments={() => navigation.navigate("Comments", { post: item })}
      onOpenChat={() => navigation.navigate("Chat", { toUser: item.author })}
      onOpenProfile={() => navigation.navigate("Profil", { user: item.author })}
      colors={colors}
    />
  );

  return (
    <View style={[styles.container, { backgroundColor: colors.bg }]}>
      {/* Filtres */}
      <FlatList
        data={FILTERS}
        horizontal
        keyExtractor={(f) => f.value}
        showsHorizontalScrollIndicator={false}
        contentContainerStyle={{ paddingHorizontal: 10, paddingVertical: 8 }}
        renderItem={({ item }) => {
          const active = filter === item.value;
          return (
            <TouchableOpacity
              onPress={() => setFilter(item.value)}
              style={[
                styles.chip,
                { backgroundColor: active ? colors.accent : colors.chip, borderColor: colors.border },
              ]}
            >
              <MaterialCommunityIcons name={item.icon} size={14} color={active ? "#fff" : colors.text} />
              <Text style={{ color: active ? "#fff" : colors.text, marginLeft: 6, fontWeight: "600" }}>
                {item.label}
              </Text>
            </TouchableOpacity>
          );
        }}
      />

      {/* Bouton créer un post */}
      <TouchableOpacity
        style={[styles.composerBtn, { backgroundColor: colors.card, borderColor: colors.border }]}
        onPress={() => setComposerVisible(true)}
      >
        <Ionicons name="create-outline" size={20} color={colors.accent} />
        <Text style={[styles.composerText, { color: colors.muted }]}>Écrire un post…</Text>
      </TouchableOpacity>

      {/* Liste des posts */}
      <FlatList
        data={posts}
        keyExtractor={(p) => String(p.id)}
        renderItem={renderPost}
        contentContainerStyle={{ paddingHorizontal: 16, paddingBottom: 80 }}
        refreshControl={<RefreshControl refreshing={refreshing} onRefresh={fetchPosts} />}
      />

      {/* Modal */}
      <Modal visible={composerVisible} animationType="slide">
        <View style={[styles.modalWrap, { backgroundColor: colors.bg }]}>
          <View style={styles.modalHeader}>
            <TouchableOpacity onPress={() => setComposerVisible(false)}>
              <Text style={[styles.cancel, { color: colors.accent }]}>Annuler</Text>
            </TouchableOpacity>
            <Text style={[styles.modalTitle, { color: colors.text }]}>Nouveau post</Text>
            <TouchableOpacity onPress={submitPost} disabled={sending}>
              {sending ? <ActivityIndicator color={colors.accent} /> : <Text style={[styles.publish, { color: colors.accent }]}>Publier</Text>}
            </TouchableOpacity>
          </View>

          {/* Type */}
          <View style={styles.typeRow}>
            {FILTERS.filter((f) => f.value !== "all").map((f) => {
              const active = composerType === f.value;
              return (
                <TouchableOpacity
                  key={f.value}
                  onPress={() => setComposerType(f.value)}
                  style={[
                    styles.typeChip,
                    { backgroundColor: active ? colors.accent : colors.chip, borderColor: colors.border },
                  ]}
                >
                  <Text style={{ color: active ? "#fff" : colors.text }}>{f.label}</Text>
                </TouchableOpacity>
              );
            })}
          </View>

          {/* Texte + images */}
          <TextInput
            style={[styles.inputText, { color: colors.text, borderColor: colors.border }]}
            multiline
            placeholder="Partage ton setup, tes photos, tes vidéos, tes paramètres..."
            placeholderTextColor={colors.muted}
            value={composerText}
            onChangeText={setComposerText}
          />

          {/* Prévisualisation des médias */}
          <View style={styles.imagesPickerRow}>
            {composerImages.map((uri, i) => (
              <View key={i} style={styles.thumbWrap}>
                <Image source={{ uri }} style={styles.thumb} />
                <TouchableOpacity style={styles.removeThumb} onPress={() => removeImage(i)}>
                  <Ionicons name="close" size={14} color="#fff" />
                </TouchableOpacity>
              </View>
            ))}
            {composerImages.length < 4 && (
              <>
                <TouchableOpacity style={[styles.addPhoto, { borderColor: colors.border }]} onPress={pickMedias}>
                  <Ionicons name="images-outline" size={22} color={colors.muted} />
                  <Text style={{ color: colors.muted, fontSize: 12 }}>Galerie</Text>
                </TouchableOpacity>
                <TouchableOpacity style={[styles.addPhoto, { borderColor: colors.border }]} onPress={takePhoto}>
                  <Ionicons name="camera-outline" size={22} color={colors.muted} />
                  <Text style={{ color: colors.muted, fontSize: 12 }}>Caméra</Text>
                </TouchableOpacity>
              </>
            )}
          </View>
        </View>
      </Modal>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  chip: { flexDirection: "row", alignItems: "center", paddingVertical: 6, paddingHorizontal: 10, borderRadius: 20, marginRight: 8, borderWidth: 1 },
  composerBtn: { flexDirection: "row", alignItems: "center", marginHorizontal: 16, marginBottom: 8, padding: 12, borderRadius: 12, borderWidth: 1 },
  composerText: { marginLeft: 8, fontSize: 14 },
  card: { borderRadius: 14, padding: 12, marginBottom: 12, borderWidth: 1 },
  cardHeader: { flexDirection: "row", alignItems: "center", marginBottom: 8 },
  avatar: { width: 36, height: 36, borderRadius: 18, marginRight: 10 },
  author: { fontWeight: "700" },
  meta: { fontSize: 12 },
  postText: { fontSize: 15, marginBottom: 10 },
  imagesRow: { flexDirection: "row", flexWrap: "wrap", gap: 8, marginBottom: 10 },
  postImage: { width: "100%", aspectRatio: 16 / 9, borderRadius: 12 },
  actionsRow: { flexDirection: "row", gap: 12 },
  actionBtn: { flexDirection: "row", alignItems: "center", gap: 6 },
  actionText: { fontWeight: "600" },
  modalWrap: { flex: 1, paddingTop: Platform.OS === "ios" ? 50 : 16, paddingHorizontal: 16 },
  modalHeader: { flexDirection: "row", justifyContent: "space-between", alignItems: "center", marginBottom: 12 },
  cancel: { fontWeight: "700" },
  publish: { fontWeight: "700" },
  modalTitle: { fontSize: 18, fontWeight: "800" },
  typeRow: { flexDirection: "row", flexWrap: "wrap", gap: 8, marginBottom: 10 },
  typeChip: { borderWidth: 1, paddingVertical: 6, paddingHorizontal: 12, borderRadius: 14 },
  inputText: { minHeight: 100, borderWidth: 1, borderRadius: 12, padding: 10, marginBottom: 10 },
  imagesPickerRow: { flexDirection: "row", flexWrap: "wrap", gap: 10 },
  thumbWrap: { position: "relative" },
  thumb: { width: 90, height: 90, borderRadius: 10 },
  removeThumb: { position: "absolute", top: 4, right: 4, backgroundColor: "rgba(0,0,0,0.6)", borderRadius: 10, padding: 3 },
  addPhoto: { width: 90, height: 90, borderRadius: 10, borderWidth: 1, alignItems: "center", justifyContent: "center", gap: 4 },
});
