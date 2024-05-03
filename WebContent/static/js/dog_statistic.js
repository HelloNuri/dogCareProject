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
	
	updateStatistic(e);
}

async function updateStatistic(e){
	const dogId = e.target.getAttribute("dog-id");
	
	const breedInput = document.querySelector("#sel2");
	const ageInput = document.querySelector(".checkbox2 input");
	const weightInput = document.querySelector(".checkbox3 input");
	
	breedInput.value = e.target.getAttribute("dog-breed");
	let ageMills = new Date() - new Date(e.target.getAttribute("dog-birth-date"));
    const ageMonths = Math.floor(ageMills / (1000 * 60 * 60 * 24 * 30));
	ageInput.value = ageMonths;
	
	const weightRes = await fetch("controller?cmd=dogRecentWeight&dogId="+dogId);
	const weightJson = await weightRes.json();
	weightInput.value = weightJson.weight;
	
}

async function getResult(){
	const breedInput = document.querySelector("#sel2");
	const ageInput = document.querySelector(".checkbox2 input");
	const weightInput = document.querySelector(".checkbox3 input");
	const categoryInput = document.querySelector("#sel3");
	
	const url = "controller?cmd=supplyRankPage" +
			"&breed="    +breedInput.value + 
			"&age="     +ageInput.value + 
			"&category="+categoryInput.value;
	const res = await fetch(url);
	const in_data = await res.json();
	
	element = '<table class="table table-bordered">';
	element += "<thead><tr><th>순위</th><th>상품명</th><th>점유율</th></tr></thead>";
	element += "<tbody>";
	for(i = 0; i<10 && i < in_data.length;i++){
		element += "<tr>";
		element += "<th>" + (i+1) + "</th>";
		element += "<th>" + in_data[i].name + "</th>";
		element += "<th>" + in_data[i].percent + "%</th>";
		element += "</tr>";
	}
	element += "</tbody>";
	element += '</table>';
	
	$("#container1").html(element);
		
}

