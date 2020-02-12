<template>
  <div>
    <h1>{{msg}}}</h1>
  </div>
</template>

<script>
  export default {
    name: 'ComponentC',
    data(){
      return{
        msg:'这是组件C',
      }
    }
  }
</script>

<style scoped>
h1{
  color: red;
}
</style>
