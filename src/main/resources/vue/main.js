import Vue from 'vue'
import VueResource from 'vue-resource'
import VueRouter from 'vue-router'
import Vuetify from "vuetify"
import 'vuetify/dist/vuetify.min.css'

import App from 'pages/App.vue'
import LoginPage from "pages/LoginPage.vue";
import RegistrationPage from "pages/RegistrationPage.vue";
import ManagePage from "pages/ManagePage.vue";
import SettingsPage from "pages/SettingsPage.vue";


Vue.use(VueResource);
Vue.use(Vuetify);
Vue.use(VueRouter);



const NotFound = { template: "<div>Page not found</div>" };

const router = new VueRouter({
    routes: [
        {
            path: '/',
            component: ManagePage,
        },
        {
            path: '/auth',
            component: LoginPage,
        },
        {
            path: '/reg',
            component: RegistrationPage,
        },
        {
            path: '/settings',
            component: SettingsPage,
        },
        {
            path: "*",
            component: NotFound
        }
    ],
    mode: "history"
});

const vuetify = new Vuetify();

const app = new Vue({
    el: '#app',
    router,
    vuetify: vuetify,
    render: a => a(App)
});
