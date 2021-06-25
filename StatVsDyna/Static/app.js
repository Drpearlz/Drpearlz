var button = document.getElementsByClassName("button")[0];
button.addEventListener("click", myfunction);
button.addEventListener("click", anotherfunction);

function myfunction(){
     console.log("this is a hit");
};
function anotherfunction(){
    alert ("You did it Peggy!");
};
