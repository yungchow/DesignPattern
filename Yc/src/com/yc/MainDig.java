package com.yc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MainDig extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JButton jButton = null;
	private JTable jTable = null;
	public DynamicShowModel model = null;
	private JScrollPane jScrollPane = null;
	private Vector title = new Vector();  //  @jve:decl-index=0:
	
	/**
	 * This is the default constructor
	 */
	public MainDig() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		query();
	}

	private void query() {
		if(model == null){
			model = new DynamicShowModel();
		}
		Entity e1 = new Entity("1","张三","男","18");
		Entity e2 = new Entity("2","李四","女","19");
		Entity e3 = new Entity("3","王五","男","20");
		Vector list = new Vector<Entity>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		model.setData(list);
		getJTable().setModel(model);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJButton(), BorderLayout.NORTH);
			jContentPane.add(getJScrollPane(),BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private Component getJScrollPane() {
		if(jScrollPane == null){
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("setting");
			//此处不用单击事件，因为设置按钮为false后依然可以用
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EditTableColumn table = new EditTableColumn(MainDig.this);
					table.setVisible(true);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	public JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			if(model == null){
				model = new DynamicShowModel();
			}
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			JTableHeader header = jTable.getTableHeader();
			header.setReorderingAllowed(false);
		}
		return jTable;
	}
	
	public static void main(String[] args) {
		MainDig main = new MainDig();
		main.setVisible(true);
	}

}
