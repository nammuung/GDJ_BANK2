//js
const b1 = document.getElementById("b1");
const b2 = document.querySelector("#b2");

b1.addEventListener("click", ()=>{

});
let v = b1.innerHTML;
b1.innerHTML='test';

// b1.속성명 가져오기
b1.getAttribute("속성명");

// b1.속성명 변경하기
b1.setAttribute("속성명", "값");


//jquery
// $("선택자").action()
$("#b1").click(() => {


});

$("#b2").on("click", ()=>{

});

// 값을 넣지않으면 조회
$("#b1").html();
$("#b1").html("test");


//동적으로 변하지 않는 속성 값을 가지고 올때
$("#b1").attr("속성명");
$("#b1").attr("속성명","값");

// 동적으로 변하는 값을 가지고 올때
$("#b1").prop("속성명");
$("#b1").prop("속성명", "값");


// input vlaue 값을 가지고오는 방법
$("#b1").val("값");