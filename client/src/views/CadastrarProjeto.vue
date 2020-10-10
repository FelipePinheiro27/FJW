<template>
  <div class="img_fundo">
    <div v-if="logged == true">
      <NavBarLog />
    </div>
    <div v-if="logged == false">
      <NavBar />
    </div>
    <div>
      <form class="box" action="">
        <br />
        <div class="top_cp container">
          <br>
          <h2 id="logo_cp" class="text-center">
            Preencha os Dados Abaixo Para Cadastrar seu Projeto
          </h2><br>
        </div>
        <div class="text-left inputs_cp">
          <div class="form-group border_input_cp">
            <label class="" for="title" id="title">Título:</label>
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
              v-model="palavras_chaves"
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
              <option value="Projeto de Conclusão de Curso">
                Projeto de Conclusão de Curso
              </option>
              <option value="TCC">TCC</option>
              <option value="BIA">BIA</option>
              <option value="NPDS">NPDS</option>
              <option value="PIBID">PIBID</option>
              <option value="PIBIC">PIBIC</option>
            </select>
          </div>
          <div >
            <input type="file"
      id="file"
      ref="file"
      name="image"
      >
          </div>
        </div>

        <div class="text-center">
          <br /><br />
          <button
            type="button"
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
import NavBarLog from "./NavBarLog";

export default {
  name: "CadastrarProjeto",
  data: function () {
    return {
      logged: false,
      id: 0,
      user_id: "",
      titulo: "",
      descricao: "",
      palavras_chaves: "",
      tipo: "",
      baseURI: "http://localhost:8085/BD/api/projects/",
      baseUploadURI: "http://localhost:8085/BD/upload"
    };
  },
  mounted: function () {
    if (localStorage.getItem("user")) {
      this.logged = true;
    }
  },
  methods: {
    handleFileUpload(id, update) {

      this.file = this.$refs.file.files[0];

      let obj = {
        resource: "user",
        id: id,
      };
      let json = JSON.stringify(obj);

      let form = new FormData();
      form.append("obj", json);
      form.append("file", this.file);

      this.$http
        .post(this.baseUploadURI, form, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((result) => {
          console.log(result);
        });
        this.clearInput();
    },
    postRegisterProject: function () {
      if(this.titulo != "" && this.descricao != "" && this.palavras_chaves != "" && this.tipo != "" && 
      document.getElementById("file") != null){
      var jsonUser = localStorage.getItem('user');
      var user = JSON.parse(jsonUser);

      let obj = {
        user_id: user.id,
        titulo: this.titulo,
        descricao: this.descricao,
        palavras_chaves: this.palavras_chaves,
        tipo: this.tipo,
      };
      this.$http.post(this.baseURI, obj).then((result) => {
        this.projects = result.data;
        this.handleFileUpload(this.projects.id);
              // location.reload();
              alert("Projeto cadastrado!!")
      });
      }
      else
      alert("Verifique se todos os campos estão preenchidos!!")
     },
     clearInput: function(){
       document.getElementById("palavrasChaves").value = "";
       document.getElementById("descricao").value = "";
       document.getElementById("file").value = null;
       document.getElementById("titulo").value = "";
     },
      
  },
  components: {
    NavBar,
    NavBarLog,
  },
};
</script>

<style>
#title{
  margin-top: 5%;
}

.titulo_cp {
  width: 100%;
}
.top_cp{
  width: 100%;
  background-color: cornflowerblue;
  color: white;
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
  padding-top: 1%;
  padding-bottom: 1%;
}
.ficheiro_cp {
  width: 30%;
}
</style>


