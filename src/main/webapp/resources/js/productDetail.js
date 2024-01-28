/**
 * 
 */
 const frm = document.getElementById("frm");
 const up = document.getElementById("up");
 const dele = document.getElementById("del");
 const create = document.getElementById("create");
 const more = document.getElementById("more")
 const replyList = document.getElementById("replyList");

 replyList.addEventListener("click", (e)=>{
	
	if(e.target.getAttribute("id")=='more'){
		let p = e.target.getAttribute('data-replyList-page');
		fetch("../reply/list?productNum="+up.getAttribute("data-product-num")+"&page="+(p*1+1), {
			method:"GET"
		}).then(r=> r.text())
		  .then(r=>document.getElementById("replyList").innerHTML=r)

	}
	
 })

//replyAdd (Fetch 사용, JS)
const replyAdd = document.getElementById("replyAdd");

fetch("../reply/list?productNum="+up.getAttribute("data-product-num"), {
	method:"GET"
}).then(r=> r.text())
  .then(r=>document.getElementById("replyList").innerHTML=r)


replyAdd.addEventListener("click", ()=>{
	let replyForm = document.getElementById("replyForm");
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
		// fetch("../wishlist/add?productNum="+$("#up").attr("data-product-num"),{
		// 	method:"GET"
		// })
		// .then(response=>response.text())
		// .then(response=>{
		// 	console.log(response);
		// })
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