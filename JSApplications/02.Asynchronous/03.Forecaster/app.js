function attachEvents() {
    const location = document.getElementById('location').value;
    let submitBtn = document.getElementById('submit');
    submitBtn.addEventListener('click' , async () => getForecast(location));
}

attachEvents();

async function getForecast(name) {
    const code = await getLocationCode(name);

    const [currentWhether, upcomingWhether] = await Promise.all([
        getCurrent(code),
        getUpcoming(code)
    ])

    return {currentWhether, upcomingWhether};
}

async function getLocationCode(name) {
    const url = 'http://localhost:3030/jsonstore/forecaster/locations';

    const response = await fetch(url);
    const data = await response.json();

    const location = data.find(l => l.name === name);

    return location.code;
}

async function getCurrent(code) {
    const url = 'http://localhost:3030/jsonstore/forecaster/today/' + code;

    const response = await fetch(url);
    const data = await response.json();

    return data;
}

async function getUpcoming(code) {
    const url = 'http://localhost:3030/jsonstore/forecaster/upcoming/' + code;

    const response = await fetch(url);
    const data = await response.json();

    return data;
}