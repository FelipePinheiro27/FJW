<template>
  <div>
    <button @click="$router.push({ name: 'CadastrarProjeto' })">Insert</button>

    <ul>
      <li v-for="projeto in projects" :key="projeto.id">
        <div id="geral">
          <div class="left">
            <h4>{{ projeto.titulo }} {{ projeto.id }}</h4>
            <p>{{ projeto.descricao }}</p>
            <p>{{ projeto.palavras_chaves }}</p>
            <p>{{ projeto.tipo }}</p>
          </div>
          <div class="right">
            <button @click="goToEdit(projeto.id)">Update</button>
            <button @click="deleteProjectById(projeto.id)">Delete</button>
          </div>
        </div>
        <hr />
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Projects",
  data() {
    return {
      projects: [],
      jsonUser: null,
      baseURI: "http://localhost:8080/api/projects",
    };
  },
  created: function () {
    this.getAll();
    if (this.$session.exists()) {
      (this.jsonUser = this.$session.get("user")),
        (this.user_id = JSON.parse(this.jsonUser).id);
    }
  },
  methods: {
    getAll: function () {
      this.$http.get(this.baseURI).then((result) => {
        this.projects = result.data;
      });
    },
    deleteProjectById: function (id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        this.getAll();
      });
    },
    goToEdit: function (id) {
      localStorage.setItem("projectId", id);
      this.$router.push({ name: "ProjectEdit" });
    },
  },
};
</script>
