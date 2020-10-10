<template>
  <div>
    <h3>Login:</h3>
    <input type="text" name="" id="" v-model="login" /><br />
    <h3>Password:</h3>
    <input type="password" name="" id="" v-model="password" /><br /><br />
    <button @click="insertUser">Insert</button><br />
  </div>
</template>

<script>
export default {
  name: "UserInsert",
  data: function() {
    return {
      login: "",  
      password: "",
      baseURI: "http://localhost:8080/projeto/api/users",
    };
  },
  methods: {
    insertUser: function() {
      let obj = {
        login: this.login,
        password: this.password,
      };

      this.$http.post(this.baseURI, obj).then((result) => {
        if (result.data != "") {
          this.$router.push({ name: 'Users'});
        } 
      });
    },
  },
};
</script>

<style></style>
