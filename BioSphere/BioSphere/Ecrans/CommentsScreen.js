import React, { useEffect, useState, useContext } from 'react';
import { View, Text, StyleSheet, FlatList, TextInput, TouchableOpacity } from 'react-native';
import { AppContext } from '../Ecrans/context/AppContext';
import api from './services/api';

export default function CommentsScreen({ route }) {
  const { post } = route.params;
  const { theme } = useContext(AppContext);
  const isDark = theme === 'dark';

  const colors = {
    bg: isDark ? '#0f1113' : '#fff',
    text: isDark ? '#fff' : '#222',
    card: isDark ? '#171a1d' : '#f7f7f9',
    border: isDark ? '#2b2f34' : '#e5e5ea',
    muted: isDark ? '#a7a7a7' : '#666',
    accent: '#2a9d8f',
  };

  const [comments, setComments] = useState([]);
  const [message, setMessage] = useState('');

  const fetchComments = async () => {
    try {
      const res = await api.get(`/community/posts/${post.id}/comments`);
      setComments(res.data || []);
    } catch {}
  };

  useEffect(() => { fetchComments(); }, []);

  const send = async () => {
    if (!message.trim()) return;
    try {
      await api.post(`/community/posts/${post.id}/comments`, { text: message.trim() });
      setMessage('');
      fetchComments();
    } catch {}
  };

  return (
    <View style={[styles.container, { backgroundColor: colors.bg }]}>
      <FlatList
        data={comments}
        keyExtractor={(c) => String(c.id)}
        contentContainerStyle={{ padding: 16 }}
        renderItem={({ item }) => (
          <View style={[styles.item, { backgroundColor: colors.card, borderColor: colors.border }]}>
            <Text style={{ color: colors.text, fontWeight: '700' }}>{item.author.username || item.author.email}</Text>
            <Text style={{ color: colors.text }}>{item.text}</Text>
          </View>
        )}
        ListEmptyComponent={<Text style={{ color: colors.muted, textAlign: 'center' }}>Aucun commentaire.</Text>}
      />

      <View style={[styles.inputRow, { borderTopColor: colors.border }]}>
        <TextInput
          value={message}
          onChangeText={setMessage}
          placeholder="Écrire un commentaire…"
          placeholderTextColor={colors.muted}
          style={[styles.input, { color: colors.text }]}
        />
        <TouchableOpacity style={[styles.send, { backgroundColor: colors.accent }]} onPress={send}>
          <Text style={{ color: '#fff', fontWeight: '700' }}>Envoyer</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}
const styles = StyleSheet.create({
  container:{ flex:1 },
  item:{ borderWidth:1, borderRadius:12, padding:10, marginBottom:10 },
  inputRow:{ flexDirection:'row', alignItems:'center', padding:10, borderTopWidth:1 },
  input:{ flex:1, padding:10 },
  send:{ paddingVertical:10, paddingHorizontal:14, borderRadius:10, marginLeft:8 }
});
