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
    <title>Chỉnh sửa thông tin danh sách thôn xóm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Chỉnh sửa danh sách thôn xóm</h1>
        <form:form action="${pageContext.request.contextPath}/dm-thonxom/update" modelAttribute="dmThonXom" method="post">
            <table class="table">
                <tr>
                    <td>Tên thôn</td>
                    <td>
                       <form:input path="tenThon"/>
                        <form:hidden path="id"/>
                    </td>
                </tr>
                <tr>
                    <td>Mô tả thôn</td>
                    <td>
                        <form:input path="moTaThon"/>
                    </td>
                </tr>
                <tr>
                    <td>Trạng thái hoạt động</td>
                    <td>
                        <form:input path="trangThai"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <form:button type="submit">Update</form:button>
                    </td>
                </tr>

            </table>
        </form:form>
    </div>
</body>
</html>
