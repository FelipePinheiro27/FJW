<template>
  <div>
    <button @click="$router.push({ name: 'SignUp' })">Insert</button>

    <ul>
      <li v-for="user in users" :key="user.id">
        <div id="geral">
          <div class="left">
            <h4>{{ user.id }}</h4>
            <p>{{ user.login }}</p>
            <p>{{ user.password }}</p>
            <p>{{ user.instituicao }}</p>
            <p>{{ user.curso }}</p>
          </div>
          <div class="right">
            <button
              @click="
                $router.push({ name: 'UserEdit', params: { id: user.id } })
              "
            >
              Update
            </button>
            <button @click="deleteUserById(user.id)">Delete</button>
          </div>
        </div>
        <hr />
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "Users",
  data() {
    return {
      users: [],
      baseURI: "http://localhost:8086/api/users",
    };
  },
  created: function () {
    this.getAll();
  },
  methods: {
    getAll: function () {
      this.$http.get(this.baseURI).then((result) => {
        this.users = result.data;
      });
    },
    deleteUserById: function (id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        this.getAll();
      });
    },
  },
};
</script>

<style>
#geral {
  margin: 0;
}
.left {
  float: left;
  width: 75%;
}
.right {
  float: left;
  width: 25%;
}

hr {
  width: 100%;
}
</style>
