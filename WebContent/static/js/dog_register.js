function gotoPreviousPage(e) {
    e.preventDefault();
    if (window.history.length > 1) {
        window.history.go(-1);
    } else {
        console.log('No previous page found.');
    }
}

function submitDogRegister(e){
	e.preventDefault();
	e.target.submit();
}
