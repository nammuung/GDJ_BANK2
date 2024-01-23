<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Account Add</title>
    <!-- 사용전 경로를 꼭 수정 하세요 -->
	<c:import url="../temps/head_css.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정 하세요 -->
			<c:import url="../temps/header.jsp"></c:import>

            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">Get in touch</h1>
                            <p class="lead fw-normal text-muted mb-0">Let's work together!</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- * * SB Forms Contact Form * *-->
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- This form is pre-integrated with SB Forms.-->
                                <!-- To make this form functional, sign up at-->
                                <!-- https://startbootstrap.com/solution/contact-forms-->
                                <!-- to get an API token!-->
                                <form id="contactForm" action="./add" method="post" >
                                <input type="hidden" name="account" value="${accountDTO.account}"> 
                           	 <!-- <input type="hidden" name="productNum" value="${accountDTO.productNum}"> -->
                           	 <!--  <input type="hidden" name="productNum" value="${prodcutDTO.productNum}"> -->
                          	 <!--<input type="hidden" name="userName" value="${member.userName}">--> 
                                     
                                     <div class="form-floating mb-3">
                                        <input class="form-control" name="productNum" id="productNum" type="text" data-sb-validations="required" />
                                        <label for="productNum">상품번호</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">상품명은 필수 입니다.</div>
                                    </div>  
                                                                        
                                    <!-- 비밀 번호 -->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" name="accountPw" id="accountPw" type="text"  style="height: 10rem" data-sb-validations="required"></textarea>
                                        <label for="accountPw">계좌비밀번호</label>
                                        <div class="invalid-feedback" data-sb-feedback="message:required">상품내용 필수 입니다.</div>
                                    </div> 

                                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">상품등록</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>


        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정 하세요 -->
        <c:import url="../temps/footer.jsp"></c:import>

    </body>
</html>
    