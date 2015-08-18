/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.budthapa.jts.view.media;

import com.budthapa.jts.business.MediaHouseBL;
import com.budthapa.jts.model.MediaHouseBean;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author budthapa
 */
public class ViewMediaHouse extends javax.swing.JInternalFrame {

    private MediaHouseBL media;
    private MediaHouseBean mediaBean;
    public static DefaultTableModel table;
    private String setStatus;
    private String setStatusNews;
    private String setStatusTv;
    private String setStatusRadio;
    private String setStatusOnline;
    private String setStatusMagazine;

    /**
     * Creates new form ViewMediaHouse
     */
    public ViewMediaHouse() {
        initComponents();
        setVisible(true);
        media = new MediaHouseBL();
        mediaBean = new MediaHouseBean();
        //bring table data from media
        initialiseTableAndFillWithData();

    }

    public void refreshTable(){
        initialiseTableAndFillWithData();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewClientsTable = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("View list of Media House");

        viewClientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viewClientsTable.setToolTipText("Double Click to Edit or Delete this row.");
        viewClientsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewClientsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(viewClientsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initialiseTableAndFillWithData() {
        //initialise table and set editable to false
        table = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        List<MediaHouseBean> mediaList = media.getMediaHouseList();
        //column name is compulsary, if not added, added rows will not be displayed
        table.addColumn("S.No");
        table.addColumn("Name");
        table.addColumn("Email");
        table.addColumn("Contact Person");
        table.addColumn("Contact Number");
        table.addColumn("Fax");
        table.addColumn("Newspaper");
        table.addColumn("Television");
        table.addColumn("Radio");
        table.addColumn("Online");
        table.addColumn("Magazine");
        table.addColumn("Others");
        table.addColumn("Media Address");

        for (MediaHouseBean mediaList1 : mediaList) {
            setStatusNews=mediaList1.isNewspaper()?"Yes":"No";
            setStatusTv=mediaList1.isTelevision()?"Yes":"No";
            setStatusRadio=mediaList1.isRadio()?"Yes":"No";
            setStatusOnline=mediaList1.isOnline()?"Yes":"No";
            setStatusMagazine=mediaList1.isMagazine()?"Yes":"No";
            
            
            //create dynamic row
            Object[] rowData = {mediaList1.getMediaId(), mediaList1.getMediaName(), mediaList1.getMediaEmail(), mediaList1.getMediaContactPerson(), 
                mediaList1.getMediaContactNumber(), mediaList1.getMediaFax(), setStatusNews, setStatusTv, setStatusRadio,setStatusOnline, setStatusMagazine, 
                mediaList1.getOtherMedia(), mediaList1.getMediaAddress()};
            table.addRow(rowData);
        }
        viewClientsTable.setModel(table);

    }

    private void viewClientsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewClientsTableMouseClicked

        int id;
        String name;
        String type;
        String email;
        String contactPerson;
        String contactNumber;
        String fax;
        String address;
        Boolean newspaper;
        Boolean tv;
        Boolean radio;
        Boolean online;
        Boolean magazine;
        String others;

        //if user click twice in a row
        if (evt.getClickCount() == 2) {
            JTable table = (JTable) evt.getSource();
            int selectedRow = table.getSelectedRow();
//            int columnCount = table.getColumnCount(); //count the number of rows
//            System.out.println("column count "+columnCount);
            int counter=0;
            //get the items from the row starting from column index 0 to column max size;

            id = (int) table.getValueAt(selectedRow, counter);
            name = (String) table.getValueAt(selectedRow, ++counter);
            email = (String) table.getValueAt(selectedRow, ++counter);
            contactPerson = (String) table.getValueAt(selectedRow, ++counter);
            contactNumber = (String) table.getValueAt(selectedRow, ++counter);
            fax = (String) table.getValueAt(selectedRow, ++counter);
            newspaper = (Boolean) table.getValueAt(selectedRow, ++counter);
            tv = (Boolean) table.getValueAt(selectedRow, ++counter);
            radio = (Boolean) table.getValueAt(selectedRow, ++counter);
            online = (Boolean) table.getValueAt(selectedRow, ++counter);
            magazine = (Boolean) table.getValueAt(selectedRow, ++counter);
            others = (String) table.getValueAt(selectedRow, ++counter);
            address = (String) table.getValueAt(selectedRow, ++counter);

            //populate the add new client with these new values
            MediaHouseBean mhb = new MediaHouseBean(id, name, email, contactPerson, contactNumber, fax, address, newspaper, tv, radio, online, magazine, true, others);

            //open dialog to edit or delete the user;
            EditMediaHouse editMediaHouse = new EditMediaHouse();
            MediaHouseFrame frame = new MediaHouseFrame();
            frame.getFrame();
            frame.setVisible(true);
            editMediaHouse.add(frame);

            //set button text dynamically
            //set button text to 'update' while accessing from this class
            String buttonText = "Update";
            frame.setButtonText(buttonText);

            frame.setValuesToEdit(mhb);

            editMediaHouse.rowIdToDelete = selectedRow;
        }
    }//GEN-LAST:event_viewClientsTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable viewClientsTable;
    // End of variables declaration//GEN-END:variables

}