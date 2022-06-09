<template>
  <iframe id="map-iframe" class="map-iframe" src="http://localhost:1234/"></iframe>
</template>

<script>
export default {
  props: ['track'],
  watch: {
    track(newTrack, oldTrack) {
      document.getElementById("map-iframe").contentWindow.postMessage('data-url', `http://localhost:8080/api/track/${newTrack.id}/geoJson`)
    }
  }
}


</script>

<style scoped>

</style>