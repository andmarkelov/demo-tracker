<template>
  <v-app>
    <router-view></router-view>
  </v-app>

</template>

<script>

  export default {

  }
</script>

<style>
.map-iframe {
  border: 0;
  height: 100%;
  width: 100%;
  background-color: gainsboro;
}

/*.geotable td:hover {*/
/*    background: rgba(0, 255, 0, 0.05);*/
/*}*/

.geotable td {
  padding: 5px;
}

.geodiv:hover {
  background: rgba(0, 0, 0, 0.05);
}

.geodiv {
  border-radius: 5px;
}

.elem-disabled {
  pointer-events: none
}
</style>