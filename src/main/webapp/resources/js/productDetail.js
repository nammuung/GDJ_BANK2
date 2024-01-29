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


getReplyList(1, up.getAttribute("data-product-num"));
//댓글 등록
//more -> 더보기 버튼
more.addEventListener("click", ()=>{
   let p = more.getAttribute("data-replyList-page");//현재 페이지 번호
   let a = more.getAttribute("data-replyList-totalPage");//전체 페이지 번호
   
   if(p>a){
       alert('마지막 페이지 입니다');
   }

   //data-product-num -> productnum을 받기위한 변수 
   getReplyList(p, up.getAttribute("data-product-num"))
})


//List 가져오는 함수
function getReplyList(page, num){
   fetch("../reply/list?page="+page+"&productNum="+num, {
       method:"GET"
   })
   .then(r => r.json())
   .then(r => {
       more.setAttribute("data-replyList-page", r.pager.page*1+1);
       more.setAttribute("data-replyList-totalPage", r.pager.totalPage);
       r=r.datas;
       // List 로 값이 넘어오기 때문에 꺼내서 사용
       for(let i=0;i<r.length;i++){
            // tr태그 생성
           let tr = document.createElement("tr");
            // td태그 생성
           let td = document.createElement("td");
            // td태그에 값 넣기
           td.innerHTML=r[i].replyContents;
           tr.append(td);

            // td태그 생성
           td = document.createElement("td");
           td.innerHTML=r[i].userName;
           tr.append(td);

            // td태그 생성
           td = document.createElement("td");
           let d = new Date(r[i].replyDate);
           // 날짜 포펫 변경
           td.innerHTML=d.getFullYear()+"."+(d.getMonth()+1)+"."+d.getDate();
           tr.append(td);
           replyList.append(tr);
       }


   })
   ;

}



// 댓글등록
//replyAdd (Fetch 사용, JS)
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
       more.setAttribute("data-replyList-page", 1);
   })
})
    // 폼 데이터 받는 용도
    up.addEventListener("click", function(){
        frm.submit();
    });
    // 수정
    create.addEventListener("click", function(){
        frm.setAttribute("action","../account/add");
        frm.setAttribute("method","get");
        frm.submit();
        
    });
    // 삭제
    dele.addEventListener("click", function(){
        let result = confirm("정말 삭제하시겠습니까?");
        if(result){
        frm.setAttribute("action","./delete");
        frm.setAttribute("method","post");
        frm.submit(); 		
        }
    });

    // 관심상품 추가
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