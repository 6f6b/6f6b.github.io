<template>
  <div>
    <button-counter-father>
<!--      <button-counter></button-counter>-->
    </button-counter-father>
  </div>
</template>

<script>
import ButtonCounter from "@/components/button-counter";
import ButtonCounterFather from "@/components/button-counter-father";
export default {
  name: 'HelloWorld',
  components: {ButtonCounter, ButtonCounterFather},
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
