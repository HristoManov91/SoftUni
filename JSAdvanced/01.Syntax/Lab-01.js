/**
 * 
 * @param {String} param 
 */
function echo(param){
    console.log(param.length);
    console.log(param);
}

echo('Hello, JavaScript!');
echo('strings are easy');

function echo2(param1 , param2 = 'Hi'){
    console.log(param1 + ' ' + param2)
};

echo2('Gosho' , 'zdrasti');
echo2('gosho');
echo2();