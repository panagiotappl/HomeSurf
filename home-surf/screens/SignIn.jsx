import React from 'react';
import { Text, View } from 'react-native';
import { Button } from 'react-native-elements';

import globalStyles from '../global.scss';

export default function SignIn({ navigation }) {
  return (
    <View>
      <Text>Sign in</Text>
      <Text>- or create your account -</Text>
      <Button
        type="clear"
        titleStyle={globalStyles['button-title']}
        title="Register"
        onPress={() => navigation.navigate('Registration')}
      />
    </View>
  );
}
