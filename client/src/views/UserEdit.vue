<template>
  <div>
    <h3>Login:</h3>
    <input type="text" name="" id="" v-model="user.login" /><br />
    <h3>Password:</h3>
    <input type="password" name="" id="" v-model="user.password" /><br />
    <h3>Instituicao:</h3>
    <input type="text" name="" id="" v-model="user.instituicao" /><br /><br />
    <h3>Curso:</h3>
    <input type="text" name="" id="" v-model="user.curso" /><br /><br />
    <button @click="editRegister">Edit</button><br />
  </div>
</template>

<script>
export default {
  name: "UserEdit",
  props: ["id"],
  data: function() {
    return {
      user: {},
      baseURI: "http://localhost:8080/api/users",
    };
  },
  created: function() {
    alert(this.id);
    this.$http
      .get(this.baseURI + "/" + this.id)
      .then((result) => {
        this.user = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
      console.log(this.user)
  },
  methods: {
    editRegister: function() {
      let obj = {
        login: this.user.login,
        password: this.user.password,
        instituicao: this.user.instituicao,
        curso: this.user.curso
      };

      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
        this.$router.push({ name: 'Users'});
      });
    },
  },
};
</script>

<style></style>
