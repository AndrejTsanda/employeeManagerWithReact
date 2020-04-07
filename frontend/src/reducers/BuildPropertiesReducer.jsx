import { RECEIVE_BUILD_PROPERTIES } from '../actions/BuildPropertiesActions.jsx';

const buildProperties = (state = {
  buildProperties: {
    data: {
      version: '',
    },
  },
}, action) => {
  switch(action.type) {
    case RECEIVE_BUILD_PROPERTIES:
      return {
        ...state,
        buildProperties:
        action.buildProperties,
      };
    default:
      return state;
  }
};

export default buildProperties;