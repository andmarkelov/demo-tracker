<template>

  <v-card class="MainCard" :loading="this.loading" v-if="items.length > 0">
    <v-list two-line>
      <v-list-item-group>
        <div v-for="(item, index) in items">
          <v-list-item :key="item.id" :disabled="item._props.disabled">

              <v-list-item-avatar>
                <v-icon class="green lighten-1" dark>mdi-cellphone-marker</v-icon>
              </v-list-item-avatar>

              <v-list-item-content @dblclick="editItem(item, index)">
                <v-list-item-title v-text="item.name"/>
                <v-list-item-subtitle class="text-subtitle-2" v-text="item.id"/>
                <v-list-item-subtitle v-text="item.guid"/>
              </v-list-item-content>

              <v-list-item-action>
                <v-tooltip top>
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn icon v-bind="attrs" v-on="on" @click="editItem(item, index)"><v-icon color="blue darken-3" dark>mdi-pencil</v-icon></v-btn>
                  </template>
                  <span>Modify</span>
                </v-tooltip>
              </v-list-item-action>

              <v-list-item-action>
                <v-tooltip top>
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn icon v-bind="attrs" v-on="on" @click="eraseTracks(item, index)"><v-icon color="blue darken-3" dark>mdi-eraser</v-icon></v-btn>
                  </template>
                  <span>Erase tracks</span>
                </v-tooltip>
              </v-list-item-action>

            <v-list-item-action>
              <v-tooltip top>
                <template v-slot:activator="{ on, attrs }">
                  <v-btn icon v-bind="attrs" v-on="on" @click="deleteItem(item, index)"><v-icon color="red darken-3" dark>mdi-close-circle-outline</v-icon></v-btn>
                </template>
                <span>Remove device</span>
              </v-tooltip>
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
        _props: {
          disabled: false
        }
      }));
      this.loading = false;
    })
  },
  methods: {

    deleteItem(item, index) {
      this.loading = true;
      item._props.disabled = true;

      this.$resource("/api/device{/id}").delete({id: item.id})
          .then(result => {
                this.loading = false;
                this.items.splice(index, 1);
          },
          error => {
            this.loading = false;
            item._props.disabled = false;
            alert("error");
          });

    },
    eraseTracks(item, index) {
      this.loading = true;

      this.$resource("/api/device{/id}/tracks").delete({id: item.id})
          .then(result => {
                this.loading = false;
                alert("Tracks erased");
              },
              error => {
                this.loading = false;
                alert("Erasing error");
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