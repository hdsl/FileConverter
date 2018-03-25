/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileconverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author amseidu
 */
public class FileConverterUI extends javax.swing.JFrame {

    String selectedFilePath;

    String selectedFileName;

//    private static String OUTPUTFILENAME = "C:\\FILE_CONVERTER\\";

//    private static final Path ACCOUNTS = Paths.get(OUTPUTFILENAME + "ACCOUNTS.txt");
//    private static final Path CARDACCOUNTS = Paths.get(OUTPUTFILENAME + "CARDACCOUNTS.txt");
//    private static final Path CARDOVERRIDELIMITS = Paths.get(OUTPUTFILENAME + "CARDOVERRIDELIMITS.txt");
//    private static final Path CARDS = Paths.get(OUTPUTFILENAME + "CARDS.txt");
//    private static final Path CUSTOMERACCOUNTS = Paths.get(OUTPUTFILENAME + "CUSTOMERACCOUNTS.txt");

    String PATH = "C:\\FILE_CONVERTER\\";
    String directoryName = PATH;

    public FileConverterUI() {
        setTitle("Prudential Bank Limited - File Converter");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        selectedFileURL = new javax.swing.JTextField();
        convertFileButton = new javax.swing.JButton();
        selectFileButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        UCCRadioButton = new javax.swing.JRadioButton();
        PUCRadioButton = new javax.swing.JRadioButton();
        ezwichRadioButton = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        convertedFileField = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        fileChooser.setDialogTitle("Select FIle");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select File", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        selectedFileURL.setEditable(false);

        convertFileButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        convertFileButton.setText("Convert");
        convertFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertFileButtonActionPerformed(evt);
            }
        });

        selectFileButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        selectFileButton.setText("Select file");
        selectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Ensure this folder is always present. \"C:\\FILE_CONVERTER\"");

        buttonGroup1.add(UCCRadioButton);
        UCCRadioButton.setText("UCC");

        buttonGroup1.add(PUCRadioButton);
        PUCRadioButton.setText("PUC");

        buttonGroup1.add(ezwichRadioButton);
        ezwichRadioButton.setText("Ezwich");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(selectedFileURL, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(selectFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(convertFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(UCCRadioButton)
                        .addGap(35, 35, 35)
                        .addComponent(PUCRadioButton)
                        .addGap(28, 28, 28)
                        .addComponent(ezwichRadioButton)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(selectedFileURL, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectFileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(convertFileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UCCRadioButton)
                    .addComponent(PUCRadioButton)
                    .addComponent(ezwichRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Converted File Format", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        convertedFileField.setEditable(false);
        convertedFileField.setColumns(20);
        convertedFileField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        convertedFileField.setRows(5);
        jScrollPane1.setViewportView(convertedFileField);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        closeButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(closeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void dualPurposeConversion() {

        try {

            InputStream inputStream = new FileInputStream(selectedFilePath);

            // Get the workbook instance for XLS file
//            HSSFWorkbook workbook = new HSSFWorkbook(input);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            // Get first sheet from the workbook
//            HSSFSheet sheet = workbook.getSheetAt(0);
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Get the total number of rows
            int rowCount = sheet.getPhysicalNumberOfRows();

            String fileContent = "";

            // Iterate through each rows from first sheet
            Iterator rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {

                String concatRowData = "";

//                HSSFRow row = (HSSFRow) rowIterator.next();
                XSSFRow row = (XSSFRow) rowIterator.next();

                Cell lastColumn = row.getCell(row.getLastCellNum() - 1);

                String lastColumnValue = lastColumn.getStringCellValue();

                String[] studentId = lastColumnValue.split("/");

                String studentPixId = "";

                for (String s : studentId) {

                    studentPixId = studentPixId + s;

                }

                // For each row, iterate through each columns
                Iterator cellIterator = row.cellIterator();

                int count = 0;

                while (cellIterator.hasNext()) {

                    count++;

                    String columnStringData = "";

//                    HSSFCell cell = (HSSFCell) cellIterator.next();
                    XSSFCell cell = (XSSFCell) cellIterator.next();

                    switch (cell.getCellType()) {

//                        case HSSFCell.CELL_TYPE_STRING:
                        case XSSFCell.CELL_TYPE_STRING:

                            columnStringData = cell.getStringCellValue();
                            break;
                        case XSSFCell.CELL_TYPE_NUMERIC:

                            Integer columnNumData = (int) cell.getNumericCellValue();
                            columnStringData = columnNumData.toString();
                            break;
                        default:
                            break;
                    }

                    if (concatRowData.equals("")) {

                        concatRowData = columnStringData;
                    } else {

                        concatRowData = concatRowData + "," + columnStringData;
                    }

                }

                if (count == 3) {
                    concatRowData = concatRowData + ",-,-,-,-,-,,,,,-,,,-,-,-,-,-,-,-,,,-,-,-,-,-,,-,-,,,,,,,,-,-,,-,-,,,,,,,,,,,,,,,,,,,,,,-";
                } else if (count == 5) {
                    concatRowData = concatRowData + "," + studentPixId.toLowerCase() + ",-,-,,,,,-,,,-,-,-,-,-,-,-,,,-,-,-,-,-,,-,-,,,,,,,,-,-,,-,-,,,,,,,,,,,,,,,,,,,,,,-";
                }

                fileContent = fileContent + System.lineSeparator() + concatRowData;

            }

            //Get current date
            LocalDateTime localDate = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");

            String formattedDate = localDate.format(formatter);

            String outputFileName = "converted_file" + "_" + formattedDate + ".txt";

            String fileHeader = "<Header>,1,PrudentialBank UCC,-,-,-,,,,,,,,,,-,-,,00233," + formattedDate + "";

            String fileTrail = "<Trailer>,1," + rowCount + "," + rowCount + "," + rowCount;

            String outFileContent = fileHeader + System.lineSeparator() + fileContent + System.lineSeparator() + fileTrail;

            File directory = new File(directoryName);

            if (!directory.exists()) {
                directory.mkdir();
            }

//            OUTPUTFILENAME = OUTPUTFILENAME + outputFileName;
            File file = new File(directoryName + outputFileName);

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(outFileContent);
            bw.close();

//            Files.write(Paths.get(OUTPUTFILENAME), outFileContent.getBytes());
            convertedFileField.setText(outFileContent);

            JOptionPane.showMessageDialog(null, "File converted successfully", "File Converter", 1);

            System.exit(0);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileConverterUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileConverterUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ezwichConversion() {

        try {

            InputStream inputStream = new FileInputStream(selectedFilePath);

            // Get the workbook instance for XLS file
//            HSSFWorkbook workbook = new HSSFWorkbook(input);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            // Get first sheet from the workbook
//            HSSFSheet sheet = workbook.getSheetAt(0);
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Get the total number of rows
            int rowCount = sheet.getPhysicalNumberOfRows();

            int count = 0;

//            String accountsFileContent = "";
            String cardAccountsFileContent = "";
            String cardOverrideLimitsFileContent = "";
            String cardsFileContent = "";
//            String customerAccountsFileContent = "";

            // Iterate through each rows from first sheet
            Iterator rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {

                count++;

                String concatRowData = "";

                String accountNumberStringColumnValue = "";

//                HSSFRow row = (HSSFRow) rowIterator.next();
                XSSFRow row = (XSSFRow) rowIterator.next();

                Cell firstColumn = row.getCell(row.getFirstCellNum());

                switch (firstColumn.getCellType()) {

//                        case HSSFCell.CELL_TYPE_STRING:
                    case XSSFCell.CELL_TYPE_STRING:

                        accountNumberStringColumnValue = firstColumn.getStringCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:

                        Integer columnNumData = (int) firstColumn.getNumericCellValue();
                        accountNumberStringColumnValue = columnNumData.toString();
                        break;
                    default:
                        break;
                }

                //check for account type of account number
                String accountTypeCheck = accountNumberStringColumnValue.substring(9);

                String accountType = null;

                if (accountTypeCheck.startsWith("5")) {
                    //savings account
                    accountType = "10";
                } else if (accountTypeCheck.startsWith("0")) {
                    //current account
                    accountType = "20";
                }

                //for ACCOUNTS file
//                String accounts = "U" + "," + accountNumberStringColumnValue + "," + accountType + "," + "936" + ",,,,";
//                accountsFileContent = accountsFileContent + System.lineSeparator() + accounts;
                //for CARDACCOUNTS file
                String cardAccounts = "U" + "," + accountNumberStringColumnValue + "," + "001" + "," + accountNumberStringColumnValue + "," + accountType + "," + count + "," + accountType;
                cardAccountsFileContent = cardAccountsFileContent + System.lineSeparator() + cardAccounts;

                //for CARDOVERRIDELIMITS file
                String cardOverrideLimits = "U" + "," + accountNumberStringColumnValue + "," + "001" + "," + "99" + "," + "100000" + "," + "100000" + "," + "99" + "," + "100000" + "," + "100000" + "," + "100000" + "," + "100000" + ",0,,,,,,,,,,,,,,,,,,,,,,,,,";
                cardOverrideLimitsFileContent = cardOverrideLimitsFileContent + System.lineSeparator() + cardOverrideLimits;

                //for CARDS file
                String cards = "U" + "," + accountNumberStringColumnValue + "," + "001" + "," + "Ezwich" + "," + accountType + "," + "6" + ",,1905,,,,4,,,,,,0,,PPPPSSS,,,,36," + accountNumberStringColumnValue + ",,," + accountType;
                cardsFileContent = cardsFileContent + System.lineSeparator() + cards;

                //for CUSTOMERACCOUNTS file
//                String customerAccounts = "U" + "," + accountNumberStringColumnValue.substring(0, 9) + "," + accountNumberStringColumnValue + "," + accountType;
//                customerAccountsFileContent = customerAccountsFileContent + System.lineSeparator() + customerAccounts;
            }

            //Get current date
//            LocalDateTime localDate = LocalDateTime.now();
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
//
//            String formattedDate = localDate.format(formatter);
            try {

                File directory = new File(directoryName);

                if (!directory.exists()) {
                    directory.mkdir();
                }

//                File file = new File(directoryName + "CARDACCOUNTS.txt");
                //write to ACCOUNTS file
//                byte[] accountDataToByte = accountsFileContent.getBytes();
//                Files.write(ACCOUNTS, accountDataToByte);
                //write to CARDACCOUNTS file
                Path CARDACCOUNTS = Paths.get(directoryName + "CARDACCOUNTS.txt");

                byte[] cardAccDataToByte = cardAccountsFileContent.getBytes();
                Files.write(CARDACCOUNTS, cardAccDataToByte);

                //write to CARDOVERRIDELIMITS file
                Path CARDOVERRIDELIMITS = Paths.get(directoryName + "CARDOVERRIDELIMITS.txt");

                byte[] cardOverrideDataToByte = cardOverrideLimitsFileContent.getBytes();
                Files.write(CARDOVERRIDELIMITS, cardOverrideDataToByte);

                //write to CARDS file
                Path CARDS = Paths.get(directoryName + "CARDS.txt");

                byte[] cardsDataToByte = cardsFileContent.getBytes();
                Files.write(CARDS, cardsDataToByte);

                //write to CUSTOMERACCOUNTS file
//                byte[] customerAccDataToByte = customerAccountsFileContent.getBytes();
//                Files.write(CUSTOMERACCOUNTS, customerAccDataToByte);
//                Files.createFile(ACCOUNTS);
            } catch (IOException e) {
                e.printStackTrace();
            }

//            BufferedWriter bufferedWriter = null;
//
//            File file = new File("ACCOUNTS.txt");
//            FileWriter fileWriter = new FileWriter(file);
//            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(accountsFileContent);
            //create folder with current date
//            Files.createDirectories(Paths.get("C:\\FILE_CONVERTER\\" + formattedDate));
//            String outputFileName = "converted_file" + "_" + formattedDate + ".txt";
//
//            String fileHeader = "<Header>,1,PrudentialBank UCC,-,-,-,,,,,,,,,,-,-,,00233," + formattedDate + "";
//
//            String fileTrail = "<Trailer>,1," + rowCount + "," + rowCount + "," + rowCount;
//
//            String outFileContent = fileHeader + System.lineSeparator() + System.lineSeparator() + fileTrail;
//
//            OUTPUTFILENAME = OUTPUTFILENAME + outputFileName;
//
//            Files.write(Paths.get(OUTPUTFILENAME), outFileContent.getBytes());
//
//            convertedFileField.setText(outFileContent);
            JOptionPane.showMessageDialog(null, "File converted successfully", "File Converter", 1);

            System.exit(0);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileConverterUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileConverterUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void selectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileButtonActionPerformed

        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fileChooser.getSelectedFile();

            selectedFilePath = file.getAbsolutePath();

            selectedFileName = file.getName();

            selectedFileURL.setText(selectedFilePath);

        }
    }//GEN-LAST:event_selectFileButtonActionPerformed

    private void convertFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertFileButtonActionPerformed

        if (selectedFilePath == null) {

            JOptionPane.showMessageDialog(null, "File not selected", "File Converter", 1);

        } else {

            if (buttonGroup1.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Select converter option", "File Converter", 1);
            } else if (buttonGroup1.getSelection().equals(UCCRadioButton.getModel()) || buttonGroup1.getSelection().equals(PUCRadioButton.getModel())) {

                dualPurposeConversion();

            } else if (buttonGroup1.getSelection().equals(ezwichRadioButton.getModel())) {
                ezwichConversion();
            }

        }


    }//GEN-LAST:event_convertFileButtonActionPerformed


    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FileConverterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileConverterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileConverterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileConverterUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileConverterUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton PUCRadioButton;
    private javax.swing.JRadioButton UCCRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton convertFileButton;
    private javax.swing.JTextArea convertedFileField;
    private javax.swing.JRadioButton ezwichRadioButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton selectFileButton;
    private javax.swing.JTextField selectedFileURL;
    // End of variables declaration//GEN-END:variables
}
