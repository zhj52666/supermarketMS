<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="background-color: #f1f1ef">

	<div style="width:70%;margin:0px auto;height:150px;padding:20px 80px 120px 80px; border: 1px">
		
		<h1 align="center">武汉理工大学校内超市销售统计</h1>
		
	<form action="/SupermarketMS/saleShow" method="post" >
		<table>
			<tr>
				<td>
					<h3 style="margin-right: 30px">商品分类:</h3>
				</td>
				<td><!-- path相当于name属性 -->
					<select class="form-control" name="cid" selected="${sale.product.cid}">
						<c:forEach items="${categories}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<h3 style="margin-right: 30px">&nbsp;&nbsp;&nbsp;&nbsp;时间由:</h3>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="date" name="front"/>
				</td>
				<td>
					<h3 style="margin-right: 30px">&nbsp;&nbsp;&nbsp;&nbsp;到:</h3>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="date" name="rear"/>
				</td>
				<td>
					<input type="submit" class="btn btn-success" style="margin-left: 20px;" value="提交">	
				</td>
			</tr>
		</table>
		
	</form>
</div>
<div style="width:60%;margin:0 auto;padding-bottom: 120px;">
	<c:if test="${sales!=null}">
    	<table class="table table-striped table-bordered table-hover" width="40%">
		<thead>
			<tr align="center">
				<th>商品编号</th>
				<th>商品名称</th>
				<th>所属分类</th>
				<th>进价</th>
				<th>售价</th>
				<th>销量</th>
				<th>销售额</th>
				<th>净利润</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sales}" var="sale">
			<tr>
				<td>${sale.pid}</td>
				<td>${sale.product.name!=null?sale.product.name:null}</td>
				<td>${sale.product.category.name!=null?sale.product.category.name:null}</td>
				<td>${sale.product.price!=null?sale.product.price:null}</td>
				<td>${sale.product.nowPrice!=null?sale.product.nowPrice:null}</td>
				<td>${sale.saleCount}</td>
				<td>${sale.saleroom}</td>
				<td>${sale.profit}</td>
			</tr>
			</c:forEach>
		</tbody>
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