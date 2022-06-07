<template>


  <div class="main-container">

    <v-toolbar style="flex:0">
      <slot name="toolbar-content"></slot>
    </v-toolbar>

    <div class="main-content">
      <div class="main-content-container" style="width:300px">
        <slot name="left-panel"></slot>
      </div>
      <div style="display: grid; width: 500px; grid-template-rows: 96px 1fr">
        <!--          <v-card>-->
        <slot name="center-title"></slot>
        <!--          </v-card>-->
        <div class="main-content-container">
          <slot name="center-panel"></slot>
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
</template>

<script>
export default {
  
}
</script>

<style scoped>
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