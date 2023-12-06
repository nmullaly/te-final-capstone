<template>
    <div class="search-bar">
      <input type="text" v-model="input" placeholder="search..." />
      <button v-on:click="searchUsers">Search Users</button>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        input: ''
      };
    },
    methods: {
      searchUsers() {
        let userId = this.input.trim();
        if (userId !== '') {
          this.$router.push({ name: 'ProfileView', params: { id: userId } });
        }
      }
    }
  }
  </script>
  
  <style>
  .search-bar {
    display: flex;
    margin-top: 20px; 
    align-items: center;
    justify-content: center;
    margin-bottom: 20px;
    font-family: 'Courier New', Courier, monospace;
  }
  
  .search-bar input {
    padding: 5px;
    margin-right: 5px;
    font-family: 'Courier New', Courier, monospace;
  }
  
  .search-bar button {
    padding: 5px 10px;
  }
  </style>
  