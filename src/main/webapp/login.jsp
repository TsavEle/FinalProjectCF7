
<%@ include file="WEB-INF/jsp/header3.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="max-width:400px; margin:100px auto; text-align:center;">
    <h2>Login</h2>

    <!-- Error message -->
        <c:if test="${param.error eq 'true'}">
            <div style="color:red; margin-bottom:15px;">
                Invalid username or password.
            </div>
        </c:if>

    <!-- Form sends POST request to LoginController -->
    <form action="login" method="post">

        <div style="margin-bottom:15px;">
            <input type="text"
                   name="username"
                   placeholder="Username"
                   required
                   style="width:100%; padding:8px;">
        </div>

        <div style="margin-bottom:15px;">
            <input type="password"
                   name="password"
                   placeholder="Password"
                   required
                   style="width:100%; padding:8px;">
        </div>


        <div>
            <button type="submit" style="padding:15px 40px; font-size:18px; background-color:#28a745; color:white; border:none; border-radius:8px; cursor:pointer;">
                Login
            </button>
        </div>

    </form>
</div>



<%@ include file="WEB-INF/jsp/footer.jsp" %>

