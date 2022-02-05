const {isOddOrEven} = require('./Exercise-02');
const {expect} = require('chai');

describe('Test isOddOrEven function', () => {
    it('Test with valid input', () => {
        expect(isOddOrEven('hello')).to.be.equal('odd');
        expect(isOddOrEven('hi')).to.be.equal('even');
    })
    it('Test with invalid input return undefined', () => {
        expect(isOddOrEven({})).to.be.undefined;
    })
})