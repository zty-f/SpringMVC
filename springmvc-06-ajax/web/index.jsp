<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <%--<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script> 在线的jquery--%>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <script>
      function a(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{'name':$("#username").val()},
          success:function (data,status) {
            console.log("data="+data);
            console.log("status="+status);
          }
        });
      }
    </script>
  </head>
  <body>


  <%--onblur：失去焦点触发事件,发送请求到后台--%>
  用户名：<input type="text" id="username" onblur="a()"/>


  </body>
</html>
