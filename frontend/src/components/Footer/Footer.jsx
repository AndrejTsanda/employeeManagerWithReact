import React from 'react';
import './Footer.css';

const Footer = ({version}) => {
  return (
    <div className="footer">
      Copyright 2020 - All Rights Reserved, v {version}
    </div>
  );
}

export default Footer;