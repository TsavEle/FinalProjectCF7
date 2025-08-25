<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Our Team</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/visitor.css">
</head>
<body>

<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="main-content" style="text-align:center; margin-top:100px;">

    <!-- Navigation buttons -->
    <div style="margin-bottom:40px;">
        <a href="index.jsp"><button style="padding:10px 20px; margin-right:20px;">HOME</button></a>
        <a href="visitorOurFirm"><button style="padding:10px 20px;">OUR FIRM</button></a>
    </div>

    <!-- Search bar -->
    <div style="margin-bottom:50px;">
        <form action="visitorOurTeam" method="get">
            <input type="text" name="practice" placeholder="Search by practices" style="padding:10px; width:300px;">
            <button type="submit" style="padding:10px 20px;">Search</button>
        </form>
    </div>

    <!-- Lawyers board -->
    <div style="max-width:1000px; margin:0 auto; text-align:left;">
        <table border="1" cellpadding="10" cellspacing="0" style="width:100%; border-collapse:collapse;">
            <thead style="background-color:#004080; color:white;">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Practice</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>City</th>
                    <th>Zipcode</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty lawyers}">
                        <c:forEach var="l" items="${lawyers}">
                            <tr>
                                <td>${l.firstname}</td>
                                <td>${l.lastname}</td>
                                <td>${l.skillsAsString}</td>
                                <td>${l.email}</td>
                                <td>${l.phoneNumber}</td>
                                <td>${l.city.name}</td>
                                <td>${l.zipcode}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="7" style="text-align:center;">No lawyers found.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>

</body>
</html>
