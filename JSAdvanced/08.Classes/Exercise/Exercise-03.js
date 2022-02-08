function solve(array, sorted) {

    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let result = [];

    for (const arrayElement of array) {
        let [destination, price, status] = arrayElement.split('|');

        let ticket = new Ticket(destination, Number(price), status);

        result.push(ticket);
    }

    if (sorted === 'price'){
        return result.sort((t1, t2) => t1.price - t2.price);
    } else {
        return result.sort((t1, t2) => t1[sorted].localeCompare(t2[sorted]))
    }
}



console.log(solve(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'destination'
));