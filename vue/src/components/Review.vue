<template>
	<div id="review">
		<div id="header">
			<h2 id="movieTitle">{{ this.review.movieName }}</h2>
			<h2 id="username">{{ this.review.username }}</h2>
			<div id="rating">
				<img class="popcorn" src="../assets/Popcorn.svg.png" v-for="num in this.review.rating" v-bind:key="num" />
			</div>
		</div>
		<div id="body">
			<h3 id="reviewTitle">{{ this.review.headline }}</h3>
			<p id="reviewText">{{ this.review.body }}</p>
		</div>
	</div>
</template>

<script>
import MovieService from '../services/MovieService';
import ProfileService from '../services/ProfileService';


export default {

	props: ['review'],

}

</script>

<style>
	.popcorn {
		height: 20px;
	}

	h1 {
		font-weight: normal;
	}
</style>