/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddXMPPAccount.java
 *
 * Created on Apr 9, 2010, 2:51:57 PM
 */

package com.hyk.proxy.client.launch.gui;

import com.hyk.proxy.client.config.Config.XmppAccount;;

/**
 *
 * @author qiying.wang
 */
public class XMPPAccountDialog extends javax.swing.JDialog {
    /** A return status code - returned if Cancel button has been pressed */
    public static final int RET_CANCEL = 0;
    /** A return status code - returned if OK button has been pressed */
    public static final int RET_OK = 1;

    private UICallback callback;

    /** Creates new form AddXMPPAccount */
    public XMPPAccountDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** @return the return status of this dialog - one of RET_OK or RET_CANCEL */
    public int getReturnStatus() {
        return returnStatus;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        isXmppAdvanceEnable = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        xmppServerHost = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        xmppServerPort = new javax.swing.JTextField();
        isUseOldSSL = new javax.swing.JCheckBox();

        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Advanced Options"));

        isXmppAdvanceEnable.setText("Enable Advanced Options");
        isXmppAdvanceEnable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isXmppAdvanceEnableActionPerformed(evt);
            }
        });

        jLabel3.setText("XMPP Server Host:");

        jLabel4.setText("XMPP Server Port:");

        isUseOldSSL.setText("Enable Old SSL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xmppServerPort, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                            .addComponent(isXmppAdvanceEnable)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                .addComponent(xmppServerHost, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(isUseOldSSL)
                        .addContainerGap(249, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(isXmppAdvanceEnable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(xmppServerHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(xmppServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isUseOldSSL)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passText))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(userText, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(userText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
        XmppAccount account = new  XmppAccount();
        account.jid = userText.getText().trim();
        account.passwd = new String(passText.getPassword()).trim();
        //XmppAccount account = new XmppAccount(userText.getText().trim(), new String(passText.getPassword()).trim());
        if(isXmppAdvanceEnable.isSelected() || !isAddOpr)
        {
        	account.isOldSSLEnable = isUseOldSSL.isSelected();
            //account.setOldSSLEnable(isUseOldSSL.isSelected());
            if(null != xmppServerHost.getText() && !xmppServerHost.getText().trim().equals(""))
            {
            	 account.serverHost = xmppServerHost.getText();
                 //account.setServerHost(xmppServerHost.getText());
            }
            if(null != xmppServerPort.getText() && !xmppServerPort.getText().trim().equals(""))
            {
            	 account.serverPort = Integer.parseInt(xmppServerPort.getText());
                 //account.setServerPort(Integer.parseInt(xmppServerPort.getText()));
            }
        }
        callback.callback(new Object[]{account});
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void isXmppAdvanceEnableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isXmppAdvanceEnableActionPerformed
        enableAdvanceOptions();
    }//GEN-LAST:event_isXmppAdvanceEnableActionPerformed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    public void startAddAccount(UICallback callback)
    {
        isAddOpr = true;
        setTitle("Add XMPP Account");
        this.callback = callback;
        userText.setText("");
        passText.setText("");
        setLocationByPlatform(true);
        disableAdvanceOptions();
        setVisible(true);
    }

    public void startModifyAccount(XmppAccount account, UICallback callback)
    {
        isAddOpr = false;
        setTitle("Modify XMPP Account");
        setLocationByPlatform(true);
        this.callback = callback;
        userText.setText(account.jid);
        userText.setEditable(false);
        passText.setText(account.passwd);
        isUseOldSSL.setSelected(account.isOldSSLEnable);
        xmppServerHost.setText(account.serverHost);
        xmppServerPort.setText("" + account.serverPort);
        disableAdvanceOptions();

        setVisible(true);
    }

    protected void disableAdvanceOptions()
    {
        isXmppAdvanceEnable.setSelected(false);
        isUseOldSSL.setEnabled(false);
        xmppServerHost.setEditable(false);
        xmppServerPort.setEnabled(false);
    }

    protected void enableAdvanceOptions()
    {
        isXmppAdvanceEnable.setSelected(true);
        isUseOldSSL.setEnabled(true);
        xmppServerHost.setEditable(true);
        xmppServerPort.setEnabled(true);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                XMPPAccountDialog dialog = new XMPPAccountDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox isUseOldSSL;
    private javax.swing.JCheckBox isXmppAdvanceEnable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passText;
    private javax.swing.JTextField userText;
    private javax.swing.JTextField xmppServerHost;
    private javax.swing.JTextField xmppServerPort;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;

    private boolean isAddOpr;
}
