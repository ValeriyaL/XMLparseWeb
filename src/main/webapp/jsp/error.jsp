<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.text"/>
<html><head><title><fmt:message key="label.error.caption"/></title></head>
<body>
<fmt:message key="label.error.request"/> ${pageContext.errorData.requestURI} <fmt:message key="label.error.failed"/>
<br/>
<fmt:message key="label.error.servlet"/>: ${pageContext.errorData.servletName}
<br/>
<fmt:message key="label.error.code"/>: ${pageContext.errorData.statusCode}
<br/>
<fmt:message key="label.error.exception"/>: ${pageContext.errorData.throwable}
<a href="jsp/main.jsp"><fmt:message key="label.error.main"/></a>
</body></html>
