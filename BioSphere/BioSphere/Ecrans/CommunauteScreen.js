import React, { useCallback, useContext, useEffect, useMemo, useState } from 'react';
import {
  View, Text, StyleSheet, FlatList, TouchableOpacity, Image,
  RefreshControl, TextInput, Modal, Alert, ActivityIndicator, Platform
} from 'react-native';
import { useFocusEffect, useNavigation } from '@react-navigation/native';
import * as ImagePicker from 'expo-image-picker';
import { Ionicons, MaterialCommunityIcons } from '@expo/vector-icons';
import api from './services/api';
import { AppContext } from '../Ecrans/context/AppContext';

const FILTERS = [
  { label: 'Tous', value: 'all', icon: 'earth' },
  { label: 'Eau douce', value: 'eau_douce', icon: 'fish' },
  { label: 'Eau de mer', value: 'eau_de_mer', icon: 'waves' },
  { label: 'Terrarium', value: 'terrarium', icon: 'leaf' },
  { label: 'Bassin', value: 'bassin', icon: 'water' },
  { label: 'Plante', value: 'plante', icon: 'sprout' },
];

// Petite carte pour un post (mini composant)
function PostCard({ post, onOpenComments, onOpenChat, onOpenProfile, colors }) {
  return (
    <View style={[styles.card, { backgroundColor: colors.card, borderColor: colors.border }]}>
      {/* Header auteur */}
      <TouchableOpacity style={styles.cardHeader} onPress={() => onOpenProfile(post.author)}>
        <Image
          source={{ uri: post.author.photoUrl || 'https://cdn-icons-png.flaticon.com/512/149/149071.png' }}
          style={styles.avatar}
        />
        <View style={{ flex: 1 }}>
          <Text style={[styles.author, { color: colors.text }]}>
            {post.author.username || post.author.email}
          </Text>
          <Text style={[styles.meta, { color: colors.muted }]}>
            {post.typeLabel} · {new Date(post.createdAt).toLocaleString()}
          </Text>
        </View>
      </TouchableOpacity>

      {/* Texte */}
      {!!post.text && <Text style={[styles.postText, { color: colors.text }]}>{post.text}</Text>}

      {/* Images */}
      {!!post.images?.length && (
        <View style={styles.imagesRow}>
          {post.images.map((uri, idx) => (
            <Image key={idx} source={{ uri }} style={styles.postImage} />
          ))}
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

export default function CommunauteScreen({ route, navigation }) {
  // si tu passes user depuis TabRoutes : route?.params?.user
  const user = route?.params?.user;

  // Thème
  const { theme } = useContext(AppContext);
  const isDark = theme === 'dark';
  const colors = useMemo(() => ({
    bg: isDark ? '#0f1113' : '#fff',
    text: isDark ? '#fff' : '#222',
    muted: isDark ? '#a7a7a7' : '#666',
    card: isDark ? '#171a1d' : '#f7f7f9',
    border: isDark ? '#2b2f34' : '#e5e5ea',
    chip: isDark ? '#1f2327' : '#eef2f5',
    accent: '#2a9d8f',
  }), [isDark]);

  // Filtres & feed
  const [filter, setFilter] = useState('all');
  const [posts, setPosts] = useState([]);
  const [refreshing, setRefreshing] = useState(false);
  const [page, setPage] = useState(1); // pour la pagination simple
  const [loadingMore, setLoadingMore] = useState(false);

  // Composer (modal de création)
  const [composerVisible, setComposerVisible] = useState(false);
  const [composerType, setComposerType] = useState('eau_de_mer');
  const [composerText, setComposerText] = useState('');
  const [composerImages, setComposerImages] = useState([]);
  const [sending, setSending] = useState(false);

  // Helpers format libellé type
  const typeLabel = (t) => {
    switch (t) {
      case 'eau_de_mer': return 'Aquarium (eau de mer)';
      case 'eau_douce': return 'Aquarium (eau douce)';
      case 'terrarium': return 'Terrarium';
      case 'bassin': return 'Bassin';
      case 'plante': return 'Plante';
      default: return 'Autre';
    }
  };

  // Charger le feed
  const fetchPosts = async (reset = false) => {
    try {
      const nextPage = reset ? 1 : page;
      const res = await api.get('/community/posts', {
        params: { type: filter, page: nextPage, pageSize: 10 },
      });

      // On mappe les types en libellés ici pour l’UI
      const items = (res.data || []).map(p => ({
        ...p,
        typeLabel: typeLabel(p.type),
      }));

      if (reset) {
        setPosts(items);
        setPage(2);
      } else {
        setPosts(prev => [...prev, ...items]);
        setPage(nextPage + 1);
      }
    } catch (e) {
      console.log(e);
      Alert.alert('Erreur', 'Impossible de charger les publications.');
    }
  };

  // Refresh
  const onRefresh = async () => {
    setRefreshing(true);
    await fetchPosts(true);
    setRefreshing(false);
  };

  // Infinite scroll
  const loadMore = async () => {
    if (loadingMore) return;
    setLoadingMore(true);
    await fetchPosts(false);
    setLoadingMore(false);
  };

  // Montage + filtre
  useFocusEffect(
    useCallback(() => {
      fetchPosts(true);
    }, [filter])
  );

  // Ouvrir profil public
  const openProfile = (author) => {
    // Tu peux créer un écran UserPublicProfile si tu veux séparer
    navigation.navigate('Profil', { user: author }); // simple: réutilise Profil avec user passé
  };

  // Ouvrir commentaires
  const openComments = (post) => {
    navigation.navigate('Comments', { postId: post.id, post });
  };

  // Ouvrir chat (MP)
  const openChat = (author) => {
    navigation.navigate('Chat', { toUser: author });
  };

  // Choix images (max 4)
  const pickImages = async () => {
    const result = await ImagePicker.launchImageLibraryAsync({
      allowsMultipleSelection: true,
      selectionLimit: 4,
      quality: 0.8,
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
    });
    if (!result.canceled) {
      const uris = result.assets.map(a => a.uri);
      setComposerImages(prev => [...prev, ...uris].slice(0, 4));
    }
  };

  const takePhoto = async () => {
    const cam = await ImagePicker.requestCameraPermissionsAsync();
    if (cam.status !== 'granted') return Alert.alert('Permission caméra refusée');
    const res = await ImagePicker.launchCameraAsync({ quality: 0.8 });
    if (!res.canceled) setComposerImages(prev => [...prev, res.assets[0].uri].slice(0, 4));
  };

  const removeImage = (idx) => {
    setComposerImages(prev => prev.filter((_, i) => i !== idx));
  };

  // Envoi post
  const submitPost = async () => {
    if (!user?.id) return Alert.alert('Erreur', 'Utilisateur introuvable.');
    if (!composerText.trim() && composerImages.length === 0) {
      return Alert.alert('Erreur', 'Écris un message ou ajoute au moins une photo.');
    }

    try {
      setSending(true);

      // Ici, on envoie en JSON simple (URIs). Si tu uploades sur le back, passe en multipart/form-data.
      const payload = {
        userId: user.id,
        type: composerType,
        text: composerText.trim(),
        images: composerImages, // URIs locales; côté back, accepte des URLs/base64 selon ton choix
      };

      await api.post('/community/posts', payload);

      setComposerText('');
      setComposerImages([]);
      setComposerType('eau_de_mer');
      setComposerVisible(false);
      await fetchPosts(true);
    } catch (e) {
      console.log(e);
      Alert.alert('Erreur', "Impossible de publier.");
    } finally {
      setSending(false);
    }
  };

  const renderPost = ({ item }) => (
    <PostCard
      post={item}
      onOpenComments={openComments}
      onOpenChat={openChat}
      onOpenProfile={openProfile}
      colors={colors}
    />
  );

  return (
    <View style={[styles.container, { backgroundColor: colors.bg }]}>
      {/* Filtres */}
      <FlatList
        data={FILTERS}
        keyExtractor={(f) => f.value}
        horizontal
        showsHorizontalScrollIndicator={false}
        contentContainerStyle={{ paddingHorizontal: 16, paddingTop: 10, paddingBottom: 6 }}
        renderItem={({ item }) => {
          const active = filter === item.value;
          return (
            <TouchableOpacity
              onPress={() => setFilter(item.value)}
              style={[
                styles.chip,
                { backgroundColor: active ? colors.accent : colors.chip, borderColor: colors.border }
              ]}
            >
              <MaterialCommunityIcons
                name={item.icon}
                size={16}
                color={active ? '#fff' : colors.text}
                style={{ marginRight: 6 }}
              />
              <Text style={{ color: active ? '#fff' : colors.text, fontWeight: '600' }}>
                {item.label}
              </Text>
            </TouchableOpacity>
          );
        }}
      />

      {/* Bouton composer */}
      <TouchableOpacity style={[styles.composerBtn, { backgroundColor: colors.card, borderColor: colors.border }]} onPress={() => setComposerVisible(true)}>
        <Ionicons name="create-outline" size={20} color={colors.accent} />
        <Text style={[styles.composerText, { color: colors.muted }]}>Écrire un post…</Text>
      </TouchableOpacity>

      {/* Feed */}
      <FlatList
        data={posts}
        keyExtractor={(p) => String(p.id)}
        renderItem={renderPost}
        contentContainerStyle={{ padding: 16, paddingTop: 8 }}
        refreshControl={
          <RefreshControl refreshing={refreshing} onRefresh={onRefresh} tintColor={colors.accent} />
        }
        onEndReachedThreshold={0.4}
        onEndReached={loadMore}
        ListFooterComponent={
          loadingMore ? <ActivityIndicator style={{ marginVertical: 10 }} color={colors.accent} /> : null
        }
        ListEmptyComponent={
          <Text style={{ color: colors.muted, textAlign: 'center', marginTop: 30 }}>
            Aucun post pour le moment.
          </Text>
        }
      />

      {/* Modal composer */}
      <Modal visible={composerVisible} animationType="slide" onRequestClose={() => setComposerVisible(false)}>
        <View style={[styles.modalWrap, { backgroundColor: colors.bg }]}>
          <View style={styles.modalHeader}>
            <TouchableOpacity onPress={() => setComposerVisible(false)}>
              <Text style={[styles.cancel, { color: colors.accent }]}>Annuler</Text>
            </TouchableOpacity>
            <Text style={[styles.modalTitle, { color: colors.text }]}>Nouveau post</Text>
            <TouchableOpacity onPress={submitPost} disabled={sending}>
              {sending ? (
                <ActivityIndicator color={colors.accent} />
              ) : (
                <Text style={[styles.publish, { color: colors.accent }]}>Publier</Text>
              )}
            </TouchableOpacity>
          </View>

          {/* Type */}
          <View style={styles.typeRow}>
            {FILTERS.filter(f => f.value !== 'all').map(f => {
              const active = composerType === f.value;
              return (
                <TouchableOpacity
                  key={f.value}
                  onPress={() => setComposerType(f.value)}
                  style={[
                    styles.typeChip,
                    { backgroundColor: active ? colors.accent : colors.chip, borderColor: colors.border }
                  ]}
                >
                  <Text style={{ color: active ? '#fff' : colors.text, fontWeight: '600' }}>{f.label}</Text>
                </TouchableOpacity>
              );
            })}
          </View>

          {/* Texte */}
          <TextInput
            style={[
              styles.inputText,
              { color: colors.text, borderColor: colors.border, backgroundColor: isDark ? '#121417' : '#fff' }
            ]}
            multiline
            placeholder="Partage ton setup, des photos, tes paramètres…"
            placeholderTextColor={colors.muted}
            value={composerText}
            onChangeText={setComposerText}
          />

          {/* Images */}
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
                <TouchableOpacity style={[styles.addPhoto, { borderColor: colors.border }]} onPress={pickImages}>
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

  chip: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingVertical: 8, paddingHorizontal: 12,
    borderRadius: 20, marginRight: 8, borderWidth: 1,
  },

  composerBtn: {
    flexDirection: 'row', alignItems: 'center',
    marginHorizontal: 16, marginBottom: 8, padding: 12,
    borderRadius: 12, borderWidth: 1,
  },
  composerText: { marginLeft: 8, fontSize: 14 },

  card: {
    borderRadius: 16, padding: 12, marginBottom: 14,
    borderWidth: 1,
  },
  cardHeader: { flexDirection: 'row', alignItems: 'center', marginBottom: 8 },
  avatar: { width: 36, height: 36, borderRadius: 20, marginRight: 10 },
  author: { fontWeight: '700' },
  meta: { fontSize: 12 },

  postText: { fontSize: 15, marginBottom: 10 },
  imagesRow: { flexDirection: 'row', flexWrap: 'wrap', gap: 8, marginBottom: 10 },
  postImage: { width: '100%', aspectRatio: 16/9, borderRadius: 12 },

  actionsRow: { flexDirection: 'row', gap: 12 },
  actionBtn: { flexDirection: 'row', alignItems: 'center', gap: 6, paddingVertical: 6 },
  actionText: { fontWeight: '600' },

  // Modal composer
  modalWrap: { flex: 1, paddingTop: Platform.OS === 'ios' ? 50 : 16, paddingHorizontal: 16 },
  modalHeader: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center', marginBottom: 12 },
  cancel: { fontWeight: '700' },
  publish: { fontWeight: '700' },
  modalTitle: { fontSize: 18, fontWeight: '800' },

  typeRow: { flexDirection: 'row', flexWrap: 'wrap', gap: 8, marginBottom: 10 },
  typeChip: { borderWidth: 1, paddingVertical: 7, paddingHorizontal: 12, borderRadius: 14 },

  inputText: { minHeight: 120, borderWidth: 1, borderRadius: 12, padding: 12, marginBottom: 10 },

  imagesPickerRow: { flexDirection: 'row', flexWrap: 'wrap', gap: 10 },
  thumbWrap: { position: 'relative' },
  thumb: { width: 90, height: 90, borderRadius: 10 },
  removeThumb: {
    position: 'absolute', top: 4, right: 4,
    backgroundColor: 'rgba(0,0,0,0.6)', borderRadius: 10, padding: 3,
  },
  addPhoto: {
    width: 90, height: 90, borderRadius: 10, borderWidth: 1,
    alignItems: 'center', justifyContent: 'center', gap: 6,
  },
});
