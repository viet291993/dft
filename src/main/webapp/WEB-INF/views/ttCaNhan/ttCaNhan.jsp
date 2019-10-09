<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin cá nhân</title>
</head>
<body>
    <div>
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

                <c:forEach items="${lstTtCaNhan}" var="t" varStatus="i">
                    <tr>
                        <td>${i.index+1}</td>
                        <td>${t.hoTen}</td>
                        <td>${t.gioiTinh.ten}</td>
<%--                        <td>${t.gioiTinh.id == 1 ? t.ngaySinh : ''}</td>--%>
<%--                        <td>${t.gioiTinh.id == 2 ? '' : t.ngaySinh}</td>--%>
<%--                        <td>${t.ttTinh.ten}</td>--%>
<%--                        <td>${t.ttHuyen.ten}</td>--%>
<%--                        <td>${t.ttXa.ten}</td>--%>
<%--                        <td>${t.ttThonXom.ten}</td>--%>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>
