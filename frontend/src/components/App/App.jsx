import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from '../../store/index.jsx';
import Routes from '../../routes/Router.jsx';
import Header from '../Header/Header.jsx';
import Footer from '../../containers/FooterContainer.jsx';
import './App.css';

function App() {
  return (
    <div className="App">
      <Provider store = {store}>
        <Header />
        <BrowserRouter>
          <Routes />
        </BrowserRouter>
        <Footer />
      </Provider>
    </div>
  );
}

export default App;