<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật thông tin các nhân</title>
</head>
<body>
    <div>
        <div>
            <form:form action="${pageContext.request.contextPath}/ttCaNhan/" modelAttribute="ttCaNhanSuaDTO" method="post">
                <form:input path="hoTen" placeholder="Họ tên"/>
                <form:errors path="hoTen" cssClass="errors_message"/>
                <br>

                <form:input path="maYTeCaNhan" placeholder="Mã y tế cá nhân"/>
                <form:errors path="maYTeCaNhan" cssClass="errors_message"/>
                <br>

                <form:input path="ngaySinh" placeholder="Ngày sinh"/>
                <form:errors path="ngaySinh" cssClass="errors_message"/>
                <br>

                <form:radiobutton path="gioiTinh.id" value="1" checked="true" name="gt"/> Nam
                <form:radiobutton path="gioiTinh.id" value="2" name="gt"/> Nữ
                <br>

                Quận huyện: <form:select path="ttHuyen.id" items="${lstDmQuanHuyens}" itemLabel="ten" itemValue="id"/>
                <%--                <form:select path="" items="${lstDmTinhs}" itemLabel="ten" itemValue="id"/>--%>
                <%--                <form:select path="" items="${lstDmThonXoms}" itemLabel="ten" itemValue="id"/>--%>

                <button name="btnCapNhat">Cập nhật</button>
                <button name="btnHuy">Hủy</button>
            </form:form>
        </div>
    </div>

</body>
</html>
