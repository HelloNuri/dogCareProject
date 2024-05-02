<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <title>Dog Care: 강아지 건강정보 입력</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="static/img/dogCare.png.ico">
  <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> -->
  <script src="static/js/bootstrap.bundle.min.js"></script>

  <link rel="stylesheet" href="static/css/main.css">
  <link rel="stylesheet" href="static/css/dog_info.css">

  <script src="static/js/dog_info.js">

  </script>

  <!-- 항목 삭제버튼의 이미지를 .class로 만들면 리소스를 아낄 수 있지 않을까? -->
</head>

<body>
  <nav class="navbar navbar-expand-sm bg-primary navbar-primary">

    <div class="container-fluid">
      <a id="backPage" class="navbar-brand" href="controller?cmd=mainUI"><svg xmlns="http://www.w3.org/2000/svg" width="28"
          height="28" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
          <path fill-rule="evenodd"
            d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8" />
        </svg>
      </a>
      <div id="title"><span class="navbar-brand">강아지 건강정보 입력</span></div>
      <div></div>
    </div>
  </nav>

  <div id="body" class="container">
    <div id="main-container">
      <form action="controller?cmd=addDogInfo" method="post">
        <div id="select-container">
          <div class="dropdown">
            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">강아지 선택
            </button>
            <ul class="dropdown-menu">
            <c:forEach var="dog" items="${dogs}">
            	<li><a class="dropdown-item" dog-id="${dog.getDogId()}" dog-breed="${dog.getBreed()}" dog-birth-date="${dog.getBirthDate()}" dog-gender="${dog.getGender()}">${dog.getName()}</a></li>
            </c:forEach>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li><a class="dropdown-item" href="controller?cmd=registerDogUI"
                  style="display: flex; justify-content: center; color: green;"><svg xmlns="http://www.w3.org/2000/svg"
                    width="32" height="32" fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                    <path
                      d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z" />
                  </svg></a></li>
            </ul>
          </div>
          <input type="date" name="datetime-local" id="infoDate" class="form-control" name="dogInfoDate">
        </div>
        <div id="dogInfo-container" class="logoImage">
          <div class="grid-row">
            <div class="label">강아지 정보</div>
            <input type="hidden" id="dogId" name="dogId" required>
            <div class="items">
              <div class="item">
                <div>이름: </div>
                <input type="text" class="form-control" placeholder="골댕이" disabled>
              </div>
              <div class="item">
                <div>품종: </div>
                <input type="text" class="form-control" placeholder="골든 리트리버" disabled>
              </div>
              <div class="item">
                <div>나이: </div>
                <input type="text" class="form-control" placeholder="13개월" disabled>
              </div>
              <div class="item">
                <div>성별: </div>
                <input type="text" class="form-control" placeholder="남" disabled>
              </div>
            </div>
          </div>
          <div class="grid-row">
            <div class="label">강아지 건강정보</div>
            <div class="items">
              <div class="item">
                <div>*체중: </div>
                <input type="number" class="form-control" placeholder="11.3 (kg)" name="dogWeight" required>
              </div>
              <div class="item">
                <div>*운동량:</div>
                <input type="number" class="form-control" placeholder="7 (시간/주)" name="dogExerciseTime" required>
              </div>
              <div class="item">
                <div>비고: </div>
                <input type="text" class="form-control" placeholder="구역질 자꾸 함" name="dogNote">
              </div>
            </div>
          </div>
          <div class="grid-row">
            <div class="label">강아지 용품 정보</div>
            <div class="items">
              
              <button type="button" id="supply-btn" class="btn btn-primary"><svg xmlns="http://www.w3.org/2000/svg"
                  fill="currentColor" class="bi bi-plus-circle-fill" viewBox="0 0 16 16">
                  <path
                    d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z" />
                </svg>
              </button>


            </div>

          </div>
        </div>
        <div style="display: flex;justify-content: end;">
          <button class="btn btn-primary" style="padding: 1rem 2rem;display: flex;align-items: center;">등록</button>
        </div>
      </form>

    </div>


  </div>


  <script>
    const dogInfoForm = document.querySelector("form");
    const dogSelectBtn = document.querySelector(".dropdown button");
    const dogs = document.querySelector(".dropdown button").nextElementSibling.querySelectorAll("li");
    const supplies = document.querySelectorAll('div.items:last-of-type')[2].querySelectorAll(".item");
    const supplyAddBtn = document.querySelector("#supply-btn");
    
    document.querySelector("#infoDate").value = new Date().toISOString().slice(0, 10);



    dogInfoForm.addEventListener("submit", submitDogInfo);
    for (let i = 0; i < dogs.length - 2; i++) {
      dogs[i].addEventListener("click", (e) => updateSelectedDog(e));
    }

    supplyAddBtn.addEventListener("click", insertSupply);
  </script>
</body>

</html>