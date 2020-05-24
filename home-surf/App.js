import React from 'react';
import { Provider as StoreProvider, useSelector } from 'react-redux';
import { createStore } from 'redux';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { AntDesign } from '@expo/vector-icons';
import reducer from './reducer';
import { isUserLoggedIn } from './selectors';

import HomeScreen from './screens/HomeScreen';
import SignInScreen from './screens/SignInScreen';
import RegistrationScreen from './screens/RegistrationScreen';
import ProfileScreen from './screens/ProfileScreen';

import Colors from './colors.js';

const SignInStack = createStackNavigator();
const Tab = createBottomTabNavigator();

function SignInStackScreen({ isLoggedIn }) {
  return (
    <SignInStack.Navigator>
      {isLoggedIn && (
        <SignInStack.Screen name="Profile" component={ProfileScreen} />
      )}
      {!isLoggedIn && (
        <SignInStack.Screen name="Sign In" component={SignInScreen} />
      )}
      {!isLoggedIn && (
        <SignInStack.Screen
          name="Registration"
          component={RegistrationScreen}
        />
      )}
    </SignInStack.Navigator>
  );
}

const store = createStore(reducer);

function MainNavigation() {
  const isLoggedIn = useSelector(isUserLoggedIn);
  return (
    <NavigationContainer>
      <Tab.Navigator
        screenOptions={({ route }) => ({
          tabBarIcon: ({ focused, color, size }) => {
            let iconName;

            if (route.name === 'Search') {
              iconName = 'search1';
            } else if (route.name === 'Sign In' || route.name === 'Profile') {
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
        <Tab.Screen name={isLoggedIn ? 'Profile' : 'Sign In'}>
          {() => <SignInStackScreen isLoggedIn={isLoggedIn} />}
        </Tab.Screen>
        <Tab.Screen name="Inbox" component={HomeScreen} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}
export default function App() {
  return (
    <StoreProvider store={store}>
      <MainNavigation />
    </StoreProvider>
  );
}
