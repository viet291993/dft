<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Trang chu
    </title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar" style="background: #e6e2eb">
    <a class="navbar-brand" href="#">Trang chủ</a>
    <a class="navbar-brand" href="#">Tinh</a>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/QuanHuyen">Quận huyện</a>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/dmxaphuong">Xã phường</a>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/dm-thonxom/list">Thôn xóm</a>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/ttCaNhan/">Thông tin cá nhân</a>
    <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>

<div class="container">
    <div style="padding-top: 20px">
        <form:form action="/" method="post" modelAttribute="TtCaNhan">
            <div class="row">
                <span class="label label-default">Địa phương</span>

                <div class="col-sm">
                    <form:select path="ttTinh" id="tinh">
                        <form:option disabled="true" value="" label="-- Chọn Tỉnh/Thành phố"/>
                        <form:options items="${litsTinhTP_Selects}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </div>
                <div class="col-sm">
                    <form:select path="ttHuyen" id="quanHuyen">
                        <form:option value="" label="-- Chọn Quận huyện"/>
                        <form:options items="${listQuanHuyen_Selects}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </div>
                <div class="col-sm">
                    <form:select path="ttXa" id="phuongXa">
                        <form:option value="" label="-- Chọn Phường xã"/>
                        <form:options items="${listPhuongXa_Selects}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </div>
                <div class="col-sm">
                    <form:select path="ttThonXom" id="thonXom">
                        <form:option value="" label="-- Chọn Thôn xóm"/>
                        <form:options items="${listThonXom_Selects}" itemValue="ma" itemLabel="ten"/>
                    </form:select>
                </div>
            </div>

            <div class="col-sm" style="padding-top: 10px; text-align: center;">
                <input type="submit" value="Tìm kiếm">
            </div>
        </form:form>
        <div style="padding-top: 20px">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Handle</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Jacob</td>
                    <td>Thornton</td>
                    <td>@fat</td>
                </tr>

                </tbody>
            </table>
            <div>
            </div>
        </div>
</body>
</html>
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
                    html += '<option value="' + data[i].ma + '">' + data[i].ten + '</option>';
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

