<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Demo-tracker</title>
    <link rel="icon" type="image/png" href="img/favicon.png" />
    <link rel="stylesheet" href="style/clear.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">
</head>
<body>

<script>
    <#if spring_username??>
    document.__proto__.spring_username = '${spring_username}';
    </#if>
</script>

<div id="app"></div>

<script src="http://localhost:8000/main.js"></script>
</body>
</html>