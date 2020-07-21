<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="width:60%;margin:0 auto">
	<h1 align="center">武汉理工大学校内超市商品分类信息</h1>
	<table class="table table-striped table-bordered table-hover" width="40%">
		<thead>
			<tr align="center">
				<th>编号</th>
				<th>分类名称</th>
				<th>推荐指数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.recommend}</td>
				<td>
					&nbsp;&nbsp;
         			<a href="/SupermarketMS/toUpdateCategory?id=${category.id}" class="btn btn-sm btn-primary" >修改&nbsp;<span class="glyphicon glyphicon-pencil"></span></a>
         			&nbsp;&nbsp;
         			<a href="/SupermarketMS/deleteCategory?id=${category.id}" class="btn btn-sm btn-danger">删除&nbsp;<span class="glyphicon glyphicon-trash"></span></a>
       			</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>
<div style="width:30%;margin:50px auto;height:250px;padding:50px 70px;">
		
	<form action="/SupermarketMS/addCategory" method="post" >

		<table>
			<tr>
				<td>
					<label style="margin-right: 30px">分类名称</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="name"/>
				</td>
			</tr>
			<tr>
				<td>
					<label style="margin-right: 30px">推荐等级</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="recommend"/>
				</td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" style="margin-left: 120px;margin-top: 30px;" value="增加">
		
	</form>
</div>