<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="width:35%;margin:50px auto;height:250px;padding:50px 70px;">
	
	<h1 align="center"> 请您为 ${product.name} 增加库存</h1>	
		
	<form action="/SupermarketMS/addStock" method="post" >
		<input type="hidden" name="id" value="${product.id}">
		<input type="hidden" name="oldStock" value="${product.stock}">
		<table>
			<tr>
				<td>
					<h4 style="margin-right: 30px">商品名称：</h4>
				</td>
				<td><!-- path相当于name属性 -->
					<h4 style="margin-right: 30px">${product.name}</h4>
				</td>
			</tr>
			<tr>
				<td>
					<h4 style="margin-right: 30px">增加库存数量</h4>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="stock"/>
				</td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" style="margin-left: 120px;margin-top: 30px;" value="增加">
		
	</form>
</div>