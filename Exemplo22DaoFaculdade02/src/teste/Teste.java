package teste;

import controller.Controller;
import model.dao.postgres.DaoPostgres;
import view.View;

public class Teste {
	
	public static void main(String[] args) {
		new Controller(new DaoPostgres(), new View());
	}

}
