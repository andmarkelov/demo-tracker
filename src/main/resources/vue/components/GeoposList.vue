<template>
  <table class="geotable">
    <geopos-item v-for="item in items" :key="item.id" :data="item"/>
  </table>
</template>

<script>
import GeoposItem from "components/GeoposItem.vue";

export default {
  props: ['track'],
  components: {
    GeoposItem
  },
  data() {
    return {
      items:''
    }
  },
  watch: {

      track(newTrack, oldTrack) {
        this.items = []
        this.$resource("/api/track/{track_id}/point").get({track_id: newTrack.id}).then(
            result => result.json().then(
                data => data.forEach(
                    point => this.items.push(point)
                )
            )
        )
      }
  }
}
</script>

<style>


</style>