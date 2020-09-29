<template>
  <form class="form_login container" autocomplete="on">
    <div class="text-center">
      <img id="img_login" src="Imagens/imagem_login.png" alt="" />
      <h1 class="title">DivPro</h1>
      <p>Insira seus dados para entrar na plataforma</p>
    </div>
    <div class="card_campos">
      <label class="text_login text-center">Usuário</label
      ><input
        type="text"
        id="user"
        name="usuario"
        placeholder="Digite seu usuário"
        v-model="user"
        required
      />
    </div>
    <div class="card_campos">
      <label class="text_login text-center">Senha</label
      ><input
        type="password"
        id="senha"
        name="senha"
        placeholder="Digte sua senha"
        v-model="senha"
        required
      />
    </div>
    <div>
      <div id="btn-login">
        <router-link to="/">
          <div class="btns_login">
            <button id="login" type="submit">LOGIN</button>
          </div>
        </router-link>
      </div>
      <div id="btn-cadastro">
        <router-link to="/Cadastro">
          <div class="btns_login">
            <button onclick="" id="cadastro" type="submit">CADASTRO</button>
          </div>
        </router-link>
      </div>
    </div>
  </form>
</template>
          

<script>
export default {
  name: "Login",
  data: function () {
    return {
      user: "",
      senha: "",
    };
  },
};
// var campo_user = document.getElementById("user");
// var campo_senha = document.getElementById("senha");
// var botao_login = document.getElementById("login");
// var botao_cadastro = document.getElementById("cadastro");

// myStorage = window.localStorage;

// function usuario(user, senha) {
//     this.user = user;
//     this.senha = senha;
//     this.verificaBD = function () {
//         if (myStorage.getItem(this.user) != null) {
//             if (JSON.stringify(myStorage.getItem(this.user)) == JSON.stringify(this.senha)) {
//                 location.href = "index.html";
//             }
//             else{
//                 alert("Usuário ou senha incorretos")
//             }
//         }
//         else{
//             alert("Usuário ou senha incorretos")
//         }
//         if (this.user.length < 6) {
//             alert("O usuário deve conter no mínimo 6 caracteres")
//         }
//         if (this.senha.length <= 6) {
//             alert("A senha deve conter no mínimo 8 caracteres")
//         }
//     }
// }
// botao_login.onclick = function redirect(event) {
//     event.preventDefault();
//     console.log("Testando o campo senha " + campo_senha.value);
//     novo_usuario = new usuario(campo_user.value, campo_senha.value);
//     novo_usuario.verificaBD();
// }
</script>

<style>
.form_login {
  width: 25%;
  margin: auto;
  padding-top: 3%;
  margin-top: 4%;
}
.card_campos > label {
  color: black;
  display: block;
}
.card_campos > input {
  border-radius: 5px;
  width: 90%;
  padding-left: 5%;
}
.card_campos > button {
  /* background-image: linear-gradient(to right,rgb(25, 0, 255), rgb(58, 54, 54)); */
  background-color: rgb(55, 104, 196);
  width: 100%;
  border-radius: 30rem;
  height: 5%;
  padding: 5px;
  color: white;
  border: 0px;
  margin-bottom: 2%;
}
#img_login {
  margin-top: 5%;
  border-radius: 50px;
  width: 28%;
  box-shadow: 0px 0px 10px #ccc;
}
.title {
  color: cornflowerblue;
}
#cadastro {
  margin-bottom: 10%;
}
.btns-login {
  margin-top: 1%;
}
.btns_login {
  margin-top: 8%;
}
.btns_login > button {
  background-color: rgb(55, 104, 196);
  width: 100%;
  border-radius: 30rem;
  height: 5%;
  color: white;
  border: 0px;
  margin-bottom: 2%;
}
.text_login {
  margin-top: 2%;
  margin-bottom: 2%;
}
#btn-cadastro{
    margin-top: -8%;
}
</style>