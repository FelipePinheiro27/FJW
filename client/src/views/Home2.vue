<template>
  <div class="home2">
    <div class="text-white">
      <ul>
        <li v-for="projeto in projects" :key="projeto.id">
          <h4>{{ "Projeto ID " + projeto.id }}</h4>
          <p>{{ "User ID " + projeto.user_id }}</p>
          <p>{{ "Titulo " + projeto.titulo }}</p>
          <p>{{ "Descricao " + projeto.descricao }}</p>
          <p>{{ "Palavras Chaves " + projeto.palavras_chaves }}</p>
          <p>{{ "Tipo " + projeto.tipo }}</p>
          <p>
            ///////////////////////////////////////////////////////////////////////
          </p>
        </li>
      </ul>
    </div>
    <button @click="getById" type="button">getById</button>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      users: [],
      projects: [],
      baseURI: "http://localhost:8085/BD/api/projects",
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
