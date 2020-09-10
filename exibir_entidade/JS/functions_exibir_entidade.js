//Criação da instância do myStorage
myStorage = window.localStorage;
//Limpando todos os dados antigos.
myStorage.clear();
//Variável pra atribuir um ID ao criar uma pessoa
var id = 0;
var corpo_tabela = document.querySelector("tbody[id='tbodyP'");
var template = document.querySelector("#template1");
//Primeira linha do localstorage é um header contendo a sequência de parâmetros
myStorage.setItem("Linha 1 - Header", "ID do Usuário, Nome do Usuário,Título do Projeto, Instituição")

//Entidade das pessoas
function Pessoa(nome, instituicao, projetos, curso) {
    this.nome = nome;
    this.id = "" + id++;
    this.instituicao = instituicao;
    this.projetos = projetos;
    this.curso = curso;

};
//Entidade dos projeto
function Projeto(autor, titulo, descricao, palavrasChaves, tipo) {
    this.titulo = titulo;
    this.autor = autor;
    this.descricao = descricao;
    this.palavrasChaves = palavrasChaves;
    this.tipo = tipo;
}
//Entidade que possui um vetor de pessoas que contém todas as pessoas que possuem projetos.
function entidades(pessoas) {
    this.pessoas = pessoas;
    this.criar_tabela_template = function () {
        var info = [];
        for (var i = 0; i < this.pessoas.length; i++) {
            for (var j = 0; j < this.pessoas[i].projetos.length; j++) {
                lista_td = template.content.querySelectorAll("td");
                lista_td[0].textContent = this.pessoas[i].projetos[j].tipo
                lista_td[1].textContent = this.pessoas[i].projetos[j].autor
                lista_td[2].textContent = this.pessoas[i].instituicao
                var nova_linha = document.importNode(template.content, true)
                corpo_tabela.appendChild(nova_linha);
                //console.log("Na posição " + i + " " + this.projetos[i].titulo)
                info = [this.pessoas[i].id, this.pessoas[i].nome, this.pessoas[i].instituicao,this.pessoas[i].projetos[j].titulo]
                myStorage.setItem("Título do Projeto -> " + this.pessoas[i].projetos[j].titulo, JSON.stringify(info))
            }
        }
    }
}
//Mostrando entidades de forma dinâmica
function mostrarEntidades() {
    var pj1 = new Projeto("Ana Larissa de Queiroz França", "Estudo a cerca da Periodontite","Efeito de segurança de 6,7-dimetoxi-3-nitrocumarina na Periodontite", "saúde,periodontite","Conclusão de Curso")
    var pj2 = new Projeto("Maria Clarice Sousa", "Estágio no NPDS", "Trabalho sobre o NPDS","NPDS, desenvolvendo","Descrição de estágio - NPDS")
    var pj3 = new Projeto("Maria Clarice Sousa", "PID - Matemática", "Trabalho sobre o PID de matemática 1","PID, aulas, matemática","Descrição de bolsa - PID")

    var projetos1 = [pj1];
    var projetos2 = [pj2,pj3];

    var p1 = new Pessoa("Ana Larissa de Queiroz França", "Universidade Federal do Ceará (UFC)", projetos1, "Ciências Biológicas")
    var p2 = new Pessoa("Maria Clarice Sousa", "Instituto Federal do Ceará (IFCE)", projetos2, "Matemática")

    var pessoas = [p1, p2]
    var ent = new entidades(pessoas);
    ent.criar_tabela_template();
}
