<template>
  <div>
    <h3>Login:</h3>
    <input type="text" name="" id="" v-model="user.login" /><br />
    <h3>Password:</h3>
    <input type="password" name="" id="" v-model="user.password" /><br /><br />
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
      baseURI: "http://localhost:8080/projeto/api/users",
    };
  },
  created: function() {
    this.$http
      .get(this.baseURI + "/" + this.id)
      .then((result) => {
        this.user = result.data;
      })
      .catch(function(error) {
        console.log(error);
      });
  },
  methods: {
    editRegister: function() {
      let obj = {
        login: this.user.login,
        password: this.user.password,
      };

      this.$http.put(this.baseURI + "/" + this.id, obj).then((result) => {
        this.$router.push({ name: 'Users'});
      });
    },
  },
};
</script>

<style></style>
