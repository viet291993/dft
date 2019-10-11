<%--
  Created by IntelliJ IDEA.
  User: ndang
  Date: 10/10/2019
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo danh sách thôn xóm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Tạo danh sách thôn xóm mới</h1>
        <table class="table table-bored">
            <tr>
                <td>Chọn Tỉnh, TP</td>
                <td>

                </td>
            </tr>
            <tr>
                <td>Chọn Huyện, Quận</td>
                <td>
                    <form:select path="maTinh" itemValue="id" items="${dm}"></form:select>
                </td>
            </tr>
            <tr>
                <td>Chọn Xã, Phường</td>
                <td></td>
            </tr>
            <tr>
                <td>Thôn</td>
                <td></td>
            </tr>
            <tr>
                <td>Mô tả Thôn</td>
                <td></td>
            </tr>
            <tr>
                <td>Trạng thái hoạt động</td>
                <td></td>
            </tr>
        </table>
    </div>
</body>
</html>
