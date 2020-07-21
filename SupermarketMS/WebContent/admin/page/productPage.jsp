<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="background-color: #f1f1ef">

	<div style="width:90%;margin:0px auto;height:150px;padding:20px 80px 120px 80px; border: 1px">
		
	<h1 align="center">武汉理工大学校内超市商品库存信息</h1>
		
	<form action="/SupermarketMS/selectProduct" method="post" >
		<table>
			<tr>
				<td>
					<h5 style="margin-right: 30px">商品名称:</h5>
				</td>
				<td>
					<input class="form-control" type="text" name="name"/>
				</td>
				<td>
					<h5 style="margin-right: 30px">&nbsp;&nbsp;&nbsp;&nbsp;商品分类:</h5>
				</td>
				<td>
					<select class="form-control" name="cid">
					<option value="">请选择分类</option>
						<c:forEach items="${categories}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<h5 style="margin-right: 30px">&nbsp;&nbsp;&nbsp;&nbsp;生产时间由:</h5>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="date" name="front"/>
				</td>
				<td>
					<h5 style="margin-right: 30px">&nbsp;&nbsp;&nbsp;&nbsp;到:</h5>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="date" name="rear"/>
				</td>
				<td>
					<input type="submit" class="btn btn-success" style="margin-left: 20px;" value="查找">	
				</td>
				<td>
					<a href="/SupermarketMS/toAddProduct" class="btn btn-primary" style="margin-left: 20px;" >添加</a>
				</td>
			</tr>
		</table>
		
	</form>
</div>
<div style="width:80%;margin:0 auto;height: 400px;">	
	<table class="table table-striped table-bordered table-hover" width="40%">
		<thead>
			<tr align="center">
				<th>编号</th>
				<th>分类</th>
				<th>名称</th>
				<th>生产日期</th>
				<th>厂家</th>
				<th>进价</th>
				<th>进货日期</th>
				<th>库存数</th>
				<th>售价</th>
				<th>售出数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.category!=null?product.category.name:null}</td>
				<td>${product.name}</td>
				<td><fmt:formatDate value="${product.yieldDate}" pattern="yyyy-MM-dd"/></td>
				<td>${product.manufacturers}</td>
				<td>${product.price}</td>
				<td><fmt:formatDate value="${product.createDate}" pattern="yyyy-MM-dd"/></td>
				<td>${product.stock}</td>
				<td>${product.nowPrice}</td>
				<td>${product.saleCount}</td>
				<td>
					&nbsp;&nbsp;
					<a href="/SupermarketMS/toAddStock?id=${product.id}" class="btn btn-sm btn-primary" >增加库存 &nbsp;<span class="glyphicon glyphicon-plus"></span></a>
         			&nbsp;&nbsp;
         			<a href="/SupermarketMS/toUpdateProduct?id=${product.id}" class="btn btn-sm btn-primary" >修改&nbsp;<span class="glyphicon glyphicon-pencil"></span></a>
         			&nbsp;&nbsp;
         			<a href="/SupermarketMS/deleteProduct?id=${product.id}" class="btn btn-sm btn-danger">删除&nbsp;<span class="glyphicon glyphicon-trash"></span></a>
       			</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
</div>