/**
 * 
 */
 const frm = document.getElementById("frm");
 const up = document.getElementById("up");
 const dele = document.getElementById("del");
 const create = document.getElementById("create");
 const more = document.getElementById("more")
 const replyList = document.getElementById("replyList");
 const replyAdd = document.getElementById("replyAdd");
 const replyUpdateButton = document.getElementById("replyUpdateButton");

getReplyList(1, up.getAttribute("data-product-num"));
// then -> 응답 받는용도
//modal 수정 버튼 (jsp에 뿌려져있기때문에 이벤트 위임이 필요가 없음)
replyUpdateButton.addEventListener("click",()=>{
	let replyUpdateForm = document.getElementById("replyUpdateForm");
	let FormDatax = new FormData(replyUpdateForm);
	fetch("../reply/update",{
		method:"POST",
		body:FormDatax
	}).then(r=> r.json())
	.then(r=> {
		alert(r)
		if(r>0){ // 0과 비교하는건 결과값이 0,1로 옴 
			//replyContens와 num을 꺼내오는 작업
			//td의 Id를 가져와서 내용을 수정
			let  i ="replyContents"+document.getElementById("replyUpdateNum").value
			i= document.getElementById(i);
			i.innerHTML = document.getElementById("replyUpdateContents").value
		}else{
			alert('수정 실패')
		}
		// form데이터를 비워주는 역할
		replyUpdateForm.reset();
		//버튼을 눌렀을때 강제로 버튼을 클릭하게 하는 이벤트
		document.getElementById("replyCloseButton").click();
		
	})
})


//수정 버튼(자바스크립트방식) [이벤트 위임]
replyList.addEventListener("click",(e)=>{
	if(e.target.classList.contains("update")){
		// modal textarea
		const replyUpdateContents = document.getElementById("replyUpdateContents");
		
		// td의 id생성
		let i ='replyContents'+e.target.getAttribute("data-replyNum");

		//해당 id의 td element가져옴
		const r = document.getElementById(i)
		alert(r.innerHTML);

		//modal 창에 contenst값을 넣어줌 innertext상관없
		replyUpdateContents.value=r.innerHTML;

		// Contenst를 modal에 넘겨주는 역할
		// input value값에 replyNum이 넣어져있는거 element에서 확인 가능
		document.getElementById("replyUpdateNum").value=e.target.getAttribute("data-replyNum");

		// td의 다음 형재의 내용 (contents-> replyWriter)
		 document.getElementById("replyWriter").value=r.nextSibling.innerHTML;
	}
})





//삭제 버튼 (제이쿼리)
$("#replyList").on("click", ".del", function(){
	let n = $(this).attr("data-replyNum")
	console.log("replyNum : ", n)

	
	fetch("../reply/delete",{
		method:"post",
		headers : {"Content-type": 'application/x-www-form-urlencoded;charset=utf-8'},
		body:"replyNum="+n+"&productNum="+ up.getAttribute("data-product-num")
	})
	.then(r=>r.json())
	.then(r=>{
		replyList.innerHTML="";
		makeList(r);
	})
})


//더보기 
more.addEventListener("click", ()=>{
	let p = more.getAttribute("data-replyList-page");//현재 페이지 번호
	let a = more.getAttribute("data-replyList-totalPage");//전체 페이지 번호
	
	if(p>a){
		alert('마지막 페이지 입니다');
	}
	
	getReplyList(p, up.getAttribute("data-product-num"))
})

// list 가져 오는 함수
function getReplyList(page, num){
	fetch("../reply/list?page="+page+"&productNum="+num, {
		method:"GET"
	})
	.then(r => r.json())
	.then(r => {
		makeList(r);
	})
	;

}

function makeList(r){
	more.setAttribute("data-replyList-page", r.pager.page*1+1);
	more.setAttribute("data-replyList-totalPage", r.pager.totalPage);
	let userName = replyList.getAttribute("data-user");
	r=r.datas;
	for(let i=0;i<r.length;i++){
		let tr = document.createElement("tr");

		let td = document.createElement("td");
		// contestns만들때 id넣기
		td.setAttribute("id", "replyContents"+r[i].replyNum)
		td.innerHTML=r[i].replyContents;
		tr.append(td);

		td = document.createElement("td");
		td.innerHTML=r[i].userName;
		tr.append(td);

		td = document.createElement("td");
		let d = new Date(r[i].replyDate);
		td.innerHTML=d.getFullYear()+"."+(d.getMonth()+1)+"."+d.getDate();
		tr.append(td);

		if(userName == r[i].userName){
			td = document.createElement("td");
			let b = document.createElement("button")
			b.innerHTML="삭제";
			b.setAttribute("class", "del")
			b.setAttribute("data-replyNum", r[i].replyNum)
			td.append(b);
			tr.append(td)

			td = document.createElement("td");
			b = document.createElement("button")
			b.innerHTML="수정";
			b.setAttribute("class", "update")
			b.setAttribute("data-replyNum", r[i].replyNum)
			b.setAttribute("data-bs-toggle", "modal");
			b.setAttribute("data-bs-target", "#replyUpdateModal");
			td.append(b);
			tr.append(td)
		}
		replyList.append(tr);
	}
}





//댓글등록
replyAdd.addEventListener("click", ()=>{
	const replyForm = document.getElementById("replyForm");
	let form = new FormData(replyForm);

	fetch("../reply/add", {
		method:"POST",
		body:form
	})
	.then(r=>r.json())
	.then(r=>{
		replyList.innerHTML="";
		makeList(r);
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