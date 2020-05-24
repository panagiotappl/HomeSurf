export const isUserLoggedIn = state => !!state.user.username && !!state.user.userId;
export const getUsername = state => state.user.username;