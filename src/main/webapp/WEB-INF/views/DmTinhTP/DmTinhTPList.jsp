<%--
  Created by IntelliJ IDEA.
  User: Thuxeko
  Date: 10/14/2019
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Tỉnh TP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
${notifi}
<table class="table table-bordered">
    <tr class="thead-dark">
        <th>ID</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Cấp</th>
        <th>Trạng thái</th>
        <th></th>
    </tr>
    <c:forEach items="${lstTinh}" var="tinh">
        <tr>
            <td>${tinh.id}</td>
            <td>${tinh.ma}</td>
            <td>${tinh.ten}</td>
            <td>${tinh.moTa}</td>
            <td>${tinh.cap}</td>
            <td>${tinh.trangThai}</td>
            <td>
                <a href="${pageContext.request.contextPath}/tinhTP/sua/${tinh.id}">Sửa</a>
                <a href="${pageContext.request.contextPath}/tinhTP/xoa/${tinh.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

