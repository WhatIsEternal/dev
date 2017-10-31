<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/12/012
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



    <script>

        function orderspic() {
            $("#main").css("display", "block");
            $("#main2").css("display", "none");
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '订单统计'
                },
                tooltip: {},
                legend: {
                    data: ['销量']
                },
                xAxis: [{
                    data: (function () {
                        var arr = [];
                        $.ajax({
                            type: "post",
                            async: false,
                            url: "../orderspic.do",
                            data: {},
                            dataType: "json", //返回数据形式为json
                            success: function (result) {
                                if (result) {
                                    for (var i = 0; i < result.length; i++) {
                                        console.log(result[i].m);
                                        arr.push(result[i].m + '月份');
                                    }
                                }
                            },
                            error: function (errorMsg) {
                                alert("不好意思，图表请求数据失败啦!");
                                myChart.hideLoading();
                            }
                        })
                        return arr;
                    })(),
                    axisLabel: {
                        interval: 0,//横轴信息全部显示
                        rotate: -30,//-30度角倾斜显示
                    }
                }],
                yAxis: {},
                series: [
                    {
                        name: '销量',
                        type: 'bar',
                        data: (function () {
                            var arr = [];
                            $.ajax({
                                type: "post",
                                async: false,
                                url: "../orderspic.do",
                                data: {},
                                dataType: "json", //返回数据形式为json
                                success: function (result) {
                                    if (result) {
                                        for (var i = 0; i < result.length; i++) {
                                            console.log(result[i].num);
                                            arr.push(result[i].num);
                                        }
                                    }
                                },
                                error: function (errorMsg) {
                                    alert("不好意思,图表请求数据失败啦!");
                                    myChart.hideLoading();
                                }
                            })
                            return arr;
                        })()
                    },
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
        function orderspic2() {
            $("#main2").css("display", "block");
            $("#main").css("display", "none");
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main2'));
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '订单统计'
                },
                tooltip: {},
                legend: {
                    data: ['销量']
                },
                xAxis: [{
                    data: (function () {
                        var arr = [];
                        $.ajax({
                            type: "post",
                            async: false,
                            url: "../ordersusers.do",
                            data: {},
                            dataType: "json", //返回数据形式为json
                            success: function (result) {
                                console.log("用户名" + result[0].owner);
                                if (result) {
                                    for (var i = 0; i < result.length; i++) {
                                        console.log(result[i].owner);
                                        arr.push(result[i].owner);
                                    }
                                }
                            },
                            error: function (errorMsg) {
                                alert("不好意思，图表请求数据失败啦!");
                                myChart.hideLoading();
                            }
                        })
                        return arr;
                    })(),
                    axisLabel: {
                        interval: 0,//横轴信息全部显示
                        rotate: -30,//-30度角倾斜显示
                    }
                }],
                yAxis: {},
                series: [
                    {
                        name: '销量',
                        type: 'bar',
                        data: (function () {
                            var arr = [];
                            $.ajax({
                                type: "post",
                                async: false,
                                url: "../ordersusers.do",
                                data: {},
                                dataType: "json", //返回数据形式为json
                                success: function (result) {
                                    if (result) {
                                        for (var i = 0; i < result.length; i++) {
                                            console.log(result[i].num);
                                            arr.push(result[i].num);
                                        }
                                    }
                                },
                                error: function (errorMsg) {
                                    alert("不好意思,图表请求数据失败啦!");
                                    myChart.hideLoading();
                                }
                            })
                            return arr;
                        })()
                    },
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    </script>


<button class="btn btn-success" onclick="orderspic()" style="margin: 30px 20px;">按月份统计</button>
<button class="btn btn-success" onclick="orderspic2()" style="margin: 30px 20px;">按用户统计</button>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<div id="main2" style="width: 600px;height:400px;"></div>



