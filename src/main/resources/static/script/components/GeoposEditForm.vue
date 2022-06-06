<template>
  <v-form>
    <v-container>
      <v-row>
        <v-col md="2"><v-text-field v-model="lat" label="latitude"></v-text-field> </v-col>
        <v-col md="2"><v-text-field v-model="lon" label="longitude"></v-text-field></v-col>
        <v-col><v-btn color="secondary" @click="addGeoPoint">add</v-btn></v-col>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
export default {
  props: ['geo_points', 'track'],
  data: function () {
    return {
      lat: '',
      lon: '',
      enabled: true
    }
  },
    methods: {
      addGeoPoint() {
        const pointData = {lat: this.lat, lon: this.lon, created: new Date(), track: {id: this.track.id}};
        //this.enabled = false;
        this.$resource("/api/point{/id}").save({}, pointData).then(
            result => {
              result.json().then(data => {

                this.geo_points.push(data);
                this.lat = '';
                this.lon = '';
                
                //this.enabled = true;
              })
            }

        );
      }
    }
}


</script>

<style>



</style>