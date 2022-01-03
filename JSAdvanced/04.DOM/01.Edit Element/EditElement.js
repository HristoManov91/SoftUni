function editElement(element , matcher , replacer) {
    const text = element.textContent;
    element.textContent = text.replaceAll(matcher, replacer);
}