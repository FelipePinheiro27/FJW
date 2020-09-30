//Instância do localStorage
myStorage = window.localStorage;
//Sempre limpando o localStorage antes de adicionar novas linhas
myStorage.clear();
//Adicionando a primeira linha com a descrição dos campos (HEADER)
myStorage.setItem("Linha 1 - Header", "Nome, Email, Data de nascimento(aaaa-mm-dd),Services,Total por hora($)")
var vm = new Vue({
    el: "#app",
    data: {
        user: {
            nome: "",
            email: null,
            data1: new Date(),
            services: []
        },
        nomeImg: "Imagens/imagem1.png",
        alt: "fastcloud"
    },
    filters: {
        //Retorna a string passada com letra maiscula no começo
        capitalize: function (value) {
            if (!value) return ''
            value = value.toString()
            return value.charAt(0).toUpperCase() + value.slice(1)
        }
    },
    methods: {
        //Adiciona na tabela fazendo todas as verificações dos campos
        addNaTabela() {
            if (this.user.nome != "") {
                if (validarEmail(this.user.email)) {
                    var x = calcularIdade(this.user.data1)
                    if (x >= 18 && x <= 90) {
                        if (verificarBoxes()) {
                            this.makeProject();
                            document.getElementById("registros").innerHTML = "Quantidade de Registros: " + (localStorage.length - 1)
                        }
                        else {
                            alert("Pelo menos um dos serviços deve ser selecionado")
                        }
                    }
                    else {
                        alert("O usuário não possui maioridade ou o campo 'Data de nascimento' não foi preenchido corretamente")
                    }
                }
                else {
                    alert("O seu seu email não é válido")
                }
            }
            else {
                alert("Preencha o campo do nome de usuário")
            }
        },
        //Retorna todos os serviços marcados e seus respectivos valores dentro de um vetor
        returnServicesAndTotal() {
            let textServices = "";
            let total = 0;

            this.user.services.forEach(idService => {
                for (let itemService in arrayServices) {
                    if (arrayServices[itemService].id === idService) {
                        textServices += `${arrayServices[itemService].description}<br>`
                        total += arrayServices[itemService].valueByHour
                    }
                }
            });
            const textTotal = `$ ${total} Por Hora`
            return [textServices, textTotal]
        },
        makeProject() {
            //ESsa parte da função cria a linha com os respectivos componentes
            var corpo_tabela = document.querySelector("tbody[id='tbodyP'")
            var template = document.querySelector("#template1")
            lista_td = template.content.querySelectorAll("td");
            lista_td[0].textContent = this.user.nome;
            lista_td[1].textContent = this.user.email;;
            lista_td[2].textContent = this.user.data1;;

            const [services, total] = this.returnServicesAndTotal()
            x = services
            y = total

            lista_td[3].innerHTML = x;
            lista_td[4].textContent = y;
            var nova_linha = document.importNode(template.content, true)
            corpo_tabela.appendChild(nova_linha);

            //Essa parte da função adiciona elementos no localStorage assim que cria a linha na tabela
            x = x.replace(/<br>/g, "#");
            var array = [this.user.nome, this.user.email, this.user.data1, x, y]
            var aux = JSON.stringify(array);
            var qtdLinhas = document.getElementById("myTable").rows.length;
            myStorage.setItem("Linha " + qtdLinhas.toString(), aux)
        }
    }
});
var arrayServices = [
    {
        id: "cpu-micro",
        description: "Processing - 1 micro - $ 1,00 per hour",
        valueByHour: 1
    },
    {
        id: "cpu-medium",
        description: "Processing - 1 medium - $ 2,00 per hour",
        valueByHour: 2
    },
    {
        id: "cpu-large",
        description: "Processing - 1 large - $ 10,00 per hour",
        valueByHour: 10
    },
    {
        id: "hd-10gb",
        description: "Storage - 10 GB HD - $ 0,50 per hour",
        valueByHour: 0.5
    },
    {
        id: "hd-1tb",
        description: "Storage - 1 TB HD - $ 1,00 per hour",
        valueByHour: 1
    },
    {
        id: "ssd-100gb",
        description: "Storage - 100 GB - $ 5,00 per hour",
        valueByHour: 5
    },
]
//Função para verificar se o email é válido e segue o formato de email
function validarEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
//Usada pra verificar se o user é maior de idade
function calcularIdade(nascimento) {
    hoje = new Date()
    nascimento = parseDate(nascimento)
    if (nascimento < hoje) {
        return Math.floor(Math.ceil(Math.abs(nascimento.getTime() - hoje.getTime()) / (1000 * 3600 * 24)) / 365.25);
    }
    return -1
}
//Transforma uma string numa obejto data(aaaa-mm-dd)
function parseDate(input) {
    var parts = input.match(/(\d+)/g);
    return new Date(parts[0], parts[1] - 1, parts[2]);
}
//Verifica se pelo menos um dos serviços estão marcados para não adicionar linhas sem serviços
function verificarBoxes() {
    var boxes = document.getElementsByClassName('checkbox');
    for (var i = 0; i < boxes.length; i++) {
        if (boxes[i].checked) {
            return true
        }
    }
    return false
}
