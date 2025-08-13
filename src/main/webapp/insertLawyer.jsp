<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/header2.jsp" %>


<div style="text-align:center; margin-top:30px; min-height:80vh;">
    <h2>Insert New Lawyer</h2>

    <form id="insertLawyerForm" style="display:inline-block; text-align:left; margin-top:20px; width:450px;">

        <!-- Name -->
        <div style="margin-bottom:15px;">
            <label>Name:</label><br>
            <input type="text" name="name" style="width:100%; padding:10px;">
        </div>

        <!-- Lastname -->
        <div style="margin-bottom:15px;">
            <label>Lastname:</label><br>
            <input type="text" name="lastname" style="width:100%; padding:10px;">
        </div>

        <!-- Phone -->
        <div style="margin-bottom:15px;">
            <label>Phone:</label><br>
            <input type="text" name="phone" style="width:100%; padding:10px;">
        </div>

        <!-- Email -->
        <div style="margin-bottom:15px;">
            <label>Email:</label><br>
            <input type="email" name="email" style="width:100%; padding:10px;">
        </div>

        <!-- Practices Multi-Select -->
        <div style="margin-bottom:15px;">
            <label for="practices">Practices:</label><br>
            <div class="multiselect" style="position:relative; width:100%;">
                <div class="selectBox" onclick="toggleCheckboxes()">
                    <select style="width:100%; padding:10px;">
                        <option>Select Practices</option>
                    </select>
                    <div class="overSelect" style="position:absolute; top:0; left:0; right:0; bottom:0; cursor:pointer;"></div>
                </div>
                <div id="checkboxes" style="display:none; border:1px solid #ccc; padding:10px; background:white; position:absolute; width:100%; z-index:10;">
                    <label><input type="checkbox" value="Civil Law" onclick="updateSelectText()"> Civil Law</label><br>
                    <label><input type="checkbox" value="Criminal Law" onclick="updateSelectText()"> Criminal Law</label><br>
                    <label><input type="checkbox" value="Corporate Law" onclick="updateSelectText()"> Corporate Law</label><br>
                    <label><input type="checkbox" value="Family Law" onclick="updateSelectText()"> Family Law</label><br>
                    <label><input type="checkbox" value="Tax Law" onclick="updateSelectText()"> Tax Law</label>
                </div>
            </div>
        </div>

        <!-- City -->
        <div style="margin-bottom:15px;">
            <label>City:</label><br>
            <select name="city" style="width:100%; padding:10px;">
                <option value="" disabled selected>Select City</option>
                <option value="Athens">Athens</option>
                <option value="Thessaloniki">Thessaloniki</option>
                <option value="Patras">Patras</option>
            </select>
        </div>

        <!-- VAT -->
        <div style="margin-bottom:15px;">
            <label>VAT:</label><br>
            <input type="text" name="vat" style="width:100%; padding:10px;">
        </div>

        <!-- Zipcode -->
        <div style="margin-bottom:15px;">
            <label>Zipcode:</label><br>
            <input type="text" name="zipcode" style="width:100%; padding:10px;">
        </div>

        <!-- Street -->
        <div style="margin-bottom:15px;">
            <label>Street:</label><br>
            <input type="text" name="street" style="width:100%; padding:10px;">
        </div>

        <!-- Street Number -->
        <div style="margin-bottom:15px;">
            <label>Street Number:</label><br>
            <input type="text" name="street_number" style="width:100%; padding:10px;">
        </div>

        <!-- Buttons -->
        <div style="text-align:center; margin-top:20px;">
            <button type="submit" style="background-color: #28a745; color: white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer;">
                Submit
            </button>
            <button type="reset" style="background-color: #28a745; color: white; padding:10px 20px; border:none; border-radius:5px; cursor:pointer;">
                Reset
            </button>
        </div>
    </form>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>

<script>
let expanded = false;

function toggleCheckboxes() {
    let checkboxes = document.getElementById("checkboxes");
    checkboxes.style.display = expanded ? "none" : "block";
    expanded = !expanded;
}

function updateSelectText() {
    let selected = [];
    document.querySelectorAll('#checkboxes input[type="checkbox"]:checked').forEach(cb => {
        selected.push(cb.value);
    });
    document.querySelector(".selectBox select option").textContent = selected.length > 0 ? selected.join(", ") : "Select Practices";
}

function resetPractices() {
    document.querySelectorAll('#checkboxes input[type="checkbox"]').forEach(cb => cb.checked = false);
    document.querySelector(".selectBox select option").textContent = "Select Practices";
}

document.addEventListener("click", function(e) {
    if (!document.querySelector(".multiselect").contains(e.target)) {
        document.getElementById("checkboxes").style.display = "none";
        expanded = false;
    }
});
</script>

