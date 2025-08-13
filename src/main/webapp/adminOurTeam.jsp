<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header2.jsp" %>

<div style="text-align:center; margin-top:50px; min-height:80vh;">

    <!-- Navigation Buttons -->
    <div style="margin-bottom:40px;">
        <a href="index.jsp">
            <button style="padding:10px 20px; margin-right:20px;">HOME</button>
        </a>
        <a href="visitorOurFirm.jsp">
            <button style="padding:10px 20px;">OUR FIRM</button>
        </a>
    </div>

   <!-- Combined Search Form -->
       <form action="AdminOurTeamSearchServlet" method="get" style="margin-bottom:50px; display:flex; justify-content:center; gap:20px; align-items:center;">
           <!-- Search by practices -->
           <input type="text" name="practice" placeholder="Search by practices" style="padding:10px 15px; width:200px;">
           <!-- Search by name -->
           <input type="text" name="name" placeholder="Search by name" style="padding:10px 15px; width:200px;">
           <button type="submit" style="padding:10px 15px;">Search</button>
           <!-- Reset button -->
                   <button type="button" style="padding:10px 15px;" onclick="window.location.href='adminOurTeam.jsp'">Reset</button>
       </form>

       <!-- Insert Lawyer Button -->
       <div style="margin:30px 0; text-align:center;">
           <a href="insertLawyer.jsp">
               <button style="padding:10px 20px; background-color:#28a745; color:white; border:none; border-radius:5px; cursor:pointer;">
                   Insert Lawyer
               </button>
           </a>
       </div>

    <!-- Lawyers Board -->
    <div style="display:flex; flex-direction:column; align-items:center; gap:30px;">

        <!-- Mock Lawyer -->
        <div style="border:1px solid #ccc; padding:20px; width:600px; text-align:left; border-radius:8px;">
            <h3>John Papadopoulos</h3>
            <p><strong>City:</strong> Athens</p>
            <p><strong>Surname:</strong> Papadopoulos</p>
            <p><strong>Zipcode:</strong> 10552</p>
            <p><strong>Email:</strong> john@example.com</p>
            <p><strong>Phone:</strong> +30 210 1234567</p>

            <!-- Admin buttons -->
            <div style="margin-top:15px;">
                <button style="padding:5px 15px; margin-right:10px;">Full View</button>
                <button style="padding:5px 15px; margin-right:10px;">Update</button>
                <button style="padding:5px 15px; background-color:#c00; color:white;">Delete</button>
            </div>
        </div>

    </div>

</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>