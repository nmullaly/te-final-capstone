<template>
	<div id="reviewBoxGottaHaveBetterVariableNames">
		<div id="ReviewMetaData">
			<h1 id="movieTitleTwo">{{ this.review.headline }}</h1>
				<div id="usernameAndRating">
					<h2 id="username" class="EBoog" v-on:click="routeToUser">{{ this.review.username }}</h2>
					<div id="rating">
						<span class="popcorn" v-for="num in this.review.rating" v-bind:key="num">&#127871;</span>
					</div>
				</div>
		</div>
		<div id="ReviewContent" >
			<h2 id="reviewTitle" class="EBoog" v-on:click="routeToMovie"> {{this.review.title}} </h2>
			<p id="reviewText">{{ this.review.body }}</p>
		</div>
	</div>
</template>

<script>
import MovieService from '../services/MovieService';
import ProfileService from '../services/ProfileService';


export default {

props: ['review'],
methods:{
routeToMovie() {
      let movieId = this.review.movieId;
      this.$router.push({ name: "Movie", params: { id: movieId } });
    },
routeToUser() {
		let userID = this.review.profileId;
		this.$router.push({ name: "ProfileView", params: { id: userID } });
}
}
// data() {
//     return {
//       review: {
// 		title: "movie title",
// 		username: "tim Heidecker",
// 		rating: 5,
// 		headline: "I love the movies",
// 		body: "These are great movies",
// 	  }
// }
// }
}

</script>

<style>
#reviewBoxGottaHaveBetterVariableNames{
	background-color: #A0A59B;
	border-radius: 5px;
	text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.1);
	width: 500px;
	height:auto;
	border: 2px solid black;
}
.Eboog{
  font-size: 20px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  align-items: flex-end;
  border-radius: 1px black;
  z-index: 1;
  
}
#usernameAndRating{
	display: flex;
	align-items: center;
	margin-right: 0;
}
#username{
	margin-right: auto;
	color:white;
	text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);
}
#reviewText{
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  color:white;
}
#movieTitleTwo{
	color:white;
	text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.83);
	font-weight: bold;
	padding-top:5px;
}
#ReviewMetaData {
  border-bottom: 1px solid black;
  margin-right: 0;
  margin-left: 0;;
}
#rating{
	background-color: #E9CBCB;
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
	border: 1px solid black;
	margin-right: 0;
	border-right: 0;
	padding-right: 0;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
}
.popcorn {
	height: 20px;
}
#reviewContent{
	background-color: #E9CBCB;
}
#reviewTitle{
	display:flex;
	margin-left: 5px;
	margin-top: 8px;
	color:white;
	text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);
}
#reviewText {
  text-indent: 20px;
  text-align: left;
	padding-bottom: 15px;
	color:white;
	text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.50);
}
</style>