import com.cg.dao.*;
import com.cg.exceptions.InsuranceException;
import com.cg.model.*;
import com.cg.utility.JdbcConnect;
public class test {

	public static void main(String[] args) throws InsuranceException {
		
		AdminDAO ob=new AdminDAO();
		UserRole obj =new UserRole("krish","msdhoni123","admin");
		int a=ob.addUser(obj);
		System.out.println(a);
		boolean f=ob.isUserExists("krish");
		boolean g=ob.isUserExists("tom");
		System.err.println(f+" "+g);
		
		
		// TODO Auto-generated method stub

	}

}
