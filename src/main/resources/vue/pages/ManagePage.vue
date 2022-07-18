<template>
  <base-container>
    <template v-slot:toolbar-content>
      <my-toolbar title="My map" :user_object="user_object"></my-toolbar>
    </template>
    <template v-slot:left-panel-title>
      <device-selector v-model="current_device"/>
    </template>
    <template v-slot:left-panel>
      <track-list :device="current_device" :items = "geo_tracks" v-model="current_track"/>
    </template>
    <template v-slot:center-title>
      <v-card v-if="current_track !== undefined">
        <track-info :track="current_track"></track-info>
      </v-card>
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
import GeoMap from "../components/GeoMap.vue";
import DeviceSelector from "components/DeviceSelector.vue";
import MyToolbar from "components/MyToolbar.vue";

export default {
  components: {
    MyToolbar,
    DeviceSelector,
    GeoMap,
    BaseContainer,
    TrackInfo,
    TrackList,
    GeoposList,
    GeoposEditForm
  },
  data() {
    return {
      geo_tracks: [],
      geo_points: [],
      current_track: undefined,
      current_device: undefined,
      user_object: {
        name: document.spring_username,
        email:"pupalupa@msk.ru",
        userpic: "https://cdn.vuetifyjs.com/images/john.jpg"
      }
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