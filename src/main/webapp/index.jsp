<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="Styles/index.css">
</head>

<body>
    <header>
        <div class="logo">Logo</div>
        <div class="auth-buttons">
            <button onclick="location.href='login.html'">Login</button>
            <button onclick="location.href='signup.html'">Sign Up</button>
        </div>
    </header>

    <div class="container">
        <h2>Login</h2>
        <form action="login" method="get">
            <div class="form-group">
                <label for="phone">Phone number</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="password">Enter your password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
        </form>
    </div>

    <footer>
        <p>&copy; 2025 My Movie Booker</p>
    </footer>
</body>

</html>
