<template>
  <div justify-center>
    <my-toolbar title="Settings" :user_object="user_object">
      <template v-slot:inner>
        <v-divider>vertical</v-divider>
        <v-tabs v-model="tabs">
          <v-tab to="/"><v-icon>mdi-arrow-left-bold</v-icon>Home</v-tab>
          <v-tab>User profile</v-tab>
          <v-tab>Devices</v-tab>
        </v-tabs>
      </template>
    </my-toolbar>

      <v-tabs-items v-model="tabs">
        <v-tab-item>
        </v-tab-item>
        <v-tab-item>
        <v-card flat class="ml-auto mr-auto mt-3" style="width: 500px;display: block;">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        </v-card>

        </v-tab-item>
        <v-tab-item>
          <v-card flat class="ml-auto mr-auto mt-3" style="width: 500px;display: block;">
            <device-list-managed @edit="editDevice"/>
            <v-btn class="ma-3" @click="addNewDevice()">Add new device</v-btn>
            <new-device-dialog @saved="onSaveDevice" :deviceObject="curDeviceObject" v-model="newDeviceDialogVisible"></new-device-dialog>
          </v-card>
        </v-tab-item>
      </v-tabs-items>
  </div>

</template>

<script>
import MyToolbar from "../components/MyToolbar.vue";
import DeviceListManaged from "../components/DeviceListManaged.vue";
import NewDeviceDialog from "../dialogs/NewDeviceDialog.vue";

export default {
  props: {

  },
  components: {
    NewDeviceDialog,
    MyToolbar,
    DeviceListManaged
  },
  data() {
    return {
      user_object: {
        name: document.spring_username,
        email:"pupalupa@msk.ru",
        userpic: "https://cdn.vuetifyjs.com/images/john.jpg"
      },
      tabs: 2,
      text: undefined,
      devicesItems: [],
      newDeviceDialogVisible: false,
      curDeviceObject: {}
    }
  },
  methods: {
    addNewDevice() {
      this.curDeviceObject.id = 0;
      this.curDeviceObject.guid = "";
      this.curDeviceObject.name = "new device #id";
      this.newDeviceDialogVisible = true;
    },
    onSaveDevice(obj) {
      if(obj.id == 0) {
        //add new
        this.$http.post("/api/device", obj)
            .then(res => {
                  this.devicesItems.push(res.body)
                },
                error => {
                    alert("error")
                });
      } else {
        //edit
        this.$resource("/api/device{/id}").update({id: obj.id}, obj)
            .then(result => {
                  obj.name = result.body.name;
                },
                error => {
                  alert("error");
                });

      }

    },
    editDevice(obj) {
      this.curDeviceObject = {...obj};
      this.newDeviceDialogVisible = true;
    }
  }
}

</script>

<style scoped>

</style>