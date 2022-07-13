<template>
    <div class="text-center">
      <v-menu
          v-model="menu"
          :close-on-content-click="false"
          :nudge-width="200"
          offset-x
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
              color="indigo"
              dark
              v-bind="attrs"
              v-on="on"
          >
            {{user_object.name}}
          </v-btn>
        </template>

        <v-card>
          <v-list>
            <v-list-item>
              <v-list-item-avatar>
                <img
                    :src="user_object.userpic"
                    alt="userpic"
                >
              </v-list-item-avatar>

              <v-list-item-content>
                <v-list-item-title>@<b>{{user_object.name}}</b></v-list-item-title>
                <v-list-item-subtitle>{{user_object.email}}</v-list-item-subtitle>
              </v-list-item-content>


            </v-list-item>
          </v-list>

          <v-divider></v-divider>

       

          <v-card-actions>
            <v-spacer></v-spacer>

            <v-btn
                text
                to="/settings"
            >
              Settings
            </v-btn>
            <v-btn
                color="primary"
                text
                href="/logout"
            >
              Exit
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-menu>
    </div>
</template>

<script>
  export default {
    props: ['user_object'],
    data: () => ({
    menu: false,
    message: false
}),
}
</script>

<style scoped>

</style>