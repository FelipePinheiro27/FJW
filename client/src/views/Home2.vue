<template>
  <div class="home2">
    <div class="text-white">
      <ul>
        <li v-for="projeto in projects" :key="projeto.id">
          <h4>{{ "Projeto ID " + projeto.id }}</h4>
          <p>{{ "User ID " + projeto.userId }}</p>
          <p>{{ "Titulo " + projeto.titulo }}</p>
          <p>{{ "Descricao " + projeto.descricao }}</p>
          <p>{{ "Palavras Chaves " + projeto.palavrasChaves }}</p>
          <p>{{ "Tipo " + projeto.tipo }}</p>
          <p>///////////////////////////////////////////////////////////////////////</p>
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
      baseURI: "http://localhost:8080/projeto/api/projects",
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.projects = result.data;
      console.log(result.data);
    });
  },
};
</script>
