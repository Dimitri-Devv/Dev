import * as React from 'react';
import { Ionicons } from '@expo/vector-icons';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import EcosystemesScreen from '../Ecrans/EcosystemesScreen';
import CommunauteScreen from '../Ecrans/CommunauteScreen';
import ProfilScreen from '../Ecrans/ProfilScreen';
import ParametresScreen from '../Ecrans/ParametresScreen';

const Tab = createBottomTabNavigator();



export default function TabRoutes() {
  return (
  
          
    

    <Tab.Navigator
    
      screenOptions={({ route }) => ({
        tabBarIcon: ({ color, size }) => {
          let iconName;

          if (route.name === 'Écosystèmes') iconName = 'leaf';
          else if (route.name === 'Communauté') iconName = 'people';
          else if (route.name === 'Profil') iconName = 'person';
          else if (route.name === 'Paramètres') iconName = 'settings';

          return <Ionicons name={iconName} size={size} color={color} />;
        },
        tabBarActiveTintColor: '#007AFF',
        tabBarInactiveTintColor: 'gray',
        tabBarStyle: {
          backgroundColor: '#fff',
          borderTopWidth: 0,
          elevation: 0,
          height: 60,
        },
        headerShown: false,
      })}
    >
      <Tab.Screen name="Écosystèmes" component={EcosystemesScreen} />
      <Tab.Screen name="Communauté" component={CommunauteScreen} />
      <Tab.Screen name="Profil" component={ProfilScreen} />
      <Tab.Screen name="Paramètres" component={ParametresScreen} />
    </Tab.Navigator>
  );
}
