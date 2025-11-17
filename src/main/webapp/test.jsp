
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Test JSP Page</h1>
    <ul>
        <% 
            String[] persons = (String[]) request.getAttribute("persons");
            for (String person : persons) {
        %>
            <li><%= person %></li>
        <% } %>
    </ul>
</body>
</html>