function sortTickets(array, paramToSort) {

    class Ticket {
        constructor(destination, price, status) {
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }

    let tickets = [];

    for (const arrayElement of array) {
        let tokens = arrayElement.split('|');
        let ticket = new Ticket(tokens[0], Number(tokens[1]), tokens[2]);
        tickets.push(ticket);
    }

    switch (paramToSort) {
        case 'destination':
            tickets.sort((a,b) => a.destination.localeCompare(b.destination));
            break;
        case 'price':
            tickets.sort((a,b) => a.price - b.price);
            break;
        case 'status':
            tickets.sort((a,b) => a.status.localeCompare(b.status));
            break;
    }

    return tickets;

}

console.log(sortTickets(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'destination'
));

console.log(sortTickets(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'status'
));