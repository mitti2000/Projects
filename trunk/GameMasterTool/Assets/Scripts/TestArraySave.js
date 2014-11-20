#pragma strict

var playerName = new String[5];
var HP = new int[5];
var Init = new int[5];

var sort = new int[5];
var min :int =1000;
var tempMin :int = 0;
var check = true;


function OnGUI(){
	if(check){
		for (var k=0;k<sort.Length;k++){
			for (var j=0; j<playerName.Length; j++){
					if(Init[j]<min && Init[j]>tempMin){
						min=Init[j];
						sort[k]=j;
					}
				}
				tempMin = min;
				min = 1000;
			}
		}
	if(check){
		for(var x=0; x<sort.Length;x++){
			Debug.Log("Sort["+x+"]="+sort[x]);
			}
		check=false;
	}
	

	GUILayout.BeginArea(Rect(0,0,Screen.width,Screen.height));
		GUILayout.BeginVertical();
			for(var i=0; i<playerName.Length;i++){
				GUILayout.BeginHorizontal();
					GUILayout.Label(playerName[sort[i]]);
					GUILayout.Space(20);
					GUILayout.Label(HP[sort[i]].ToString());
					GUILayout.Space(20);
					GUILayout.Label(Init[sort[i]].ToString());
				GUILayout.EndHorizontal();
				}
		GUILayout.EndVertical();
	GUILayout.EndArea();
	}