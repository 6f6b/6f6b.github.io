import Vue from 'vue'
import Router from 'vue-router'
import APP from '@/APP'
Vue.use(Router)


export default new Router({
  routes: [
    {
      path: '/',
      name: '首页',
      component: APP
    }
  ]
})
