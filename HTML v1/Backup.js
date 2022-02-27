async function API(){
    const url = 'https://newsapi.org/v2/everything?q=indra&sortBy=publishedAt&apiKey=ff89690dfaf2424eb197197a3c397583';
    try { //ff89690dfaf2424eb197197a3c397583
            let res = await fetch(url);
            return await res.json();
        } catch (error) {
            console.log(error);
        }

}

async function getMain(){
    let a1 = await API();
    let totalNumber = a1.totalResults;

    let articles = a1.articles;
    let titulo;
    let autor;
    let fecha;
    let desc;
    let url;

    for(const article of articles){
        let title = article.title;
        let content = article.content;
        if(title.includes("Indra") && content.includes("Indra") )
        {
            titulo = article.title;
            autor = article.author;
            fecha = article.publishedAt;
            desc = article.description;
            url = article.url;
            console.log(article);
        }

    }

    document.getElementById("titulo").innerHTML = titulo;
    document.getElementById("autor").innerHTML = autor;
    document.getElementById("fecha").innerHTML = fecha;

    document.getElementById("desc").innerHTML = desc;
    document.getElementById("url").href = url;
    document.getElementById("url").innerHTML = "Link al documento";


    console.log(totalNumber);


}
getMain();