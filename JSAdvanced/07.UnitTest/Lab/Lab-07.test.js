const {createCalculator} = require('./Lab-07');
const {expect} = require('chai');

describe('Test createCalculator function', () => {
    let calc;

    beforeEach(() => {
        calc = createCalculator();
    })
    describe('Test inner function add' , () => {
        it('Test with valid input', () => {
            calc.add(2);
            expect(calc.get()).to.be.equal(2);
            calc.add('1');
            expect(calc.get()).to.be.equal(3);
        });
    });
    describe('Test inner function subtract' , () => {
        it('Test with valid input', () => {
            calc.subtract(2);
            expect(calc.get()).to.be.equal(-2);
            calc.subtract('1');
            expect(calc.get()).to.be.equal(-3);
        })
    });
    describe('Test inner function get' , () => {
        it('Should return 0 on get()' , () => {
            let value = calc.get();
            expect(value).to.be.equal(0);
        })
    });
})