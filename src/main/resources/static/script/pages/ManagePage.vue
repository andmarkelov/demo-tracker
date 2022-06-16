<template>
  <base-container>
    <template v-slot:toolbar-content>
      <v-toolbar-title>Points manager</v-toolbar-title>
      <v-spacer></v-spacer>

      <user-menu :user_object="user_object"/>
      <!--        <v-btn icon href="/logout">-->
      <!--          <v-img max-width="24" max-height="24" src="img/location-exit.png"></v-img>-->
      <!--        </v-btn>-->

    </template>
    <template v-slot:left-panel>
      <track-list :items = "geo_tracks" v-model="current_track"/>
    </template>
    <template v-slot:center-title>
      <track-info :track="current_track"></track-info>
    </template>
    <template v-slot:center-panel>
      <geopos-edit-form :geo_points = "geo_points" :track="current_track"/>
<!--      <geopos-list :items = "geo_points" :track="current_track"/>-->
    </template>
    <template v-slot:right-panel>
      <geo-map :track="current_track"></geo-map>
    </template>
  </base-container>
</template>

<script>
import GeoposList from "components/GeoposList.vue"
import GeoposEditForm from "components/GeoposEditForm.vue"
import TrackList from "components/TrackList.vue"
import TrackInfo from "components/TrackInfo.vue"
import BaseContainer from "components/BaseContainer.vue";
import GeoMap from "components/GeoMap.vue";
import UserMenu from "components/UserMenu.vue";

export default {
  components: {
    GeoMap,
    BaseContainer,
    TrackInfo,
    TrackList,
    GeoposList,
    GeoposEditForm,
    UserMenu
  },
  data() {
    return {
      geo_tracks: [],
      geo_points: [],
      current_track: Object,
      user_object: {name: document.spring_username, email:"pupalupa@msk.ru", userpic: "https://cdn.vuetifyjs.com/images/john.jpg"}
    }
  },
  created() {

  }
  // ,
  // methods: {
  //   trackSelectionChanged(event) {
  //     this.current_track = event;
  //   }
  // }
}
</script>

<style scoped>


</style>