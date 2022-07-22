<template>
    <iframe ref="mapIframe" class="map-iframe" src="/map/index.html"> </iframe>
</template>

<script>
export default {
  props: ['track'],
  watch: {
    async track(newTrack) {
      const response = await fetch(`/api/track/${newTrack.id}/geoJson`);
      const result = await response.json();

      this.$refs.mapIframe.contentWindow.postMessage({
        geo: result.routes[0].geometry
      }, '*');
    }
  }
}
</script>

<style scoped>
</style>