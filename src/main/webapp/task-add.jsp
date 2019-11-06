<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>创建任务</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="static/js/jquery-3.1.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        $(function () {
            //回填项目信息
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/project/infoAndAtta",
                success:function (list) {
                    $(list).each(function () {
                        var option = "<option value='" + this.pid + "'>"+ this.pname +"</option>"
                        $("#select_project").append(option)
                    })
                }
            })
            /*回填执行者信息*/
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/customer/infoAndTask",
                success:function (list) {
                    $(list).each(function () {
                        var option = "<option value='" + this.eid + "'>"+ this.ename+"&nbsp;&nbsp;--&nbsp;&nbsp;"+ this.name  +"</option>"
                        $("#select_empFk2").append(option)
                    })
                }
            })
            //当项目信息改变时，查询需求分析表，回填需求分析
            $("#select_project").change(function () {
                //清空后面所有的元素
                $("#select_analysis option:gt(0)").remove()
                $("#select_module option:gt(0)").remove()
                $("#select_function option:gt(0)").remove()
                $("#input_tasktitle").val("")

                var pid = $(this).val();
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/analysis/info1/"+pid,
                    success:function (analysis) {
                        $(analysis).each(function () {
                            var option = "<option value='" + this.id + "' >"+ this.title +"</option>"
                            $("#select_analysis").append(option)
                        })
                    }
                })
            })
            /*当需求信息改变时，回填模块信息*/
            $("#select_analysis").change(function () {
                //清楚后面的元素
                $("#select_module option:gt(0)").remove()
                $("#select_function option:gt(0)").remove()
                $("#input_tasktitle").val("")

                var id = $(this).val()
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/moduls/info/" + id,
                    success:function (moduls) {
                        $(moduls).each(function (index,elem) {
                            var option = "<option value='" + this.id + "' >"+ this.modname +"</option>"
                            $("#select_module").append(option)
                        })
                    }
                })
            })
            //当模块信息改变时，回填功能信息
            $("#select_module").change(function () {
                //清楚后面的元素
                $("#select_function option:gt(0)").remove()
                $("#input_tasktitle").val("")

                var id = $(this).val()
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/function/info/" + id,
                    success:function (moduls) {
                        $(moduls).each(function (index,elem) {
                            var option = "<option value='" + this.id + "' >"+ this.functionname +"</option>"
                            $("#select_function").append(option)
                        })
                    }
                })
            })
            /*$("#select_function").change(function () {
                /!*清空数据*!/
                $("#input_tasktitle").val("")
                //回填数据
                var str = $(this).val()
                var arr = str.split("_");
                /!*回填数据*!/
                $("#input_tasktitle").val(arr[1])
            })*/
        })
        function commit() {
            $("#form2").submit()
        }
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
                        当前位置:任务管理>>创建任务
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/task/insert" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="skin/images/frame/tbg.gif">&nbsp;创建任务&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select style="width: 130px" id="select_project">
                    <option >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---请选择---</option>
                </select>-
                <select style="width: 130px" id="select_analysis">
                    <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---请选择---</option>
                </select>-
                <select style="width: 130px" id="select_module">
                    <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---请选择---</option>
                </select>-
                <select style="width: 130px" id="select_function" name="funFk">
                    <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---请选择---</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="tasktitle" id="input_tasktitle" placeholder="请输入任务标题"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" onclick="WdatePicker({minDate:'%y-%M-%d',skin:'twoer'})" id="starttime" name="starttime" placeholder="请输入开始时间"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" onclick="WdatePicker({minDate:'%y-%M-%d',skin:'twoer'})" id="endtime" name="endtime" placeholder="请输入结束时间"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select id="select_empFk2" name="empFk2">

                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="level">
                    <option value="高">高</option>
                    <option value="中">中</option>
                    <option value="低">低</option>
                    <option value="暂缓">暂缓</option>
                </select>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">详细说明：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130 name="remark"></textarea>
            </td>
        </tr>

        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a href="javascript:commit()" class="coolbg">保存</a>
                <a href="javascript:history.go(-1)" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>

</body>
</html>