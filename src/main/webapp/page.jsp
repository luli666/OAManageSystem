<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#skip").change(function () {
                var pageNum = $(this).val()
                var regex = /^\d*$/;
                //判断是否为数字
                if(!regex.test(pageNum)){
                    alert("请输入正确的页码")
                    return ;
                }
                window.location.href = "${requestURI}?pageNum="+pageNum+"${params}";
            })
        })
    </script>
</head>
<body>
    <a style="font-size: 14px" href="${requestURI}?pageNum=1${params}">首页</a>
    <a style="font-size: 14px" href="${requestURI}?pageNum=${page.pageNum-1}${params}">上一页</a>
    <c:forEach items="${page.navigatepageNums}" var="num">
        <c:if test="${num == page.pageNum}">
            <span style="font-weight: bold;font-size: 15px">${num}</span>
        </c:if>
        <c:if test="${num != page.pageNum}">
            <a style="font-size: 14px" href="${requestURI}?pageNum=${num}${params}">${num}</a>
        </c:if>
    </c:forEach>
    <a style="font-size: 14px" href="${requestURI}?pageNum=${page.pageNum+1}${params}">下一页</a>
    <a style="font-size: 14px" href="${requestURI}?pageNum=${page.total-1}${params}">尾页</a>
    &nbsp;&nbsp;跳转到<input size="3px" type="text" id="skip"/>页
</body>
</html>
