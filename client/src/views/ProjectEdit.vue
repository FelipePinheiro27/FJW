<template>
  <div>
    <h3>ID:</h3>
    <input type="text" name="" id="" v-model="projeto.id" /><br />
    <h3>Titulo:</h3>
    <input type="text" name="" id="" v-model="projeto.titulo" /><br />
    <h3>Descrição:</h3>
    <input type="text" name="" id="" v-model="projeto.descricao" /><br />
    <h3>Palavras Chaves:</h3>
    <input type="text" name="" id="" v-model="projeto.palavras_chaves" /><br /><br />
    <h3>Tipo de Projeto:</h3>
    <input type="text" name="" id="" v-model="projeto.tipo" /><br /><br />
    <button @click="putProject">Edit</button><br />
  </div>
</template>

<script>
export default {
  name: "ProjectEdit",
  id: 2,
  data: function() {
    return {
      id:'',
      titulo:'',
      descricao:'',
      palavras_chaves:'',
      tipo:'',
      projeto:{},
      baseURI: "http://localhost:8080/api/projects",
    };
  },
  created: function() {
    this.$http
      .get(this.baseURI + "/" + localStorage.getItem("projectId"))
      .then((result) => {
        this.projeto = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
      console.log("O projeto: " + this.projeto)
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
          this.$router.push({ name: 'Projects'});
        });
    },
  },
};
</script>

<style></style>
