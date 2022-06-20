<template>
  <div>
    <my-toolbar title="Settings" :user_object="user_object">
      <template v-slot:inner>
        <v-tabs v-model="tabs">
          <v-tab to="/"><v-icon>mdi-arrow-left-bold</v-icon>Home</v-tab>
          <v-tab>User profile</v-tab>
          <v-tab>Devices</v-tab>
        </v-tabs>
      </template>
    </my-toolbar>

    <v-main>
    <v-tabs-items v-model="tabs">
      <v-tab-item>

            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.

      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-title class="text-h5">
            An awesome title
          </v-card-title>
          <v-card-text>
            <p>
              Duis lobortis massa imperdiet quam. Donec vitae orci sed dolor rutrum auctor. Vestibulum facilisis, purus nec pulvinar iaculis, ligula mi congue nunc, vitae euismod ligula urna in dolor. Praesent congue erat at massa.
            </p>

            <p>
              Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Pellentesque egestas, neque sit amet convallis pulvinar, justo nulla eleifend augue, ac auctor orci leo non est. Etiam sit amet orci eget eros faucibus tincidunt. Donec sodales sagittis magna.
            </p>

            <p class="mb-0">
              Ut leo. Suspendisse potenti. Duis vel nibh at velit scelerisque suscipit. Fusce pharetra convallis urna.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
      <v-tab-item>
        <v-card flat>
          <v-card-title class="text-h5">
            An even better title
          </v-card-title>
          <v-card-text>
            <p>
              Maecenas ullamcorper, dui et placerat feugiat, eros pede varius nisi, condimentum viverra felis nunc et lorem. Sed hendrerit. Maecenas malesuada. Vestibulum ullamcorper mauris at ligula. Proin faucibus arcu quis ante.
            </p>

            <p class="mb-0">
              Etiam vitae tortor. Curabitur ullamcorper ultricies nisi. Sed magna purus, fermentum eu, tincidunt eu, varius ut, felis. Aliquam lobortis. Suspendisse potenti.
            </p>
          </v-card-text>
        </v-card>
      </v-tab-item>
    </v-tabs-items>
    </v-main>
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
      },
      tabs: 2,
      text: undefined
    }
  },
}
</script>

<style scoped>

</style>