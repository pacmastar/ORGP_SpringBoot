<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Spring boot</h1>

<form name = "user" action="/addUser" method="post">

    <input type="text" name="id" value="${user.id}" hidden="true">
    Name:<br>
    <input type="text" name="name" value="${user.name}">
    <br>Email:<br>
    <input type="text" name="email" value="${user.email}">
    <br>Age:<br>
    <input type="text" name="age" value="${user.age}">
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

