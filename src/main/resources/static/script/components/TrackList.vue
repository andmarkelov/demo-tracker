<template>
<!--  <v-card  class="overflow-y-auto">-->
  
  <v-list>
    <v-list-item-group
        mandatory
        v-model="model"
        @change="onChange"
        active-class="border"
        color="indigo"
    >
      <track-list-item
          v-for="(item, i) in items"
          :key="i"
          :data="item"

      />

    </v-list-item-group>
  </v-list>
<!--  </v-card>-->
</template>

<script>
  import TrackListItem from "components/TrackListItem.vue"

  export default {
    props: ['items', 'device'],
    components: {
      TrackListItem
    },
    created() {
      // this.$resource("/api/track{/id}").get().then(
      //     result => result.json().then(data => {
      //       data.forEach(track => {
      //         track.icon = "img/go-kart-track.svg"
      //         this.items.push(track)
      //       })
      //     this.onChange(this.curItem)
      //     }),
      //);
      

    },
    data: function () {
      return {
        model: 0
      }
    },
    watch: {
      device(newDev, oldDev) {

        this.items.length = 0;

        this.$resource("/api/device{/dev_id}/tracks").get({dev_id: newDev.id}).then(
            result => result.json().then(data => {
              data.forEach(track => {
                track.icon = "img/go-kart-track.svg"
                this.items.push(track)
              });

              if(this.items.length > 0) {
                this.curItem = this.items[0];
                this.onChange(this.curItem);
              }
            })
        );
      }
    },
    computed: {
      curItem: {
        get() {
          return this.items[this.model];
        },
        set(nothing) {
          
        }
      }
    },
    methods: {
      onChange(event) {
        this.$emit('input', this.curItem)
      }
    }


  }
</script>

<style scoped>
  .border {
    border-right: 3px solid dodgerblue;
  }
</style>