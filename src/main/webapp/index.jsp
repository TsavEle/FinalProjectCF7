<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div style="text-align:center; margin-top:100px;">
    <h2>Welcome to our directory</h2>
    <p>Search and view information about lawyers in Greece.</p>

    <div style="margin-top:50px;">
        <form action="our-firm.jsp" method="get" style="display:inline;">
            <button type="submit" style="padding:15px 30px; font-size:18px; margin-right:20px;">OUR FIRM</button>
        </form>

        <form action="our-team.jsp" method="get" style="display:inline;">
            <button type="submit" style="padding:15px 30px; font-size:18px;">OUR TEAM</button>
        </form>
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



</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
