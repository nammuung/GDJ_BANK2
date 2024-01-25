console.log("agreement");

//js
 const checkAll = document.getElementById("checkAll");
 const checks = document.getElementsByClassName("checks");
 const del = document.getElementById("del");

// //jquery
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




$('#del').click(()=>{
    let nums = [];
    let checkElement=[];
    $('.checks').each(function(idx, item) { 
      if($(item).prop("checked")){
      nums.push($(item).val());
      checkElement.push(item);
      }
    });

    if( nums.length < 1 ){
      alert("리스트를 선택해주시기 바랍니다.");
      return;
    }

    console.log(nums);
    $.ajax({
        method:"post",
        url:"./delete",
        traditional:true,
        data:{
            productNum:nums,
        },
        success :function(result){
            if(result.trim()>0){
                //1. 현재 페이지를 리로드 하는 방법
                //location.reload();

                //2. Element들 삭제
                console.log(checkElement)
                
                //parents(checkElement).remove();
                
                //console.log($(".checks").parents(checkElement))
                $(".checks").parent().parent().parent(checkElement).remove()

                // 
            }
        },
        error   :function(result){
            alert('에러 발생');
        }
    })

    
});