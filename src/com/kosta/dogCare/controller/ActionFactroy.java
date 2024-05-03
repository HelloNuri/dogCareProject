package com.kosta.dogCare.controller;

import com.kosta.dogCare.controller.action.Action;
import com.kosta.dogCare.controller.action.Login;
import com.kosta.dogCare.controller.action.LoginUI;
import com.kosta.dogCare.controller.action.AddDogInfo;
import com.kosta.dogCare.controller.action.AddDogInfoUI;
import com.kosta.dogCare.controller.action.AlbumList;
import com.kosta.dogCare.controller.action.AlbumListUI;
import com.kosta.dogCare.controller.action.CheckValidationNum;
import com.kosta.dogCare.controller.action.DogHealthReportUI;
import com.kosta.dogCare.controller.action.DogList;
import com.kosta.dogCare.controller.action.DogRecentWeight;
import com.kosta.dogCare.controller.action.ExerciseChart;
import com.kosta.dogCare.controller.action.FindAccountUI;
import com.kosta.dogCare.controller.action.FindId;
import com.kosta.dogCare.controller.action.FindPw;
import com.kosta.dogCare.controller.action.IsExistId;
import com.kosta.dogCare.controller.action.Logout;
import com.kosta.dogCare.controller.action.MainUI;
import com.kosta.dogCare.controller.action.Register;
import com.kosta.dogCare.controller.action.RegisterDog;
import com.kosta.dogCare.controller.action.RegisterDogUI;
import com.kosta.dogCare.controller.action.RegisterUI;
import com.kosta.dogCare.controller.action.SendValidationNum;
import com.kosta.dogCare.controller.action.SupplyRankPage;
import com.kosta.dogCare.controller.action.SupplyStatistic;
import com.kosta.dogCare.controller.action.SupplyStatisticUI;
import com.kosta.dogCare.controller.action.WatchAlbum;
import com.kosta.dogCare.controller.action.WatchAlbumUI;
import com.kosta.dogCare.controller.action.WeightChart;

public class ActionFactroy {
	
	public Action getAction(String cmd){
		Action action = null;
		switch (cmd) {
		/*login*/
		case "loginUI":
			action = new LoginUI();
			break;
		case "login":
			action = new Login();
			break;
		/*register*/
		case "registerUI":
			action = new RegisterUI();
			break;
		case "register":
			action = new Register();
			break;
		case "sendValidationNum":
			action = new SendValidationNum();
			break;
		case "checkValidationNum":
			action = new CheckValidationNum();
			break;
		case "isExistId":
			action = new IsExistId();
			break;
		/*ID/PW찾기*/
		case "findAccountUI":
			action = new FindAccountUI();
			break;
		case "findId":
			action = new FindId();
			break;
		case "findPw":
			action = new FindPw();
			break;
		/*메인메뉴*/
		case "mainUI":
			action = new MainUI();
			break;
		/*강아지 건강정보 등록*/
		case "addDogInfoUI":
			action = new AddDogInfoUI();
			break;
		case "addDogInfo":
			action = new AddDogInfo();
			break;
		/*강아지 회원가입*/
		case "registerDogUI":
			action = new RegisterDogUI();
			break;
		case "registerDog":
			action = new RegisterDog();
			break;
		/*강아지 인바디*/
		case "dogHealthReportUI":
			action = new DogHealthReportUI();
			break;
		case "weightChart":
			action = new WeightChart();
			break;
		case "exerciseChart":
			action = new ExerciseChart();
			break;
		/*나의 강아지 앨범목록*/
		case "albumListUI":
			action = new AlbumListUI();
			break;
		case "albumList":
			action = new AlbumList();
			break;
		/*앨범 상세보기*/
		case "watchAlbumUI":
			action = new WatchAlbumUI();
			break;
		case "watchAlbum":
			action = new WatchAlbum();
			break;
		/*강아지 관련용품 통계*/
		case "supplyStatisticUI":
			action = new SupplyStatisticUI();
			break;
		case "supplyStatistic":
			action = new SupplyStatistic();
			break;
		case "dogRecentWeight":
			action = new DogRecentWeight();
			break;
		case "supplyRankPage":
			action = new SupplyRankPage();
			break;
		
		/*공통 기능*/
		case "logout":
			action = new Logout();
			break;
		case "dogList":
			action = new DogList();
			break;
		}
		return action;
	}
}
