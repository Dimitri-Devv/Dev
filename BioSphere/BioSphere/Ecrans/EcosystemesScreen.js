
import { View, Text, StyleSheet, ScrollView, Image, TouchableOpacity, FlatList } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import React, { useEffect, useState } from "react";
import api from "../Components/api/biosphereApi";

export default function EcosystemesScreen() {
  const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    paddingHorizontal: 20,
    paddingTop: 60,
  },
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  title: {
    fontSize: 28,
    fontWeight: 'bold',
  },
  addButton: {
    backgroundColor: '#f2f2f2',
    borderRadius: 20,
    padding: 6,
  },
  subtitle: {
    fontSize: 20,
    fontWeight: '600',
    marginTop: 25,
  },
  cardsContainer: {
    marginTop: 15,
  },
  card: {
    backgroundColor: '#fff',
    borderRadius: 15,
    width: 230,
    marginRight: 15,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowOffset: { width: 0, height: 3 },
    shadowRadius: 5,
    elevation: 3,
  },
  cardImage: {
    width: '100%',
    height: 120,
    borderTopLeftRadius: 15,
    borderTopRightRadius: 15,
  },
  cardContent: {
    padding: 10,
  },
  cardTitle: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 6,
  },
  infoRow: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 3,
  },
  infoText: {
    fontSize: 14,
    marginLeft: 4,
  },
  secondaryText: {
    fontSize: 13,
    color: '#555',
    marginLeft: 4,
  },
});
const [ecosystems, setEcosystems] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await api.get("/ecosystems");
        setEcosystems(res.data);
      } catch (err) {
        console.error("Erreur API :", err);
      }
    };
    fetchData();
  }, []);



  return (
    <ScrollView style={styles.container}>
      {/* En-tête */}
      <View style={styles.header}>
        <Text style={styles.title}>BioSphere</Text>
        <TouchableOpacity style={styles.addButton}>
          <Ionicons name="add" size={26} color="#000" />
        </TouchableOpacity>
      </View>

      <Text style={styles.subtitle}>Mes écosystèmes</Text>

      ------------------------

      Liste des cartes
      <ScrollView horizontal showsHorizontalScrollIndicator={false} style={styles.cardsContainer}>
        {/* --- Carte Aquarium --- */}
        <View style={styles.card}>
          <Image
            source={{ uri: 'https://cdn.futura-sciences.com/buildsv6/images/square720/6/2/4/6244012662_126412_plantes-aquarium-eau-douce.jpg' }}
            style={styles.cardImage}
          />
          <View style={styles.cardContent}>
            <Text style={styles.cardTitle}>Aquarium d'eau douce</Text>
            <View style={styles.infoRow}>
              <Ionicons name="thermometer-outline" size={18} color="black" />
              <Text style={styles.infoText}>25 °C</Text>
              <Ionicons name="water-outline" size={18} color="black" style={{ marginLeft: 10 }} />
              <Text style={styles.infoText}>7.4</Text>
            </View>
            <View style={styles.infoRow}>
              <Ionicons name="refresh-outline" size={18} color="#007AFF" />
              <Text style={styles.secondaryText}>Changement d'eau dans 4 jours</Text>
            </View>
          </View>
        </View>

        {/* --- Carte Terrarium --- */}
        <View style={styles.card}>
          <Image
            source={{ uri: 'https://i.redd.it/3cupuild9ufa1.jpg' }}
            style={styles.cardImage}
          />
          <View style={styles.cardContent}>
            <Text style={styles.cardTitle}>Terrarium</Text>
            <View style={styles.infoRow}>
              <Ionicons name="water-outline" size={18} color="black" />
              <Text style={styles.infoText}>70 %</Text>
            </View>
            <View style={styles.infoRow}>
              <Ionicons name="checkmark-circle-outline" size={18} color="#007AFF" />
              <Text style={styles.secondaryText}>Vérifier l'humidité</Text>
            </View>
          </View>
        </View>
        <View style={styles.container}>
      <Text style={styles.title}>🌎 Mes écosystèmes</Text>
      <FlatList
        data={ecosystems}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <Text style={styles.name}>{item.name}</Text>
            <Text>Type : {item.type}</Text>
          </View>
        )}
      />
    </View>
      </ScrollView>
    </ScrollView>
  );
}
