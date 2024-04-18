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