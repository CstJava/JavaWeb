package com.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.service.topic.Topic;
import com.service.user.User;
import com.service.user.UserDao;
import com.service.user.Impl.UserDaoImpl;
import com.util.EmailUtil;

@MultipartConfig
public class UserServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
    
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 验证账号密码(登陆)
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userExistPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String phone = request.getParameter("phoneNum");	
		String password = request.getParameter("password");
		if(phone==null||password==null){
			out_write(response, "账号密码不能为空");
		}else{
			User user = userDao.userExist(phone,password);
			if(user==null){
				out_write(response, "账号不存在或密码错误");
			}else{
				HttpSession session = request.getSession();
				session.setAttribute("id", user);// 保存用户ID
				out_write(response, "输入正确");
			}		
		}
	}
	
	/**
	 * 验证账号是否存在
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userExist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String phone = request.getParameter("phoneNum");	
		if(phone==null){
			out_write(response, "账号不能为空");	
		}else{
			boolean b = userDao.userExist(phone);
			String tips= b? "账号存在":"账号不存在";
			out_write(response, tips);			
		}
	}
	
	/**
	 * 发送验证码到邮箱
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sentemail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email;
		String p_email = request.getParameter("email");			
		String p_email_hz = request.getParameter("email_hz");
		if(p_email==null||p_email==""){
			out_write(response, "邮箱不能为空");		
		}else{
			if(p_email_hz!=null){
				email = p_email + p_email_hz;			
			}else{
				email = p_email;								
			}
			//生成6位随机数
			String s=""+((int)(Math.random()*90000)+10000);
			
			String email_code = s; 
			EmailUtil.sendMail(email,email_code);
			request.getSession().setAttribute("email_code",email_code);		
			
			String tips = "发送验证码成功";		
			out_write(response, tips);			
		}

	}
	
	/**
	 * 验证码验证
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pword_number_emailCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String emailCode = request.getParameter("emailcode");		
		String emailcode = (String) request.getSession().getAttribute("email_code");
		if(emailCode==null){
			out_write(response,"验证码不能为空");
		}else{
			String tips = emailCode.equals(emailcode) ? "验证码正确" : "验证码错误" ;	
			out_write(response,tips);
		}
	}
	
	/**
	 * 验证验证码并注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String emailCode = request.getParameter("emailcode");		
		String emailcode = (String) request.getSession().getAttribute("email_code");
		if(emailCode==null){
			out_write(response,"验证码不能为空");
		}else{
			String tips = emailCode.equals(emailcode) ? "验证码正确" : "验证码错误" ;
			if(tips.equals("验证码正确")){
				String phoneNum=request.getParameter("phoneNum");
				if(phoneNum==null){
					out_write(response, "账号不能为空");
				}else{
					String password=request.getParameter("password");
					String passwordRepeat=request.getParameter("passwordRepeat");
					if(password==null){
						out_write(response, "密码不能为空");
					}else{
						if(passwordRepeat==null||passwordRepeat!=password){
							out_write(response, "两次密码不同");
						}else{	
							String name=request.getParameter("name");
							if(name==null||name==""){
								out_write(response, "名称不能为空");
							}else{
								String email=request.getParameter("email");
								if(email==null||email==""){
									out_write(response, "邮箱不能为空");
								}else{
									userDao.insertUser(phoneNum, password, email, name);														
								}
							}
						}
					}
					
				}
			}else{			
				out_write(response, tips);			
			}
			
		}
	}
	
	/**
	 * 验证账号邮箱是否存在
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pword_number(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String phoneNum = request.getParameter("phoneNum");		
		String email = request.getParameter("email");
		if(phoneNum==null||email==null||email==""){
			out_write(response, "账号邮箱不能为空");		
		}else{
			boolean b= userDao.userExistEmail(phoneNum, email);			
			String tips =b? "账号邮箱正确":"账号不存在或邮箱错误";
			out_write(response, tips);						
		}
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String phoneNum = request.getParameter("phoneNum");		
		String password = request.getParameter("password");		
		if(password==null||password.length()<6){
			out_write(response,"密码长度不能小于6");
		}else{
			boolean b= userDao.changePassword(phoneNum, password);	
			String tips =b? "修改成功":"修改失败";
			out_write(response, tips);						
		}
	}
	
	/**
	 * 用户退出
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userExit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();// 获取HttpSession的对象
		session.invalidate();// 销毁session
		request.getRequestDispatcher("DiaryServlet?action=listAllDiary")
				.forward(request, response);// 重定向页面
	}
	
	/**
	 * 修改头像
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updataTouxiang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			Part part = request.getPart("touxiang");//前台的文件标签的name,若ajax直接提交表单，这里无法获取  
			if(part.getContentType().contains("image")){
				String file = part.getHeader("Content-Disposition"); 
				//获取文件名  
				String fileName = file.substring(file.lastIndexOf("=")+2, file.length()-1);  
				//获取项目的部署路劲  
				String basePath = "D:\\workspace\\webWork\\WebContent\\images\\";  
				//上传文件到部署路劲  
				part.write(basePath+fileName);
				HttpSession session = request.getSession();
				String phoneNum=((User)session.getAttribute("id")).getPhoneNum();
				userDao.updataTouxiang(phoneNum,"images/"+fileName);
				((User)session.getAttribute("id")).setHeadSculptureAdd("images/"+fileName);
			}
			
		} catch (Exception e) {
		}
	}
	
	/**
	 * 修改个人资料
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updataUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String age = request.getParameter("age");
		String phoneNum = request.getParameter("phoneNum");	
		String name = request.getParameter("name");		
		String email = request.getParameter("email")+request.getParameter("email_hz");
		String sex = request.getParameter("sex");
		String introduction = request.getParameter("introduction");
		String address = request.getParameter("address");
		if(name==null||name==""){
			out_write(response, "名字不能为空");
		}else if(name.length()>10){
			out_write(response, "名字不能超过10字");
		}else if(age!=null&&Integer.parseInt(age)>1000){
			out_write(response, "请输入合法年龄");
		}else if(email==null||email==""){
			out_write(response, "邮箱不能为空");
		}else if(address!=null&&address.length()>100){
			out_write(response, "地区不能超过100字");
		}else if(introduction!=null&&introduction.length()>100){
			out_write(response, "个人介绍不能超过100字");
		}else{
			boolean b= userDao.changeUser(phoneNum, email,name,sex,Integer.parseInt(age),address,introduction);
			System.out.println();
			if(b){
				HttpSession session = request.getSession();
				User user =(User)session.getAttribute("id");
				user.setPhoneNum(phoneNum);
				user.setName(name);
				user.setAddress(address);
				user.setAge(Integer.parseInt(age));
				user.setEmail(email);
				user.setIntroduction(introduction);
				user.setSex(sex);
				session.setAttribute("id",user);
			}
			String tips =b? "修改成功":"修改失败";
			out_write(response, tips);						
		}
	}
	
	/**
	 * 回复他人信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void toOthersTopicComment(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");			
		ArrayList<HashMap<String, String>> list=userDao.toOthersTopicComment(phoneNum);	
		HttpSession session = request.getSession();
		session.setAttribute("toOthersTopicCommentList", list);
		out_write(response,""+list.size());						
	}
	
	/**
	 * 收到话题回复信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void myTopicComment(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");			
		ArrayList<HashMap<String, String>> list1=userDao.userCommentTopic(phoneNum);
		HttpSession session = request.getSession();
		session.setAttribute("userCommentTopicList", list1);	
		
		out_write(response,""+list1.size());						
	}
	
	/**
	 * 用户最近访问
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userRecentlyVisit(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");			
		Object[][] obj=userDao.userRecentlyVisitTopic(phoneNum);
		
		HttpSession session = request.getSession();
		session.setAttribute("userRecentlyVisitTopic", obj);
	
		out_write(response,""+obj.length);						
	}
	
	/**
	 * 用户收藏话题信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userCollectionTopic(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");	
		
		ArrayList<Topic> list=userDao.userCollectionTopic(phoneNum);
		HttpSession session = request.getSession();
		session.setAttribute("userCollectionTopic", list);
		
		out_write(response,""+list.size());						
	}
	
	/**
	 * 获取关注人的信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userConcernUser(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");		
		ArrayList<User> list=userDao.userConcernUser(phoneNum);
		HttpSession session = request.getSession();
		session.setAttribute(phoneNum+"ConcernUserList", list);
			
		out_write(response,""+list.size());	 					
	}
	
	
	/**
	 * 获取粉丝信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userFans(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");		
		ArrayList<User> list=userDao.userFans(phoneNum);
		HttpSession session = request.getSession();
		session.setAttribute(phoneNum+"FansList", list);			
		out_write(response,""+list.size());						
	}
	
	
	/**
	 * 添加关注
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void concernTopicUser(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");		
		String beConcerner= request.getParameter("beConcerner");
		boolean b=userDao.deleteUserConcernUser(phoneNum,beConcerner);
		String tips= b?"取消成功":"取消失败";
		if(b){
			HttpSession session = request.getSession();
			((User)session.getAttribute("id")).setGuanzhu(((User)session.getAttribute("id")).getGuanzhu()-1);
		}
		out_write(response,tips);						
	}
	/**
	 * 取消关注
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void deleteUserConcernUser(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");		
		String beConcerner= request.getParameter("beConcerner");
		boolean b=userDao.deleteUserConcernUser(phoneNum,beConcerner);
		String tips= b?"取消成功":"取消失败";
		if(b){
			HttpSession session = request.getSession();
			((User)session.getAttribute("id")).setGuanzhu(((User)session.getAttribute("id")).getGuanzhu()-1);
		}
		out_write(response,tips);						
	}
	
	/**
	 * 取消粉丝
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void deleteUserFans(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");		
		String concerner= request.getParameter("concerner");
		boolean b=userDao.deleteUserFans(phoneNum,concerner);
		String tips= b?"取消成功":"取消失败";
		if(b){
			HttpSession session = request.getSession();
			((User)session.getAttribute("id")).setFans(((User)session.getAttribute("id")).getFans()-1);
		}
		out_write(response,tips);						
	}
	
	/**
	 * 获取好友信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void userFriends(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		String phoneNum = request.getParameter("phoneNum");		
		User user=userDao.userFriends(phoneNum);
		HttpSession session= request.getSession();
		session.setAttribute(phoneNum, user);
		out_write(response,phoneNum);							
	}
	
	/**
	 * 判断关系
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void getRelation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session= request.getSession();
		String phoneNum = ((User)session.getAttribute("id")).getPhoneNum();
		String othersPhoneNum = request.getParameter("phoneNum");
		String tips;
		if(!phoneNum.equals(othersPhoneNum)){
			boolean b=userDao.getRelation(phoneNum, othersPhoneNum);
			tips =b? "取消关注":"关注好友";			
		}else{
			tips="本人";
		}
		out_write(response,tips);										
	}
	
	/**
	 * 设置好友关系
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void setRelation(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session= request.getSession();
		String phoneNum = ((User)session.getAttribute("id")).getPhoneNum();
		String othersPhoneNum = request.getParameter("phoneNum");	
		String relation = request.getParameter("relation");
		String tips;
		//用户判断关系，如果已关注为true，还未关注为false
		boolean b;  
		if(relation.equals("取消关注")){
			b=true;
		}else{
			b=false;
		}
		if(!relation.equals("本人")){
			boolean result=userDao.setRelation(phoneNum, othersPhoneNum,b);
			if(b){
				tips =result? "取消成功":"取消失败";			
			}else{
				tips =result? "关注成功":"关注失败";
			}			
		}else{
			tips="本人";
		}
		out_write(response,tips);							
	}
	
	/**
	 * 搜索用户
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		//下标奇数表示用户信息，偶数表示话题信息
		ArrayList<User> list=userDao.selectUser(name);
		session.setAttribute("selectUserList", list);	
	}
}
