<template>
  <div>
    <div>
      <NavBar />
    </div>
    <div class="container">
      <div class="top_cp">
        <br />
        <h2 class="text-center">
          Projetos desenvolvidos na faculdades de Crateús
        </h2>
      </div>

      <div class="left">
        
      </div>
          <form>
              <div class="form-group">
                <label for="#">Autor:</label>
                <input type="email" class="form-control" id="autor" placeholder="Digite um nome...">
              </div>
            <div class="form-group">
              <label for="#">Área do Projeto:</label>
              <select class="form-control" id="area">
                <option>Ciência da Computação</option>
                <option>Matemática</option>
                <option>Enfermagem</option>
                <option>Engenharia Civil</option>
                <option>Psicologia</option>
                <option>Física</option>
                <option>Engenharia de Minas</option>
              </select>

            </div>
            <div class="form-group">
              <label for="#">Tipo do Projeto:</label>
              <select class="form-control" id="tipo">
                <option>Extensão</option>
                <option>BIA</option>
                <option>TCC</option>
                <option>PIBIC</option>
              </select>
            </div>
          </form>

      







      <br /><br />
      <br />
      <div class="text-center">
        <div class="btn-buscar">
          <button class="btn btn-primary">Consultar</button>
        </div>
        <div class="btn-limpar">
          <button type="reset" class="btn btn-danger">Limpar</button>
        </div>
      </div>
    </div>

    <table class="table table table-bordered">
        <thead>
          <tr class="bg-primary">
            <th scope="col">#</th>
            <th scope="col">Área do Projeto</th>
            <th scope="col">Tipo do Proejto</th>
            <th scope="col">Autor</th>
          </tr>
        </thead>

        <tbody>
          <tr class="table-light">
             <th scope="row">1</th>
            <td>Ciência da Computação</td>
            <td>BIA</td>
            <td>Jean Camelo</td>
          </tr>
          
          <tr class="table-light">
            <th scope="row">2</th>
            <td>Ciência da Computação</td>
            <td>Extensão</td>
            <td>Adalberto Felipe</td>
          </tr>
          <tr class="table-light">
            <th scope="row">3</th>
            <td>Ciência da Computação</td>
            <td>BIA</td>
            <td>Wallysom Lopes</td>
          </tr>
        </tbody>
    </table>
  </div>
</template>



<script>

import NavBar from "./NavBar";

export default {
  name: "BuscarProjetos",
  components: {
    NavBar,
  },
  data() {
    return {};
  },
};
</script>

<style>
.container {
  background-color: white;
}
table {
  margin-left: 5vw;
  margin-top: 5%;
}

.btn-buscar, .btn-limpar {
  display: inline-block;
  margin-right: 1%;
  margin-bottom: 2%;
}
</style>