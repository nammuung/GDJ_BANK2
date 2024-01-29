/**
 * 
 */
const frm = document.getElementById("frm");
const up = document.getElementById("up");
const dele = document.getElementById("del");
const create = document.getElementById("create");
const replyList = document.getElementById("replyList");
let more = document.getElementById("more");
//replyAdd (fetch 사용)
const replyform = document.getElementById("replyform");
let form = new FormData(replyform);
const replyAdd = document.getElementById("replyAdd");


// replyList.addEventListener("click",(e)=>{
//     if(e.target)
// })


more.addEventListener("click", ()=>{
    console.log('클릭됨');
let p = more.getAttribute("data-replyList-page") // 현재 페이지번호
let a = more.getAttribute("data-replyList-totalPage") // 전체 페이지 번호
p=p*1+1;
if(p>a){
    alert('마지막 페이지');
}
more.setAttribute("data-replyList-page", p)
fetch("../reply/list?productNum="+up.getAttribute("data-product-num")+"&page="+p, {
	method:"GET"
}).then(r=> r.text())
  .then(r=>$("#replyList").append(r))

});



// fetch("../reply/list?="+up.getAttribute("data-product-num"),{
//     method:"GET"
// }).then(r=> r.text())
// .then(r=>document.getElementById(""))

//replyAdd (Fetch 사용, JS)


// fetch("../reply/list?productNum="+up.getAttribute("data-product-num"), {
// 	method:"GET"
// }).then(r=> r.text())
//   .then(r=>document.getElementById("replyList").innerHTML=r)

  replyAdd.addEventListener("click", ()=>{
	const replyForm = document.getElementById("replyForm");
	let form = new FormData(replyForm);

	fetch("../reply/add", {
		method:"POST",
		body:form
	})
	.then(r=>r.text())
	.then(r=>{
		document.getElementById("replyList").innerHTML=r
		replyForm.reset();
	})
})



    up.addEventListener("click", function(){
        frm.submit();
    });
    
    create.addEventListener("click", function(){
        frm.setAttribute("action","../account/add");
        frm.setAttribute("method","get");
        frm.submit();
        
    });

    dele.addEventListener("click", function(){
        let result = confirm("정말 삭제하시겠습니까?");
        if(result){
        frm.setAttribute("action","./delete");
        frm.setAttribute("method","post");
        frm.submit(); 		
        }
    });

    $("#wishList").click(function(){

       let productNum = $("#up").attr("data-product-num");
       $.ajax({
           url:"../wishlist/add",
           method:"GET",
           data:{
               productNum:productNum
           },
           success:function(result){
               if(result==1){
                   let r=confirm("관심목록으로 이동");
                   if(r){
                       location.href="../wishlist/list"
                   }
               }else {
                   alert('등록 실패');
               }
               
           },
           error:function(){
               alert("관심상품 추가에 실패하였습니다");
           }
       });

   });