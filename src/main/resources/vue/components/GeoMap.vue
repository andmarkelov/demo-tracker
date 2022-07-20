<template>
    <iframe id="map-iframe" class="map-iframe" src="/map/index.html"> </iframe>
</template>

<script>
export default {
  props: ['track'],
  watch: {
    async track(newTrack, oldTrack) {
      const response = await fetch(`/api/track/${newTrack.id}/geoJson`);
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