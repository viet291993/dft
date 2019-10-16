<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật thông tin các nhân</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/app/css/ttCaNhanCSS/ttCaNhanCSS.css">
</head>
<body>
    <div>
        <div>
            <p class="alo"></p>
        </div>
        <div>
            <form:form action="${pageContext.request.contextPath}/ttCaNhan/" modelAttribute="ttCaNhanSuaDTO" method="post">
                <form:hidden path="id" cssClass="errors_message"/>

                <form:input path="hoTen" placeholder="Họ tên"/>
                <form:errors path="hoTen" cssClass="errors_message"/>
                <br>

                <form:input path="maYTeCaNhan" placeholder="Mã y tế cá nhân"/>
                <form:errors path="maYTeCaNhan" cssClass="errors_message"/>
                <br>

                <form:input path="ngaySinh" placeholder="Ngày sinh"/>
                <form:errors path="ngaySinh" cssClass="errors_message"/>
                <br>

                <form:radiobutton path="gioiTinh.id" value="1" name="gt"/> Nam
                <form:radiobutton path="gioiTinh.id" value="2" name="gt"/> Nữ
                <br>

                Tỉnh, thành phố: <form:select path="ttTinh.id" items="${lstDmTinhs}" itemLabel="ten" itemValue="id"/>
<%--                Quận huyện: <form:select path="ttHuyen.id" class="cboQuanHuyen"/>--%>
                <%--                <form:select path="" items="${lstDmThonXoms}" itemLabel="ten" itemValue="id"/>--%>
                <br>

                <button name="btnCapNhat">Cập nhật</button>
                <button name="btnHuy">Hủy</button>
            </form:form>
        </div>
    </div>

</body>
</html>
