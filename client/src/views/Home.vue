<template>
  <div class="home">
    <div>
      <ul>
        <li v-for="user in users" :key="user.id">
          <h4>{{ user.id }}</h4>
          <p>{{ user.login }}</p>
          <p>{{ user.password }}</p>
          <p>{{ user.insitituicao }}</p>
          <p>{{ user.curso }}</p>
          <hr />
        </li>
      </ul>
    </div>
    <div>
      <ul>
        <li v-for="projeto in projects" :key="projeto.id">
          <h4>{{ "ProjetoID" + projeto.id }}</h4>
          <p>{{ projeto.login }}</p>
          <hr />
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      users: [],
      projects: [],
      baseURI: "http://localhost:8080/projeto/api/users",
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.users = result.data;
      console.log(result.data);
    });
  },
};
</script>
