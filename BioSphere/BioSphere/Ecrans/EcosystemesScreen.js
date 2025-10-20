import React, { useState, useCallback, useContext } from 'react';
import { View, Text, FlatList, Image, StyleSheet, TouchableOpacity, Alert } from 'react-native';
import { useFocusEffect } from '@react-navigation/native';
import { Ionicons } from '@expo/vector-icons';
import api from './services/api';
import { AppContext } from '../Ecrans/context/AppContext';

export default function EcosystemesScreen({ route, navigation }) {
  const user = route.params?.user;
  const [ecosystems, setEcosystems] = useState([]);
  const [loading, setLoading] = useState(false);

  // 🟢 Récupération du thème global
  const { theme } = useContext(AppContext);
  const isDark = theme === 'dark';

  const colors = {
    bg: isDark ? '#121212' : '#fff',
    text: isDark ? '#fff' : '#333',
    secondaryText: isDark ? '#bbb' : '#666',
    cardBg: isDark ? '#1e1e1e' : '#f9f9f9',
    border: isDark ? '#333' : '#ddd',
  };

  // 🧭 Traduction du type
  const formatType = (type) => {
    switch (type) {
      case 'eau_de_mer': return 'Eau de mer';
      case 'eau_douce': return 'Eau douce';
      case 'terrarium': return 'Terrarium';
      case 'bassin': return 'Bassin';
      case 'plante': return 'Plante';
      default: return type;
    }
  };

  // 🔄 Récupération des écosystèmes
  const fetchEcosystems = async () => {
    if (!user?.id) return;
    setLoading(true);
    try {
      const res = await api.get(`/ecosystems/${user.id}`);
      setEcosystems(res.data);
    } catch (err) {
      console.error(err);
      Alert.alert('Erreur', "Impossible de charger les écosystèmes");
    } finally {
      setLoading(false);
    }
  };

  useFocusEffect(useCallback(() => { fetchEcosystems(); }, [user?.id]));

  // ❌ Suppression d’un écosystème
  const handleDelete = (ecoId, name) => {
    Alert.alert("Supprimer", `Supprimer "${name}" ?`, [
      { text: 'Annuler', style: 'cancel' },
      {
        text: 'Supprimer', style: 'destructive', onPress: async () => {
          try {
            await api.delete(`/ecosystems/${ecoId}`);
            fetchEcosystems();
          } catch (e) {
            Alert.alert('Erreur', "Suppression impossible");
          }
        }
      }
    ]);
  };

  // 🪴 Affichage d’un écosystème
  const renderItem = ({ item }) => (
    <TouchableOpacity
      style={[styles.card, { backgroundColor: colors.cardBg, borderColor: colors.border }]}
      onPress={() => navigation.navigate('EcosystemDetail', { ecosystem: item, user })}
    >
      <View style={styles.headerRow}>
        <Text style={[styles.ecoName, { color: colors.text }]}>{item.name}</Text>
        <TouchableOpacity onPress={() => handleDelete(item.id, item.name)}>
          <Ionicons name="trash" size={22} color="red" />
        </TouchableOpacity>
      </View>

      {!!item.photoUrl && (
        <Image source={{ uri: item.photoUrl }} style={styles.cardImage} />
      )}

      <View style={styles.infoRow}>
        <Ionicons name="water-outline" size={18} color="#2a9d8f" />
        <Text style={[styles.ecoType, { color: colors.secondaryText }]}>  {formatType(item.type)}</Text>
      </View>
    </TouchableOpacity>
  );

  return (
    <View style={[styles.container, { backgroundColor: colors.bg }]}>
      <Text style={[styles.title, { color: colors.text }]}>
        Bienvenue {user?.username || user?.email} 👋
      </Text>
      <Text style={[styles.subtitle, { color: colors.secondaryText }]}>
        Vos écosystèmes :
      </Text>

      {loading ? (
        <Text style={[styles.loadingText, { color: colors.secondaryText }]}>Chargement…</Text>
      ) : ecosystems.length === 0 ? (
        <Text style={[styles.empty, { color: colors.secondaryText }]}>
          Aucun écosystème trouvé.
        </Text>
      ) : (
        <FlatList
          data={ecosystems}
          keyExtractor={(i) => i.id.toString()}
          renderItem={renderItem}
          showsVerticalScrollIndicator={false}
        />
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20 },
  title: { fontSize: 22, fontWeight: 'bold', marginBottom: 10 },
  subtitle: { fontSize: 16, marginBottom: 15 },
  loadingText: { textAlign: 'center', marginTop: 40 },
  empty: { textAlign: 'center', marginTop: 40 },
  card: {
    borderRadius: 12,
    padding: 15,
    marginBottom: 15,
    borderWidth: 1,
    elevation: 2,
  },
  headerRow: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  ecoName: { fontSize: 18, fontWeight: 'bold' },
  cardImage: { width: '100%', height: 150, borderRadius: 10, marginTop: 10 },
  infoRow: { flexDirection: 'row', alignItems: 'center', marginTop: 8 },
  ecoType: { fontSize: 14 },
});
