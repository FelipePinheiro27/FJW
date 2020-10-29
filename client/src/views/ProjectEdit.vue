<template>
  <div class="container">
    <nav class="navbar navbar-dark bg-primary">
      <h3 id="titulo">Atualizar Dados de um Projeto</h3>
    </nav>

    <label class="descricao" for="#">ID:</label>
    <input
      type="text"
      class="form-control"
      name=""
      id=""
      value=""
      v-model="projeto.id"
    /><br />

    <label class="descricao" for="#">Título :</label>
    <input
      type="text"
      class="form-control"
      name=""
      id=""
      value=""
      v-model="projeto.titulo"
    /><br />

    <label class="descricao" for="#">Descrição :</label>
    <input
      type="text"
      class="form-control"
      name=""
      id=""
      value=""
      v-model="projeto.descricao"
    /><br />

    <label class="descricao" for="#">Palavras_Chaves:</label>
    <input
      type="text"
      class="form-control"
      name=""
      id=""
      value=""
      v-model="projeto.palavras_chaves"
    /><br /><br />

    <label class="descricao" for="#">Tipo de Projeto :</label>
    <input
      type="text"
      class="form-control"
      name=""
      id=""
      value=""
      v-model="projeto.tipo"
    /><br /><br />

    <button type="button" id="editar" class="btn butoes_cp btn-primary" @click="putProject">
      Editar
    </button>

    <button type="reset" id="clear" class="btn butoes_cp btn-danger">
      Limpar
    </button>
  </div>
</template>

<script>
export default {
  name: "ProjectEdit",
  id: 2,
  data: function () {
    return {
      id: "",
      titulo: "",
      descricao: "",
      palavras_chaves: "",
      tipo: "",
      projeto: {},
      baseURI: "http://localhost:8086/api/projects",
    };
  },
  created: function () {
    this.$http
      .get(this.baseURI + "/" + localStorage.getItem("projectId"))
      .then((result) => {
        this.projeto = result.data;
      })
      .catch(function (error) {
        console.log(error);
      });
    console.log("O projeto: " + this.projeto);
  },
  methods: {
    ///Tipo e user_id estão sendo pegos de forma estática, no PUT todos os campos devem ser passados
    ///Na hora de fazer a página de modificação nenhum campo pode fica em branco, todos devem ser preenchidos
    ///Se não está errado, e na hora da modificação dá erro.
    putProject: function () {
      let obj = {
        titulo: this.titulo,
        descricao: this.descricao,
        palavras_chaves: this.palavras_chaves,
        user_id: this.user_id,
      };
      console.log("O user_id: " + this.user_id);
      this.$http
        .put(this.baseURI + "/" + this.projeto.id, {
          user_id: this.projeto.user_id,
          titulo: this.projeto.titulo,
          descricao: this.projeto.descricao,
          palavras_chaves: this.projeto.palavras_chaves,
          tipo: this.projeto.tipo,
        })
        .then((result) => {
          this.$router.push({ name: "Projects" });
        });
    },
  },
};
</script>

<style>
#editar {
  margin-left: 40%;
}
#clear {
  margin-left: 1%;
}
.btn butoes_cp btn-primary {
  margin-left: 30%;
}

.navbar {
  border-radius: 5px;
}

#titulo {
  padding-left: 30%;
  padding-top: 1%;
  padding-bottom: 1%;
}
</style>
