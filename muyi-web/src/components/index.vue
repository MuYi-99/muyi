<template>
  <el-container>
    <!-- 顶栏菜单 start -->
    <el-header>
      <el-menu mode="horizontal" default-active="1">
        <el-menu-item>
          <img title="muyi" class="muyi-logo" :src="require('../../static/img/logo.png')">
        </el-menu-item>
        <el-menu-item @click="sidebarCollapseHandle">
          <span :class="'fa fa-' + (isSidebarCollapse ? 'indent' : 'outdent')" :title="isSidebarCollapse ? '展开' : '收缩'"></span>
        </el-menu-item>
        <el-menu-item index="1">流程管理</el-menu-item>
        <el-submenu index="2">
          <template slot="title">我的工作台</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
          <el-menu-item index="2-3">选项3</el-menu-item>
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项1</el-menu-item>
            <el-menu-item index="2-4-2">选项2</el-menu-item>
            <el-menu-item index="2-4-3">选项3</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="3" disabled>消息中心</el-menu-item>
        <el-menu-item index="4">订单管理</el-menu-item>
        <!-- 用户 -->
        <el-submenu index="5" style="float: right;">
          <template slot="title">
            <img :src="require('../../static/img/user.png')">
          </template>
          <el-menu-item>用户信息</el-menu-item>
          <el-menu-item>关于我们</el-menu-item>
          <el-menu-item style="border-top:1px solid #dbdbdb">退出</el-menu-item>
        </el-submenu>
        <!-- 搜索 -->
        <el-menu-item style="float: right;">
          <el-input size="medium" placeholder="搜索">
            <span slot="prefix" class="fa fa-search"></span>
          </el-input>
        </el-menu-item>
      </el-menu>
    </el-header>
    <!-- 顶栏菜单 end -->
    <!-- 侧边菜单栏 start -->
    <el-container>
      <el-aside width="auto">
        <el-menu
          class="muyi-sidebar"
          @select="sidebarMenuSelect"
          :collapse="isSidebarCollapse">
          <el-menu-item v-for="menuInfo in menuInfos" :key="menuInfo.id" :index="menuInfo.url">
            <i :class="menuInfo.icon"></i>
            <span slot="title">{{menuInfo.name}}</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <!-- 侧边菜单栏 end -->
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data () {
    return {
      // 侧边栏的收缩开关
      isSidebarCollapse: false,
      menuInfos: [
        {
          id: '1',
          code: 'flow_setting',
          name: '流程配置',
          url: '/',
          icon: 'fa fa-cog'
        },
        {
          id: '2',
          code: 'flow_center',
          name: '流程中心',
          url: '/center',
          icon: 'fa fa-list'
        }
      ]
    }
  },
  methods: {
    // 侧边栏收缩处理
    sidebarCollapseHandle () {
      this.isSidebarCollapse = !this.isSidebarCollapse
    },
    sidebarMenuSelect (index) {
      this.$router.push(index).catch(err => {
        console.log(err.toString())
      })
    }
  }
}
</script>
<style scoped>
.muyi-logo{
  width: 100%;
  height: 100%;
}
.muyi-sidebar{
  height: 92.5vh;
  text-align: left;
}
.muyi-sidebar:not(.el-menu--collapse){
  width: 200px;
}
</style>
