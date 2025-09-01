<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<style>
    /* Style for navigation buttons */
    .nav-button {
        background-color: #004080; /* deep blue */
        color: #ffffff; /* white text */
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-weight: bold;
        text-decoration: none; /* for <a> tags */
        cursor: pointer;
        transition: background-color 0.2s, opacity 0.2s;
    }

    .nav-button:hover {
        background-color: #003366; /* slightly darker on hover */
        opacity: 0.9;
    }
</style>

<div style="text-align:center; margin-top:100px;">
    <h2>Welcome to our directory</h2>
    <p>Search and view information about lawyers in Greece.</p>

    <div style="margin-top:50px;">
        <a href="visitorOurFirm" class="nav-button">OUR FIRM</a>
        <a href="visitorOurTeam" class="nav-button">OUR TEAM</a>
    </div>

    <!-- About Us section -->
    <div style="margin-top:70px; max-width:800px; margin-left:auto; margin-right:auto; text-align:center; margin-bottom:220px;">
        <h3>ABOUT US</h3>
        <p style="text-align:left;">
            Papadopoulos Lawyers Directory is dedicated to connecting clients with the most qualified legal professionals across Greece.
            Our platform provides detailed profiles of lawyers, including their skills, experience, and contact information,
            making it easy to find the right expert for your needs. We are committed to accuracy, transparency, and supporting
            the legal community.
        </p>
    </div>

     <div style="margin-top:20px; text-align:center;">
         <img src="${pageContext.request.contextPath}/img/Law-firms.jpeg"
              alt="Law-firms"
              style="max-width:600px; width:100%; height:auto; border-radius:15px; display:inline-block;">
     </div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>