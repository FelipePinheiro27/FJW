<template>
   <form class="form_login" autocomplete="on">
        <div class="card">
            <div class="card_top">
                <img id="img_login" src="Imagens/imagem_login.png" alt="">
                <h2 class="title">DivPro</h2>
                <p>Insira seus dados para o login</p>
            </div>
            <div class="card_campos">
                <label>Usuário</label><input type="text" id="user" name="usuario" placeholder="Digite seu usuário" v-model="user" required>
            </div>
            <div class="card_campos">
                <label>Senha</label><input type="password" id="senha" name="senha" placeholder="Digte sua senha" v-model="senha" required>
            </div>
            <div class="card_campos">
                <label><input type="checkbox">Lembre-me</label>
            </div>
            <div class="card_campos">
                <button id="login" type="submit">LOGIN</button>
                <button onclick="window.location.href = 'cadastro.html'" id="cadastro" type="submit">CADASTRO</button>
            </div>
        </div>
    </form>
</template>

<script>
export default {
    name: "Login",
    data: function(){
        return{
            user: "",
            senha: "",            
        }
    }
}
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
body{
    background-color: #f0f0f0;
    font-family: sans-serif;
}
.form_login{
    width: 400px;
    margin: auto;
    padding-top: 40px;
}
.card{
    box-shadow: 1px 1px 5px #ccc;
    background-color: white;
    padding: 30px;
    border: 5px;
}
.card_top{
    text-align: center;
}
.card_campos{
    margin-bottom: 10px;

}
.card_campos > label{
    width: 100px;
    color: black;
    /* display: block; */
}
.card_campos > input{
    border-radius: 5px;
    width: 300px;
    height: 25px;
    padding-left: 5px;   
}
.card_campos > button{
    background-image: linear-gradient(to right,red, rgb(58, 54, 54));
    width: 100%;
    border-radius: 30px;
    height: 35px;
    padding: 5px;
    color: white;
    border: 0px;
    margin-bottom: 5px;
}
.card_campos > button:hover{
    background-image: linear-gradient(to right,rgb(58, 54, 54),red);

}

#img_login{
    border-radius: 50px;
    width: 100px;
    box-shadow: 0px 0px 10px #ccc;
}
.title
{
    color: crimson;
}
</style>