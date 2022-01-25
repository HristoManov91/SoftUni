function editElement(element , matcher , replacer) {
    const text = element.textContent;
    const match = new RegExp(matcher, 'g');
    element.textContent = text.replace(match, replacer);
}