import React, { useEffect, useState } from "react";
import { View, Text, Image, StyleSheet, FlatList, ActivityIndicator } from "react-native";

const ecosystemTypeLabels = {
  eau_douce: "Aquarium d’eau douce",
  eau_de_mer: "Aquarium marin",
  terrarium: "Terrarium",
  bassin: "Bassin",
  plante: "Plante",
};

export default function ProfilPublic({ route }) {
  const { user } = route.params;
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    if (user?.id) {
      fetch(`http://192.168.1.76:8081/api/community/users/${user.id}`)
        .then((res) => res.json())
        .then((data) => {
          setUserData(data);
          setLoading(false);
        })
        .catch((err) => {
          console.error("Erreur chargement profil :", err);
          setLoading(false);
        });
    }
  }, [user]);

  if (loading) {
    return (
      <View style={styles.loadingContainer}>
        <ActivityIndicator size="large" color="#2a9d8f" />
      </View>
    );
  }

  if (!userData) {
    return (
      <View style={styles.loadingContainer}>
        <Text>Utilisateur introuvable.</Text>
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <Image
        source={{
          uri: userData?.photoUrl || "https://cdn-icons-png.flaticon.com/512/149/149071.png",
        }}
        style={styles.avatar}
      />
      <Text style={styles.username}>{userData?.username || "Utilisateur inconnu"}</Text>
      {userData?.bio && <Text style={styles.bio}>{userData.bio}</Text>}

      <Text style={styles.sectionTitle}>Écosystèmes :</Text>
      <FlatList
        data={userData?.ecosystems || []}
        keyExtractor={(item) => String(item.id)}
        renderItem={({ item }) => (
          <View style={styles.ecoCard}>
            {item.photoUrl && (
              <Image
                source={{ uri: item.photoUrl }}
                style={styles.ecoImage}
                resizeMode="cover"
              />
            )}
            <View style={styles.ecoText}>
              <Text style={styles.ecoName}>{item.name}</Text>
              <Text style={styles.ecoType}>{ecosystemTypeLabels[item.type] || "Type inconnu"}</Text>
            </View>
          </View>
        )}
        ListEmptyComponent={<Text style={styles.empty}>Aucun écosystème public</Text>}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20, backgroundColor: "#fff" },
  loadingContainer: { flex: 1, justifyContent: "center", alignItems: "center" },
  avatar: { width: 100, height: 100, borderRadius: 50, alignSelf: "center" },
  username: { fontSize: 22, fontWeight: "bold", textAlign: "center", marginTop: 10 },
  bio: { textAlign: "center", marginVertical: 10, color: "#555" },
  sectionTitle: { fontSize: 18, fontWeight: "bold", marginTop: 20, marginBottom: 10 },
  ecoCard: {
    backgroundColor: "#fff",
    borderRadius: 12,
    padding: 15,
    marginBottom: 15,
    alignItems: "center",
    shadowColor: "#000",
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
    elevation: 3,
  },
  ecoImage: { width: 80, height: 80, borderRadius: 10, marginBottom: 10 },
  ecoText: { alignItems: "center" },
  ecoName: { fontSize: 18, fontWeight: "600", marginBottom: 4, textAlign: "center" },
  ecoType: { fontSize: 14, color: "#777", textAlign: "center" },
  empty: { textAlign: "center", color: "#999", marginTop: 10 },
});