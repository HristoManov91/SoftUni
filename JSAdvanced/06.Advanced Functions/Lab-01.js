function solve(area, vol, input) {

    // return JSON.parse(input).map(fig => ({
    //     area: area.apply(fig),
    //     volume: vol.apply(fig)
    // }));

    const figures = JSON.parse(input);
    let result = [];

    for (const figure of figures){
        const figureArea = area.apply(figure);
        const figureVol = vol.apply(figure);

        result.push({
            area: figureArea,
            volume: figureVol
        })
    }

    return result;
}

const data = `[
{"x":"1","y":"2","z":"10"},
{"x":"7","y":"7","z":"10"},
{"x":"5","y":"2","z":"10"}
]`;

console.log(solve(area, vol, data));

const data2 = `[
{"x":"10","y":"-22","z":"10"},
{"x":"47","y":"7","z":"-5"},
{"x":"55","y":"8","z":"0"},
{"x":"100","y":"100","z":"100"},
{"x":"55","y":"80","z":"250"}
]`;

console.log(solve(area, vol, data2));

function area() {
    return Math.abs(this.x * this.y);
}

function vol() {
    return Math.abs(this.x * this.y * this.z);
}

