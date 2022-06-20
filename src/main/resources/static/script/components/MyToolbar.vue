<template>
  <v-toolbar style="flex:0">
    <v-toolbar-title>{{ this.title }}</v-toolbar-title>
    <v-spacer></v-spacer>

    <slot name="inner"></slot>

    <user-menu :user_object="this.user_object"/>
  </v-toolbar>
</template>

<script>
import UserMenu from "components/UserMenu.vue";

export default {
  components: {
    UserMenu
  },
  props: ['user_object', 'title']
}
</script>

<style scoped>

</style>