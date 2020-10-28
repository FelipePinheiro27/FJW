<template>
  <div id="container">
    <nav class="navbar navbar-dark bg-dark">
      <router-link to="/index">
        <a class="navbar-brand h3 mb-0" id="home"
          ><h3 class="logo">DivPro</h3></a
        >
      </router-link>

      <h5>Meus Projetos</h5>
    </nav>

    <table class="table table-hover table-light">
      <thead>
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Título</th>
          <th scope="col">Descrição</th>
          <th scope="col">Tipo</th>
          <th scope="col">Autor</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>############</td>
          <td>asdasdasdasdasdasdaasdasasd</td>
          <td>TCC</td>
          <td>Jean Camelo</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>############</td>
          <td>fghfghfghfghfhgfghfghfghfgh</td>
          <td>BIA</td>
           <td>Wallysson Lopes
           </td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>############</td>
          <td>qweqweqweqweqweqweqweqweqwe</td>
          <td>PIBIC</td>
          <td>Adalberto Felipe</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
    
};
</script>

<style>
table {
  margin-top: 5%;
  margin-right: 5%;
}
h5 {
  color: white;
  margin-right: 80%;
}
#home {
  margin-left: 10%;
}

.logo {
  color: cornflowerblue;
}
</style>