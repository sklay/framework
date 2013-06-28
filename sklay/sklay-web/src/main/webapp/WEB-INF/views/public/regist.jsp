<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include.jsp" %>
<form class="form-horizontal" action="${ctx}/public/doRegist">
	<div class="control-group">
		<label class="control-label" for="inputEmail">登入账号</label>
		<div class="controls">
			<input type="text" class="email" id="inputEmail" placeholder="账号" name="name">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputPassword">登入密码</label>
		<div class="controls">
			<input type="password" id="inputPassword" placeholder="密码" name="password">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="repeatPassword">重复密码</label>
		<div class="controls">
			<input type="password" id="repeatPassword" placeholder="重复密码" name="repetPassword">
		</div>
	</div>
</form>
