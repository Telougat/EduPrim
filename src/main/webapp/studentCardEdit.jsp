<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/08/2020
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fiche Élèves - Edition</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css" />
</head>
<body>

<div class="w-3/5 border border-solid border-b-3 border-rose flex items-center">
    <h1>ÉDITION</h1>
</div>
<!-- student card -->
<div class="flex bg-blanc shadow-2xl rounded-lg mx-4 md:mx-auto my-56 w-3/5 border border-gris border-1 pr-4 pl-4">
    <div class="flex items-start px-4 py-6 w-full ml-2">
        <div class="w-full md:w-1/2 bg-red-200 p-1 h-full">
            <div class="flex flex-wrap w-full">
                <div class="md:w-1/2 w-full">
                    <p class="font-semibold text-violet">Nom :</p><br>
                    <input class="font_tahoma shadow appearance-none focus:text-violet border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="name"  placeholder="${Name}">
                </div>
                <div class="w-1/2">
                    <p class="font-semibold text-violet">Prénom :</p><br>
                    <p class="text-rose">${firstName}</p>
                    <input class="font_tahoma shadow appearance-none focus:text-violet border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="firstName"  placeholder="${firstName}">
                </div>
            </div>
            <br>
            <div class="my-3">
                <p class="font-semibold text-violet">Date de naissance :</p><br>
                <input class="font_tahoma  shadow appearance-none focus:text-violet border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="birthDate"  placeholder="${birthDate}">
            </div>
            <div class="my-3">
                <p class="font-semibold text-violet">Adresse du responsable :</p><br>
                <p class="text-rose">${address}</p>
                <input class="font_tahoma  shadow appearance-none focus:text-violet border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="address"  placeholder="${address}">
            </div>
            <div class="my-3">
                <p class="font-semibold text-violet">Adresse mail du responsable :</p><br>
                <input class="font_tahoma  shadow appearance-none focus:text-violet border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="mail"  placeholder="${mail}">
            </div>
            <div class="my-3">
                <p class="font-semibold text-violet">Téléphone du responsable :</p><br>
                <input class="font_tahoma  shadow appearance-none focus:text-violet border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="phone"  placeholder="${phone}">
            </div>
        </div>
        <div class="flex flex-col items-center justify-center md:w-1/2 h-full p-1 hidden md:flex">
            <div class="w-64">
            <img src="${pageContext.request.contextPath}/ressources/images/user.png" alt="user logo">
                <br>
            <button class="bg-violet text-blanc font-bold w-full p-1 rounded-lg  shadow-lg">Modifier</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
