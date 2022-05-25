<template>
  <table class="geotable">
    <geopos-item v-for="item in items" :key="item.id" :data="item"/>
  </table>
</template>

<script>
import GeoposItem from "components/GeoposItem.vue";

//var pointRepo = Vue.resource("/api/geo{/id}");


export default {
  props: ['items'],
  components: {
    GeoposItem
  },
  created() {
    this.$resource("/api/geo{/id}").get().then(
        result => result.json().then(
            data => data.forEach(
                point => this.items.push(point)
            )
        )
    )
  }


}
</script>

<style>


</style>