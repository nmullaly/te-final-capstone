<template>
	<div>
		<header-bar />
		<profile />
		<footer-bar />
	</div>
</template>

<script>
import Profile from '../components/Profile.vue';
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';

export default {
	components: {
		Profile,
		HeaderBar,
		FooterBar
	}
}

</script>

<style>

</style>