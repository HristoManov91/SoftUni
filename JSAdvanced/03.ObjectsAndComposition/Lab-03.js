function cityTaxes(name , population , treasury){
    return {
        name,
        population,
        treasury,
        taxRate: 10,
        collectTaxes(){
            this.treasury += Math.floor(this.population * this.taxRate);
        },
        applyGrowth(percent){
            this.population += Math.floor(this.population * (percent / 100));
        },
        applyRecession(percent){
            this.treasury -= Math.ceil(this.treasury * (percent / 100));
        }
    };
}

const city = cityTaxes('Tortuga', 7000, 15000);
console.log(city);

console.log('-----')

const city2 = cityTaxes('Tortuga', 7000, 15000);
city2.collectTaxes();
console.log(city2.treasury);
city2.applyGrowth(5);
console.log(city2.population);
city2.applyRecession(10)
console.log(city2.treasury)
