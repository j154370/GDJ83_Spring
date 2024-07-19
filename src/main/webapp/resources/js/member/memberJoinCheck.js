/**
 * 
 */
 
//데이터타입 변수명
// 함수 선언 (이름이 있는 명명 함수) 이름이 없는 익명함수도 있음
// function col(){return} 리턴은 있지만 리턴 타입은 없었음


    
const btn = document.getElementById("btn");
const divMouse1 = document.getElementById("divMouse1");
const divMouse2 = document.getElementById("divMouse2");

const user_id = document.getElementById("user_id");
const user_pw = document.getElementById("user_pw");
const user_pw_check = document.getElementById("user_pw_check");
const user_name = document.getElementById("user_name");
const user_phone = document.getElementById("user_phone");
const user_email = document.getElementById("user_email");
const user_address = document.getElementById("user_address");
const frm = document.getElementById("frm");
const user_pw_error = document.getElementById("password_error");
const user_pw_eqerror = document.getElementById("password_eqerror");
let flag1 = 0;
let flag2 = 0;
let flag3 = 0;

divMouse1.addEventListener("change", function(){
    if(user_pw.value != user_pw_check.value){
        user_pw_eqerror.classList ="text-danger"
        user_pw_eqerror.innerHTML = "비밀번호가 같지 않습니다.";
        user_pw_check.value = "";
        user_pw_check.focus();
    }else{
        user_pw_eqerror.classList ="text-primary"
        user_pw_eqerror.innerHTML = "비밀번호가 같습니다."
        flag3 = 1;
    }
    if(user_pw.value.length >= 6){
        user_pw_error.innerHTML = "";
    }
})

divMouse2.addEventListener("change", function(){
    if(user_pw.value != user_pw_check.value){
        user_pw_eqerror.classList ="text-danger"
        user_pw_eqerror.innerHTML = "비밀번호가 같지 않습니다.";
        user_pw_check.value = "";
        user_pw_check.focus();
    }else{
        user_pw_eqerror.classList ="text-primary"
        user_pw_eqerror.innerHTML = "비밀번호가 같습니다."
        flag3 = 1;
    }
})

btn.addEventListener("click", function(){
    if(user_id.value == "" || user_pw.value == "" || user_name.value == ""
        || user_phone.value == "" || user_email.value == "" || user_address.value == "" || user_pw_check == "" || user_pw.value.length < 6){
        if(user_id.value == "" || user_pw.value == "" || user_name.value == ""
            || user_phone.value == "" || user_email.value == "" || user_address.value == ""){
        alert('반드시 모든 정보를 기입하시오.');
        }
        if(user_pw.value.length < 6){
            user_pw_error.innerHTML = "비밀번호를 6자 이상으로 입력 하시오.";
            user_pw.focus();
        }
    }else{
        console.log("f 1 2 1");
        flag1 = 1;
        flag2 = 1;
    }

    if(flag1 == 1 && flag2 == 1 && flag3 == 1){
        console.log("123123123");
        alert('회원가입 완료.');
        frm.submit();
    }
});

