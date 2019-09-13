import React, {Component} from 'react';

class Oma extends Component {
    render() {
        let muttuja = false;
        let jsx;
        if (muttuja)
            jsx = <p>Oma komponentti</p>;
        else
            jsx = <p>Toinen komponentti</p>;
        return (
            <div>
                <div>{jsx}</div>
                <p></p>
            </div>
        );
    }
}

export default Oma;