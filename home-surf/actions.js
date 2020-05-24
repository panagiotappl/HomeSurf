export const USER_LOGIN = 'USER_LOGIN';
export const USER_LOGOUT = 'USER_LOGOUT';

export function login(username, id) {
  return {
    type: USER_LOGIN,
    payload: { username: username, userId: id },
  };
}
