<%@tag description="Page Template without logo" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EduPrim</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/custom.css"/>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
</head>
<body>
    <c:if test="${grandbg != null && !grandbg.isEmpty()}">
        <img class="grandbg" src="${pageContext.request.contextPath}/ressources/images/${grandbg}" alt="BackgroundDesktop">
    </c:if>
    <c:if test="${smallbg != null && !smallbg.isEmpty()}">
        <img class="mobilebg" src="${pageContext.request.contextPath}/ressources/images/${smallbg}" alt="BackgroundMobile">
    </c:if>
<header id="pageheader" class="w-full text-gray-700 bg-transparent py-3">
    <div x-data="{ open: false }"  class="flex flex-col max-w-screen-xl px-4 ml-auto md:items-center md:justify-between md:flex-row md:px-6 lg:px-8">
        <div @click.away="open = false" class="p-4 flex flex-row items-end justify-end">
            <button class="md:hidden" @click="open = !open">
                <svg fill="violet" viewBox="0 0 20 20" class="w-6 h-6">
                    <path x-show="!open" fill-rule="evenodd" d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM9 15a1 1 0 011-1h6a1 1 0 110 2h-6a1 1 0 01-1-1z" clip-rule="evenodd"></path>
                    <path x-show="open" fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path>
                </svg>
            </button>
        </div>
        <nav :class="{'flex': open, 'hidden': !open}" class="flex-col flex-grow pb-4 md:pb-0 hidden md:flex md:justify-end md:flex-row">
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-bold bg-transparent md:mt-0 md:ml-4 text-violet md:border-b-2 border-violet" href="#">Classe</a>
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-bold bg-transparent md:mt-0 md:ml-4 text-violet" href="#">Matériels</a>
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-bold bg-transparent md:mt-0 md:ml-4 text-violet" href="#">Livres</a>
            <a class="uppercase tracking-widest px-4 py-2 mt-2 text-sm font-bold bg-transparent md:mt-0 md:ml-4 border border-4 border-solid border-violet  hover:bg-violet hover:text-blanc text-violet" href="#">Déconnexion</a>
        </nav>
    </div>
</header>
<div id="body">
    <jsp:doBody/>
</div>
<footer id="pagefooter">
</footer>
</body>
</html>