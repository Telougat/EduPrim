<%@tag description="Body Admin Prefabrication" pageEncoding="UTF-8" %>

<div class="min-h-screen flex items-center">
    <div class="w-full flex flex-wrap justify-center mt-16 md:mt-0">
        <div class="mb-4 w-5/6 md:w-4/6 lg:w-2/5 xl:w-1/2 lg:p-20 xl:p-40 flex items-center">
            <img class="w-full" src="${pageContext.request.contextPath}/ressources/images/logo.png" alt="logo">
        </div>
        <div class="w-4/5 lg:w-3/5 xl:w-1/2 lg:p-40 rounded px-2 md:px-8 pt-6 pb-8 mb-4 flex flex-col">
            <jsp:doBody/>
        </div>
    </div>
</div>
