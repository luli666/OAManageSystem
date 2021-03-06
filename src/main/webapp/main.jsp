<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <title>main</title>
    <base target="_self">
	<base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/moment.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/moment.min.js"></script>
    <script type="text/javascript">
        $(function () {
            /*通知公告*/
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/notice/show",
                success:function (msg) {
                    if(msg.map.statusCode == 200){
                        $(msg.map.notices).each(function () {
                            var li = " <li class='ue-clear'>\n" +
                                "                    <span>"+ moment(this.ndate).format("YYYY-MM-DD") +"</span>&nbsp;&nbsp;&nbsp;<a href='javascript:open("+ this.nid +")'  class='notice-title'>"+ this.ntitle +"</a>\n" +
                                "                </li>\n" +
                                "                <p>"
                            $("#insert_li").append(li)
                        })
                    }
                }
            })
            /*员工论坛*/
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/forumpost/infoInMain",
                success:function (msg) {
                    if(msg.map.statusCode == 200){
                        $(msg.map.list).each(function () {
                            var li = "<li class=\"ue-clear\">\n" +
                                "                    <span><img src=\"${pageContext.request.contextPath}/images/tx.png\" height=\"50px\"\n" +
                                "                               width=\"50px\"/></span> 发布时间："+ moment(this.createtime).format("YYYY-MM-DD") +"\n" +
                                "                    <a href=\"role.jsp\" class=\"notice-title\">"+ this.forumtitle +"</a>\n" +
                                "                    <p>"+ this.forumcontent +"</p>"
                                "                </li>\n" +
                                "                <p>"
                            $("#insert_ul").append(li)
                        })
                    }
                }
            })
        })
        function open(nid) {
            /*显示遮罩层*/
            $("#cover").show()
            $("#cover").css("height",document.body.scrollHeight)
            $("#showdiv").show()
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/notice/look/"+nid,
                success:function(msg){
                    if(msg.map.statusCode == 200){
                        $("#ntitle").text(msg.map.notice.ntitle)
                        $("#content").text(msg.map.notice.remark)
                    }
                }
            })
        }
        function closeWindow() {
            /*隐藏遮罩层*/
            $("#cover").css("height","0px")
            $("#showdiv").css("display","none")
        }

    </script>
</head>
<body leftmargin="8" topmargin='8'>
<!-- 遮罩层 -->
<div id="cover"
     style="background: #000; position: absolute; left: 0px; top: 0px; width: 100%; filter: alpha(opacity=30); opacity: 0.3; display: none; z-index: 2 ">

</div>
<!-- 弹窗 -->
<div id="showdiv"
     style="width: 60%; margin: 0 auto; height:500px; border: 1px solid #999; display: none; position: absolute; top: 20%; left: 20%; z-index: 3; background: #fff">
    <!-- 标题 -->
    <div id="ntitle"
         style="background: #F8F7F7; width: 100%; height: 2rem; font-size: 0.65rem; line-height: 2rem; border: 1px solid #999; text-align: center;">

    </div>
    <!-- 内容 -->
    <div id="content" style="text-indent: 50px; height: 4rem; font-size: 2rem; padding: 0.5rem; line-height: 3rem; ">

    </div>
    <!-- 按钮 -->
    <div style="background: green; width: 10%; margin: 0 auto; height: 1.5rem; line-height: 1.5rem; text-align: center;color: #fff;margin-top: 28rem; -moz-border-radius: .128rem; -webkit-border-radius: .128rem; border-radius: .128rem;font-size: .59733rem;"
         onclick="closeWindow()">
        关闭
    </div>
</div>

<table width="98%" border="0" align="center" cellpadding="0"
       cellspacing="0">
    <tr>
        <td>
            <div style='float: left'>
                <img height="14" src="${pageContext.request.contextPath}/skin/images/frame/book1.gif" width="20"/>&nbsp;欢迎使用项目平台管理系统
            </div>
            <div style='float: right; padding-right: 8px;'>
                <!--  //保留接口  -->
            </div>
        </td>
    </tr>
    <tr>
        <td height="1" background="${pageContext.request.contextPath}/skin/images/frame/sp_bg.gif"
            style='padding: 0px'></td>
    </tr>
</table>

<table width="98%" align="center" border="0" cellpadding="4"
       cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
    <tr>
        <td colspan="2" background="${pageContext.request.contextPath}/skin/images/frame/wbg.gif"
            bgcolor="#EEF4EA" class='title'>
            <div style='float: left'>
                <span>快捷操作</span>
            </div>
            <div style='float: right; padding-right: 10px;'></div>
        </td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td height="30" colspan="2" align="center" valign="bottom">
            <table
                    width="100%" border="0" cellspacing="1" cellpadding="1">
                <tr>
                    <td width="15%" height="31" align="center"><img
                            src="skin/images/frame/qc.gif" width="90" height="30"/></td>
                    <td width="85%" valign="bottom">
                        <div class='icoitem'>
                            <div class='ico'>
                                <img src='${pageContext.request.contextPath}/skin/images/frame/addnews.gif' width='16'
                                     height='16'/>
                            </div>
                            <div class='txt'>
                                <a href='project-base.html'><u>查看项目信息</u></a>
                            </div>
                        </div>
                        <div class='icoitem'>
                            <div class='ico'>
                                <img src='${pageContext.request.contextPath}/skin/images/frame/menuarrow.gif' width='16'
                                     height='16'/>
                            </div>
                            <div class='txt'>
                                <a href='task-my.html'><u>查看任务</u></a>
                            </div>
                        </div>
                        <div class='icoitem'>
                            <div class='ico'>
                                <img src='${pageContext.request.contextPath}/skin/images/frame/manage1.gif' width='16'
                                     height='16'/>
                            </div>
                            <div class='txt'>
                                <a href='task-add.html'><u>发布任务</u></a>
                            </div>
                        </div>
                        <div class='icoitem'>
                            <div class='ico'>
                                <img src='${pageContext.request.contextPath}/skin/images/frame/file_dir.gif' width='16'
                                     height='16'/>
                            </div>
                            <div class='txt'>
                                <a href='message-give.html'><u>收件箱</u></a>
                            </div>
                        </div>
                        <div class='icoitem'>
                            <div class='ico'>
                                <img src='${pageContext.request.contextPath}/skin/images/frame/part-index.gif'
                                     width='16'
                                     height='16'/>
                            </div>
                            <div class='txt'>
                                <a href='info.html'><u>个人信息</u></a>
                            </div>
                        </div>
                        <div class='icoitem'>
                            <div class='ico'>
                                <img src='${pageContext.request.contextPath}/skin/images/frame/manage1.gif' width='16'
                                     height='16'/>
                            </div>
                            <div class='txt'>
                                <a href='modpassword.html'><u>修改密码</u></a>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>


<table width="98%" align="center" border="0" cellpadding="3"
       cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom: 8px; margin-top: 8px;">
    <tr>
        <td background="${pageContext.request.contextPath}/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
            class='title'><span>待完成任务</span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td>您有<a href=""><font color="red">2</font></a>个任务未完成……&nbsp;
        </td>
    </tr>
</table>


<table width="98%" align="center" border="0" cellpadding="3"
       cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom: 8px; margin-top: 8px;">
    <tr>
        <td background="${pageContext.request.contextPath}/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
            class='title'><span>未读消息</span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td>您有<a href=""><font color="red">10</font></a>条未读消息……&nbsp;
        </td>
    </tr>
</table>


<table width="98%" align="center" border="0" cellpadding="3"
       cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom: 8px; margin-top: 8px;">
    <tr>
        <td background="${pageContext.request.contextPath}/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
            class='title'><span>通知公告</span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td>
            <ul class="notice-list" id="insert_li">

            </ul>
        </td>
    </tr>
</table>

<table width="98%" align="center" border="0" cellpadding="3"
       cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom: 8px; margin-top: 8px;">
    <tr>
        <td background="${pageContext.request.contextPath}/skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
            class='title'><span>员工论坛</span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
        <td>
            <ul class="notice-list" id="insert_ul">

            </ul>
        </td>
    </tr>
</table>

</body>
</html>