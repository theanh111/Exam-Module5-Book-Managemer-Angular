package javaapplication2;

import javax.swing.RowFilter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Home extends javax.swing.JFrame {

    private static ArrayList<Product> list;
    DefaultTableModel model;

    public void writeFile() {
        String path = "danh sach.txt";
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (int i = 0; i < list.size(); i++) {
                objectOutputStream.writeObject(list.get(i));
            }

        } catch (Exception e) {
        } finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {

            }
        }

    }

    public void readFile() {
        String path = "danh sach.txt";
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Product product = (Product) objectInputStream.readObject();
                list.add(product);
            }
        } catch (Exception e) {
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
            }

        }
    }

    // con phan hien thi chua xong
    public void updataProduct(Product product) {
        list.set(fixtIndex, product);
        showList(list);

    }

    public static Home home = new Home();

    public Home() {
        initComponents();
        this.setTitle("Trang chu");
        list = new ArrayList<>();
        readFile();
        showList(list);

    }

    public void showList(ArrayList<Product> list) {

        model = (DefaultTableModel) jTable1.getModel();
        int i = 1;
        model.setRowCount(0);
        for (Product product : list) {
            model.addRow(new Object[]{
                i++, product.getNameString(), product.getCodeString(), product.getAmount()
            });
        }
        jTable1.setModel(model);
        model.fireTableDataChanged();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        inPutNameProduct = new javax.swing.JTextField();
        inPutCodeProduct = new javax.swing.JTextField();
        inPutAmount = new javax.swing.JTextField();
        inPut = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        deleteInput = new javax.swing.JButton();
        deleteValue = new javax.swing.JButton();
        fixValue = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        valueFind = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Nhập sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Mã hàng hóa");

        jLabel4.setText("Số lượng");
        jLabel4.setToolTipText("");

        inPut.setText("Thêm mới");
        inPut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inPutActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        deleteInput.setText("Xóa nhập");
        deleteInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInputActionPerformed(evt);
            }
        });

        deleteValue.setText("Xóa dữ liệu");
        deleteValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteValueActionPerformed(evt);
            }
        });

        fixValue.setText("Sửa");
        fixValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inPutAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(inPutCodeProduct)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fixValue, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteValue))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inPut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteInput))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Exit)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(inPutNameProduct)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inPutNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inPutCodeProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inPutAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inPut)
                    .addComponent(deleteInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteValue)
                    .addComponent(fixValue))
                .addGap(31, 31, 31)
                .addComponent(Exit))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Số lượng"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        valueFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueFindActionPerformed(evt);
            }
        });
        valueFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                valueFindKeyReleased(evt);
            }
        });

        jLabel5.setText("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(valueFind, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInputActionPerformed
        clearData();
    }//GEN-LAST:event_deleteInputActionPerformed

    private void inPutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inPutActionPerformed

        String number = "[1-9][0-9]*";
        Pattern pattern = Pattern.compile(number);
        Matcher matcher = pattern.matcher(inPutAmount.getText());
        if (matcher.matches()) {
            Product product = new Product();
            product.setNameString(inPutNameProduct.getText());
            product.setCodeString(inPutCodeProduct.getText());
            product.setAmount(Integer.parseInt(inPutAmount.getText()));
            list.add(product);
            showList(list);
            clearData();
            writeFile();
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "nhap sai dinh dang so luong");
        }

    }//GEN-LAST:event_inPutActionPerformed
    private void clearData() {
        inPutNameProduct.setText("");
        inPutCodeProduct.setText("");
        inPutAmount.setText("");
    }
    int removeIndex;
    private void deleteValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteValueActionPerformed

        removeIndex = jTable1.getSelectedRow();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Danh sach trong");
        } else {
            if (removeIndex == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hay chon mot dong de xoa");
            } else {
                list.remove(removeIndex);
                showList(list);
            }
        }
        writeFile();
    }//GEN-LAST:event_deleteValueActionPerformed

    private void fixValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixValueActionPerformed
        String name;
        String code;
        int amount;
        name = inPutNameProduct.getText();
        code = inPutCodeProduct.getText();
        amount = Integer.parseInt(inPutAmount.getText());
        Product product = new Product(name, code, amount);
        if (JOptionPane.showConfirmDialog(null, "Ban muon tiep tuc?", "Xác nhận", JOptionPane.DEFAULT_OPTION) == 0) {
            JOptionPane.showMessageDialog(rootPane, "Da thay doi");
            updataProduct(product);
            clearData();
        }
    }//GEN-LAST:event_fixValueActionPerformed
    int findIndex;
    private void valueFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueFindActionPerformed
        model = (DefaultTableModel) jTable1.getModel();
        String search = valueFind.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

    }//GEN-LAST:event_valueFindActionPerformed

    private void valueFindKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valueFindKeyReleased

        model = (DefaultTableModel) jTable1.getModel();
        String search = valueFind.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_valueFindKeyReleased
    int fixtIndex;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        fixtIndex = jTable1.getSelectedRow();
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Danh sach trong");
        } else {
            if (fixtIndex == -1) {
                JOptionPane.showMessageDialog(rootPane, "Hay chon dong can sua");
            } else {
                inPutNameProduct.setText(list.get(fixtIndex).getNameString());
                inPutCodeProduct.setText(list.get(fixtIndex).getCodeString());
                inPutAmount.setText(list.get(fixtIndex).getAmount() + "");
            }
        }
        writeFile();
    }//GEN-LAST:event_jTable1MouseClicked

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton deleteInput;
    private javax.swing.JButton deleteValue;
    private javax.swing.JButton fixValue;
    private javax.swing.JButton inPut;
    private javax.swing.JTextField inPutAmount;
    private javax.swing.JTextField inPutCodeProduct;
    private javax.swing.JTextField inPutNameProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField valueFind;
    // End of variables declaration//GEN-END:variables
}
