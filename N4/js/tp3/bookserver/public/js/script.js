
$("#newbook").click(function (event) {
  $.ajax({
    // The URL for the request
    url: "/books",
    // The data to send (will be converted to a query string)
    data: {
        id: 123
    },
    // Whether this is a POST/GET/UPDATE/DELETE request
    type: "GET",
    // The type of data we expect back
    dataType : "json",
    // Code to run if the request succeeds;
    // the response is passed to the function
    success: function(json) {
        $( "<h1>" ).text( json.title ).appendTo( "body" );
        $( "<div class=\"content\">").html(json.html).appendTo( "body" );
    },
    // Code to run if the request fails; the raw request and
    // status codes are passed to the function
    error: function( xhr, status, errorThrown ) {
        alert("Sorry, there was a problem!");
        console.log( "Error: " + errorThrown );
        console.log( "Status: " + status );
        console.dir( xhr );
    },
    // Code to run regardless of success or failure
    complete: function( xhr, status ) {
        alert( "The request is complete!" );
    }
  });
});
