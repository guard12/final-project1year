package DBLayer;


public class DBConnectionTest {
	public void test() {
		DBConnection dbCon = DBConnection.getInstance();
		if(dbCon != null)
		{
			System.out.println("Connection to DB is ok");
		}
		else{
			System.out.println("Can not connect to the DB");
		}
	}
}
