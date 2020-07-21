<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="width:30%;margin:50px auto;height:250px;padding:50px 70px;">
		
	<form action="/SupermarketMS/updateCategory" method="post" >
		<input type="hidden" name="id" value="${category.id}">
		<table>
			<tr>
				<td>
					<label style="margin-right: 30px">分类名称</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="name" value="${category.name}"/>
				</td>
			</tr>
			<tr>
				<td>
					<label style="margin-right: 30px">推荐等级</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="recommend" value="${category.recommend}"/>
				</td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" style="margin-left: 120px;margin-top: 30px;" value="修改">
		
	</form>
</div>