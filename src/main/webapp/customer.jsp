<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>客户信息管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></script>
    
    <style>
        #uploadImg{
            font-size:16px;
            overflow:hidden;
            position:absolute
        }
        #file{
            position:absolute;
            z-index:100;
            margin-left:-180px;
            font-size:60px;
            opacity:0;
            filter:alpha(opacity=0); margin-top:-5px;
        }
    </style>
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="${pageContext.request.contextPath}/skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:客户信息管理>>客户信息
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/customer-add.jsp';" value='添加客户信息'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='${pageContext.request.contextPath}/customer/search' method='get'>

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
                                <option value='1'>客户所在公司名称</option>
                                <option value='2'>联系人姓名</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' name='keyword' placeholder="请输入关键字" value='' style='width:120px'/>
                        </td>
                        <td width='110'>
                            <select name='orderby' style='width:120px'>
                                <option value='0'>正序</option>
                                <option value='1'>逆序</option>
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
            <td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">联系人</td>
            <td width="10%">公司名称</td>
            <td width="8%">添加时间</td>
            <td width="8%">联系电话</td>
            <td width="10%">操作</td>
        </tr>

        <c:forEach items="${customers}" var="customer" varStatus="index">
            <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <td><input name="id" type="checkbox" id="id" value="${customer.id}" class="np"></td>
                <td>${index.count}</td>
                <td>${customer.companyperson}</td>
                <td align="center">${customer.comname}</td>
                <td>
                    <fmt:formatDate value="${customer.addtime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>
                <td>${customer.comphone}</td>
                <td><a href="${pageContext.request.contextPath}/customer/edit/${customer.id}">编辑</a> | <a href="${pageContext.request.contextPath}/customer/look/${customer.id}">查看详情</a></td>
            </tr>
        </c:forEach>

        <tr bgcolor="#FAFAF1">
            <td height="28" colspan="12">
                &nbsp;
                <a href="javascript:checkAll()" class="coolbg">全选</a>
                <a href="javascript:reverse()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:del()" class="coolbg">&nbsp;删除&nbsp;</a>
                <a href="javascript:exportExcel()" class="coolbg">&nbsp;导出Excel&nbsp;</a>
                <span id="uploadImg">
                   <input type="file" id="file" size="1" onclick="importExcel()" >
                   <a href="javascript:void(0)" >上传Excel</a>
                </span>
            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center"><!--翻页代码 --></td>
        </tr>
    </table>

</form>
    <script type="text/javascript">
        /*导入表格*/
        function importExcel() {
            /*获取表单信息*/
            var formdata = new FormData();
            /*创建定时器*/
            var time = setInterval(function () {
                //获取文件
                var file = $("#file")[0].files[0];
                if(file != undefined){
                    //若获取到文件，则清楚定时器
                    clearInterval(time)
                    formdata.append("multipart",file);
                    //异步上传
                    $.ajax({
                        type:"post",
                        url:"${pageContext.request.contextPath}/customer/importExcel",
                        data:formdata,
                        cache:false,
                        processData:false,
                        contentType:false,
                        success:function (map) {
                            alert(map.msg)
                            window.location.href = "${pageContext.request.contextPath}/customer/list"
                        }
                    })
                }
            })


        }
        /*导出表格*/
        function exportExcel() {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/customer/export",
                success:function (info) {
                    if(info == true){
                        alert("导出成功!")
                    }else{
                        alert("导出失败!")
                    }
                }
            })
        }
        /*删除*/
        function del() {
            var ids = "";
            $(".np:checked").each(function () {
                ids = ids + ","+ $(this).val();
            })
            /*ids为空退出*/
            if(ids == null || ids == '' ){
                alert("请先选则要删除的记录")
                return ;
            }
            if(!confirm("确定要删除记录吗?")){
                return ;
            }
            ids = ids.substring(1);
            //同步请求的方式
            //window.location.href = "${pageContext.request.contextPath}/customer/delete?ids="+ids;
            //异步请求
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/customer/delete/"+ids,
                data:{"_method":"delete"},
                success:function (map) {
                    if(map.status == 200){
                        window.location.href = "${pageContext.request.contextPath}/customer/list";
                    }else{
                        alert(map.msg);
                        window.location.href = "${pageContext.request.contextPath}/customer/list";
                    }
                },
                error:function () {
                    alert("删除失败");
                    window.location.href = "${pageContext.request.contextPath}/customer/list";
                }
            })
        }

        /*全选*/
        function checkAll() {
            $("[type='checkbox']").prop("checked",true);
        }
        /*反选*/
        function reverse() {
            $("[type='checkbox']").each(function () {
                var info = !($(this).prop("checked"))
                $(this).prop("checked",info)
            })
        }
    </script>

</body>
</html>