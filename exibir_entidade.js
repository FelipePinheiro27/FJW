function armazenar() {
    var Usuario = {
        Nome: "Jean",
        Instituicao: "UFC Crateús",
        Projetos: [
            {
                Titulo: "UI DESIGN",
                Autor: "Jean Camelo",
                descricao: "Desenvolver protótipos de interface para web utilizando a ferramenta figma.",
                corpo: "asdasdasdasdasdadadadadadad"
            },
            {
                Titulo: "Aprimoramento de praticas no NPDS",
                Autor: "Maria Angela",
                descricao: "Desenvolver novas praticas para melhoria do desempendo no NPDS",
                corpo: "asdasdasdasdasdadadadadadadasdasdadasasdasdaadsasdadasdasdasda"
            },
            {
                Titulo: "Estudo de UX Desine nos projetos do Campus",
                Autor: "Marcos Paulo",
                descricao: "Observação do usuário ao realizar uma tarefa em um determinado projeto",
                corpo: "asdasdasdasdasdadadadadadadasdasdadasasdasdaadsasdadasdasdasda"
            }
        ]
    };

    var strObj = JSON.stringify(Usuario);

    localStorage.setItem("pessoa", strObj);

    var obj1 = JSON.parse(strObj);

    for(x in obj1){
        document.getElementById("exemplo").innerHTML += x + " : " + obj1[x] + "</br>";
    }

} 