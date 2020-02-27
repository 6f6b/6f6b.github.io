
<template>
	<div></div>
</template>

<script>
  // import my from 'myproperties'

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
            var vm = new Vue()
            console.log(vm.$myProperty)
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
