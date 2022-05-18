$(document).ready(function () {
    var button = document.getElementById("btn");
    $("#btn").click(function () {
            sendAjaxForm('result_form', 'ajax_form');
            return false;
        }
    );
    button.addEventListener("click", makeDisabled);

    function makeDisabled() {
        button.disabled = true;
    }
});

function sendAjaxForm(result_form, ajax_form) {
    $.ajax({
        url: 'student',
        type: "POST",
        dataType: "html",
        data: $("#" + ajax_form).serialize(),
        success: function (response) {
            var result = $.parseJSON(response);
            if (result.responseId <= 0) {
                $('#result_form').html(result.message)
                    .css("color", "red")
                    .css("font-weight", "bold");
            } else {
                $('#result_form').html(result.message)
                    .css("color", "green")
                    .css("font-weight", "bold");
            }
        },
        error: function (response) {
            $('#result_form').html('Ошибка. Данные не отправлены.');
        }
    });
}