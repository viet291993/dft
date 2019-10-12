<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:template title="Danh mục xã phường">
    <jsp:attribute name="content">
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
	</jsp:attribute>
</l:template>

