package main;

import controllers.Controllers;

public class Main {

	public static void main(String[] args) {
		
		new Controllers();
		Controllers.getLoginController().requestLoginMenu();

	}

}
