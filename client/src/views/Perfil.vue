<template>
  <div class="img_fundo">
    <div class="container">
      <!-- <NavBar /> -->
      <div v-for="user in users" :key="user.id">
        <div class="dados" v-if="user.id == id_user">
          <h1 id="titulo">Perfil do Usuário</h1>
          <img id="img_perfil" src="Imagens/perfil.png" alt="" />

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Nome :</b>
          </nav>
          <label id="login" for="#"
            ><h4>{{ user.login }}</h4>
          </label>

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Instituição :</b>
          </nav>
          <label  id="instituicao" for="#"
            ><h4>{{ user.instituicao }}</h4>
          </label>

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Curso :</b>
          </nav>
          <label  id="curso" for="#"> <h4>{{ user.curso }}</h4></label>

           <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Alterar Dados da Conta :</b>
          </nav>
          <a  href="" id="link"><h4>Modificar Dados</h4></a> 

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Meus Projetos</b> 
          </nav>

          <div id="container">

            <table class="table table table-bordered">
              <thead>
                <tr class="bg-primary">
                  <th scope="col">ID</th>
                  <th scope="col">Título</th>
                  <th scope="col">Descrição</th>
                  <th scope="col">Tipo</th>
                  <th scope="col">Autor</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">1</th>
                  <td>############</td>
                  <td>asdasdasdasdasdasdaasdasasd</td>
                  <td>TCC</td>
                  <td>Jean Camelo</td>
                </tr>
                <tr>
                  <th scope="row">2</th>
                  <td>############</td>
                  <td>fghfghfghfghfhgfghfghfghfgh</td>
                  <td>BIA</td>
                  <td>Wallysson Lopes</td>
                </tr>
                <tr>
                  <th scope="row">3</th>
                  <td>############</td>
                  <td>qweqweqweqweqweqweqweqweqwe</td>
                  <td>PIBIC</td>
                  <td>Adalberto Felipe</td>
                </tr>
              </tbody>
            </table>
          </div>

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Meus Favoritos:</b>
          </nav>
          
           <table class="table table table-bordered">
      <thead>
        <tr class="bg-primary">
          <th scope="col">Título</th>
          <th scope="col">Descrição</th>
          <th scope="col">Tipo</th>
          <th scope="col">Autor</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>############</td>
          <td>asdasdasdasdasdasdaasdasasd</td>
          <td>TCC</td>
          <td>Jean Camelo</td>
        </tr>
        <tr>
          <td>############</td>
          <td>fghfghfghfghfhgfghfghfghfgh</td>
          <td>BIA</td>
           <td>Wallysson Lopes
           </td>
        </tr>
        <tr>
          <td>############</td>
          <td>qweqweqweqweqweqweqweqweqwe</td>
          <td>PIBIC</td>
          <td>Adalberto Felipe</td>
        </tr>
      </tbody>
    </table>
  </div>

        </div>
      </div>
    </div>
  </div>
</template>


<script>
import NavBar from "./NavBar";

export default {
  components: {
    NavBar,
  },
  data() {
    return {
      id_user: "",
      nome: "",
      curso: "",
      users: [],
      projects: [],
      baseURI: "http://localhost:8086/api/projects",
      baseURI2: "http://localhost:8086/api/users",
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.projects = result.data;
      console.log(this.projects);
    });
    this.$http.get(this.baseURI2).then((result) => {
      this.users = result.data;
      console.log(this.users);
    });

    if (this.$session.exists()) {
      var jsonUser = this.$session.get("user");
      var user = JSON.parse(jsonUser);
      this.nome = user.login;
      this.id_user = user.id;
    }
  },
};
</script>

<style>
#login {
  margin-left: 35%;
}
#instituicao {
  margin-left: 40%;
}
#curso {
  margin-left: 30%;
}

#link {
  margin-top: 30%;
}
#titulo {
  color: #446088;
}

.dados {
  padding: 50px 200px 40px;
}
.container {
  border-radius: 5px;
}

#img_perfil {
  color: #446088;

  width: 15%;
  margin-top: 5%;
  margin-left: 40%;
  margin-bottom: 5%;
}
</style>