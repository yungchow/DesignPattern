package com.yc;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TableHeaderManage {
	public static void setColumnWidth(JTable table,DynamicShowModel model){
		TableColumn column = null;
		if(table.getColumnModel().getColumnCount()>0){
			for(int i=0;i<model.getColumnCount();i++){
				column = table.getColumnModel().getColumn(i);
				String headSt = column.getHeaderValue().toString();
				Component comp;
				int len;
				TableCellRenderer renderer = column.getHeaderRenderer();
				if(renderer == null)
					renderer = new DefaultTableCellRenderer();
				comp = renderer.getTableCellRendererComponent(table, headSt, false, false, 0, i);
				len = comp.getPreferredSize().width + 10;
				column.setPreferredWidth(len);
			}
		}
	}
}
