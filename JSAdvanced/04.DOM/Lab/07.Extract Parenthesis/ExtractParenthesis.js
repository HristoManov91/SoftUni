function extract(content) {
    let textContent = document.getElementById(content).textContent;

    let result = [];

    const pattern = /\((.+?)\)/g;

    let matches = pattern.exec(textContent);
    while (matches != null){
        result.push(matches)

        matches = pattern.exec(textContent);
    }

    return result.join('; ');
}