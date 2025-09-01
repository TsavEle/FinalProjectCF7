<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Papadopoulos Lawyers Directory</title>
    <style>
        /* Header styling */
        header {
            background-color: #1e90ff; /* lighter blue */
            color: white;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        /* Header title */
        header h1 {
            margin: 0;
            font-size: 24px;
        }

        /* Logout button styling */
        .logout-button {
            padding: 10px 20px;
            font-size: 16px;
            margin-left: 20px;
            background-color: #dc3545;  /* red for logout */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: flex;
            align-items: center;
            transition: background-color 0.2s, opacity 0.2s;
            font-family: 'Segoe UI Emoji', Arial, sans-serif; /* added for emoji support */
        }

        /* Hover effect */
        .logout-button:hover {
            background-color: #c82333; /* slightly darker red */
            opacity: 0.9;
        }

        /* Optional: make body background light gray */
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f2f2f7;
        }
    </style>
</head>
<body>
    <header>
        <h1>Papadopoulos Lawyers Directory</h1>
        <form action="logout" method="get" style="display:flex; align-items:center;">
            <button type="submit" class="logout-button">
                <span style="margin-right:8px;">🔓</span> Logout
            </button>
        </form>
    </header>
</body>
</html>
