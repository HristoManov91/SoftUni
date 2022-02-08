const {flowerShop} = require('./flowerShop');
const {expect} = require('chai');

describe('Tests flowerShop' , () => {

    describe('Tests calcPriceOfFlowers function' , () => {
        it('Tests with valid inputs', () => {
            expect(flowerShop.calcPriceOfFlowers('rose' , 10 , 5)).to.be.equal(`You need $50.00 to buy rose!`)
        });
        it('should be return error Invalid input!' , () => {
           expect(() => flowerShop.calcPriceOfFlowers(1,1,1.1)).to.throw('Invalid input!');
        })
    });
    describe('Tests checkFlowersAvailable function' , () => {
        it('Test with valid inputs', () => {
            expect(flowerShop.checkFlowersAvailable('rose' , ['rose' , 'liulak'])).to.be.equal(`The rose are available!`)
        })
        it('Test with invalid inputs', () => {
            expect(flowerShop.checkFlowersAvailable('rose' , [])).to.be.equal(`The rose are sold! You need to purchase more!`)
        })
    });
    describe('Tests sellFlowers function' , () => {
        it('Test with valid inputs', () => {
            expect(flowerShop.sellFlowers(["Rose", "Lily", "Orchid"] , 2)).to.be.equal('Rose / Lily')
        })
    });
})