<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.eduprim.beans.Livre" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kevin
  Date: 27/08/2020
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Emprunt de livres</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css" />
</head>
<body>
    <div class="container">
        <table class="w-full table-fixed border border-rose px-8 py-2">
            <thead class="w-full">
                <tr class="flex w-full mb-4 text-violet">
                    <th class="p-4 w-1/3">Titre</th>
                    <th class="p-4 w-1/4">Auteur</th>
                    <th class="p-4 w-1/4">Genre</th>
                    <th class="p-4 w-1/2">Résumé</th>
                    <th class="p-4 w-1/4">Statut</th>
                    <th class="p-4 w-1/4">Emprunteur</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<Livre> listeLivre = Livre.getAllLivres();



                %>

                listeLivre: <%=Livre.getAllLivres() %>
                
                <c:forEach items="${listeLivre}" var="item">
                    Item = ${item}<br>
                </c:forEach>




            </tbody>
        </table>
    </div>
</body>
</html>
