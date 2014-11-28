#pragma strict


//Character editor
var selectedCharacter :int = 1;
var tempName : String;
var tempHP : String;
var tempInitiative : String;
var tempNPC : boolean;

//List sorting
var charSort = new int[1];
var minValue :int =1000;
var tempMin :int = 1;
var sortExist : boolean = false;
var iniCount : int;
var sortDiff : int;
var tempMinChar : int = 0;

//PlayerPrefsX
var playerNames = new String[1];
var initiative = new int[1];




function Start () {
	//Set Player 0
	playerNames[0] = "empty";
	initiative[0]=0;
	
	//Set Player 1 called "Name"
	System.Array.Resize.<String>(playerNames,playerNames.length+2);
	System.Array.Resize.<int>(initiative,initiative.length+2);
	System.Array.Resize.<int>(charSort,charSort.length+2);
	playerNames[1] = "Gilliath";
	initiative[1] = 5;
	
	playerNames[2] = "Balbarosch";
	initiative[2] = 3;
		
	}

function OnGUI (){

//	CharSort();
	
	
	GUILayout.BeginArea(Rect(10,20,Screen.width, Screen.height*0.4));
				GUILayout.BeginVertical();
					GUILayout.Space(10);
						GUILayout.BeginHorizontal();
							GUILayout.Space(Screen.width*0.05);
							GUILayout.Label("charSort[i]", GUILayout.Width(Screen.width*0.4));
							GUILayout.Label("Name", GUILayout.Width(Screen.width*0.4));
							GUILayout.Label("Init", GUILayout.Width(Screen.width*0.125));
						GUILayout.EndHorizontal();
						GUILayout.Space(5);
						for(var i=playerNames.Length-1;i>0;i--){
							if(initiative[charSort[i]]>0){
								GUILayout.BeginHorizontal();
									GUILayout.Space(Screen.width*0.05);
									GUILayout.Label(""+charSort[i],GUILayout.Width(Screen.width*0.4));
									GUILayout.Label(playerNames[charSort[i]],GUILayout.Width(Screen.width*0.4));
									GUILayout.Label(initiative[charSort[i]].ToString(), GUILayout.Width(Screen.width*0.125));
								GUILayout.EndHorizontal();
								GUILayout.Space(10);
								}
							}
					GUILayout.Space(20);
				GUILayout.EndVertical();
			GUILayout.EndArea();
			
			//Fight Character Editor
			GUILayout.BeginArea(Rect(10,Screen.height*0.4+20,Screen.width, Screen.height*0.4));
				//Character Selection Left/Right
				GUILayout.BeginHorizontal();
					GUILayout.Space(20);
					if (selectedCharacter>1){if(GUILayout.Button("<--",GUILayout.Width(Screen.width*0.05))) selectedCharacter--;}
					else GUILayout.Button("<--", GUILayout.Width(Screen.width*0.05));
					if(selectedCharacter < playerNames.Length-1){if(GUILayout.Button("-->", GUILayout.Width(Screen.width*0.05))) selectedCharacter++;}
					else GUILayout.Button("-->", GUILayout.Width(Screen.width*0.05));
					GUILayout.Label(playerNames[selectedCharacter], GUILayout.Width(Screen.width*0.4));
				GUILayout.EndHorizontal();
				
				//Character Editor
				GUILayout.BeginVertical();
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("Name:", GUILayout.Width(Screen.width*0.2));
						playerNames[selectedCharacter] = GUILayout.TextField(playerNames[selectedCharacter]);
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(20);
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("Initiative:", GUILayout.Width(Screen.width*0.2));
						if(initiative[selectedCharacter]==0) GUILayout.Label("-", GUILayout.Width(Screen.width*0.2));
						else GUILayout.Label(initiative[selectedCharacter].ToString(), GUILayout.Width(Screen.width*0.2));
						GUILayout.Space(Screen.width*0.02);
						if(initiative[selectedCharacter]<1) GUILayout.Button("", GUILayout.Width(Screen.width*0.05));
					  	else {if(GUILayout.Button("", GUILayout.Width(Screen.width*0.05))){ 
					  			initiative[selectedCharacter]--;
					  			CharSort();
					  			}
					  		}
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("", GUILayout.Width(Screen.width*0.05))) {
					  		initiative[selectedCharacter]++;
					  		CharSort();
					  		}
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("reset")) initiative[selectedCharacter]=0;
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(20);
					GUILayout.BeginHorizontal();
						GUILayout.FlexibleSpace();
						if(GUILayout.Button("Neu")) AddNewCharacter();
						GUILayout.Space(Screen.width*0.1);
						if(GUILayout.Button("SortList")) CharSort();
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
				GUILayout.EndVertical();
			GUILayout.EndArea();
	
	}


//Add new Character
function AddNewCharacter(){
	System.Array.Resize.<int>(charSort,charSort.length+1);
	System.Array.Resize.<String>(playerNames,playerNames.length+1);
	playerNames[playerNames.Length-1] = "Name";
	System.Array.Resize.<int>(initiative,initiative.length+1);
	initiative[playerNames.Length-1] = 0;
	selectedCharacter = playerNames.Length-1;
	CharSort();
	}

	
function CharSort(){
	for(var x=0;x<charSort.Length;x++) charSort[x]=0;
	
	for (var k=1;k<charSort.Length;k++){
		for (var j=1; j<playerNames.Length; j++){
			if(initiative[j]<=minValue && initiative[j]>=tempMin){
				for(var l=1;l<charSort.Length;l++){
					if(charSort[l]==j){
						sortExist=true;
						}
					else if(charSort[l]!=j && !sortExist){
						sortExist=false;
						}
					}
				if(!sortExist){
					minValue=initiative[j];
					tempMinChar=j;
					}
				sortExist=false;
				}
			}
		if(minValue<1000)tempMin=minValue;
		minValue=1000;
		if(tempMinChar>0)charSort[k]=tempMinChar;
		tempMinChar=0;
		}
	tempMinChar=0;
	tempMin=1;
	}		

	
	
	
	