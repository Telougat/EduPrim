<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:pageAdmin>
    <jsp:body>
        <div>
            <div class="flex justify-center mt-16">
                <h1 class="uppercase text-4xl text-xl text-violet relative">
                    Liste des professeurs<br/>
                    <hr class="absolute w-full border-t border-rose bottom-0 -mb-2">
                </h1>
            </div>
            <div class="grid grid-cols-1 gap-6 xl:gap-10 mt-16 mx-12 xl:mx-24">
                <a class="w-11/12 md:w-1/2 lg:w-1/3 mx-auto text-3xl text-blanc bg-violet text-center bordures-arrondies" href="${pageContext.request.contextPath}/prof/creation">
                    +
                </a>
                <c:forEach items="${professeurs}" var="professeur">
                    <a class="w-11/12 md:w-1/2 lg:w-1/3 mx-auto" href="#">
                        <div class="text-center border border-gris bg-blanc py-6 cursor-pointer shadow" style="border-radius: 20px;">
                            <p class="text-3xl text-violet"><c:out value="${professeur.getPrenom()}"/> <c:out value="${professeur.getNom()}"/></p>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </jsp:body>
</p:pageAdmin>
