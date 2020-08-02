function myFunction() {
  // Get the checkbox
  document.getElementById("v2-lable").style.display="none";
  document.getElementById("v2-div1").style.display="none";
  document.getElementById("v2-div2").style.display="none";

  document.getElementById("v1-lable").style.display="block";
  document.getElementById("v1-div").style.display="block";
  document.getElementById("v1-lable").style.visibility="visible";
  document.getElementById("v1-div").style.visibility="visible";

  unsetHighlight(document.getElementById("d2"));
  setHighlight(document.getElementById("d1"));
  document.getElementById("signle-date").checked=true;



} 
function myFunction2() {
  
  document.getElementById("v1-lable").style.display="none";
  document.getElementById("v1-div").style.display="none";

  document.getElementById("v2-lable").style.display="block";
  document.getElementById("v2-div1").style.display="block";
  document.getElementById("v2-div2").style.display="block";

 unsetHighlight(document.getElementById("d1"));
 setHighlight(document.getElementById("d2"));
 document.getElementById("mutli-dates").checked= true;
} 

function teamSelector(){
  document.getElementById("teams-lable").style.display="block";
  document.getElementById("teams-div").style.display="block";
  document.getElementById("multi-teams").click;
}
function allTeams(){
  document.getElementById("all-teams").click();
  document.getElementById("teams-lable").style.visibility="hidden";
  document.getElementById("teams-div").style.visibility="hidden";
  document.getElementById("teams").textContent = "All teams";

}
function mutiTeams(){
	document.getElementById("mutli-teams").click();
	document.getElementById("teams-lable").style.visibility="visible";
	document.getElementById("teams-div").style.visibility="visible";
	document.getElementById("teams").textContent = "";
}

function toDate(id)
{
	//document.getElementById(id).type="date";		
}
function selectTeam(id)
{

	if( document.getElementById(id).getElementsByTagName("input")[0].checked )
	{
		document.getElementById(id).style.backgroundColor = "#e6e6e6";
		document.getElementById(id).getElementsByTagName("input")[0].checked=false;
	}
	else
	{
		document.getElementById(id).style.backgroundColor = "#00ad5f";
		document.getElementById(id).getElementsByTagName("input")[0].checked=true;
	}
		
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
	if(element.getElementsByTagName("input")[0].value == "")
		unsetHighlight(element);
	else
		setHighlight(element); 
	
}
function setHighlight(element)
{
	element.setAttribute("val","set");	
}
function unsetHighlight(element)
{
	element.setAttribute("val","unset");	
}

