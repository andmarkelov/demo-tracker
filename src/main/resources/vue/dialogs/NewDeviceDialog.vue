<template>
  <v-dialog
      v-model="show"
      max-width="600px"
      @keydown.esc="close()"
      persistent
  >


    <v-card>
      <v-card-title>
        <span v-if="deviceObject.id == 0" span class="text-h5">Add new device</span>
        <span v-else span class="text-h5">Edit device {{deviceObject.id }}</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="10">
              <v-text-field
                  label="Device name"
                  required
                  v-model="deviceObject.name"
                  autofocus
              ></v-text-field>
            </v-col>

            <v-col cols="10">
              <v-text-field
                  label="Guid"
                  required
                  v-model="deviceObject.guid"
              ></v-text-field>
            </v-col>

          </v-row>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn
            color="blue darken-1"
            text
            @click="close()"
        >
          Close
        </v-btn>
        <v-btn
            color="blue darken-1"
            text
            @click="save()"
        >
          Save
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  props: {
    value: Boolean,
    deviceObject: {
      id: 0,
      name: "",
      guid: ""
    }
  },
  data: () => ({

  }),
  computed: {
    show: {
      get () {
        return this.value
      },
      set (value) {
        this.$emit('input', value)
      }
    }
  },
  methods: {
    close() {
      this.show = false;
    },
    save() {
      this.show = false;
      this.$emit('saved', this.deviceObject);
    }
  }
}
</script>

<style scoped>

</style>