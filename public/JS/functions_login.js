var campo_user = document.getElementById("user");
var campo_senha = document.getElementById("senha");
var botao_login = document.getElementById("login");
var botao_cadastro = document.getElementById("cadastro");

myStorage = window.localStorage;

function usuario(user, senha) {
    this.user = user;
    this.senha = senha;
    this.verificaBD = function () {
        if (myStorage.getItem(this.user) != null) {
            if (JSON.stringify(myStorage.getItem(this.user)) == JSON.stringify(this.senha)) {
                location.href = "index.html";
            }
            else{
                alert("Usuário ou senha incorretos")
            }
        }
        else{
            alert("Usuário ou senha incorretos")
        }
        if (this.user.length < 6) {
            alert("O usuário deve conter no mínimo 6 caracteres")
        }
        if (this.senha.length <= 6) {
            alert("A senha deve conter no mínimo 8 caracteres")
        }
    }
}
botao_login.onclick = function redirect(event) {
    event.preventDefault();
    console.log("Testando o campo senha " + campo_senha.value);
    novo_usuario = new usuario(campo_user.value, campo_senha.value);
    novo_usuario.verificaBD();
}