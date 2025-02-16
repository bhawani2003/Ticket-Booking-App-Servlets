<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Booking - Order Summary</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Styles/orderSummary.css">
</head>
<body>
    <header>
        <a href="${pageContext.request.contextPath}/movieapp/home" class="logo">Logo</a>
        <div class="nav-links">
            <input type="text" placeholder="Search Movie">
            <input type="text" placeholder="Search Theatre">
        </div>
        <button class="profile-btn" onclick="GotoProfile()">Profile</button>
    </header>

    <main class="main-container">
        <div class="left-section">
            <div class="box"></div>
            <div class="info">Movie info</div>
        </div>
        <div class="payment-section">
            <h4>Order Summary:</h4>
            <div class="payment-details">Order details go here...</div>
        </div>
    </main>

    <div class="buttons-container">
        <button class="button" onclick="GotoPayments()">Confirm</button>
        <button class="button" onclick="GotoSeatSelection()">Cancel</button>
    </div>

    <footer>
        <p>&copy; 2024 My Movie Booker</p>
    </footer>
</body>
<script>
function GotoPayments(){
	window.location.href="/movieapp/payments";
}

function GotoSeatSelection(){
	window.location.href="/movieapp/seat-selection";
}

function GotoProfile(){
	window.location.href="/movieapp/profile"
}
</script>
</html>
