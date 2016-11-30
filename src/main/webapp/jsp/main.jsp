<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.text" />
<html><head><title><fmt:message key="title"/></title></head>
<body>
<h3><fmt:message key="label.language"/></h3>
<form name="Language" action="../candyaction" method="post">
    <select name="language">
        <option value="en_US"><fmt:message key="label.language.english"/></option>
        <option value="ru_RU"><fmt:message key="label.language.russian"/></option>
    </select>
    <button type="submit" name="command" value="Language"><fmt:message key="label.button.language"/></button>
</form>
<form method="POST" enctype="multipart/form-data" action="../candyaction">
    <h3><fmt:message key="label.parsing"/></h3>
    <select name="parser" required>
        <option value="sax">SAX</option>
        <option value="dom">DOM</option>
        <option value="stax">StAX</option>
    </select>
    <h3><fmt:message key="label.file"/></h3>
    <input type="file" name="upfile"><br/><br/>
    <button type="submit" name="command" value="Parser"><fmt:message key="label.button.parse"/></button>
</form>
</body></html>
