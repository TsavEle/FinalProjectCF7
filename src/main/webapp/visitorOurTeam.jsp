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

    <style>
        /* Navigation buttons styling */
        .nav-button {
            background-color: #004080; /* deep blue */
            color: #ffffff; /* white text */
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-weight: bold;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.2s, opacity 0.2s;
            display: inline-block;
            margin-right: 10px;
        }

        .nav-button:last-child {
            margin-right: 0; /* remove margin from the last button */
        }

        .nav-button:hover {
            background-color: #003366; /* darker on hover */
            opacity: 0.9;
        }

        /* Search button style */
        .search-button {
            padding: 15px 40px;
            font-size: 18px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: opacity 0.2s;
        }

        .search-button:hover {
            opacity: 0.9;
        }

        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 10px;
            border: 1px solid #ddd;
        }

        table thead {
            background-color: #004080;
            color: white;
        }

        /* Input field */
        input[type="text"] {
            padding: 10px;
            width: 300px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="main-content" style="text-align:center; margin-top:100px;">

    <!-- Navigation buttons -->
    <div style="margin-bottom:40px;">
        <a href="index.jsp" class="nav-button">HOME</a>
        <a href="visitorOurFirm" class="nav-button">OUR FIRM</a>
    </div>

    <!-- Search bar -->
    <div style="margin-bottom:50px;">
        <form action="visitorOurTeam" method="get">
            <input type="text" name="practice" placeholder="Search by practices">
            <button type="submit" class="search-button">Search</button>
        </form>
    </div>

    <!-- Lawyers board -->
    <div style="max-width:1000px; margin:0 auto; text-align:left;">
        <table>
            <thead>
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