import { combineReducers } from 'redux';

const INITIAL_STATE = {
  user: { username: null, userId: null },
};

const reducer = (state = INITIAL_STATE, action) => {
  switch (action.type) {
    case 'USER_LOGIN':
      return {
        ...state,
        user: {
          username: action.payload.username,
          userId: action.payload.userId,
        },
      };
    case 'USER_LOGOUT':
      return {
        ...state,
        user: { username: null, userId: null },
      };
    default:
      return state;
  }
};

export default reducer;
