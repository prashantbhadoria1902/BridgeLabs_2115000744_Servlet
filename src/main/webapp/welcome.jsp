<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
    <h2>Welcome, <%= request.getAttribute("user") %>!</h2>
    <p>You have successfully logged in.</p>
</body>
</html>
