//Criação da instância do myStorage
myStorage = window.localStorage;
//Limpando todos os dados antigos.
myStorage.clear();
//Variável pra atribuir um ID ao criar uma pessoa
var id = 0;
var corpo_tabela = document.querySelector("tbody[id='tbodyP'");
var template = document.querySelector("#template1");
//Primeira linha do localstorage é um header contendo a sequência de parâmetros
myStorage.setItem("Linha 1 - Header", "ID do Usuário, Nome do Usuário, ID do Usuário, Instituição")

//Entidade das pessoas
function Pessoa(nome, instituicao, projetos) {
    this.nome = nome;
    this.id = "" + id++;
    this.instituicao = instituicao;
    this.projetos = projetos;

};
//Entidade dos projeto
function Projeto(autor, titulo, descricao) {
    this.titulo = titulo;
    this.autor = autor;
    this.descricao = descricao;
}
//Entidade que possui um vetor de pessoas que contém todas as pessoas que possuem projetos.
function entidades(pessoas) {
    this.pessoas = pessoas;
    this.criar_tabela_template = function () {
        var info = [];
        for (var i = 0; i < this.pessoas.length; i++) {
            for (var j = 0; j < this.pessoas[i].projetos.length; j++) {
                lista_td = template.content.querySelectorAll("td");
                lista_td[0].textContent = this.pessoas[i].nome
                lista_td[1].textContent = this.pessoas[i].projetos[j].titulo
                lista_td[2].textContent = this.pessoas[i].instituicao
                var nova_linha = document.importNode(template.content, true)
                corpo_tabela.appendChild(nova_linha);
                //console.log("Na posição " + i + " " + this.projetos[i].titulo)
                info = [this.pessoas[i].id, this.pessoas[i].nome, this.pessoas[i].instituicao]
                myStorage.setItem("Título do Projeto -> " + this.pessoas[i].projetos[j].titulo, JSON.stringify(info))
            }
        }
    }
}
//Mostrando entidades de forma dinâmica
function mostrarEntidades() {
    var pj1 = new Projeto("Almada", "NPDS", "Trabalho sobre o NPDS")
    var pj2 = new Projeto("Walysson", "BIA", "Trabalho sobre o BIA")
    var pj3 = new Projeto("Walysson", "WEB", "Trabalho sobre o WEB")
    var pj4 = new Projeto("Maria", "PID", "Trabalho sobre o PID")

    var projetos1 = [pj1];
    var projetos2 = [pj4];
    var projetosW = [pj2, pj3];

    var p1 = new Pessoa("Almada", "UFC", projetos1)
    var p2 = new Pessoa("Walysson", "UECE", projetosW)
    var p3 = new Pessoa("Maria", "IFCE", projetos2)

    var pessoas = [p1, p2, p3]
    var ent = new entidades(pessoas);
    ent.criar_tabela_template();
}
