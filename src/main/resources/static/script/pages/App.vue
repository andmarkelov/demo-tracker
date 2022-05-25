<template>
  <div>
    <div class="container">
      <div class="left_panel"style="border: gainsboro solid 1px; max-width: 300px">Some content</div>
      <div class="title_panel">Points Manager</div>
      <div class="points_panel" style="border-top: gainsboro solid 1px">
        <geopos-edit-form :geo_points = "geo_points"/>
        <geopos-list :items = "geo_points"/>
      </div>
      <div class="route_title_panel">Route title panel</div>
      <div class="map_panel">Map</div>
    </div>

  </div>
</template>

<script>
  import GeoposList from "components/GeoposList.vue";
  import GeoposEditForm from "components/GeoposEditForm.vue";

  export default {
    components: {
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
.container {  display: grid;
  grid-template-columns: 30% 50% 40%;
  grid-template-rows: 30px 50px auto;
  gap: 0px 0px;
  grid-auto-flow: row;
  align-content: space-between;
  grid-template-areas:
    "title_panel title_panel title_panel"
    "left_panel route_title_panel route_title_panel"
    "left_panel points_panel map_panel";
}

.left_panel { grid-area: left_panel; }

.title_panel { grid-area: title_panel; }

.points_panel { grid-area: points_panel; }

.route_title_panel { grid-area: route_title_panel; }

.map_panel { grid-area: map_panel; }

</style>