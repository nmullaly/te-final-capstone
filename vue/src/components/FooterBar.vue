<template>
    <footer class="footyboi">
        <h1 id = "logo">Call of Movie</h1>
        <h2>Copyright 2024</h2>
        <h3>About Us</h3>
    </footer> 
</template>

<style>
.footyboi {
  display: flex;
  flex-direction: row; /* Make the children stack vertically */
  justify-content: center; /* Center vertically */
  align-items: center; /* Center horizontally */
  background-color: #DC8A8A;
  background: linear-gradient(to bottom, #f72a06, #DC8A8A);
  /* border: 2px solid #000000; */
  font-size: medium;
}
.footyboi > * {
  font-size: 16px; /* Adjust the font size as needed */
  flex-grow: 1;
  justify-content: center; 
  text-align: center;
}
h1{
  color:aliceblue
}

h2{
  color:aliceblue
}

h3{
  color:aliceblue
}
</style>