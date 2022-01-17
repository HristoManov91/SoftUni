
const {expect} = require('chai');
const {mathEnforcer} = require('./Exercise-04');

describe('Test mathEnforcer', () => {
    describe('addFive' , () => {
        it('Test with invalid input return undefined' , () => {
            expect(mathEnforcer.addFive('0')).to.be.undefined;
            expect(mathEnforcer.addFive(null)).to.be.undefined;
            expect((mathEnforcer.addFive({}))).to.be.undefined;
            expect((mathEnforcer.addFive({}))).to.be.undefined;
        });
        it('Test with valid input and return input add five', () => {
            expect(mathEnforcer.addFive(-5)).to.be.equal(0);
            expect(mathEnforcer.addFive(5)).to.be.equal(10);
            expect(mathEnforcer.addFive(5.52)).to.be.closeTo(10.52 , 0.01);
        });
    });
    describe('subtractTen' , () => {
        it('Test with invalid input and return undefined' , () => {
            expect(mathEnforcer.subtractTen('0')).to.be.undefined;
            expect(mathEnforcer.subtractTen(null)).to.be.undefined;
            expect((mathEnforcer.subtractTen({}))).to.be.undefined;
            expect((mathEnforcer.subtractTen({}))).to.be.undefined;
        });
        it('Test with valid input and return input subtract ten', () => {
            expect(mathEnforcer.subtractTen(-5)).to.be.equal(-15);
            expect(mathEnforcer.subtractTen(15)).to.be.equal(5);
            expect(mathEnforcer.subtractTen(35.52)).to.be.closeTo(25.52 , 0.01);
        });
    });
    describe('sum' , () => {
        it('Test with invalid input and return undefined' , () => {
            expect(mathEnforcer.sum('0' , 1)).to.be.undefined;
            expect(mathEnforcer.sum(null , 2)).to.be.undefined;
            expect((mathEnforcer.sum({} , 3))).to.be.undefined;
            expect((mathEnforcer.sum([] , {}))).to.be.undefined;
            expect((mathEnforcer.sum([]))).to.be.undefined;
        });
        it('Test with valid input and return sum', () => {
            expect(mathEnforcer.sum(-5 , 10)).to.be.equal(5);
            expect(mathEnforcer.sum(15 , 0)).to.be.equal(15);
            expect(mathEnforcer.sum(35.52 , 4.48)).to.be.closeTo(40 , 0.01);
        });
    });
})