<!-- This component has a bunch of users now for simplicity but in the future should be a template with just one -->
<template>
    <div>
        <div id="holdThisBox">
        <img src = "../assets/AntMan.jpg" id = "user1" class="userCard"/>
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