<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p:pageAdmin>
    <jsp:body>
        <div>
            <div class="grid grid-cols-1 gap-12 xl:gap-24 mt-16 mx-12 xl:mx-24">
                <a href="#" class="w-full md:w-1/2 mx-auto">
                    <div class="text-center border border-gris py-6 cursor-pointer shadow" style="border-radius: 20px;">
                        <h3 class="text-3xl text-violet">Liste des professeurs</h3>
                        <p class="text-xl text-rose">21 professeurs</p>
                    </div>
                </a>
                <a href="#" class="w-full md:w-1/2 mx-auto">
                    <div class="text-center border border-gris py-6 cursor-pointer shadow" style="border-radius: 20px;">
                        <h3 class="text-3xl text-violet">Liste des classes</h3>
                        <p class="text-xl text-rose">23 classes</p>
                    </div>
                </a>
            </div>
        </div>
    </jsp:body>
</p:pageAdmin>
