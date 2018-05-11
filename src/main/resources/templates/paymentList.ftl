<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<#include "fragments/bootstrapcss.ftl">
</head>
<body>
<#include "fragments/navbar.ftl">
<h1>Send payments</h1>
<br>
<table class="table table-bordered table-hover">
    <tr class="active">
        <th>id</th>
        <th>agent</th>
        <th>paymentId</th>
        <th>uid</th>
        <th>payment</th>
        <th>agent time</th>
        <th>status</th>
        <th>change status</th>
    </tr>

<#list paymentList as payment>
    <tr>
        <td><a href="/payment/view/${payment.tableId?c}">${payment.tableId?c}</a></td>
        <td>${payment.systemId}</td>
        <td>${payment.paymentId}</td>
        <td>${payment.cardNumber}</td>
        <td>${payment.summ?c}</td>
        <td>${payment.agentTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
        <td>${payment.status}</td>
        <td>${payment.changeStatusTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
    </tr>
</#list>
</table>
</body>
</html>

