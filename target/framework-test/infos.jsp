<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
    <h2>Entrez vos informations</h2>
    <form action="info" method="post">
        <input type="text" name="nom" placeholder="Votre nom ici...">
        <input type="date" name="date" >
        <input type="number" name="age">
        <p> Telephone :</p>
        <input type="tel" name="telephone" placeholder="Votre téléphone ici...">

        <p>loisirs :</p>
        <input type="checkbox" id="dance" name="loisir" value="dance">
        <label for="dance">Dance</label><br>
        <input type="checkbox" id="sport" name="loisir" value="sport">
        <label for="sport">Sport</label><br>
        <input type="checkbox" id="lecture" name="loisir" value="lecture">
        <label for="lecture">Lecture</label><br>
        <input type="checkbox" id="chant" name="loisir" value="chant">
        <label for="chant">Chant</label><br>
        <input type="checkbox" id="cinema" name="loisir" value="cinema">
        <label for="cinema">Cinéma</label><br><br>
        
        <button type="submit">Valider</button>
    </form>
    
</body>
</html>