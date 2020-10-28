<template>
  <div class="img_fundo">
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
          Projetos desenvolvidos no Instituto de Estudos e Pesquisas do Vale do Acaraú
        </h2>
        <br>
      </div>
      <br><br>

      <div class="left">
        
      </div>
          <form>
              <div class="form-group">
                <label for="#">Autor:</label>
                <input type="text" class="form-control" id="autor" placeholder="Digite um nome...">
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

          <div class="form-group">
            <label for="#" >Limitar quantidade:</label>
            <input type="number" class="form-control" id="number" placeholder="XX">
          </div>

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
            <td v-if="user.id == projeto.user_id && user.instituicao == 'IVA' " >{{user.curso}}</td> 
            <td v-if="user.id == projeto.user_id && user.instituicao == 'IVA'" >{{projeto.tipo}}</td>
            <td v-if="user.id == projeto.user_id && user.instituicao == 'IVA'" >{{projeto.titulo}}</td>
            <td v-if="user.id == projeto.user_id && user.instituicao == 'IVA'">{{user.login}}</td>
            <td v-if="user.id == projeto.user_id && user.instituicao == 'IVA'">
              <div @click="setId(projeto.id , './ShowProject')" id="img_lupa"></div>
              
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
  this.$http.get(this.baseURI2).then((result) => {
      this.users = result.data;
    });
},
setId: function(project, URL){
    var obj = {id_projeto: project}
    var strObj = JSON.stringify(obj);

    localStorage.setItem("id_projeto",strObj);

  window.open(URL,"janela1","width=1080, height=800,directories=no,location=no,menubar=no,scrollbars=no, status=no, toolbar=no, resizable=no")
},

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

#img_lupa{
  background-image: url(lupa.jpg);
  width: 30px;
  height: 16px;
  cursor: pointer;
}

#number{
  width: 7%;
}
</style>