<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include.jsp"%>
<form class="form-horizontal" action="${ctx}/public/doLogin">
	<div class="control-group">
		<label class="control-label" for="inputEmail">登入账号</label>
		<div class="controls">
			<input type="text" class="email" id="inputEmail" placeholder="Email" name="name">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputPassword">登入密码</label>
		<div class="controls">
			<input type="password" id="inputPassword" placeholder="Password" name="password">
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<label class="checkbox"> <input type="checkbox" name="rememberMe">
				Remember me
			</label>
		</div>
	</div>
</form>