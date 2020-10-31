<template>
  <div class="img_fundo">
          <NavBarLog />

    <div class="container">
      <div v-for="user in users" :key="user.id">
        <div class="dados" v-if="user.id == id_user">
          <h1 id="titulo">Perfil do Usuário</h1>
          <img id="img_perfil" src="Imagens/perfil.png" alt="" />

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Nome:</b>
          </nav>
          <label id="login" for="#"
            ><h4>{{ user.login }}</h4>
          </label>

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Instituição:</b>
          </nav>
          <label  id="instituicao_perfil" for="#"
            ><h4>{{ user.instituicao }}</h4>
          </label>

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Curso:</b>
          </nav>
          <label  id="curso_perfil" for="#"> <h4>{{ user.curso }}</h4></label>

           <!-- <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Alterar Dados da Conta:</b>
          </nav>
          <router-link to="/userEdit">
          <a  href="" id="link"><h4>Modificar Dados:</h4></a> 
          </router-link> -->


          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Meus Projetos:    </b>    
          </nav>
          <div>
            <div @click="pegaValor" id="filtro"></div>
            <input class="form-control" id="limit" v-model="valor" placeholder="Qtd">
          </div>      
          <div id="container">

            <table class="table table table-bordered">
              <thead>
                <tr class="bg-primary">
                  <th scope="col">ID</th>
                  <th scope="col">Título</th>
                  <th scope="col">Descrição</th>
                  <th scope="col">Tipo</th>
                  <th scope="col">-</th>
                  <th scope="col">-</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="projeto in projects" :key="projeto.id">
                  <th v-if="id == projeto.user_id">{{projeto.id}}</th>
                  <td v-if="id == projeto.user_id">{{projeto.titulo}}</td>
                  <td v-if="id == projeto.user_id">{{projeto.descricao}}</td>
                  <td v-if="id == projeto.user_id">{{projeto.tipo}}</td>
                  <td v-if="id == projeto.user_id" style="width: 1%;">
              <div @click="deleteProjectById(projeto.id)" id="apagar"></div>
               </td>
               <td v-if="id == projeto.user_id" style="width: 1%;">
              <div @click="setId(projeto.id , './projectEdit')" id="update"></div>
               </td>
                </tr>
              </tbody>
            </table>
          </div>

          <nav class="navbar navbar-light" style="background-color: #446088">
            <b style="color: white">Meus Favoritos:</b>
          </nav>
          
          <div v-for="fav in favoritos" :key="fav.id">
            <div v-if="id == fav.user_id">
              <div v-for="projeto in projects" :key="projeto.id">
                <div v-if="projeto.id == fav.project_id">
           <table class="table table table-bordered" >
      <thead>
        <tr class="bg-primary">
          <th scope="col">Título</th>
          <th scope="col">Descrição</th>
          <th scope="col">Tipo</th>
          <th></th>
        </tr>
      </thead>
      <tbody >
        <tr >
          <td >{{projeto.titulo}}</td>
          <td >{{projeto.descricao}}</td>
          <td >{{projeto.tipo}}</td>
          <td>
              <div @click="setId(projeto.id , './ShowProject2')" id="img_lupa"></div>
          </td>
        </tr>
      </tbody>
    </table>
            </div>
        </div>
      </div>
    </div>
  </div>

        </div>
      </div>
    </div>
</template>


<script>
import NavBarLog from "./NavBarLog";

export default {
  components: {
    NavBarLog,
  },
  data() {
    return {
      id: 0,
      valor: '',
      users: [],
      projects: [],
      favoritos: [],
      baseURI: "http://localhost:8086/api/projects",
      baseURI2: "http://localhost:8086/api/users",
      baseURI3: "http://localhost:8086/api/favoritos",
    };
  },
  created: function () {
    this.$http.get(this.baseURI2).then((result) => {
      this.users = result.data;
      console.log(this.users);
    });
    this.$http.get(this.baseURI).then((result) => {
        this.projects = result.data
      var jsonUser = this.$session.get("user");
        var user = JSON.parse(jsonUser);
        this.nome = user.login;
        this.id = user.id;
          });


    this.$http.get(this.baseURI3).then((result) => {
      this.favoritos = result.data;
    });

    if (this.$session.exists()) {
      var jsonUser = this.$session.get("user");
      var user = JSON.parse(jsonUser);
      this.nome = user.login;
      this.id_user = user.id;
    }
  },
  methods: {


    pegaValor: function(){
          this.$http.get(this.baseURI).then((result) => {
      if(this.valor == 0){
      this.projects = result.data;
      console.log(this.projects);
      var jsonUser = this.$session.get("user");
        var user = JSON.parse(jsonUser);
        this.nome = user.login;
        this.id = user.id;
        }
        if(this.valor != 0){
      this.filtroRegistro();
      var jsonUser = this.$session.get("user");
        var user = JSON.parse(jsonUser);
        this.nome = user.login;
        this.id = user.id;
        }
    });
    },

    filtroRegistro: function() {
      this.$http
        .get(this.baseURI + "/limit?valor=" + this.valor)
        .then((result) => {
          this.projects = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },

    setId: function(id, URL){
    // var obj = {id_projeto: project}
    // var strObj = JSON.stringify(obj);

    localStorage.setItem("id_projeto",id);

  window.open(URL,"janela1","width=1080, height=800,directories=no,location=no,menubar=no,scrollbars=no, status=no, toolbar=no, resizable=no")
},
    deleteProjectById: function (id_Projeto) {
      this.$http.delete(this.baseURI + "/" + id_Projeto).then((result) => {
        location.reload();
      });
    }

  }
};
</script>

<style>
#filtro{
  float: right;
  background-image: url(filtro.png);
  width: 25px;
  height: 25px;
  margin-left: 1%;
  margin-top: 1%;
  cursor: pointer;
}
#limit{
  width: 10%;
  float: right;
}

#login {
  margin-left: 5%;
}
#instituicao_perfil {
  margin-left: 5%;
}
#curso_perfil  {
  margin-left: 5%;
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

#apagar{
  background-image: url(delete2.png);
  width: 30px;
  height: 30px;
  cursor: pointer;
}

#update{
  background-image: url(update.png);
  width: 30px;
  height: 30px;
  cursor: pointer;
}
</style>