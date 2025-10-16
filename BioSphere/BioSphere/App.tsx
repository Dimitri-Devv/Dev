import * as React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import TabRoutes from './routes/tabRoutes';

export default function App() {
  return (
    <>
    <NavigationContainer>

      <TabRoutes />
    </NavigationContainer>
    </>
    
  );
}
