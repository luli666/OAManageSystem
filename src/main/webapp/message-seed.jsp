<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>发信息</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/employee/infoAndEmail",
                success:function (msg) {
                    if(msg.map.statusCode == 200){
                        $(msg.map.list).each(function () {
                            var option = "<option value='"+ this.email +"'>"+ this.ename +"</option>"
                            $("#insert_select").append(option)
                        })
                    }
                }
            })
        })
        function commit(){
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
                        当前位置:信息箱>>发信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/email/insert" method="post" enctype="multipart/form-data">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="skin/images/frame/tbg.gif">&nbsp;发信息&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">收件人：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="ename" id="insert_select">
                    <option>--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">标题：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="title"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">内容：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <textarea rows=15 cols=130 name="content"></textarea>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">附件：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <input type="file" name="multipart"/>
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