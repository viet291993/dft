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
    <title>Danh sách: Thôn xóm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Danh sách các thôn xóm</h1>
        <div>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <th>ID</th>
                    <th>Mã thôn</th>
                    <th>Tên Thôn</th>
                    <th>Mô tả thôn</th>
                    <th>Mã tỉnh</th>
                    <th>Mã huyện</th>
                    <th>Mã xã</th>
                    <th>Trạng thái</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </thead>

                <tbody>
                <c:forEach items="${DmThonXoms}" var="DmThonXoms">
                    <tr>
                        <td>${DmThonXoms.id }</td>
                        <td>${DmThonXoms.maThon }</td>
                        <td>${DmThonXoms.tenThon }</td>
                        <td>${DmThonXoms.moTaThon }</td>
                        <td>${DmThonXoms.maTinh }</td>
                        <td>${DmThonXoms.maHuyen }</td>
                        <td>${DmThonXoms.maXa }</td>
                        <td>${DmThonXoms.trangThai}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/dm-thonxom/edit/${DmThonXoms.id }">Edit</a></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/dm-thonxom/delete/${DmThonXoms.id}"
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
