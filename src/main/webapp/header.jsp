<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27/08/2020
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css" />
</head>
<body>
<script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
<div class="w-full text-gray-700 bg-white dark-mode:text-gray-200 dark-mode:bg-gray-800">
    <div x-data="{ open: false }" class="flex flex-col max-w-screen-xl px-4 mx-auto md:items-center md:justify-between md:flex-row md:px-6 lg:px-8">
        <div class="p-4 flex flex-row items-center justify-between">
            <div class="w-32 h-12">
                <img src="${pageContext.request.contextPath}/ressources/images/logo.png" alt="logo">
            </div>
            <button class="md:hidden rounded-lg focus:outline-none focus:shadow-outline" @click="open = !open">
                <svg fill="currentColor" viewBox="0 0 20 20" class="w-6 h-6">
                    <path x-show="!open" fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM9 15a1 1 0 011-1h6a1 1 0 110 2h-6a1 1 0 01-1-1z" clip-rule="evenodd"></path>
                    <path x-show="open" fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path>
                </svg>
            </button>
        </div>
        <nav :class="{'flex': open, 'hidden': !open}" class="flex-col flex-grow pb-4 md:pb-0 hidden md:flex md:justify-end md:flex-row">
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-semibold bg-transparent md:mt-0 md:ml-4 text-violet" href="#">Classe</a>
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-semibold bg-transparent md:mt-0 md:ml-4 text-violet" href="#">Matériels</a>
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-semibold bg-transparent md:mt-0 md:ml-4 text-violet" href="#">Livres</a>
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-semibold bg-transparent md:mt-0 md:ml-4 border border-solid border-violet border-1 hover:bg-violet hover:text-blanc text-violet" href="#">Déconnexion</a>
        </nav>
    </div>
</div>
</body>
</html>
