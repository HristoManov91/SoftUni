class Hex {
    constructor(value) {
        this.value = value;
    }

    valueOf() {
        return this.value;
    };

    toString() {
        return '0x' + (this.value.toString(16)).toUpperCase();
    };

    plus(number) {
        if (typeof number === 'string') {
            number = this.parse(number);
        }
        return new Hex(this.value + number);

    };

    minus(number) {
        if (typeof number === 'string') {
            number = this.parse(number);
        }
        return new Hex(this.value - number);
    };

    parse(strings) {
        return parseInt(strings.slice(2), 16);
    };
}

let FF = new Hex(255);
console.log(FF.valueOf())
console.log(FF.toString());
console.log(FF.parse('OxFF'))
console.log(FF.toString());
FF.valueOf() + 1 == 256;
let a = new Hex(200);
let b = new Hex(5);
console.log(a.plus(b).toString());
console.log(a.plus(b).toString()==='0xF');
console.log(FF.parse('AAA'));
