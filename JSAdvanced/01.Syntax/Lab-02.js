function strlen(word1, word2, word3) {
    let totalLength = word1.length + word2.length + word3.length;
    let averageLength = Math.floor(totalLength / 3);

    console.log(totalLength);
    console.log(averageLength);
}

strlen('chocolate', 'ice cream', 'cake');
strlen('pasta', '5', '22.3');
strlen('pasta', 5, '22.3');//error NaN