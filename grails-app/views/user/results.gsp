<%--
  Created by IntelliJ IDEA.
  User: sergio
  Date: 22/02/16
  Time: 17:43
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Hubbub</title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1>Results</h1>
<%--Displays total number of users in the system--%>
<p>
    Searched ${totalUsers} records
    for items matching <em>${term}</em>.
Found <strong>${users.size()}</strong> hits.
</p>
<ul>
    <g:each var="user" in="${users}">
    <%--Iterates over all matched users--%>
        <li>${user.loginId}</li>
    </g:each>
</ul>
<g:link action='search'>Search Again</g:link>
</body>
</html>