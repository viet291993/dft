<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>
<l:template title="Trang chu">
    <jsp:attribute name="content">
<div class="container">
    <h1>Chỉnh sửa danh sách thôn xóm</h1>
    <form:form action="${pageContext.request.contextPath}/dm-thonxom/update" modelAttribute="dmThonXomDTO" method="post">
        <table class="table">
            <tr>
                <td>Thôn</td>
                <td>
                    <form:input path="ten" />
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
                        <form:option disabled="true" value="" label="> Chọn Tỉnh/Thành phố"/>
                        <form:options items="${dmThonXomDTO.tinh}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>Huyện</td>
                <td>
                    <form:select path="huyen" id="quanHuyen">
                        <form:option disabled="true" value="" label="> Chọn Quận/Huyện"/>
                        <form:options items="${dmThonXomDTO.huyen}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>Xã</td>
                <td>
                    <form:select path="xa" id="phuongXa">
                        <form:option disabled="true" value="" label="> Chọn Xã/Phường"/>
                        <form:options items="${dmThonXomDTO.xa}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Trạng thái hoạt động</td>
                <td>
                    <form:radiobutton path="trangThai" value="1"/>Đang hoạt động
                    <form:radiobutton path="trangThai" value="0"/>Dừng hoạt động<br>
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
</jsp:attribute>
    <jsp:attribute name="footer">
        <script type="text/javascript" charset="utf-8">
            $("select#tinh").change(function(){
                $.getJSON(
                    "/ajax/QuanHuyen",
                    {tinhMa: $(this).val()},
                    function(data){
                        var html  = '';
                        for (var i = 0; i < data.length; i++) {
                            html += '<option value="' + data[i].ma + '">' + data[i].ten + '</option>';
                        }
                        $("select#quanHuyen").html(html);
                    });
            });

            $("select#quanHuyen").change(function(){
                $.getJSON(
                    "/ajax/PhuongXa",
                    {quanHuyenMa: $(this).val()},
                    function(data){
                        var html  = '';
                        for (var i = 0; i < data.length; i++) {
                            html += '<option value="' + data[i].id + '">' + data[i].ten + '</option>';
                        }
                        $("select#phuongXa").html(html);
                    });
            });

            $("select#phuongXa").change(function(){
                $.getJSON(
                    "/ajax/ThonXom",
                    {phuongXaMa: $(this).val()},
                    function(data){
                        var html  = '';
                        for (var i = 0; i < data.length; i++) {
                            html += '<option value="' + data[i].ma + '">' + data[i].ten + '</option>';
                        }
                        $("select#thonXom").html(html);
                    });
            });
        </script>
</jsp:attribute>
</l:template>
