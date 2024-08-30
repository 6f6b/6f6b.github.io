<template>
	<button v-on:click="mark">You clicked me {{ count }} times.</button>
</template>

<script>
	export default {
		name:'button-center',
		inject:['getM'],
		data (){
			return {
				count: this.count
			}
		},
		methods:{
			mark:function (){
				this.count++
				console.log(this.$parent)
			}
		}
	}
</script>

<style>
</style>
