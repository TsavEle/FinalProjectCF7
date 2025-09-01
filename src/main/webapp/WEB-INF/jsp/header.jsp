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

        /* Login button */
        header .login-button {
            color: white;
            text-decoration: none;
            padding: 10px 15px;
            background-color: #00bfff;
            border-radius: 5px;
            font-weight: bold;
            border: none;
            cursor: pointer;
            transition: background-color 0.2s, opacity 0.2s;
        }

        header .login-button:hover {
            background-color: #009acd;
            opacity: 0.9;
        }

        /* Ensure form does not push button down */
        header form {
            margin: 0;
            display: flex;
            align-items: center;
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
        <form action="login" method="get">
            <button type="submit" class="login-button">Login</button>
        </form>
    </header>
</body>
</html>