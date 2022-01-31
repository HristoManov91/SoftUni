function solution() {
    let result = '';

    return {
        append,
        removeStart,
        removeEnd,
        print
    }

    function append(string){
        result += string;
    }

    function removeStart(count){
        result = result.slice(count)
    }

    function removeEnd(count){
        result = result.slice(0 , -count)
    }

    function print() {
        console.log(result);
    }
}

let firstZeroTest = solution();

firstZeroTest.append('hello');
firstZeroTest.append('again');
firstZeroTest.removeStart(3);
firstZeroTest.removeEnd(4);
firstZeroTest.print();
