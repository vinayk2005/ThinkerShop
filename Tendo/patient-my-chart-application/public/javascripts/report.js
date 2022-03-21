var i = 0;
var selected_card ="";
var selected_managed_product_cid = "";
var provider_list = new Map();
var selected_provider_list = new Map();
var selected_provider_id=""	
var timeUpdate;
var is_taxonomy_selected=false;
var current_page = 1;
let num_of_pages = 0;



$(document).ready(function () {

  $('#divq1').css('display','none');
  $('#divq2').css('display','none');
  $('#divq3').css('display','none');
  $('#page').css('display','none');
  $("#alert_success_feedback").hide();
  
  $('#q3').val("");
  $('#start').on('click',function(event){
    $('#divq1').css('display','block');
  });

  $('#login-sumbit').on('click',function(event){
    $('#login').css('display','none');
    $('#page').css('display','block');
    

  });

  $('input[name=q1]:radio').on('change', function() {
    submitQuestionnaireFeedback(1,$('input[name=q1]:radio:checked').val(),1);
    
    $('#divq2').css('display','block');  

    
  });

  $('input[name=q2]:radio').on('change', function() {
    submitQuestionnaireFeedback(2,$('input[name=q2]:radio:checked').val(),1);
    $('#divq3').css('display','block');  
    
  });

  $('#submit').on('click', function(event){
    submitQuestionnaireFeedback(3,$('#q3').val(),1);

    var html = "Thanks again! Here’s what we heard: <br> <ul>" +
    "<li> On a scale of 1-10, would you recommend Dr. Careful to a friend or family member?  -  <strong>" + $('input[name=q1]:radio:checked').val() + "</strong> </li>" +
    "<li> Did Dr. Careful explain how to manage this diagnosis in a way you could understand?  -  <strong>" + $('input[name=q2]:radio:checked').val() + "</strong> </li>" +
    "<li> Your feeling about being diagnosed with Diabetes without complications  -  <strong>" + $('#q3').val() + "</strong> </li>" +
    "</ul>";

    
    $('#feedback_details_message').append(html);
    $("#alert_success_feedback").fadeTo(5000, 300).slideUp(5500, function() {
      $("#alert_success_feedback").slideUp(100);
    });
    
  });

  function submitQuestionnaireFeedback(qId, value, apptId){
   
    var url = "/patient-appt-feedback?patientAppointmentId="+apptId +"&questionnairId="+ qId + "&value="+ value;

    
    $.ajax({
      contentType: 'application/json',
        type: 'post',
        url: url,
        dataType: 'html',
        async:true,
        success: function (data) {
        },
        error: function (data) {
          console.log('Error:', data);
        }
      });
  
  }


});
