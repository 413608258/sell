<html>
    <#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">
        <#--主体内容content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix cye-lm-tag">
                    <div class="col-md-12 column cye-lm-tag">
                        <table class="table table-condensed">
                            <thead class="cye-lm-tag">
                            <tr class="cye-lm-tag">
                                <th>订单Id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th class="cye-lm-tag">
                                    订单状态
                                </th>
                                <th>支付方式</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTOPage.content as orderDTO>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.buyerName}</td>
                                <td>${orderDTO.buyerPhone}</td>
                                <td>${orderDTO.buyerAddress}</td>
                                <td>${orderDTO.orderAmount}</td>
                                <td>${orderDTO.getOrderStatusEnum().getMessage()}</td>
                                <td>微信</td>
                                <td>${orderDTO.getPayStatusEnum().getMessage()}</td>
                                <td>${orderDTO.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td><a href="/sell/seller/order/detail?orderId=${orderDTO.getOrderId()}">详情</a></td>
                                <td>
                                    <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.getOrderId()}">取消</a>
                                    </#if>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <#--分页-->
                    <div class="col-md-12 column cye-lm-tag">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else >
                                <li><a href="/sell/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                            </#if>
                            <#list 1..orderDTOPage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else >
                                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>

                            <#if currentPage gte orderDTOPage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else >
                                <li><a href="/sell/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <#--弹窗-->
    <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">
                        提醒
                    </h4>
                </div>
                <div class="modal-body">
                    你有新的订单
                </div>
                <div class="modal-footer">
                    <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
                </div>
            </div>

        </div>

    </div>
    <#--播放音乐-->
    <audio id="notice" loop="loop">
        <source src="/sell/mp3/song.mp3" type="audio/mpeg">
    </audio>

    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/js/bootstrap.min.js"></script>
    <script>
        var websocket = null;
        if('WebSocket' in window){
            websocket = new WebSocket('ws://peeggv.natappfree.cc/sell/webSocket');
        } else {
            alert('该浏览器不支持websocket!');
        }
        websocket.onopen = function (event) {
            console.log('建立连接');
        }

        websocket.onclose = function (event) {
            console.log('连接关闭');
        }

        websocket.onmessage = function (event) {
            console.log("收到消息：" + event.data);
            //弹窗提醒
            $('#myModal').modal('show');
            //播放音乐
            //这样暂时不可以
            //$('#notice').play();
            document.getElementById('notice').play();
        }

        websocket.onerror = function () {
            alert("websocket 通信发生错误！");
        }

        window.onbeforeunload = function () {
            websocket.close();
        }
    </script>
    </body>
</html>
<#--
<#list orderDTOPage.content as orderDTO>
    ${orderDTO.orderId}
</#list>-->
