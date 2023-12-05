<template>
    <div class="w-80 h-80 p-1 rounded-full ring-2 ring-gray-300 dark:ring-gray-500" id = "pfp">
        <img :src="imageSource" alt="Profile Picture" />
    </div>
</template>

<script>
export default {
  props: ['imageSource'],
};
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
#pfp{
    width:80px;
    height: 80px;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    border: 1px solid #CBD1DA;
}
</style> 