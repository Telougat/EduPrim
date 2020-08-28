<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<p:page>
    <jsp:body>
        <div>
            <div class="flex justify-center mt-16">
               <h1 class="uppercase text-4xl text-xl text-violet relative">
                   Liste de vos classes<br/>
                   <hr class="absolute w-full border-t border-rose bottom-0 -mb-2">
               </h1>
            </div>
            <div class="grid grid-cols-1 md:grid-cols-3 gap-12 xl:gap-24 mt-16 mx-12 xl:mx-24">
                <c:forEach items="${classes}" var="classe">
                    <a href="?id=${classe.getID()}">
                        <div class="text-center border border-gris py-6 cursor-pointer shadow" style="border-radius: 20px;">
                            <h3 class="text-3xl text-violet"><c:out value="${classe.getNom()}"/></h3>
                            <p class="text-xl text-rose"><c:out value="${classe.count()}"/> élèves</p>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </jsp:body>
</p:page>
