package Vista;

import javax.swing.*;
import java.awt.event.*;

public class ModalConfirmarCerrarCompeV2 extends JDialog {
    private JPanel pPrincipal;
    private JButton button1;
    private JButton eliminarButton;
    private JButton cancelarButton;
    private boolean confirmado = false;

    public ModalConfirmarCerrarCompeV2() {
        setContentPane(pPrincipal);
        setModal(true);
        pack();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(eliminarButton);
        setTitle("¡WARNING!");
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Vista/Fotos/alerta.png"));
        setIconImage(imagen.getImage());

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                confirmado = true;
                dispose();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // call onCancel() on ESCAPE
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    public boolean isConfirmado() {
        return confirmado;
    }
}
