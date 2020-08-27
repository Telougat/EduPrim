<%--
  Created by IntelliJ IDEA.
  User: Enzo
  Date: 27/08/2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Connectez-vous !</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css" />
    </head>
    <body class="h-screen overflow-hidden flex items-center">
        <div class="w-full flex flex-wrap justify-center">
            <div class="w-1/3 lg:w-1/2">
                <img class="w-full" src="${pageContext.request.contextPath}/ressources/images/logo.png" alt="logo">
            </div>
            <div class="w-4/5 lg:w-1/2 rounded px-8 pt-6 pb-8 mb-4 flex flex-col">
                <div style="font-family: Tahoma,sans-serif;" class="mb-4 text-6xl text-gris text-center">
                    <h1>Vous êtes de retour !</h1>
                </div>
                <div class="mb-6">
                    <label class="block text-grey-darker font-bold mb-1 text-md text-gris" for="identifiant">
                        Identifiant
                    </label>
                    <input class="shadow appearance-none border-solid border border-gris rounded w-full py-2 px-3 text-grey-darker" id="identifiant" type="text" placeholder="">
                </div>
                <div class="mb-6">
                    <label class="block text-grey-darker text-4xl lg:text-md font-bold mb-1 text-gris" for="mdp">
                        Mot de passe
                    </label>
                    <input class="shadow appearance-none border border-gris rounded w-full py-2 px-3 text-grey-darker mb-3" id="mdp" type="password" placeholder="">
                </div>
                <div class="flex items-center justify-between">
                    <button class="bg-violet hover:bg-blue-dark text-blanc font-bold py-2 px-4 rounded w-full" type="button">
                        Se connecter
                    </button>
                </div>
                <p class="text-sm">
                    Vous ne possédez pas de compte ? <a class="text-violet" href="#">créer un compte</a>
                </p>
            </div>
        </div>
    </body>
</html>
