<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulaire departement</title>
</head>
<body>
    <h2>Formulaire departement</h2>
    
    <form action="form-emp" method="post">

            <h2>Informations </h2>
            ID : <input type="number" name="d.id" ><br>
            Nom : <input type="text" name="d.nom" ><br><br>

            <h4>Employé 1</h4>
            <input type="number" name="liste[0].id" ><br>
            <input type="text" name="liste[0].nom" placeholder="Nom Employé 1"><br><br>

            <h4>Employé 2</h4>
            <input type="number" name="liste[1].id" ><br>
            <input type="text" name="liste[1].nom" placeholder="Nom Employé 2"><br><br>

            <h4>Employé 3</h4>
            <input type="number" name="liste[2].id" ><br>
            <input type="text" name="liste[2].nom" placeholder="Nom Employé 3"><br><br>
        <button type="submit">Envoyer</button>
    </form>
</body>
</html>