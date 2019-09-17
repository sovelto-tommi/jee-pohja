import React from 'react';
import {poistaKirja} from "../services/kirja-api";

const Kirja = (props) => {
    const poistaKirja = () => {
        props.poistaKirja(props.kirja.id);
    }
    const {id, nimi, hinta, kirjailijat, kustantaja, isbn10} = props.kirja;
    const kirjailijastr = kirjailijat.map(k => {
        return `${k.etunimi} ${k.sukunimi}`;
    }).join(', ');
    return (
        <tr>
            <td>{id}</td>
            <td>{nimi}</td>
            <td>{hinta} €</td>
            <td>{kustantaja.nimi}</td>
            <td>{isbn10}</td>
            <td>{kirjailijastr}</td>
            <td><button type='button' onClick={poistaKirja}>Poista</button></td>
        </tr>
    );
}

export default Kirja;