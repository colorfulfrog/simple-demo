<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'log.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js" charset="utf-8"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
	count=0;
		function senddata(){
			var datalist={"mobile":$("#mobile").val()};
			
		$.ajax({
            url:'<%=basePath%>/e/driver/BsDriverLocationController/upmobile',
            type: "POST",
            dataType: "json",
            data: JSON.stringify(datalist),
            cache: false,
            contentType: "application/json",
            success:function(data){
            	$("#h1").css("font-size","100px").html(++count);
            },
            error: function(){
            }
        });
        }
        
	function start(){		
		setInterval(function(){
            senddata();
          },10000);
	}
	</script>

  </head>
  
  <body>
    <input type="input" name="mobile" id="mobile" /><br/> <input type="button" value="Test" onclick="start()"/>
    <h1 id="h1"></h1>
  </body>
</html>
