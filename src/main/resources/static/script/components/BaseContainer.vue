<template>


  <div class="main-container">

    <slot name="toolbar-content"></slot>

    <div class="main-content">
      <div style="display: grid;  grid-template-rows: 60px 1fr 100px; width: 600px">
        <div>
          <slot name="left-panel-title" style="width:100%"></slot>
        </div>
        <div class="main-content-container" style="width:100%">
          <slot name="left-panel"></slot>
        </div>
        <div>
          <slot name="center-title"></slot>
        </div>
      </div>
<!--      <div style="display: grid;  grid-template-rows: 96px 1fr; width: 600px">-->
<!--        &lt;!&ndash;          <v-card>&ndash;&gt;-->
<!--        <slot name="center-title"></slot>-->
<!--        &lt;!&ndash;          </v-card>&ndash;&gt;-->
<!--        <div class="main-content-container">-->
<!--          <slot name="center-panel"></slot>-->
<!--        </div>-->
<!--      </div>-->
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