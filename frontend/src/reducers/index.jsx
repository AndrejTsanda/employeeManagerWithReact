import { combineReducers } from 'redux';
import buildProperties from './BuildPropertiesReducer.jsx';

const reducers = combineReducers({
  buildProperties,
});

export default reducers;