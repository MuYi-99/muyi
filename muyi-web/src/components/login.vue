<template>
  <div class="muyi-background" :style="background">
    <div>
      <el-form class="muyi-login" ref="user" :model="user" :rules="rules">
        <img class="muyi-logo" :src="require('../../static/img/logo.png')">
        <el-form-item label="用户名" prop="username">
          <el-input type="text" v-model="user.username" placeholder="请输入 4 ~ 10 位的数字、字母或下划线">
            <span slot="prefix" class="fa fa-user"></span>
          </el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="user.password" autocomplete="off" placeholder="请输入 8 ~ 16 位的数字、字母和特殊字符">
            <span slot="prefix" class="fa fa-key"></span>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('user')">登录</el-button>
          <el-button @click="resetForm('user')">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  name: 'login',
  data () {
    // 用户名校验
    var usernameValidator = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('请输入用户名'))
      }
      setTimeout(() => {
        if (this.usernamePattern.test(value)) {
          callback()
        } else {
          callback(new Error('请输入 4 ~ 10 位的数字、字母或下划线'))
        }
      }, 500)
    }
    // 密码校验
    var passwordValidator = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('请输入密码'))
      }
      setTimeout(() => {
        if (this.passwordPattern.test(value)) {
          callback()
        } else {
          callback(new Error('请输入 8 ~ 16 位的数字、字母和特殊字符'))
        }
      }, 500)
    }
    return {
      // 背景
      background: {
        backgroundImage: 'url(' + require('../../static/img/background.jpg') + ')',
        backgroundRepeat: 'no-repeat',
        backgroundSize: '100% 100%'
      },
      // 用户名的正则
      usernamePattern: /^[a-zA-Z0-9_]{4,10}$/,
      // 密码的正则
      passwordPattern: /^.*(?=.{8,16})(?=.*\d)(?=.*[A-Za-z])(?=.*[!@#$%^&*? ]).*$/,
      user: {
        username: '',
        password: ''
      },
      rules: {
        username: [
          { validator: usernameValidator, trigger: 'blur' }
        ],
        password: [
          { validator: passwordValidator, trigger: 'blur' }
        ]
      }
    }
  }
}
</script>

<style>
.muyi-background{
  width: 100%;
  height: 98vh;
}
.muyi-login{
  width: 450px;
  margin: 0px auto;
  border: 1px solid rgb(234, 234, 234);
  position: relative;
  top: 22vh;
  padding: 35px 35px 15px;
  background: #ffffff;
  opacity: 0.8;
  border-radius: 10px;
}
.muyi-logo{
  width: 128px;
  height: 128px;
}
</style>
