<%--
  Created by IntelliJ IDEA.
  User: sergio
  Date: 22/02/16
  Time: 13:02
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Hubbub</title>
    <meta name="layout" content="main"/>
</head>

<body>
    <formset>
        <legend>Search for Friends</legend>
        <g:form action="results">
            <label for="loginId">Login ID</label>
            <g:textField name="loginId"/>
            <g:submitButton name="search" value="Search" />
        </g:form>
    </formset>
</body>
</html>