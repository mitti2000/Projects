#pragma strict

var charName = ["Test1","Test2","Test3"];
var i=1;
var j=2;
var k=3;
var istOn = true;
var result =0;

function Start(){

	}

function OnGUI(){

		GUILayout.BeginArea(Rect(0,0,Screen.width,Screen.height));
		for(var i=0;i<charName.Length;i++){
			GUILayout.BeginHorizontal();
				GUILayout.Label(charName[i]);
				GUILayout.FlexibleSpace();
				if(GUILayout.Button(""+i)) result +=i;
				GUILayout.FlexibleSpace();
			GUILayout.EndHorizontal();
			}
		GUILayout.EndArea();
		}

	