import React from 'react';
import { Switch, Route } from 'react-router-dom';

const Router = () => (
  <main>
    <Switch>
      <Route exact path="/" component={() => <h1>Home page</h1>} />
      <Route path="/login" component={() => <h1>Login page</h1>} />
    </Switch>
  </main>
);

export default Router;