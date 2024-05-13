package encriptadocesar;

import javax.swing.JOptionPane;

public class EncriptadoCesar extends javax.swing.JFrame {

    public EncriptadoCesar() {
        initComponents(); // Método para inicializar componentes de la interfaz gráfica
    }

    // Método para inicializar los componentes de la interfaz gráfica
    private void initComponents() {
        // Declaración de componentes de la interfaz gráfica
        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        keyTextField = new javax.swing.JTextField();
        encryptButton = new javax.swing.JButton();
        decryptButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana

        // Configuración del área de texto de entrada
        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        jScrollPane1.setViewportView(inputTextArea);

        jLabel1.setText("Mensaje:"); // Etiqueta para el área de texto de entrada

        jLabel2.setText("Clave:"); // Etiqueta para el campo de texto de la clave

        encryptButton.setText("Encriptar"); // Botón para encriptar el mensaje
        encryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptButtonActionPerformed(evt);
            }
        });

        decryptButton.setText("Desencriptar"); // Botón para desencriptar el mensaje
        decryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptButtonActionPerformed(evt);
            }
        });

        // Configuración del área de texto de salida
        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane2.setViewportView(outputTextArea);

        // Configuración del diseño de la interfaz gráfica
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(encryptButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decryptButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(keyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptButton)
                    .addComponent(decryptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    // Método para realizar la encriptación al hacer clic en el botón de encriptar
    private void encryptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String message = inputTextArea.getText(); // Obtiene el mensaje ingresado por el usuario
        int key = Integer.parseInt(keyTextField.getText()); // Obtiene la clave ingresada por el usuario
        String encryptedMessage = encrypt(message, key); // Encripta el mensaje
        outputTextArea.setText(encryptedMessage); // Muestra el mensaje encriptado en el área de texto de salida
    }

    // Método para realizar la desencriptación al hacer clic en el botón de desencriptar
    private void decryptButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String encryptedMessage = inputTextArea.getText(); // Obtiene el mensaje encriptado ingresado por el usuario
        int key = Integer.parseInt(keyTextField.getText()); // Obtiene la clave ingresada por el usuario
        String decryptedMessage = decrypt(encryptedMessage, key); // Desencripta el mensaje
        outputTextArea.setText(decryptedMessage); // Muestra el mensaje desencriptado en el área de texto de salida
    }

    // Método para encriptar el mensaje utilizando el cifrado César
    private String encrypt(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int offset = character - base;
                int encryptedOffset = (offset + key) % 26;
                char encryptedChar = (char) (base + encryptedOffset);
                result.append(encryptedChar);
            } else {
                result.append(character); // Conserva los caracteres que no son letras
            }
        }

        return result.toString(); // Devuelve el mensaje encriptado
    }

    // Método para desencriptar el mensaje utilizando el cifrado César
    private String decrypt(String message, int key) {
        return encrypt(message, 26 - key); // La desencriptación es simplemente la encriptación con la clave inversa
    }

    // Método principal para ejecutar la aplicación
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
            java.util.logging.Logger.getLogger(EncriptadoCesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncriptadoCesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncriptadoCesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncriptadoCesar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncriptadoCesar().setVisible(true); // Crea y muestra la interfaz gráfica
            }
        });
    }

    // Declaración de variables de la interfaz gráfica
    private javax.swing.JButton decryptButton;
    private javax.swing.JButton encryptButton;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keyTextField;
    private javax.swing.JTextArea outputTextArea;
    // Fin de la declaración de variables
}
