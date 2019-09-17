import React from 'react';
import logo from './logo.svg';
import './App.css';
import Oma from "./oma";
import KirjaKomponentti from "./components/KirjaKomponentti";

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <Oma/>
            </header>
            <hr/>
            <KirjaKomponentti/>
        </div>
    );
}

export default App;
