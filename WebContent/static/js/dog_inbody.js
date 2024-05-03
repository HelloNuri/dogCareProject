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
	weightBox.innerText = weightData.trim();
	exerciseBox.innerText = exerciseData.trim();
	
	let xAxisData = ['철수','영희','민수','지수']; // x축 데이터 배열 생성
	let seriesData = [70,80,100,30]; // 값 데이터 배열 생성
	updateChart();
}

function updateChart(){

    function drawChart () { 

	var myChart = echarts.init(document.getElementById('chart')); // echarts init 메소드로 id=chart인 DIV에 차트 초기화
	
	option = { // 차트를 그리는데 활용 할 다양한 옵션 정의
                xAxis: {
                    type: 'category',
                    data: xAxisData // 위에서 정의한 X축 데이터
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                    data: seriesData, // 위에서 정의한 값 데이터
                    type: this.value // 버튼의 value 데이터 ('line' or 'bar')
                    }
                ]
                    };
    
	myChart.setOption(option); // 차트 디스플레이
}
}
