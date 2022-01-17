
const {expect} = require('chai');
const {isOddOrEven} = require("./module");

describe('Test isOddOrEven' , () => {
    it('Test with invalid input return undefined', () => {
        expect(isOddOrEven(1)).to.be.undefined;
        expect(isOddOrEven({})).to.be.undefined;
        expect(isOddOrEven([])).to.be.undefined;
    });

    it('Test with string on odd length', () => {
        expect(isOddOrEven('bye')).to.be.equal('odd')
    });

    it('Test with string on even length' , () => {
        expect(isOddOrEven('hi')).to.be.equal('even')
        expect(isOddOrEven('')).to.be.equal('even')
    });
})