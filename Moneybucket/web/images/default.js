// JavaScript Document

var xmlhttp = getXmlHttp();

function openPopUpBox(){
	var url = "bookingform.htm";
	var popBox = document.getElementById("popBox");
	if(xmlhttp!=null){
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				if(xmlhttp.responseText.length >0){
					popBox.innerHTML= xmlhttp.responseText;
					popBox.style.height="auto";
					setPopUpBoxPosition();
					popBox.style.visibility = "visible";
				}
			}
		}
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
	}
}

function closePopUpBox(){
	var popBox = document.getElementById("popBox");
	popBox.style.visibility = "hidden";
	popBox.style.height= "0";
}

function setPopUpBoxPosition(){
	var popBox = document.getElementById("popBox");
	
	popBox.style.height="auto";//!important
	
	var popBoxOffsetHeight = popBox.offsetHeight;
	var visibleAreaHeight = window.innerHeight;
	var popBoxTop = (popBoxOffsetHeight >= visibleAreaHeight) ? 0 : parseInt((visibleAreaHeight-popBoxOffsetHeight)/2);
	
	var popBoxOffsetWidth = popBox.offsetWidth;
	var visibleAreaWidth = document.body.clientWidth;
	var popBoxLeft = (popBoxOffsetWidth >= visibleAreaWidth) ? 0 : parseInt((visibleAreaWidth-popBoxOffsetWidth)/2);
	popBox.style.top = popBoxTop+"px";
	popBox.style.left = popBoxLeft+"px";
}

function submitBooking(){
	var popUpHeaderText = document.getElementById("popUpHeaderText");
	var popUpBoxBodyDiv = document.getElementById("popUpBoxBodyDiv");
	var popUpBoxBtmDiv = document.getElementById("popUpBoxBtmDiv");
	
	popUpBoxBodyDiv.innerHTML = "Submitted!";
	popUpBoxBtmDiv.innerHTML = "";
	setPopUpBoxPosition();
	return false; //stop submitting form
}
function getXmlHttp(){
	var xmlhttp;
	if(window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else{// code for IE6, IE5
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttp;
}