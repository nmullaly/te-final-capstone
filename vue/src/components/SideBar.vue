<template>
  <div id="sidebarContainer">
    <aside class="sidebar">
      <profile v-bind:profile="this.profile" />
      <!-- <h2>{{ profile.username }}</h2>
      <p>{{ profile.bio }}</p> -->
      <!-- <h3>Favorite Movies</h3>
      <ul>
        <li v-for="(movie, index) in profile.watchlist" :key="index">
          {{ movie.title }} <span @click="removeFavorite(index)">❌</span>
        </li>
      </ul>
      <button @click="editFavorites">Edit Favorites</button> -->
      <!-- Edit Favorites Form -->
      <!-- <div v-if="isEditing">
        <label for="newFavorite">Add a new favorite:</label>
        <input v-model="newFavorite" />
        <button @click="addFavorite">Add</button>
      </div> -->
    </aside>
  </div>
</template>
  
<script>
import Profile from '../components/Profile.vue';

  export default {
    props: ['profile'],
    components: {
      Profile,
    },
    data() {
      return {
        isEditing: false,
        newFavorite: '',
      };
    },
    methods: {
      editFavorites() {
        this.isEditing = true;
      },
      // addFavorite() {
      //   // Add the new favorite to the watchlist
      //   this.profile.watchlist.push({
      //       title: this.newFavorite,
      //   });
      //   // Reset the input and hide the form
      //   this.newFavorite = '';
      //   this.isEditing = false;
      // },
      // removeFavorite(index) {
      //   // Remove the favorite at the specified index
      //   this.profile.watchlist.splice(index, 1);
      // },
    },
  };
  </script>
  
  <style>
  #sidebarContainer {
    display: grid;
    grid-template-columns: 1fr 2fr;
  }

  .sidebar {
    /* width: 100%; */
    padding: 20px;
    background: linear-gradient(to bottom, #f01607, #DC8A8A);
    /* height: 100vh; */
    width: 21.55%;
    height: 20%;
    /* margin-left: 1%; */
    border-radius: 5px;
    border-radius: 12px;
    border: 1px solid white;
    align-items: center;
    justify-content: center;
    position: fixed;
  }
  
  /* Add styling for the edit form if needed */
  .sidebar label,
  .sidebar input,
  .sidebar button {
    margin-top: 10px;
  }
  
  /* Styling for the remove (X) span */
  .sidebar span {
    cursor: pointer;
    margin-left: 5px;
  }
  </style>