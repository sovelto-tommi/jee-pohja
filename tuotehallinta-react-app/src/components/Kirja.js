import React from 'react';

const Kirja = (props) => {
    const {nimi, hinta, kirjailijat} = props.kirja;
    return (
        <tr>
            <td>{nimi}</td>
            <td>{hinta}</td>
            <td>{kirjailijat[0].etunimi}</td>
        </tr>
    );
}

export default Kirja;