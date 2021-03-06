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
        <th colspan="3">action</th>
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
        <td><a href="/payment/unblock/${payment.tableId?c}" class="btn btn-success">unblock</a></td>
        <td><a href="/payment/repaid/${payment.tableId?c}" class="btn btn-danger">repaid</a></td>
        <td><a href="/payment/layaside/${payment.tableId?c}" class="btn btn-warning">lay aside</a></td>
    </tr>
</table>
<br>
<br>
<a href="/payments/">back</a>
<br>
<br>
<div class="container">
    <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="pill" href="#home">Logs</a></li>
        <li><a data-toggle="pill" href="#menu1">Transactions</a></li>
        <li><a data-toggle="pill" href="#menu2">Payments</a></li>
    </ul>

    <div class="tab-content">
        <div id="home" class="tab-pane fade in active">
            <h3>Logs</h3>
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
        </div>
        <div id="menu1" class="tab-pane fade">
            <h3>Transactions</h3>
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
                    <th>dosFlag</th>
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
        </div>
        <div id="menu2" class="tab-pane fade">
            <h3>Payments</h3>
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
                </tr>
            <#list allPayments as p>
                <tr>
                    <td>${p.tableId?c}</td>
                    <td>${p.systemId}</td>
                    <td>${p.paymentId}</td>
                    <td>${p.cardNumber}</td>
                    <td>${p.summ}</td>
                    <td>${p.agentTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
                    <td>${p.status}</td>
                    <td>${p.changeStatusTime?string["yyyy-MM-dd HH:mm:ss.sss"]}</td>
                </tr>
            </#list>
            </table>
        </div>
    </div>
</div>
<#include "fragments/footer.ftl">
</body>
</html>