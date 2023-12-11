<template>
  <div>
    <form v-on:submit.prevent="createReview">
      <!-- <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div> -->
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.headline" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 popcorn</option>
          <option value="2">2 popcorns</option>
          <option value="3">3 popcorns</option>
          <option value="4">4 popcorns</option>
          <option value="5">5 popcorns</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.body"></textarea>
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click="redirectToMovieView" />
    </form>
  </div>
</template>

<script>
import ReviewService from '../services/ReviewService';

export default {
  data() {
    return {
      newReview: {
        profileId: this.$store.state.user.id,
        movieId: this.$route.params.id,
        headline: '',
        rating: 1, // Default
        body: ''
      }
    };
  },
  methods: {
    createReview() {
      ReviewService.createReview(this.newReview)
        .then(response => {
          if (response.status == 200) {
            console.log('Success')
          }})
      this.redirectToMovieView();
      // this.resetForm();
    },
    redirectToMovieView() {
      this.$router.push({name: 'Movie', params: { id: this.$route.params.id }});
    },
    // resetForm() {
    //   this.newReview = {
    //     // profileId: '',
    //     // movieId: '',
    //     headline: '',
    //     rating: 1,
    //     body: ''
    //   };
    // },

  },
}

</script>

<style scoped>
.form-element {
  margin-top: 10px;
}

.form-element label {
  display: block;
}

.form-element input,
.form-element select {
  height: 30px;
  width: 300px;
}

.form-element textarea {
  height: 60px;
  width: 300px;
}

form input[type=button] {
  width: 100px;
}

form input[type=submit] {
  width: 100px;
  margin-right: 10px;
}
</style>
