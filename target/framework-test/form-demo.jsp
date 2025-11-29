<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test Formulaire</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
        }
        form {
            background: #f4f4f4;
            padding: 20px;
            border-radius: 8px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
        .note {
            background: #fff3cd;
            padding: 10px;
            border-left: 4px solid #ffc107;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <h1>Test d'injection de parametres</h1>

    <form action="form-test" method="POST">
        <label for="id">ID (int):</label>
        <input type="number" id="id" name="id" value="123" required>
        
        <label for="name">Nom (String):</label>
        <input type="text" id="name" name="name" value="Tafita" required>
        
        <input type="submit" value="Envoyer">
    </form>

    <h2>Test avec parametre manquant</h2>
    <form action="form-test" method="POST">
        <label for="id2">ID uniquement:</label>
        <input type="number" id="id2" name="id" value="456" required>
        
        <input type="submit" value="Envoyer sans nom">
    </form>
</body>
</html>
