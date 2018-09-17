package frame;
import javax.swing.*;
import db.ContactDao;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
public class Login extends JFrame implements ActionListener{
    //定义需要的组件
	JTextField jtf;               //文本框
	JButton jb1,jb2;
	JLabel jl1,jl2;               //标签
	JPasswordField jpf;           //密码框
	JPanel jp1,jp2,jp3;
	
	//创建组件
	public Login(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("登录");
		jb2=new JButton("退出");
		
		jl1=new JLabel("用户名:");
		jl2=new JLabel("密     码:");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);

		//设置管理器的模式
		this.setLayout(new GridLayout(3,1));
		//添加组件
		jp1.add(jl1);
		jp1.add(jtf);
		jp2.add(jl2);
		jp2.add(jpf);
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//2个按钮注册监听器
		jb1.addActionListener(this);
		jb2.addActionListener(this);
				
		
		this.setTitle("登录界面                                  ps：登陆权限请联系管理员");
		this.setSize(500,150);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);	
	}
	//监听器的处理
			public void actionPerformed(ActionEvent e){
				//点击重置按钮，退出登录界面
				if(e.getSource()==jb2){
					System.exit(0);
				}
				//点击登录按钮
				if(e.getSource()==jb1){
					String name=jtf.getText();//获取文本框输入的内容
					char[] pwTmp=jpf.getPassword();//获取密码框输入的内容
					//把char[]数组转换成String
					String pw=new String(pwTmp);
					//比较用户输入的用户名跟密码是否跟数据库表user匹配
					boolean flag=ContactDao.checkUser(name,pw);
					//判断用户名和密码
					if(flag==true){
						//登录界面消失
						this.dispose();
						//显示主界面
						try {
							new MainFrame();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(flag==false){
						JOptionPane.showMessageDialog(this, "用户名或密码错误！");
					}
				}
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Login();
	}

}
