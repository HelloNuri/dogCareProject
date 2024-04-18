function updateSubmitDisabled(e) {
    const uid = document.querySelector('#uid');
    const pwd = document.querySelector('#pwd');
    const submitBtn = document.querySelector("#login-form button[type='submit']")
    if (uid.value.length >= 6 && pwd.value.length >= 8) {
        submitBtn.disabled = false;
    } else {
        submitBtn.disabled = true;
    }
}

function encryptPassword(pwd) {
    return pwd
}