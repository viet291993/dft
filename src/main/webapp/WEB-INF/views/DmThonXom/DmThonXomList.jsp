
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:template title="Trang chu">
    <jsp:attribute name="content">
    <div class="container">
        <h1>Danh sách các thôn xóm</h1>
        <div>
            <table class="table table-bordered">
                <thead class="thead-dark">
                    <th>Số Thứ tự</th>
                    <th>Tên Thôn</th>
                    <th>Mô tả thôn</th>
                    <th>Tỉnh</th>
                    <th>Huyện</th>
                    <th>Xã</th>
                    <th>Trạng thái</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </thead>

                <tbody>
                <c:forEach items="${DmThonXoms}" var="thonxom">
                    <tr>
                        <td>${thonxom.id}</td>
                        <td>${thonxom.ten}</td>
                        <td>${thonxom.moTaThon}</td>
                        <td>${thonxom.tinh}</td>
                        <td>${thonxom.huyen}</td>
                        <td>${thonxom.xa}</td>
                        <td>${thonxom.trangThai}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/dm-thonxom/edit/${thonxom.id }">Edit</a></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/dm-thonxom/delete/${thonxom.id}"
                               onclick="
                                    if (!(confirm('Bạn có chắc chắn muốn xóa????')))
                                        return false ">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</jsp:attribute>
<jsp:attribute name="footer">
</jsp:attribute>
 </l:template>
