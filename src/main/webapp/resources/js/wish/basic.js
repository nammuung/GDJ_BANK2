console.log("agreement");

//js


//jquery
$('#checkAll').click(()=>{
    let v = $("#checkAll").prop("checked");
    
    $('.checks').prop("checked", v);
});

$('.checks').click(function(){
    let flag=true;
    
    $('.checks').each(function(idx, c){
        
        if(!$(c).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    $("#checkAll").prop("checked", flag);
})

$('#btn').click(function(e){
    e.preventDefault();
    
    let flag=true;

    $('.req').each(function(idx, r){
        if(!$(r).prop('checked')){
            flag=!flag;
            return false;
        }
    });

    if(flag){
        location.href="join";
    }else {
        alert('필수 약관 동의 필요');
    }


});