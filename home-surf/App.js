import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { AntDesign } from '@expo/vector-icons';

import HomeScreen from './screens/HomeScreen';
import SignInScreen from './screens/SignInScreen';
import RegistrationScreen from './screens/RegistrationScreen';

import Colors from './colors.js';

const SignInStack = createStackNavigator();
const Tab = createBottomTabNavigator();

function SignInStackScreen() {
  return (
    <SignInStack.Navigator>
      <SignInStack.Screen name="Sign In" component={SignInScreen} />
      <SignInStack.Screen name="Registration" component={RegistrationScreen} />
    </SignInStack.Navigator>
  );
}
export default function App() {
  return (
    <NavigationContainer>
      <Tab.Navigator
        screenOptions={({ route }) => ({
          tabBarIcon: ({ focused, color, size }) => {
            let iconName;

            if (route.name === 'Search') {
              iconName = 'search1';
            } else if (route.name === 'Sign In') {
              iconName = 'user';
            } else if (route.name === 'My bookings') {
              iconName = 'calendar';
            } else if (route.name === 'Inbox') {
              iconName = 'mail';
            }

            return <AntDesign name={iconName} size={size} color={color} />;
          },
        })}
        tabBarOptions={{
          activeTintColor: Colors.darkTeal,
          inactiveTintColor: 'gray',
        }}
      >
        <Tab.Screen name="Search" component={HomeScreen} />
        <Tab.Screen name="My bookings" component={HomeScreen} />
        <Tab.Screen name="Sign In" component={SignInStackScreen} />
        <Tab.Screen name="Inbox" component={HomeScreen} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}
