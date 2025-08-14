<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header2.jsp" %>

<%
    String lawyerId = request.getParameter("id");
    String name = request.getParameter("name");
    String lastname = request.getParameter("lastname");
%>

<div style="text-align:center; margin-top:50px; min-height:80vh;">
    <h2 style="color:red;">Delete Confirmation</h2>
    <p>Are you sure you want to delete <strong><%= name %> <%= lastname %></strong>?</p>

    <form action="deleteLawyerServlet" method="post" style="margin-top:20px;">
        <input type="hidden" name="id" value="<%= lawyerId %>">

        <button type="submit" style="background-color:#dc3545; color:white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer;">
            Confirm
        </button>
        <a href="adminOurTeam.jsp" style="text-decoration:none; margin-left:10px;">
            <button type="button" style="background-color:#6c757d; color:white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer;">
                Cancel
            </button>
        </a>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
