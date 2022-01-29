function encodeAndDecodeMessages() {
    document.getElementById('main').addEventListener('click', (ev) => {
        if (ev.target.tagName !== 'BUTTON') {
            return;
        }

        let decodedMessage = document.getElementsByTagName('textarea')[0];
        let encodeMessage = document.getElementsByTagName('textarea')[1];

        if (ev.target.textContent.includes('Encode')) {
            let text = decodedMessage.value;
            let encode = [];
            for (let i = 0; i < text.length; i++) {
                let newChar = String.fromCharCode(text.charCodeAt(i) + 1);
                encode.push(newChar);
            }
            decodedMessage.value = '';
            encodeMessage.value = encode.join('');
        } else {
            let text = encodeMessage.value;
            let decode = [];
            for (let i = 0; i < text.length; i++) {
                let newChar = String.fromCharCode(text.charCodeAt(i) - 1);
                decode.push(newChar);
            }
            encodeMessage.value = decode.join('');
        }
    })
}