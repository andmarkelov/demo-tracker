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
         <DeviceSettingsTabContent/>
        </v-tab-item>
      </v-tabs-items>
  </div>

</template>

<script>
import MyToolbar from "../components/MyToolbar.vue";
import DeviceSettingsTabContent from "../components/DeviceSettingsTabContent.vue";
export default {
  components: {
    DeviceSettingsTabContent,
    MyToolbar
  },
  data() {
      return  {
      user_object: {
        name: document.spring_username,
        email:"pupalupa@msk.ru",
        userpic: "https://cdn.vuetifyjs.com/images/john.jpg"
      },
      tabs: 2,
      text: undefined
    }
  }
}
</script>

<style scoped>

</style>