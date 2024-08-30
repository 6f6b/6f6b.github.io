<template>
	<div>
    <h2>刘丰牛逼</h2>
    <slot>默认值</slot>
  </div>
</template>

<script>
	export default {
		name:'button-counter-father',
		data:function (){
			return {
        title:"妈卖批",
        liufeng:'keyie'
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
					  getM:this.getMap,
				  }
		}
	}
</script>

<style>
</style>
