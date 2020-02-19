<template>
  <label>
    <input type="text">
<!--    <button-counter></button-counter>-->

    <button-counter-father>
      <button-counter></button-counter>
    </button-counter-father>
  </label>
</template>

<script>
  import ButtonCounterFather from '@/components/button-counter-father'
  import ButtonCounter from '@/components/button-counter'
  export default {
    name: 'ComponentC',
    components: {ButtonCounter, ButtonCounterFather},
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
