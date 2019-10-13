<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:template title="Danh mục thôn xóm">
    <jsp:attribute name="content">
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
	</jsp:attribute>
</l:template>

