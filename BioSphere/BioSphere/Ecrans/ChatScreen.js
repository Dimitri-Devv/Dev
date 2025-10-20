import React, { useContext, useState } from 'react';
import { View, Text, StyleSheet, TextInput, TouchableOpacity, FlatList } from 'react-native';
import { AppContext } from '../Ecrans/context/AppContext';

export default function ChatScreen({ route }) {
  const { toUser } = route.params;
  const { theme } = useContext(AppContext);
  const isDark = theme === 'dark';

  const [messages, setMessages] = useState([]);
  const [text, setText] = useState('');

  const colors = {
    bg: isDark ? '#0f1113' : '#fff',
    text: isDark ? '#fff' : '#222',
    card: isDark ? '#171a1d' : '#f7f7f9',
    border: isDark ? '#2b2f34' : '#e5e5ea',
    muted: isDark ? '#a7a7a7' : '#666',
    accent: '#2a9d8f',
  };

  const send = () => {
    if (!text.trim()) return;
    const msg = { id: Date.now(), text: text.trim(), mine: true };
    setMessages(prev => [msg, ...prev]);
    setText('');
  };

  return (
    <View style={[styles.container, { backgroundColor: colors.bg }]}>
      <Text style={{ color: colors.text, textAlign:'center', marginVertical:10 }}>
        Conversation avec {toUser.username || toUser.email}
      </Text>

      <FlatList
        data={messages}
        keyExtractor={m => String(m.id)}
        inverted
        contentContainerStyle={{ padding: 16 }}
        renderItem={({item}) => (
          <View style={[
            styles.bubble,
            { alignSelf: item.mine ? 'flex-end' : 'flex-start',
              backgroundColor: item.mine ? colors.accent : colors.card }
          ]}>
            <Text style={{ color: item.mine ? '#fff' : colors.text }}>{item.text}</Text>
          </View>
        )}
      />

      <View style={[styles.row, { borderTopColor: colors.border }]}>
        <TextInput
          value={text}
          onChangeText={setText}
          placeholder="Écrire un message…"
          placeholderTextColor={colors.muted}
          style={[styles.input, { color: colors.text }]}
        />
        <TouchableOpacity style={[styles.send, { backgroundColor: colors.accent }]} onPress={send}>
          <Text style={{ color:'#fff', fontWeight:'700' }}>Envoyer</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}
const styles = StyleSheet.create({
  container:{ flex:1 },
  bubble:{ padding:10, borderRadius:12, marginBottom:10, maxWidth:'80%' },
  row:{ flexDirection:'row', alignItems:'center', padding:10, borderTopWidth:1 },
  input:{ flex:1, padding:10 },
  send:{ paddingVertical:10, paddingHorizontal:14, borderRadius:10, marginLeft:8 }
});
