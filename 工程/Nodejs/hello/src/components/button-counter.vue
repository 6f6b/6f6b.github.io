<template>
	<button v-on:click="mark">You clicked me {{ count }} times.</button>
</template>

<script>
	export default {
		name:'button-counter',
		inject:['getM'],
		data (){
			return {
				count: this.count
			}
		},
		methods:{
			mark:function (){
				this.count++
        this.getM()
				console.log(this.$parent.$data)
			}
		}
	}
</script>

<style>
</style>
