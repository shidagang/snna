<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page language="java" import="cn.com.na.utils.PhapiAesUtil" %>
<%@ page language="java" import="cn.com.na.bean.Constants" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>邮箱激活账号</title>
</head>

<%
String encode = PhapiAesUtil.encode("2",Constants.ACC_KEY);
%>

<body>
<h2><a href="http://192.168.41.44:9090/snna/sendEmail/validate?cp=<%=encode%>">激活测试 </a></h2>
</body>
</html>