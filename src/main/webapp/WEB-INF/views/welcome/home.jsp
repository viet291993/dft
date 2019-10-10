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
    <a class="navbar-brand" href="#">Quận huyện</a>
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
        <form>
            <div class="row">
                <span class="label label-default">Địa phương</span>

                <div class="col-sm">
                    <input type="text" class="form-control" id="tinhId" placeholder="Tỉnh/thành">
                </div>
                <div class="col-sm">
                    <input type="text" class="form-control" id="huyenId" placeholder="Quận/Huyện">
                </div>
                <div class="col-sm">
                    <input type="text" class="form-control" id="phuongId" placeholder="Phường/Xã">
                </div>
                <div class="col-sm">
                    <input type="text" class="form-control" id="thonId" placeholder="Thông/Xóm">
                </div>
            </div>

            <div class="col-sm" style="padding-top: 10px; text-align: center;">
                <input type="submit" value="Tìm kiếm">
            </div>
        </form>
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
