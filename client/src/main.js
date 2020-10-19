import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import VueSession from 'vue-session'

Vue.use(VueSession)
Vue.prototype.$http = axios
Vue.config.productionTip = false

new Vue({
    router,
    render: function(h) { return h(App) }
}).$mount('#app')