//Hiển thị thông báo
var content = document.getElementById('thongBao').innerHTML;

if (content !== "" && content !== "Chúc bạn một ngày tốt lành!") {
    swal({
        title: "From Admin",
        text: content}
    );
}



