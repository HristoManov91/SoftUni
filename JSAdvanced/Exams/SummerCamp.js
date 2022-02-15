class SummerCamp {

    constructor(organizer, location) {
        this.organizer = organizer;
        this.location = location;
        this.priceForCamp = {
            child: 150,
            student: 300,
            collegian: 500
        };
        this.listOfParticipants = [];
    };

    registerParticipant(name, condition, money) {
        if (!this.priceForCamp[condition]) {
            throw new Error("Unsuccessful registration at the camp.");
        }

        if (this.listOfParticipants.filter(p => p.name === name).length) {
            return `The ${name} is already registered at the camp.`;
        }

        if (this.priceForCamp[condition] > money) {
            return `The money is not enough to pay the stay at the camp.`;
        }

        this.listOfParticipants.push({
            name: name,
            condition: condition,
            power: 100,
            wins: 0
        })

        return `The ${name} was successfully registered.`
    };

    unregisterParticipant(name) {
        if (this.listOfParticipants.filter(p => p.name === name).length) {
            for (let i = 0; i < this.listOfParticipants.length; i++) {
                if (this.listOfParticipants[i].name === name) {
                    this.listOfParticipants.splice(i, 1);
                    return `The ${name} removed successfully.`
                }
            }
        } else {
            throw new Error(`The ${name} is not registered in the camp.`);
        }
    }

    timeToPlay(typeOfGame, participant1, participant2) {

        const player1 = this.listOfParticipants.filter(p => p.name === participant1).shift();
        const player2 = this.listOfParticipants.filter(p => p.name === participant2).shift();

        if (typeOfGame === 'WaterBalloonFights') {

            if (!player1 || !player2) {
                throw new Error (`Invalid entered name/s.`);
            }

            if (player1.condition !== player2.condition) {
                throw new Error (`Choose players with equal condition.`);
            }

            if (player1.power > player2.power){
                player1.wins += 1;
                return `The ${player1.name} is winner in the game ${typeOfGame}.`
            } else if (player1.power < player2.power){
                player2.wins += 1;
                return `The ${player2.name} is winner in the game ${typeOfGame}.`
            } else {
                return `There is no winner.`;
            }

        } else if (typeOfGame === 'Battleship') {

            if (!player1) {
                throw new Error('Invalid entered name/s.');
            }

            player1.power += 20;

            return `The ${player1.name} successfully completed the game ${typeOfGame}.`
        }
    }

    toString() {
        let result = [];
        result.push(`${this.organizer} will take ${this.listOfParticipants.length} participants on camping to ${this.location}`);
        this.listOfParticipants
            .sort((p1,p2) => p2.wins - p1.wins)
            .forEach(p => result.push(`${p.name} - ${p.condition} - ${p.power} - ${p.wins}`));

        return result.join('\n');
    }
}

const summerCamp = new SummerCamp("Jane Austen", "Pancharevo Sofia 1137, Bulgaria");
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 200));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.registerParticipant("Leila Wolfe", "childd", 200));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.unregisterParticipant("Petar"));
// console.log(summerCamp.unregisterParticipant("Petar Petarson"));
// console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
// console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
// console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
// console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
// console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));
console.log(summerCamp.registerParticipant("Petar Petarson", "student", 300));
console.log(summerCamp.timeToPlay("Battleship", "Petar Petarson"));
console.log(summerCamp.registerParticipant("Sara Dickinson", "child", 200));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Sara Dickinson"));
console.log(summerCamp.registerParticipant("Dimitur Kostov", "student", 300));
console.log(summerCamp.timeToPlay("WaterBalloonFights", "Petar Petarson", "Dimitur Kostov"));

console.log(summerCamp.toString());


