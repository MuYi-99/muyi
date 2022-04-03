import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: () => import('@/components/index'),
      children: [
        {
          path: '/center',
          name: 'center',
          component: () => import('@/components/flow/center')
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/components/login')
    }
  ]
})
