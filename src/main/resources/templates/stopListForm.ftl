<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<#include "fragments/bootstrapcss.ftl">
</head>

<body>
<#include "fragments/navbar.ftl">
<h1>Stop list</h1>
<div class="container">
    <form action="/stoplist" method="post">
        <div class="form-group">
            <label for="uid">UID:</label>
            <input class="form-control" type="text" name="uid" id="uid">
        </div>
        <div class="form-group">
            <input class="btn btn-primary" type="submit" value="Submit">
        </div>
    </form>
</div>
<#if cards??>
<table class="table table-bordered table-hover">
    <tr class="active">
        <th>id</th>
        <th>uid</th>
        <th>reason</th>
        <th>delete</th>
    </tr>

    <#list cards as card>
        <tr>
            <td>${card.id?c}</td>
            <td>${card.uid}</td>
            <td>${card.reason}</td>
            <td><a href="/stoplist/delete/${card.uid}">delete</a></td>
        </tr>
    </#list>
</#if>
</table>
</body>
</html>