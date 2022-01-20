class Stringer {
    constructor(innerString, innerLength) {
        this._innerString = innerString;
        this._innerLength = innerLength;
    }

    increase(length) {
        if (this._innerLength + length <= 0) {
            this._innerLength = 0;
        } else {
            this._innerLength += length
        }
    }

    decrease(length) {
        if (this._innerLength - length <= 0) {
            this._innerLength = 0;
        } else {
            this._innerLength -= length;
        }
    }

    toString() {
        if (this._innerLength === 0) {
            return '...';
        } else if (this._innerLength < this._innerString.length) {
            return this._innerString.substring(0, this._innerLength) + '...';
        } else {
            return this._innerString;
        }
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(4);
console.log(test.toString()); // Test
