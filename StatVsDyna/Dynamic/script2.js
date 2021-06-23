function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
      x.className += " responsive";
    } else {
      x.className = "topnav";
    
    $(document).ready(function(){

        $('#menu').click(function(){
          $(this).toggleClass('fa-times');
          $('header').toggleClass('toggle');
        })
       })
    }    
}