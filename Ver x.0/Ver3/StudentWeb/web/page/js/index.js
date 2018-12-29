//Hiển thị thông báo
var content = document.getElementById('thongBao').innerHTML;
if (content !== "Chúc bạn một ngày tốt lành!" && content !== "") {
    swal({
        title: "Lịch Thi",
        text: content}
    );
}


//Đăng ký nhận tin 

