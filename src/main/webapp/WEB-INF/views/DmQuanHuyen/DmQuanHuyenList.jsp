<%--
  Created by IntelliJ IDEA.
  User: Viet
  Date: 09/10/2019
  Time: 05:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:template title="Danh sách Quận Huyện">
    <jsp:attribute name="content">
        <form method="get" action="/QuanHuyen">
            <input type="text" name="keyword" value="${param.keyword}" />
            <button>Tìm kiếm</button>
        </form>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <th>ID</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Mô tả</th>
                <th>Mã tỉnh</th>
                <th>Cấp</th>
                <th>Trạng thái</th>
                <th></th>
            </thead>
            <tbody>
            <c:forEach items="${listDmQuanHuyen}" var="QH">
            <tr>
                <td>${QH.id}</td>
                <td>${QH.ma}</td>
                <td>${QH.ten}</td>
                <td>${QH.moTa}</td>
                <td>${QH.maTinh}</td>
                <td>${QH.cap}</td>
                <td>${QH.trangThai}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/QuanHuyen/Sua/${QH.id}">Sửa</a>
                    <a href="${pageContext.request.contextPath}/QuanHuyen/Xoa/${QH.id}">Xóa</a>
                </td>
            </tr>
        </c:forEach>
            </tbody>
        </table>
    </jsp:attribute>
</l:template>

