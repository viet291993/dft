<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa thông tin danh sách thôn xóm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Chỉnh sửa danh sách thôn xóm</h1>
    <form:form action="${pageContext.request.contextPath}/dm-thonxom/update" modelAttribute="dmThonXom" method="post">
        <table class="table">
            <tr>
                <td>Thôn</td>
                <td>
                    <form:input path="ten"/>
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
                <td>Tỉnh</td>
                <td>
                    <form:select path="tinh" id="tinh">
                        <form:option disabled="true" value="" label="Chọn Tỉnh/Thành phố"/>
                        <form:options items="${dmTinhTP_List}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>Huyện</td>
                <td>
                    <form:select path="huyen" id="huyen">
                        <form:option disabled="true" value="" label="Chọn Quận/Huyện"/>
                        <form:options items="${dmQuanHuyen_List}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>Xã</td>
                <td>
                    <form:select path="xa" id="xa">
                        <form:option disabled="true" value="" label="Chọn Quận/Huyện"/>
                        <form:options items="${dmXaPhuong_List}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Trạng thái hoạt động</td>
                <td>
                    <form:radiobutton path="trangThai" value="1"/>
                    <form:radiobutton path="trangThai" value="0"/><br>
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
