<template>
  <div class="teste_login">
    <form class="form_login container" autocomplete="on">
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
          <div class="btns_login">
            <button @click="postLogin" id="makeCad" type="button">LOGIN</button>
          </div>
        </div>
        <div id="btn-cadastro">
          <router-link to="/signup">
            <div class="btns_login">
              <button onclick="" id="backLogin" type="button">CADASTRAR</button>
            </div>
          </router-link>
        </div>
        <br />
      </div>
    </form>

    <!-- <br> <br> <br> <br> <br> <br> -->
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      login: "",
      password: "",
      baseURI: "http://localhost:8086/api/users/login",
    };
  },
  created: function () {
    if (this.$session.exists()) {
      this.$router.replace("/index");
    }
  },
  methods: {
    postLogin: function () {
      if (
        this.login != "" &&
        this.password != "" &&
        this.login.length >= 6 &&
        this.password.length >= 6
      ) {
        let obj = {
          login: this.login,
          password: this.password,
        };
        let session = {
          login: null,
          id: null,
        };

        this.$http
          .post(this.baseURI, obj)
          .then((result) => {
            if (result.status === 200) {
              this.$session.start();
              session.login = result.data.login;
              session.id = result.data.id;
              // alert(result.data.password);
              this.$session.set("user", JSON.stringify(session));
              location.reload();
            }
          })
          .catch(function (error) {
            if (error.response.status === 401) {
              alert("Cheque o Login e o Password!");
            } else {
              alert("Não foi possivel entrar!");
            }
          });
      } else {
        alert("Nome usuário ou senha curtos, é necessário mais que 5 caracteres!!");
      }
    },
  },
};
</script>

<style>
.form_login {
  width: 25%;
  margin: auto;
  padding-top: 3%;
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
body {
  background-image: url(2.jpg);
  background-repeat: repeat;
}
.teste_login {
  margin-top: 5%;
}
.text_login {
  margin-top: 2%;
  margin-bottom: 2%;
}
#btn-cadastro {
  margin-top: -6%;
  /* margin-bottom: 10%; */
}
</style>