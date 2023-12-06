<template>
    <div>
        <div id="holdThisBox">
        <user-profile-pic class = "pfp" :imageSource="userImages[0]"></user-profile-pic>
        <user-profile-pic class = "pfp" :imageSource="userImages[1]"></user-profile-pic>
        <user-profile-pic class = "pfp" :imageSource="userImages[2]"></user-profile-pic>
        <user-profile-pic class = "pfp" :imageSource="userImages[3]"></user-profile-pic>
        <user-profile-pic class = "pfp" :imageSource="userImages[4]"></user-profile-pic>
        <user-profile-pic class = "pfp" :imageSource="userImages[5]"></user-profile-pic>
        </div>
    </div>
</template>

<script>

import UserProfilePic from "../components/UserProfilePic.vue";

export default {
  components: {
    UserProfilePic,
  },
  data() {
    return {
      userImages: [
        "src/assets/Zoldo/OoS_Mittens_Sprite.png",
        "src/assets/Zoldo/55px-OoS_Cap'n_Sprite.png",
        "src/assets/Zoldo/55px-OoS_Ricky_Sprite.png",
        "src/assets/Zoldo/58px-OoS_Great_Moblin_Sprite.png",
        "src/assets/Zoldo/59px-OoS_Great_Fairy_Sprite.png",
        "src/assets/Zoldo/OoS_Golden_Sage_Sprite.png",
      ],
    };
  },
};
</script>

<style>
#holdThisBox{
    display: flex;
    justify-content: center;
}
.pfp{
    margin-left: 10px;
    margin-right: 10px;
}
</style> 