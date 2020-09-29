<template>
  <div>
    <div>
        <NavBar/>
    </div>
    <div class="text-left alinhamento form-group">
      <form class="" action="">
        <div class="top">
          <br>
          <h2 class="text-center">
            Projetos Desenvolvidos nas Faculdades Públicas
          </h2>
        </div>
        <div class="padding">
          <div class="form-control">
            <label>Tipo de Projeto:</label>
            <select name="projetos" id="opc" class="form-control">
              <option value="ext"></option>
              <option value="ext">Projeto de Extensão</option>
              <option value="TCC">TCC</option>
              <option value="BIA">BIA</option>
              <option value="BIA">NPDS</option>
              <option value="BIA">PIBID</option>
              <option value="BIA">PIBIC</option>
            </select>
          </div>


          <div class="form-control">
            <label>Instituição Promotora:</label>
            <select name="projetos" id="opc" class="form-control">
              <option value="ext"></option>
              <option value="ext">(UFC) Universidade Federal do Ceará</option>
              <option value="TCC">(UECE) Universidade Estadual do Ceaŕa</option>
              <option value="BIA">(IFCE) Instituto Federal do Ceará</option>
            </select>
          </div>


          <div class="form-control">
            <label>Área de Atuação:</label>
            <select name="projetos" id="opc" class="form-control">
              <option value="ext"></option>
              <option value="ext">Biologia</option>
              <option value="ext">Ciências da Computação</option>
              <option value="TCC">Engenharia Ambiental</option>
              <option value="BIA">Engenharia Civil</option>
              <option value="BIA">Engenharia de Minas</option>
              <option value="BIA">Física</option>
              <option value="BIA">Letras</option>
              <option value="BIA">Matemática</option>
              <option value="BIA">Química</option>
              <option value="BIA">Sistemas de Informação</option>
            </select>
          </div>
        </div>
        <br /><br />
        <div class="text-center">
          <div class="btn-buscar">
            <button class="btn btn-primary">Buscar</button>
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
  name: 'ProcurarProjeto',
  components: {
    NavBar,
  }
}
</script>

<style>
#first {
  margin-left: 65%;
}
.container {
  background-color: white;
}
.form-control {
  padding: 1%;
  width: 95%;
}
.top {
  width: 95%;
  padding-bottom: 2%;
  padding-right: 5%;
  
}
.card {
  color: white;
  background-color: cornflowerblue;
}
.btn-buscar,
.btn-limpar {
  display: inline-block;
  margin-right: 1%;
  margin-bottom: 2%;
}

</style>