/**
 * 	Teacher's code
 */


window.onload = function(){
	setListeners();
	
}


function setListeners(){
	
document.getElementById('info').addEventListener('click', getInfo, false);	


}

function getInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status ==200){
			console.log(xhr.responseText);
			var studentInfo = JSON.parse(xhr.responseText);
			document.getElementById('userid').innerHTML = studentInfo.userId;
			document.getElementById('email').innerHTML = studentInfo.email;
			document.getElementById('firstname').innerHTML = studentInfo.firstName;
			document.getElementById('lastname').innerHTML = studentInfo.lastName;
			
		
		}
			
		}
	
	xhr.open("GET", "userinfo", true);
	xhr.send();
	
}
