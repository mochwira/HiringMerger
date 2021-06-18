var delayQueue = [];
var doingQueue = [];
var delayLenght = 0;


function addQueue(value){
	// delayQueue = parseData();
	console.log('---q : '+delayQueue.length);
	console.log('---l : '+delayLenght);

	var delayLenghtVal = delayQueue.length;
	var delayLenghtOpen = delayLenght-1;
	console.log('Val : '+delayLenghtVal);
	console.log('Op  : '+delayLenghtOpen);
	if (delayLenghtVal < delayLenghtOpen) {
		delayQueue.push(value);
	}else if(delayLenghtVal == delayLenghtOpen){
		delayQueue.shift();
		delayQueue.push(value);		
	}
	// stringifyData(delayQueue);
}


function remove(value){
	const index = delayQueue.indexOf(value);
	if (index > -1) {
		delayQueue.splice(index, 1);
	}
}

function getQueue(){
	console.log(delayQueue);
	return delayQueue;
}


function getValue(value){
	for(i=0; i < delayQueue.length; i++){
		var id = delayQueue[i];
		if (id == value) {
			return true;
		}
	}
	return false;
}



// Skill Data PARSE
function parseData(){
	data = JSON.parse(localStorage.getItem('storage'));
	return data;
}

// Skill Data stringify
function stringifyData(data){
	if (data != null) {
		localStorage.setItem("storage", JSON.stringify(data));
	}
}