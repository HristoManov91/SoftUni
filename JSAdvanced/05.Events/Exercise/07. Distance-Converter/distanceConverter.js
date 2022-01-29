function attachEventsListeners() {
    let ratios = {
        km: 1000,
        m: 1,
        cm: 0.01,
        mm: 0.001,
        mi: 1609.34,
        yrd: 0.9144,
        ft: 0.3048,
        in: 0.0254
    }

    const inputDistanceElement = document.getElementById('inputDistance');
    const inputUnitElement = document.getElementById('inputUnits');
    const outputDistanceElement = document.getElementById('outputDistance');
    const outputUnitElement = document.getElementById('outputUnits');

    document.getElementById('convert').addEventListener('click' , onConvert);

    function onConvert() {
        const distance = convert(Number(inputDistanceElement.value) , inputUnitElement.value);

        console.log(distance[outputUnitElement.value]);
        outputDistanceElement.value = distance[outputUnitElement.value];
    }

    function convert(distance , unit){
        const inMetric = distance * ratios[unit];

        return {
            km: inMetric / ratios.km,
            m: inMetric,
            cm: inMetric / ratios.cm,
            mm: inMetric / ratios.mm,
            mi: inMetric / ratios.mi,
            yrd: inMetric / ratios.yrd,
            ft: inMetric / ratios.ft,
            in: inMetric / ratios.in,
        }
    }


}