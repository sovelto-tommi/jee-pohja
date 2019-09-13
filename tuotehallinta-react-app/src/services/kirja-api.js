
const url = '/api/kirjat';

function haeKirjat() {
    return fetch(url)
        .then(resp=>resp.json());
}

module.exports = {haeKirjat}