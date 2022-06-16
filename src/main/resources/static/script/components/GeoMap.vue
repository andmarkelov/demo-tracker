<template>

    <iframe id="map-iframe" class="map-iframe" src="http://localhost:1234"> </iframe>

<!--     <div style="position: absolute"> <v-text-field-->
<!--          hide-details-->
<!--          prepend-icon="mdi-magnify"-->
<!--          single-line-->
<!--      ></v-text-field></div>-->


</template>



<script>
export default {
  props: ['track'],
  watch: {
    async track(newTrack, oldTrack) {
      const response = await fetch(`http://localhost:8080/api/track/${newTrack.id}/geoJson`);
      response.json().then(function (result) {
        document.getElementById("map-iframe").contentWindow
            .postMessage({geo: result.routes[0].geometry}, '*');
      });

    }
  }
}


</script>

<style scoped>

</style>