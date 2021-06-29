function validateForm() {
    var v = document.forms["myForm"]["sal"].value;
    if (v == "") {
        alert("Salutation must be filled.");
        return false;
    }

    var v = document.forms["myForm"]["fname"].value;
    var x = /^[a-zA-Z]+\s?[a-zA-Z]*\s?$/;
    var result = x.test(v);
    if(result == false){
        alert("Name must be 1 or 2 words of only alphabets.");
        return false;
    }

    var v = document.forms["myForm"]["uname"].value;
    if (v == "") {
        alert("Username must be filled.");
        return false;
    }

    var v = document.forms["myForm"]["pwd"].value;
    if(!v.match(/[a-z]/) || !v.match(/[A-Z]/) || !v.match(/[0-9]/) || !v.match(/\W|_/)){
        alert("Password must be atleast 1 lowercase, uppercase, special charecter, number.");
        return false;
    }

    v = document.forms["myForm"]["email"].value;
    var x = /^[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*@[a-zA-Z]+(.[a-zA-Z]+)+$/;
    var result = x.test(v);
    if(result == false){
        alert("Enter a proper email.");
        return false;
    }

    var v = document.forms["myForm"]["dob"].value;
    var dob = new Date(v);
    var month_diff = Date.now() - dob.getTime();
    var age_dt = new Date(month_diff);  
    var year = age_dt.getUTCFullYear();
    var age = Math.abs(year - 1970);
    if(v == null || v == ""){
        alert("Date of Birth must be filled.");
        return false;
    } else if(age > 35 || age < 18){
        alert("Age should be between 18 and 35.");
        return false;
    }

    var v = document.querySelectorAll('input[name="lang"]:checked').length;
    if(v < 2){
        alert("Atleast 2 languages must be selected.");
        return false;
    }
}

var n = document.getElementById("fname");
var h = document.getElementById("hint");

n.onfocus = function() {
    document.getElementById("hint").innerHTML = "Hint : Name must be 1 or 2 words of only alphabets";
    document.getElementById("message").style.display = "block";
    document.getElementById("FN").style.backgroundColor = "yellow";
}

n.onblur = function() {
    document.getElementById("message").style.display = "none";
    h.classList.remove("valid");
    h.classList.add("invalid");
    document.getElementById("FN").style.backgroundColor = "rgb(255, 255, 255, 0.8)";
}

n.onkeyup = function() {
    var x = /^[a-zA-Z]+\s?[a-zA-Z]*\s?$/;
    if(n.value.match(x)) {
        h.classList.remove("invalid");
        h.classList.add("valid");
    } else {
        h.classList.remove("valid");
        h.classList.add("invalid");
    }
}

var n1 = document.getElementById("pwd");

n1.onfocus = function() {
    document.getElementById("hint").innerHTML = "Hint : Password must be atleast 1 lowercase, uppercase, special charecter, number.";
    document.getElementById("message").style.display = "block";
    document.getElementById("PW").style.backgroundColor = "yellow";
}

n1.onblur = function() {
    document.getElementById("message").style.display = "none";
    h.classList.remove("valid");
    h.classList.add("invalid");
    document.getElementById("PW").style.backgroundColor = "rgb(255, 255, 255, 0.8)";
}

n1.onkeyup = function() {
    if(!n1.value.match(/[a-z]/) || !n1.value.match(/[A-Z]/) || !n1.value.match(/[0-9]/) || !n1.value.match(/\W|_/)){
        h.classList.remove("valid");
        h.classList.add("invalid");
    } else {
        h.classList.remove("invalid");
        h.classList.add("valid");
    }
}

var n2 = document.getElementById("dob");

n2.onfocus = function() {
    document.getElementById("hint").innerHTML = "Hint : Age should be between 18 and 35.";
    document.getElementById("message").style.display = "block";
}

n2.onblur = function() {
    document.getElementById("message").style.display = "none";
    h.classList.remove("valid");
    h.classList.add("invalid");
}

n2.oninput = function() {
    var v = document.forms["myForm"]["dob"].value;
    var dob = new Date(v);
    var month_diff = Date.now() - dob.getTime();
    var age_dt = new Date(month_diff);  
    var year = age_dt.getUTCFullYear();
    var age = Math.abs(year - 1970);
    if(v == null || v == "" || age > 35 || age < 18){
        h.classList.remove("valid");
        h.classList.add("invalid");
    } else {
        h.classList.remove("invalid");
        h.classList.add("valid");
    }
}