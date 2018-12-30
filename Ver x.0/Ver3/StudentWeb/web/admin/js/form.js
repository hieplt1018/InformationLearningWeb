function selectOption(s1, s2) {
    var s1 = document.getElementById(s1);
    var s2 = document.getElementById(s2);
    if (s1.value == "diem") {
        s2.innerHTML ='<div class="row">                <div class="col-25"><label for="fname">Nhập mã học kỳ</label></div>                <div class="col-75"><input type="text" name="maHK" value="20172"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Vị trí tên môn học (hàng, cột)</label></div>                <div class="col-75"><input type="text" name="vt_tenMH" value="2,3"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Vị trí số tín chỉ (hàng, cột)</label></div>                <div class="col-75"><input type="text" name="vt_soTC" value="3,3"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập mã sinh viên (cột)</label></div>                <div class="col-75"><input type="text" name="vt_maSV" value="2"><br></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập điểm chuyên cần (cột)</label></div>                <div class="col-75"><input type="text" name="vt_diemCC" value="7"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập điểm kiểm tra (cột)</label></div>                <div class="col-75"><input type="text" name="vt_diemKT" value="8"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập điểm thực hành (cột)</label></div>                <div class="col-75"><input type="text" name="vt_diemTH" value="9"></div>            </div>                        <div class="row">                <div class="col-25"><label for="fname"> Nhập điểm bài tập (cột)</label></div>                <div class="col-75"><input type="text" name="vt_diemBT" value="10"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập điểm thi (cột)</label></div>                <div class="col-75"><input type="text" name="vt_diemThi" value="11"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập điểm tổng kết (cột)</label></div>                <div class="col-75"><input type="text" name="vt_diemTK" value="12"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập điểm chữ (cột)</label></div>                <div class="col-75"><input type="text" name="vt_diemChu" value="13"></div>            </div>            <div class="row">                <div class="col-25"><label for="fname">Nhập dòng bắt đầu </label></div>                <div class="col-75"><input type="text" name="vt_dongBD" value="8">                </div>            </div><div class="row">                <div class="col-75"><input type="submit" value="Submit"></div>            </div>';
    } else if (s1.value == "thongtincanhan") {
        s2.innerHTML =
                'Nhập lớp (cột):<input type="text" name="vt_lop" value="1"><br>\n\
                    Nhập mã sinh viên (cột):<input type="text" name="vt_maSV" value="2"><br>\n\
                    Nhập họ (cột):<input type="text" name="vt_ho" value="3"><br>\n\
                    Nhập tên (cột):<input type="text" name="vt_ten" value="4"><br>\n\
                    Nhập ngày sinh (cột):<input type="text" name="vt_ngaysinh" value="5"><br>\n\
                    Nhập dòng bắt đầu:<input type="text" name="vt_dongBD" value="6"><br><div class="row">                <div class="col-75"><input type="submit" value="Submit"></div>            </div>';
    } else if (s1.value == "tkb") {
        s2.innerHTML =
                'Nhập mã học kỳ:<input type="text" name="maHK" value="20172"><br>\n\
                    Nhập mã môn học (cột):<input type="text" name="vt_maMH" value="1"><br>\n\
                    Nhập tên môn học (cột):<input type="text" name="vt_tenMH" value="2"><br>\n\
                    Nhập mã nhóm (cột):<input type="text" name="vt_maNhom" value="4"><br>\n\
                    Nhập tổ hợp (cột):<input type="text" name="vt_toHop" value="5"><br>\n\
                    Nhập tổ thực hành (cột):<input type="text" name="vt_toTH" value="6"><br>\n\
                    Nhập thứ (cột):<input type="text" name="vt_thu" value="10"><br>\n\
                    Nhập tiết bắt đầu (cột):<input type="text" name="vt_tietBD" value="11"><br>\n\
                    Nhập số tiết (cột):<input type="text" name="vt_soTiet" value="12"><br>\n\
                    Nhập kíp (cột):<input type="text" name="vt_kip" value="13"><br>\n\
                    Nhập phòng (cột):<input type="text" name="vt_phong" value="15"><br>\n\
                    Nhập nhà (cột):<input type="text" name="vt_nha" value="16"><br>\n\
                    Nhập tuần học (cột):<input type="text" name="vt_tuanHoc" value="17"><br>\n\
                    Nhập giảng viên (cột):<input type="text" name="vt_giangVien" value="39"><br>\n\
                    Nhập dòng bắt đầu:<input type="text" name="vt_dongBD" value="11"><br><div class="row">                <div class="col-75"><input type="submit" value="Submit"></div>            </div>';
    } else if (s1.value == "lichthi") {
        s2.innerHTML =
                'Nhập mã học kỳ:<input type="text" name="maHK" value="20172"><br>\n\
                    Nhập ngày thi (cột):<input type="text" name="vt_ngaythi" value="0"><br>\n\
                    Nhập tiết bắt đầu (cột):<input type="text" name="vt_tietBD" value="1"><br> \n\
                    Nhập giờ bắt đầu (cột):<input type="text" name="vt_gioBD" value="2"><br>\n\
                    Nhập mã môn học (cột):<input type="text" name="vt_maMH" value="3"><br>\n\
                    Nhập mã nhóm (cột):<input type="text" name="vt_maNhom" value="4"><br>\n\
                    Nhập tổ thi (cột):<input type="text" name="vt_toThi" value="5"><br>\n\
                    Nhập tên môn học (cột):<input type="text" name="vt_tenMH" value="6"><br>\n\
                    Nhập sĩ số (cột):<input type="text" name="vt_siSo" value="7"><br>\n\
                    Nhập phòng thi (cột):<input type="text" name="vt_phongThi" value="8"><br>\n\
                    Nhập ghi chú (cột):<input type="text" name="vt_ghiChu" value="9"><br>\n\
                    Nhập giảng viên (cột):<input type="text" name="vt_giangVien" value="14"><br>\n\
                    Nhập dòng bắt đầu:<input type="text" name="vt_dongBD" value="8"><br><div class="row">                <div class="col-75"><input type="submit" value="Submit"></div>            </div>';
    } else if (s1.value == "dangkymonhoc") {
        s2.innerHTML =
                'Nhập mã học kỳ:<input type="text" name="maHK" value="20172"><br>\n\
                    Nhập mã sinh viên (cột):<input type="text" name="vt_maSV" value="1"><br>\n\
                    Nhập lớp môn học (cột):<input type="text" name="vt_lopMH" value="8"><br>\n\
                    Nhập mã môn học (cột):<input type="text" name="vt_maMH" value="10"><br>\n\
                    Nhập tên môn học (cột):<input type="text" name="vt_tenMH" value="11"><br>\n\
                    Nhập số tín chỉ (cột):<input type="text" name="vt_soTC" value="12"><br>\n\
                    Nhập dòng bắt đầu:<input type="text" name="vt_dongBD" value="6"><br><div class="row">                <div class="col-75"><input type="submit" value="Submit"></div>            </div>';
    } else {
        s2.innerHTML = "";
    }
}
