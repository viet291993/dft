<%--
  Created by IntelliJ IDEA.
  User: ndang
  Date: 10/10/2019
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách: Xã phường</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Danh sách các xã phường</h1>
    <div>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <th>Id</th>
                <th>Mã xã phường</th>
                <th>Tên</th>
                <th>Mô tả xã phường</th>
                <th>Mã tỉnh</th>
                <th>Mã huyện</th>
                <th>Cấp</th>
                <th>Trạng thái</th>
                <th>Ngày tạo</th>
                <th>Người tạo id</th>
                <th>Ngày sửa</th>
                <th>Người sửa id</th>
                <th>Edit</th>
                <th>Delete</th>
            </thead>

            <tbody>
            <c:forEach items="${listDmXaPhuong}" var="list">
                <tr>
                    <td>${list.id }</td>
                    <td>${list.ma }</td>
                    <td>${list.ten }</td>
                    <td>${list.moTa }</td>
                    <td>${list.maTinh }</td>
                    <td>${list.maHuyen }</td>
                    <td>${list.cap }</td>
                    <td>${list.trangThai}</td>
                    <td>${list.ngayTao }</td>
                    <td>${list.nguoiTaoId }</td>
                    <td>${list.ngaySua }</td>
                    <td>${list.nguoiSuaId }</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/dmxaphuong/edit/${list.id }">Edit</a></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/dm-dmxaphuong/delete/${list.id}"
                           onclick="
                                    if (!(confirm('Bạn có chắc chắn muốn xóa????')))
                                        return false ">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
