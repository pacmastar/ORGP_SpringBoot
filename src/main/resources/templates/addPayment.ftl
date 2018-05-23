<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<#include "fragments/bootstrapcss.ftl">
</head>
<body>
<#include "fragments/navbar.ftl">
<p>add payment</p>
<div class="container">
    <form name="payment" action="/payment/add" method="post">
        <div class="form-group">
            <label for="uid">UID:</label>
            <input class="form-control" type="text" name="cardnumber" id="cardnumber">
        </div>
        <div class="form-group">
            <label for="agentId">Agent:</label>
            <input class="form-control" type="text" name="agentId" id="agentId">
        </div>
        <div class="form-group">
            <label for="paymentId">PaymentId:</label>
            <input class="form-control" type="text" name="paymentId" id="paymentId">
        </div>
        <div class="form-group">
            <label for="summ">Summ:</label>
            <input class="form-control" type="text" name="summ" id="summ">
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <input class="form-control" type="text" name="status" id="status">
        </div>
        <div class="input-group date form-group" id="datetimepicker">
            <span class="input-group-addon datepickerbutton">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>

            <input type="text" class="form-control" name="agentTime" id="agentTime"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-remove"></span>
            </span>
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="Submit">
        </div>
    </form>
</div>
<#include "fragments/footer.ftl">
<script>
    $(function () {
        $('#datetimepicker').datetimepicker({locale: 'ru'});
        $('.glyphicon-remove').click(function () {

            $('#datetimepicker').data("datetimepicker").clear();
        });
    });
</script>
</body>
</html>