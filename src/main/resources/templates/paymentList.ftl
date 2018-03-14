<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h1>Spring boot</h1>
<#list 1..totalPage-1 as i>
<a href="/payment/page/${i}">${i} | </a>
</#list>
<br>
<br>
<table border="1">
    <tr>
        <th>id</th>
        <th>agent</th>
        <th>paymentId</th>
        <th>uid</th>
        <th>payment</th>
        <th>agent time</th>
        <th>status</th>
        <th>change status</th>
    </tr>

    <#--<h1>${totalPage}</h1>-->
    <#--<h1>${page_num}</h1>-->



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

