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
}

function toDate(id)
{
	document.getElementById(id).type="date";		
}
function selectTeam(id)
{

	if(!  document.getElementById(id).getElementsByTagName("input")[0].checked )
		document.getElementById(id).style.backgroundColor = "#e6e6e6";
	else
		document.getElementById(id).style.backgroundColor = "#00ad5f";
	document.getElementById(id).getElementsByTagName("input")[0].click();
}


