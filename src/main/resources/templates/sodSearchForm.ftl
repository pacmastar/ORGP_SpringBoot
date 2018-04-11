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
<form action="/searchSod" method="post">
    UID:<br>
    <input type="text" name="uid">
    <input type="submit" value="Submit">
</form>
<#if primaryList??>
<br>
<h3>Active</h3>
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
        <th>dosFlag</th>
        <th>signature</th>
    </tr>

    <#list primaryList as primary>
        <tr>
            <td>${primary.idSodTrans?c}</td>
            <td>${primary.cardNumber}</td>
            <td>${primary.cardType}</td>
            <td>${primary.cardSubType?c}</td>
            <td>${primary.regDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
            <td>${primary.kassierCode}</td>
            <td>${primary.kassCode}</td>
            <td>${primary.summPayment}</td>
            <td>${primary.summPurse}</td>
            <td>${primary.validatorId}</td>
            <td>${primary.agentId}</td>
            <td>${primary.dosFlag?string("true","")}</td>
            <td>${primary.signature}</td>
        </tr>
    </#list>
</table>

<br>
<h3>Аrchive</h3>
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
        <th>dosFlag</th>
        <th>signature</th>
    </tr>
    <br>
    <#list secondaryList as secondary>
        <tr>
            <td>${secondary.idSodTrans?c}</td>
            <td>${secondary.cardNumber}</td>
            <td>${secondary.cardType}</td>
            <td>${secondary.cardSubType?c}</td>
            <td>${secondary.regDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
            <td>${secondary.kassierCode}</td>
            <td>${secondary.kassCode}</td>
            <td>${secondary.summPayment}</td>
            <td>${secondary.summPurse}</td>
            <td>${secondary.validatorId}</td>
            <td>${secondary.agentId}</td>
            <td>${secondary.dosFlag?string("true","")}</td>
            <td>${secondary.signature}</td>
        </tr>
    </#list>
</#if>
</table>
</body>
</html>