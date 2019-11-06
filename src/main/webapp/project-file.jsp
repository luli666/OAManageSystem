<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>附件管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></script>
    <script type="text/javascript">
        $(function () {
            if ($("#info").val() != 1) {
                $.ajax({
                    type: "get",
                    url: "${pageContext.request.contextPath}/attachment/list",
                    success: function (list) {
                        $(list).each(function (index, elem) {
                            var tr = "<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\n" +
                                "            onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\n" +
                                "            <td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"" + elem.id + "\" class=\"np\"></td>\n" +
                                "            <td>" + (index + 1) + "</td>\n" +
                                "            <td>" + elem.attname + "</td>\n" +
                                "            <td align=\"center\"><a href=''><u>" + elem.pname + "</u></a></td>\n" +
                                "            <td>1</td>\n" +
                                "            <td>2015-02-03</td>\n" +
                                "            <td>2015-06-03</td>\n" +
                                "            <td><a href=\"${pageContext.request.contextPath}/attachment/download/" + elem.id + "\">下载</a> |<a href=\"${pageContext.request.contextPath}/attachment/backfill/" + elem.id + "\">编辑</a> | <a\n" +
                                "                    href=\"${pageContext.request.contextPath}/attachment/look/" + elem.id + "\">查看详情</a></td>\n" +
                                "        </tr>"
                            $("#tr_insert").before(tr)
                        })
                    }
                })
            }
        })
    </script>
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/frame/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="${pageContext.request.contextPath}/skin/images/frame/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:项目管理>>附件管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np"
                               onClick="location='${pageContext.request.contextPath}/project-file-add.jsp';"
                               value='添加新附件'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='${pageContext.request.contextPath}/attachment/search' method='get'>
    <input type='hidden' name='dopost' value=''/>
    <table width='98%' border='1' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center"
           style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='${pageContext.request.contextPath}/skin/images/frame/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='cid' style='width:150px'>
                                <option value='0'>选择类型...</option>
                                <option value='1'>附件名称</option>
                                <option value='2'>项目名称</option>
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
                                <option value='1'>添加时间</option>
                                <option value='2'>修改时间</option>
                            </select>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="image"
                                                     src="${pageContext.request.contextPath}/skin/images/frame/search.gif"
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

    <input type="hidden" id="info" value="${info}">
    <table width="98%" border="1" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/frame/tbg.gif">
                &nbsp;附件列表&nbsp;
            </td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">附件名称</td>
            <td width="10%">所属项目</td>
            <td width="10%">附件个数</td>
            <td width="8%">上传时间</td>
            <td width="8%">修改时间</td>
            <td width="13%">操作</td>
        </tr>

        <c:forEach items="${list}" var="attachment" varStatus="index">
            <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <td><input name="id" type="checkbox" id="id" value="${attachment.id}" class="np"></td>
                <td>${index.count}</td>
                <td>${attachment.attname}</td>
                <td align="center"><a href=''><u>${attachment.pname}</u></a></td>
                <td>1</td>
                <td>2015-02-03</td>
                <td>2015-06-03</td>
                <td><a href="${pageContext.request.contextPath}/attachment/download/${attachment.id}">下载</a>
                    |<a href="${pageContext.request.contextPath}/attachment/backfill/${attachment.id}">编辑</a> | <a
                            href="${pageContext.request.contextPath}/attachment/look/${attachment.id}">查看详情</a></td>
            </tr>
        </c:forEach>

        <tr bgcolor="#FAFAF1" id="tr_insert">
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
    /*删除*/
    function del() {
        var ids = "";
        $("input:checked").each(function () {
            ids = ids + "," + $(this).val()
        })
        if (ids == null || ids == "") {
            alert("请先选择要删除的记录")
            return;
        }
        if (!(confirm("确定要删除选中的记录吗？"))) {
            return;
        }
        ids = ids.substring(1);
        $.ajax({
            type: "post",
            url: "${pageContext.request.contextPath}/attachment/deleteAll/" + ids,
            data: {"_method": "delete"},
            success: function (map) {
                if (map.status == 200) {
                    window.location.href = "${pageContext.request.contextPath}/project-file.jsp"
                } else {
                    alert(map.msg);
                    window.location.href = "${pageContext.request.contextPath}/project-file.jsp"
                }
            }, error: function () {
                alert("删除失败")
                window.location.href = "${pageContext.request.contextPath}/project-file.jsp"
            }
        })
    }

    /*全选*/
    function checkout() {
        $("[type='checkbox']").prop("checked", true);
    }

    /*反选*/
    function reverse() {
        $("[type='checkbox']").each(function () {
            var info = $(this).prop("checked");
            $(this).prop("checked", !info)
        })
    }
</script>
</body>
</html>