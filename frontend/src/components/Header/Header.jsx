import React from 'react';
import logo from '../../logo.svg'
import Menu from '../Menu/Menu.jsx';
import "./Header.css"

const Header = () => {
  return (
    <div className="header">
      <img src={logo} alt="logo"/>
      <Menu />
    </div>
  );
}

export default Header;