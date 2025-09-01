<%@ include file="/WEB-INF/jsp/header2.jsp" %>

<div style="text-align:center; margin-top:100px; min-height:70vh;">
    <h2 style="color:green;">✅ Lawyer Inserted Successfully!</h2>
    <p>The lawyer’s information has been added to the directory.</p>

    <div style="margin-top:30px;">
        <a href="adminOurTeam.jsp">
            <button style="background-color: #28a745; color: white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer;">
                Back to Our Team
            </button>
        </a>
        <a href="insertLawyer.jsp">
            <button style="background-color: #28a745; color: white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer;">
                Insert Another Lawyer
            </button>
        </a>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>