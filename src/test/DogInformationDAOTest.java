package test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dogCare.db.dao.ConnectionManager;
import dogCare.db.dao.DogInformationDAO;
import dogCare.db.dao.DogInformationDAOImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DogInformationDAOTest {
	DogInformationDAO dao;
	int temp;
	
	@Test
	@Order(1)
	@DisplayName("Connection 생성됨")
	void connectionTest() throws ClassNotFoundException, SQLException {
		assertThat(ConnectionManager.getConnection()).isNotNull(); 	
	}
	
	@Test
	@Order(2)
	@DisplayName("Connection 생성됨")
	void CRUDTest() throws ClassNotFoundException, SQLException{
		dao = new DogInformationDAOImpl();
		
		dao.addDogInfo(1, null);
	}
	

}
