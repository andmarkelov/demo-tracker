<template>
  <div>
    <v-select
        v-model="curItem"
        :items="items"
        item-text="name"
        item-value="id"
        label="Please select a device"
        no-data-text="No devices found"
        prepend-inner-icon="mdi-cellphone-marker"
        hide-details="true"
        return-object
        single-line
        :loading="loading"
        :disabled="loading"
    ></v-select>
  </div>
</template>

<script>
  let cu = {};
  export default {
    data () {
      return {
        items: [],
        loading: true
      }
    },
    computed: {
      curItem: {
        get() {
          return cu;
        },
        set(cur) {
          this.cu = cur
          this.$emit('input', this.cu)
        }
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