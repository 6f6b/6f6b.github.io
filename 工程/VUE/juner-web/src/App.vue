<template>
  <div id="app">
      <div class="loginContainer"></div>
    <div class="button">
        <input placeholder="请输入手机号">
        <input placeholder="请输入密码">
        <button class="button">登录/注册</button>
    </div>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {}
}
</script>

<style lang="scss">
  #app{
      width: 100%;
      height: 100%;
      position: absolute;
      background-image: url("../src/assets/background.jpg");
      background-position: center;

      .loginContainer{
          position: absolute;
          /*margin: auto;*/
          /*width: 200px;*/
          /*height: 200px;*/
          /*border-width: 10px;*/
          /*border-color: #42b983;*/
      }
  }
</style>
