<template>
  <header class = "header" id = "header">
    <header-bar/></header>
  <div id="curtains-container">
<img src="../assets/redcurtains.png" alt ="Red Curtains" />
  </div>
    
    <div id="login">
      <form v-on:submit.prevent="login">
        
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
  
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <form v-on:submit.prevent="login">
    <button type="submit">Sign in</button>
  </form>
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
  <footer-bar/>
</template>

<script>
import authService from "../services/AuthService";
import HeaderBar from "../components/HeaderBar.vue";
import FooterBar from "../components/FooterBar.vue";

export default {
  components: {
    HeaderBar,
    FooterBar,
  },
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$store.commit("GET_WATCHLIST");
            this.$router.push({ name: 'home' });
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style>
#curtains-container{
  position: relative;
}
#curtains-container img {
width: 100%;
height: auto;
}
label {
  
  color: white;
}
html > body {
 background-color: black;
  font-style: courier-new;
  text-align: center;
  
}
button {
  color: black;
}
.form-input-group {
/* font-family:'Courier New', Courier, monospace; */
font-size: 20px;
}
#login {
  position: absolute;
  top: 70%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 1; 
  text-align: center; 
  color: white; 
}
router-link{
  color: white;
}
</style>