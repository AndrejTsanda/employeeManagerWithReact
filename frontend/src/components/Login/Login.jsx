import React from 'react';
import { Button, TextField, InputAdornment, IconButton } from '@material-ui/core';
import { Visibility, VisibilityOff} from '@material-ui/icons';
import { MIN_LENGTH_PASSWORD } from '../../modules/constants.jsx';
import './Login.css';

class LoginForm extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      username: '',
      password: '',
      loginError: '',
      passwordError: '',
      showPassword: false,
    };
  }

  validationError(fieldName) {
    if(fieldName === 'username') {
      this.state.username.length === 0 ? this.setState({
        loginError: 'Login cannot be empty.'
      }) : this.setState({
        loginError: ''
      });
    }
    if(fieldName === 'password') {
      this.state.password.length < `${MIN_LENGTH_PASSWORD}` ? this.setState({
        passwordError: `Password must be more than ${MIN_LENGTH_PASSWORD} characters.`
      }) : this.setState({
        passwordError: ''
      }); 
    }
  }

  handleChange(event, fieldName) {
    const { state } = this;
    state[fieldName] = event.target.value;
    this.setState(state);
  };

  handleBlur(fieldName) {
    this.validationError(fieldName);
  };

  handleClickShowPassword() {
    this.setState({ 
      showPassword: !this.state.showPassword 
    })
  }

  isValidate(username, password) {
    return {
      username: username.length === 0,
      password: password.length < `${MIN_LENGTH_PASSWORD}`
    };
  }
  
  render() {
    const errors = this.isValidate(this.state.username, this.state.password);
    const isDisabled = Object.keys(errors).some(x => errors[x]);
    
    return(
      <div className="login_form">
        <TextField className="input_text"
          label="Login"
          value={
            this.state.username
          }
          onChange={
            (event) => this.handleChange(event, 'username')
          }
          onBlur={
            () => this.handleBlur('username')
          }
          helperText={
            this.state.loginError
          }
          type="text"
        />

        <TextField className="input_text"
          label="Password"
          value={
            this.state.password
          }
          onChange={
            (event) => this.handleChange(event, 'password')
          }
          onBlur={
            () => this.handleBlur('password')
          }
          helperText={
            this.state.passwordError
          }
          type={ this.state.showPassword ? "text" : "password" }
          InputProps = {{
            endAdornment: (
              <InputAdornment position="end">
                <IconButton className="button_visibility"
                  aria-label="toggle password visibility"
                  onClick={
                    () => this.handleClickShowPassword()
                  }>
                  { this.state.showPassword ? <Visibility /> : <VisibilityOff /> }
                </IconButton>
              </InputAdornment>
            )
          }}
        />
        <Button className="button_login"
          variant="outlined"
          disabled={ isDisabled }>
          Login
        </Button>
      </div>
    );
  }
}

export default LoginForm;