<template>
  <div class="home2">
    <div>
      <input type="text" placeholder="Digite o id do projeto" v-model="id" />
      <button @click="deleteProjectByID" type="button">deleteByID</button>
    </div>
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
    <div>
      <h3>ID do Projeto:</h3>
      <input type="text" name="" id="" v-model="id" /><br />
      <h3>Titulo:</h3>
      <input type="text" name="" id="" v-model="titulo" /><br />
      <h3>descricao:</h3>
      <input type="text" name="" id="" v-model="descricao" /><br /><br />
      <h3>palavras_chaves:</h3>
      <input type="text" name="" id="" v-model="palavras_chaves" /><br /><br />
      <button @click="putProject">Edit</button><br />
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      users: [],
      user_id:"",
      titulo:"",
      descricao:"",
      palavras_chaves:"",
      project: {},
      projects: [],
      id: "",
      jsonUser: null,
      baseURI: "http://localhost:8080/BD/api/projects",
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.projects = result.data;
      if(this.$session.exists()){
      this.jsonUser = this.$session.get("user"),
      this.user_id = JSON.parse(this.jsonUser).id;  
      }
  
    });
     
  },
  methods: {
    deleteProjectByID: function () {
      let obj = {
        id: this.id,
      };
      if (this.id != "") {
        this.$http
          .delete(this.baseURI + "/" + this.id)
          .then((result) => {
            this.project = result.data;
          })
          .catch(function (error) {
            console.log(error);
          });
      } else {
        alert("Digite um Id para essa função");
      }
    },
    ///Tipo e user_id estão sendo pegos de forma estática, no PUT todos os campos devem ser passados
    ///Na hora de fazer a página de modificação nenhum campo pode fica em branco, todos devem ser preenchidos
    ///Se não está errado, e na hora da modificação dá erro.
     putProject: function () {
      let obj = {
        titulo: this.titulo,
        descricao: this.descricao,
        palavras_chaves: this.palavras_chaves,
        user_id: this.user_id
      };
      console.log("O user_id: " + this.user_id)
      this.$http
        .put(this.baseURI + "/" + this.id, {  
          user_id: this.user_id,
          titulo: this.titulo,
          descricao: this.descricao,
          palavras_chaves: this.palavras_chaves,
          tipo:"TCC"
        })
        .then((result) => {
          console.log(this.user_id)
          console.log(result.data);
        });
    },
  },
};
</script>
