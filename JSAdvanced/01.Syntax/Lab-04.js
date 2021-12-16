/**
 * 
 * @param {Number} r 
 */
function circleArea(r) {
    if (typeof (r) == 'number') {
        let area = r ** 2 * Math.PI;
        console.log(Math.round(area * 100) / 100);
        console.log(area.toFixed(2));//return to String
    } else {
        console.log(`We can not calculate the circle area, because we receive a ${typeof(r)}.`);
    }
}

circleArea(5);
circleArea('asd')