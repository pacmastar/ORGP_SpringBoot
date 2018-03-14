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
        <td>${payment.agentTime}</td>
        <td>${payment.status}</td>
        <td>${payment.changeStatusTime}</td>
        <td><a href="/payment/changestatus/${payment.tableId?c}">unblock</a></td>
    </tr>
</table>
<br>
<br>
<a href="/payment/">back</a>
<br>
<br>
</body>
</html>