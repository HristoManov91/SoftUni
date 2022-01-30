const testNumbers = require('./testNumbers');
const {expect} = require('chai');

describe('Test Numbers' , () => {
    describe('sumNumbers' , () => {
        it('works with valid numbers', () => {
            expect(testNumbers.sumNumbers(1 , 2)).to.be.equal('3.00');
            expect(testNumbers.sumNumbers(-1 , -22)).to.be.equal('-23.00');
            expect(testNumbers.sumNumbers(-1.01 , 2)).to.be.equal('0.99');
            expect(testNumbers.sumNumbers(2.22 , 0)).to.be.equal('2.22');
        });
        it('invalid inputs', () => {
            expect(testNumbers.sumNumbers('1' , 2)).to.be.undefined;
            expect(testNumbers.sumNumbers('1' , '2')).to.be.undefined;
            expect(testNumbers.sumNumbers(1 , '2')).to.be.undefined;
            expect(testNumbers.sumNumbers('str' , 'str')).to.be.undefined;
        })
    });

    describe('numberChecker' , () => {
        it('works with valid inputs', () => {
            expect(testNumbers.numberChecker('1')).to.be.equal('The number is odd!')
            expect(testNumbers.numberChecker('2')).to.be.equal('The number is even!')
            expect(testNumbers.numberChecker(1)).to.be.equal('The number is odd!')
            expect(testNumbers.numberChecker(2)).to.be.equal('The number is even!')
        });
        it('invalid inputs', () => {
            expect(() => testNumbers.numberChecker('str')).to.be.throw();
        })
    });

    describe('averageSumArray' , () => {
        it('works with valid inputs', () => {
            expect(testNumbers.averageSumArray([1,2,3])).to.be.equal(2)
            expect(testNumbers.averageSumArray([1,2,3,4])).to.be.equal(2.5)
        })
    })
})

