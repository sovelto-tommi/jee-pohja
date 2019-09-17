
const url = '/tuotehallinta-web/api/kirjat';

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

export function poistaKirja(id) {
    const durl = `${url}/${id}`;
    return fetch(durl, {method: 'DELETE'});
}