package frame;
import javax.swing.*;
import db.ContactDao;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
public class Login extends JFrame implements ActionListener{
    //������Ҫ�����
	JTextField jtf;               //�ı���
	JButton jb1,jb2;
	JLabel jl1,jl2;               //��ǩ
	JPasswordField jpf;           //�����
	JPanel jp1,jp2,jp3;
	
	//�������
	public Login(){
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jb1=new JButton("��¼");
		jb2=new JButton("�˳�");
		
		jl1=new JLabel("�û���:");
		jl2=new JLabel("��     ��:");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);

		//���ù�������ģʽ
		this.setLayout(new GridLayout(3,1));
		//������
		jp1.add(jl1);
		jp1.add(jtf);
		jp2.add(jl2);
		jp2.add(jpf);
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		//2����ťע�������
		jb1.addActionListener(this);
		jb2.addActionListener(this);
				
		
		this.setTitle("��¼����                                  ps����½Ȩ������ϵ����Ա");
		this.setSize(500,150);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);	
	}
	//�������Ĵ���
			public void actionPerformed(ActionEvent e){
				//������ð�ť���˳���¼����
				if(e.getSource()==jb2){
					System.exit(0);
				}
				//�����¼��ť
				if(e.getSource()==jb1){
					String name=jtf.getText();//��ȡ�ı������������
					char[] pwTmp=jpf.getPassword();//��ȡ��������������
					//��char[]����ת����String
					String pw=new String(pwTmp);
					//�Ƚ��û�������û����������Ƿ�����ݿ��userƥ��
					boolean flag=ContactDao.checkUser(name,pw);
					//�ж��û���������
					if(flag==true){
						//��¼������ʧ
						this.dispose();
						//��ʾ������
						try {
							new MainFrame();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					if(flag==false){
						JOptionPane.showMessageDialog(this, "�û������������");
					}
				}
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new Login();
	}

}
