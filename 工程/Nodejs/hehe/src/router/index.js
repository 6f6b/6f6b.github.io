import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import A from '@/components/ComponentA'
import B from '@/components/ComponentB'
import C from '@/components/ComponentC'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/a',
      name: 'A',
      component: A
    },
    {
      path: '/b',
      name: 'B',
      component: B
    },
    {
      path: '/c',
      name: 'C',
      component: C
    }
  ]
})
