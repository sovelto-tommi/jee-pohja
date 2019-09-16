
// const booturl = '/api/kirjat';
const wildflyurl = '/tuotehallinta-web/api/kirjat';
const url = wildflyurl;

export function haeKirjat() {
    return fetch(url)
        .then(resp => {
            return resp.json()
        });
}

export function uusikirja(kirja) {
    return fetch(url, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(kirja)
    })
}

