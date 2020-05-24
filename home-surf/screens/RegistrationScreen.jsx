import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Button, View } from 'react-native';
import { Input } from 'react-native-elements';
import Icon from 'react-native-vector-icons/FontAwesome';
import { login } from '../actions';

import Colors from '../colors.js';
import styles from './RegistrationScreen.module.scss';

export default function RegistrationScreen() {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [firstName, setFirstName] = useState('');
  const [surname, setSurname] = useState('');
  const [mobile, setMobile] = useState('');
  const [password, setPassword] = useState('');
  const [rePassword, setRePassword] = useState('');

  const [usernameError, setUsernameError] = useState(null);
  const [emailError, setEmailError] = useState(null);
  const [firstNameError, setFirstNameError] = useState(null);
  const [surnameError, setSurnameError] = useState(null);
  const [mobileError, setMobileError] = useState(null);
  const [passwordError, setPasswordError] = useState(null);
  const [rePasswordError, setRePasswordError] = useState(null);

  const [isSubmitting, setIsSubmitting] = useState(false);

  const dispatch = useDispatch();

  const user = useSelector((state) => state.user);

  const loginUser = () => {
    const url = 'https://192.168.1.114:8443/home-surf/users/login';
    fetch(url, {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        emailOrUsername: username,
        password: password,
      }),
    })
      .then((response) => response.json())
      .then((json) => {
        dispatch(login(json.username, json.id));
      })
      .catch((error) => {
        console.error(error);
      });
  };
  const _validateUsername = () => {
    if (username.trim() === '') {
      setUsernameError('Username is required');
      return;
    }
    const url =
      'https://192.168.1.114:8443/home-surf/users/username-exists/' + username;
    fetch(url)
      .then((response) => response.json())
      .then((usernameExists) => {
        if (usernameExists) {
          setUsernameError('Username already exists');
        } else {
          setUsernameError(null);
        }
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const _validateEmail = () => {
    if (email.trim() === '') {
      setEmailError('Email is required');
      return;
    }

    let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (!re.test(email)) {
      setEmailError('Email address is not valid');
      return;
    }

    const url =
      'https://192.168.1.114:8443/home-surf/users/email-exists/' + email;
    const response = fetch(url)
      .then((response) => response.json())
      .then((emailExists) => {
        if (emailExists) {
          setEmailError('Email already exists');
        } else {
          setEmailError(null);
        }
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const _validateForm = () => {
    _validateUsername();
    _validateEmail();
    if (firstName.trim() === '') {
      setFirstNameError('First name is required');
    }
    if (surname.trim() === '') {
      setSurnameError('Surname is required');
    }
    if (mobile.trim() === '') {
      setMobileError('Mobile is required');
    }
    if (password.trim() === '') {
      setPasswordError('Password is required');
    }
    if (password.trim() !== '' && rePassword.trim() === '') {
      setRePasswordError('Please re-enter your password');
    }
    if (
      password.trim() !== '' &&
      rePassword.trim() !== '' &&
      password !== rePassword
    ) {
      setPasswordError("Passwords don't match");
    }
  };

  const _canSubmitForm = () => {
    return (
      !usernameError ||
      !emailError ||
      !firstNameError ||
      !surnameError ||
      !mobileError ||
      !passwordError ||
      !rePasswordError
    );
  };

  const submitForm = () => {
    _validateForm();
    if (!_canSubmitForm()) {
      return null;
    }

    setIsSubmitting(true);
    const url = 'https://192.168.1.114:8443/home-surf/users/';
    fetch(url, {
      method: 'POST',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        username: username,
        email: email,
        name: firstName,
        surname: surname,
        mobile: mobile,
        password: password,
        roles: [{ roleId: 1 }],
      }),
    })
      .then((response) => response.json())
      .then((json) => {
        setIsSubmitting(false);
        loginUser();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <View style={styles.container}>
      <Input
        value={username}
        placeholder="Username"
        leftIcon={<Icon name="user" size={24} color="grey" />}
        onChangeText={(text) => setUsername(text.replace(/\s/g, ''))}
        errorMessage={usernameError}
      />
      <Input
        value={email}
        placeholder="Email"
        leftIcon={<Icon name="envelope" size={24} color="grey" />}
        onChangeText={(text) => setEmail(text.replace(/\s/g, ''))}
        errorMessage={emailError}
      />
      <Input
        placeholder="First name"
        value={firstName}
        onChangeText={(text) => setFirstName(text)}
        errorMessage={firstNameError}
      />
      <Input
        placeholder="Last name"
        value={surname}
        onChangeText={(text) => setSurname(text)}
        errorMessage={surnameError}
      />
      <Input
        placeholder="Mobile"
        value={mobile}
        onChangeText={(text) => setMobile(text)}
        errorMessage={mobileError}
      />
      <Input
        value={password}
        placeholder="Password"
        leftIcon={<Icon name="lock" size={24} color="grey" />}
        secureTextEntry={true}
        onChangeText={(text) => setPassword(text)}
        errorMessage={passwordError}
      />
      <Input
        value={rePassword}
        placeholder="Repeat password"
        leftIcon={<Icon name="lock" size={24} color="grey" />}
        secureTextEntry={true}
        onChangeText={(text) => setRePassword(text)}
        errorMessage={rePasswordError}
      />
      <Button
        title="Create your account"
        onPress={() => submitForm()}
        loading={isSubmitting}
        color={Colors.darkTeal}
      />
    </View>
  );
}

const mapStateToProps = (state) => {
  const { user } = state;
  return { user };
};
