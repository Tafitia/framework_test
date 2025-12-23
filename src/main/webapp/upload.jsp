<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test Upload Simple</title>
</head>
<body>
    <h2>Uploader des fichiers</h2>
    
    <form action="upload" method="post" enctype="multipart/form-data">
        
        <p>
            <label>Premier fichier :</label><br>
            <input type="file" name="file1" multiple>
        </p>
        
        <p>
            <label>Deuxième fichier :</label><br>
            <input type="file" name="file2">
        </p>
        
        <button type="submit">Envoyer</button>
    </form>
    
</body>
</html>