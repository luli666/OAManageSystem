<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>需求分析管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/moment.min.js"></script>
    <script type="text/javascript">
        /*模糊查询*/
        function commit(){
            //删除之前的记录
            $(".del_tr").remove();

            var cid = $("#cid").val();
            var keyword = $("#keyword").val();
            var orderby = $("#orderby").val();
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/analysis/list",
                data:{"cid":cid,"keyword":keyword,"orderby":orderby},
                success:function (list) {
                    $(list).each(function (index,elem) {
                        var tr = "<tr class='del_tr' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\n" +
                            "            onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\n" +
                            "            <td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\""+ elem.id +"\" class=\"np\"></td>\n" +
                            "            <td>"+ (index+1) +"</td>\n" +
                            "            <td>"+ elem.title +"</td>\n" +
                            "            <td align=\"center\"><a href=''><u>"+ elem.proname +"</u></a></td>\n" +
                            "            <td>"+ moment(elem.addtime).format('YYYY-MM-DD') +"</td>\n" +
                            "            <td>"+ moment(elem.updatetime).format('YYYY-MM-DD') +"</td>\n" +
                            "            <td><a href=\"${pageContext.request.contextPath}/analysis/info/"+ elem.id +"\">编辑</a> | <a href=\"${pageContext.request.contextPath}/analysis/look/"+ elem.id +"\">查看详情</a></td>\n" +
                            "     </tr>";
                        $("#sign").before(tr);
                    })
                }
            })
        }
        $(function () {
            /*查找所有*/
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/analysis/list",
                success:function (list) {
                    $(list).each(function (index,elem) {
                        var tr = "<tr class='del_tr' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\n" +
                            "            onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\n" +
                            "            <td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\""+ elem.id +"\" class=\"np\"></td>\n" +
                            "            <td>"+ (index+1) +"</td>\n" +
                            "            <td>"+ elem.title +"</td>\n" +
                            "            <td align=\"center\"><a href=''><u>"+ elem.proname +"</u></a></td>\n" +
                            "            <td>"+ moment(elem.addtime).format('YYYY-MM-DD') +"</td>\n" +
                            "            <td>"+ moment(elem.updatetime).format('YYYY-MM-DD') +"</td>\n" +
                            "            <td><a href=\"${pageContext.request.contextPath}/analysis/info/"+ elem.id +"\">编辑</a> | <a href=\"${pageContext.request.contextPath}/analysis/look/"+ elem.id +"\">查看详情</a></td>\n" +
                            "     </tr>";
                        $("#sign").before(tr);
                    })
                }
            })
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
                        当前位置:项目管理>>需求分析管理
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/project-need-add.jsp';"
                               value='添加新项目需求'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' id="form3" action='${pageContext.request.contextPath}/analysis/list' method='get'>
    <input type='hidden' name='dopost' value=''/>
    <table width='98%' id="table" border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center"
           style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='skin/images/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='cid' id="cid" style='width: 150px;'>
                                <option value='0'>选择类型...</option>
                                <option value='1'>项目名称</option>
                                <option value='2'>标题</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' id="keyword" name='keyword' value='' style='width:120px'/>
                        </td>
                        <td width='110'>
                            <select name='orderby' id="orderby" style='width:120px'>
                                <option value='0'>排序...</option>
                                <option value='1'>添加时间</option>
                                <option value='2'>修改时间</option>
                            </select>
                        </td>
                        <td>
                           <%-- &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="${pageContext.request.contextPath}/skin/images/frame/search.gif"
                                                     width="45" height="20" border="0" class="np"/>--%>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="button" onclick="commit()" value="搜索"
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
            <td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/frame/tbg.gif">&nbsp;需求列表&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">标题</td>
            <td width="10%">项目名称</td>
            <td width="8%">添加时间</td>
            <td width="8%">修改时间</td>
            <td width="10%">操作</td>
        </tr>

        <tr bgcolor="#FAFAF1" id="sign">
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
    function checkout(){
        $("[type='checkbox']").prop("checked",true);
    }
    /*反选*/
    function reverse(){
        $("[type='checkbox']").each(function () {
            var info = $(this).prop("checked");
            $(this).prop("checked",!info);
        })
    }
    /*删除*/
    function del() {
        var ids = "";
        $("input:checked").each(function () {
            ids = ids + "," + $(this).val();
        })
        if(ids == null || ids == ""){
            alert("请先选择要删除的记录")
            return ;
        }
        if(!(confirm("确定要删除选中的记录吗?"))){
            return ;
        }
        ids = ids.substring(1);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/analysis/delete/"+ids,
            data:{"_method":"delete"},
            success:function (map) {
                if(map.status == 200){
                    window.location.href = "${pageContext.request.contextPath}/project-need.jsp"
                }else{
                    alert(map.msg)
                    window.location.href = "${pageContext.request.contextPath}/project-need.jsp"
                }
            },error:function () {
                alert("删除失败")
                window.location.href = "${pageContext.request.contextPath}/project-need.jsp"
            }
        })

    }

</script>

</body>
</html>