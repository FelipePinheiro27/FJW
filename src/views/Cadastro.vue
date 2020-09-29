<template>
  <form class="form_cadastro container" autocomplete="on">
    <div class="container">
      <div class="text-center">
        <img id="img_login" src="Imagens/imagem_login.png" alt="" />
        <h1 class="title">DivPro</h1>
        <p>Insira seus dados para criar sua conta</p>
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
      <div class="card_campos">
        <label class="text_login text-center">Instituição</label
        ><input
          type="password"
          id="senha"
          name="senha"
          placeholder="Digite sua Instituição"
          v-model="senha"
          required
        />
      </div>
      <div class="card_campos">
        <label class="text_login text-center">Curso</label
        ><input
          type="password"
          id="senha"
          name="senha"
          placeholder="Digite o seu Curso"
          v-model="senha"
          required
        />
      </div>
      <div>
       <div id="btn-loging">
        <router-link to="/Login">
          <div class="btns_login">
            <button id="makeCad" type="submit">CADASTRAR</button>
          </div>
        </router-link>
      </div>
        <div id="btn-cadastro">
          <router-link to="/Login">
            <div class="btns_login">
              <button onclick="" id="backLogin" type="submit">
                VOLTAR PARA LOGIN
              </button>
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </form>
</template>

<script>
export default {};
</script>

<style>
.form_cadastro {
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
  padding: 5px;
  color: white;
  border: 0px;
  margin-bottom: 2%;
}
.text_login {
  margin-top: 2%;
  margin-bottom: 2%;
}
</style>