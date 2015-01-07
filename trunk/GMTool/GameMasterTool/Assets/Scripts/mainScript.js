#pragma strict

//Dice Rolling
var diceResult : String;
var rollResult : int;
var lastRolls : String[];
var roll : int;

//Selection Grid
var gridSelectedButton :int = 0;
var gridStrings : String[] = ["Liste", "Kampf"];

//Character editor
var selectedCharacter :int = 1;
var tempName : String;
var tempHP : String;
var tempInitiative : String;
var tempNPC : boolean;
var scrollPositionCharacter : Vector2;

//Initiative
var activeCharacter : int;
var fight : boolean = false;
var touch : Touch;


//GUI Skins
var styleDice : GUISkin;
var styleInitiative : GUISkin;
var styleCharacter : GUISkin;
var styleToolbar : GUISkin;
var styleBox : GUIStyle;

//Screen Resolution
var defaultWidth :int  =600;
var screenRotation : int;

var guiSizeDiceResultWidth: int;
var guiSizeDiceResultHeight: int;
var guiSizeDiceWidth: int;
var guiSizeDiceHeight: int;
var guiSizeDiceBeginX :int;
var guiSizeSelectHeight :int;
var guiSizeSelectBeginY :int;
var guiSizeInitiativeHeight : int;
var guiSizeInitiativeBeginY :int;
var guiSizeCharacterHeight : int;
var guiSizeCharacterBeginY : int;

//FontSizes
var fontSizeLastRoll : int;
var fontSizeLast5Rolls : int;
var fontSizeLastRollLabel : int;
var fontSizeLast5RollsLabel : int;
var fontSizeDiceButton : int;
var fontSizeCharTitle : int;
var fontSizeCharSubtitle : int;
var fontSizeCharButton : int;
var fontSizeCharTable : int;
var fontSizeCharEditor : int;
var fontSizeToolbarButton :int;
var fontSizeInitiativeTitle :int;
var fontSizeInitiativeTable :int;
var fontSizeInitiativeButton :int;

//PlayerPrefsX


var playerNames = new String[1];
var healthPoints = new int[1];
var initiative = new int[1];
var npc = new boolean [1];


//List sorting
var charSort = new int[1];
var minValue :int =1000;
var tempMin :int = 1;
var sortExist : boolean = false;
var iniCount : int;
var sortDiff : int;
var tempMinChar : int =0;


function Start () {
	//playerNames = PlayerPrefsX.GetStringArray ("playerNames");
	//healthPoints = PlayerPrefsX.GetIntArray ("healthPoints");
	//initiative = PlayerPrefsX.GetIntArray ("initiative");
	//npc = PlayerPrefsX.GetBoolArray ("npc");
	
	
	if(PlayerPrefsX.GetStringArray ("playerNames").Length==0){
	
		Debug.Log("newPlayer");
		//Set Player 0
		playerNames[0] = "";
		healthPoints[0]=0;
		initiative[0]=0;
		npc[0]=false;
		
		//Set Player 1 called "Name"
		System.Array.Resize.<String>(playerNames,playerNames.length+1);
		System.Array.Resize.<int>(healthPoints,healthPoints.length+1);
		System.Array.Resize.<int>(initiative,initiative.length+1);
		System.Array.Resize.<boolean>(npc,npc.length+1);
		System.Array.Resize.<int>(charSort,charSort.length+1);
		
		playerNames[1] = "Name";
		healthPoints[1] = 0;
		initiative[1] = 0;
		npc[1]=false;
		}
	
	else{
	Debug.Log("loadGame");
	playerNames = PlayerPrefsX.GetStringArray ("playerNames");
	healthPoints = PlayerPrefsX.GetIntArray ("healthPoints");
	initiative = PlayerPrefsX.GetIntArray ("initiative");
	npc = PlayerPrefsX.GetBoolArray ("npc");
	charSort = PlayerPrefsX.GetIntArray ("charSort");
	}
	
		
	//Set Display Size
	guiSizeDiceResultWidth = Screen.width*0.3;
	guiSizeDiceResultHeight = Screen.height*0.25;
	guiSizeDiceWidth = Screen.width*0.63;
	guiSizeDiceHeight = Screen.height*0.20;
	guiSizeDiceBeginX = Screen.width*0.33;
	guiSizeSelectHeight = Screen.height*0.04;
	guiSizeSelectBeginY = guiSizeDiceHeight;
	guiSizeInitiativeHeight = Screen.height*0.4;
	guiSizeInitiativeBeginY = guiSizeSelectBeginY + guiSizeSelectHeight;
	guiSizeCharacterHeight = Screen.height - guiSizeDiceHeight - guiSizeSelectHeight-guiSizeInitiativeHeight;
	guiSizeCharacterBeginY = guiSizeInitiativeBeginY + guiSizeInitiativeHeight;
	
	//Set Font Sizes for Dice Area
	styleDice.customStyles[0].fontSize = Mathf.RoundToInt (fontSizeLastRoll * Screen.width / (defaultWidth * 1.0));
	styleDice.customStyles[1].fontSize = Mathf.RoundToInt (fontSizeLast5Rolls * Screen.width / (defaultWidth * 1.0));
	styleDice.customStyles[2].fontSize = Mathf.RoundToInt (fontSizeLastRollLabel * Screen.width / (defaultWidth * 1.0));
	styleDice.customStyles[3].fontSize = Mathf.RoundToInt (fontSizeLast5RollsLabel * Screen.width / (defaultWidth * 1.0));
	for (var i=4;i< styleDice.customStyles.Length;i++){
		styleDice.customStyles[i].fontSize = Mathf.RoundToInt (fontSizeDiceButton * Screen.width / (defaultWidth * 1.0));
		}
	
	//Set Font Sizes for Toolbar Area
	styleToolbar.button.fontSize= Mathf.RoundToInt (fontSizeToolbarButton * Screen.width / (defaultWidth * 1.0));
	
	
	//Set Font Sizes for Character Area
	styleCharacter.customStyles[0].fontSize= Mathf.RoundToInt (fontSizeCharTitle * Screen.width / (defaultWidth * 1.0));
	styleCharacter.customStyles[1].fontSize= Mathf.RoundToInt (fontSizeCharSubtitle * Screen.width / (defaultWidth * 1.0));
	styleCharacter.customStyles[7].fontSize= Mathf.RoundToInt (fontSizeCharButton * Screen.width / (defaultWidth * 1.0));
	styleCharacter.customStyles[3].fontSize= Mathf.RoundToInt (fontSizeCharTable * Screen.width / (defaultWidth * 1.0));
	styleCharacter.customStyles[4].fontSize= Mathf.RoundToInt (fontSizeCharEditor * Screen.width / (defaultWidth * 1.0));
	styleCharacter.customStyles[8].fontSize= Mathf.RoundToInt (fontSizeCharButton * Screen.width / (defaultWidth * 1.0));
	
	//Set Font Sizes for Initiative Table
	styleInitiative.customStyles[0].fontSize = Mathf.RoundToInt (fontSizeInitiativeTitle * Screen.width / (defaultWidth * 1.0));
	styleInitiative.customStyles[1].fontSize = Mathf.RoundToInt (fontSizeInitiativeTable * Screen.width / (defaultWidth * 1.0));
	styleInitiative.customStyles[2].fontSize = Mathf.RoundToInt (fontSizeInitiativeButton * Screen.width / (defaultWidth * 1.0));
	
	SaveData();
	
	}

function Update(){
	if(Input.touchCount>0){
		touch=Input.touches[0];
		if(touch.phase == TouchPhase.Moved){
			scrollPositionCharacter.y += touch.deltaPosition.y;
			}
		}
	if (Input.GetKeyDown(KeyCode.Escape)) {
		SaveData();
 		Application.Quit(); 
 		}
	}

function OnGUI (){
	SortList();
	InvokeRepeating("SaveData", 1, 5);
	
	//set GUI Style for Dice Area
	GUI.skin = styleDice;
	GUI.skin.box = styleBox;
	GUI.Box(Rect(0,0,Screen.width, Screen.height),"");
	//***********************************************************************************************************************
	//Group for Dice Rolling
	GUILayout.BeginArea (Rect (Screen.width*0.03,guiSizeSelectHeight/2,guiSizeDiceResultWidth,guiSizeDiceResultHeight));
		GUILayout.BeginVertical();
			GUILayout.Label("Würfelwurf",styleDice.customStyles[2]);
			GUILayout.Label(diceResult,styleDice.customStyles[0]);
			GUILayout.Label("Letzte 5 Würfe",styleDice.customStyles[3]);
			GUILayout.Label(lastRolls[0]+lastRolls[1]+lastRolls[2]+lastRolls[3]+lastRolls[4],styleDice.customStyles[1]);
		GUILayout.EndVertical();
	GUILayout.EndArea();
	GUILayout.BeginArea (Rect (guiSizeDiceBeginX,guiSizeSelectHeight/2,guiSizeDiceWidth,guiSizeDiceHeight));	
		GUILayout.BeginVertical();
			GUILayout.BeginHorizontal();
				if(GUILayout.Button("W2 ",styleDice.customStyles[4])) RollDice(2);
				if(GUILayout.Button("W4 ",styleDice.customStyles[5])) RollDice(4);
				if(GUILayout.Button("W6 ",styleDice.customStyles[6])) RollDice(6);
				if(GUILayout.Button("W8 ",styleDice.customStyles[7])) RollDice(8);
			GUILayout.EndHorizontal();
			GUILayout.BeginHorizontal();
				if(GUILayout.Button("W10",styleDice.customStyles[8])) RollDice(10);
				if(GUILayout.Button("W12",styleDice.customStyles[9])) RollDice(12);
				if(GUILayout.Button("W20",styleDice.customStyles[10])) RollDice(20);
				if(GUILayout.Button("clear",styleDice.customStyles[11])) ClearDiceRolls();
			GUILayout.EndHorizontal();
		GUILayout.EndVertical();
	GUILayout.EndArea();
	//***********************************************************************************************************************
	//Group for Toolbar
	GUI.skin = styleToolbar;
	GUILayout.BeginArea(Rect(Screen.width*0.03,guiSizeSelectBeginY,guiSizeDiceWidth, guiSizeSelectHeight/2));
	//	GUILayout.BeginHorizontal();
	//		gridSelectedButton = GUILayout.Toolbar (gridSelectedButton, gridStrings);
	//	GUILayout.EndHorizontal();
	GUILayout.EndArea();
	
	//***********************************************************************************************************************
	//Check which GUI Should be loaded
	switch(gridSelectedButton){
	//***********************************************************************************************************************
		case 0: //InitiativeList
			GUI.skin = styleInitiative;
			GUILayout.BeginArea(Rect(0,guiSizeInitiativeBeginY,Screen.width*0.95, guiSizeInitiativeHeight));
				GUILayout.BeginVertical();
					GUILayout.Space(guiSizeInitiativeHeight*0.03);
					scrollPositionCharacter=GUILayout.BeginScrollView(scrollPositionCharacter);
						GUILayout.BeginHorizontal();
							GUILayout.Space(Screen.width*0.05);
							GUILayout.Label("", styleInitiative.customStyles[0], GUILayout.Width(Screen.width*0.05));
							GUILayout.Label("Name", styleInitiative.customStyles[0], GUILayout.Width(Screen.width*0.4));
							GUILayout.Label("HP", styleInitiative.customStyles[0], GUILayout.Width(Screen.width*0.125));
							GUILayout.Label("Init", styleInitiative.customStyles[0], GUILayout.Width(Screen.width*0.125));
							GUILayout.Label("NPC", styleInitiative.customStyles[0], GUILayout.Width(Screen.width*0.15));
						GUILayout.EndHorizontal();
						GUILayout.Space(5);
						for(var i=playerNames.Length-1;i>0;i--){
							if(initiative[charSort[i]]>0){
								GUILayout.BeginHorizontal();
									GUILayout.Space(Screen.width*0.05);
									if (activeCharacter==i)GUILayout.Label("X", styleInitiative.customStyles[0], GUILayout.Width(Screen.width*0.05));
									else GUILayout.Label("", styleInitiative.customStyles[0], GUILayout.Width(Screen.width*0.05));
									GUILayout.Label(playerNames[charSort[i]], styleInitiative.customStyles[1],GUILayout.Width(Screen.width*0.4));
									GUILayout.Label(healthPoints[charSort[i]].ToString(), styleInitiative.customStyles[1],GUILayout.Width(Screen.width*0.125));
									GUILayout.Label(initiative[charSort[i]].ToString(), styleInitiative.customStyles[1],GUILayout.Width(Screen.width*0.125));
									if(npc[charSort[i]]==true)GUILayout.Label("X", styleInitiative.customStyles[1],GUILayout.Width(Screen.width*0.125));
									else GUILayout.Label("", styleInitiative.customStyles[1],GUILayout.Width(Screen.width*0.125));
								GUILayout.EndHorizontal();
								GUILayout.Space(guiSizeInitiativeHeight*0.01);
								}
							}
					GUILayout.EndScrollView();
					GUILayout.Space(guiSizeInitiativeHeight*0.03);
					GUILayout.BeginHorizontal();
						GUILayout.FlexibleSpace();
						if(GUILayout.Button("Kampfbeginn", styleInitiative.customStyles[2])) {
							InitiativeBeginFight();
							fight = true;
							}
						if(GUILayout.Button("Nächster", styleInitiative.customStyles[2])&& fight){
							InitiativeNextCharacter(activeCharacter);
							}
						if(GUILayout.Button("Kampfende",styleInitiative.customStyles[2])){
							activeCharacter=0;
							fight = false;
							}
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.FlexibleSpace();
				GUILayout.EndVertical();
			GUILayout.EndArea();
			
			//Fight Character Editor
			GUI.skin = styleCharacter;
			GUILayout.BeginArea(Rect(0,guiSizeCharacterBeginY,Screen.width, guiSizeCharacterHeight));
				GUILayout.BeginVertical();
					GUILayout.Space(guiSizeCharacterHeight*0.01);
					//Character Selection Left/Right
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.25);
						if (selectedCharacter>1){if(GUILayout.Button("", styleCharacter.customStyles[9], GUILayout.Width(Screen.width*0.1))) NextCharacter(selectedCharacter,0);}
						else GUILayout.Button("", styleCharacter.customStyles[9], GUILayout.Width(Screen.width*0.1));
						GUILayout.Space(Screen.width*0.1);
						if(selectedCharacter < playerNames.Length-1){if(GUILayout.Button("", styleCharacter.customStyles[10], GUILayout.Width(Screen.width*0.1))) NextCharacter(selectedCharacter,1);}
						else GUILayout.Button("", styleCharacter.customStyles[10], GUILayout.Width(Screen.width*0.1));
						GUILayout.Label(playerNames[selectedCharacter], styleCharacter.customStyles[0], GUILayout.Width(Screen.width*0.4));
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					
					//Character Editor
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("Name:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2));
						playerNames[selectedCharacter] = GUILayout.TextField(playerNames[selectedCharacter], styleCharacter.customStyles[3]);
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("HP:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2), GUILayout.Height(Screen.width*0.07));
					  	GUILayout.Label(healthPoints[selectedCharacter].ToString(), styleCharacter.customStyles[3],GUILayout.Width(Screen.width*0.2), GUILayout.Height(Screen.width*0.07));
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("", styleCharacter.customStyles[2],GUILayout.Width(Screen.width*0.07), GUILayout.Height(Screen.width*0.07))) healthPoints[selectedCharacter]--;
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("", styleCharacter.customStyles[6],GUILayout.Width(Screen.width*0.07), GUILayout.Height(Screen.width*0.07))) healthPoints[selectedCharacter]++;
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("Initiative:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2), GUILayout.Height(Screen.width*0.07));
						if(initiative[selectedCharacter]==0) GUILayout.Label("-", styleCharacter.customStyles[3],GUILayout.Width(Screen.width*0.2), GUILayout.Height(Screen.width*0.07));
						else GUILayout.Label(initiative[selectedCharacter].ToString(), styleCharacter.customStyles[3],GUILayout.Width(Screen.width*0.2), GUILayout.Height(Screen.width*0.07));
						GUILayout.Space(Screen.width*0.02);
						if(initiative[selectedCharacter]<1) GUILayout.Button("", styleCharacter.customStyles[2],GUILayout.Width(Screen.width*0.07), GUILayout.Height(Screen.width*0.07));
					  	else {
					  		if(GUILayout.Button("", styleCharacter.customStyles[2],GUILayout.Width(Screen.width*0.07), GUILayout.Height(Screen.width*0.07))){
					  			initiative[selectedCharacter]--;
					  			SortList();
					  			}
					  		}
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("", styleCharacter.customStyles[6],GUILayout.Width(Screen.width*0.07), GUILayout.Height(Screen.width*0.07))){
					  		initiative[selectedCharacter]++;
					  		SortList();
					  		}
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("reset", styleCharacter.customStyles[7])) initiative[selectedCharacter]=0;
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("NPC?:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2), GUILayout.Height(Screen.width*0.07) );
						npc[selectedCharacter] = GUILayout.Toggle(npc[selectedCharacter], "", GUILayout.Width(Screen.width*0.07), GUILayout.Height(Screen.width*0.07) );
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					GUILayout.BeginHorizontal();
						GUILayout.FlexibleSpace();
						if(GUILayout.Button("Neu", styleCharacter.customStyles[8])) AddNewCharacter();
						GUILayout.Space(Screen.width*0.1);
						if(GUILayout.Button("Delete", styleCharacter.customStyles[8])) DeleteCharacter(selectedCharacter);
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.FlexibleSpace();
				GUILayout.EndVertical();
			GUILayout.EndArea();
			break;
		}
	//***********************************************************************************************************************
	
	}

//Roll the Dice		
function RollDice(dice:int){
	//Create Random Number from 1 to Eyes on the Dice
	roll = Random.Range(1,dice+1);
	
	//Make yes/not Statement for W2
	if(dice==2){
		if(roll==1){diceResult = "ja";}
		else if(roll==2){diceResult = "nein";}
		}
	//Or set the Dice result	
	else{diceResult = ""+roll;}
	
	for (var i=lastRolls.Length-1; i>0; i--){
		lastRolls[i]=lastRolls[i-1];
		if(i==1 && lastRolls[i]) lastRolls[i] = " / "+lastRolls[i];
		}
	lastRolls[0]=diceResult;
	}
		
//Clear all Dice Rolls
function ClearDiceRolls(){
	for(var i=0;i<lastRolls.Length;i++)lastRolls[i]="";
	diceResult = "";
	}

//Add new Character
function AddNewCharacter(){
	System.Array.Resize.<int>(charSort,charSort.length+1);
	System.Array.Resize.<String>(playerNames,playerNames.length+1);
	playerNames[playerNames.Length-1] = "Name";
	System.Array.Resize.<int>(healthPoints,healthPoints.length+1);
	healthPoints[playerNames.Length-1] = 0;
	System.Array.Resize.<int>(initiative,initiative.length+1);
	initiative[playerNames.Length-1] = 0;
	System.Array.Resize.<boolean>(npc,npc.length+1);
	npc[playerNames.Length-1] = true;
	selectedCharacter = playerNames.Length-1;
	SortList();
	}
	
//Sort List
function SortList(){
	for (var x=0;x<charSort.Length;x++) charSort[x]=0;

	for (var k=1;k<charSort.Length;k++){
		for (var j=1; j<playerNames.Length; j++){
			if(initiative[j]<=minValue && initiative[j]>=tempMin){
				for(var l=1; l<charSort.Length; l++){
					if(charSort[l]==j) sortExist = true;
					else if (charSort[l]!=j && !sortExist) sortExist=false;
					}
				if (!sortExist){
					minValue=initiative[j];
					tempMinChar=j;
					}
				sortExist = false;
				}
			}
		if(minValue<1000) tempMin = minValue;
		minValue = 1000;
		if(tempMinChar>0)charSort[k]=tempMinChar;
		tempMinChar=0;
		}
	tempMinChar=0;
	tempMin = 1; 
	}


//Delete Character or NPC
function DeleteCharacter(character:int){
	if(character==1){
		playerNames[1]="Name";
		healthPoints[1]=0;
		initiative[1]=0;
		return;
		}
	playerNames[character]="";
	healthPoints[character]=0;
	initiative[character]=0;
	if(character==playerNames.Length-1){
		for(var a=playerNames.Length-1;a>0;a--){
			if(playerNames[a]!=""){
				selectedCharacter=a;
				break;
				}
			}
		}
	else{
		for(var b=character;b<playerNames.Length;b++){
			if(playerNames[b]!=""){
				selectedCharacter=b;
				break;
				}
			}
		selectedCharacter=charSort[1];
		}
	}

//Switch through the Character in the character editor
function NextCharacter(character:int,direction:int){
	switch(direction){
		case 0:
		for(var i=character-1;i>0;i--){
			if(playerNames[i]!=""){
				selectedCharacter=i;
				return;
				}
			}
		case 1:
		for(var j=character+1; j<playerNames.Length;j++){
			if(playerNames[j]!=""){
				selectedCharacter=j;
				return;
				}
			}
		}
	}

//Set active Character to the one with the highest Initiative
function InitiativeBeginFight(){
	for(var a=charSort.Length-1;a>0;a--){
		if(charSort[a]!=0){
			activeCharacter=a;
			break;
			}
		}
	}

//Set the active Character to the one next in the initiative order
function InitiativeNextCharacter(character:int){
	 if(activeCharacter>1)activeCharacter--;
	 else {
	 	for(var a=charSort.Length-1;a>=0;a--){
	 		if(charSort[a]!=0){
				activeCharacter=a;
				break;
				}
			}
		}
	}

//DatenSpeichern
function SaveData(){
	PlayerPrefsX.SetStringArray ("playerNames", playerNames);
	PlayerPrefsX.SetIntArray  ("healthPoints", healthPoints);
	PlayerPrefsX.SetIntArray ("initiative", initiative);
	PlayerPrefsX.SetBoolArray ("npc", npc);
	PlayerPrefsX.SetIntArray ("charSort", initiative);
	}
	
		
	
	
	
/*
Update Log

-Dice Button Texture
-Removed Sample Characters
-Changed Button Size Character Area

*/
	
	
	