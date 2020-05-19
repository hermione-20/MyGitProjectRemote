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
	
	//-----------��������ѯ-------------------
	private String isUpload;
	public String findUserByCondition() {
		users=service.findUserByCondition(user.getUserName(), user.getGender(),user.getEducation(), isUpload);
		return SUCCESS;
	}
	
	//---------�༭�û�------------------
	
	public String edit() {
		//�ж��û��Ƿ��ϴ����ļ�
		if(upload==null) {
			//�û�û���ϴ��ļ�������ԭ����
			User dbUser=service.findUserById(user.getUserID());//�����û�id���û������
			//����û��ѡ���ļ���userģ���е�filename��path��ΪNull,������Ҫ�ò�������û���ֵ�滻��
			user.setFilename(dbUser.getFilename());
			user.setPath(dbUser.getPath());
			int res=service.modifyUser(user);
			if(res>0) {
				return SUCCESS;
			}
			
		}else {
			//�û��ϴ����ļ�
			//1.�����ļ���·��
			String filePath=ServletActionContext.getServletContext().getRealPath("/files");
			String dir=generateChildPath(filePath);
			
			//2.���ɴ�������Ե��ļ���
			String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;
			
			//3.��userģ����ȱ�ٵ���������ȥ
			user.setPath(dir);
			user.setFilename(fileName);//������ļ��������Ǵ���GUID���ļ��������ص�ʱ����
			//4.�ϴ��ļ�����
			upload.renameTo(new File(filePath+File.separator+dir,fileName));
			//5.�����û�
			int res=service.modifyUser(user);
			if(res>0) {
			return SUCCESS;
		}
		}
		return null;
	}
	
	
	
	
	//-------------��ʾ�༭�û�����-----------
	public String editUI() {
		user=service.findUserById(user.getUserID());
		//��user����ѹ��ջ��
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	//-----------ɾ���û�-------------------
	public String delete() {
		int res=service.removeUser(user.getUserID());
		if(res>0) {
		return SUCCESS;
	}
		return null;
	}
	
	//-------------�ļ�����-------------------
	private InputStream inputStream;
	private String oldFileName;//ԭʼ�ļ���
	public String download() throws Exception {
		//1.��ȡ�û���Ϣ
		User dbUser=service.findUserById(user.getUserID());
		//2.�ļ���ŵ�·��
		String filePath=ServletActionContext.getServletContext().getRealPath("/files");
		//��ԭʼ�ļ���ֵ
		oldFileName=dbUser.getFilename().substring(dbUser.getFilename().indexOf("_")+1);
		//3.���ֽ���������ֵ
		inputStream=new FileInputStream(filePath+File.separator+dbUser.getPath()+File.separator+dbUser.getFilename());
		//4.���سɹ�
		return SUCCESS;
		//5.ʣ�µĽ���stream�����ͼ��
	}
	
	//----------�鿴�û���ϸ��Ϣ-----------------
	
	public String findUserById() {
		//����userID��ȡuser����
		user=service.findUserById(user.getUserID());
		//��user����ѹ��ջ��
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}
	
	
	//--------��ѯ�����û�---------
	//���ڴ�����в�ѯ�������û�
	private List<User> users;
	public String findAll() {
		users=service.findAllUser();
		return SUCCESS;
	}
	
	//------�����û�------
	//�����û���file
	private File upload;
	//�ļ���
	private String uploadFileName;
	public String add() {
		//1.�����ļ���·��
		String filePath=ServletActionContext.getServletContext().getRealPath("/files");
		String dir=generateChildPath(filePath);
		
		//2.���ɴ�������Ե��ļ���
		String fileName=TokenHelper.generateGUID()+"_"+uploadFileName;
		
		//3.��userģ����ȱ�ٵ���������ȥ
		user.setPath(dir);
		user.setFilename(fileName);//������ļ��������Ǵ���GUID���ļ��������ص�ʱ����
		//4.�ϴ��ļ�����
		upload.renameTo(new File(filePath+File.separator+dir,fileName));
		//5.�����û�
		int res=service.saveUser(user);
		if(res>0) {
		return SUCCESS;
	}
		return null;
	}
	//������"yyyy-MM-dd"��ʽ�������ļ���
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

	//-------�û���¼�Ķ�������-------
	public String login() {
		User dbUser=service.login(user.getLogonName(), user.getLogonPwd());
		//�жϲ鵽���û�û��
		if(dbUser==null) {
			addActionError("�û������ڣ������û��������벻ƥ��");
			return "input";
		}
		//��½�ɹ�
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