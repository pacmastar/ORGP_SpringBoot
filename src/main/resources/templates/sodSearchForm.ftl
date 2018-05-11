<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<#include "fragments/bootstrapcss.ftl">
</head>
<body>
<#include "fragments/navbar.ftl">
<div class="container">
    <form action="/searchSod" method="post">
        <div class="form-group">
            <label for="uid">UID:</label>
            <input class="form-control" type="text" name="uid" id="uid">
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="Submit">
        </div>
    </form>
</div>
<#if primaryList??>
<br>
<h1>Active</h1>
<br>




<table class="table table-bordered table-hover">
    <tr class="active">
        <th>idSodTrans</th>
        <th>cardNumber</th>
        <th>cardType</th>
        <th>cardSubType</th>
        <th>regDateTime</th>
        <th>kassierCode</th>
        <th>kassCode</th>
        <th>summPayment</th>
        <th>summPurse</th>
        <th>begin</th>
        <th>end</th>
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
            <td>${primary.beginDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
            <td>${primary.endDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
            <td>${primary.validatorId}</td>
            <td>${primary.agentId}</td>
            <td>${primary.dosFlag?string("true","")}</td>
            <td>${primary.signature}</td>
        </tr>
    </#list>
</table>

<br>
<h1>Archive</h1>
<table class="table table-bordered table-hover">
    <tr class="active">
        <th>idSodTrans</th>
        <th>cardNumber</th>
        <th>cardType</th>
        <th>cardSubType</th>
        <th>regDateTime</th>
        <th>kassierCode</th>
        <th>kassCode</th>
        <th>summPayment</th>
        <th>summPurse</th>
        <th>begin</th>
        <th>end</th>
        <th>validatorId</th>
        <th>agentId</th>
        <th>dosFlag</th>
        <th>signature</th>
    </tr>
    <br>
    <#list secondaryList as secondary>
        <tr class="active">
            <td>${secondary.idSodTrans?c}</td>
            <td>${secondary.cardNumber}</td>
            <td>${secondary.cardType}</td>
            <td>${secondary.cardSubType?c}</td>
            <td>${secondary.regDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
            <td>${secondary.kassierCode}</td>
            <td>${secondary.kassCode}</td>
            <td>${secondary.summPayment}</td>
            <td>${secondary.summPurse}</td>
            <td>${secondary.beginDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
            <td>${secondary.endDateTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
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