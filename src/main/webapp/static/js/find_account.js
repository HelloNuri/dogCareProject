function selectPage(e){
    updateSelectButton(e.target.text);
    
}
function updateSelectButton(buttonContent){
    const idSelectPageBtn = document.querySelector("#changePage>a:first-child");
    const pwdSelectPageBtn = document.querySelector("#changePage>a:last-child");
    const idFindPage = document.querySelector("#findIdPage");
    const pwdFindPage = document.querySelector("#findPwdPage");

    if(buttonContent == idSelectPageBtn.text){
        //id 찾기 페이지
        idSelectPageBtn.classList.add("selectPage");
        pwdSelectPageBtn.classList.remove("selectPage");
        idFindPage.style.display = "grid";
        pwdFindPage.style.display = "none";
    }else if(buttonContent == pwdSelectPageBtn.text){
        //pw 찾기 페이지
        pwdSelectPageBtn.classList.add("selectPage");
        idSelectPageBtn.classList.remove("selectPage");
        idFindPage.style.display = "none";
        pwdFindPage.style.display = "grid";
    }
}
function findId(e){
    e.preventDefault();
    const email = document.querySelector("#id-email").value;
    const idShowBow = document.querySelector("#idShow");

    let uid = getUidByEmail(email);
    let message = email + "님의 계정은 존재하지 않습니다.";
    if(uid != null)
        message = email + "님의 아이디는 " + uid + "입니다.";

    idShowBow.innerHTML = message;
}

function getUidByEmail(email){
    let uid = null;
    return uid;
}

function findPwd(e){
    e.preventDefault();
    const uid = document.querySelector("#pwd-id").value;
    const name = document.querySelector("#pwd-name").value;
    const email = document.querySelector("#pwd-email").value;
    const pwdShowBow = document.querySelector("#resetShow");

    let isPwdReset = resetPwd(uid, name, email);
    let message = "아이디, 이름, 이메일이 등록된 정보와 일치하지 않습니다.";
    if(isPwdReset)
        message = "등록된 이메일로 초기화 메일을 전송하였습니다.";
    pwdShowBow.innerHTML = message;
}

function resetPwd(uid, name, email){
    let isPwdReset = false;
    return isPwdReset;
}