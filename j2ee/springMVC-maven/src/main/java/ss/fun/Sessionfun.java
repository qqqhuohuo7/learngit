package ss.fun;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import ss.jdbc.Signin;

public class Sessionfun {
	
	@Resource
	Signin signin;
	
	public String examSession(HttpSession ses){
		if(ses.getAttribute("status")=="in" ){
    		return "1";
    	}
		return "0";
	}
	
	public void remSession(HttpSession ses){
		ses.setAttribute("status","out");
		ses.invalidate();
	}
	
	public boolean login(String name,String passwd,HttpSession ses){
		if(signin.sign(name,passwd)){
			ses.setAttribute("status","in");
			return true;
		}
		ses.setAttribute("status","out");
		return false;
	}
}
