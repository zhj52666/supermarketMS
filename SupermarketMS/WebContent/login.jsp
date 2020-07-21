<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	window.onload = function(){
		var img=document.getElementById("checkCode");
		var bt = document.getElementById("change");
		bt.onclick=function(){
			var date = new Date().getTime();
			img.src = "checkCode?"+date;
		}
		img.onclick=function(){
			var date = new Date().getTime();
			img.src = "checkCode?"+date;
		}
	}	
</script>
<style type="text/css">
.error{
	color=red;
}
</style>
<title>登录</title>
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="alert alert-info">
				 <button type="button" class="close" data-dismiss="alert">×</button>
				<h4>
					温馨提示!
				</h4> <strong>警告!</strong> 非本校内超市管理人员人请注意你的个人行为，您无权访问本页面。
			</div>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span12">
			<h3 class="text-center">
				武汉理工大学超市管理系统
			</h3>
		</div>
	</div>
	<div class="container"> 
    	<div class="form-horizontal">
    		<form class="form-horizontal" action="/SupermarketMS/login" method="post">
    			<div class="form-group">
            		<label class="col-sm-2 control-label">用户名</label>
            		<div class="col-sm-10">
                		<input type="text" class="form-control" name="username" placeholder="请输入用户名">
            		</div>
        		</div>

        		<div class="form-group">
           			<label class="col-sm-2 control-label">密码</label>
            		<div class="col-sm-10">
                		<input type="password" class="form-control" name="password" placeholder="请输入密码">
            		</div>
        		</div>
        		
        		<div class="form-group">
           			<label class="col-sm-2 control-label">验证码</label>
            		<div class="col-sm-10">
                		<input type="text" class="form-control" name="checkCode" placeholder="请输入验证码">
                		<img id="checkCode" src="/SupermarketMS/checkCode"><a href="#" id="change" >看不清，换一张？</a>
            		</div>
        		</div>
       		
        		<div class="form-group" style="margin-left: 300px">
            		<div class="col-sm-6">
                		<button type="submit" class="btn btn-primary" style="margin:0 80px ">登陆</button>
						<a class="btn btn-secondary" href="/SupermarketMS/index.jsp">返回</a>
            		</div>
        		</div>
    		</form>
		</div>
	</div>
	
	<div class="error"><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div> 
	<div class="error"><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %> </div>
	<div class="text-center" id="footer" style="height: 100px; width: auto;padding-top: 30px;background-color: #e7e7e7;position: fixed;left: 0;bottom: 0;right: 0">
		<a href="http://beian.miit.gov.cn" target="_blank">冀ICP备20009856号</a>
		<p><a href="#">本网站站最终解释权归武汉理工大学，严禁盗用侵权</a></p>
	</div>	
</div>
</body>
</html>