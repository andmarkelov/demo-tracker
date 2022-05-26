<template>
  <v-app>
    <div class="main-container">

      <v-toolbar style="flex:0">
        <v-toolbar-title>Points manager</v-toolbar-title>
      </v-toolbar>

      <div class="main-content">

        <div class="main-content-container" style="width:300px">
          <routes-list/>
        </div>
        <div style="display: grid;width:500px;grid-template-rows: 96px 1fr">
          <v-card>Route X<br>info</v-card>
          <div class="main-content-container">

            <geopos-edit-form :geo_points = "geo_points"/>
            <geopos-list :items = "geo_points"/>
          </div>
        </div>
        <div style="flex:1;">
          <v-container fill-height class="d-flex justify-center">
            <v-img
                lazy-src="img/map_big_icon_preview.png"
                max-height="250"
                max-width="250"
                src="img/map_big_icon_preview.png"
                style="filter: alpha(Opacity=30);opacity: 0.3"
            ></v-img>
          </v-container>
        </div>
      </div>
    </div>
    </v-app>

</template>

<script>
  import GeoposList from "components/GeoposList.vue";
  import GeoposEditForm from "components/GeoposEditForm.vue";
  import RoutesList from "components/RoutesList.vue";

  export default {
    components: {
      RoutesList,
      GeoposList,
      GeoposEditForm
    },
    data() {
      return {
        geo_points: []
      }
    }
  }
</script>

<style>
.main-container {
  height: 100vh;
  display: flex;
  flex-direction: column;
}
.main-content {
  flex:1;
  display: flex;
  overflow: auto;
}
.main-content-container {
  overflow: auto;
  scroll-behavior: smooth;

}
</style>