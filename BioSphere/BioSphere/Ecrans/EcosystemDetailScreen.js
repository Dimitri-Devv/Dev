import React, { useEffect, useState, useContext } from 'react';
import {
  View, Text, StyleSheet, ScrollView, Image,
  TouchableOpacity, TextInput, Alert, Dimensions
} from 'react-native';
import { Ionicons, MaterialCommunityIcons } from '@expo/vector-icons';
import * as ImagePicker from 'expo-image-picker';
import { LineChart } from 'react-native-chart-kit';
import api from './services/api';
import { AppContext } from '../Ecrans/context/AppContext';

// Icônes des paramètres
const ICONS = {
  'pH': 'water-outline',
  'Température': 'thermometer',
  'KH': 'chart-bell-curve',
  'CO₂': 'molecule-co2',
  'Oxygène dissous': 'air-filter',
  'Lumière': 'white-balance-sunny',
  'Nutriments': 'sprout',
  'Nitrites (NO₂)': 'test-tube',
  'Nitrates (NO₃)': 'flask-outline',
  'Phosphates (PO₄)': 'flask-round-bottom-outline',
  'Fer (Fe)': 'beaker',
  'Cuivre (Cu)': 'chemical-weapon',
  'Potassium (K)': 'atom',
  'Ammoniaque (NH₃/NH₄)': 'biohazard',
  'Silicates (SiO₂)': 'grain',
  'Salinité': 'waves',
  'Densité': 'scale-balance',
  'Calcium (Ca)': 'bone',
  'Magnésium (Mg)': 'beaker',
  'Strontium (Sr)': 'alpha-s-box',
  'Iode (I)': 'vial',
  'ORP (Redox)': 'current-ac',
  'Turbidité': 'beaker-remove-outline',
  'Humidité': 'water-percent',
  'Humidité du sol': 'flower',
  'EC (Conductivité)': 'flash-outline',
};

// Paramètres selon le type
const PARAMS_BY_TYPE = {
  eau_douce: ['pH', 'Température', 'Nitrites (NO₂)', 'Nitrates (NO₃)', 'Phosphates (PO₄)', 'Fer (Fe)', 'Cuivre (Cu)', 'Potassium (K)', 'KH', 'CO₂'],
  eau_de_mer: [
    'Température', 'Salinité', 'Densité', 'pH', 'KH (Alcalinité)', 'Calcium (Ca)',
    'Magnésium (Mg)', 'Potassium (K)', 'Strontium (Sr)', 'Iode (I)', 'Nitrates (NO₃)',
    'Nitrites (NO₂)', 'Ammoniaque (NH₃/NH₄)', 'Phosphates (PO₄)', 'Fer (Fe)',
    'Silicates (SiO₂)', 'Oxygène dissous', 'ORP (Redox)'
  ],
  bassin: ['Température', 'pH', 'Oxygène dissous', 'Turbidité', 'Nitrites (NO₂)', 'Nitrates (NO₃)', 'Phosphates (PO₄)'],
  plante: ['Humidité du sol', 'Température', 'Lumière', 'CO₂', 'pH', 'EC (Conductivité)', 'Nutriments']
};

export default function EcosystemDetailScreen({ route, navigation }) {
  const { ecosystem } = route.params;
  const [eco, setEco] = useState(ecosystem);
  const [editing, setEditing] = useState(false);
  const [name, setName] = useState(ecosystem.name);
  const [photoUrl, setPhotoUrl] = useState(ecosystem.photoUrl);
  const [equipment, setEquipment] = useState([]);
  const [newEquip, setNewEquip] = useState({ name: '', brand: '', details: '' });
  const [selectedParam, setSelectedParam] = useState('pH');
  const availableParams = PARAMS_BY_TYPE[eco.type] || ['pH', 'Température', 'Nitrates'];
  const [history, setHistory] = useState([]);
  const [newValue, setNewValue] = useState('');

  // 🌙 Thème global
  const { theme } = useContext(AppContext);
  const isDark = theme === 'dark';
  const colors = {
    bg: isDark ? '#121212' : '#f8f9fa',
    card: isDark ? '#1e1e1e' : '#fff',
    text: isDark ? '#fff' : '#2a2a2a',
    secondary: isDark ? '#aaa' : '#555',
    accent: '#2a9d8f'
  };

  const loadEquipment = async () => {
    try { const r = await api.get(`/equipment/${eco.id}`); setEquipment(r.data); } catch {}
  };
  const loadHistory = async () => {
    try { const r = await api.get(`/parameters/history/${eco.id}/${encodeURIComponent(selectedParam)}`); setHistory(r.data || []); } catch {}
  };

  useEffect(() => { loadEquipment(); }, []);
  useEffect(() => { loadHistory(); }, [selectedParam]);

  const pickImage = async () => {
    const res = await ImagePicker.launchImageLibraryAsync({ allowsEditing: true, quality: 1 });
    if (!res.canceled) setPhotoUrl(res.assets[0].uri);
  };

  const saveEco = async () => {
    try {
      const body = { name, photoUrl, type: eco.type };
      const r = await api.put(`/ecosystems/${eco.id}`, body);
      setEco(r.data);
      setEditing(false);
      Alert.alert('Modifié', 'Écosystème mis à jour');
    } catch {
      Alert.alert('Erreur', 'Mise à jour impossible');
    }
  };

  const addEquip = async () => {
    if (!newEquip.name.trim()) return;
    try {
      await api.post('/equipment', { ecosystemId: eco.id, ...newEquip });
      setNewEquip({ name: '', brand: '', details: '' });
      loadEquipment();
    } catch { Alert.alert('Erreur', "Ajout matériel impossible"); }
  };

  const delEquip = async (id) => {
    try { await api.delete(`/equipment/${id}`); loadEquipment(); }
    catch { Alert.alert('Erreur', "Suppression impossible"); }
  };

  const addRecord = async () => {
    const v = parseFloat(newValue.replace(',', '.'));
    if (Number.isNaN(v)) return Alert.alert('Erreur', 'Entrez une valeur numérique');
    try {
      await api.post('/parameters/history', { ecosystemId: eco.id, name: selectedParam, value: v });
      setNewValue('');
      loadHistory();
    } catch { Alert.alert('Erreur', "Ajout de mesure impossible"); }
  };

  const handlePointClick = (data) => {
    if (!history[data.index]) return;
    const record = history[data.index];
    Alert.alert(
      "Supprimer la mesure ?",
      `Valeur : ${record.value}\nDate : ${(record.measuredAt || '').slice(0, 10)}`,
      [
        { text: "Annuler", style: "cancel" },
        {
          text: "Supprimer",
          style: "destructive",
          onPress: async () => {
            try { await api.delete(`/parameters/history/${record.id}`); loadHistory(); }
            catch { Alert.alert("Erreur", "Impossible de supprimer cette valeur."); }
          }
        }
      ]
    );
  };

  return (
    <ScrollView style={[styles.container, { backgroundColor: colors.bg }]}>
      {/* Header */}
      <View style={styles.header}>
        <TouchableOpacity onPress={() => navigation.goBack()}>
          <Ionicons name="arrow-back" size={26} color={colors.accent} />
        </TouchableOpacity>
        <Text style={[styles.title, { color: colors.accent }]}>{eco.name}</Text>
        <TouchableOpacity onPress={() => (editing ? saveEco() : setEditing(true))}>
          <Ionicons name={editing ? 'checkmark' : 'create-outline'} size={26} color={colors.accent} />
        </TouchableOpacity>
      </View>

      {!!photoUrl && <Image source={{ uri: photoUrl }} style={styles.image} />}
      {editing && (
        <TouchableOpacity style={[styles.photoButton, { backgroundColor: colors.accent }]} onPress={pickImage}>
          <Ionicons name="image-outline" size={18} color="#fff" />
          <Text style={styles.photoButtonText}>Changer la photo</Text>
        </TouchableOpacity>
      )}

      {/* Paramètres */}
      <View style={[styles.card, { backgroundColor: colors.card }]}>
        <Text style={[styles.sectionTitle, { color: colors.accent }]}>Paramètres</Text>

        <ScrollView horizontal showsHorizontalScrollIndicator={false} style={styles.paramScroll}>
          {availableParams.map(p => (
            <TouchableOpacity
              key={p}
              style={[styles.paramChip, selectedParam === p && { backgroundColor: colors.accent, borderColor: colors.accent }]}
              onPress={() => setSelectedParam(p)}
            >
              <MaterialCommunityIcons
                name={ICONS[p] || 'flask-outline'}
                size={16}
                color={selectedParam === p ? '#fff' : colors.accent}
                style={{ marginRight: 4 }}
              />
              <Text style={[styles.paramChipText, selectedParam === p && { color: '#fff' }]}>{p}</Text>
            </TouchableOpacity>
          ))}
        </ScrollView>

        {history?.length ? (
          <LineChart
            data={{
              labels: history.map(h => (h.measuredAt || '').slice(5, 10)),
              datasets: [{ data: history.map(h => h.value || 0) }],
            }}
            width={Dimensions.get('window').width - 60}
            height={220}
            fromZero
            yAxisInterval={1}
            onDataPointClick={handlePointClick}
            chartConfig={{
              backgroundGradientFrom: colors.card,
              backgroundGradientTo: colors.card,
              color: () => colors.accent,
              labelColor: () => colors.secondary,
            }}
            style={{ borderRadius: 12, marginVertical: 10 }}
          />
        ) : (
          <Text style={[styles.emptyChart, { color: colors.secondary }]}>Aucune donnée</Text>
        )}

        <View style={styles.addMeasureRow}>
          <TextInput
            style={[styles.input, { color: colors.text, borderColor: colors.secondary }]}
            keyboardType="decimal-pad"
            value={newValue}
            onChangeText={setNewValue}
            placeholder={`Ajouter une valeur (${selectedParam})`}
            placeholderTextColor={colors.secondary}
          />
          <TouchableOpacity onPress={addRecord} style={styles.addBtn}>
            <Ionicons name="add-circle" size={30} color={colors.accent} />
          </TouchableOpacity>
        </View>
      </View>

      {/* Matériel */}
      <View style={[styles.card, { backgroundColor: colors.card }]}>
        <Text style={[styles.sectionTitle, { color: colors.accent }]}>Matériel</Text>
        {equipment.length === 0 ? (
          <Text style={[styles.emptyChart, { color: colors.secondary }]}>Aucun matériel ajouté.</Text>
        ) : (
          equipment.map(it => (
            <View key={it.id} style={styles.equipRow}>
              <Text style={[styles.equipText, { color: colors.text }]}>
                • {it.name}{it.brand ? ` — ${it.brand}` : ''}{it.details ? ` (${it.details})` : ''}
              </Text>
              <TouchableOpacity onPress={() => delEquip(it.id)}>
                <Ionicons name="trash-outline" size={20} color="red" />
              </TouchableOpacity>
            </View>
          ))
        )}

        <TextInput style={[styles.input, { color: colors.text }]} placeholder="Nom du matériel" value={newEquip.name} onChangeText={t => setNewEquip({ ...newEquip, name: t })} />
        <TextInput style={[styles.input, { color: colors.text }]} placeholder="Marque" value={newEquip.brand} onChangeText={t => setNewEquip({ ...newEquip, brand: t })} />
        <TextInput style={[styles.input, { color: colors.text }]} placeholder="Détails" value={newEquip.details} onChangeText={t => setNewEquip({ ...newEquip, details: t })} />
        <TouchableOpacity style={[styles.saveButton, { backgroundColor: colors.accent }]} onPress={addEquip}>
          <Text style={styles.saveButtonText}>Ajouter</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1 },
  header: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center', margin: 15 },
  title: { fontSize: 22, fontWeight: 'bold' },
  image: { width: '90%', height: 200, alignSelf: 'center', borderRadius: 12, marginBottom: 10 },
  photoButton: { flexDirection: 'row', alignItems: 'center', justifyContent: 'center', borderRadius: 8, padding: 10, marginBottom: 10 },
  photoButtonText: { color: '#fff', marginLeft: 6 },
  card: { marginHorizontal: 15, marginVertical: 10, padding: 15, borderRadius: 16 },
  sectionTitle: { fontSize: 18, fontWeight: '700', marginBottom: 8 },
  paramScroll: { flexGrow: 0, marginBottom: 10 },
  paramChip: { flexDirection: 'row', alignItems: 'center', borderWidth: 1, borderRadius: 20, paddingVertical: 6, paddingHorizontal: 10, marginRight: 8 },
  paramChipText: { fontWeight: '600', fontSize: 13 },
  input: { borderWidth: 1, borderRadius: 8, padding: 10, marginVertical: 6, flex: 1 },
  addMeasureRow: { flexDirection: 'row', alignItems: 'center' },
  addBtn: { marginLeft: 10 },
  equipRow: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center', marginBottom: 6 },
  equipText: { fontSize: 15 },
  saveButton: { borderRadius: 8, padding: 12, alignItems: 'center', marginTop: 10 },
  saveButtonText: { color: '#fff', fontWeight: 'bold' },
  emptyChart: { textAlign: 'center', marginVertical: 8 },
});
