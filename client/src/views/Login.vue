<template>
    <form class="form_cadastro container" autocomplete="on">
    <div class="container">
      <div class="text-center">
        <img id="img_login" src="Imagens/imagem_login.png" alt="" />
        <h1 class="title">DivPro</h1>
        <p>Insira seus dados para entrar na sua conta</p>
      </div>
      <div class="card_campos">
        <label class="text_login text-center">Usuário</label
        ><input
          type="text"
          id="user"
          name="usuario"
          placeholder="Digite seu usuário"
          v-model="login"
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
          v-model="password"
          required
        />
      </div>
      <div>
        <div id="btn-loging">
          <router-link to="/index">
            <div class="btns_login">
              <button @click="postLogin" id="makeCad" type="submit">
                LOGIN
              </button>
            </div>
          </router-link>
        </div>
        <div id="btn-cadastro">
          <router-link to="/signup">
            <div class="btns_login">
              <button onclick="" id="backLogin" type="submit">
                CADASTRAR
              </button>
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </form>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      login: "",
      password: "",
      baseURI: "http://localhost:8085/BD/api/users",
    };
  },
  created: function() {
    if(localStorage.getItem("user")) {
        this.$router.replace("/");
    } 
  },
  methods: {
    postLogin: function() {
      let obj = {
        login: this.login,
        password: this.password,
      };

      this.$http.post(this.baseURI, obj).then((result) => {
        if (result.data != "") {
          localStorage.setItem("user", JSON.stringify(result.data));
          location.reload();
        } else {
          alert("Check the login and password.");
        }
      });
    },
  },
};
</script>

<style>
.form_login {
  width: 25%;
  margin: auto;
  padding-top: 3%;
  margin-top: 4%;
  background-color: white;
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
  color: white;
  border: 0px;
  margin-bottom: 2%;
}
.text_login {
  margin-top: 2%;
  margin-bottom: 2%;
}
#btn-cadastro {
  margin-top: -8%;
}
</style>
