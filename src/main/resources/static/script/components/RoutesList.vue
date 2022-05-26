<template>
<!--  <v-card  class="overflow-y-auto">-->
  
  <v-list>
    <v-list-item-group
        mandatory
        v-model="model"
        active-class="border"
        color="indigo"
    >
      <v-list-item
          v-for="(item, i) in items"
          :key="i"
      >
        <v-list-item-icon>
          <v-img max-height="64" max-width="64" :src="item.icon"></v-img>
<!--          <v-icon ="item.icon"></v-icon>-->
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title v-text="item.text"></v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list-item-group>
  </v-list>
<!--  </v-card>-->
</template>

<script>
export default {
  data: function () {
    return {
      items: [
        {
          icon: 'img/go-kart-track.svg',
          text: 'Wifi1',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Bluetooth',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Data Usage',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Wifi',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Bluetooth',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Data Usage',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Wifi',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Bluetooth',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Data Usage',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Wifi',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Bluetooth',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Data Usage',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Wifi',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Bluetooth',
        },
        {
          icon: 'img/go-kart-track.svg',
          text: 'Data Usage',
        },

      ],
      model: 1,
    }
  }

  
}
</script>

<style scoped>
  .border {
    border-right: 3px solid dodgerblue;
  }
</style>