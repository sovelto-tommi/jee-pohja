import React, {Component} from 'react';

class KirjaLomake extends Component {
    constructor(props) {
        super(props);
        this.state = {
            nimi: '',
            hinta: 0.0,
            kieli: 'suomi',
            editio: '1st',
            kirjailijat: [
                {id: 3}
            ],
            kustantaja: {
                id: 1
            },
            "isbn13": "978-0596009205",
            "isbn10": "0596009208"
        }
    }

    arvoMuuttunut = (e) => {
        const uusitila = {};
        uusitila[e.target.name] = e.target.value;
        this.setState(uusitila);
    }

    laheta = () => {
        this.props.vanhemmanFunktio(this.state);
        this.setState({nimi: '', hinta: 0, kieli: ''});
    }

    render() {
        return (
            <form>
                <p><label htmlFor={'lomake.nimi'}>Nimi: </label>
                    <input type='text' id='lomake.nimi' name='nimi' value={this.state.nimi} onChange={this.arvoMuuttunut}/>
                </p>
                <p><label htmlFor={'lomake.hinta'}>Hinta: </label>
                    <input type='number' id='lomake.hinta' name='hinta' value={this.state.hinta} onChange={this.arvoMuuttunut}/>
                </p>
                <p><label htmlFor={'lomake.kieli'}>Kieli: </label>
                    <input type='text' id='lomake.kieli' name='kieli' value={this.state.kieli} onChange={this.arvoMuuttunut}/>
                </p>
                <p>
                    <input type='button' defaultValue='Lähetä' onClick={this.laheta}/>
                </p>
            </form>
        );
    }
}

export default KirjaLomake;