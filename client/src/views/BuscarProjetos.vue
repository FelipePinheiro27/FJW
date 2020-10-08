<template>
  <div>
    <div v-if="logged == true">
      <NavBarLog />
    </div>
    <div v-if="logged == false">
      <NavBar />
    </div>
    
    <div class="container">
      <br> <br>
      <div class="top_cp">
        <br />
        <h2 class="text-center" id="logo_cp">
          Projetos desenvolvidos na faculdades de Crateús
        </h2>
        <br>
      </div>
      <br><br>

      <div class="left">
        
      </div>
          <form>
              <div class="form-group">
                <label for="#">Autor:</label>
                <input type="email" class="form-control" id="autor" placeholder="Digite um nome...">
              </div>
            <div class="form-group">
              <label for="#">Área do Projeto:</label>
              <select class="form-control" id="area">
                <option>Ciência da Computação</option>
                <option>Matemática</option>
                <option>Enfermagem</option>
                <option>Engenharia Civil</option>
                <option>Psicologia</option>
                <option>Física</option>
                <option>Engenharia de Minas</option>
              </select>

            </div>
            <div class="form-group">
              <label for="#">Tipo do Projeto:</label>
              <select class="form-control" id="tipo">
                <option>Extensão</option>
                <option>BIA</option>
                <option>TCC</option>
                <option>PIBIC</option>
              </select>
            </div>
          </form>

      <br /><br />
      <br />
      <div class="text-center">
        <div class="btn-buscar">
          <button class="btn btn-primary" @click="teste">Consultar</button>
        </div>
        <div class="btn-limpar">
          <button type="reset" class="btn btn-danger">Limpar</button>
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
            
          </tr>
        </thead>

        <tbody id="tbody" v-for="projeto in projects" :key="projeto.id">
          
           <tr class="table-light" v-for="user in users" :key="user.id" >
            <td v-if="user.id == projeto.user_id" >{{user.curso}}</td> 
            <td v-if="user.id == projeto.user_id" >{{projeto.tipo}}</td>
            <td v-if="user.id == projeto.user_id" >{{projeto.titulo}}</td>
            <td v-if="user.id == projeto.user_id">{{user.login}}</td>
            <td v-if="user.id == projeto.user_id"><button @click="getId(user.id)">+</button></td>
          </tr>
      
        </tbody>
    </table>
    </div>
  </div>

</template>



<script>


import NavBar from "./NavBar";
import NavBarLog from "./NavBarLog";

export default {
  name: "BuscarProjetos",
  components: {
    NavBar,
    NavBarLog,
  },
  data() {
    return {
      logged: false,
      users: [],
      projects: [],
      baseURI: "http://localhost:8085/BD/api/projects",
      baseURI2: "http://localhost:8085/BD/api/users"
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.projects = result.data;
      console.log(result.data);
    });
},
  mounted: function () {
    if (localStorage.getItem("user")) {
      this.logged = true;
    }
  },
methods:{
teste: function(){
  this.$http.get(this.baseURI2).then((result) => {
      this.users = result.data;
      console.log(result.data);
    });
},
getId: function(user){
  console.log("ID do user: " + user)
}

},
};
</script>

<style>
.container {
  background-color: white;
}

.container table {
  margin-top: 5%; 
}


.btn-buscar, .btn-limpar {
  display: inline-block;
  margin-right: 1%;
  margin-bottom: 2%;
}
</style>