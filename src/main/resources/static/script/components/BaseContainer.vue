<template>


  <div class="main-container">

    <v-toolbar style="flex:0">
      <slot name="toolbar-content"></slot>
    </v-toolbar>

    <div class="main-content">
      <div class="main-content-container" style="width:400px">
        <slot name="left-panel"></slot>
      </div>
      <div style="display: grid;  grid-template-rows: 96px 1fr; width: 600px">
        <!--          <v-card>-->
        <slot name="center-title"></slot>
        <!--          </v-card>-->
        <div class="main-content-container">
          <slot name="center-panel"></slot>
        </div>
      </div>
<!--      <div style="width: 100%">-->
        <slot name="right-panel"></slot>
<!--      </div>-->
<!--      <div style="flex:1;">-->
<!--        <v-container fill-height >-->
<!--          -->
<!--&lt;!&ndash;          <v-img&ndash;&gt;-->
<!--&lt;!&ndash;              lazy-src="img/map_big_icon_preview.png"&ndash;&gt;-->
<!--&lt;!&ndash;              max-height="250"&ndash;&gt;-->
<!--&lt;!&ndash;              max-width="250"&ndash;&gt;-->
<!--&lt;!&ndash;              src="img/map_big_icon_preview.png"&ndash;&gt;-->
<!--&lt;!&ndash;              style="filter: alpha(Opacity=30);opacity: 0.3"&ndash;&gt;-->
<!--&lt;!&ndash;          ></v-img>&ndash;&gt;-->
<!--        </v-container>-->
<!--      </div>-->
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