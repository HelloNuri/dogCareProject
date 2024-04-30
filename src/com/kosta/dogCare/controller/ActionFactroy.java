package com.kosta.dogCare.controller;

import com.kosta.dogCare.controller.action.Action;
import com.kosta.dogCare.controller.action.Login;
import com.kosta.dogCare.controller.action.LoginUI;
import com.kosta.dogCare.controller.action.AddDogInfo;
import com.kosta.dogCare.controller.action.AddDogInfoUI;
import com.kosta.dogCare.controller.action.AlbumList;
import com.kosta.dogCare.controller.action.AlbumListUI;
import com.kosta.dogCare.controller.action.CheckIdExistence;
import com.kosta.dogCare.controller.action.CheckValidationNum;
import com.kosta.dogCare.controller.action.DogHealthReport;
import com.kosta.dogCare.controller.action.DogHealthReportUI;
import com.kosta.dogCare.controller.action.FindAccountUI;
import com.kosta.dogCare.controller.action.FindId;
import com.kosta.dogCare.controller.action.FindPw;
import com.kosta.dogCare.controller.action.IsExistId;
import com.kosta.dogCare.controller.action.Logout;
import com.kosta.dogCare.controller.action.MainUI;
import com.kosta.dogCare.controller.action.Register;
import com.kosta.dogCare.controller.action.RegisterDogUI;
import com.kosta.dogCare.controller.action.RegisterUI;
import com.kosta.dogCare.controller.action.SendValidationNum;
import com.kosta.dogCare.controller.action.SupplyStatistic;
import com.kosta.dogCare.controller.action.SupplyStatisticUI;
import com.kosta.dogCare.controller.action.WatchAlbum;
import com.kosta.dogCare.controller.action.WatchAlbumUI;

public class ActionFactroy {
	
	public Action getAction(String cmd){
		Action action = null;
		switch (cmd) {
		case "loginUI":
			action = new LoginUI();
			break;
		case "login":
			action = new Login();
			break;
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
		case "checkIdExistence":
			action = new CheckIdExistence();
			break;
		case "findAccountUI":
			action = new FindAccountUI();
			break;
		case "findId":
			action = new FindId();
			break;
		case "findPw":
			action = new FindPw();
			break;
		case "mainUI":
			action = new MainUI();
			break;
		case "logout":
			action = new Logout();
			break;
		case "addDogInfoUI":
			action = new AddDogInfoUI();
			break;
		case "addDogInfo":
			action = new AddDogInfo();
			break;
		case "registerDogUI":
			action = new RegisterDogUI();
			break;
		case "registerDog":
			action = new RegisterDogUI();
			break;
		case "dogHealthReportUI":
			action = new DogHealthReportUI();
			break;
		case "dogHealthReport":
			action = new DogHealthReport();
			break;
		case "albumListUI":
			action = new AlbumListUI();
			break;
		case "albumList":
			action = new AlbumList();
			break;
		case "watchAlbumUI":
			action = new WatchAlbumUI();
			break;
		case "watchAlbum":
			action = new WatchAlbum();
			break;
		case "supplyStatisticUI":
			action = new SupplyStatisticUI();
			break;
		case "supplyStatistic":
			action = new SupplyStatistic();
			break;
		case "isExistId":
			action = new IsExistId();
			break;
		
		}
		return action;
	}
}
