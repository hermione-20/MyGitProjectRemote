package com.itheima.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.ActionError;
import org.apache.struts2.util.TokenHelper;

import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private IUserService service=new UserServiceImpl();
	private User user=new User();

	
	public User getModel() {
		return user;
	}
	
	//-----------多条件查询-------------------
	private String isUpload;
	public String findUserByCondition() {
		users=service.findUserByCondition(user.getUserName(), user.getGender(),user.getEducation(), isUpload);
		return SUCCESS;
	}
	
	//---------编辑用户------------------
	
	public String edit() {
		//判断用户是否上传了文件
		if(upload==null) {
			//用户没有上传文件，还用原来的
			User dbUser=service.findUserById(user.getUserID());//根据用户id把用户查出来
			//由于没有选择文件，user模型中的filename和path都为Null,我们需要用查出来的用户的值替换；
			user.setFilename(dbUser.getFilename());
			user.setPath(dbUser.getPath());
			int res=service.modifyUser(user);
			if(res>0) {
				return SUCCESS;
			}
			
		}else {
			//用户上传了文件
			//1.保存文件的路径
			String filePath=ServletActionContext.getServletContext().getRealPath("/files");
			String dir=generateChildPath(filePath);
			
			//2.生成带有随机性的文件名
			String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;
			
			//3.把user模型中缺少的数据填充进去
			user.setPath(dir);
			user.setFilename(fileName);//保存的文件名必须是带有GUID的文件名，下载的时候用
			//4.上传文件操作
			upload.renameTo(new File(filePath+File.separator+dir,fileName));
			//5.保存用户
			int res=service.modifyUser(user);
			if(res>0) {
			return SUCCESS;
		}
		}
		return null;
	}
	
	
	
	
	//-------------显示编辑用户界面-----------
	public String editUI() {
		user=service.findUserById(user.getUserID());
		//把user对象压入栈顶
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	//-----------删除用户-------------------
	public String delete() {
		int res=service.removeUser(user.getUserID());
		if(res>0) {
		return SUCCESS;
	}
		return null;
	}
	
	//-------------文件下载-------------------
	private InputStream inputStream;
	private String oldFileName;//原始文件名
	public String download() throws Exception {
		//1.获取用户信息
		User dbUser=service.findUserById(user.getUserID());
		//2.文件存放的路径
		String filePath=ServletActionContext.getServletContext().getRealPath("/files");
		//给原始文件赋值
		oldFileName=dbUser.getFilename().substring(dbUser.getFilename().indexOf("_")+1);
		//3.给字节输入流赋值
		inputStream=new FileInputStream(filePath+File.separator+dbUser.getPath()+File.separator+dbUser.getFilename());
		//4.返回成功
		return SUCCESS;
		//5.剩下的交给stream结果视图；
	}
	
	//----------查看用户详细信息-----------------
	
	public String findUserById() {
		//根据userID获取user对象
		user=service.findUserById(user.getUserID());
		//把user对象压入栈顶
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	
	
	//--------查询所有用户---------
	//用于存放所有查询出来的用户
	private List<User> users;
	public String findAll() {
		users=service.findAllUser();
		return SUCCESS;
	}
	
	//------添加用户------
	//保存用户的file
	private File upload;
	//文件名
	private String uploadFileName;
	public String add() {
		//1.保存文件的路径
		String filePath=ServletActionContext.getServletContext().getRealPath("/files");
		String dir=generateChildPath(filePath);
		
		//2.生成带有随机性的文件名
		String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;
		
		//3.把user模型中缺少的数据填充进去
		user.setPath(dir);
		user.setFilename(fileName);//保存的文件名必须是带有GUID的文件名，下载的时候用
		//4.上传文件操作
		upload.renameTo(new File(filePath+File.separator+dir,fileName));
		//5.保存用户
		int res=service.saveUser(user);
		if(res>0) {
		return SUCCESS;
	}
		return null;
	}
	//生成以"yyyy-MM-dd"格式命名的文件夹
	private String generateChildPath(String filePath) {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String dir=format.format(date);
		File file=new File(filePath,dir);
		if(!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	//-------用户登录的动作方法-------
	public String login() {
		User dbUser=service.login(user.getLogonName(), user.getLogonPwd());
		//判断查到了用户没有
		if(dbUser==null) {
			addActionError("用户不存在，或者用户名与密码不匹配");
			return "input";
		}
		//登陆成功
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		return SUCCESS;
	}
	
	

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public InputStream getInputstream() {
		return inputStream;
	}

	public void setInputstream(InputStream inputstream) {
		this.inputStream = inputstream;
	}

	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	
	

}
