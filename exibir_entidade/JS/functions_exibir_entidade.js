var corpo_tabela = document.querySelector("tbody[id='tbodyP'")
var template = document.querySelector("#template1")
myStorage = window.localStorage;
myStorage.clear()
myStorage.setItem("Linha 1 - Header", "Nome do Usuário, ID do Usuário, Instituição, Projetos")

function Pessoa(nome, instituicao, projetos) {
    this.nome = nome;
    this.id = ""+(localStorage.length - 1)
    this.instituicao = instituicao;
    this.projetos = projetos;
    this.criar_tabela_template = function () {
        var titulos = "#";
        for(var i = 0;i < this.projetos.length;i++){
            lista_td = template.content.querySelectorAll("td");
            lista_td[0].textContent = this.projetos[i].autor;
            lista_td[1].textContent = this.projetos[i].titulo;
            lista_td[2].textContent = this.instituicao;
            lista_td[3].textContent.innerHTML = "teste"
            var nova_linha = document.importNode(template.content, true)
            corpo_tabela.appendChild(nova_linha);
            console.log("Na posição " + i + " " + this.projetos[i].titulo)
            titulos += this.projetos[i].titulo + "#"
        }
        console.log(titulos)
        var info = [this.nome, this.id,this.instituicao,titulos]
        myStorage.setItem("ID do Usuário -> " + this.id, JSON.stringify(info))
    }
};
function Projeto(autor, titulo, descricao) {
    this.titulo = titulo;
    this.autor = autor;
    this.descricao = descricao;
}
function mostrarEntidades() {
    var pj1 = new Projeto("Almada", "NPDS", "Trabalho sobre o NPDS")
    var pj2 = new Projeto("Walysson", "BIA", "Trabalho sobre o BIA")
    var projetos = [pj1, pj2];
    var p1 = new Pessoa("Almada", "UFC", projetos)
    p1.criar_tabela_template();
}
