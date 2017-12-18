package com.example.myapplication.PhysicalArchitecture;

import android.os.Handler;
import android.util.Log;

import com.example.myapplication.Constants;

import java.util.ArrayList;

import static com.example.myapplication.PhysicalArchitecture.Client.*;


public class ClientControl {
	
	private Client client;
	private ArrayList<String> SList;
	private ArrayList<String> CList;
	private int userState = Constants.NONE;

	private Handler mainHandler, main2Handler, ChattingHandler, OrderHandler;

	public ClientControl(Client client)
	{
		this.client = client;
		SList = new ArrayList<String>();
		CList = new ArrayList<String>();
	}	
	
	//////////test
	public void setUserState(int userState) {
		this.userState = userState;
	}
	
	public int getUserState() {
		return userState;
	}

	public void addString(String string)
	{
		SList.add(string);
	}

	public ArrayList<String> getSList() {
		return SList;
	}
	
	public ArrayList<String> getCList() {
		return CList;
	}
	
	void handleMsg(String msg) {
		System.out.println("받은 메시지 : " + msg);
		
		if (msg.startsWith("#cmd%fin")) {//
			switch(userState) {
				case START : // 앱 처음 실행 상태. 현재 위치 GPS 좌표를 서버로 보낸 뒤 응답이 오면
					userState = NONE;	// TODO 앱 진행 가능하도록!!
					break;
				case WAIT_MATCHING: // 방을 만들어서 다른 사용자를 기다리거나 매칭 대기중일 때 서버에서 매칭이 되어 응답이 오면
					client.clientW.sendToServer("#cmd%entrance");	// 서버에 채팅방 입장 명령을 보냄
					userState = ENTRANCE;								// 채팅방 입장 대기 상태로 전환
					break;
				case MAKE_ROOM:	// 서버로 방을 만든다고 요청을 했을 때 서버에서 응답이 오면
					userState = WAIT_MATCHING;
					// TODO 채팅방 액티비티!!!! 다른 사용자 들어오는거 기다리기!
				case ENTRANCE:		// 채팅방 입장 대기 상태일 때 서버에서 응답이 오면
					// TODO 채팅방 액티비티!!!! 채팅시작. 만약에 이미 채팅방에 있을 경우, 사용자 입장만 알리기.
					userState = CHATTING;	// 채팅중 상태로 전환

					break;
				case SELECT_MENU:
				case CHECK_MENU:
				case COMPLETE_ORDER:
			}
		} else if (msg.startsWith("#cmd%fail")) {
			switch(userState) {
				case WAIT_MATCHING:
					break;
				case SHOWROOMLIST:
					break;
				case ENTRANCE:
					break;
				case SELECT_MENU:
				case CHECK_MENU:
				case COMPLETE_ORDER:
			}
		} else if (msg.startsWith("#cmd%err")) {
			
		} else if (msg.startsWith("#chat")) {
			CList.add(msg.substring(6));
		}
		SList.remove(0);
	}

	/////////////////////////////////

	// 앱 시작할때 현재 사용자 위치를 서버로 보냄.
	public void start(double a, double b){
		String s = "#start%";
		s += a;
		s += "%";
		s += b;

		client.sendToServer(s);
	}

	// 매칭 시작. 변수는 매칭할때 선택한 옵션. (ex : 카테고리..브랜드..메뉴)
	public void search(int... is){
		if(is.length > 3) {
			Log.d("err", "wrong parameter in search(int...)");
			return;
		}

		String s = "#search";
		for(int i : is){
			s += "%";
			s += i;
		}

		client.sendToServer(s);
		userState = WAIT_MATCHING;
	}

	public void makeRoom(){
		String s = "#makeroom";

		client.sendToServer(s);
		userState = MAKE_ROOM;
	}

	public void makeRoom(int... is){
		if(is.length > 3) {
			Log.d("err", "wrong parameter in makeRoom(int...)");
			return;
		}

		String s = "#makeroom";
		for(int i : is){
			s += "%";
			s += i;
		}

		client.sendToServer(s);
		userState = MAKE_ROOM;
	}

	public void showRoomList(){
		String s = "#showroomlist";

		client.sendToServer(s);
		userState = SHOWROOMLIST;
	}

	public void showRoomList(int... is){
		if(is.length > 3) {
			Log.d("err", "wrong parameter in showRoomList(int...)");
			return;
		}

		String s = "#showroomlist";
		for(int i : is){
			s += "%";
			s += i;
		}

		client.sendToServer(s);
		userState = SHOWROOMLIST;
	}

	public void selectMenu(int category, int brand, int menu){
		String s = "#selectmenu%";
		s += category;
		s += "%";
		s += brand;
		s += "%";
		s += menu;

		client.sendToServer(s);
		userState = SELECT_MENU;
	}

	public void checkMenu(){
		String s = "#checkmenu";

		client.sendToServer(s);
		userState = CHECK_MENU;
	}

	public void checkDeposit(){
		String s = "#checkdeposit";

		client.sendToServer(s);
		userState = COMPLETE_ORDER;
	}

	public void orderTrace(){
		String s = "#ordertrace";

		client.sendToServer(s);
		userState = TRACE_ORDER;
	}

	///////////////////////////////////


	public Handler getMainHandler() {
		return mainHandler;
	}

	public void setMainHandler(Handler mainHandler) {
		this.mainHandler = mainHandler;
	}

	public Handler getMain2Handler() {
		return main2Handler;
	}

	public void setMain2Handler(Handler main2Handler) {
		this.main2Handler = main2Handler;
	}

	public Handler getChattingHandler() {
		return ChattingHandler;
	}

	public void setChattingHandler(Handler chattingHandler) {
		ChattingHandler = chattingHandler;
	}

	public Handler getOrderHandler() {
		return OrderHandler;
	}

	public void setOrderHandler(Handler orderHandler) {
		OrderHandler = orderHandler;
	}
}