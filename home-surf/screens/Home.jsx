import React from 'react';
import { Text, View } from 'react-native';
import { Button } from 'react-native-elements';

import styles from './Home.module.scss';

export default function Home() {
  return (
    <View style={styles.container}>
      <Text style={styles.header}>HomeSurf</Text>
      <Button type="clear" titleStyle={styles.title} title="Sign in" />
      <Button type="clear" titleStyle={styles.title} title="Register" />
    </View>
  );
}
