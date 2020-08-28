<%@tag description="Body Admin Prefabrication" pageEncoding="UTF-8" %>
<div class="mt-4 md:mt-32 grid grid-cols-1 md:grid-cols-2 gap-20 mx-auto w-8/12">
    <div class="flex justify-center items-center relative">
        <img class="w-full md:w-3/4 lg:w-full" src="${pageContext.request.contextPath}/ressources/images/logo_admin.png" alt="logo">
    </div>
    <div class="flex justify-center items-center">
        <div class="w-full lg:mx-8">
            <jsp:doBody/>
        </div>
    </div>
</div>
