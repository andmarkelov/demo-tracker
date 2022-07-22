<template>
  <v-card flat class="ml-auto mr-auto mt-3" style="width: 500px;display: block;">
    <device-list-managed
        :items="items"
        @edit="editDevice"
        @tracksErased="eraseTracks"
        @deleted="deleteItem"
    />
    <v-btn class="ma-3" @click="addNewDevice">Add new device</v-btn>
    <new-device-dialog @saved="onSaveDevice" :deviceObject="curDeviceObject" v-model="newDeviceDialogVisible"></new-device-dialog>
  </v-card>
</template>

<script>
import DeviceListManaged from "../components/DeviceListManaged.vue";
import NewDeviceDialog from "../dialogs/NewDeviceDialog.vue";

export default {
  components: {
    NewDeviceDialog,
    DeviceListManaged
  },
  data() {
    return {
      items: [],
      newDeviceDialogVisible: false,
      curDeviceObject: {}
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

    })
  },
  methods: {
    addNewDevice() {
      this.curDeviceObject.id = 0;
      this.curDeviceObject.guid = "";
      this.curDeviceObject.name = "new device";
      this.newDeviceDialogVisible = true;
    },
    onSaveDevice(obj) {
      if(obj.id == 0) {
        //add new
        this.$http.post("/api/device", obj)
            .then(res => {
                  this.items.push({...res.body,
                    _props: {
                      disabled: false
                    }})
                },
                error => {
                  alert("error")
                });
      } else {
        //edit
        this.$resource("/api/device{/id}").update({id: obj.id}, obj)
            .then(result => {
                  Object.assign(this.items.find(o => o.id === result.body.id), result.body);
                },
                error => {
                  alert("error");
                });

      }

    },
    editDevice(obj) {
      this.curDeviceObject = {...obj};
      this.newDeviceDialogVisible = true;
    },
    eraseTracks(item, comp) {
      comp.loading = true;

      this.$resource("/api/device{/id}/tracks").delete({id: item.id})
          .then(result => {
                comp.loading = false;
                alert("Tracks erased");
              },
              error => {
                comp.loading = false;
                alert("Erasing error");
              });

    },
    deleteItem(item, comp) {
      comp.loading = true;
      item._props.disabled = true;

      this.$resource("/api/device{/id}").delete({id: item.id})
          .then(result => {
                comp.loading = false;
                this.items.splice(
                    this.items.indexOf(item)
                );
              },
              error => {
                comp.loading = false;
                item._props.disabled = false;
                alert("error");
              });

    },
  }
}
</script>

<style scoped>

</style>