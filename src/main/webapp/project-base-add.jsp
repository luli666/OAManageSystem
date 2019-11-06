<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加项目信息</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        function commit(){
            $("#form2").submit();
        }

        $(function () {
            /*回填公司名称*/
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/customer/info",
                success:function (msg) {
                    $(msg).each(function (index,elem) {
                        var option = "<option value='"+elem.id+"'>"+elem.comname+"</option>"
                        $("#select_comname").append(option)
                    })
                }
            })
            /*回填项目经理*/
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/employee/info",
                success:function (msg) {
                    $(msg).each(function (index,elem) {
                        var option = "<option value='"+elem.eid+"'>"+elem.ename+"</option>"
                        $("#select_empFk").append(option)
                    })
                }
            })

            /*回填公司联系人*/
            $("#select_comname").change(function () {
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/customer/infobyid/"+$(this).val(),
                    success:function (msg) {
                        $(msg).each(function (index,elem) {
                            $("#input_comper").val(elem.companyperson)
                        })
                    }
                })
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
                        当前位置:项目管理>>添加项目基本信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/project/insert" method="POST">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="${pageContext.request.contextPath}/skin/images/frame/tbg.gif">&nbsp;添加新项目信息&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">项目名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="pname" placeholder="请输入项目名称"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">客户公司名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="comname" id="select_comname">
                    <option>--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">客户方负责人：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" id="input_comper" readonly name="comper" placeholder="请输入客户方负责人"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">项目经理：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="empFk" id="select_empFk">
                    <option>--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">开发人数：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="empcount" placeholder="请输入开发人数"/>人
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" onclick="WdatePicker({minDate:'%y-%M-%d',skin:'twoer'})" id="starttime" name="starttime" placeholder="请输入开始时间"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">立项时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" onclick="WdatePicker({minDate:'%y-%M-%d',skin:'twoer'})" name="buildtime" placeholder="请输入立项时间"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">预估成本：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="cost" placeholder="请输入预估成本"/>万
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">级别：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="level">
                    <option value="紧急">紧急</option>
                    <option value="一般">一般</option>
                    <option value="暂缓">暂缓</option>
                </select>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">计划完成时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" onclick="WdatePicker({minDate:'%y-%M-%d',skin:'twoer'})" name="endtime" placeholder="请输入计划完成时间"/>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea type="text" rows=15 cols=130 onchange="change()" name="remark"></textarea>
                <span id="number"></span>
            </td>
        </tr>

        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a class="coolbg" href="javascript:commit()">保存</a>
                <a href="javascript:history.go(-1)" class="coolbg">返回</a>
            </td>
        </tr>
    </table>

</form>


</body>
</html>