function calculator() {
    let num1InputElement;
    let num2InputElement;
    let resultElement;

    function init(selector1, selector2, resultSelector) {
        num1InputElement = document.querySelector(selector1);
        num2InputElement = document.querySelector(selector2);
        resultElement = document.querySelector(resultSelector);
    };

    function add() {
        resultElement.value = Number(num1InputElement.value) + Number(num2InputElement.value);
    };

    function subtract() {
        resultElement.value = Number(num1InputElement.value) - Number(num2InputElement.value);
    };

    return {
        init,
        add,
        subtract
    }
}

const calculate = calculator();
calculate.init('#num1', '#num2', '#result');






