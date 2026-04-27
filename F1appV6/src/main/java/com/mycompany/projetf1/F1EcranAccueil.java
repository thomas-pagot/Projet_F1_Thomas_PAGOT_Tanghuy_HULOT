/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projetf1;


/**
 *
 * @author Admin
 */
public class F1EcranAccueil extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(F1EcranAccueil.class.getName());

    /**
     * Creates new form F1EcranAccueil
     */
    public F1EcranAccueil() {
        initComponents();

        this.setSize(712, 426);
        this.setPreferredSize(new java.awt.Dimension(712, 426));
        this.setLocationRelativeTo(null);

        String[] listeImages = {
            "/alpine.jpg",
            "/mercedes.jpg",
            "/ferrari.jpg",
            "/redbull.jpg"
        };

        int tirageAuSort = new java.util.Random().nextInt(listeImages.length);
        java.net.URL cheminImage = getClass().getResource(listeImages[tirageAuSort]);

        if (cheminImage != null) {
            jLabel5.setIcon(new javax.swing.ImageIcon(cheminImage));
        } else {
            System.out.println("ERREUR : Impossible de trouver l'image " + listeImages[tirageAuSort]);
        }

        try {
            java.io.InputStream is = getClass().getResourceAsStream("/Montserrat-Bold.ttf");
            java.awt.Font policeArrondie = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, is);
            java.awt.Font policeTitre = policeArrondie.deriveFont(32f);
            java.awt.Font policeBouton = policeArrondie.deriveFont(16f);
            jLabel1.setFont(policeTitre);
            jButton1.setFont(policeBouton);
            jButton2.setFont(policeBouton);
        } catch (Exception e) {
            System.out.println("Impossible de charger Montserrat : " + e.getMessage());
        }

        java.awt.Color couleurFondNormal = new java.awt.Color(30, 30, 30);
        java.awt.Color couleurSurvol = new java.awt.Color(225, 6, 0);
        java.awt.Color couleurTexte = java.awt.Color.WHITE;

        jButton1.setBackground(couleurFondNormal);
        jButton1.setForeground(couleurTexte);
        jButton1.setFocusPainted(false);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(couleurSurvol);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1.setBackground(couleurFondNormal);
            }
        });

        jButton2.setBackground(couleurFondNormal);
        jButton2.setForeground(couleurTexte);
        jButton2.setFocusPainted(false);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(couleurSurvol);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2.setBackground(couleurFondNormal);
            }
        });

        this.setOpacity(0.0f);

        javax.swing.Timer timerFade = new javax.swing.Timer(15, new java.awt.event.ActionListener() {
            float opacite = 0.0f;

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                opacite += 0.05f;
                if (opacite >= 1.0f) {
                    opacite = 1.0f;
                    ((javax.swing.Timer) e.getSource()).stop();
                }
                setOpacity(opacite);
            }
        });
        timerFade.start();

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseX = evt.getX();
                mouseY = evt.getY();
            }
        });

        this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int kordinatX = evt.getXOnScreen();
                int kordinatY = evt.getYOnScreen();
                setLocation(kordinatX - mouseX, kordinatY - mouseY);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Bienvenue dans F1 Archives");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, 49));

        jButton1.setText("Voir les Saisons 2023 & 2024");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        jButton2.setText("Quitter");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 130, 30));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 66, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(946, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alpine.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        jButton1.setEnabled(false);
        jButton2.setEnabled(false);

        javax.swing.Timer timerFadeOut = new javax.swing.Timer(15, new java.awt.event.ActionListener() {
            float opacite = 1.0f;

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                opacite -= 0.05f;
                if (opacite <= 0.0f) {
                    ((javax.swing.Timer) e.getSource()).stop();
                    MainFrame nouvellePage = new MainFrame();
                    nouvellePage.setLocation(getLocation());
                    nouvellePage.setVisible(true);
                    dispose();
                    return;
                }
                setOpacity(Math.max(0, opacite));
            }
        });
        timerFadeOut.start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton2ActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
                logger.log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            java.awt.EventQueue.invokeLater(() -> new F1EcranAccueil().setVisible(true));
        }

        int mouseX;
        int mouseY;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
