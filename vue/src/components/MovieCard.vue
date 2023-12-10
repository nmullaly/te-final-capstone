<template>
    <div>
        <div id="holdThisBox">
            <img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + this.movie.poster_path" v-on:click="routeToMovie" id = "movie1" class="movieCard"/>
            <form id = "reviewUnique">
      <div class="form-element">
        <!-- <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 popcorns</option>
          <option value="2">2 popcorns</option>
          <option value="3">3 popcorns</option>
          <option value="4">4 popcorns</option>
          <option value="5">5 popcorns</option>
        </select>

        Gotta Prevent refresh -->

        <div class="rating-buttons">
          <button v-for="num in 5" :key="num" @click="setRating(num)"></button>
          <img
        src="../assets/Popcorn.svg.png" alt="Popcorn" class="popcorn-icon" :class="{ 'selected': newReview.rating === num }" />
        </div>
      </div>
      <!-- <div class="form-element">
        <label for="review">Review:</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <input type="submit" value="Save" />
      <input type="button" value="Cancel" v-on:click="resetForm" /> -->
    </form>
          </div>
    </div>
</template>

<script>
import movieService from "../services/MovieService.js";
import reviewService from "../services/ReviewService.js";
import ProfileService from "../services/ProfileService.js";

export default {
    data() {
    return {
      movie: {},
      newReview: {},
    };
  },

created() {
    this.fetchMovie();
    },

    
methods: {
  generateRandomMovie(){
		let validIds = [649006,2,3,5,6,8,11,12,13,14,15,16,17,18,19,20,21,22,24,25,26,27,28,33,35,38,55,58,59,62,63,64,65,66,67,68,69,70,71,73,74,75,76,77,78,79,80,81,82,83,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,109,110,111,112,113,114,115,116,117,118,120,121,122,123,124,125,126,127,128,129,132,133,134,135,137,138,139,140,141,142,143,144,145,146,147,148,149,150,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,182,183,184,185,186,187,189,191,192,193,194,195,196,197,198,199,200,201,203,204,205,206,207,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,265,266,267,268,269,270,271,272,273,275,276,277,278,279,280,281,284,285,286,287,288,289,290,291,293,294,296,297,298,299,300,301,302,303,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,326,327,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,363,364,377,378,379,380,381,383,387,388,389,390,391,393,387,388,389,390,391,392,393,395,396,397,398,400,401,402,403,404,405,406,407,408,409,410,411,412,414,419,421,422,423,424,425,426,427,428,429,430,431,433,434,435,436,437,438,439,440,441,442,445,446,451,453,454,455,462,464,465,466,467,468,469,470,471,473,475,476,179,480,481,482,483,489,490,492,493,496,497,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,521,522,523,524,525,526,527,530,531,532,533,534,535,901362,102899,166424,299536,284054,118340,332562,17473,327363,36685,24032,578,49051,76600,40016,438631,569094,634649,537116,109445,37724,424694,614939,593643,546554,661374,26914,197599,475557,872585,346698,787699,458723,419430,359940,405774,447332,333339,268896,338970,495507,14164,10196,536869,181812,502356,9607,27296,576845,398181,548473,286217,150540,177572,2062,545611,245891,603,27205,11324,106646,68718,512195,612502,370567,431580,420809,102651,157350,262500,262504,131634,1053110,427641,399566,791373,464052,1001835,37169,295693,324852,526896,675353,438148,453395,10193,325712,116977,142709,489985,270303,72331,536554,619778,124532,8327,424277,298014,579974];
		let movieId = validIds[Math.floor(Math.random() * validIds.length)];
		return movieId;
	},

  
  addNewReview() {
      this.$store.commit('ADD_REVIEW', this.newReview);
      this.resetForm();
  },
   
  resetForm() {
      this.showForm = false;
      this.newReview = {};
  },
  
  fetchMovie() {
      let movieId = this.generateRandomMovie();
      movieService
        .getMovieById(movieId)
        .then((response) => {
          this.movie = response.data;
        })
        .catch((error) => {
          if (error.response) {
            console.log(error.response.status);
          } else if (error.request) {
            console.log("Server error");
          } else {
            console.log("Front-end error");
          }
        })},
        routeToMovie() {
        let movieId = this.movie.id;
          this.$router.push({ name: 'Movie', params: { id: movieId } });
        },
        generateRandom(){
        movieService.generateRandomMovie;
        }
      }
}

</script>

<style>
#holdThisBox{
    display: flex;
    justify-content: center;
    flex-direction: column;
}
.movieCard{
    margin-left: 10px;
    margin-right: 10px;
    border: 1px solid #CBD1DA;
    border-radius: 4px;
    height: 350px;
    width: auto;
    cursor: url("../assets/hm3.jpg"), pointer;
}
.popcorn-icon {
  width: 20px; /* Adjust the width as needed */
  height: auto;
}

.rating-buttons {
  display: flex;
}

.rating-buttons button {
  background-color: transparent;
  border: none;
  padding: 5px 10px;
  margin-right: 5px;
  cursor: pointer;
}
.rating-buttons button.selected {
  background-color: #007BFF; /* Change to your desired selected color */
  color: white;
}

#holdThisBox:hover #reviewUnique {
    display: block;
}

#reviewUnique {
    display: none;
}
#holdThisBox:hover {
    outline: 3px solid whitesmoke;
    transform: scale(1.03);
}
</style>
