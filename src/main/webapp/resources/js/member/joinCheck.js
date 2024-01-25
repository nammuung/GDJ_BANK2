console.log('join check');

//js

//username
const userName = document.getElementById("userName");

//password
const password = document.getElementById("password");
const passwordResult = document.getElementById("passwordResult");
const passwordCheck = document.getElementById("passwordCheck");
const passwordCheckResult = document.getElementById("passwordCheckResult");

//name
const id = document.getElementById("name");

//phone
const phone = document.getElementById("phone");

//E-mail
const email = document.getElementById("email");

//address
const address = document.getElementById("address");

//avatar
const avatar = document.getElementById("avatar");

//btn
const joinbtn = document.getElementById("joinbtn");

//========================================================================
//user_Name  java에서 처리


//========================================================================
// name
// id.addEventListener('blur', ()=>{
//     let id1 = id.value;
//     console.log(id1);
//     if(id1.length=0){
//         alert('아이디가 입력되지 않았습니다.');
//     }
// });

$("#userName").blur(function(){
    // $.get("idCheck?userName="+$("#userName").val(), function(response){
    //  console.log(response);
    // })

    // fetch("./idCheck?userName="+$("#userName").val(),{
    //     method:"GET"
        
    // })
    // .then(response=>response.text())
    // .then(response=>console.log(response));
    //let userName=$("#userName").val();
    $.ajax({
        url:"./idCheck",
        method:"GET",
        data:{
            userName:$("#userName").val()
        },
        success:function(r){
            console.log(r)
        },
        error:function(){
            alert('error')
        }
    });
})


//========================================================================

// password 

password.addEventListener('blur', function(){
    let p = password.value;
    if(p.length>7){
        passwordResult.innerHTML='OK'
    }else {
        passwordResult.innerHTML='비번은 8글자 이상 이어야 함'
    }
     passwordCheck.value('');
     passwordCheckResult.innerHTML='';
})

passwordCheck.addEventListener('keyup', function(){
    if(passwordCheck.value==password.value){
        passwordCheckResult.innerHTML='일치 한다'
    }else {
        passwordCheckResult.innerHTML='일치 하지 않는다'
    }
});

joinbtn.addEventListener('click', ()=>{
    if (passwordCheck.value==password.value){
        alert('같음');
    }else{
        alert('다름');
    }
});
//================================================================


//================================================================
//phone
phone.addEventListener('blur', ()=>{
    if(phone.length<0){
        alert('전화번호가 입력 되지 않았습니다.');
    }
});

//================================================================
//email
email.addEventListener('blur', ()=>{
    if(email.length<0){
        alert('이메일이 입력 되지 않았습니다.');
    }
});

//================================================================
//address
address.addEventListener('blur', ()=>{
    if(address.length<0){
        alert('주소가 입력 되지 않았습니다.');
    }
});


//================================================================

/// jquery
// $('#password').blur(function(){
//     if($('#password').val().length>7){
//         $('#passwordResult').html('OK');
//     }else {
//         $('#passwordResult').html('비번은 8글자 이상 이어야 함');
//     }
//     // 
//     $('#passwordCheck').val('');
//     $('#passwordCheckResult').html('');
// });

// $('#passwordCheck').keyup(function(){
//     if($('#passwordCheck').val()==$('#password').val()){
//         $('#passwordCheckResult').html('일치 한다')
//     }else {
//         $('#passwordCheckResult').html('일치하지 않는다')
//     }

// });

// 	$('#joinbtn').click(()=>{
//         console.log('gd');
//         if($('#passwordCheck').val()==$('#password').val()){
// 		alert('일치한다');
// 	}else{
// 	alert('일치하지 않는다.');
// 	}
// 	});

