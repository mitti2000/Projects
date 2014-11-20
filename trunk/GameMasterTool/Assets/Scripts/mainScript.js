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


function Start () {

	//Set Player 0
	playerNames[0] = "empty";
	healthPoints[0]=0;
	initiative[0]=1;
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
	
		
	//Set Display Size
	guiSizeDiceResultWidth = Screen.width*0.3;
	guiSizeDiceResultHeight = Screen.height*0.2;
	guiSizeDiceWidth = Screen.width*0.67;
	guiSizeDiceHeight = Screen.height*0.2;
	guiSizeDiceBeginX = Screen.width*0.3;
	guiSizeSelectHeight = Screen.height*0.04;
	guiSizeSelectBeginY = guiSizeDiceHeight;
	guiSizeInitiativeHeight = Screen.height*0.5;
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
	
	//Set Font Sizes for Initiative Table
	styleInitiative.customStyles[0].fontSize = Mathf.RoundToInt (fontSizeInitiativeTitle * Screen.width / (defaultWidth * 1.0));
	styleInitiative.customStyles[1].fontSize = Mathf.RoundToInt (fontSizeInitiativeTable * Screen.width / (defaultWidth * 1.0));
	styleInitiative.customStyles[2].fontSize = Mathf.RoundToInt (fontSizeInitiativeButton * Screen.width / (defaultWidth * 1.0));
	
	
	}

function Update(){
	if(Input.touchCount>0){
		touch=Input.touches[0];
		if(touch.phase == TouchPhase.Moved){
			scrollPositionCharacter.y += touch.deltaPosition.y;
			}
		}
	}

function OnGUI (){
	//Get amount of Initiative Characters and set length of sorting Array
	/*
	for(var a=0;a<playerNames.Length;a++){
		if(initiative[a]>0) iniCount++;
		}
	sortDiff=(charSort.Length-iniCount)-1;
	if (charSort.Length!=iniCount) System.Array.Resize.<int>(charSort,charSort.length-sortDiff);
	Debug.Log(charSort.Length);
	iniCount=0;
	*/
	//Sort List
	for (var k=1;k<charSort.Length;k++){
		for (var j=1; j<playerNames.Length; j++){
			if(initiative[j]<=minValue && initiative[j]>=tempMin){
				for(var l=1; l<=k; l++){
					if(j==charSort[l]) sortExist = true;
					}
				if (!sortExist){
					minValue=initiative[j];
					charSort[k]=j;
					}
				}
			sortExist = false;
			}
		tempMin = minValue;
		minValue = 1000;
		}
	tempMin = 1;
	
	//set GUI Style for Dice Area
	GUI.skin = styleDice;
	GUI.skin.box = styleBox;
	GUI.Box(Rect(0,0,Screen.width, Screen.height),"");
	//***********************************************************************************************************************
	//Group for Dice Rolling
	GUILayout.BeginArea (Rect (Screen.width*0.03,0,guiSizeDiceResultWidth,guiSizeDiceResultHeight));
		GUILayout.BeginVertical();
			GUILayout.Label("Würfelwurf",styleDice.customStyles[2]);
			GUILayout.Label(diceResult,styleDice.customStyles[0]);
			GUILayout.Label("Letzte 5 Würfe",styleDice.customStyles[3]);
			GUILayout.Label(lastRolls[0]+lastRolls[1]+lastRolls[2]+lastRolls[3]+lastRolls[4],styleDice.customStyles[1]);
		GUILayout.EndVertical();
	GUILayout.EndArea();
	GUILayout.BeginArea (Rect (guiSizeDiceBeginX,0,guiSizeDiceWidth,guiSizeDiceHeight));	
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
	GUILayout.BeginArea(Rect(Screen.width*0.03,guiSizeSelectBeginY,guiSizeDiceWidth, guiSizeSelectHeight));
		GUILayout.BeginHorizontal();
			gridSelectedButton = GUILayout.Toolbar (gridSelectedButton, gridStrings);
		GUILayout.EndHorizontal();
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
									//GUILayout.Label(""+charSort[i]);
									//GUILayout.Label("Sort"+i);
								GUILayout.EndHorizontal();
								GUILayout.Space(guiSizeInitiativeHeight*0.01);
								}
							}
					GUILayout.EndScrollView();
					GUILayout.Space(guiSizeInitiativeHeight*0.03);
					GUILayout.BeginHorizontal();
						GUILayout.FlexibleSpace();
						if(GUILayout.Button("Kampfbeginn", styleInitiative.customStyles[2])) {
							fight = true;
							activeCharacter=playerNames.Length-1;
							}
						if(GUILayout.Button("Nächster", styleInitiative.customStyles[2])&& fight){
							if(activeCharacter>1)activeCharacter--;
							else activeCharacter=playerNames.Length-1;
							}
						if(GUILayout.Button("Kampfende",styleInitiative.customStyles[2])){
							activeCharacter=playerNames.Length;
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
				//Character Selection Left/Right
				GUILayout.BeginHorizontal();
					GUILayout.Space(Screen.width*0.25);
					if (selectedCharacter>1){if(GUILayout.Button("", styleCharacter.customStyles[2], GUILayout.Width(Screen.width*0.05))) selectedCharacter--;}
					else GUILayout.Button("", styleCharacter.customStyles[2], GUILayout.Width(Screen.width*0.05));
					if(selectedCharacter < playerNames.Length-1){if(GUILayout.Button("", styleCharacter.customStyles[6], GUILayout.Width(Screen.width*0.05))) selectedCharacter++;}
					else GUILayout.Button("", styleCharacter.customStyles[6], GUILayout.Width(Screen.width*0.05));
					GUILayout.Label(playerNames[selectedCharacter], styleCharacter.customStyles[0], GUILayout.Width(Screen.width*0.4));
					
				GUILayout.EndHorizontal();
				//Character Editor
				GUILayout.BeginVertical();
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("Name:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2));
						playerNames[selectedCharacter] = GUILayout.TextField(playerNames[selectedCharacter], styleCharacter.customStyles[3]);
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("HP:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2));
					  	GUILayout.Label(healthPoints[selectedCharacter].ToString(), styleCharacter.customStyles[3],GUILayout.Width(Screen.width*0.2));
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("", styleCharacter.customStyles[2],GUILayout.Width(Screen.width*0.05))) healthPoints[selectedCharacter]--;
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("", styleCharacter.customStyles[6],GUILayout.Width(Screen.width*0.05))) healthPoints[selectedCharacter]++;
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("Initiative:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2));
						if(initiative[selectedCharacter]==0) GUILayout.Label("-", styleCharacter.customStyles[3],GUILayout.Width(Screen.width*0.2));
						else GUILayout.Label(initiative[selectedCharacter].ToString(), styleCharacter.customStyles[3],GUILayout.Width(Screen.width*0.2));
						GUILayout.Space(Screen.width*0.02);
						if(initiative[selectedCharacter]<1) GUILayout.Button("", styleCharacter.customStyles[2],GUILayout.Width(Screen.width*0.05));
					  	else {if(GUILayout.Button("", styleCharacter.customStyles[2],GUILayout.Width(Screen.width*0.05))) initiative[selectedCharacter]--;}
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("", styleCharacter.customStyles[6],GUILayout.Width(Screen.width*0.05))) initiative[selectedCharacter]++;
					  	GUILayout.Space(Screen.width*0.02);
					  	if(GUILayout.Button("reset", styleCharacter.customStyles[7])) initiative[selectedCharacter]=0;
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.Space(guiSizeCharacterHeight*0.05);
					GUILayout.BeginHorizontal();
						GUILayout.Space(Screen.width*0.01);
						GUILayout.Label("NPC?:", styleCharacter.customStyles[1],GUILayout.Width(Screen.width*0.2));
						npc[selectedCharacter] = GUILayout.Toggle(npc[selectedCharacter], "");
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
					GUILayout.BeginHorizontal();
						GUILayout.FlexibleSpace();
						if(GUILayout.Button("Neu", styleCharacter.customStyles[8])) AddNewCharacter();
						GUILayout.Space(Screen.width*0.1);
						GUILayout.Button("Delete", styleCharacter.customStyles[8]);
						GUILayout.FlexibleSpace();
					GUILayout.EndHorizontal();
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
	}
	

	
	
	
	
	
	