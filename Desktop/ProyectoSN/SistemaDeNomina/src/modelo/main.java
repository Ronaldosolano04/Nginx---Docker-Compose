package modelo;

import javax.swing.MenuSelectionManager;

public class main {
    /**
     * @param args
     */
    public main(String[] args) {
        GestorNomina gestorNomina = new GestorNomina();
        MenuSelectionManager menu = new Menu(gestorNomina);
        menu.mostrarMenuPrincipal();
    }

    @Override
    public String toString() {
        return "main []";
    }
}