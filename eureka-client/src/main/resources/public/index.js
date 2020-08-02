function myFunction() {
  // Get the checkbox
  document.getElementById("v2-lable").style.display="none";
  document.getElementById("v2-div").style.display="none";


  document.getElementById("v1-lable").style.display="block";
  document.getElementById("v1-div").style.display="block";
  document.getElementById("v1-lable").style.visibility="visible";
  document.getElementById("v1-div").style.visibility="visible";
  document.getElementById("signle-date").click();



} 
function myFunction2() {
  
  document.getElementById("v1-lable").style.display="none";
  document.getElementById("v1-div").style.display="none";

  document.getElementById("v2-lable").style.display="block";
  document.getElementById("v2-div").style.display="block";

console.log("aaaaaaaaaaaaaaaaaaaaaaaaaa");
document.getElementById("mutli-dates").click();
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
	document.getElementById(id).type="date";		
}
function selectTeam(id)
{

	if( document.getElementById(id).getElementsByTagName("input")[0].checked )
	{
		document.getElementById(id).style.backgroundColor = "#e6e6e6";
		
		var children = document.getElementById("teams").children;
		for(i=0; i< children.length;i++)
		{
			if(children[i].id == "view"+id)
			{
				document.getElementById("teams").removeChild(children[i]);
				break;
			}
		}
		document.getElementById(id).getElementsByTagName("input")[0].checked=false;
	}
	else
	{
		document.getElementById(id).style.backgroundColor = "#00ad5f";

		var temp = document.createElement("lable");
		temp.id = "view"+id;
		temp.className="label-checkbox100";
		temp.style.backgroundColor="#00ad5f";
		temp.textContent=document.getElementById(id).textContent;
		document.getElementById("teams").appendChild(temp);
		document.getElementById(id).getElementsByTagName("input")[0].checked=true;
	}
		
}
function showTeams(id)
{
	if(  document.getElementById(id).checked )
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
	}	
}

