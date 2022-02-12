async function getInfo() { // make function to 'async' for work 'await'

    const stopId = document.getElementById('stopId').value;
    let stopNameElement = document.getElementById('stopName');
    let timeTableElement = document.getElementById('buses');

    const url = `http://localhost:3030/jsonstore/bus/businfo/${stopId}`;

    try {
        stopNameElement.textContent = 'Loading...';
        timeTableElement.innerHTML = '';

        const res = await fetch(url); //get request return Promise and write 'await' to transfer on data
        if (res.status !== 200) {
            throw new Error('Stop ID not found');
        }
        const data = await res.json(); //to extract data from response we transform

        stopNameElement.textContent = data.name;

        Object.entries(data.buses).forEach((b) => {
            const liElement = document.createElement('li');
            liElement.textContent = `Bus ${b[0]} arrives in ${b[1]} minutes`

            timeTableElement.appendChild(liElement);
        })

    } catch (error) {
        stopNameElement.textContent = 'Error';
    }
}