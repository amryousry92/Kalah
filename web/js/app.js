/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( ".circle" ).click(function(event) {
  console.log(event.target.id);
  
  $.ajax({
        url: "/move",
        type: "post",
        data: {id: event.target.id},
        cache: false,
        contentType: false,
        processData: false,
        success: function(data) {
            
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.responseText);
        }
    });
});