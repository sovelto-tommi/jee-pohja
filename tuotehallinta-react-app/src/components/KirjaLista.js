import React, {Component} from "react";
import Kirja from './Kirja';
import {haeKirjat} from '../services/kirja-api';

export default class KirjaLista extends Component {
    state = { kirjat: []};
    componentDidMount() {
        haeKirjat().then(kirjat=> {
            this.setState({kirjat: kirjat});
        });
    }
    render() {
        const kirjat = this.state.kirjat.map(kirja => {
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
