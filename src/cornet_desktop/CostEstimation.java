package cornet_desktop;

import cornet_desktop.Model.Aksesoris;
import cornet_desktop.Model.Aksesoris2;
import cornet_desktop.Model.CostEstimationBudget;
import cornet_desktop.Model.Konduktor;
import cornet_desktop.Model.LockNut;
import cornet_desktop.presenter.CostEstimationPresenter;
import cornet_desktop.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.*;


public class CostEstimation extends javax.swing.JFrame{

    private final CostEstimationPresenter costEstimationPresenter = new CostEstimationPresenter();
    private final List<CostEstimationBudget> costEstimationBudget = new ArrayList<>();
    private final List<String> jenisTower = Arrays.asList("TENSION", "SUSPENSION");
    private final Object[] headerTitle = {"No.", "Tipe Tower", "Basis", "Class Pondasi", "Sagging", "Clamping", "ST", "DT", "SS", "DS", "Harga"};
    private final Utils utils = new Utils();
    private final Konduktor konduktor = new Konduktor();
    private final Aksesoris aksesoris = new Aksesoris();
    private final Aksesoris2 aksesoris2 = new Aksesoris2();
    private final double totalHargaPersiapan = 384780616.638456;
    private final double pertambahanHargaPersiapan = 19227133.567868;
    private final double hargaArmourRodACSR = 1189018.51656667; //tinggal di kali jumlah tower
    private JTable tableCostEstimation;
    private List<String> tipeTower = new ArrayList<>();
    private List<String> classPondasi = new ArrayList<>();
    private List<String> tipeTowerSelected = Arrays.asList(new String[5]);
    
    private final ItemListener dropDownListener = (event) -> {
        if(event.getStateChange() == ItemEvent.SELECTED){
            String result = event.getItem().toString();
            int row = tableCostEstimation.getSelectedRow();
            System.out.println("row:"+row);
            if(tipeTower.contains(result)){
                tipeTowerSelected.set(row, result);
                costEstimationPresenter.loadBasisTower(result);
                List<String> basisTower = costEstimationPresenter.getBasisTower();
                setupDropdown(tableCostEstimation.getColumnModel().getColumn(2), basisTower);
                setHargaPersiapan(row);
            }else if(classPondasi.contains(result)){
                hitungHargaPondasi(result, row);
                updateHargaTower(row);
            }else{
                hitungHargaTower(tipeTowerSelected.get(row), result, row);
                updateHargaTower(row);
            }
            hitungGrandTotal();
        }
    };
    
    // listener perubahan tabel
    private final Action listenerPerubahanTabel = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            TableCellListener tcl = (TableCellListener)e.getSource();
            int row = tcl.getRow();
            int column = tcl.getColumn();
            if(column > 3 && column < 10){
                String value = tcl.getNewValue().toString();
                if(value.isEmpty() || value.contains("null")){
                    value = "0";
                }
                System.out.println("value:"+value);
                hitungHarga(row, column, value);
                updateHargaTower(row);
                hitungGrandTotal();
            }
        }
    };
    
    public CostEstimation() {
        initComponents();
        costEstimationBudget.add(new CostEstimationBudget());
        costEstimationBudget.add(new CostEstimationBudget());
        costEstimationBudget.add(new CostEstimationBudget());
        costEstimationBudget.add(new CostEstimationBudget());
        costEstimationBudget.add(new CostEstimationBudget());
        creatingTable();
        loadDataDropdown();
    }
    
    private void creatingTable(){
        DefaultTableModel dm = new DefaultTableModel(headerTitle, 5);
        tableCostEstimation = new JTable(dm){
            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
            
            @Override
            public Component prepareRenderer( TableCellRenderer renderer, int row, int column) {
                JComponent jc = (JComponent)super.prepareRenderer(renderer, row, column);
                jc.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
                return jc;
            }
        };
        //memberikan nomor pada kolom no
        int row = tableCostEstimation.getRowCount();
        for (int x = 0 ; x <= 4 ; x++){
            String no = String.valueOf(x+1);
            tableCostEstimation.setValueAt(no, x, 0);
        }
        
        //center table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        tableCostEstimation.setDefaultRenderer(String.class, centerRenderer);
        for(int x = 0 ; x <= 10 ; x++){
            tableCostEstimation.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
        }
        
        //memasang listener perubahan data pada baris dan kolom tertentu pada tabel
        TableCellListener tcl = new TableCellListener(tableCostEstimation, listenerPerubahanTabel);
        
        tableCostEstimation.setRowHeight(56);
        tableCostEstimation.getTableHeader().setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
        tableCostEstimation.setFont(new Font("Arial Rounded MT Bold", Font.CENTER_BASELINE, 18));
        
        //mengatur ukuran kolom secara statis
        tableCostEstimation.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableCostEstimation.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableCostEstimation.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableCostEstimation.getColumnModel().getColumn(2).setPreferredWidth(150);
        tableCostEstimation.getColumnModel().getColumn(3).setPreferredWidth(200);
        tableCostEstimation.getColumnModel().getColumn(4).setPreferredWidth(130);
        tableCostEstimation.getColumnModel().getColumn(5).setPreferredWidth(130);
        tableCostEstimation.getColumnModel().getColumn(6).setPreferredWidth(50);
        tableCostEstimation.getColumnModel().getColumn(7).setPreferredWidth(50);
        tableCostEstimation.getColumnModel().getColumn(8).setPreferredWidth(50);
        tableCostEstimation.getColumnModel().getColumn(9).setPreferredWidth(50);
        tableCostEstimation.getColumnModel().getColumn(10).setPreferredWidth(235);
        
        TableColumnModel cm = tableCostEstimation.getColumnModel();
//        cm.getColumn(0).setWidth(3);
//        cm.getColumn(10).setWidth(10);
        ColumnGroup coba = new ColumnGroup("Isolator");
        for(int indexKolom=6; indexKolom<=9; indexKolom++){
            TableColumn kolom = cm.getColumn(indexKolom);
            kolom.setWidth(1);
            coba.add(kolom);
        }
        GroupableTableHeader header = (GroupableTableHeader)tableCostEstimation.getTableHeader();
        header.addColumnGroup(coba);
        jScrollPane1.getViewport().add(tableCostEstimation);
    }
    
    private void loadDataDropdown(){
        //load data tipe tower dari database
        costEstimationPresenter.loadTipeTower();
        //load class pondasi tower
        costEstimationPresenter.loadClassPondasi();
        //list data tipe tower
        tipeTower = costEstimationPresenter.getTipeTower();
        //kolom tipe tower
        TableColumn kolomTipeTower = tableCostEstimation.getColumnModel().getColumn(1);
        //setup dropdown tipe tower
        setupDropdown(kolomTipeTower, tipeTower);
        //list class pondasi tower
        classPondasi = costEstimationPresenter.getClassPondasi();
        //kolom class pondasi
        TableColumn kolomClassPondasi = tableCostEstimation.getColumnModel().getColumn(3);
        //setup dropdown class pondasi
        setupDropdown(kolomClassPondasi, classPondasi);
    }
    
    private void setupDropdown(TableColumn kolom, List<String> data){
        JComboBox comboBox = new JComboBox();
        for(String tipe : data){
            comboBox.addItem(tipe);
        }
        comboBox.addItemListener(dropDownListener);
        kolom.setCellEditor(new DefaultCellEditor(comboBox));
    }
    
    private void hitungHargaTower(String result, String basis, int row){
        double hargaTower = costEstimationPresenter.getHargaTower(result, basis);
        System.out.println("harga tower " + result + " : " +utils.getCurrencyFormat(hargaTower));
        costEstimationBudget.get(row).setTotalHargaTower(hargaTower);
    }
    
    private void hitungHargaPondasi(String result, int row){
        String tipeTowerSelected = tableCostEstimation.getValueAt(row, 1).toString();
        System.out.println(tipeTowerSelected);
        double hargaPondasi = costEstimationPresenter.getHargaPondasi(tipeTowerSelected, result);
        System.out.println("harga pondasi:"+utils.getCurrencyFormat(hargaPondasi));
        costEstimationBudget.get(row).setTotalHargaPondasiTower(hargaPondasi);
    }
    
    private void hitungHarga(int row, int column, String value){
        System.out.println("baris:"+row+" dan kolom:"+column);
        try {
            Double qty = Double.parseDouble(value);
            switch(column){
                case 4:
                    //sagging
                    costEstimationBudget.get(row).setSagging(qty);
                    System.out.println("sagging set = " + costEstimationBudget.get(row).getSagging());
                    break;
                case 5:
                    //clamping and armour rod
                    costEstimationBudget.get(row).setClamping(qty);
                    costEstimationBudget.get(row).setTotalHargaAromourRod(qty);
                    break;
                case 6:
                    //ST
                    costEstimationBudget.get(row).setTotalHargaIsolatorST(qty);
                    break;
                case 7:
                    //DT
                    costEstimationBudget.get(row).setTotalHargaIsolatorDT(qty);
                    break;
                case 8:
                    //SS
                    costEstimationBudget.get(row).setTotalHargaIsolatorSS(qty);
                    break;
                case 9:
                    //DS
                    costEstimationBudget.get(row).setTotalHargaIsolatorDS(qty);
                    break;
                default:
                    System.out.println("another");
                    break;
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void updateHargaTower(int row){
        double totalBudget = costEstimationBudget.get(row).getTotalKeseluruhan();
        tableCostEstimation.setValueAt(utils.getCurrencyFormat(totalBudget), row, 10);
    }
    
    private void updateKomisioning(int qty, double total){
        TFKomisioning.setText(String.valueOf(qty));
        TFHarga2.setText(utils.getCurrencyFormat(total));
    }
    
    private void hitungGrandTotal(){
        //menghitung total harga tower dan jumlah tower
        double totalHargaTower = 0.0;
        int tower = 0;
        for(CostEstimationBudget budget : costEstimationBudget){
            double total = budget.getTotalKeseluruhan();
            totalHargaTower += total;
            if(budget.getTotalKeseluruhan() != 0.0){
                tower++;
            }
        }
        if(totalHargaTower > 0.0){
            hitungHargaIsolator();
            hitungHargaMaterialdanPondasiTower();
            konduktor.setJumlahTower(tower);
            konduktor.setJumlahSagging(getTotalSagging());
            konduktor.setJumlahClamping(getTotalClamping());
            aksesoris.setJumlahTower(tower);
            double totalArmourRodACSR = tower * hargaArmourRodACSR;
            hitungTotalKonduktor(totalArmourRodACSR);
            aksesoris2.setTotalKomisioning(tower);
            updateKomisioning(tower, aksesoris2.getTotalKomisioning());
            if(satuan_combobox.getSelectedItem().toString() == "KMR"){
                double grandTotal = getHargaPersiapan() + totalHargaTower + konduktor.getTotalKeseluruhan() + totalArmourRodACSR + 
                        aksesoris.getTotalKeseluruhan() + getTotalLockNut() + aksesoris2.getTotalKeseluruhan();
                TFGrandTotal.setText(utils.getCurrencyFormat(grandTotal));
            }
            System.out.println("================================================================================================");
        }
    }
    
    private double getHargaPersiapan(){
        double harga = 0.0;
        String hargaPersiapan = TFHarga1.getText();
        harga = utils.getNumberFormat(hargaPersiapan);
        return harga;
    }
    
    private void setHargaPersiapan(int sizeSelected){
        double hargaPersiapan = totalHargaPersiapan + (pertambahanHargaPersiapan * sizeSelected);
        TFHarga1.setText(utils.getCurrencyFormat(hargaPersiapan));
    }
    
    private void getTotalArmourRod(){
        int armor = 0;
        double total = 0;
        for(CostEstimationBudget budget : costEstimationBudget){
            armor += budget.getClamping();
            total += budget.getTotalHargaAromourRod();
        }
//        System.out.println("armor rod = " + armor + " total harga = " + utils.getCurrencyFormat(total));
    }
    
    private double getTotalSagging(){
        double sagging = 0;
        double totalSagging = 0;
        for(CostEstimationBudget budget : costEstimationBudget){
            sagging += budget.getSagging();
            totalSagging += budget.getTotalHargaSagging();
        }
//        System.out.println("sagging = " + sagging + " total harga = " + utils.getCurrencyFormat(totalSagging));
        return sagging;
    }
    
    private double getTotalClamping(){
        int clamping = 0;
        double total = 0;
        for(CostEstimationBudget budget : costEstimationBudget){
            clamping += budget.getClamping();
            total += budget.getTotalHargaClamping();
        }
//        System.out.println("clamping = " + clamping + " total harga = " + utils.getCurrencyFormat(total));
        getTotalArmourRod();
        return clamping;
    }
    
    private void hitungHargaMaterialdanPondasiTower(){
        double materialTower = 0;
        double pondasiTower = 0;
        for (CostEstimationBudget budget : costEstimationBudget){
            materialTower += budget.getTotalHargaTower();
            pondasiTower += budget.getTotalHargaPondasiTower();
        }
        System.out.println("total material tower = " + utils.getCurrencyFormat(materialTower));
        System.out.println("total pondasi tower = " + utils.getCurrencyFormat(pondasiTower));
    }
    
    private void hitungTotalKonduktor(double armourRodACSR){
        double totalArmor = 0;
        double totalSagging = 0;
        double totalClamping = 0;
        double totalKeseluruhan = 0;
        for (CostEstimationBudget budget : costEstimationBudget){
            totalArmor += budget.getTotalHargaAromourRod();
            totalSagging += budget.getTotalHargaSagging();
            totalClamping += budget.getTotalHargaClamping();
        }
        totalKeseluruhan = totalArmor + totalSagging + totalClamping + armourRodACSR;
        System.out.println("total konduktor = " + utils.getCurrencyFormat(totalKeseluruhan));
    }
    
    private void hitungHargaIsolator(){
        double st = 0;
        double dt = 0;
        double ss = 0;
        double ds = 0;
        for (CostEstimationBudget budget : costEstimationBudget){
            st += budget.getTotalHargaIsolatorST();
            dt += budget.getTotalHargaIsolatorDT();
            ss += budget.getTotalHargaIsolatorSS();
            ds += budget.getTotalHargaIsolatorDS();
        }
        System.out.println("st = " + utils.getCurrencyFormat(st));
        System.out.println("dt = " + utils.getCurrencyFormat(dt));
        System.out.println("ss = " + utils.getCurrencyFormat(ss));
        System.out.println("ds = " + utils.getCurrencyFormat(ds));
        double total = st + dt + ss + ds;
        System.out.println("total isolator = " + utils.getCurrencyFormat(total));
    }
    
    private double getTotalLockNut(){
        double total = 0.0;
        HashMap<String, LockNut> lockNut = costEstimationPresenter.getLockNut();
        tipeTowerSelected.forEach((tipe) -> {
            if(tipe != null){
                lockNut.get(tipe).addQuantity();
            }
        });
        for(String key : lockNut.keySet()){
            double lockTotal = lockNut.get(key).getTotal();
            System.out.println("lock nut " + key + " = " + lockNut.get(key).getQuantity() + " = " + utils.getCurrencyFormat(lockTotal));
            total += lockNut.get(key).getTotal();
        }
        System.out.println("total Aksessoris 1 = " + utils.getCurrencyFormat(total + aksesoris.getTotalKeseluruhan()));
        return total;
    }
    
    public void showLayout(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CostEstimation().setVisible(true);
            }
        });
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
        logo = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        LPersiapan = new javax.swing.JLabel();
        LQuantity = new javax.swing.JLabel();
        LSatuan = new javax.swing.JLabel();
        LHarga1 = new javax.swing.JLabel();
        LKomisioning = new javax.swing.JLabel();
        LHarga2 = new javax.swing.JLabel();
        LGrandTotal = new javax.swing.JLabel();
        TFHarga1 = new javax.swing.JTextField();
        TFKomisioning = new javax.swing.JTextField();
        TFGrandTotal = new javax.swing.JTextField();
        TFHarga2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        persiapan_combobox = new javax.swing.JComboBox<>();
        qty_combobox = new javax.swing.JComboBox<>();
        satuan_combobox = new javax.swing.JComboBox<>();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1369, 831));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(1230, 820));
        jPanel1.setOpaque(false);

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo/logo PLN fix.png"))); // NOI18N
        logo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoMouseClicked(evt);
            }
        });

        title.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("COST ESTIMATION");

        LPersiapan.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        LPersiapan.setForeground(new java.awt.Color(255, 255, 255));
        LPersiapan.setText("Persiapan");

        LQuantity.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        LQuantity.setForeground(new java.awt.Color(255, 255, 255));
        LQuantity.setText("Quantity");

        LSatuan.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        LSatuan.setForeground(new java.awt.Color(255, 255, 255));
        LSatuan.setText("Satuan");

        LHarga1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        LHarga1.setForeground(new java.awt.Color(255, 255, 255));
        LHarga1.setText("Harga");

        LKomisioning.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        LKomisioning.setForeground(new java.awt.Color(255, 255, 255));
        LKomisioning.setText("Komisioning");

        LHarga2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        LHarga2.setForeground(new java.awt.Color(255, 255, 255));
        LHarga2.setText("Harga");

        LGrandTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        LGrandTotal.setForeground(new java.awt.Color(255, 255, 255));
        LGrandTotal.setText("Grand Total");

        TFHarga1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        TFHarga1.setMinimumSize(new java.awt.Dimension(200, 30));
        TFHarga1.setPreferredSize(new java.awt.Dimension(200, 30));

        TFKomisioning.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        TFKomisioning.setMinimumSize(new java.awt.Dimension(200, 30));
        TFKomisioning.setPreferredSize(new java.awt.Dimension(200, 30));

        TFGrandTotal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        TFGrandTotal.setMinimumSize(new java.awt.Dimension(200, 30));
        TFGrandTotal.setPreferredSize(new java.awt.Dimension(200, 30));

        TFHarga2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        TFHarga2.setMinimumSize(new java.awt.Dimension(200, 30));
        TFHarga2.setPreferredSize(new java.awt.Dimension(200, 30));

        jScrollPane1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jScrollPane1.setOpaque(false);

        persiapan_combobox.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        persiapan_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Pekerjaan" }));
        persiapan_combobox.setMinimumSize(new java.awt.Dimension(200, 30));
        persiapan_combobox.setPreferredSize(new java.awt.Dimension(200, 30));

        qty_combobox.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        qty_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "1" }));
        qty_combobox.setMinimumSize(new java.awt.Dimension(200, 30));
        qty_combobox.setPreferredSize(new java.awt.Dimension(200, 30));

        satuan_combobox.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        satuan_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "KMR" }));
        satuan_combobox.setMinimumSize(new java.awt.Dimension(200, 30));
        satuan_combobox.setPreferredSize(new java.awt.Dimension(200, 30));
        satuan_combobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                satuan_comboboxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo)
                        .addGap(456, 456, 456)
                        .addComponent(title)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TFHarga2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LGrandTotal)
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LHarga2)
                                    .addComponent(TFGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(55, 55, 55))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(793, 1069, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LHarga1)
                            .addComponent(TFHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LKomisioning)
                            .addComponent(TFKomisioning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(persiapan_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LPersiapan))
                                .addGap(132, 132, 132)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LQuantity)
                                    .addComponent(qty_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(158, 158, 158)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(satuan_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(LSatuan)
                                        .addGap(111, 111, 111)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo)
                    .addComponent(title))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LPersiapan)
                            .addComponent(LHarga1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFHarga1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(persiapan_combobox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qty_combobox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LSatuan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(satuan_combobox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFGrandTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LHarga2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LKomisioning))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFKomisioning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFHarga2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addComponent(LGrandTotal)))
                .addGap(73, 73, 73))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 830);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/background/bg_content1.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1370, 830);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void logoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoMouseClicked
        // TODO add your handling code here:
        new home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoMouseClicked

    private void satuan_comboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_satuan_comboboxItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() == "KMR"){
            String hargaRupiah = utils.getCurrencyFormat(totalHargaPersiapan);
            TFHarga1.setText(hargaRupiah);
        }
    }//GEN-LAST:event_satuan_comboboxItemStateChanged


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CostEstimation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CostEstimation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LGrandTotal;
    private javax.swing.JLabel LHarga1;
    private javax.swing.JLabel LHarga2;
    private javax.swing.JLabel LKomisioning;
    private javax.swing.JLabel LPersiapan;
    private javax.swing.JLabel LQuantity;
    private javax.swing.JLabel LSatuan;
    private javax.swing.JTextField TFGrandTotal;
    private javax.swing.JTextField TFHarga1;
    private javax.swing.JTextField TFHarga2;
    private javax.swing.JTextField TFKomisioning;
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JComboBox<String> persiapan_combobox;
    private javax.swing.JComboBox<String> qty_combobox;
    private javax.swing.JComboBox<String> satuan_combobox;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
