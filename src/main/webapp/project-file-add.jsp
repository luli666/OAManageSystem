<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>添加附件</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
    <SCRIPT type="text/javascript" SRC="${pageContext.request.contextPath}/static/js/jquery-3.1.1.js"></SCRIPT>
    <script type="text/javascript">
        /*同步上传文件*/
        /*function commit(){
            $("#form2").submit();
        }*/
        /*异步上传文件*/
        function commit(){
            /*获取表单中的数据*/
            var proFk = $("#select_proFk").val();
            var attname = $("#attname").val()
            var attdis = $("#attdis").val()
            //获取上传域数据
            var multipart = $("#multipart")[0].files[0]
            var remark = $("#remark").val()

            /*创建表单对象*/
            var formdata = new FormData();
            /*将表单中的数据添加进formdata对象中*/
            formdata.append("proFk",proFk);
            formdata.append("attname",attname);
            formdata.append("attdis",attdis);
            formdata.append("multipart",multipart);
            formdata.append("remark",remark);

            $.ajax({
                type:"post",
                url:"${pageContext.request.contextPath}/attachment/insert1",
                data:formdata,
                cache:false,                 //告诉浏览器,不要缓存数据
                processData:false,          //告诉浏览器，不要进行数据转换
                contentType:false,          //告诉浏览器，不要进行设置编码
                success:function (map) {
                    if(map.statusCode == 200){
                        window.location.href = "${pageContext.request.contextPath}/project-file.jsp"
                    }else{
                        if(confirm("您确定要离开页面吗?")){
                            window.location.href = "${pageContext.request.contextPath}/project-file.jsp"
                        }
                    }
                }
            })
        }

        $(function () {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/project/infoAndAtta",
                success:function (list) {
                    $(list).each(function () {
                        var option = "<option value='"+ this.pid +"'>"+ this.pname +"</option>"
                        $("#select_proFk").append(option)
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
                        当前位置:项目管理>>添加附件
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/attachment/insert" method="post" enctype="multipart/form-data">

    <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center"
           style="margin-top:8px">
        <tr bgcolor="#E7E7E7">
            <td height="24" colspan="2" background="${pageContext.request.contextPath}/skin/images/frame/tbg.gif">&nbsp;添加附件&nbsp;</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select name="proFk" id="select_proFk">
                    <option>--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">附件名称：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input size="26" id="attname" name="attname" placeholder="请输入附件名称"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">附件信息描述：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input size="52" id="attdis" name="attdis" placeholder="请输入描述信息"/>
            </td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FAFAF1" height="22">附件：</td>
            <td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <input type="file" id="multipart" name="multipart"/></td>
        </tr>

        <tr>
            <td align="right" bgcolor="#FAFAF1">备注：</td>
            <td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';"
                onMouseOut="javascript:this.bgColor='#FFFFFF';">
                <textarea rows=10 cols=130 id="remark" name="remark"></textarea>
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