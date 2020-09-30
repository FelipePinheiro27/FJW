<template>
  <div>
    <div>
      <NavBar />
    </div>
    <div>
      <form class="box" action="">
        <br />
        <h2 id="logo_cp" class="text-center">
          Prencha os Dados Abaixo Para Cadastrar seu Projeto
        </h2>
        <div class="text-left inputs_cp">
          <div class="form-group">
            <label class="" for="title">Título:</label>
            <input
              type="text"
              class="form-control"
              name="titulo"
              id="titulo"
              v-model="titulo"
            />
          </div>
          <div class="form-group">
            <label>Descrição:</label>
            <textarea
              class="form-control"
              id="descricao"
              name="descricao"
              v-model="descricao"
            ></textarea>
          </div>
          <div class="form-group">
            <label>Palavras Chaves :</label>
            <input
              type="text"
              class="form-control"
              id="palavrasChaves"
              name="palavrasChaves"
              v-model="palavrasChaves"
            />
          </div>
          <div class="form-group">
            <label>Tipo de Projeto:</label>
            <select
              name="projetos"
              id="opc"
              class="form-control"
              v-model="tipo"
            >
              <option value="Projeto de Conclusão de Curso">Projeto de Conclusão de Curso</option>
              <option value="TCC">TCC</option>
              <option value="BIA">BIA</option>
              <option value="NPDS">NPDS</option>
              <option value="PIBID">PIBID</option>
              <option value="PIBIC">PIBIC</option>
            </select>
          </div>
          <div class="form-group">
            <input class="form-control ficheiro_cp" type="file" id="ficheiro" />
          </div>
        </div>

        <div class="text-center">
          <br /><br />
          <button
            @click="postRegisterProject"
            class="btn butoes_cp btn-primary"
          >
            Cadastrar
          </button>
          <button type="reset" id="limpar_cp" class="btn butoes_cp btn-danger">
            Limpar
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import NavBar from "./NavBar";
export default {
  name: "CadastrarProjeto",
  data: function () {
    return {
      userId: "",
      titulo: "",
      descricao: "",
      palavrasChaves: "",
      tipo: "",
      baseURI: "http://localhost:8080/projeto/api/projects",
    };
  },
  methods: {
    postRegisterProject: function () {
      var user = localStorage.getItem("user");
      var uId = JSON.parse(user);
      let obj = {
        userId: uId.id,
        titulo: this.titulo,
        descricao: this.descricao,
        palavrasChaves: this.palavrasChaves,
        tipo: this.tipo,
      };
      this.$http.post(this.baseURI, obj).then((result) => {
        this.projects = result.data;
        console.log(result.data);
      });
    },
  },
  components: {
    NavBar,
  },
};
</script>

<style>
.titulo_cp {
  width: 95%;
}
.box {
  background-color: white;
  margin-top: 3%;
  margin-left: 5%;
  margin-right: 5%;
}
.butoes_cp {
  margin-bottom: 2%;
  width: 10%;
}
.inputs_cp {
  margin-left: 1%;
  margin-right: 1%;
}
#limpar_cp {
  margin-left: 1%;
}
#logo_cp {
  color: cornflowerblue;
}
.ficheiro_cp {
  width: 30%;
}
</style>


