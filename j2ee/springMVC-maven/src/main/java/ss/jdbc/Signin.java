package ss.jdbc;

import java.util.HashMap;
import java.util.Map;

public class Signin {
	private Map<String,String>signtab = new HashMap<String,String>();
	
	public Signin(){
		signtab.put("345", "password");
		signtab.put("123", "password");
	}
	public boolean sign(String name,String passwd){
		if(signtab.get(name)!=null&&signtab.get(name).equals(passwd)){
			return true;
		}
		//...
		return false;
	}
}
