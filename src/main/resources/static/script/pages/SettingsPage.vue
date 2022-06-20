<template>
  <div>
    <my-toolbar title="Settings" :user_object="user_object">
      <template v-slot:inner>
        <v-tabs value="2">
          <v-tab to="/"><v-icon>mdi-arrow-left-bold</v-icon>Home</v-tab>
          <v-tab>User profile</v-tab>
          <v-tab>Devices</v-tab>
        </v-tabs>
      </template>


    </my-toolbar>
<!--    <v-card>-->
<!--      <v-toolbar-->
<!--          color="white"-->
<!--          flat-->
<!--      >-->
<!--        <v-app-bar-nav-icon></v-app-bar-nav-icon>-->

<!--        <v-toolbar-title>Your Dashboard</v-toolbar-title>-->

<!--        <v-spacer></v-spacer>-->

<!--        <v-btn icon>-->
<!--          <v-icon>mdi-magnify</v-icon>-->
<!--        </v-btn>-->

<!--        <v-btn icon>-->
<!--          <v-icon>mdi-dots-vertical</v-icon>-->
<!--        </v-btn>-->

<!--        <template v-slot:extension>-->
<!--          <v-tabs-->
<!--              v-model="tab"-->
<!--              align-with-title-->
<!--          >-->
<!--            <v-tabs-slider color="yellow"></v-tabs-slider>-->

<!--            <v-tab-->
<!--                v-for="item in items"-->
<!--                :key="item"-->
<!--            >-->
<!--              {{ item }}-->
<!--            </v-tab>-->
<!--          </v-tabs>-->
<!--        </template>-->
<!--      </v-toolbar>-->

<!--      <v-tabs-items v-model="tab">-->
<!--        <v-tab-item-->
<!--            v-for="item in items"-->
<!--            :key="item"-->
<!--        >-->
<!--          <v-card flat>-->
<!--            <v-card-text v-text="text"></v-card-text>-->
<!--          </v-card>-->
<!--        </v-tab-item>-->
<!--      </v-tabs-items>-->
<!--    </v-card>-->
  </div>
</template>

<script>
import MyToolbar from "components/MyToolbar.vue";
export default {
  components: {
    MyToolbar
  },
  data() {
    return {
      user_object: {
        name: document.spring_username,
        email:"pupalupa@msk.ru",
        userpic: "https://cdn.vuetifyjs.com/images/john.jpg"
      }
    }
  },
}
</script>

<style scoped>

</style>