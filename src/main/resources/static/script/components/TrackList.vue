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
    props: ['items'],
    components: {
      TrackListItem
    },
    created() {
      this.$resource("/api/track{/id}").get().then(
          result => result.json().then(data => {
            data.forEach(track => {
              track.icon = "img/go-kart-track.svg"
              this.items.push(track)
            })
          this.onChange(this.curItem)
          }),
      );
      

    },
    data: function () {
      return {
        model: 0
      }
    } ,

    computed: {
      curItem: {
        get() {
          return this.items[this.model];
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