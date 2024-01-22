console.log("agreement");

//js
const checkAll = document.getElementById("checkAll");
const checks = document.getElementsByClassName("checks");

checkAll.addEventListener("click", ()=>{
    let v = checkAll.getAttribute("checked");
    console.log("CHECK : ", v);
    v = checkAll.checked;
    
    for(let check of checks){
        check.checked=v;

    }

})
let checkcount = 0;
for(let c of checks){
    c.addEventListener("click", function(){
        console.log(this.checked);
        if(this.checked == false){
            checkAll.checked = false;
        }else{
            checkAll.checked = true;
        }
    })


}



//jquery
// $('#checkAll').click(()=>{
//     let v = $("#checkAll").prop("checked");
    
//     $('.checks').prop("checked", v);
// });

// $('.checks').click(function(){
//     console.log($(this).prop('checked'));
// })