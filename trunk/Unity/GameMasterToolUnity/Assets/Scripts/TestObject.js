#pragma strict

var testInt :int = 25;

function getTestInt(): int {
	return this.testInt;
}

function setTestInt(testInt : int){
	this.testInt = testInt;
}