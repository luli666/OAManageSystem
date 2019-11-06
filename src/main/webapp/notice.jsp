<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>发件箱</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/moment.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/notice/list",
                success:function (msg) {
                    if (msg.map.statusCode == 200) {
                        $(msg.map.page.list).each(function (index, elem) {
                            var tr = "<tr class='del_tr' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                                "            <td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"" + elem.nid + "\" class=\"np\"></td>\n" +
                                "            <td>" + (msg.map.page.pageSize*(msg.map.page.pageNum-1) + (index+1)) + "</td>\n" +
                                "            <td>" + elem.ntitle + "</td>\n" +
                                "            <td align=\"center\"><span >" + elem.remark + "</span></td>\n" +
                                "            <td>" + moment(elem.ndate).format('YYYY-MM-DD') + "</td>\n" +
                                "            <td><a >编辑</a></td>\n" +
                                "        </tr>"
                            $("#insert_before").before(tr)
                        })
                    }
                    var page1 = "<a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum=1"+ msg.map.params +"\">首页</a>\n" +
                        "                        <a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)'  name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pageNum-1)+ msg.map.params  +"\">上一页</a>"

                    var page3 = "<a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pageNum+1)+msg.map.params +"\">下一页</a>\n" +
                        "       <a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pages) + msg.map.params +"\">尾页</a>\n"
                    var page2 = "";
                    $(msg.map.page.navigatepageNums).each(function (index,pagenum) {
                        if(pagenum == msg.map.page.pageNum){
                            page2 = page2 + "<span class='del_a' style='font-weight: bold;font-size: 15px'>"+ pagenum +"</span>"
                        }else{
                            page2 = page2 + "<a class='del_a' style='font-size: 14px' onclick='page(this)' href='javascript:void(0)' name='"+ msg.map.requestURI + "?pageNum="+ pagenum + msg.map.params +"'>"+ pagenum +"</a>"
                        }
                    })
                    var page = page1 + page2 + page3
                    $("#insert_page").append(page)
                }
            })
        })
        function page(path){
            /*删除分页之前的记录*/
            $(".del_tr").remove();
            $(".del_a").remove();
            $.ajax({
                type:"get",
                url:path.name,
                success:function(msg){
                    if (msg.map.statusCode == 200) {
                        $(msg.map.page.list).each(function (index, elem) {
                            var tr = "<tr class='del_tr' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                                "            <td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"" + elem.nid + "\" class=\"np\"></td>\n" +
                                "            <td>" + (msg.map.page.pageSize*(msg.map.page.pageNum-1) + (index+1)) + "</td>\n" +
                                "            <td>" + elem.ntitle + "</td>\n" +
                                "            <td align=\"center\"><span >" + elem.remark + "</span></td>\n" +
                                "            <td>" + moment(elem.ndate).format('YYYY-MM-DD') + "</td>\n" +
                                "            <td><a >编辑</a></td>\n" +
                                "        </tr>"
                            $("#insert_before").before(tr)
                        })
                    }

                    var page1 = "<a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum=1"+ msg.map.params +"\">首页</a>\n" +
                        "                        <a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)'  name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pageNum-1)+ msg.map.params  +"\">上一页</a>"

                    var page3 = "<a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pageNum+1)+msg.map.params +"\">下一页</a>\n" +
                        "       <a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pages) + msg.map.params +"\">尾页</a>\n"
                    var page2 = "";
                    $(msg.map.page.navigatepageNums).each(function (index,pagenum) {
                        if(pagenum == msg.map.page.pageNum){
                            page2 = page2 + "<span class='del_a' style='font-weight: bold;font-size: 15px'>"+ pagenum +"</span>"
                        }else{
                            page2 = page2 + "<a class='del_a' style='font-size: 14px' onclick='page(this)' href='javascript:void(0)' name='"+ msg.map.requestURI + "?pageNum="+ pagenum + msg.map.params +"'>"+ pagenum +"</a>"
                        }
                    })
                    var page = page1 + page2 + page3
                    $("#insert_page").append(page)
                }
            })
        }
    </script>

</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="skin/images/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:信息箱>>通知公告
                    </td>
                    <td>
                        <input type='button' class="coolbg np" onClick="location='${pageContext.request.contextPath}/notice-send.jsp';" value='发布新通告'/>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<!--  搜索表单  -->
<form name='form3' id="form3" >
    <input type='hidden' name='dopost' value=''/>
    <table width='98%' id="table" border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center"
           style="margin-top:8px">
        <tr bgcolor='#EEF4EA'>
            <td background='skin/images/frame/wbg.gif' align='center'>
                <table border='0' cellpadding='0' cellspacing='0'>
                    <tr>
                        <td width='90' align='center'>搜索条件：</td>
                        <td width='160'>
                            <select name='search_cid' id="cid" style='width: 150px;'>
                                <option value='0'>选择类型...</option>
                                <option value='1'>标题</option>
                                <option value='2'>内容</option>
                            </select>
                        </td>
                        <td width='70'>
                            关键字：
                        </td>
                        <td width='160'>
                            <input type='text' id="keyword" name='search_keyword' value='' style='width:120px'/>
                        </td>
                        <td width='110'>
                            <select name='search_orderby' id="orderby" style='width:120px'>
                                <option value='0'>排序...</option>
                                <option value='1'>时间升序</option>
                                <option value='2'>时间降序</option>
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
            <td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;发件箱&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#FAFAF1" height="22" id="tr2">
            <td width="4%">选择</td>
            <td width="6%">序号</td>
            <td width="10%">标题</td>
            <td width="10%">内容</td>
            <td width="8%">发送时间</td>
            <td width="8%">操作</td>
        </tr>

        <tr bgcolor="#FAFAF1" id="insert_before">
            <td height="28" colspan="12">
                &nbsp;
                <a href="javascript:checkout()" class="coolbg">全选</a>
                <a href="javascript:reverse()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="javascript:del()" class="coolbg">&nbsp;删除&nbsp;</a>
                <a href="" class="coolbg">&nbsp;导出Excel&nbsp;</a>
            </td>
        </tr>
        <tr align="right" bgcolor="#EEF4EA">
            <td height="36" colspan="12" align="center" id="insert_page"><!--翻页代码 --></td>
        </tr>
    </table>

</form>
<script type="text/javascript">
    /*搜索*/
    function commit() {
        /*删除分页之前的记录*/
        $(".del_tr").remove();
        $(".del_a").remove();

        var param = $("#form3").serialize();
        $.ajax({
            type:"get",
            url:"${pageContext.request.contextPath}/notice/list",
            data:param,
            success:function (msg) {
                if (msg.map.statusCode == 200) {
                    $(msg.map.page.list).each(function (index, elem) {
                        var tr = "<tr class='del_tr' align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='#FCFDEE';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\" >\n" +
                            "            <td><input name=\"id\" type=\"checkbox\" id=\"id\" value=\"" + elem.nid + "\" class=\"np\"></td>\n" +
                            "            <td>" + (msg.map.page.pageSize*(msg.map.page.pageNum-1) + (index+1)) + "</td>\n" +
                            "            <td>" + elem.ntitle + "</td>\n" +
                            "            <td align=\"center\"><span >" + elem.remark + "</span></td>\n" +
                            "            <td>" + moment(elem.ndate).format('YYYY-MM-DD') + "</td>\n" +
                            "            <td><a >编辑</a></td>\n" +
                            "        </tr>"
                        $("#insert_before").before(tr)
                    })
                }

                var page1 = "<a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum=1"+ msg.map.params +"\">首页</a>\n" +
                    "                        <a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)'  name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pageNum-1)+ msg.map.params  +"\">上一页</a>"

                var page3 = "<a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pageNum+1)+msg.map.params +"\">下一页</a>\n" +
                    "       <a class='del_a' style=\"font-size: 14px\" onclick='page(this)' href='javascript:void(0)' name=\""+ msg.map.requestURI +"?pageNum="+ (msg.map.page.pages) + msg.map.params +"\">尾页</a>\n"
                var page2 = "";
                $(msg.map.page.navigatepageNums).each(function (index,pagenum) {
                    if(pagenum == msg.map.page.pageNum){
                        page2 = page2 + "<span class='del_a' style='font-weight: bold;font-size: 15px'>"+ pagenum +"</span>"
                    }else{
                        page2 = page2 + "<a class='del_a' style='font-size: 14px' onclick='page(this)' href='javascript:void(0)' name='"+ msg.map.requestURI + "?pageNum="+ pagenum + msg.map.params +"'>"+ pagenum +"</a>"
                    }
                })
                var page = page1 + page2 + page3
                $("#insert_page").append(page)
                $("#cid").val(0)
                $("#keyword").val("")
                $("#orderby").val(0)
            }
        })
    }
    /*全选*/
    function checkout() {
        $("[type='checkbox']").prop("checked",true)
    }
    /*反选*/
    function reverse() {
        $("[type='checkbox']").each(function () {
            var info = $(this).prop("checked")
            $(this).prop("checked",!info)
        })
    }
    /*删除*/
    function del(){
        var ids = ""
        $("input:checked").each(function () {
            ids = ids + "," + $(this).val()
        })
        if(ids == null || ids == ""){
            alert("请先选择要删除的元素")
            return ;
        }
        if(!confirm("确定要删除选中的元素吗?")){
            return ;
        }
        ids = ids.substring(1)
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/notice/delete/"+ ids,
            data:{"_method":"delete"},
            success:function(msg){
                if(msg.map.statusCode == 200){
                    window.location.href = "${pageContext.request.contextPath}/notice.jsp"
                }else{
                    alert("删除失败")
                    window.location.href = "${pageContext.request.contextPath}/notice.jsp"
                }
            }
        })
    }
</script>
</body>
</html>