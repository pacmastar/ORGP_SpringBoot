<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>view payment</title>
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
<table>
    <tr>
        <th>id</th>
        <th>agent</th>
        <th>paymentid</th>
        <th>cardnumber</th>
        <th>summ</th>
        <th>agenttime</th>
        <th>status</th>
        <th>changeStatusTime</th>
        <th>action</th>
    </tr>
    <tr>
        <td>${payment.tableId?c}</td>
        <td>${payment.systemId}</td>
        <td>${payment.paymentId}</td>
        <td>${payment.cardNumber}</td>
        <td>${payment.summ}</td>
        <td>${payment.agentTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
        <td>${payment.status}</td>
        <td>${payment.changeStatusTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
        <td><a href="/payment/changestatus/${payment.tableId?c}">unblock</a></td>
    </tr>
</table>
<br>
<br>

<a href="/payment/">back</a>
<br>
<br>
<table>
    <tr>
        <th>idSodTrans</th>
        <th>cardNumber</th>
        <th>cardType</th>
        <th>cardSubType</th>
        <th>regDateTime</th>
        <th>kassierCode</th>
        <th>kassCode</th>
        <th>summPayment</th>
        <th>summPurse</th>
        <th>validatorId</th>
        <th>agentId</th>
        <#--<th>dosFlag</th>-->
        <th>signature</th>
    </tr>

<#list sodTransactions as transaction>
    <tr>
        <td>${transaction.idSodTrans?c}</td>
        <td>${transaction.cardNumber}</td>
        <td>${transaction.cardType}</td>
        <td>${transaction.cardSubType?c}</td>
        <td>${transaction.regDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
        <td>${transaction.kassierCode}</td>
        <td>${transaction.kassCode}</td>
        <td>${transaction.summPayment}</td>
        <td>${transaction.summPurse}</td>
        <td>${transaction.validatorId}</td>
        <td>${transaction.agentId}</td>
        <#--<td>${transaction.dosFlag}</td>-->
        <td>${transaction.signature}</td>

    </tr>
</#list>
</table>
</body>
</html>