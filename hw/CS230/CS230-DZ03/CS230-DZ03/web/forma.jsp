<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Izabrano</title>
    </head>
    <body>
        <h1>Link ka izabranim fakultetima :</h1>
        <%
            if (!request.getParameter("ime").equals("")) {
                out.print("Dobrodošao/la " + request.getParameter("ime") + ", izabrao si sledeće fakultete:<br>");
            } else {
                out.print("Polje za ime ste ostavili prazno !!");
            }
            if (request.getParameter("fit") != null && request.getParameter("fit").equals("on")) {
                out.print("<b>Za link ka FIT: </b>");
                out.print("<a href='prikaz.jsp?fname=" + "fit" + "'>Kliknite ovde</a></br>");
                out.print("<p><em>Fakultet informacionih tehnologija – FIT, nastao je 2005. godine. "
                        + "Izgrađen je po principima koje definiše Bolonjska deklaracija za "
                        + "evropski sistem obrazovanja.<br>Nastavni programi u oblasti informacionih "
                        + "tehnologija su usaglašeni sa preporukama američkih informatičkih "
                        + "profesionalnih udruženja IEEE i ACM,<br>koje usmeravaju programe američkih "
                        + "univerziteta u informatičkim oblastima, a u skladu sa potrebama preduzeća, "
                        + "vladinih i drugih organizacija.</em></p>");
            }
            if (request.getParameter("fdu") != null && request.getParameter("fdu").equals("on")) {
                out.print("<b>Za link ka FDU: </b>");
                out.print("<a href='prikaz.jsp?fname=" + "fdu" + "'>Kliknite ovde</a></br>");
                out.print("<p><em>Grafički dizajn, kao umetnička disciplina, "
                        + "se bavi kreativnim procesom koji ostvaruje vizualnu "
                        + "komunikaciju sa korisnima dobijenog vizualnog rešenja.</em></p>");
            }
            if (request.getParameter("fam") != null && request.getParameter("fam").equals("on")) {
                out.print("<b>Za link ka FAM: </b>");
                out.print("<a href='prikaz.jsp?fname=" + "fam" + "'>Kliknite ovde</a></br>");
                out.print("<p><em>Savremeno poslovanje odvija se na globalnom tržištu, "
                        + "u uslovima konkurentnosti (što je sve manje pitanje uspeha, "
                        + "a sve više uslov opstanka preduzeća),<br>a bazira na informacijama "
                        + "i znanju koje postaju ključni proizvodni resurs.</em></p>");
            }
        %>
    </body>
</html>
