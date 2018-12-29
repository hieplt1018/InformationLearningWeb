//Hiển thị thông báo
var content = document.getElementById('thongBao').innerHTML;

if (content !== "") {
    swal({
        title: "From Admin",
        text: content}
    );
}



