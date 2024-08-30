<template>
	<div></div>
</template>

<script>
	export default {
		name:'button-counter-father',
		data:function (){
			return {
				
			}
		}
		,
		methods:{
				  getMap:function(){
					  console.log('获取地图')
				  }
		},
		provide:function (){
				  return {
					  getM:this.getMap(),
				  }
		}
	}
</script>

<style>
</style>
