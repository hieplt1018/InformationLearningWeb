$(document).ready(function () {
    var bodyTable = $("#showdiem");
    var theadTable = $("#theadTable");
    var data;

    // load data and show General======================================================

    let readJsonFileGeneral = (hocky) => {
        $.ajax({
            url:
                    "https://raw.githubusercontent.com/hieplt1018/StudentWeb/master/CSDL/diem.json",
            dataType: "json",
            success: function (_data) {
                data = new Data(_data, hocky);
                data.showGeneral();
            }
        });
    }

    // ajax read file JSON and show Details
    let readJsonFile = (hocky) => {
        $.ajax({
            url:
                    "https://raw.githubusercontent.com/hieplt1018/WebHocTapCaNhan/master/diem.json",
            dataType: "json",
            success: function (_data) {
                data = new Data(_data, hocky);
                data.showDetails();
            }
        });
    }

    // Choose cach hien thi diem
    $("#generalMark").click(function () {
        var hocky = document.getElementById("ticket_category_clone").value;
        readJsonFileGeneral(hocky);
        $("#btnMark").html("Xem tổng quát");
    });


    // Click on Detail Mark
    $("#detailMark").click(function () {
        var season = $('#btnSeason').text();
        if (season == "KỲ 1 NĂM 3")
            hocky = "20171";
        if (season == "KỲ 2 NĂM 3")
            hocky = "20172";
        readJsonFile(hocky);
        $("#btnMark").html("Xem toàn bộ các đầu điểm");
    });

    // Click choose season
    $("#muathu2017").click(function () {
        $("#btnSeason").html("KỲ 1 NĂM 3");
        $("#btnMark").html("Xem tổng quát");
        readJsonFileGeneral("20171");
    });

    $("#muahe2017").click(function () {
        $("#btnSeason").html("KỲ 2 NĂM 3");
        $("#btnMark").html("Xem tổng quát");
        readJsonFileGeneral("20172");
    });

    //Object data
    function Data(data, _hocky) {
        this.Data = data;
        var hocky = _hocky;

        (this.showGeneral = () => {

            theadTable.empty();
            var addThead =
                    "<th>STT</th>" +
                    "<th>Mã môn</th>" +
                    "<th>Tên môn</th>" +
                    "<th>Điểm hệ 10</th>" +
                    "<th>Điểm hệ 4</th>" +
                    "<th>Điểm chữ</th>";
            theadTable.append(addThead);
            bodyTable.empty();
            var i = 0;

            $.each(this.Data, function (index, value) {
                if (value.nhhk === hocky) {
                    i++;
                    var recode =
                            "<tr><td>" +
                            i +
                            "</td><td>" +
                            value.mamh +
                            "</td><td>" +
                            value.tenmh +
                            "</td><td>" +
                            value.diemtk +
                            "</td><td>" +
                            value.diemhe4 +
                            "</td><td>" +
                            value.diemch +
                            "</td></tr>";
                    bodyTable.append(recode);
                }
            });

        }),
                (this.showDetails = () => {
                    var i = 0;
                    var addThead =
                            "<th>STT</th>" +
                            "<th>Mã môn</th>" +
                            "<th>Tên môn</th>" +
                            "<th>CC</th>" +
                            "<th>TH</th>" +
                            "<th>KT</th>" +
                            "<th>Cuối kỳ</th>" +
                            "<th>Điểm hệ 10</th>" +
                            "<th>Điểm hệ 4</th>" +
                            "<th>Điểm chữ</th>";
                    theadTable.empty();
                    theadTable.append(addThead);
                    bodyTable.empty();
                    $.each(this.Data, function (index, value) {
                        if (value.nhhk === hocky) {
                            i++;
                            var recode =
                                    "<tr><td>" +
                                    i +
                                    "</td><td>" +
                                    value.mamh +
                                    "</td><td>" +
                                    value.tenmh +
                                    "</td><td>" +
                                    value.diemcc +
                                    "</td><td>" +
                                    value.diemth +
                                    "</td><td>" +
                                    value.diemkt1 +
                                    "</td><td>" +
                                    value.diemthi +
                                    "</td><td>" +
                                    value.diemtk +
                                    "</td><td>" +
                                    value.diemhe4 +
                                    "</td><td>" +
                                    value.diemch +
                                    "</td></tr>";
                            bodyTable.append(recode);
                        }
                    });
                });
    }
});
