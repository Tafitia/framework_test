<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
    <h2>Identifiez-vous</h2>

    <% if(request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <% if(request.getAttribute("info") != null) { %>
        <p style="color: blue;"><%= request.getAttribute("info") %></p>
    <% } %>

    <form action="login" method="post">
        <p>
            <label>Votre Nom :</label>
            <input type="text" name="nom" required placeholder="Ex: Rakoto">
        </p>
        <p>
            <label>Votre Email :</label>
            <input type="email" name="email" required placeholder="Ex: rabe@mail.mg">
        </p>
        <button type="submit">Entrer</button>
    </form>
</body>
</html>