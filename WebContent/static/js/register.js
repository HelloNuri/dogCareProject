function validatePassword() {
    const pwd = document.querySelector("#pwd");
    const pwdConfirm = document.querySelector("#pwdConfirm");
    if (isStrongPassword(pwd.value)) {
        pwd.setCustomValidity('');
    } else{
        pwd.setCustomValidity("비밀번호는 대소문자, 숫자, 특수문자 포함 8자 이상이여야 합니다!");
    }
    if (pwd.value != pwdConfirm.value) { // 만일 두 인풋 필드값이 같지 않을 경우
        // setCustomValidity의 값을 지정해 무조건 경고 표시가 나게 하고
        pwdConfirm.setCustomValidity("비밀번호가 일치하지 않습니다!");
    } else { // 만일 두 인풋 필드값이 같을 경우
        // 오류가 없으면 메시지를 빈 문자열로 설정해야한다. 오류 메시지가 비어 있지 않은 한 양식은 유효성 검사를 통과하지 않고 제출되지 않는다.
        // 따라서 빈값을 주어 submit 처리되게 한다
        pwdConfirm.setCustomValidity('');
    }
}

function isStrongPassword(pwd) {
    return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&-])[A-Za-z\d@$!%*#?&-]{8,}$/.test(pwd);
}

function isOnlyNumberAndEnglish(str) {
    return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);
}

function isValidIdLength(uid) {
    return uid.length >= 4 && uid.length <= 12
}

function isEqualPassword(password1, password2) {
    return password1 === password2;
}

function validateId(){
    const uid = document.querySelector("#uid");
    if(uid.value.length >= 6 && onlyNumberAndEnglish(uid.value)){
        uid.setCustomValidity("");
    }else{
        uid.setCustomValidity("아이디는 영문 및 숫자로 이루어진 6글자 이상이어야 합니다!")

    }
}

function onlyNumberAndEnglish(str) {
    return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(str);
  }

function sendValidNumber(e){
    e.preventDefault();
    return true;
}