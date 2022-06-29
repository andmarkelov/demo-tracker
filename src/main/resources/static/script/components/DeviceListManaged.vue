<template>
  <v-card :loading="this.loading" width="500px">
    <v-list two-line>
      <v-list-item-group>
        <div v-for="(item, index) in items">
          <v-list-item :key="item.id">

              <v-list-item-avatar>
                <v-icon class="green lighten-1" dark>mdi-cellphone-marker</v-icon>
              </v-list-item-avatar>

              <v-list-item-content>
                <v-list-item-title v-text="item.name"/>
                <v-list-item-subtitle class="text-subtitle-2" v-text="item.id"/>
                <v-list-item-subtitle v-text="item.guid"/>
              </v-list-item-content>

              <v-list-item-action>
                <v-btn icon><v-icon color="red darken-3" dark>mdi-close-circle-outline</v-icon></v-btn>
              </v-list-item-action>

          </v-list-item>

          <v-divider v-if="index < items.length - 1" :key="index"/>
        </div>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>

<script>
export default {
  data () {
    return {
      items: [],
      loading: true
    }
  },
  created() {
    this.$resource("/api/currentUser/devices").get().then(data => {
      this.items = data.body;
      this.loading = false;
    })
  }
}
</script>

<style scoped>

</style>