package frame;
import java.awt.*;
import java.awt.event.*;import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;

import db.ContactDao;


public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JMenuBar menubar = new JMenuBar();
	JMenu m_contactManager = new JMenu("��ϵ�˹���");
	JMenu m_systemManager = new JMenu("ϵͳ����");
	JMenuItem mi_query = new JMenuItem("������ϵ��");
	JMenuItem mi_insert = new JMenuItem("�����ϵ��");
	JMenuItem mi_modify = new JMenuItem("�޸���ϵ��");
	JMenuItem mi_delete = new JMenuItem("ɾ����ϵ��");
	JMenuItem mi_exit = new JMenuItem("�˳�ϵͳ");
	
	JToolBar toolbar = new JToolBar();
	JButton b_qry = new JButton(new ImageIcon("imgs/search.png"));
	JButton b_ins = new JButton(new ImageIcon("imgs/input.png"));
	JButton b_upd = new JButton(new ImageIcon("imgs/update.png"));
	JButton b_del = new JButton(new ImageIcon("imgs/delete.png"));
	JButton b_exit = new JButton(new ImageIcon("imgs/exit.png"));
	//JLabel l_img = new JLabel(new ImageIcon("imgs/img.jpg"));
	
	
	//��ʼ������
	public MainFrame() throws SQLException {
		Vector a=new Vector();
		a.add("����");
		a.add("�Ա�");
		a.add("����");
		a.add("�ֻ�����");
		a.add("����");
		a.add("΢�ź�");
		a.add("QQ����");
		Vector b=new Vector();
		//String[] colNames=new String[]{"����","�Ա�","����","�ֻ�����","����","΢�ź�","QQ����"};
		//String[][] datas={{"����","��","24","1111111","asdasd@qq.com","asdasddfg","55554313"},{"����","��","24","1111111","asdasd@qq.com","asdasddfg","55554313"},{"����","��","24","1111111","asdasd@qq.com","asdasddfg","55554313"},{"����","��","24","1111111","asdasd@qq.com","asdasddfg","55554313"},{"����","��","24","1111111","asdasd@qq.com","asdasddfg","55554313"}};
		//super("��ϵ�˹���");
		ResultSet n=ContactDao.getAllContacts();
		while(n.next()) {
			Vector k=new Vector();
			k.add(n.getString(1));
			k.add(n.getString(2));
			k.add(n.getString(3));
			k.add(n.getString(4));
			k.add(n.getString(5));
			k.add(n.getString(6));
			k.add(n.getString(7));
			b.add(k);
		}
		JTable table=new JTable(b,a);
		JScrollPane sp=new JScrollPane(table);
		
		
		this.add(sp);
		
		this.buildMenuBar();
		this.setJMenuBar(menubar);		
		this.buildToolBar();		
		Container c = this.getContentPane();		
		c.add(toolbar, BorderLayout.NORTH);
		//c.add(l_img, BorderLayout.CENTER);
		this.setBounds(200,100,1000, 200);
		this.setTitle("��ϵ�˹���ϵͳ");
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		

		// ���ò˵����ݼ�
		mi_query.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_MASK, false));
		mi_insert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				InputEvent.CTRL_MASK, false));
		mi_modify.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.CTRL_MASK, false));
		mi_delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				InputEvent.CTRL_MASK, false));
		mi_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				InputEvent.CTRL_MASK, false));

		//ע�������
		mi_query.addActionListener(this);
		mi_insert.addActionListener(this);
		mi_modify.addActionListener(this);
		mi_delete.addActionListener(this);
		mi_exit.addActionListener(this);
		
		b_qry.addActionListener(this);
		b_ins.addActionListener(this);
		b_upd.addActionListener(this);
		b_del.addActionListener(this);
		b_exit.addActionListener(this);

	}

	// �����˵�
	void buildMenuBar() {
		menubar.add(m_contactManager);
		menubar.add(m_systemManager);
		m_contactManager.add(mi_query);
		m_contactManager.add(mi_insert);
		m_contactManager.add(mi_modify);
		m_contactManager.add(mi_delete);
		m_systemManager.add(mi_exit);
	}
	
	//����������
	void buildToolBar() {
		toolbar.setFloatable(false);
		toolbar.add(b_qry);
		toolbar.addSeparator();
		toolbar.add(b_ins);
		toolbar.add(b_upd);
		toolbar.add(b_del);
		toolbar.addSeparator();
		toolbar.add(b_exit);
		b_qry.setToolTipText("������ϵ��");
		b_ins.setToolTipText("�����ϵ��");
		b_upd.setToolTipText("�޸���ϵ��");
		b_del.setToolTipText("ɾ����ϵ��");
		b_exit.setToolTipText("�˳�ϵͳ");
	}

	//�¼�����
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//�˳�
		if (src == mi_exit  || src==b_exit) {
			System.exit(0);
		}
		//����
		if (src == mi_query || src==b_qry) {
			 new QueryContactFrame();
		}
		//���
		if (src == mi_insert || src==b_ins) {
			new InsertContactFrame();
		}		
		//�޸�
		if (src == mi_modify || src==b_upd) {
			new ModifyContactFrame();
		}
		//ɾ��
		if (src == mi_delete || src==b_del) {			
			new DeleteContactFrame();
		}
	}
}


