<template>
<div class="teste_signUp">
       <form class="form_cadastro container" autocomplete="on">
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
      <div class="card_campos">
        <label class="text_login text-center">Instituição</label
        ><input
          v-model="instituicao"
          type="text"
          id="instituicao"
          name="instituicao"
          placeholder="Digite sua Instituição"
          
        />
      </div>
      <div class="card_campos">
        <label class="text_login text-center">Curso</label
        ><input
          v-model="curso"
          type="text"
          id="curso"
          name="curso"
          placeholder="Digite o seu Curso"
          
        />
      </div>
      <div>
        <div id="btn-loging">
            <div class="btns_login">
              <button @click="postRegister" id="makeCad" type="button">
                CADASTRAR
              </button>
            </div>
        </div>
        <div id="btn-cadastro">
          <router-link to="/Login">
            <div class="btns_login">
              <button onclick="" id="backLogin" type="button">
                VOLTAR PARA LOGIN
              </button>
            </div>
          </router-link>
        </div>
      </div>
      <br>
     </form>
  </div>
  
</template>

<script>
export default {
  name: "SignUp",
  data: function () {
    return {
      login: "",
      password: "",
      instituicao: "",
      curso: "",
      baseURI: "http://localhost:8080/api/users",
    };
  },
  methods: {
    postRegister: function () {
      if(this.login != "" && this.password != "" && this.login.length >= 6 && this.password.length >= 6){
      let obj = {
        login: this.login,
        password: this.password,
        instituicao: this.instituicao,
        curso: this.curso,
      };

        this.$http.post(this.baseURI, obj).then((result) => {
          if (result.status === 200) {
            this.$session.start();
            this.$session.set("user", JSON.stringify(result.data));
            location.reload();
          }
        })
        .catch(function(error){
          if(error.response.status === 401){
            alert("Cheque o Login e o Password");
          }
          else{
            alert("Não foi possível entrar");
          }
        });
      }
      else{
        alert("Login ou senha curtos, é necessário mais que 5 caracteres!");
      }
    },
  },
};
</script>

<style>
.form_cadastro {
  width: 25%;
  height: 100%;
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
  width: 100%;
  padding-left: 2%;
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

.teste_signUp{
  margin-top: 1%;
}
</style>
