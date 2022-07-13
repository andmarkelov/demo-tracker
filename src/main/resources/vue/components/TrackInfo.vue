<template>
  <div style="margin: 5px; margin-top: 10px; ">
    <editable-caption  :class="{ 'trackTitleGained': track.nameChanged }" :text="track.name"/>
    <br>
    info
  </div>
</template>

<script>
  import EditableCaption from "./EditableCaption.vue";

  export default {
    props: ['track'],
    components: {
      EditableCaption
    }
  }
</script>

<style scoped>
  .trackTitleGained text {
    font-weight: bold;
  }
</style>