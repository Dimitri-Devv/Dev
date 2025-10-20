import React, { useState, useEffect, useContext } from 'react';
import { View, Text, TextInput, StyleSheet, TouchableOpacity, Image, Alert, ScrollView } from 'react-native';
import { Ionicons } from '@expo/vector-icons';
import * as ImagePicker from 'expo-image-picker';
import api from './services/api';
import { AppContext } from '../Ecrans/context/AppContext';

export default function ProfilScreen({ route }) {
  const { user } = route.params;
  const [profile, setProfile] = useState(user);
  const [editing, setEditing] = useState(false);
  const [loading, setLoading] = useState(false);

  // 🎨 Thème global
  const { theme } = useContext(AppContext);
  const isDark = theme === 'dark';

  const colors = {
    bg: isDark ? '#121212' : '#fff',
    text: isDark ? '#fff' : '#333',
    card: isDark ? '#1e1e1e' : '#f7f7f7',
    inputBg: isDark ? '#222' : '#fff',
    border: isDark ? '#444' : '#ddd',
  };

  // 🔄 Recharge les données utilisateur depuis le back
  const fetchProfile = async () => {
    try {
      const res = await api.get(`/auth/${user.id}`);
      setProfile(res.data);
    } catch (e) {
      console.error(e);
      Alert.alert('Erreur', "Impossible de récupérer les informations du profil.");
    }
  };

  useEffect(() => { fetchProfile(); }, []);

  // 📸 Changer la photo
  const pickImage = async () => {
    const res = await ImagePicker.launchImageLibraryAsync({
      allowsEditing: true,
      quality: 1,
    });
    if (!res.canceled) {
      setProfile({ ...profile, photoUrl: res.assets[0].uri });
    }
  };

  // 💾 Enregistrer les changements
  const handleSave = async () => {
    setLoading(true);
    try {
      const payload = {
        firstName: profile.firstName,
        lastName: profile.lastName,
        username: profile.username,
        bio: profile.bio,
        photoUrl: profile.photoUrl,
      };

      const res = await api.put(`/auth/${profile.id}`, payload);
      setProfile(res.data);
      setEditing(false);
      Alert.alert('Succès', 'Profil mis à jour avec succès.');
    } catch (err) {
      console.error(err);
      Alert.alert('Erreur', "Impossible de mettre à jour le profil.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <ScrollView style={[styles.container, { backgroundColor: colors.bg }]}>
      {/* --- PHOTO DE PROFIL --- */}
      <View style={styles.header}>
        <TouchableOpacity onPress={pickImage}>
          <Image
            source={{
              uri: profile.photoUrl
                ? profile.photoUrl
                : 'https://cdn-icons-png.flaticon.com/512/149/149071.png',
            }}
            style={styles.avatar}
          />
        </TouchableOpacity>

        <View style={{ alignItems: 'center' }}>
          <Text style={[styles.usernameText, { color: colors.text }]}>
            {profile.username ? `@${profile.username}` : 'Utilisateur'}
          </Text>
          <Text style={[styles.emailText, { color: colors.text }]}>{profile.email}</Text>
        </View>

        <TouchableOpacity onPress={() => setEditing(!editing)} style={styles.editButton}>
          <Ionicons name={editing ? 'checkmark' : 'create-outline'} size={26} color="#fff" />
        </TouchableOpacity>
      </View>

      {/* --- CHAMPS DE PROFIL --- */}
      <View style={[styles.infoBlock, { backgroundColor: colors.card }]}>
        <Text style={[styles.label, { color: colors.text }]}>Prénom</Text>
        <TextInput
          style={[
            styles.input,
            { backgroundColor: colors.inputBg, borderColor: colors.border, color: colors.text },
            !editing && styles.disabledInput,
          ]}
          value={profile.firstName || ''}
          onChangeText={(t) => setProfile({ ...profile, firstName: t })}
          editable={editing}
          placeholder="Entrez votre prénom"
          placeholderTextColor={isDark ? '#aaa' : '#666'}
        />

        <Text style={[styles.label, { color: colors.text }]}>Nom</Text>
        <TextInput
          style={[
            styles.input,
            { backgroundColor: colors.inputBg, borderColor: colors.border, color: colors.text },
            !editing && styles.disabledInput,
          ]}
          value={profile.lastName || ''}
          onChangeText={(t) => setProfile({ ...profile, lastName: t })}
          editable={editing}
          placeholder="Entrez votre nom"
          placeholderTextColor={isDark ? '#aaa' : '#666'}
        />

        <Text style={[styles.label, { color: colors.text }]}>Nom d’utilisateur</Text>
        <TextInput
          style={[
            styles.input,
            { backgroundColor: colors.inputBg, borderColor: colors.border, color: colors.text },
            !editing && styles.disabledInput,
          ]}
          value={profile.username || ''}
          onChangeText={(t) => setProfile({ ...profile, username: t })}
          editable={editing}
          placeholder="Entrez un nom d’utilisateur"
          placeholderTextColor={isDark ? '#aaa' : '#666'}
        />

        <Text style={[styles.label, { color: colors.text }]}>Bio</Text>
        <TextInput
          style={[
            styles.input,
            styles.textarea,
            { backgroundColor: colors.inputBg, borderColor: colors.border, color: colors.text },
            !editing && styles.disabledInput,
          ]}
          value={profile.bio || ''}
          onChangeText={(t) => setProfile({ ...profile, bio: t })}
          editable={editing}
          placeholder="Parlez un peu de vous..."
          placeholderTextColor={isDark ? '#aaa' : '#666'}
          multiline
        />
      </View>

      {/* --- BOUTON ENREGISTRER --- */}
      {editing && (
        <TouchableOpacity style={styles.saveButton} onPress={handleSave} disabled={loading}>
          <Text style={styles.saveButtonText}>
            {loading ? 'Enregistrement...' : 'Enregistrer les modifications'}
          </Text>
        </TouchableOpacity>
      )}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20 },
  header: {
    alignItems: 'center',
    marginBottom: 20,
    position: 'relative',
  },
  avatar: {
    width: 120,
    height: 120,
    borderRadius: 100,
    borderWidth: 3,
    borderColor: '#2a9d8f',
    marginBottom: 10,
  },
  usernameText: { fontSize: 20, fontWeight: 'bold' },
  emailText: { fontSize: 14 },
  editButton: {
    position: 'absolute',
    right: 10,
    top: 10,
    backgroundColor: '#2a9d8f',
    padding: 8,
    borderRadius: 20,
  },
  infoBlock: {
    padding: 15,
    borderRadius: 12,
  },
  label: { fontWeight: '600', marginTop: 10 },
  input: {
    borderWidth: 1,
    borderRadius: 8,
    padding: 10,
    marginTop: 4,
  },
  textarea: {
    height: 80,
    textAlignVertical: 'top',
  },
  disabledInput: {
    opacity: 0.7,
  },
  saveButton: {
    backgroundColor: '#2a9d8f',
    padding: 14,
    borderRadius: 10,
    alignItems: 'center',
    marginTop: 20,
  },
  saveButtonText: { color: '#fff', fontWeight: 'bold' },
});
