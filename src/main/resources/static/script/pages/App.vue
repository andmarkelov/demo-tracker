<template>
  <v-app>
<!--       <v-main>-->
<!--        <v-layout row wrap>-->
<!--          <v-layout column color="blue">привет</v-layout>-->
<!--          <v-layout row wrap>-->
<!--              <geopos-edit-form :geo_points = "geo_points"/>-->
<!--              <v-card height="100%" class="overflow-auto">-->
<!--                <geopos-list :items = "geo_points"/>-->
<!--              </v-card>-->
<!--          </v-layout>-->
<!--        </v-layout>-->
<!--       </v-main>-->
                <header>Points manager | User</header>
                <v-layout no-gutters class="black">
                  <v-row style="background: black" no-gutters>
                    <v-col class="red">
                      <routes-list/>
                    </v-col>
                    <v-col fill-height class="blue">
                      <header class="yellow"><v-card>Route X:</v-card></header>
                      <v-card flat fill-height class="overflow-auto">
                        <v-layout no-gutters row wrap>
                        <geopos-edit-form :geo_points = "geo_points"/>
                        <geopos-list :items = "geo_points"/>
                        </v-layout>
                      </v-card>
                    </v-col>
                    <v-col fill-height class="white">
                      <v-container fill-height class="d-flex justify-center">
                      <v-img
                          lazy-src="img/map_big_icon_preview.png"
                          max-height="250"
                          max-width="250"
                          src="img/map_big_icon_preview.png"
                          style="filter: alpha(Opacity=30);opacity: 0.3"
                      ></v-img>
                      </v-container>
                    </v-col>
                  </v-row>
                </v-layout>

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

</style>