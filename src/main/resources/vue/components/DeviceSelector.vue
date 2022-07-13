<template>
  <div>
    <v-select
        v-model="curItem"
        :items="items"
        item-text="name"
        item-value="id"
        label="Please select a tracker device"
        no-data-text="No devices found"
        prepend-inner-icon="mdi-cellphone-marker"
        hide-details="true"
        filled
        return-object
        single-line
        :loading="loading"
        :disabled="loading"
    >
<!--     <template v-slot:item >-->
<!--       <v-icon>mdi-cellphone-marker</v-icon>-->
<!--       {{ this.item.name }}-->
<!--     </template>-->

    </v-select>
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