<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div style="background-color: #f1f1ef">

	<div style="width:70%;margin:0px auto;height:150px;padding:20px 80px 120px 80px; border: 1px">
		
		<h1 align="center">武汉理工大学校内超市收银台</h1>
		
	<form action="/SupermarketMS/checkstand" method="post" >

		<table>
			<tr>
				<td>
					<h3 style="margin-right: 30px">商品编号:</h3>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="pid"/>
				</td>
				<td>
					<h3 style="margin-right: 30px">&nbsp;&nbsp;&nbsp;&nbsp;购买数量:</h3>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="count"/>
				</td>
				<td>
					<input type="submit" class="btn btn-success" style="margin-left: 20px;" value="提交">	
				</td>
			</tr>
		</table>
		
	</form>
</div>
<div style="width:60%;margin:0 auto;padding-bottom: 120px;">
	<h2 align="lef">销售明细：</h2>
	<c:if test="${product!=null}">
    <table>
		<tr>
			<td><h3 style="margin-right: 30px">商品名称:</h3></td>
			<td><h3 style="margin-right: 30px">${product.name}</h3></td>
			<td><h3 style="margin-right: 30px">销售单价:</h3></td>
			<td><h3 style="margin-right: 30px">${product.nowPrice}</h3></td>
			<td><h3 style="margin-right: 30px">购买数量:</h3></td>
			<td><h3 style="margin-right: 30px">${count}</h3></td>
		</tr>
		<tr>
			<td><h3 style="margin-right: 30px">应付金额:</h3></td>
			<td><h3 style="margin-right: 30px">${product.nowPrice*count}</h3></td>
			<td><h3 style="margin-right: 30px">实收金额:</h3></td></td>
			<td><input id="money" class="form-control" type="text" name="money"/></td>
			<td></td>
			<td><button onclick="f(${product.nowPrice*count})">计算找零</button></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><h3 style="margin-right: 30px">找零:</h3></td>
			<td><h3 id="show" style="margin-right: 30px">0.0 元</h3></td>
		</tr>
	</table>	
	</c:if>
	
</div>

</div>
<script type="text/javascript">
	
	function f(event){
		var m = 0;
		m = $("#money").val();
		alert("找零："+(m-event)+" 元！");
		$("#show").text((m-event) + " 元");
	}

</script>
