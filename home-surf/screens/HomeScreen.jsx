import React from 'react';
import { Text, View } from 'react-native';

import styles from './HomeScreen.module.scss';

export default function Home({ navigation }) {
  return (
    <View style={styles.container}>
      <Text style={styles.header}>HomeSurf</Text>
    </View>
  );
}
