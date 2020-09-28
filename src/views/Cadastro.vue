<template>
  <form class="form_login" autocomplete="on">
        <div class="card">
            <div class="card_top">
                <img id="img_login" src="Imagens/imagem_login.png" alt="">
                <h2 class="title">DivPro</h2>
                <p>Insira os dados pedidos para a criação de um novo usuário</p>
            </div>
            <div class="card_campos">
                <label>Usuário</label><input type="text" id="user" name="usuario" placeholder="Digite um nome para seu usuário" required>
            </div>
            <div class="card_campos">
                <label>Senha</label><input type="password" id="senha" name="senha" placeholder="Digite uma senha para acessar sua conta" required>
            </div>
            <div class="card_campos">
                <label>Instituição</label><input type="text" name="inst" id="inst" placeholder="Digite sua Instituição" required>
            </div>
            <div class="card_campos">
                <label>Curso</label><input type="text" name="inst" id="inst" placeholder="Digite o seu Curso" required>
            </div>
            <div class="card_campos">
                <button id="cadastrar" type="submit">CONFIMAR CADASTRO</button>
                <button onclick="location.href = 'login.html'" id="voltar_cadastro_login" type="submit">VOLTAR PARA LOGIN</button>
            </div>
        </div>
    </form>
</template>

<script>
export default {

}
</script>

<style>
body {
  background-color: #f0f0f0;
  font-family: sans-serif;
}
.form_login {
  width: 400px;
  margin: auto;
  padding-top: 40px;
}
.card {
  box-shadow: 1px 1px 5px #ccc;
  background-color: white;
  padding: 30px;
  border: 5px;
}
.card_top {
  text-align: center;
}
.card_campos {
  margin-bottom: 10px;
}
.card_campos > label {
  width: 100px;
  color: black;
  /* display: block; */
}
.card_campos > input {
  border-radius: 5px;
  width: 300px;
  height: 25px;
  padding-left: 5px;
}
.card_campos > button {
  background-image: linear-gradient(to right, red, rgb(58, 54, 54));
  width: 100%;
  border-radius: 30px;
  height: 35px;
  padding: 5px;
  color: white;
  border: 0px;
  margin-bottom: 5px;
}
.card_campos > button:hover {
  background-image: linear-gradient(to right, rgb(58, 54, 54), red);
}

#img_login {
  border-radius: 50px;
  width: 100px;
  box-shadow: 0px 0px 10px #ccc;
}
.title {
  color: crimson;
}

</style>