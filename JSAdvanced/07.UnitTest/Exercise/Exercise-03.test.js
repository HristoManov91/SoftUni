const {lookupChar} = require('./Exercise-03');
const {expect} = require('chai');

describe('Test lookupChar function', () => {
    it('Test with valid input', () => {
       expect(lookupChar('hello' , 0)).to.be.equal('h');
       expect(lookupChar('hello' , 4)).to.be.equal('o');
    });
    it('Test with first param not a string return undefined', () => {
        expect(lookupChar([] , 1)).to.be.undefined;
    });
    it('Test with second param not a number return undefined', () => {
        expect(lookupChar('hello' , {})).to.be.undefined;
    })
    it('Test with invalid index return Incorrect index', () => {
        expect(lookupChar('hello' , -1)).to.be.equal('Incorrect index');
        expect(lookupChar('hello' , 10)).to.be.equal('Incorrect index');
        expect(lookupChar('hello' , 5)).to.be.equal('Incorrect index');
        expect(lookupChar('hello' , 2.22)).to.be.undefined;
    })
})