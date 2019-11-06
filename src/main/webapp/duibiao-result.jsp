<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>对标管理</title>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/frame/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr>
        <td height="26" background="skin/images/frame/newlinebg3.gif">
            <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td>
                        当前位置:对标管理>>对标分析
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>

<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var xArr = new Array()
    var sArr = new Array()
    $.ajax({
        type:"get",
        url:"${pageContext.request.contextPath}/bench/info",
        success:function (list) {
            $(list).each(function () {
                xArr.push(this.comname)
                sArr.push(this.salesAnount)
            })
            var myChar = echarts.init($("#main")[0])
            var option = {
                title:{
                    text:'2018手机销售额比较',
                    left:'center',
                    top:'bottom'
                },
                legend:{
                    data:['销售额']
                },
                xAxis: {
                    data: xArr
                },
                yAxis: {
                    axisLabel:{
                        formatter:'{value} 亿'
                    }
                },
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: sArr
                },{
                    name: '销量',
                    type: 'line',
                    data: sArr
                }]
            }
            myChar.setOption(option)
        }
    })

</script>

</body>
</html>