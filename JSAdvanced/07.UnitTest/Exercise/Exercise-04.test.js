const {mathEnforcer} = require('./Exercise-04');
const {expect} = require('chai');

describe('Test mathEnforcer functions', () => {
    describe('Test addFive functions', () => {
        it('Test with valid input', () => {
            expect(mathEnforcer.addFive(10)).to.be.equal(15);
            expect(mathEnforcer.addFive(-5)).to.be.equal(0);
            expect(mathEnforcer.addFive(2.22)).to.be.closeTo(7.22 , 0.01);
            expect(mathEnforcer.addFive(-22.22)).to.be.closeTo(-17.22 , 0.01);
        });
        it('should return undefined when param is not a number', () => {
            expect(mathEnforcer.addFive('5')).to.be.undefined;
        })
    });
    describe('Test subtractTen function' , () => {
        it('Test with valid input', () => {
            expect(mathEnforcer.subtractTen(20)).to.be.equal(10);
            expect(mathEnforcer.subtractTen(-20)).to.be.equal(-30);
            expect(mathEnforcer.subtractTen(11.11)).to.be.closeTo(1.11 , 0.01);
            expect(mathEnforcer.subtractTen(-21.11)).to.be.closeTo(-31.11 , 0.01);
        });
        it('should return undefined when param is not a number', () => {
            expect(mathEnforcer.subtractTen('55')).to.be.undefined;
        })
    });
    describe('Test sum function', () => {
        it('Test with valid input', () => {
            expect(mathEnforcer.sum(5 , 10)).to.be.equal(15);
            expect(mathEnforcer.sum(-5 , 10)).to.be.equal(5);
            expect(mathEnforcer.sum(5.55 , 10.10)).to.be.closeTo(15.65 , 0.01);
            expect(mathEnforcer.sum(-5.55 , 10)).to.be.closeTo(4.45 , 0.01);
        });
        it('should return undefined when any from params is not a number', () => {
            expect(mathEnforcer.sum('55' , 5)).to.be.undefined;
            expect(mathEnforcer.sum(55 , '5')).to.be.undefined;
        })
    });
});