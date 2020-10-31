<template>
  <div id="app">
    <!-- <div id="nav">
      <router-link to="/">Home </router-link> |
      <router-link to="/projects"> Projects </router-link>|
      <router-link to="/users"> Users </router-link>|
      <router-link to="/signup">Register</router-link>
      <router-link to="/aboutproject"> | AboutProject</router-link>|
      <router-link to="/showproject">Visualizar Projeto</router-link>
      <router-link v-if="logged == false" to="/login"> | Login</router-link>
      <a href="#" v-if="logged" @click="logout"> | Logout</a>
      <router-link to="/cadastrarprojeto"> | Cadastrar Projetos</router-link>
      <router-link to="/index"> | Index</router-link>
      <button @click="teste">
        Clica aqui Para ver o ID do User logado no console (Deve Estar logado)
      </button>
    </div> -->
    <router-view />
  </div>
</template>

<script>
export default {
  data() {
    return {
      logged: false,
    };
  },
  created: function () {
    if (this.$session.exists()) {
      this.logged = true;
    }
  },
  methods: {
    logout: function () {
      this.$session.destroy();
      location.reload();
    },
    teste: function () {
      if (this.$session.exists()) {
        var jsonUser = this.$session.get("user");
        var user = JSON.parse(jsonUser);
        console.log(user.id);
      }
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
}

ul {
  list-style-type: none;
  text-align: left;
  white-space: nowrap;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
