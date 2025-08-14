<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/header2.jsp" %>

<h2 style="text-align:center; margin-top:20px;">Admin - Our Team</h2>

<!-- Insert Lawyer Button -->
<div style="text-align:center; margin-bottom:20px;">
    <a href="insertLawyer.jsp">
        <button style="background-color:green; color:white; padding:10px 20px; border:none; border-radius:5px;">
            Insert Lawyer
        </button>
    </a>
</div>

<!-- Mock Lawyer Card -->
<div style="display:flex; justify-content:center; margin-top:20px;">
    <div style="
        border:1px solid #ddd;
        border-radius:12px;
        width:320px;
        padding:20px;
        text-align:center;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        transition: transform 0.2s ease, box-shadow 0.2s ease;
    "
    onmouseover="this.style.transform='translateY(-3px)'; this.style.boxShadow='0 8px 16px rgba(0,0,0,0.15)';"
    onmouseout="this.style.transform='translateY(0)'; this.style.boxShadow='0 4px 12px rgba(0,0,0,0.1)';">

        <!-- Avatar -->
        <div style="width:100px; height:100px; margin:0 auto 15px auto; border-radius:50%; overflow:hidden; background-color:#f0f0f0; display:flex; align-items:center; justify-content:center; font-size:40px; color:#888;">
            JD
        </div>

        <!-- Lawyer Info -->
        <h3 style="margin-bottom:5px;">John Doe</h3>
        <p style="margin:3px 0; font-size:14px; color:#555;"><strong>Practice:</strong> Corporate Law</p>
        <p style="margin:3px 0; font-size:14px; color:#555;"><strong>City:</strong> New York</p>

        <!-- Admin buttons -->
        <div style="margin-top:15px;">
            <button style="padding:6px 14px; margin:5px; border-radius:5px; border:none; background-color:#007bff; color:white; cursor:pointer;">
                Full View
            </button>
            <a href="updateLawyer.jsp?id=1">
                <button style="padding:6px 14px; margin:5px; border-radius:5px; border:none; background-color:#28a745; color:white; cursor:pointer;">
                    Update
                </button>
            </a>
            <button style="padding:6px 14px; margin:5px; border-radius:5px; border:none; background-color:#dc3545; color:white; cursor:pointer;"
                    onclick="openDeleteModal('1', 'John', 'Doe')">
                Delete
            </button>
        </div>
    </div>
</div>

<!-- Delete Confirmation Modal -->
<div id="deleteModal" class="modal" style="display:none; position:fixed; z-index:1000; left:0; top:0; width:100%; height:100%; overflow:auto; background-color:rgba(0,0,0,0.5);">
    <div class="modal-content" style="background-color:white; margin:15% auto; padding:30px; border-radius:10px; width:400px; text-align:center;">
        <h2 style="color:red;">Delete Confirmation</h2>
        <p>Are you sure you want to delete <strong id="lawyerName"></strong>?</p>

        <form id="deleteForm" action="deleteLawyerServlet" method="post" style="margin-top:20px;">
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

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
