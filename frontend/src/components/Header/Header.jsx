import React from 'react';
import logo from '../../logo.svg'
import "./Header.css"

const Header = () => {
  return (
    <div className="header">
      <img src={logo} alt="logo"/>
      Header
    </div>
  );
}

export default Header;