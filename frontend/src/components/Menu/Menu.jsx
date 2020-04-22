import React from 'react';
import { AppBar, Toolbar, Button, IconButton, Typography } from '@material-ui/core';
import MenuIcon from '@material-ui/icons/Menu';
import './Menu.css';

class Menu extends React.Component {
  
  generateMenuItems() {
    let menu = [
      {title: 'HOME', url: 'home'},
      {title: 'HELP', url: 'help'}
    ]
    return menu.map(value => <Link menuItem={value} />);
  }

  render() {
    return(
      <div>
        <AppBar position="static">
          <Toolbar>
            <IconButton edge="start" className="menuBotton" color="inherit" aria-label="menu">
              <MenuIcon />
            </IconButton>
            <Typography variant="h6" className="title">
              <div className="menu">
                {this.generateMenuItems()}
              </div>
            </Typography>
            <Button color="inherit">Logout</Button>
          </Toolbar>
        </AppBar>
      </div>
    )
  }
}

class Link extends React.Component {
  render() {
    const url = "/" + this.props.menuItem.url;
    return(
      <div>
        <a href={url}><Button color="inherit">{this.props.menuItem.title}</Button></a>
      </div>
    );
  }
}

export default Menu;