package teste;

import controller.Controller;
import model.Dao;
import model.dao_postgre.DaoPostgre;
import view.View;
import view.view_default.ViewDefault;

public class Teste {
	
	public static void main(String[] args) {
		Dao model = new DaoPostgre();
		View view = new ViewDefault();
		Controller controller = new Controller(model, view);
		controller.init();
	}

}
