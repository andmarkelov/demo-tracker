<template>
  <v-list-item

  >
    <v-list-item-icon>
      <v-img max-height="64" max-width="64" :src="data.icon"></v-img>
      <!--          <v-icon ="item.icon"></v-icon>-->
    </v-list-item-icon>

    <v-list-item-content>
      <v-list-item-title v-text="data.name"></v-list-item-title>
    </v-list-item-content>
  </v-list-item>
</template>

<script>
export default {
  props: ['data'],
  methods: {
    deleteRoute() {
      this.$resource("/api/track{/id}").delete({id: this.data.id}).then(result => {
        this.$destroy();
        this.$el.parentNode.removeChild(this.$el);
      });
    }
  }

}
</script>

<style scoped>

</style>