import java.awt.Dimension;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CollectionView extends JScrollPane{

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private Collection<Box> collection;
	public CollectionView(Collection<Box> collection,  int width, int height, String name){
		initializeTables(collection, width, height,  name);
	}
	private void initializeTables(Collection<Box> collection, int width, int height, String name)
	{
		Object[] columns = new String[]{"Name","Size"};
		model=new DefaultTableModel(columns,0);
		table=new JTable(model);
		table.setRowSelectionAllowed(false);
		this.collection=collection;
		setViewportView(table);
		setPreferredSize(new Dimension(width, height));
		setBorder(BorderFactory.createTitledBorder(name));
	}
	
	
	public void refresh(){
		model.setRowCount(0);
		for (Box r: this.collection){
			Object[] o = new String[]{r.getName(),r.getSize()};
			model.addRow(o);
		}
	}
}