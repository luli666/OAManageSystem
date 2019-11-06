<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>项目信息管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></script>

</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/frame/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="${pageContext.request.contextPath}/skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:项目管理>>基本信息管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/project-base-add.jsp';"
                               value='添加新项目'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='${pageContext.request.contextPath}/project/search' method='get'>

    <table width='98%' border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center"
           style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='${pageContext.request.contextPath}/skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='cid' style='width:150px;'>
                                <option value='0'>选择类型...</option>
                                <option value='1'>项目名称</option>
                                <option value='2'>项目经理</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='keyword' value='' style='width:120px'/>
                        </td>
                        <td width='110'>
                            <select name='orderby' style='width:120px'>
                                <option value='0'>排序...</option>
                                <option value='1'>立项时间</option>
                                <option value='2'>计划完成时间</option>
                            </select>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif"
                                                     width="45" height="20" border="0" class="np"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</form>
<!--  内容列表   -->
<form name="form2">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;项目信息列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">项目名称</td>
            <td width="10%">客户公司名称</td>
            <td width="10%">客户方负责人</td>
            <td width="5%">项目经理</td>
            <td width="8%">开发人员数</td>
            <td width="6%">立项时间</td>
            <td width="8%">最近更新时间</td>
            <td width="8%">计划完成时间</td>
            <td width="8%">状态</td>
            <td width="10%">操作</td>
        </tr>
        <%--获取系统时间--%>
        <jsp:useBean id="now" class="java.util.Date" scope="page"/>

        <c:forEach items="${projects}" varStatus="index" var="project">
            <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <td><input name="id" type="checkbox" id="id" value="${project.pid}" class="np"></td>
                <td>${index.count}</td>
                <td align="left"><a href=''><u>${project.pname}</u></a></td>
                <td>${project.customer.comname}</td>
                <td>${project.comper}</td>
                <td>${project.employee.ename}</td>
                <td>${project.empcount}</td>
                <td><fmt:formatDate value="${project.buildtime}" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${project.starttime}" pattern="yyyy-MM-dd" /></td>
                <td><fmt:formatDate value="${project.endtime}" pattern="yyyy-MM-dd" /></td>
                <td>
                    <c:if test="${now > project.endtime}"><span style="color: green">项目已完成</span></c:if>
                    <c:if test="${now <= project.endtime}"><span style="color: red">项目进行中</span></c:if>
                </td>
                <td><a href="${pageContext.request.contextPath}/project/edit/${project.pid}">编辑</a> | <a href="${pageContext.request.contextPath}/project/look/${project.pid}">查看详情</a></td>
            </tr>
        </c:forEach>

        <tr bgcolor="#FAFAF1">
            <td height="28" colspan="12">
                &nbsp;
                <a href="javascript:checkout()" class="coolbg">全选</a>
                <a href="javascript:reverse()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:del()" class="coolbg">&nbsp;删除&nbsp;</a>
                <a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center"><!--翻页代码 --></td>
        </tr>
    </table>

</form>
<script type="text/javascript">
    /*全选*/
    function checkout() {
        $("[type='checkbox']").prop("checked",true)
    }
    /*反选*/
    function reverse() {
        $("[type='checkbox']").each(function () {
            var info = $(this).prop("checked")
            $(this).prop("checked",!info)
        })
    }
    /*删除*/
    function del() {
        var ids = "";
        $("input:checked").each(function () {
            ids = ids + "," + $(this).val();
        })
        if(ids == null || ids == ''){
            alert("请先选择要删除的记录")
            return ;
        }
        if(!confirm("确定要删除选择的记录吗?")){
            return ;
        }
        ids = ids.substring(1)
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/project/delete/"+ids,
            data:{"_method":"delete"},
            success:function (map) {
                if(map.status == 200){
                    window.location.href = "${pageContext.request.contextPath}/project/list"
                }else{
                    alert(map.msg)
                    window.location.href = "${pageContext.request.contextPath}/project/list"
                }
            },
            error:function () {
                alert("删除失败111")
                window.location.href = "${pageContext.request.contextPath}/project/list"
            }
        })

    }
</script>
</body>
</html>