<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/header2.jsp"%>

<div class="main-content" style="text-align:center; margin-top:100px;">
    <h2>Lawyer Details</h2>

    <c:if test="${not empty lawyer}">
        <div style="max-width:600px; margin:0 auto; text-align:left; padding:20px; border:1px solid #ddd; border-radius:10px;">
            <p><strong>Name:</strong> ${lawyer.firstname} ${lawyer.lastname}</p>
            <p><strong>Email:</strong> ${lawyer.email}</p>
            <p><strong>Phone:</strong> ${lawyer.phoneNumber}</p>
            <p><strong>City:</strong> ${city.name}</p>
            <p><strong>Zipcode:</strong> ${lawyer.zipcode}</p>
            <p><strong>VAT:</strong> ${lawyer.vat}</p>
            <p><strong>Skills:</strong>
                <c:forEach var="skill" items="${lawyer.skills.values()}" varStatus="status">
                    ${skill.name}<c:if test="${!status.last}">, </c:if>
                </c:forEach>
            </p>
        </div>
    </c:if>

    <div style="margin-top:20px;">
        <a href="adminOurTeam"><button style="padding:10px 20px;">Back to Team</button></a>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>