<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <router-link to="/index">
        <a class="navbar-brand h3 mb-0" id="home"
          ><h3 class="logo">DivPro</h3></a
        >
      </router-link>
      <div class="collapse navbar-collapse" id="navbarSite">
        <router-link to="/cadastrarprojeto">
          <a class="nav-link" style="color: white">Cadastrar Projeto</a>
        </router-link>
        <router-link to="/BuscarProjetos">
        <a class="nav-link" style="color: white" href="#">Procurar Projetos</a>
        </router-link>
        <div id="first">
          <a style="color: silver"><h6>{{users.login}}</h6></a>
        </div> 
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      login: "",
      users: [],
      projects: [],
      baseURI: "http://localhost:8080/api/users",
    };
  },

  created: function () {
      var jsonUser = this.$session.get('user');
      var user = JSON.parse(jsonUser);
      let obj = {
        login: user.login,
      };
      this.$http.post(this.baseURI, obj).then((result) => {
        this.users = result.data;
      });
  },
};  
</script>

<style>
#home {
  margin-left: 10%;
}
#first {
  margin-left: 65%;
}
.logo {
  color: cornflowerblue;
}
</style>