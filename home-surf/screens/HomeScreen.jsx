import React from 'react';
import { Text, View } from 'react-native';

import styles from './HomeScreen.module.scss';

export default function HomeScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <Text style={styles.header}>HomeSurf</Text>
    </View>
  );
}
