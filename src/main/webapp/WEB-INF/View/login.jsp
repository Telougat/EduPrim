<%@ page import="com.eduprim.beans.Adulte" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Connectez-vous !</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/custom.css" />
    </head>
    <body class="min-h-screen flex items-center">
        <img class="grandbg" src="${pageContext.request.contextPath}/ressources/images/background-1.png" alt="Background">
        <img class="mobilebg" src="${pageContext.request.contextPath}/ressources/images/background-mobile-1.png" alt="Background">
        <div class="w-full flex flex-wrap justify-center mt-16 md:mt-0">
            <div class="mb-4 w-5/6 md:w-4/6 lg:w-2/5 xl:w-1/2 lg:p-20 xl:p-40 flex items-center">
                <img class="w-full" src="${pageContext.request.contextPath}/ressources/images/logo.png" alt="logo">
            </div>
            <div class="w-4/5 lg:w-3/5 xl:w-1/2 lg:p-40 rounded px-2 md:px-8 pt-6 pb-8 mb-4 flex flex-col">
                <form method="post">
                    <div class="mb-12 text-4xl lg:text-4xl xl:text-6xl text-gris text-center">
                        <h1>Vous êtes de retour !</h1>
                    </div>
                    <c:if test="${sessionScope.userExist == false}">
                        <label class="text-violet mb-20">Ce compte n'existe pas !</label>
                    </c:if>
                    <div class="mb-10 md:mb-6">
                        <label class="block text-grey-darker font-bold mb-1 text-xl lg:text-xl text-gris" for="email">
                            E-mail
                        </label>
                        <input class="shadow appearance-none text-gris focus:text-violet border-solid border border-gris text-xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker" id="email" name="email" type="text" required>
                    </div>
                    <div class="mb-10 md:mb-6">
                        <label class="block text-grey-darker text-xl lg:text-xl font-bold mb-1 text-gris" for="mdp">
                            Mot de passe
                        </label>
                        <input class="shadow appearance-none text-gris focus:text-violet border border-gris text-xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="mdp" name="mdp" type="password" placeholder="" required>
                    </div>
                    <div class="flex items-center justify-between">
                        <button class="bg-violet hover:bg-blue-dark text-blanc text-xl lg:text-xl font-bold p-5 bordures-arrondies w-full" type="submit">
                            Se connecter
                        </button>
                    </div>
                    <p class="text-xl lg:text-lg">
                        Vous ne possédez pas de compte ? <a class="text-violet" href="#">créer un compte</a>
                    </p>
                </form>
            </div>
        </div>
    </body>
</html>
