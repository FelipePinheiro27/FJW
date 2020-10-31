<template>
  <div class="img_fundo">
    <div v-if="logged == true">
      <NavBarLog />
    </div>
    <div v-if="logged == false">
      <NavBar />
    </div>
    
    <div class="container" id="fundo_UFC">
      <br> <br>
      <div class="top_cp">
        <br />
        <h2 class="text-center" id="logo_cp">
          Projetos desenvolvidos na Universidade Federal do Ceará
        </h2>
        <br>
      </div>
      <br><br>

      <div class="left">
        
      </div>
          <form>
              <div class="form-group">
                <label for="#">Autor:</label>
                <input type="text" v-model="login" class="form-control" id="autor" placeholder="Digite um nome...">
              </div>
            <div class="form-group">
              <label for="#">Área do Projeto:</label>
              <select class="form-control" id="area" v-model="curso">
                <option>Ciência da Computação</option>
                <option>Matemática</option>
                <option>Enfermagem</option>
                <option>Engenharia Civil</option>
                <option>Psicologia</option>
                <option>Física</option>
                <option>Engenharia de Minas</option>
              </select>

            </div>
            <!-- <div class="form-group">
              <label for="#">Tipo do Projeto:</label>
              <select class="form-control" id="tipo">
                <option>Extensão</option>
                <option>BIA</option>
                <option>TCC</option>
                <option>PIBIC</option>
              </select>
            </div> -->
          </form>

          <!-- <div class="form-group">
            <label for="#" >Limitar quantidade:</label>
            <input type="number" class="form-control" id="number" v-model="valor" placeholder="xx">
          </div> -->

      <br />
      <div class="text-center">
        <div class="btn-buscar">
          <button class="btn btn-primary" @click="teste">Consultar</button>
        </div>
        <div class="btn-limpar">
          <button type="reset" class="btn btn-danger" @click="reload">Limpar</button>
        </div>
      </div> 
    </div>

<div class="container">
    <table class="table table table-bordered">
        <thead>
          <br>
          <tr class="bg-primary">
            <th >Área do Projeto</th>
            <th >Tipo do Projeto</th>
            <th>Título</th>
            <th >Autor</th>
            <!-- <th>Like</th> -->
            
            
          </tr>
        </thead>

        <tbody id="tbody" v-for="projeto in projects" :key="projeto.id">
          
           <tr class="table-light" v-for="user in users" :key="user.id" >
            <td v-if="user.id == projeto.user_id && user.instituicao == 'UFC'" >{{user.curso}}</td> 
            <td v-if="user.id == projeto.user_id && user.instituicao == 'UFC'" >{{projeto.tipo}}</td>
            <td v-if="user.id == projeto.user_id && user.instituicao == 'UFC'" >{{projeto.titulo}}</td>
            <td v-if="user.id == projeto.user_id && user.instituicao == 'UFC'">{{user.login}}</td>
              <!-- <td v-if="user.id == projeto.user_id">   <div id="img_estrela"></div></td> -->
              <td v-if="user.id == projeto.user_id">
                <div v-if="logged == true">
              <div @click="setId(projeto.id , './ShowProject')" id="img_lupa"></div>
              </div>
              <div v-if="logged == false">
              <div @click="setId(projeto.id , './ShowProject2')" id="img_lupa"></div>
              </div>
              </td>
          </tr>
      
        </tbody>
    </table>
    </div>
  </div>

</template>



<script>


import NavBar from "./NavBar";
import NavBarLog from "./NavBarLog";
import imageUFC from "../../public/Imagens/UFC.png";

export default {
  name: "BuscarProjetos",
  components: {
    NavBar,
    NavBarLog,
  },
  data() {
    return {
      logged: false,
      valor: '',
      login: '',
      curso: '',
      users: [],
      projects: [],
      baseURI: "http://localhost:8086/api/projects",
      baseURI2: "http://localhost:8086/api/users"
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.projects = result.data;
      console.log(result.data)
});
},
  mounted: function () {
    if (this.$session.exists()) {
      this.logged = true;
    }
  },
methods:{
teste: function(){
  if(this.login == '' && this.curso != ''){
    this.fetchUserByCurso();
    // this.filtroRegistro();
  }
  if(this.login != '' && this.curso == ''){
    this.fetchUserByTitulo();
    // this.filtroRegistro();
  }
  if(this.login != '' && this.curso != ''){
    this.fetchUserByTituloAndCurso();
    // this.filtroRegistro();
  }
  if(this.login == '' && this.curso == ''){
  this.$http.get(this.baseURI2).then((result) => {
      this.users = result.data;
      this.filtroRegistro();
    });
    }
},
filtroRegistro: function() {
      this.$http
        .get(this.baseURI2 + "/limit?valor=" + this.valor)
        .then((result) => {
          this.users = result.data;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
setId: function(project, URL){
    var obj = {id_projeto: project}
    var strObj = JSON.stringify(obj);

    localStorage.setItem("id_projeto",strObj);

  window.open(URL,"janela1","width=1080, height=800,directories=no,location=no,menubar=no,scrollbars=no, status=no, toolbar=no, resizable=no")
},
fetchUserByCurso: function() {
      this.$http
        .get(this.baseURI2 + "/ir?curso=" + this.curso)
        .then((result) => {
          this.users = result.data;
          console.log(this.users)
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    fetchUserByTitulo: function() {
      this.$http
        .get(this.baseURI2 + "/search?login=" + this.login)
        .then((result) => {
          this.users = result.data;
          console.log(this.users)
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    fetchUserByTituloAndCurso: function() {
      this.$http
        .get(this.baseURI2 + "/buscar?login=" + this.login + "&&curso=" + this.curso)
        .then((result) => {
          this.users = result.data;
          console.log(this.users)
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    reload: function(){
      location.reload();
    }

},
};
</script>

<style>



.container {
  background-color: white;
  
}

#fundo_UFC{
background-image:linear-gradient( rgba(255,255,255,.8) 0%,rgba(255,255,255,.8) 100%), url("UFC.jpg"); 
  background-repeat: no-repeat;
  background-size: 100% 100%;
}

.container table {
  margin-top: 5%; 
}


.btn-buscar, .btn-limpar {
  display: inline-block;
  margin-right: 1%;
  margin-bottom: 2%;
}

#img_lupa{
  background-image: url(lupa.jpg);
  width: 30px;
  height: 16px;
  cursor: pointer;
}

#img_estrela{
  background-image: url(estrela.png);
  width: 20px;
  height: 17px;
  cursor: pointer;
}

#number{
  width: 7%;
}

#favoritar{
  float: right;
  margin-top: 0.7%;
  background-image: url(estrela_desmarcada.jpg);
  width: 30px;
  height: 31px;
  cursor: pointer;
}

#favoritado{
  float: right;
  margin-top: 0.7%;
  background-image: url(estrela_marcada.png);
  width: 30px;
  height: 31px;
  cursor: pointer;
}
</style>