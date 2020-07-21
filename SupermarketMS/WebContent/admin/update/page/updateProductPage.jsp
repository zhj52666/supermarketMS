<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="width:30%;margin:50px auto;height:250px;padding:50px 70px;">
		
	<form action="/SupermarketMS/updateProduct" method="post" >
		<input type="hidden" name="id" value="${product.id}">
		<table>
			<tr>
				<td>
					<label style="margin-right: 30px">商品名称</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="name" value="${product.name}"/>
				</td>
			</tr>
				<td>
					<label style="margin-right: 30px">商品分类</label>
				</td>
				<td><!-- path相当于name属性 -->
					<select class="form-control" name="cid">
						<c:forEach items="${categories}" var="category">
							<c:if test="${product.cid==category.id}">
								<option value="${category.id}" selected="selected">${category.name}</option>
							</c:if>
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
				</td>
			<tr>
				<td>
					<label style="margin-right: 30px">生产日期</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="date" name="yieldDate" value="<fmt:formatDate value="${product.yieldDate}" pattern="yyyy-MM-dd"/>"/>
				</td>
			</tr>
			<tr>
				<td>
					<label style="margin-right: 30px">生产厂家</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="manufacturers" value="${product.manufacturers}"/>
				</td>
			</tr>
			<tr>
				<td>
					<label style="margin-right: 30px">进价：</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="price" value="${product.price}"/>
				</td>
			</tr>
			<tr>
				<td>
					<label style="margin-right: 30px">库存：</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="stock" value="${product.stock}"/>
				</td>
			</tr>
			<tr>
				<td>
					<label style="margin-right: 30px">售价：</label>
				</td>
				<td><!-- path相当于name属性 -->
					<input class="form-control" type="text" name="nowPrice" value="${product.nowPrice}"/>
				</td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" style="margin-left: 120px;margin-top: 30px;" value="修改">
		
	</form>
</div>