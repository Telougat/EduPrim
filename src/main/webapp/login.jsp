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

        <style>
            img.grandbg {
                position:fixed;
                top:0;
                left:0;
                z-index:-1;
                width: 100%;
                height: 100%;
                visibility: hidden;
            }

            img.mobilebg {
                position:fixed;
                top:0;
                left:0;
                z-index:-1;
                width: 100%;
                height: 100%;
                visibility: visible;
            }

            @media only screen and (min-width: 1024px) {
                img.grandbg {
                    visibility: visible;
                }
                img.mobilebg {
                    visibility: hidden;
                }
            }

            .font_tahoma {
                font-family: Tahoma,sans-serif;
            }

            .bordures-arrondies {
                border-radius: 1.6rem;
            }
        </style>
    </head>
    <body class="h-screen overflow-hidden flex items-center">
        <img class="grandbg" src="${pageContext.request.contextPath}/ressources/images/background-test.png" alt="Background">
        <img class="mobilebg" src="${pageContext.request.contextPath}/ressources/images/background-test-mobile.png" alt="Background">
        <div class="w-full flex flex-wrap justify-center">
            <div class="mb-20 w-5/6 md:w-4/6 lg:w-1/2 lg:p-20 xl:p-40 flex items-center">
                <img class="w-full" src="${pageContext.request.contextPath}/ressources/images/logo.png" alt="logo">
            </div>
            <div class="w-4/5 lg:w-1/2 lg:p-40 rounded px-8 pt-6 pb-8 mb-4 flex flex-col">
                <div class="font_tahoma mb-20 lg:mb-12 text-6xl lg:text-4xl xl:text-6xl text-gris text-center">
                    <h1>Vous êtes de retour !</h1>
                </div>
                <div class="mb-20 lg:mb-6">
                    <label class=" font_tahomablock text-grey-darker font-bold mb-1 text-5xl lg:text-xl text-gris" for="identifiant">
                        Identifiant
                    </label>
                    <input class="font_tahoma shadow appearance-none focus:text-violet border-solid border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker" id="identifiant" type="text" placeholder="">
                </div>
                <div class="mb-20 lg:mb-6">
                    <label class="font_tahoma block text-grey-darker text-5xl lg:text-xl font-bold mb-1 text-gris" for="mdp">
                        Mot de passe
                    </label>
                    <input class="font_tahoma shadow appearance-none focus:text-violet border border-gris text-5xl lg:text-xl bordures-arrondies w-full py-4 px-4 text-grey-darker mb-3" id="mdp" type="password" placeholder="">
                </div>
                <div class="flex items-center justify-between">
                    <button class="font_tahoma bg-violet hover:bg-blue-dark text-blanc text-5xl lg:text-xl font-bold p-5 bordures-arrondies w-full" type="button">
                        Se connecter
                    </button>
                </div>
                <p class="text-3xl lg:text-lg">
                    Vous ne possédez pas de compte ? <a class="text-violet" href="#">créer un compte</a>
                </p>
            </div>
        </div>
    </body>
</html>
