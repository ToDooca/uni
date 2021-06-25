<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izbor</title>
    </head>
    <body>
        <h1>Napravite izbor :</h1>
        <form method="GET" action="forma.jsp">
            FIT:<input type="checkbox" name="fit"/></br>
            FDU:<input type="checkbox" name="fdu"/></br>
            FAM:<input type="checkbox" name="fam"/></br>
            <label>Vaše ime: </label>
            <input type="text" name="ime"/>
            <input type="submit" value="Posalji"/>
        </form>

    </body>
</html>