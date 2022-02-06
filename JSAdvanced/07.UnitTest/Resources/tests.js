let {Repository} = require("./solution");
const {expect} = require('chai');

describe("Tests Repository class", function () {
    let properties = {
        name: "string",
        age: "number",
        birthday: "object"
    };
    let entity1 = {
        name: "Pesho",
        age: 22,
        birthday: new Date(1998, 0, 7)
    };
    let entity2 = {
        name: "Hristo",
        age: 30,
        birthday: new Date(1991, 7, 26)
    };
    let repo;

    beforeEach( () => {
        repo = new Repository(properties);
    })

    describe("Test count function:",  () => {
        it("should return 0",  () => {
            expect(repo.count).to.be.equal(0);
        });
        it('should return 1 when add entity' , () => {
            repo.add(entity1)
            expect(repo.count).to.be.equal(1);
        })
    });
    describe('Test _validate function:', () => {
        it('Test with invalid property,should throw exception', () => {
            let entity = {
                fullName: "Hristo Manov",
                age: 30,
                birthday: new Date(1991, 7, 26)
            };
            expect(() => repo.add(entity)).to.throw('Property name is missing from the entity!');
            let entity2 = {
                name: "Hristo",
                years: 30,
                birthday: new Date(1991, 7, 26)
            };
            expect(repo.add.bind(repo , entity2)).to.throw('Property age is missing from the entity!');
            let entity3 = {
                name: "Hristo",
                age: 30,
                birth: new Date(1991, 7, 26)
            };
            expect(repo.add.bind(repo , entity3)).to.throw('Property birthday is missing from the entity!');
        });
        it('Test with invalid type,should throw exception' , () => {
            let entity = {
                name: {},
                age: 30,
                birthday: new Date(1991, 7, 26)
            };
            expect(repo.add.bind(repo , entity)).to.throw(`Property name is not of correct type!`);
            let entity2 = {
                name: 'Hristo',
                age: 'ivan',
                birthday: new Date(1991, 7, 26)
            };
            expect(repo.add.bind(repo , entity2)).to.throw(`Property age is not of correct type!`);
            let entity3 = {
                name: 'Hristo',
                age: 30,
                birthday: 10
            };
            expect(repo.add.bind(repo , entity3)).to.throw(`Property birthday is not of correct type!`);
        })
    })
    // TODO: …
});

describe(`testing Repository class`, () => {
    let instance = {}

    beforeEach(() => instance = new Repository({
        name: 'string',
        age: 'number',
        birthday: 'object'
    }))


    describe('testing count prop', () => {
        it(`instance.count -> 0`, () => {
            expect(instance.count).to.eq(0)
        })

    })

    describe('testing .add()', () => {
        it(
            `valid obj passed as input: output -> its id in the collection`,
            () => {
                expect(instance.add({ name: '', age: 1, birthday: {} })).to
                    .eq(0)
            }
        )
    })

    describe(`testing .getId()`, () => {
        it(
            `input ID which is not present in the data collection -> throw`,
            () => {
                expect(() => instance.getId(1)).to
                    .throw('Entity with id: 1 does not exist!')
            }
        )
    })

    describe(`testing .update()`, () => {
        it(
            `input ID which is not present in the data collection -> throw`,
            () => {
                expect(() => instance.update(0, {},)).to
                    .throw(`Entity with id: 0 does not exist!`)
            }
        )
        it(`any property is missing from input object -> throw Error`, () => {
            instance.add({ name: '', age: 0, birthday: {}, })
            expect(() => instance.update(
                0,
                { age: 1, birthday: { date: 0 } }
            )).to.throw
        })
        it(`typeof input[name] !== string -> throw TypeError`, () => {
            instance.add({ name: '', age: 0, birthday: {}, })
            expect(() => instance.update(
                0,
                { name: 0, age: 1, birthday: { date: 0 } }
            )).to.throw(TypeError)
        })
    })

    describe(`testing .del()`, () => {
        it(`deletes index properly`, () => {
            instance.add({ name: '', age: 1, birthday: {} })
            instance.add({ name: '', age: 1, birthday: {} })
            instance.del(1)
            expect(instance.data.has(1)).to.eq(false)
        })
        it(`throws on index which does not exist in the collection`, () => {
            expect(() => instance.del(-1)).to
                .throw(`Entity with id: -1 does not exist!`)
        })
    })
})
