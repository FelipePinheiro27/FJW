<template>
  <div class="container">
    <div class="top_cp container" id="dar_margem">
          <br />
          
          <div id="logo_ed">
          <h2  class="text-center" >
            Preencha os Dados Abaixo Para Atualizar seu Projeto
          </h2>
          
          <br />
          </div>
        </div>

    <br />
          <form action="">
        <div>
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
    />
    </div>
    <br /><br />

    <button type="button" id="editar" class="btn butoes_cp btn-primary" @click="putProject">
      Editar
    </button>

    <button type="reset" id="clear" class="btn butoes_cp btn-danger">
      Limpar
    </button>
    </form>
  </div>
</template>

<script>
export default {
  name: "ProjectEdit",

  data: function () {
    return {
      id: "",
      titulo: "",
      descricao: "",
      palavras_chaves: "",
      user_id: "",
      tipo: "",
      projeto: {},
      // projects: [],
      baseURI: "http://localhost:8086/api/projects",
    };
  },
      created: function () {
            var strObj = localStorage.getItem("id_projeto");

    // var myObj = JSON.parse(strObj); 
    // this.id = myObj.id_projeto;
    //   alert(localStorage.getItem(this.id))
    this.$http.get(this.baseURI + "/" + localStorage.getItem("id_projeto")).then((result) => {
      // alert("Dps")
      this.projeto = result.data;
            console.log(this.projeto)
    });

},
  methods: {
    ///Tipo e user_id estão sendo pegos de forma estática, no PUT todos os campos devem ser passados
    ///Na hora de fazer a página de modificação nenhum campo pode fica em branco, todos devem ser preenchidos
    ///Se não está errado, e na hora da modificação dá erro.
    putProject: function () {
      var jsonUser = this.$session.get("user");
        var user = JSON.parse(jsonUser);
        this.user_id = user.id;
      let obj = {
        user_id: this.user_id,
        titulo: this.titulo,
        descricao: this.descricao,
        palavras_chaves: this.palavras_chaves,
        tipo: this.tipo,
      };
      this.$http
        .put(this.baseURI + "/" + localStorage.getItem("id_projeto"), 
        {
          user_id: this.projeto.user_id,
          titulo: this.projeto.titulo,
          descricao: this.projeto.descricao,
          palavras_chaves: this.projeto.palavras_chaves,
          tipo: this.projeto.tipo,
        }
        )
        .then((result) => {
          // this.$router.push({ name: "Projects" });
          this.projeto = result.data;
          alert("Projeto atualizado!!")
        });
    },
  },
};
</script>

<style>
#logo_ed {
  padding-top: 1%;
  padding-bottom: 1%;
}
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

#dar_margem{
  margin-top: 2%;
}
</style>
