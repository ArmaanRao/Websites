function digitalClock(){
  var today = new Date();
  var h = today.getHours();
  var m = today.getMinutes();
  var s = today.getSeconds();
  m = checkTime(m);
  s = checkTime(s);
  document.getElementById('clock').innerHTML = "<i class='far fa-clock'></i>" + h + ":" + m + ":" + s;
}

function checkTime(i) {
  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
  return i;
}

var intervalId = window.setInterval(function(){
  digitalClock();
}, 1000);

function changeSal(){
  var status = document.getElementById("status").value;
  if(document.getElementById("female").checked == true)
  {
    if(status == "married")
    {
      document.getElementById("salutation").innerHTML = "Mrs."
    }
    else
    {
       document.getElementById("salutation").innerHTML = "Ms."
    }
   
  }
  else if(document.getElementById("male").checked == true)
  {
    document.getElementById("salutation").innerHTML = "Mr."
  }
}

function changeColor(){
  document.getElementById("age").style.backgroundColor= "#aaaaaa";
}
function addrSelect(){
  window.alert("Selected address: " + document.getElementById("address").value);
}

function revertColor(){
   document.getElementById("age").style.backgroundColor= "#f8f8f8";
}

function isLetter(c) {
  return c.toLowerCase() != c.toUpperCase();
}

function isNumber(n) { return /^-?[\d.]+(?:e-?\d+)?$/.test(n); } 

function validateName()
{
  const name = document.getElementById("name").value;
  var i;
  for (i = 0; i < name.length; i++) {
    c = name[i];
    if(!isLetter(c)){
      window.alert("Name must contain only letters.");
      document.getElementById('name').value = '';
      break;
    }
  }

}

function validateAddress()
{
  const address = document.getElementById("address").value;
  var i;
  for (i = 0; i < address.length; i++) {
    c = address[i];
    if(!isLetter(c) && !isNumber(c)){
      window.alert("Address must contain only letters and numbers.");
      document.getElementById('address').value = '';
      break;
    }
  }
}

function validateAge()
{
  const age = document.getElementById("age").value;
  var i;
  for (i = 0; i < age.length; i++) {
    c = age[i];
    if(!isNumber(c)){
      window.alert("Age must contain only numbers.");
      document.getElementById('age').value = '';
      break;
    }
  }
}

function validatePh()
{
  const ph = document.getElementById("ph").value;
  var i;
  if(ph.length!=10)
  {
    window.alert("Invalid Number.");
    return;
  }
  for (i = 0; i < ph.length; i++) {
    c = ph[i];
    if(!isNumber(c)){
      window.alert("Contact number must contain only digits.");
      document.getElementById('ph').value = '';
      break;
    }
  }
}

function dragStart(event) {
  event.dataTransfer.setData("Text", event.target.id);
}

function allowDrop(event) {
  event.preventDefault();
}

function drop(event) {
  event.preventDefault();
  var data = event.dataTransfer.getData("Text");
  event.target.value += (document.getElementById(data).innerHTML)+" ";
}

function sendData(){
  var formelements = document.getElementById("my-form").elements;
  var queryString = "?name=" + formelements.name.value + "&address=" + formelements.address.value+ "&age=" + formelements.age.value+ "&dob=" + formelements.dob.value+ "&gender=" + formelements.gender.value+ "&status=" + formelements.status.value + "&contact=" + formelements.ph.value+ "&addiction=" + formelements.addiction.value;
  console.log(queryString);
  window.open("display.html" + queryString);
}

function displayTable(){
const url_string = window.location.href;
var url = new URL(url_string);
document.getElementById("name").innerHTML = url.searchParams.get("name");
document.getElementById("address").innerHTML = url.searchParams.get("address");
document.getElementById("age").innerHTML = url.searchParams.get("age");
document.getElementById("dob").innerHTML = url.searchParams.get("dob");
document.getElementById("gender").innerHTML = url.searchParams.get("gender");
document.getElementById("status").innerHTML = url.searchParams.get("status");
document.getElementById("number").innerHTML = url.searchParams.get("contact");
document.getElementById("addiction").innerHTML = url.searchParams.get("addiction");
}