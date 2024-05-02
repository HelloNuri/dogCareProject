<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Dog Care: 강아지 건강정보 입력</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="static/img/dogCare.png.ico">

  <script src="static/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="static/css/main.css">
  <script src="static/js/dog_inbody.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 <style> 
 	body {
 		background-image: url("static/img/logo.svg");
 		background-repeat:no-repeat;
		background-position:5px 30px;
 	}
	
	
	#contain {
		display:grid;
		grid-template-rows:0.3fr 1fr 0.8fr 1fr;
	}


	.btn-group {
		grid-area:1/1/2/2;
	}

	
	.weigth {
		grid-area:2/1/3/2;
	}
	
	
	.exercise {
		grid-area:4/1/5/2;
	}
	
	




 </style>  
</head>
<body>


<nav class="navbar navbar-expand-sm bg-primary navbar-primary" style="background-color:#92d050 !important;">
  
  <div class="container-fluid">
    <a class="navbar-brand text-center" href="controller?cmd=mainUI"><svg xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
      <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8"/>
    </svg>
    </a>
    <span id="title" class="navbar-brand">인바디</span>
  </div>
</nav>


	<div id="contain">

		<div id="select-container">
			<input type="hidden" id="selectedDog">
			<div class="dropdown">
				<button id="dogSelectBtn" type="button"
					class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
					data-updated="true">강아지 선택</button>
				<ul class="dropdown-menu" id="dogList">
					<c:forEach var="dog" items="${dogs}">
						<li><a class="dropdown-item" dog-id="${dog.getDogId()}"
							dog-breed="${dog.getBreed()}"
							dog-birth-date="${dog.getBirthDate()}"
							dog-gender="${dog.getGender()}">${dog.getName()}</a></li>
					</c:forEach>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item"
						href="controller?cmd=registerDogUI"
						style="display: flex; justify-content: center; color: green;"><svg
								xmlns="http://www.w3.org/2000/svg" width="32" height="32"
								fill="currentColor" class="bi bi-plus-circle-fill"
								viewBox="0 0 16 16">
                    <path
									d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z" />
                  </svg></a></li>
				</ul>
			</div>
		</div>



		<div id="weight">
			체중그래프
			<div class="container pt-5"></div>
		</div>

		<div id="exercise">
			운동량그래프
			<div class="container pt-5"></div>
		</div>

	</div>
	<script type="text/javascript">
	const dogSelectBtn = document.querySelector("#dogSelectBtn");
	dogSelectBtn.addEventListener("click", dogListUpdate);


</script>
</body>
</html>