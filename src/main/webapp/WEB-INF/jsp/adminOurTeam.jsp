
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
    <title>Admin - Our Team</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/visitor.css">
</head>
<body>

<%@ include file="/WEB-INF/jsp/header2.jsp"%>

<c:if test="${not empty sessionScope.successMessage}">
    <div style="color: green; text-align: center; margin: 10px 0;">
        ${sessionScope.successMessage}
    </div>
    <c:remove var="successMessage" scope="session"/>
</c:if>

<c:if test="${not empty sessionScope.errorMessage}">
    <div style="color: red; text-align: center; margin: 10px 0;">
        ${sessionScope.errorMessage}
    </div>
    <c:remove var="errorMessage" scope="session"/>
</c:if>

<div class="main-content" style="text-align:center; margin-top:100px;">
    <!-- Search bar -->
    <div style="margin-bottom:50px;">
        <form action="adminOurTeam" method="get">
            <input type="text" name="practice" placeholder="Search by practices" style="padding:10px; width:300px;">
            <button type="submit" style="padding:15px 40px; font-size:18px; background-color:#28a745; color:white; border:none; border-radius:8px; cursor:pointer;">
                Search
            </button>
        </form>
    </div>

    <!-- Insert Lawyer button -->
        <div style="margin-bottom:50px;">
            <a href="${pageContext.request.contextPath}/insertLawyer">
                <button style="padding:15px 40px; font-size:18px; background-color:#28a745; color:white; border:none; border-radius:8px; cursor:pointer;">
                    Insert Lawyer
                </button>
            </a>
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
                    <th>Actions</th>
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
                                <td>
                                    <a href="fullViewLawyer?id=${l.id}">
                                        <button style="padding:5px 10px; margin:2px; background-color:#007bff; color:white; border:none; border-radius:4px;">
                                            Full View
                                        </button>
                                    </a>
                                    <a href="${pageContext.request.contextPath}/updateLawyer?id=${l.id}">
                                        <button style="padding:5px 10px; margin:2px; background-color:#28a745; color:white; border:none; border-radius:4px;">
                                            Update
                                        </button>
                                    </a>
                                    <button style="padding:5px 10px; margin:2px; background-color:#dc3545; color:white; border:none; border-radius:4px;"
                                            onclick="openDeleteModal('${l.id}', '${l.firstname}', '${l.lastname}')">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="8" style="text-align:center;">No lawyers found.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>

</div>

<!-- Delete Confirmation Modal -->
<div id="deleteModal" class="modal" style="display:none; position:fixed; z-index:1000; left:0; top:0; width:100%; height:100%; overflow:auto; background-color:rgba(0,0,0,0.5);">
    <div class="modal-content" style="background-color:white; margin:15% auto; padding:30px; border-radius:10px; width:400px; text-align:center;">
        <h2 style="color:red;">Delete Confirmation</h2>
        <p>Are you sure you want to delete <strong id="lawyerName"></strong>?</p>

        <form id="deleteForm" action="${pageContext.request.contextPath}/deleteLawyerController" method="post" style="margin-top:20px;">
            <input type="hidden" name="id" id="lawyerId">
            <button type="submit" style="background-color:#dc3545; color:white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer;">
                Confirm
            </button>
            <button type="button" style="background-color:#6c757d; color:white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer; margin-left:10px;"
                    onclick="closeDeleteModal()">
                Cancel
            </button>
        </form>
    </div>
</div>

<script>
    function openDeleteModal(id, name, lastname) {
        document.getElementById('lawyerId').value = id;
        document.getElementById('lawyerName').innerText = name + ' ' + lastname;
        document.getElementById('deleteModal').style.display = 'block';
    }

    function closeDeleteModal() {
        document.getElementById('deleteModal').style.display = 'none';
    }

    window.onclick = function(event) {
        const modal = document.getElementById('deleteModal');
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
</script>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>