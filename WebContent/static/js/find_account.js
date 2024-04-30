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
async function findId(e){
    e.preventDefault();
    const email = document.querySelector("#id-email").value;
    const idShowBow = document.querySelector("#idShow");
    
    let url = "controller?cmd=findId&email=" + email;
    let res = await fetch(url);
    let uid = await res.text();
    console.log(uid.trim().length);
    let message = email + "님의 계정은 존재하지 않습니다.";
    if(uid != null && uid.trim().length != 0)
        message = email + "님의 아이디는 " + uid + "입니다.";
    idShowBow.innerHTML = message;
}

async function findPwd(e){
    e.preventDefault();
    const uid = document.querySelector("#pwd-id").value;
    const name = document.querySelector("#pwd-name").value;
    const email = document.querySelector("#pwd-email").value;
    const pwdShowBow = document.querySelector("#resetShow");

    let url = "controller?cmd=findPw&id="+uid+"&name="+name+"&email="+email;
    const res = await fetch(url);
    const in_data = await res.json();
    
    let message = "아이디, 이름, 이메일이 등록된 정보와 일치하지 않습니다.";
    if(in_data.result)
        message = "등록된 이메일로 초기화 메일을 전송하였습니다.";
    pwdShowBow.innerHTML = message;
}
