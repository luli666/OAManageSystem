<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>任务信息</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/moment.min.js"></script>
    <script type="text/javascript">
        /*全选*/
        function checkout(){
            $("[type='checkbox']").prop("checked",true);
        }
        /*反选*/
        function reverse(){
            $("[type='checkbox']").each(function () {
                var info = $(this).prop("checked")
                $(this).prop("checked",!info)
            })
        }
        /*删除*/
        function del(){
            var ids = ""
            $("input:checked").each(function () {
                ids = ids +"," + $(this).val()
            })
            if(ids == null || ids == ""){
                alert("请选择要删除的记录")
                return ;
            }
            if(!confirm("确定要删除选中的记录吗")){
                return ;
            }
            ids = ids.substring(1)
            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/task/delete/"+ids,
                data:{"_method":"delete"},
                success:function (map) {
                    if(map.statusCode == 200){
                        window.location.href = "${pageContext.request.contextPath}/task.jsp"
                    }else{
                        alert(map.msg)
                        window.location.href = "${pageContext.request.contextPath}/task.jsp"
                    }
                },error:function () {
                    alert("删除失败")
                    window.location.href = "${pageContext.request.contextPath}/task.jsp"
                }
            })
        }

        $(function () {
            /*回填所有数据*/
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/task/list",
                success:function (list) {
                    $(list).each(function (index,elem) {
                        var tr1 = "<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\"\n" +
                            "            onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\n" +
                            "            <td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\""+ elem.id +"\" class=\"np\"></td>\n" +
                            "            <td>"+ (index + 1) +"</td>\n" +
                            "            <td>"+ elem.tasktitle +"</td>\n" +
                            "            <td align=\"center\">"+ elem.ename +"</td>\n"
                        var tr2
                        if(elem.status == 0) {
                            tr2 = "<td align=\"center\">未进行...</td>\n"
                        }else if(elem.status == 1){
                            tr2 = "<td align=\"center\">进行中...</td>\n"
                        }else{
                            tr2 = "<td align=\"center\">已完成...</td>\n"
                        }
                        var tr3 = "            <td align=\"center\">"+ elem.level +"</td>\n" +
                            "            <td>" + moment(elem.starttime).format("YYYY-MM-DD") + "</td>\n" +
                            "            <td>" + moment(elem.endtime).format("YYYY-MM-DD") + "</td>\n" +
                            "            <td><!--<a>开始任务</a> | <a>任务完成</a> | --><a href=\"task-edit.jsp\">编辑</a> | <a href=\"${pageContext.request.contextPath}/task/look/"+ elem.id +"\">查看详情</a></td>\n" +
                            "        </tr>"
                        var tr = tr1 + tr2 + tr3
                        $("#insert_tr").before(tr)
                    })
                }
            })
        })
    </script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/frame/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="skin/images/frame/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:任务管理>>任务信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
    <input type='hidden' name='dopost' value=''/>
    <table width='98%' border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center"
           style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='skin/images/frame/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>状态：</td>
                        <td width='160'>
                            <select name='cid' style='width:150px'>
                                <option value='0'>请选择</option>
                                <option value='1'>未开始</option>
                                <option value='1'>进行中</option>
                                <option value='1'>已完成</option>
                            </select>
                        </td>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='cid' style='width:150px'>
                                <option value='0'>选择类型...</option>
                                <option value='1'>任务标题</option>
                                <option value='1'>执行者</option>
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
                                <option value='id'>排序...</option>
                                <option value='pubdate'>开始时间</option>
                                <option value='pubdate'>结束时间</option>
                            </select>
                        </td>
                        <td>
                            &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" src="skin/images/frame/search.gif"
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
            <td height="24" colspan="12" background="skin/images/frame/tbg.gif">&nbsp;任务信息&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">任务标题</td>
            <td width="10%">执行者</td>
            <td width="8%">状态</td>
            <td width="8%">优先级</td>
            <td width="8%">开始时间</td>
            <td width="8%">结束时间</td>
            <td width="15%">操作</td>
        </tr>



        <tr bgcolor="#FAFAF1" id="insert_tr">
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


</body>
</html>