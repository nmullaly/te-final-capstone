<!-- This component has a bunch of users now for simplicity but in the future should be a template with just one -->
<template>
    <div>
        <div id="holdThisBox">
        <img src = "../assets/AntMan.jpg" id = "user1" class="userCard"/>
        <img src = "../assets/FantasticFour.jpg" id = "user2" class="userCard"/>
        <img src = "../assets/OhGod.jpg" id = "user3" class="userCard"/>
        <img src = "../assets/StarTrek4.jpg" id = "user4" class="userCard"/>
        <img src = "../assets/theHobbit.jpg" id = "user5" class="userCard"/>
        <img src = "../assets/SherlockGnomes.jpg" id = "user6" class="userCard"/>
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
.userCard{
    margin-left: 10px;
    margin-right: 10px;
    border: 1px solid #CBD1DA;
    border-radius: 50%;
}
</style>
