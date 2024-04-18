"use strict";

function updateSubmitDisabled(e) {
  var uid = document.querySelector('#uid');
  var pwd = document.querySelector('#pwd');
  var submitBtn = document.querySelector("#login-form button[type='submit']");

  if (uid.value.length >= 6 && pwd.value.length >= 8) {
    submitBtn.disabled = false;
  } else {
    submitBtn.disabled = true;
  }
}

function encryptPassword(pwd) {
  return pwd;
}