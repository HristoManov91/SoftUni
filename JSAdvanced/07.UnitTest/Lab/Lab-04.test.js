const {sum} = require('./Lab-04');
const {expect} = require('chai');

describe('Test function sum' , () => {
    it('Test with valid input', () => {
        expect(sum(['1' , '2' , '3'])).to.be.equal(6);
        expect(sum(['1' , 5 , '3'])).to.be.equal(9);
    })
    it('Test with invalid input', () => {
        expect(sum(["abv" , 1])).to.be.NaN
    })
})