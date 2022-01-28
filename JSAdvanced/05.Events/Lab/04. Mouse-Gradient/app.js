function attachGradientEvents() {
    let gradientBoxElement = document.getElementById('gradient');
    gradientBoxElement.addEventListener('mousemove' , onMove);

    let output = document.getElementById('result');

    function onMove (event){
        let box = event.target;

        let result = Math.floor(event.offsetX / box.clientWidth * 100);

        output.textContent = result + '%';
    }
}