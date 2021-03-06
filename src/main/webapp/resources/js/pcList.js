$(document).ready(function(){
	$.ajax({
		url: "/demo/RESTComputer/list",
		type: "GET",
		dataType: "json",
		success:function(data){
			
			var content = "<thead><tr><th>商品id</th><th>商品名称</th><th>商品价格</th><th>更新</th><th>删除</th></tr></thead>";
			
			//v-value, i-index
			data.forEach(function(v,i){
				/* console.log(v.cid + ' ' + v.tradeMark + ' ' + v.price + ' ' + v.pic); */
				content += "<tr><td>"+v.cid+'</td><td><a id="pc" href="javascript:void(0);" onClick="pcClick(this)" value="'+ v.cid +'">'+v.tradeMark+"</a></td><td>"+v.price+"元</td>"+
							'<td><a href="/demo/RESTComputer/update/'+v.cid+'">更新</a></td>'+
							'<td><a href="/demo/RESTComputer/delete/'+v.cid+'">删除</a></td>'+
							"</tr>";
			}); 
			$('#pcTable').append("<tbody>"+content+"</tbody>");
		}
	
	});	
});
function pcClick(obj){
//	alert(obj.getAttribute("value"));
	$('#myModal').modal();
	var cid = obj.getAttribute("value");
	$.ajax({
	
		url: "/demo/RESTComputer/query/" + cid,
		type: "GET",
		dataType: "json",
		success:function(data){
				/*console.log(data.cid + ' ' + data.tradeMark + ' ' + data.price + ' ' + data.pic);*/
				$('#trade_mark').text("商品名称:  " + data.tradeMark);
				$('#pcprice').text("商品价格: " + data.price + "元");
				$('#pcpic').attr("src", "/demo/resources/pic/" + data.pic);
			}
	});	
}

