class Movie {

    constructor(movieName, ticketPrice) {
        this.movieName = movieName;
        this.ticketPrice = Number(ticketPrice);
        this.screenings = [];
        this.soldTickets = 0;
        this.totalProfit = 0;
    }

    newScreening(date, hall, description) {
        let screen = {
            date,
            hall,
            description
        }

        let isFree = this.screenings.some(s => s.date === date && s.hall === hall);

        if (!isFree) {
            this.screenings.push(screen);
            return `New screening of ${this.movieName} is added.`;
        } else {
            throw new Error(`Sorry, ${hall} hall is not available on ${date}`)
        }
    }

    endScreening(date, hall, soldTickets) {
        let indexScreen = -1;
        for (const screening of this.screenings) {
            if (screening.hall === hall && screening.date === date) {
                indexScreen = this.screenings.indexOf(screening);
                break
            }
        }

        if (indexScreen !== -1) {
            const currentProfit = this.ticketPrice * soldTickets;
            this.totalProfit += currentProfit;
            this.soldTickets += soldTickets;
            this.screenings.splice(indexScreen, 1);

            return `${this.movieName} movie screening on ${date} in ${hall} hall has ended. Screening profit: ${currentProfit}`;
        } else {
            throw new Error(`Sorry, there is no such screening for ${this.movieName} movie.`)
        }
    }

    toString() {
        let result = `${this.movieName} full information:
Total profit: ${this.totalProfit.toFixed(0)}$
Sold Tickets: ${this.soldTickets}\n`;

        if (this.screenings.length > 0) {
            result += `Remaining film screenings:\n`
            let messages = [];
            this.screenings
                .sort((a, b) => a.hall.localeCompare(b.hall))
                .forEach(e => messages.push(`${e.hall} - ${e.date} - ${e.description}`));

            result += messages.join('\n');
        } else {
            result += 'No more screenings!';
        }

        return result;
    }
}

// let m = new Movie('Wonder Woman 1984', '10.00');
// console.log(m.newScreening('October 2, 2020', 'IMAX 3D', `3D`));
// console.log(m.newScreening('October 3, 2020', 'Main', `regular`));
// console.log(m.newScreening('October 4, 2020', 'IMAX 3D', `3D`));
// console.log(m.endScreening('October 2, 2020', 'IMAX 3D', 150));
// console.log(m.endScreening('October 3, 2020', 'Main', 78));

let m = new Movie('Wonder Woman 1984', '10.00');
console.log(m.newScreening('October 2, 2020', 'IMAX 3D', `3D`));
console.log(m.newScreening('October 3, 2020', 'Main', `regular`));
console.log(m.newScreening('October 4, 2020', 'IMAX 3D', `3D`));
console.log(m.endScreening('October 2, 2020', 'IMAX 3D', 150));
console.log(m.endScreening('October 3, 2020', 'Main', 78));
console.log(m.toString());

m.newScreening('October 4, 2020', '235', `regular`);
m.newScreening('October 5, 2020', 'Main', `regular`);
m.newScreening('October 3, 2020', '235', `regular`);
m.newScreening('October 4, 2020', 'Main', `regular`);
console.log(m.toString());
