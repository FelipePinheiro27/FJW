<template>
  <div class="home">
    <div>
      <ul>
        <li v-for="user in users" :key="user.id">
          <h4>{{ user.id }}</h4>
          <p>{{ user.login }}</p>
          <p>{{ user.password }}</p>
          <p>{{ user.instituicao }}</p>
          <p>{{ user.curso }}</p>
          <hr />
        </li>
      </ul>
    </div>
    <div>
      <ul>
        <li v-for="projeto in projects" :key="projeto.id">
          <h4>{{ "ProjetoID" + projeto.id }}</h4>
          <p>{{ projeto.login }}</p>
          <hr />
        </li>
      </ul>
    </div>
      File: <input type="file" id="file" ref="file" name="image">

      <img v-if="id" width="500" height="300" :src="'uploads/user/' + id">
  </div>

</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      file: null,
      users: [],
      projects: [],
      baseURI: "http://localhost:8085/BD/api/users",
      baseUploadURI: "http://localhost:8085/BD/upload"
    };
  },
  created: function () {
    this.$http.get(this.baseURI).then((result) => {
      this.users = result.data;
      console.log(result.data);
    });
  },
  methods:{
    handleFileUpload(id) {
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
    },
  }
};  
</script>
