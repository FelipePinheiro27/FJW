<template>
  <div>
    <div>
      <NavBar />
    </div>
    <div class="text-left alinhamento form-group">
      <form action="">
        <div class="top">
          <br />
          <h2 class="text-center">
            Prencha os Dados Abaixo Para Cadastrar seu Projeto
          </h2>
        </div>
        <div class="padding">
          <div class="form-control">
            <label for="title">Título:</label>
            <input type="text" class="form-control" id="titulo" />
          </div>

          <div class="form-control">
            <label>Descrição:</label>
            <textarea class="form-control" id="desc"></textarea>
          </div>
          <div class="form-control">
            <label>Palavras Chaves :</label>
            <input type="text" class="form-control" id="pChaves" />
          </div>
          <div class="form-control">
            <label>Tipo de Projeto:</label>
            <select name="projetos" id="opc" class="form-control">
              <option value="ext">Projeto de Extensão</option>
              <option value="TCC">TCC</option>
              <option value="BIA">BIA</option>
              <option value="BIA">NPDS</option>
              <option value="BIA">PIBID</option>
              <option value="BIA">PIBIC</option>
            </select>
          </div>
          <div class="form-control">
            <input type="file" id="ficheiro" />
          </div>
        </div>
        <div class="text-center">
          <br><br>
          <div class="btn-buscar">
            <button class="btn btn-primary">Cadastrar</button>
          </div>
          <div class="btn-limpar">
            <button type="reset" class="btn btn-danger">Limpar</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import NavBar from "./NavBar";
export default {
  name: "CadastrarProjeto",
  components: {
    NavBar,
  },
};
</script>

<style>
#first {
  margin-left: 65%;
}

.top {
  color: white;
  width: 100%;
  background-color: cornflowerblue;
}
.form-control {
  width: 90%;
}
.btn {
  margin-top: 2%;
  margin-bottom: 2%;
}

.alinhamento {
  background-color: white;
  margin-top: 3%;
  margin-bottom: 3%;
  margin-left: 5%;
  margin-right: 5%;
}
.logo {
  color: cornflowerblue;
}
</style>


