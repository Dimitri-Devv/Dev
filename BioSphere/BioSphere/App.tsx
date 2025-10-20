import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import { AppProvider } from "./Ecrans/context/AppContext"; // ✅ importe le provider
import { LogBox } from 'react-native';
LogBox.ignoreLogs(['Text strings must be rendered within a <Text> component']);

import RegisterScreen from "./Ecrans/RegisterScreen";
import LoginScreen from "./Ecrans/LoginScreen";
import AddEcosystemScreen from "./Ecrans/AddEcosystemScreen";
import TabRoutes from "./routes/tabRoutes";
import EcosystemDetailScreen from "./Ecrans/EcosystemDetailScreen";
import CommentsScreen from "./Ecrans/CommentsScreen";
import ChatScreen from "./Ecrans/ChatScreen";

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <AppProvider> {/* ✅ englobe toute l’app */}
      <NavigationContainer>
        <Stack.Navigator initialRouteName="Auth">
          <Stack.Screen
            name="Auth"
            component={LoginScreen}
            options={{ headerShown: false }}
          />
          <Stack.Screen
            name="Register"
            component={RegisterScreen}
            options={{ title: "Créer un compte", headerShown: true }}
          />
          <Stack.Screen
            name="Main"
            component={TabRoutes}
            options={{ headerShown: false }}
          />
          <Stack.Screen
  name="AddEcosystem"
  component={AddEcosystemScreen}
  options={{
    title: "Ajouter un écosystème",
    headerBackTitle: "Retour",
  }}
/>
          <Stack.Screen
            name="EcosystemDetail"
            component={EcosystemDetailScreen}
          />

          <Stack.Screen name="Comments" component={CommentsScreen} options={{ title: "Commentaires" }} />
          <Stack.Screen name="Chat" component={ChatScreen} options={{ title: "Messages" }} />
        </Stack.Navigator>
      </NavigationContainer>
    </AppProvider>
  );
}
