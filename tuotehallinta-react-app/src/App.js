import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import Oma from "./oma";
import KirjaLista from "./components/KirjaLista";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
          <Oma/>
          <hr/>
          <KirjaLista/>
      </header>
    </div>
  );
}

export default App;
