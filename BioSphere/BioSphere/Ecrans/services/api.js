import axios from 'axios';

// ⚠️ adapte l’adresse selon ton setup
// - si tu testes sur simulateur Android : http://10.0.2.2:8080
// - si tu testes sur iOS : http://localhost:8080
// - si tu testes sur ton téléphone via Expo : remplace par ton IP locale (ex: http://192.168.1.76:8081)
const API_BASE_URL = 'http://192.168.1.76:8081/api';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: { 'Content-Type': 'application/json' }, 
  timeout: 10000, // 10 secondes
});

export default api;

