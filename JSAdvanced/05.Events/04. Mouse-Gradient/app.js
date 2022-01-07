function attachGradientEvents() {
    const gradient = document.getElementById('gradient');
    gradient.addEventListener('mousemove' , onMove);

    const output = document.getElementById('result');

    function onMove(ev){
        const box = ev.target;
        let result = Math.floor(ev.offsetX / box.clientWidth * 100);

        output.textContent = result + '%';
    }
}