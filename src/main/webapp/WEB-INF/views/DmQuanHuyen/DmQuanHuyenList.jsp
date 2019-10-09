<%--
  Created by IntelliJ IDEA.
  User: Viet
  Date: 09/10/2019
  Time: 05:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Quận Huyện</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Mô tả</th>
            <th>Mã tỉnh</th>
            <th>Cấp</th>
            <th>Trạng thái</th>
        </tr>
        <c:forEach items="listDmQuanHuyen" var="QuanHuyen">
            <tr>
                <td>${QuanHuyen.id}</td>
                <td>${QuanHuyen.ma}</td>
                <td>${QuanHuyen.ten}</td>
                <td>${QuanHuyen.moTa}</td>
                <td>${QuanHuyen.maTinh}</td>
                <td>${QuanHuyen.cap}</td>
                <td>${QuanHuyen.trangThai}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
