<template>
  <div>
    <span :class="{ 'trackTitleGained': track.nameChanged }">{{ track.name }}</span>
    <br>
    info
  </div>
</template>

<script>
  export default {
    props: ['track']

  }
</script>

<style scoped>
  .trackTitleGained {
    font-weight: bold;
  }
</style>