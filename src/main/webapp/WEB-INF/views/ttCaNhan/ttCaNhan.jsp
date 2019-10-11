<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/app/css/ttCaNhanCSS/ttCaNhanCSS.css">
</head>
<body>
    <div>
        <div>
            <form:form action="${pageContext.request.contextPath}/ttCaNhan/" modelAttribute="ttCaNhanDTO" method="post">
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

                <button name="btnThem">Thêm</button>
            </form:form>
        </div>

        <div>
            <table border="1">
                <tr>
                    <th>STT</th>
                    <th>Họ tên</th>
                    <th>Nam</th>
                    <th>Nữ</th>
                    <th>Tỉnh</th>
                    <th>Huyện</th>
                    <th>Xã</th>
                    <th>Thôn xóm</th>
                </tr>

                <c:forEach items="${lstTtCaNhanDTOs}" var="t" varStatus="i">
                    <tr>
                        <td>${i.index+1}</td>
                        <td>${t.hoTen}</td>
                        <td>${t.gioiTinh.id == 1 ? t.ngaySinh : ''}</td>
                        <td>${t.gioiTinh.id == 2 ? t.ngaySinh : ''}</td>
<%--                        <td>${t.ttTinh.ten}</td>--%>
<%--                        <td>${t.ttHuyen.ten}</td>--%>
<%--                        <td>${t.ttXa.ten}</td>--%>
<%--                        <td>${t.ttThonXom.ten}</td>--%>
                        <td>
                            <form action="${pageContext.request.contextPath}/" method="post">
                                <input type="hidden" value="${t.id}" name="txtId">
                                <button name="btnSua">Sửa</button> |
                                <button name="btnXoassss">Xóa</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>
