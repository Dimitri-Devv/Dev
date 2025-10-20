import React, { createContext, useState, useEffect } from 'react';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { Appearance } from 'react-native';

export const AppContext = createContext();

export const AppProvider = ({ children }) => {
  const [theme, setTheme] = useState(Appearance.getColorScheme() || 'light');
  const [language, setLanguage] = useState('fr');

  useEffect(() => {
    const loadPrefs = async () => {
      try {
        const savedTheme = await AsyncStorage.getItem('theme');
        const savedLang = await AsyncStorage.getItem('language');
        if (savedTheme) setTheme(savedTheme);
        if (savedLang) setLanguage(savedLang);
      } catch (err) {
        console.log('Erreur chargement préférences', err);
      }
    };
    loadPrefs();
  }, []);

  const toggleTheme = async () => {
    const newTheme = theme === 'light' ? 'dark' : 'light';
    setTheme(newTheme);
    await AsyncStorage.setItem('theme', newTheme);
  };

  const toggleLanguage = async () => {
    const newLang = language === 'fr' ? 'en' : 'fr';
    setLanguage(newLang);
    await AsyncStorage.setItem('language', newLang);
  };

  return (
    <AppContext.Provider
      value={{
        theme,
        toggleTheme,
        language,
        toggleLanguage,
      }}
    >
      {children}
    </AppContext.Provider>
  );
};
