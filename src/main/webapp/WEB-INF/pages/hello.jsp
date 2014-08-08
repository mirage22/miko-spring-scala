<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Miko: Scala Spring 4 Project without Web.xml</title>
    <link rel="stylesheet" href="<c:url value="/app/css/style.css" />" >
</head>
<body>
    <div class="exampleText1">
        Scala Message:
    </div>
    <div class="exampleText2">
        <h1>${message}</h1>
        <h1>${importMessage}</h1>
    </div>
</body>
</html>
