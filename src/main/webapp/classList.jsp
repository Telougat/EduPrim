<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28/08/2020
  Time: 00:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Classe</title>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ressources/css/style.css"/>
</head>
<body>
    <div class="flex items-center justify-center w-full p-2 m-2">
                        <span class="w-3/5 flex items-center justify-center border-b-2 border-rose border-opacity-50 pb-3">
                            <h1 class="text-3xl text-violet font-bold tracking-widest">CLASSE ${ name }</h1>
                        </span>
    </div>
    <div class="flex bg-blanc shadow-2xl rounded-lg mx-4 md:mx-auto my-56 w-4/5 border border-gris border-1 pr-4 pl-4">
        <div class="flex items-start px-4 py-6 w-full ml-2">
            <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad alias asperiores doloribus exercitationem
                impedit ipsam quo quod sit voluptas. Adipisci eos reprehenderit suscipit ullam. Consequuntur ea est iste
                non voluptate.
            </div>
        </div>
    </div>
</body>
</html>
