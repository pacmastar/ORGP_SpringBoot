<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Spring boot</h1>
<a href="/payment">payments list</a>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>age</th>
        <th>action</th>
    </tr>
    <#list list as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td>
                <a href="/view/${user.id}">view</a>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </#list>

</table>

<form name = "user" action="/addUser" method="post">
    Name:<br>
    <input type="text" name="name">
    <br>Email:<br>
    <input type="text" name="email">
    <br>Age:<br>
    <input type="text" name="age">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

