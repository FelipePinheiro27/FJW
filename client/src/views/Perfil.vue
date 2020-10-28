<template>

      

<div class="img_fundo">
  <div class="container">
      <!-- <NavBar /> -->
      <div v-for="user in users" :key="user.id">
        <div class="dados" v-if="user.id == id_user">
            <h1 id="titulo">Perfil do Usuário</h1>
            <img id="img_perfil" src="Imagens/perfil.png" alt="" /> 

            <div>
            <label for="#">Nome: {{user.login}} </label> 
            </div>
            <div>
              <label for="#">Instituição: {{user.instituicao}} </label>
            </div>
            <div>
              <label for="#">Curso: {{user.curso}} </label>
            </div>
            <div>
              <label for="#">Meus Projetos</label>
            </div>
            <div>
              <label for="#">Ver Favoritos</label>
            </div>
            <a href="">Modificar Dados</a>
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
      baseURI2: "http://localhost:8086/api/users"
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.projects = result.data;
            console.log(this.projects)
    });
    this.$http.get(this.baseURI2).then((result) => {
      this.users = result.data;
      console.log(this.users)
    });

        if (this.$session.exists()) {
        var jsonUser = this.$session.get("user");
        var user = JSON.parse(jsonUser);
        this.nome = user.login;
        this.id_user = user.id;
      }
}
};
</script>

<style>

.dados {
    padding: 50px 200px 40px; 
}
.container {
  border-radius: 5px;
}

#img_perfil {
  width: 15%;
  margin-top: 5%;
  margin-left: 40%;
  margin-bottom: 5%;
}
</style>