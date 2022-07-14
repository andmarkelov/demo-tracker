<template>
  <v-main>
    <v-container fluid fill-height>
      <v-layout align-center justify-center>
        <v-flex xs12 sm8 md4>
          <v-card class="elevation-12" :loading="loading" :disabled="loading">
            <v-toolbar dark color="green">
              <v-toolbar-title >Register new user</v-toolbar-title>
            </v-toolbar>
            <v-card-text>
              <v-form>
                <v-text-field
                    label="Login"
                    type="text"
                    v-model="username"
                    autofocus
                ></v-text-field>
                <v-text-field
                    label="Password"
                    type="password"
                    v-model="password"
                ></v-text-field>

                <v-card-actions class="justify-center">
                  <v-btn type="button" href="/">Back</v-btn>
                  <v-btn dark color="indigo" @click="onPerformClick()">Create</v-btn>
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
  props: {loading: false},
  data() {
    return {
      username: "",
      password: ""
    }
  },
  methods: {
    onPerformClick() {
      this.loading = true;

      const postData = {
        name: this.username,
        password: this.password
      };
      this.$http
          .post("/api/user", postData)
          .then(res => {
            this.loading = false;
            alert("OK")
          },
          error => {
            if(error.status == 409) {
              this.loading = false;
              alert("error: user exists")
            } else if(error.status == 406) {
              this.loading = false;
              alert("fields validation error")
            } else {
              this.loading = false;
              alert("unknown error")
            }

          });
    }
  }
}
</script>

<style scoped>

</style>