<template>

  <v-card class="MainCard" :loading="this.loading" v-if="items.length > 0">
    <v-list two-line>
      <v-list-item-group>
        <div v-for="(item, index) in items">
          <v-list-item :key="item.id" v-if="!item.removed">

              <v-list-item-avatar>
                <v-icon class="green lighten-1" dark>mdi-cellphone-marker</v-icon>
              </v-list-item-avatar>

              <v-list-item-content @dblclick="editItem(item, index)">
                <v-list-item-title v-text="item.name"/>
                <v-list-item-subtitle class="text-subtitle-2" v-text="item.id"/>
                <v-list-item-subtitle v-text="item.guid"/>
              </v-list-item-content>

              <v-list-item-action>
                <v-btn icon @click="deleteItem(item, index)"><v-icon color="red darken-3" dark>mdi-close-circle-outline</v-icon></v-btn>
              </v-list-item-action>

          </v-list-item>

          <v-divider v-if="index < items.length - 1" :key="index"/>
        </div>
      </v-list-item-group>
    </v-list>
  </v-card>

  <v-card class="MainCard pa-3" :loading="this.loading"  v-else="items.length == 0">no items</v-card>
</template>

<script>
export default {
  props: ['items'],
  data () {
    return {
      loading: true
    }
  },
  created() {
    this.$resource("/api/currentUser/devices").get().then(data => {
      this.items = data.body.map(e => ({
        ...e,
        removed: false
      }));
      this.loading = false;
    })
  },
  methods: {

    deleteItem(item, index) {
      this.loading = true;

      this.$resource("/api/device{/id}").delete({id: item.id})
          .then(result => {
                this.loading = false;
                this.items[index].removed = true;
          },
          error => {
            this.loading = false;
            alert("error");
          });

    },
    editItem(item, index) {
      this.$emit('edit', item);
    }
  }
}
</script>

<style scoped>
.MainCard {
  width: 500px
}
</style>