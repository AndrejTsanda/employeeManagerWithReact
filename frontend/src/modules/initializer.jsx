import { fetchBuildProperties } from '../modules/APIRequests.jsx';
import store from '../store/index.jsx';

export default () => {
  store.dispatch(fetchBuildProperties());
};