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
			<h2 id="reviewTitle">{{ this.review.headline }}</h2>
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
	background-color: whitesmoke;
	margin-right:60vw;
	border-radius: 5px;
	text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.1);
}


h2{
  font-size: 20px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  align-items: flex-end;
  border-radius: 1px black;
  z-index: 1;
  
}
#username{
	margin-right: auto;
	color:black;
}
/* #reviewTitle{
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  margin-bottom: 15px;
  color:black;
  font-size: 15px;
} */
#reviewText{
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  color:black;
}
#movieTitle{
	color:black;
	font-weight: bold;
	padding-top:5px;
}

#ReviewMetaData {
  border-bottom: 2px solid black;
  margin-right: 0;
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
	margin-left: 10px;
	margin-top: 8px;
}
#reviewText {
  text-indent: 20px;
  text-align: left;
	padding-bottom: 15px;
}


</style>