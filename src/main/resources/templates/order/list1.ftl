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

    </body>
</html>
<#--
<#list orderDTOPage.content as orderDTO>
    ${orderDTO.orderId}
</#list>-->
