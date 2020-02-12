<template>
  <div>
    <h1>{{msg}}}</h1>
  </div>
</template>

<script>
  export default {
    name: 'ComponentA',
    data(){
      return{
        msg:'这是组件A',
      }
    }
  }
</script>

<style scoped>
  h1{
    color: yellow;
  }
</style>
