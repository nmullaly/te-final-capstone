<!-- This component has a bunch of movies now for simplicity but in the future should be a template with just one -->
<template>
    <div>
        <div id="holdThisBox">
        <img src = "../assets/AntMan.jpg" id = "movie1" class="movieCard"/>
        <img src = "../assets/FantasticFour.jpg" id = "movie2" class="movieCard"/>
        <img src = "../assets/OhGod.jpg" id = "movie3" class="movieCard"/>
        <img src = "../assets/StarTrek4.jpg" id = "movie4" class="movieCard"/>
        <img src = "../assets/theHobbit.jpg" id = "movie5" class="movieCard"/>
        <img src = "../assets/SherlockGnomes.jpg" id = "movie6" class="movieCard"/>
        </div>
    </div>
</template>

<script>
</script>

<style>
#holdThisBox{
    display: flex;
    justify-content: center;
}
.movieCard{
    margin-left: 10px;
    margin-right: 10px;
    border: 1px solid #CBD1DA;
    border-radius: 4px;
}
</style>
