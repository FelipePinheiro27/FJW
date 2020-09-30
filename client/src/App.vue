<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Home </router-link> |
      <router-link to="/home2"> Home2 </router-link>|
      <router-link to="/signup">Register</router-link>
      <router-link v-if="logged == false" to="/login"> | Login</router-link>
      <router-link v-if="logged" to="/users"> | Users</router-link>
      <a href="#" v-if="logged" @click="logout"> | Logout</a>
      <router-link to="/cadastrarprojeto"> | Cadastrar Projetos</router-link>
      <router-link to="/index"> | Index</router-link>
      <button @click="teste">Clica aqui Para ver o ID do User logado no console (Deve Estar logado)</button>
    </div>
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
  mounted: function () {
    if (localStorage.getItem("user")) {
      this.logged = true;
    }
  },
  methods: {
    logout: function () {
      localStorage.removeItem("user");
      location.reload();
    },
    teste: function () {
      var user = localStorage.getItem("user");
      var obj = JSON.parse(user);
      console.log(obj.id);
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
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
