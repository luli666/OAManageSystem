<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>添加客户信息</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></script>
    <script type="text/javascript">
        function commit() {
            var v1 = checkoutComaddress();
            var v2 = checkoutComname();
            var v3 = checkoutCompanyperson();
            var v4 = checkoutComphone();
            if(v1 && v2 && v3 && v4){
                $("#form2").submit();
            }else{
                alert("信息格式不正确，请重新填写")
            }
        }
        $(function () {
            $("#comname").blur(function () {
                checkoutComname()
            })
            $("#comaddress").blur(function () {
                checkoutComaddress()
            })
            $("#companyperson").blur(function () {
                checkoutCompanyperson()
            })
            $("#comphone").blur(function () {
                checkoutComphone()
            })
        })
        //校验公司名称
        function checkoutComname() {
            var info = $("#comname").val()
            if(info != null && info.length >= 2){
                $("#span_comname").text("名称格式正确");
                $("#span_comname").css("color","green");
                return true;
            }else{
                $("#span_comname").text("名称不能为空且长度不能小于2");
                $("#span_comname").css("color","red");
                return false;
            }
        }
        //校验公司联系人
        function checkoutCompanyperson() {
            var info = $("#companyperson").val()
            if(info != null && info.length >= 2){
                $("#span_companyperson").text("名称格式正确");
                $("#span_companyperson").css("color","green");
                return true;
            }else{
                $("#span_companyperson").text("名称不能为空且长度不能小于2");
                $("#span_companyperson").css("color","red");
                return false;
            }
        }
        //校验公司地址
        function checkoutComaddress() {
            var info = $("#comaddress").val()
            if(info != null && info.length >= 2){
                $("#span_comaddress").text("地址格式正确");
                $("#span_comaddress").css("color","green");
                return true;
            }else{
                $("#span_comaddress").text("地址不能为空且长度不能小于2");
                $("#span_comaddress").css("color","red");
                return false;
            }
        }
        //校验手机号非空约束
        function checkoutComphone() {
            var info = $("#comphone").val()
            if(info != null ){
                if(/^1[3456789]\d{9}$/.test(info)){
                    $("#span_comphone").text("手机号格式正确")
                    $("#span_comphone").css("color","green")
                    return true;
                }
                $("#span_comphone").text("手机号格式不正确")
                $("#span_comphone").css("color","red")
                return false
            }
            $("#span_comphone").text("手机号不能为空")
            $("#span_comphone").css("color","red")
            return false
        }

    </script>
</head>
<body leftmargin="8" topmargin="8" background='${pageContext.request.contextPath}/skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:客户信息管理>>添加客户信息
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form id="form2" name="form2" action="${pageContext.request.contextPath}/customer/insert" method="post">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="${pageContext.request.contextPath}/skin/images/tbg.gif">&nbsp;添加客户&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="comname" id="comname" placeholder="请输入公司名称"/>
                <span id="span_comname"></span>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="companyperson" id="companyperson" placeholder="请输入联系人"/>
                <span id="span_companyperson"></span>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input size="60" name="comaddress" id="comaddress" placeholder="请输入地址"/>
                <span id="span_comaddress"></span>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="comphone" id="comphone" placeholder="请输入手机号"/>
                <span id="span_comphone"></span>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input name="camera" id="camera" placeholder="请输入电话"/>
                <span id="span_camera"></span>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <textarea rows=15 cols=130 name="present"></textarea>
            </td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
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