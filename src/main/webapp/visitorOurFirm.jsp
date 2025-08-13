<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<div style="display:flex; flex-direction:column; min-height:100vh;">

    <!-- Main content -->
    <div style="text-align:center; padding:50px 20px; max-width:800px; margin:0 auto; flex:1;">
        <h2>OUR FIRM</h2>
        <p style="text-align:left;">
            Papadopoulos Lawyers Directory is dedicated to providing comprehensive legal services across Greece.
            Our firm connects clients with highly experienced and specialized lawyers in areas such as corporate law,
            family law, criminal law, intellectual property, and more. We focus on matching the right legal expert
            with each client’s unique needs, ensuring professional guidance and reliable outcomes.

            With years of experience and an extensive network of legal professionals, our goal is to make the process
            of finding trustworthy legal assistance simple and efficient. We prioritize transparency, responsiveness,
            and personalized service, so every client feels supported and informed throughout their legal journey.

            Whether you need advice on complex legal matters, representation in court, or assistance with contracts
            and documentation, Papadopoulos Lawyers Directory serves as your trusted partner in navigating the legal landscape.
        </p>

        <!-- Navigation buttons -->
        <div style="margin-top:30px;">
            <a href="index.jsp">
                <button style="padding:10px 20px; margin-right:20px;">HOME</button>
            </a>
            <a href="visitorOurTeam.jsp">
                <button style="padding:10px 20px;">OUR TEAM</button>
            </a>
        </div>
    </div>

    <!-- Footer pushed to bottom -->
    <div style="margin-top:auto;">
        <%@ include file="/WEB-INF/jsp/footer.jsp" %>
    </div>

</div>




