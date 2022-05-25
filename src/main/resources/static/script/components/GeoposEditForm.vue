<template>
  <div :class="enabled?'':'elem-disabled'">
     <input  name="lat" v-model="lat" type="text" size="20" autocomplete="off" placeholder="latitude"/>
      <input name="lon" v-model="lon" type="text" size="20" autocomplete="off" placeholder="longitude"/>
      <button @click="addGeoPoint">add</button>
  </div>

</template>

<script>
export default {
  props: {geo_points:{}},
  data: function () {
    return {
      lat: '',
      lon: '',
      enabled: true
    }
  },
    methods: {
      addGeoPoint() {
        const pointData = {lat: this.lat, lon: this.lon, created: new Date()};
        this.enabled = false;
        this.$resource("/api/geo{/id}").save({}, pointData).then(
            result => {
              result.json().then(data => {

                this.geo_points.push(data);
                this.lat = '';
                this.lon = '';
                this.enabled = true;
              })
            }

        );
      }
    }
}


</script>

<style>


</style>