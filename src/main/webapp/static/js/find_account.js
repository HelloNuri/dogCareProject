function selectPage(e){
    e.target.classList.add("selectPage");
    if(e.target.nextElementSibling == null)
        e.target.previousElementSibling.classList.remove("selectPage");
    else
        e.target.nextElementSibling.classList.remove("selectPage");
}