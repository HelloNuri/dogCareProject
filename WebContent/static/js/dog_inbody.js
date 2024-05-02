async function dogListUpdate(e){
//	if(e.target.dataset.updated)
//		return;
	const url = "controller?cmd=dogList";
	const res = await fetch(url);
	const in_data = await res.text();
	const dogList = $("#dogList");
	dogList.html(in_data);
	
	dogListEvent();
}

function dogListEvent(){
	const dogs= document.querySelectorAll("#select-container li");
	for(const dog of dogs){
		dog.addEventListener("click", updateSelectedDog);
	}
}

function updateSelectedDog(e){
	const dogs = document.querySelector("#selectedDog");
	const dogBtn = document.querySelector("#dogSelectBtn");
	const dogId =e.target.getAttribute("dog-id"); 
	dogBtn.innerText = e.target.innerText;
	dogs.value = dogId;
	
	updateInbody(dogId);
}


async function updateInbody(dogId){
	const wR = fetch("controller?cmd=weightChart&dogId="+dogId);
	const eR = fetch("controller?cmd=exerciseChart&dogId="+dogId);
	
	let [weightRes, exerciseRes] = await Promise.all([wR, eR]);
	let [weightData, exerciseData] = await Promise.all([weightRes.text(), exerciseRes.text()]);
	const weightBox = document.querySelector("#weight div");
	const exerciseBox = document.querySelector("#exercise div");
	console.log(exerciseData);
	weightBox.innerText = weightData;
	exerciseBox.innerText = exerciseData;
	
}
