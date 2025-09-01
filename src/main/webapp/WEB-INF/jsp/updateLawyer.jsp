<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Lawyer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/visitor.css">
    <style>
        .form-container { max-width: 600px; margin: 50px auto; background: #fff; padding: 30px; border-radius: 10px; box-shadow: 0 4px 10px rgba(0,0,0,0.2); }
        .form-container h2 { text-align: center; margin-bottom: 25px; color: #004080; }
        .form-group { margin-bottom: 20px; }
        .form-group label { display: block; font-weight: bold; margin-bottom: 8px; }
        .form-group input, .form-group select { width: 100%; padding: 10px; border-radius: 6px; border: 1px solid #ccc; }
        .form-actions { text-align: center; margin-top: 25px; }
        .form-actions button { padding: 10px 20px; margin: 0 10px; border: none; border-radius: 6px; cursor: pointer; font-weight: bold; }
        .btn-submit { background-color: #007bff; color: white; }
        .btn-reset { background-color: #6c757d; color: white; }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/jsp/header2.jsp"%>

<div style="text-align: center; margin-bottom: 40px;">
    <a href="${pageContext.request.contextPath}/adminOurTeam">
        <button style="padding: 10px 20px;">BACK</button>
    </a>
</div>

<div class="form-container">
    <h2>Update Lawyer</h2>

    <form action="${pageContext.request.contextPath}/saveUpdatedLawyer" method="post">
        <!-- Hidden ID -->
        <input type="hidden" name="id" value="${lawyer.id}">

        <!-- Firstname -->
        <div class="form-group">
            <label for="firstname">First Name</label>
            <input type="text" id="firstname" name="firstname" value="${lawyer.firstname}" required>
        </div>

        <!-- Lastname -->
        <div class="form-group">
            <label for="lastname">Last Name</label>
            <input type="text" id="lastname" name="lastname" value="${lawyer.lastname}" required>
        </div>

        <!-- Phone -->
        <div class="form-group">
            <label for="phoneNumber">Phone Number</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${lawyer.phoneNumber}" required>
        </div>

        <!-- Email -->
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="${lawyer.email}" required>
            <c:if test="${not empty sessionScope.emailError}">
                <div style="color:red; font-size:14px;">${sessionScope.emailError}</div>
                <c:remove var="emailError" scope="session"/>
            </c:if>
        </div>

        <!-- VAT -->
        <div class="form-group">
            <label for="vat">VAT</label>
            <input type="text" id="vat" name="vat" value="${lawyer.vat}" required>
            <c:if test="${not empty sessionScope.vatError}">
                <div style="color:red; font-size:14px;">${sessionScope.vatError}</div>
                <c:remove var="vatError" scope="session"/>
            </c:if>
        </div>

        <!-- Street Name -->
        <div class="form-group">
            <label for="streetName">Street Name</label>
            <input type="text" id="streetName" name="streetName" value="${lawyer.streetName}" required>
        </div>

        <!-- Street Number -->
        <div class="form-group">
            <label for="streetNumber">Street Number</label>
            <input type="text" id="streetNumber" name="streetNumber" value="${lawyer.streetNumber}" required>
        </div>

        <!-- Zipcode -->
        <div class="form-group">
            <label for="zipcode">Zipcode</label>
            <input type="text" id="zipcode" name="zipcode" value="${lawyer.zipcode}" required>
        </div>

        <!-- City (dropdown) -->
        <div class="form-group">
            <label for="cityId">City</label>
            <select id="cityId" name="cityId" required>
                <option value="">-- Select City --</option>
                <c:forEach var="c" items="${cities}">
                    <option value="${c.id}" <c:if test="${c.id == lawyer.cityId}">selected</c:if>>${c.name}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Skills (checkbox list) -->
        <div class="form-group">
            <label>Skills</label>
            <c:forEach var="s" items="${skills}">
                <div>
                    <input type="checkbox" name="skills" value="${s.id}"
                        <c:if test="${lawyer.skills[s.id] != null}">checked</c:if>>
                    ${s.name}
                </div>
            </c:forEach>
        </div>

        <!-- Actions -->
        <div class="form-actions">
            <button type="submit" class="btn-submit">Update Lawyer</button>
            <button type="reset" class="btn-reset">Reset</button>
        </div>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>

</body>
</html>

