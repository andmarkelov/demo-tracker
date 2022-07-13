<template>
  <v-main>
    <v-container fluid fill-height>
      <v-layout align-center justify-center>
        <v-flex xs12 sm8 md4>
          <v-card class="elevation-12">
            <v-toolbar dark color="green">
              <v-toolbar-title >Register new user</v-toolbar-title>
            </v-toolbar>
            <v-card-text>
              <v-form method="post" action="/reg">
                <v-text-field
                    name="username"
                    label="Login"
                    type="text"
                    autofocus
                ></v-text-field>
                <v-text-field
                    id="password"
                    name="password"
                    label="Password"
                    type="password"
                ></v-text-field>

                <v-card-actions class="justify-center">
                  <v-btn type="button" href="/">Back</v-btn>  <v-btn  type="submit" dark color="indigo">Create</v-btn>
                </v-card-actions>
              </v-form>
            </v-card-text>

          </v-card>
        </v-flex>
      </v-layout>
    </v-container>
  </v-main>
</template>

<script>
export default {

}
</script>

<style scoped>

</style>