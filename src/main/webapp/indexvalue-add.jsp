<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>添加对标信息</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function commit() {
            $("#form").submit();
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
                        当前位置:对标管理>>添加对标基本信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<div>
    <form id="form" action="${pageContext.request.contextPath}/bench/insert" method="post">
    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="12" background="skin/images/frame/tbg.gif">&nbsp;<font color="red">对标企业信息如下</font>&nbsp;
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="comname" id="cname1"/>
            </td>

            <td align="right" bgcolor="#FAFAF1" height="22">营业额：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="salesAnount" id="money1"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">年份：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" id="year1" name="year"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">主要业务：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <textarea rows="3" cols="18" name="business"></textarea>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">优势：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <textarea rows="3" cols="18" name="priority"></textarea>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">劣势：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <textarea rows="3" cols="18" name="disadvantage"></textarea>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">行业地位：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="status" id="po1"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22">员工数量：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" name="empCount"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">创建时间：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="text" onclick="WdatePicker({skin:'twoer'})" name="createtime"/>
            </td>
            <td align="right" bgcolor="#FAFAF1" height="22"></td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">简单描述：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea type="text" rows=15 cols=130 name="remark"></textarea>
            </td>
        </tr>

        <tr bgcolor="#FAFAF1">
            <td height="28" colspan=4 align=center>
                &nbsp;
                <a href="javascript:commit()" class="coolbg">添加</a>
                <a href="javascript:history.go(-1)" class="coolbg">返回</a>
            </td>
        </tr>

    </table>
    </form>
</div>


<!-- 添加指标 -->


</body>
</html>