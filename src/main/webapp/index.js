function showData() {
    $.ajax({
        type: "GET",
        url: "top_forms",
        beforeSend: function () {
            $.preloader.start();
        },
        complete: function () {
            $.preloader.stop();
        },
        success: [function (fromServer) {
            var fromServerJSON = JSON.parse(fromServer);
            if(fromServerJSON == null)
                return;

            for(var i=0;i<fromServerJSON.length;i++){
                var result = "<tr><td scope='row'>" + "<b>"+(i + 1) +"</b>"+ "</td>";
                for(var j=0;j < fromServerJSON[i].length;j++)
                    result += "<td>" + fromServerJSON[i][j] + "</td>";
                result += "</tr>";
                $("table tbody").append(result);
            }
        }],
        error: [function (e) {
            alert("Error" + e);
        }]
    });
}

function showUsersLastHour() {
    $.ajax({
        type: "GET",
        url: "users_last_hour",
        beforeSend: function () {
            $.preloader.start();
        },
        complete: function () {
            $.preloader.stop();
        },
        success: [function (fromServer) {
            var fromServerJSON = JSON.parse(fromServer);
            if(fromServerJSON == null)
                return;

            for(var i=0;i<fromServerJSON.length;i++){
                var result = "<tr><td scope='row'>" + "<b>"+(i + 1) +"</b>"+ "</td>";
                result += "<td>" + fromServerJSON[i].ssoid + "</td>";
                result += "<td>" + fromServerJSON[i].formid + "</td>";
                result += "<td>" + fromServerJSON[i].ymdh + "</td>";
                result += "</tr>";
                $("table tbody").append(result);
            }
        }],
        error: [function (e) {
            alert("Error" + e);
        }]
    });
}

function usersNotCompleted() {
    $.ajax({
        type: "GET",
        url: "users_not_completed",
        beforeSend: function () {
            $.preloader.start();
        },
        complete: function () {
            $.preloader.stop();
        },
        success: [function (fromServer) {
            var fromServerJSON = JSON.parse(fromServer);
            if(fromServerJSON == null)
                return;

            for(var i=0;i<fromServerJSON.length;i++){
                var result = "<tr> + <td scope='row'>" + "<b>"+(i + 1) +"</b>"+ "</td>";
                result += "<td>" + fromServerJSON[i].ssoid + "</td>";
                result += "<td>" + fromServerJSON[i].type + "</td>";
                result += "<td>" + fromServerJSON[i].subtype + "</td>";
                result += "</tr>";
                $("table tbody").append(result);
            }
        }],
        error: [function (e) {
            alert("Error" + e);
        }]
    });
}