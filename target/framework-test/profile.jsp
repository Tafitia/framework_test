<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mon Espace</title>
</head>
<body>
    <h1>Bienvenue, <%= request.getAttribute("nomAffichage") %> !</h1>
    
    <div style="background-color: #f0f0f0; padding: 15px; border-radius: 5px;">
        <h3>Vos données de session :</h3>
        <ul>
            <li><strong>Nom :</strong> <%= request.getAttribute("nomAffichage") %></li>
            <li><strong>Email :</strong> <%= request.getAttribute("emailAffichage") %></li>
        </ul>
    </div>

    <br>
    <a href="profile">Rafraîchir la page (Test de session)</a>
    <br><br>
    <a href="logout" style="color: red;">Se Déconnecter</a>
</body>
</html>