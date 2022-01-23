function solve() {
    return {
        mage(name) {
            return {
                name,
                health: 100,
                mana: 100,
                cast(spellName) {
                    this.mana -= 1;
                    console.log(`${this.name} cast ${spellName}`);
                }
            }
        },
        fighter(name) {
            return {
                name,
                health: 100,
                stamina: 100,
                fight() {
                    this.stamina -= 1;
                    console.log(`${this.name} slashes at the foe!`)
                }
            }
        }
    }
}

let create = solve();
const scorcher = create.mage("Scorcher");
scorcher.cast("fireball")
scorcher.cast("thunder")
scorcher.cast("light")

const scorcher2 = create.fighter("Scorcher 2");
scorcher2.fight()

console.log(scorcher2.stamina);
console.log(scorcher.mana);

function solve() {
    const canCast = (state) => ({
        cast: (speel) => {
            console.log(`${this.name} cast ${speel}`);
            state.mana--;
        }
    })

    const canFight = (state) => ({
        fight: () => {
            console.log(`${state.name} slashes at the foe!`)
            state.stamina--;
        }
    })

    const fighter = (name) => {
        let state = {
            name,
            health: 100,
            stamina: 100
        }

        return Object.assign(state , canFight(state))
    }

    const mage = (name) => {
        let state = {
            name,
            health: 100,
            mana: 100
        }

        return Object.assign(state , canCast(state));
    }

    return {mage: mage , fighter: fighter}
}