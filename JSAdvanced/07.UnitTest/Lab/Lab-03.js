function printDeckOfCards(cards) {
    let results = [];

    for (const item of cards) {
        let card;
        if (item.length == 2){
            card = createCard(item.charAt(0), item.charAt(1));
        } else {
            card = createCard(item.slice(0 , 2) , item.charAt(2))
        }
        if (card === 'Error') {
            console.log(`Invalid card: ${item}`)
            return;
        }
        results.push(card);
    }

    console.log(results.join(' '));

    function createCard(face , suit) {
        const faces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A']
        const suits = {
            S: '\u2660',
            H: '\u2665',
            D: '\u2666',
            C: '\u2663'
        }

        if (!faces.includes(face) || !suits[suit]) {
            return 'Error';
        }

        let card = {
            face,
            suit,
            toString() {
                return this.face + suits[this.suit];
            }
        }
        return card.toString();
    }
}

printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);
