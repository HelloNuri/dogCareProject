package com.kosta.dogCare.controller;

import com.kosta.dogCare.controller.action.Action;
import com.kosta.dogCare.controller.action.Login;
import com.kosta.dogCare.controller.action.LoginUI;
import com.kosta.dogCare.controller.action.addDogInfo;
import com.kosta.dogCare.controller.action.addDogInfoUI;
import com.kosta.dogCare.controller.action.albumList;
import com.kosta.dogCare.controller.action.albumListUI;
import com.kosta.dogCare.controller.action.checkIdExistence;
import com.kosta.dogCare.controller.action.checkValidationNum;
import com.kosta.dogCare.controller.action.dogHealthReport;
import com.kosta.dogCare.controller.action.dogHealthReportUI;
import com.kosta.dogCare.controller.action.findAccountUI;
import com.kosta.dogCare.controller.action.findId;
import com.kosta.dogCare.controller.action.findPw;
import com.kosta.dogCare.controller.action.logout;
import com.kosta.dogCare.controller.action.mainUI;
import com.kosta.dogCare.controller.action.registerAction;
import com.kosta.dogCare.controller.action.registerDogUI;
import com.kosta.dogCare.controller.action.registerUI;
import com.kosta.dogCare.controller.action.sendValidationNum;
import com.kosta.dogCare.controller.action.supplyStatistic;
import com.kosta.dogCare.controller.action.supplyStatisticUI;
import com.kosta.dogCare.controller.action.watchAlbum;
import com.kosta.dogCare.controller.action.watchAlbumUI;

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
			action = new registerUI();
			break;
		case "register":
			action = new registerAction();
			break;
		case "sendValidationNum":
			action = new sendValidationNum();
			break;
		case "checkValidationNum":
			action = new checkValidationNum();
			break;
		case "checkIdExistence":
			action = new checkIdExistence();
			break;
		case "findAccountUI":
			action = new findAccountUI();
			break;
		case "findId":
			action = new findId();
			break;
		case "findPw":
			action = new findPw();
			break;
		case "mainUI":
			action = new mainUI();
			break;
		case "logout":
			action = new logout();
			break;
		case "addDogInfoUI":
			action = new addDogInfoUI();
			break;
		case "addDogInfo":
			action = new addDogInfo();
			break;
		case "registerDogUI":
			action = new registerDogUI();
			break;
		case "registerDog":
			action = new registerDogUI();
			break;
		case "dogHealthReportUI":
			action = new dogHealthReportUI();
			break;
		case "dogHealthReport":
			action = new dogHealthReport();
			break;
		case "albumListUI":
			action = new albumListUI();
			break;
		case "albumList":
			action = new albumList();
			break;
		case "watchAlbumUI":
			action = new watchAlbumUI();
			break;
		case "watchAlbum":
			action = new watchAlbum();
			break;
		case "supplyStatisticUI":
			action = new supplyStatisticUI();
			break;
		case "supplyStatistic":
			action = new supplyStatistic();
			break;
		}
		return action;
	}
}
