<template>
  <div id="app">
    <div class="contain">
<!--      <img src="./assets/background.jpg" class="image">-->
<!--      <input placeholder="请输入手机号">-->
<!--      <input placeholder="请输入密码">-->
    </div>
    <button class="button">登录/注册</button>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {}
}
</script>

<style scoped>
  #app{
      /*background-color: lightgray;*/
      width: 100%;
      height: 100%;
      position: absolute;
  }
  .image {
    width: 100%;
    height: 100%;
  }
  .contain{
      align-content: center;
  }
    .button{
        width: 200px;
        height: 50px;
        background-color: #2c3e50;
        color: white;
    }
</style>
