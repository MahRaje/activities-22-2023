//import logo from './logo.svg';
import './App.css';
import React from 'react';
import Registration from './components/Registration';
import Login from './components/Login';


function App() {
  return (
    <div className="App">
      <Registration />
      <hr />
      <Login />
    </div>
  );
}

export default App;
