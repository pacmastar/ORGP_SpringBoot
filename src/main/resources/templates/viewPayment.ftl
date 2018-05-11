<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<#include "fragments/bootstrapcss.ftl">
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Spring Boot</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/payments">payments</a></li>
                <li><a href="/stoplist">stoplist</a></li>
                <li><a href="/searchSod">search</a></li>
            </ul>
        </div>
    </div>
</nav>


<h1>Send payments!!!!!!!!!</h1>
<br>
<table class="table table-bordered table-hover">
    <tr class="active">
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
<a href="/payments/">back</a>
<br>
<br>
<table class="table table-bordered table-hover">
    <tr class="active">
        <th>uid</th>
        <th>date</th>
        <th>info</th>
    </tr>
<#list messages as message>
    <tr>
        <td>${message.uid}</td>
        <td>${message.regDateTime}</td>
        <td>${message.info}</td>
    </tr>
</#list>
</table>
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
        <th>validatorId</th>
        <th>agentId</th>
    <#--
    <th>dosFlag</th>
    -->
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
        <td>${transaction.dosFlag?string("true","")}</td>
        <td>${transaction.signature}</td>
    </tr>
</#list>
</table>
</body>
</html>