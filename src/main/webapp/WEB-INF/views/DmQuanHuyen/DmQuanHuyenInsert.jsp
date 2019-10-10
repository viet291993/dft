<%--
  Created by IntelliJ IDEA.
  User: Viet
  Date: 09/10/2019
  Time: 05:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Quận Huyện</title>
</head>
<body>
   <h2>Thêm quận huyện</h2>
    <form:form  action="${pageContext.request.contextPath}/QuanHuyen/Them" method="post" modelAttribute="DmQuanHuyen">
       <form:label path="ma">Mã</form:label>
       <form:input path="ma"/><br>
        <form:label path="ten">Tên</form:label>
        <form:input path="ten"/><br>
        <form:label path="moTa">Mô tả</form:label>
        <form:input path="moTa"/><br>
        <form:label path="maTinh">Tỉnh</form:label>
        <form:select path="maTinh" itemValue="id" itemLabel="ten"  items="${litsTinhTP_Selects}"/><br>
        <form:label path="cap">Cấp</form:label>
        <form:input path="cap"/><br>
        <form:label path="trangThai">Trạng thái</form:label>
        <form:radiobutton path="trangThai" value="1"/>
        <form:radiobutton path="trangThai" value="0"/><br>
        <form:button>Thêm mới</form:button>
    </form:form>
</body>
</html>
