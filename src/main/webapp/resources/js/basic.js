let btn = document.getElementById("btn");
let btn2 = document.getElementById("btn2");


let t = document.getElementById("title").value;
let c = document.getElementById("boardContents").value;
btn2.addEventListener("click",()=>{
fetch("notice/add",{
    method : "POST",
    headers:{
        "Content-type":"application/x-www-form-urlencoded"
    },
    body:"boardTitle"=+t+"&boardContents="+c
})
    .then(response => response.text())
    .then(response => console.log(response));
});



btn.addEventListener("click",()=>{
console.log("Ajax Start");
    fetch("notice/list",{
        method : "GET"
        // headers : {
        // },
    }).then((response)=>{response.text()
        .then((res)=>{
            document.getElementById("result").innerHTML=res;
        });
        });
    // response응답받을 변수 {} 객체에 담아라

    console.log("Ajax End");

})