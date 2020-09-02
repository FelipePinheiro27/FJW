var campo_user = document.getElementById("user");
var campo_senha= document.getElementById("senha");
var botao_login = document.getElementById("login");
var botao_cadastro = document.getElementById("cadastrar");

myStorage = window.localStorage

botao_cadastro.onclick = function cadastro(event)
{ 
    event.preventDefault();
    if(campo_user.value.length > 5 && campo_senha.value.length > 7){
        if(myStorage.getItem(campo_user.value) == null){
          myStorage.setItem(campo_user.value,campo_senha.value)
          alert("Cadastro feito com sucesso. Clique aqui para voltar para a tela de Login")
          location.href = "login.html";
        }
        else{
            alert("Nome de usuário ja está sendo utilizado")
        }
  }
  else{
      alert("Nome de usuário deve conter ")
  }
}