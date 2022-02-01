function getArticleGenerator(articles) {

    let contentElement = document.getElementById('content');
    let array = Array.from(articles);

    return () => {
        if (array.length > 0) {
            let articleElement = document.createElement('article');
            articleElement.textContent = array.shift();
            contentElement.appendChild(articleElement);
        }
    }
}
