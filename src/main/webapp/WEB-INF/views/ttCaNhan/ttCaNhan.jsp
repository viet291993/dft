<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/app/css/ttCaNhanCSS/ttCaNhanCSS.css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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

                Tỉnh thành phố: <form:select path="ttTinh.id" items="${lstDmTinhs}" itemLabel="ten" itemValue="id" class="cboTinh"/>
                Quận huyện: <form:select path="ttHuyen.id" class="cboQuanHuyen"/>
                Xã phường: <form:select path="ttXa.id" class="cboXaPhuong"/>
                Thôn xóm: <form:select path="ttThonXom.id" class="cboThonXom"/>

                <br>
                <button name="btnThem">Thêm</button>
            </form:form>
<%--            <span class="errors_message">${xoaError}</span>--%>
        </div>

        <div>
            <table border="1">
                <tr>
                    <th>STT</th>
                    <th>Họ tên</th>
                    <td>Mã y tế cá nhân</td>
                    <th>Nam</th>
                    <th>Nữ</th>
                    <th>Địa chỉ</th>
                </tr>

                <c:forEach items="${lstTtCaNhanDTOs}" var="t" varStatus="i">
                    <tr>
                        <td>${i.index+1}</td>
                        <td>${t.hoTen}</td>
                        <td>${t.maYTeCaNhan}</td>
                        <td>${t.gioiTinh.id == 1 ? t.ngaySinh : ''}</td>
                        <td>${t.gioiTinh.id == 2 ? t.ngaySinh : ''}</td>
                        <td>${t.ttThonXom.tenThon} - ${t.ttXa.ten} - ${t.ttHuyen.ten} - ${t.ttTinh.ten}</td>
                        <td>
                            <form:form action="${pageContext.request.contextPath}/ttCaNhan/" method="post">
                                <input type="hidden" value="${t.id}" name="txtId">
                                <button name="btnSua">Sửa</button> |
                                <button name="btnXoa">Xóa</button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
<script src="${pageContext.request.contextPath}/resources/app/js/ttCaNhanJS/ttCaNhanJS.js"></script>
</html>
