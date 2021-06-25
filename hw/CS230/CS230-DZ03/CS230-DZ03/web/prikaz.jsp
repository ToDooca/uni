
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prikaz izabranog fakulteta</title>
    </head>
    <body>

        <img src="assets/img/login-form-met.png" alt="logo" width="200">
        <h1>Izabrani fakultet :</h1>
        <%
            if (request.getParameter("fname") != null && request.getParameter("fname").equals("fit")) {
                out.print("<b>Vi ste student fakulteta informacionih tehnologija.</b>");

        %>
        <meta http-equiv="Refresh" content="5;url=https://www.metropolitan.ac.rs/osnovne-studije/fakultet-informacionih-tehnologija">
        <% }
            if (request.getParameter("fname") != null && request.getParameter("fname").equals("fam")) {
                out.print("<b>Vi ste student fakulteta za menadžment.</b>");
        %>
        <meta http-equiv="Refresh" content="5;url=https://www.metropolitan.ac.rs/osnovne-studije/fakultet-za-menadzment">
        <%
            }
            if (request.getParameter("fname") != null && request.getParameter("fname").equals("fdu")) {
                out.print("<b>Vi ste student fakulteta digitalnih umetnosti.</b>");
        %>
        <meta http-equiv="Refresh" content="5;url=https://www.metropolitan.ac.rs/fakultet-digitalnih-umetnosti-2">
        <%
            }
        %>
    </body>
</html>
