<template>
  <div>
    <h1>{{msg}}}</h1>
  </div>
</template>

<script>
  export default {
    name: 'ComponentB',
    data(){
      return{
        msg:'这是组件B',
      }
    }
  }
</script>

<style scoped>
  h1{
    color: orange;
  }
</style>
