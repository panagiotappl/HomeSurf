import React from 'react';
import { useSelector } from 'react-redux';
import { Text, View } from 'react-native';
import { getUsername } from '../selectors';

export default function ProfileScreen({ navigation }) {
  const username = useSelector(getUsername);
  return (
    <View>
      <Text>Welcome to your profile screen, { username }</Text>
      <Button title="Logout" />
    </View>
  );
}
