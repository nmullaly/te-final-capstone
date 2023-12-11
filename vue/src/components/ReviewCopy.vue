<template>
	<div id="reviewBoxGottaHaveBetterVariableNames">
		<div id="ReviewMetaData">
			<h1 id="movieTitle">{{this.review.title}}</h1>
				<div id="usernameAndRating">
					<h2 id="username">{{ this.review.username }}</h2>
					<div id="rating">
						<img class="popcorn" src="../assets/Popcorn.svg.png" v-for="num in this.review.rating" v-bind:key="num" />
					</div>
				</div>
		</div>
		<div id="ReviewContent">
			<h3 id="reviewTitle">{{ this.review.headline }}</h3>
			<p id="reviewText">{{ this.review.body }}</p>
		</div>
	</div>
</template>

<script>
import MovieService from '../services/MovieService';
import ProfileService from '../services/ProfileService';


export default {
	data() {
      return {
        review: {
            title: 'The Santa Clauses',
			username:'Tim Heidecker',
			rating: 5,
            headline: 'Directed by Jason Weiner, starring Time Alien',
			body: 'Im giving The Santa Clauses 5 bags of popcorn and a little christmas tree.  Gregg Turkington has no opinion on The Santa Clauses and is officially cedeing his role as an expert on film and movies and television here today and I dont understand what youre doing here if youre not going to give the time of day to the Santa Clauses.  Time Alien deserves to be reviewed.'
        },
      };
	}
}

</script>

<style>
#reviewBoxGottaHaveBetterVariableNames{
	background-color: #E9CBCB;
	margin-right:60vw;
}
#usernameAndRating{
  font-size: 15px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  align-items: center;
  border-radius: 1px black;
  z-index: 1;
}
#username{
	margin-right: auto;
	color:black;
}
#reviewTitle{
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  margin-bottom: 15px;
  color:black;
}
#reviewText{
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  color:black;
}
#movieTitle{
	color:black;
}
#reviewContent{
	background-color: rgba(128, 128, 128, 0.35);
	z-index: 1;
}
.popcorn {
	height: 20px;
}

h1 {
	font-weight: normal;
}


</style>