import React from 'react';
import { Switch, Route } from 'react-router-dom';
import LoginForm from '../components/Login/Login.jsx';

const Router = () => (
  <main>
    <Switch>
      <Route exact path="/" component={() => <h1>Home page</h1>} />
      <Route path="/login" component={LoginForm} />
    </Switch>
  </main>
);

export default Router;