function selectPage(e){
    updateSelectButton(e.target.text);
    
}
function updateSelectButton(buttonContent){
    let idSelectPageBtn = document.querySelector("#changePage>a:first-child");
    let pwdSelectPageBtn = document.querySelector("#changePage>a:last-child");
    
    if(buttonContent == idSelectPageBtn.text){
        idSelectPageBtn.classList.add("selectPage");
        pwdSelectPageBtn.classList.remove("selectPage");
    }else if(buttonContent == pwdSelectPageBtn.text){
        pwdSelectPageBtn.classList.add("selectPage");
        idSelectPageBtn.classList.remove("selectPage");
    }
}