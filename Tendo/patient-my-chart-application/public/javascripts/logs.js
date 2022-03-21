$(document).ready(function () {

    $(document).on('click', '[id^="roll-"]', function(event) {
        $('#log_content').attr('src', "/logs/"+this.id);
    });
    $('.glyphicon-file').click(function(){
        $(this).css("color","blue");
        $('.glyphicon-file').not(this).each(function(){
            $(this).css("color","black");
         });
    })
});