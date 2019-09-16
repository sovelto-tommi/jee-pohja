import React, {Component} from "react";
import Kirja from './Kirja';
import {haeKirjat, uusikirja} from '../services/kirja-api';
import KirjaLomake from "./KirjaLomake";
import { w3cwebsocket as W3CWebSocket } from "websocket";

export default class KirjaKomponentti extends Component {
    constructor(props) {
        super(props);
        this.state = { kirjat: []};
    }
    componentDidMount() {
        this.haeKirjat();
        const wsclient = new W3CWebSocket('ws://localhost:8080/tuotehallinta-web/kirjaws');
        wsclient.onopen = () => {
            console.log('WebSocket-yhteys saatu');
        };
        wsclient.onmessage = (message) => {
            console.log(message);
            this.haeKirjat();
        };
    }

    haeKirjat = () => {
        haeKirjat().then(kirjat=> {
            this.setState({kirjat: kirjat});
        });
    }
    uusiKirja =  (kirja) => {
        uusikirja(kirja).then((vastaus)=>{
            this.haeKirjat();
        })
    }
    render() {
        return (
            <div>
                <KirjaLista kirjat={this.state.kirjat}/>
                <hr/>
                <KirjaLomake vanhemmanFunktio={this.uusiKirja}/>
            </div>
        )
    }
}

class KirjaLista extends Component {
    render() {
        const kirjat = this.props.kirjat.map(kirja => {
            return <Kirja kirja={kirja} key={kirja.id}/>;
        })
        return (
            <div className='KirjaLista'>
                <table>
                    <tbody>
                    {kirjat}
                    </tbody>
                </table>
            </div>
        )
    }

}
