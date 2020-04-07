import axios from 'axios';
import { VERSION_URL } from './constants.jsx';
import { receiveBuildProperties } from '../actions/BuildPropertiesActions.jsx';

export const fetchBuildProperties = () => (dispatch) => {
  axios(
    `${VERSION_URL}`
  ).then(
    (buildProperties) => 
      dispatch(receiveBuildProperties(buildProperties))
  );
};