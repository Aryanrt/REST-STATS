
function init()
{
	var animation = document.getElementById("submit-container");
	animation.addEventListener("webkitAnimationEnd", animeDone);
	animation.addEventListener("animationend", animeDone);
}

function animeDone()
{
	var animation = document.getElementById("submit-container");
	if(! document.getElementById("all-teams").checked)
	{
		document.getElementsByClassName("container-contact100-form-btn")[0].style.height="9.5%";
		
		document.getElementById("teams-lable").style.visibility="visible";
		document.getElementById("teams-div").style.display="block";
	}

}

function myFunction() {
  // Get the checkbox
  document.getElementById("v2-lable").style.display="none";
  document.getElementById("v2-div1").style.display="none";
  document.getElementById("v2-div2").style.display="none";

  document.getElementById("v1-lable").style.display="flex";
  document.getElementById("v1-div").style.display="table";


  unsetHighlight(document.getElementById("d2"));
  setHighlight(document.getElementById("d1"));
  document.getElementById("signle-date").checked=true;
  document.getElementById("mutli-dates").checked= false;



} 
function myFunction2() {
  


  document.getElementById("v1-lable").style.display="none";
  document.getElementById("v1-div").style.display="none";

  document.getElementById("v2-lable").style.display="flex";
  document.getElementById("v2-div1").style.display="table";
  document.getElementById("v2-div2").style.display="table";



 unsetHighlight(document.getElementById("d1"));
 setHighlight(document.getElementById("d2"));
 document.getElementById("mutli-dates").checked= true;
 document.getElementById("signle-date").checked=false;
} 


function allTeams(){

	document.getElementById("all-teams").checked=true;
	var animation = document.getElementById("submit-container");
	
    document.getElementById("teams-lable").style.visibility="hidden";
 
	//document.getElementsByClassName("container-contact100-form-btn")[0].style.height="40%";
	document.getElementById("teams-div").style.display="none";
	animation.style.height="40%";

	
	

	animation.style.WebkitAnimation = "MoveUp 1s 1 ease-out forwards "; // Code for Chrome, Safari and Opera
	animation.style.animation = "MoveUp 1s 1 ease-out forwards";     // Standard syntax

	unsetHighlight(document.getElementById("div4"));
	setHighlight(document.getElementById("div3"));

}
function mutiTeams(){
	document.getElementById("mutli-teams").checked = true;

	//document.getElementById("submit-button").setAttribute("val","multi");
	

	var animation = document.getElementById("submit-container");
	animation.style.WebkitAnimation = "MoveDown 1s 1 ease-out forwards"; // Code for Chrome, Safari and Opera
	animation.style.animation = "MoveDown 1s 1 ease-out forwards";     // Standard syntax
	
	
	unsetHighlight(document.getElementById("div3"));
    setHighlight(document.getElementById("div4"));
}
	
function toDate(id)
{
	//document.getElementById(id).type="date";		
}
function selectTeam(element)
{

	if( element.getElementsByTagName("input")[0].checked )
	{
		element.style.backgroundColor = "#e6e6e6";
		element.getElementsByTagName("input")[0].checked=false;
	}
	else
	{
		//document.getElementById(id).style.backgroundColor = "#00ad5f";
		element.getElementsByTagName("input")[0].checked=true;
		
	}
	evalHightlight(element);
		
}
function showTeams(id)
{
	/*if(  document.getElementById(id).checked )
	{
		var temp = document.createElement("lable");
		temp.id = "view"+id;
		temp.textContent=document.getElementById(id).textContent;
		document.getElementById("teams").appendChild(temp);
		alert(3);
	}
	else
	{
		var children = document.getElementById("teams").children;
		for(i=0; i< children.length;i++)
		{
			if(children[i].id == "view"+id)
			{
				document.getElementById("teams").removeChild(children[i]);
				break;
			}
		}
		alert(4);
	}	*/
}
function evalHightlight(element)
{	
	
	if(element.tagName == "DIV")
	{
		
		if(element.getElementsByTagName("input")[0].value == "")
			unsetHighlight(element);
		else
			setHighlight(element); 
	}
	
	else if(element.tagName == "LABEL")
	{
		
		if(! element.getElementsByTagName("input")[0].checked)
			unsetHighlight(element);
		else
			setHighlight(element); 
	}
		
}
function setHighlight(element)
{
	element.setAttribute("val","set");	
}
function unsetHighlight(element)
{
	element.setAttribute("val","unset");	
}
function evalDate(element)
{
	var fromDate = new Date(document.getElementById("dates-from").value);
	var toDate = new Date(document.getElementById("dates-to").value);
	evalHightlight(element);
	if(fromDate  > toDate )
	{
		
		document.getElementById("v2-div1").setAttribute("val","error");
		document.getElementById("v2-div2").setAttribute("val","error");
		document.getElementById("error-msg").textContent = " Ending Day Can Not Be Before The Starting Day";
		document.getElementById("error-msg").style.visibility = "visible";
		document.getElementById("submit-button").disabled = true;
		
	}
	else if( new Date(fromDate.getTime() + 7 * 24 * 60 * 60 * 1000) < toDate)
	{
		document.getElementById("v2-div1").setAttribute("val","error");
		document.getElementById("v2-div2").setAttribute("val","error");
		document.getElementById("error-msg").textContent = " In Trial Mode, The Maximum Date Range Is 1 Week";
		document.getElementById("error-msg").style.visibility = "visible";
		document.getElementById("submit-button").disabled = true;
	}
	else
	{
		if( document.getElementById("v2-div1").getAttribute("val") == "error")
			document.getElementById("v2-div1").setAttribute("val","set");
		if( document.getElementById("v2-div2").getAttribute("val") == "error")
			document.getElementById("v2-div2").setAttribute("val","set");
		
		document.getElementById("error-msg").textContent = "";
		document.getElementById("error-msg").style.visibility = "hidden";	
		document.getElementById("submit-button").disabled = false;	
	}

}