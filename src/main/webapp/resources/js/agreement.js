console.log("agreement");

//javascript
// const checkAll = document.getElementById("chekcAll");
// let a = document.getElementsByClassName(checks);
// const checks = document.getElementsByClassName("checks");

// checkAll.addEventListener("click",()=>{
//     let v=checkAll.getAttribute("checked");
//     console.log(v);
//     v = checkAll.checked
//     var len = a.length;
//         for(var i=0; i<len; i++){
//           x[i].checks = e;
//         }
// });



 let a = document.getElementsByClassName(checks);
// // jquery
$('#checkAll').click(() => {
    let v = $("#checkAll").prop("checked");
    $('.checks').prop("checked", v);
    $('.opt').prop("checked", v);
    if(a=false){
        console.log("ㅎㅇ");
        $("#checkAll").prop("checked", false);
    }else{
        
    }
});



$('.checks').click(function(){
console.log($(this).prop('checked'))
console.log($(this).prop('opt'))


});