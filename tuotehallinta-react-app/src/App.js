import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Oma from "./oma";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Tallenna
        </p>
          <Oma/>
      </header>
    </div>
  );
}

export default App;
