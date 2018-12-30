/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    "use strict";

    $.ajax({
        type : "GET",
        url: contextPath + "/TimeTableServlet"
    }).done(function (responseJson) {
        console.log(responseJson);
        let timeTable = responseJson;
        let $table = $("table");
        let tuan;
        
        function showTKBTheoTuan() {
            $.each(timeTable, function (index, value) {
                let foundLyThuyet = false;
                let foundThucHanh = false;
                
                for (var i = 1; i <= value.tuanHoc.length; i++) {
                    if (i == tuan && value.tuanHoc[i - 1] == ((tuan + 10) % 10)) {

                        if (!(/\d+/).test(value.toTH)) {
                            foundLyThuyet = true;
                            $("#kip" + value.kip + "-thu" + value.thu).html(value.tenMH + "<br>Phòng: " + value.phong + " - " + value.nha);
                            $("#kip" + value.kip + "-thu" + value.thu).css("background", "cyan");
                        } else if ((/\d+/).test(value.toTH)){
                            foundThucHanh = true;
                            $("#kip" + (value.kip*2-1) + "-thu" + value.thu).html(value.tenMH + "<br>Phòng: " + value.phong + " - " + value.nha);
                            $("#kip" + (value.kip*2) + "-thu" + value.thu).html(value.tenMH + "<br>Phòng: " + value.phong + " - " + value.nha);

                            $("#kip" + (value.kip*2-1) + "-thu" + value.thu).css("background", "yellow");
                            $("#kip" + (value.kip*2) + "-thu" + value.thu).css("background", "yellow");
                        }
                    }
                }

            });
        };

        function showTableTKBTheoTuan() {
            $table.empty();
            let reshow = '<colgroup><col style="width:6%"><col style="width:15%"><col style="width:15%">'
                    + '<col style="width:15%"><col style="width:15%"><col style="width:15%">'
                    + '<col style="width:15%"></colgroup>'
                    + '<thead class="thead-dark">'
                    + '<tr><th></th><th>Thứ 2</th><th>Thứ 3</th><th>Thứ 4</th><th>Thứ 5</th><th>Thứ 6</th><th>Thứ 7</th></tr>'
                    + '</thead>'
                    + '<tbody>'
                    + '<tr id="kip1"><th>Kíp 1</th><td id="kip1-thu2"></td><td id="kip1-thu3"></td><td id="kip1-thu4"></td><td id="kip1-thu5"></td><td id="kip1-thu6"></td><td id="kip1-thu7"></td>'
                    + '<tr id="kip2"><th>Kíp 2</th><td id="kip2-thu2"></td><td id="kip2-thu3"></td><td id="kip2-thu4"></td><td id="kip2-thu5"></td><td id="kip2-thu6"></td><td id="kip2-thu7"></td>'
                    + '<tr id="kip3"><th>Kíp 3</th><td id="kip3-thu2"></td><td id="kip3-thu3"></td><td id="kip3-thu4"></td><td id="kip3-thu5"></td><td id="kip3-thu6"></td><td id="kip3-thu7"></td>'
                    + '<tr id="kip4"><th>Kíp 4</th><td id="kip4-thu2"></td><td id="kip4-thu3"></td><td id="kip4-thu4"></td><td id="kip4-thu5"></td><td id="kip4-thu6"></td><td id="kip4-thu7"></td>'
                    + '<tr id="kip5"><th>Kíp 5</th><td id="kip5-thu2"></td><td id="kip5-thu3"></td><td id="kip5-thu4"></td><td id="kip5-thu5"></td><td id="kip5-thu6"></td><td id="kip5-thu7"></td>'
                    + '<tr id="kip6"><th>Kíp 6</th><td id="kip6-thu2"></td><td id="kip6-thu3"></td><td id="kip6-thu4"></td><td id="kip6-thu5"></td><td id="kip6-thu6"></td><td id="kip6-thu7"></td>'
                    + '</tbody>';
            $table.append(reshow);
        };

        function showTKBCaNhan() {
            $table.empty();
            let reshow = '<table class="table table-bordered mt-3">'
                    + '<thead class="thead-dark fit">'
                    + '<tr><th id="maMH">Mã Môn Học</th>'
                    + '<th id="tenMH">Tên Môn Học</th>'
                    + '<th id="giangVien">Giảng Viên</th>'
                    + '<th id="maNhom">Nhóm</th>'
                    + '<th id="soTC">Số Tín Chỉ</th>'
                    + '<th id="thu">Thứ</th>'
                    + '<th id="kipbd">Kíp</th>'
                    + '<th id="sotiet">Số Tiết</th>'
                    + '<th id="phong">Phòng</th>'
                    + '<th id="toHop">Tổ Hợp</th>'
                    + '<th id="toTH">Thực Hành</th>'
                    + '<th id="tuanhoc">Tuần Học</th></tr>'
                    + '</thead>'
                    + '<tbody class="table-body">';

            $.each(timeTable, function (index, value) {
                reshow += '<tr><td class="number">' + value.maMH
                        + '</td><td>' + value.tenMH
                        + '</td><td>' + value.giangVien
                        + '</td><td class="number">' + value.maNhom
                        + '</td><td class="number">' + value.soTC
                        + '</td><td class="number">' + value.thu
                        + '</td><td class="number">' + value.kip
                        + '</td><td class="number">' + value.soTiet
                        + '</td><td class="number">' + value.phong + "-" + value.nha
                        + '</td><td class="number">' + value.toHop
                        + '</td><td class="number">' + value.toTH
                        + '</td><td class="ds-tuan">' + value.tuanHoc
                        + '</td></tr>';
            });

            reshow += '</tbody></table>';
            $table.append(reshow);
        };
        
        $('#select-menu-tkb').change(function () {
            let kieuTKB = $(this).find("option:selected").val();

            if (kieuTKB == "TKB theo tuần") {
                $('#select-menu-tuan').show();
                showTableTKBTheoTuan();
                showTKBTheoTuan();
            } else if (kieuTKB == "TKB cá nhân") {
                $('#select-menu-tuan').hide();
                showTKBCaNhan();
            }
        });

        $('#select-menu-tuan').change(function () {
            let chonTuan = $(this).find("option:selected").val();
            let numRegex = /\d+/;   // all sequential digits
            tuan = parseInt(chonTuan.match(numRegex)[0]);
            showTableTKBTheoTuan();
            showTKBTheoTuan();
        });
        
        $('td').mouseover(function () {
            let id = event.target.id;
        });
        
    });

});
