<template>
  <div id="app">
    <transition-button></transition-button>
    <router-view/>
  </div>
</template>

<script>
import TransitionButton from './components/transition-button'

export default {
  name: 'App',
  components: {TransitionButton}
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
