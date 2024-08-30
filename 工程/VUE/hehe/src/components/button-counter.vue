<template>
	<button v-on:click="mark">You clicked me {{ count }} times.</button>
</template>

<script>
	export default {
		name:'button-counter',
    props:['count'],
		inject:['getM'],
		data (){
			return {
				count: 0
			}
		},
		methods:{
			mark:function (){
				this.count++
        // this.getM()
				// console.log(this.$parent)
			}
		}
	}
</script>

<style>
</style>
