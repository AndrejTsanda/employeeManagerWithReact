import { connect } from 'react-redux';
import Footer from '../components/Footer/Footer.jsx';

const mapStateToProps = (state) => {
  const { buildProperties } = state;
  return {
    version: buildProperties.buildProperties.data.version
  };
};

const FooterContainer = connect(
  mapStateToProps,
)(Footer);

export default FooterContainer;