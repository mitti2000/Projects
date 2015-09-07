#pragma strict

var testObject : TestObject;
var testInt : int;

function Start () {
	testObject = new TestObject();
	Debug.Log("TestInt " + testObject.getTestInt());
	testObject.setTestInt(30);
	Debug.Log("TestInt " + testObject.getTestInt());
	
}

function Update () {
	
	
}