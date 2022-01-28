function focused() {
    // let divElement = document.getElementsByTagName('div')[0];
    //
    // divElement.addEventListener('focus' , (e) => {
    //     console.log(e.target)
    //     e.target.parentNode.className = 'focused';
    // });
    //
    // divElement.addEventListener('blur' , (e) => {
    //     console.log(e.target)
    //     e.target.parentNode.className = '';
    // });
    let inputElements = document.getElementsByTagName('input');

    for (const field of inputElements) {
        field.addEventListener('focus' , onFocus)
        field.addEventListener('blur' , onBlur)
    }

    function onFocus(ev){
        console.log(ev.target)
        ev.target.parentNode.className = 'focused';
    }

    function onBlur(ev){
        console.log(ev.currentTarget)
        ev.target.parentNode.className = '';
    }
}