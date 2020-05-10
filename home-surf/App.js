import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

import Home from './screens/Home';
import Registration from './screens/Registration';
import SignIn from './screens/SignIn';

const Stack = createStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home">
        <Stack.Screen
          name="Home"
          component={Home}
          options={{ title: 'HomeSurf' }}
        />
        <Stack.Screen
          name="Registration"
          component={Registration}
          options={{ title: 'Create an account' }}
        />
        <Stack.Screen
          name="SignIn"
          component={SignIn}
          options={{ title: 'Sign in' }}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
