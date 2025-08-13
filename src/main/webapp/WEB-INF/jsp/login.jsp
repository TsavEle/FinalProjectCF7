<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jsp/header.jsp" %>

<div style="max-width:400px; margin:100px auto; text-align:center;">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <div style="margin-bottom:15px;">
            <input type="text" name="username" placeholder="Username" required style="width:100%; padding:8px;">
        </div>
        <div style="margin-bottom:15px;">
            <input type="password" name="password" placeholder="Password" required style="width:100%; padding:8px;">
        </div>
        <div>
            <button type="submit" style="padding:10px 20px;">Login</button>
        </div>
    </form>
</div>

<%@ include file="jsp/footer.jsp" %>
