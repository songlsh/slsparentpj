<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜鸟教程(runoob.com)</title>
<script src="https://static.runoob.com/assets/vue/1.0.11/vue.min.js"></script>
</head>
<body>
<div id="app">
	<div class="checkbox">
		<label for="quan">
			<!-- 这里的 $event 是将当前对象传入进去，具体详情请参照vue官方文档 -->
			<input id="quan" type="checkbox" v-model="checkQuan"  @click="checkAll()"> 全选
		</label>
		<label v-for="item in ajaxData">
			<!-- v-model 双向数据绑定命令 -->
			<input class="checkItem" type="checkbox" :value="item.value" v-model="checkData"> {{item.name}}
		</label>
	</div>
</div>
<script>
	new Vue({
		el: '#app',
		data(){
			return {
				ajaxData: [{ // 后台请求过来的数据
					name: '选项1',
					value: 'apple'
				},{
					name: '选项2',
					value: 'banana'
				},{
					name: '选项3',
					value: 'orange'
				}],
				checkData: [], // 双向数据绑定的数组
				checkQuan : false
			}
		},
		watch: {
			checkData: { // 监视双向绑定的数组变化
				handler(){
					if(this.checkData.length == this.ajaxData.length){
						this.checkQuan = true;
					}else {
						this.checkQuan = false;
					}
				},
				deep: true
			}
		},
		methods: {
			checkAll(){ // 点击全选事件
				this.checkData = [];
				//alert(this.checkQuan);
                if(this.checkQuan){
					alert(this.checkQuan);
                  this.checkData = [];
                }else { // 全不选选则清空绑定的数组
					//alert(this.checkQuan);
					this.checkData = [];
					  for(var i in this.ajaxData){
						// alert(this.ajaxData[i].value);
                        this.checkData.push(this.ajaxData[i].value)
                    }
				}

			}
		}
	});
</script>
</body>
</html>
