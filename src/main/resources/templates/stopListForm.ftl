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
        tr:hover td{
            background: #B3CCFF;/* фон строки при наведении */
        }
    </style>
</head>
<body>
<form action="/stoplist" method="post">
    UID:<br>
    <input type="text" name="uid">
    <input type="submit" value="Submit">
</form>

<#if cards??>
<table border="1">
    <tr>
        <th>id</th>
        <th>uid</th>
        <th>reason</th>
        <th>delete</th>
    </tr>

    <#list cards as card>
        <tr>
        <td>${card.id?c}</td>
        <td>${card.uid}</td>
        <td>${card.reason}</td
        <td>del</td

    </tr>
</#list>
</#if>


</table>
</body>
</html>