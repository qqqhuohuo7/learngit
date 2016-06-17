package ss.ctl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ss.fun.Sessionfun;

@Controller
@RequestMapping("/test")
public class LoginController {
	
	@Resource
	Sessionfun sessionfun;
	
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
	
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request,HttpServletResponse response){
    	HttpSession sess = request.getSession(true);
    	String name = request.getParameter("name");
    	String passwd = request.getParameter("passwd");
    	
    	if(sessionfun.login(name, passwd,sess)){
    		System.out.print("\nsign Info:::name='"+name+"'");
        	System.out.print("\n"+df.format(new Date())+"_login   session ID:::"+sess.getId());
        	
        	
            return "login success~~";//+URLEncoder.encode(name, "utf-8");
    	}else
    		return "login failed!!";
    }
    
    @RequestMapping("/exam")
    @ResponseBody
    public String exam(HttpServletRequest request,HttpServletResponse response){
    	HttpSession sess = request.getSession(true);
    	return sessionfun.examSession(sess);
    }
    
    @RequestMapping("/logout")
    @ResponseBody
    public void logout(HttpServletRequest request,HttpServletResponse response){
    	HttpSession sess = request.getSession(true);
    	if(sess.getAttribute("status")=="in" ){
        	System.out.print("\n"+df.format(new Date())+"_logout  session ID:::"+sess.getId());
        	sessionfun.remSession(sess);
    	}
    }
    
    public String logStatus(HttpSession ses){
    	if(ses.getAttribute("status")=="in" ){
    		return "welcome~ status:in";
    	}
		return "outside~ status:out";
	}
}