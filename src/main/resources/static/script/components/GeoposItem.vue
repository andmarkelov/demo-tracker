<template>
  <div class="geodiv">
    <tr>
    <td><b>{{data.lat}}</b></td>
    <td><b>{{data.lon}}</b></td>
    <td><button @click="deletePoint">Delete</button></td>
    </tr>
  </div>
</template>

<script>

export default {
  props: ['data'],
  methods: {
    deletePoint() {
      this.$resource("/api/geo{/id}").delete({id: this.data.id}).then(result => {
        this.$destroy();
        this.$el.parentNode.removeChild(this.$el);
      });
    }
  }
}
</script>

<style>


</style>