import Vue from 'vue'
import VueResource from 'vue-resource'
import App from 'pages/App.vue'
import Vuetify from "vuetify"
import 'vuetify/dist/vuetify.min.css'
// import LoginForm from "./components/LoginForm";
// import RegistrationForm from "./components/RegistrationForm";



Vue.use(VueResource);
Vue.use(Vuetify);
//Vue.use(VueRouter);

new Vue({
    el: '#app',
    vuetify: new Vuetify(),
    render: a => a(App)
});

// const routerLR = new VueRouter({
//     routes: [
//         {
//             path: '/login',
//             component: LoginForm,
//         },
//         {
//             path: '/reg',
//             component: RegistrationForm,
//         }
//     ],
// });