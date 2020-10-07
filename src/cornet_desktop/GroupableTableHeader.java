/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cornet_desktop;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

 

/**
  * GroupableTableHeader
  *
  * @version 1.0 10/20/98
  * @author Nobuo Tamemasa
  */

public class GroupableTableHeader extends JTableHeader {
  private static final String uiClassID = "GroupableTableHeaderUI";
  protected Vector columnGroups = null;
    
  public GroupableTableHeader(TableColumnModel model) {
    super(model);
    setUI(new GroupableTableHeaderUI());
    setReorderingAllowed(false);
  }
  public void updateUI(){
   setUI(new GroupableTableHeaderUI());
  }
  
  public void setReorderingAllowed(boolean b) {
    reorderingAllowed = false;
  }
    
  public void addColumnGroup(ColumnGroup g) {
    if (columnGroups == null) {
      columnGroups = new Vector();
    }
    columnGroups.addElement(g);
  }

  public Enumeration getColumnGroups(TableColumn col) {
    if (columnGroups == null) return null;
    Enumeration e = columnGroups.elements();
    while (e.hasMoreElements()) {
      ColumnGroup cGroup = (ColumnGroup)e.nextElement();
      Vector v_ret = (Vector)cGroup.getColumnGroups(col,new Vector());
      if (v_ret != null) { 
  return v_ret.elements();
      }
    }
    return null;
  }
  
  public void setColumnMargin() {
    if (columnGroups == null) return;
    int columnMargin = getColumnModel().getColumnMargin();
    Enumeration e = columnGroups.elements();
    while (e.hasMoreElements()) {
      ColumnGroup cGroup = (ColumnGroup)e.nextElement();
      cGroup.setColumnMargin(columnMargin);
    }
  }
  
}

/**
  * ColumnGroup
  *
  * @version 1.0 10/20/98
  * @author Nobuo Tamemasa
  */
 
class ColumnGroup {
  protected TableCellRenderer renderer;
  protected Vector v;
  protected String text;
  protected int margin=0;

  public ColumnGroup(String text) {
    this(null,text);
  }

  public ColumnGroup(TableCellRenderer renderer,String text) {
    if (renderer == null) {
      this.renderer = new DefaultTableCellRenderer() {
  public Component getTableCellRendererComponent(JTable table, Object value,
                         boolean isSelected, boolean hasFocus, int row, int column) {
    JTableHeader header = table.getTableHeader();
    if (header != null) {
      setForeground(header.getForeground());
      setBackground(header.getBackground());
      setFont(header.getFont());
    }
          setHorizontalAlignment(JLabel.CENTER);
          setText((value == null) ? "" : value.toString());
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    return this;
        }
      };
    } else {
      this.renderer = renderer;
    }
    this.text = text;
    v = new Vector();
  }

  
  /**
   * @param obj    TableColumn or ColumnGroup
   */
  public void add(Object obj) {
    if (obj == null) { return; }
    v.addElement(obj);
  }

  
  /**
   * @param c    TableColumn
   * @param v    ColumnGroups
   */
  public Vector getColumnGroups(TableColumn c, Vector g) {
    g.addElement(this);
    if (v.contains(c)) return g;    
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      Object obj = e.nextElement();
      if (obj instanceof ColumnGroup) {
        Vector groups = 
          (Vector)((ColumnGroup)obj).getColumnGroups(c,(Vector)g.clone());
        if (groups != null) return groups;
      }
    }
    return null;
  }
    
  public TableCellRenderer getHeaderRenderer() {
    return renderer;
  }
    
  public void setHeaderRenderer(TableCellRenderer renderer) {
    if (renderer != null) {
      this.renderer = renderer;
    }
  }
    
  public Object getHeaderValue() {
    return text;
  }
  
  public Dimension getSize(JTable table) {
    Component comp = renderer.getTableCellRendererComponent(
        table, getHeaderValue(), false, false,-1, -1);
    int height = comp.getPreferredSize().height; 
    int width  = 0;
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      Object obj = e.nextElement();
      if (obj instanceof TableColumn) {
        TableColumn aColumn = (TableColumn)obj;
        width += aColumn.getWidth();
        width += margin;
      } else {
        width += ((ColumnGroup)obj).getSize(table).width;
      }
    }
    return new Dimension(width, height);
  }

  public void setColumnMargin(int margin) {
    this.margin = margin;
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      Object obj = e.nextElement();
      if (obj instanceof ColumnGroup) {
        ((ColumnGroup)obj).setColumnMargin(margin);
      }
    }
  }
}
