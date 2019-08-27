package zoo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestionAnimales extends JPanel {
    JTable animales = null;
    DefaultTableModel modeloAnimales = null;

    GestionAnimales(){
        setLayout(new BorderLayout());
        JButton borraAnimalButton = new JButton("Borrar animal");
        JButton addAnimalButton = new JButton("Aniadir animal");
        JButton editAnimalButton = new JButton("Editar animal");
        modeloAnimales = new DefaultTableModel();
        modeloAnimales.addColumn("Nombre");
        modeloAnimales.addColumn("Ojos");
        modeloAnimales.addColumn("Patas");
        modeloAnimales.addColumn("Peligrosidad");

        rellenaFilasAnimales();

        animales = new JTable(modeloAnimales);

        JScrollPane barraAnimales=new JScrollPane(animales);
        barraAnimales.setVisible(true);
        barraAnimales.setMaximumSize(new Dimension(500,300));
        add(barraAnimales, BorderLayout.CENTER);

        JPanel contenedorBotoneraAnimales = new JPanel(new GridLayout(1,3,30,30));
        contenedorBotoneraAnimales.setSize(500,100);
        contenedorBotoneraAnimales.setMaximumSize(new Dimension(500,100));


        addAnimalButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                addAnimal();
            }
        });

        editAnimalButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                editAnimal();
            }
        });

        borraAnimalButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                deleteAnimal();
            }
        });

        contenedorBotoneraAnimales.add(addAnimalButton);
        contenedorBotoneraAnimales.add(editAnimalButton);
        contenedorBotoneraAnimales.add(borraAnimalButton);


        add(contenedorBotoneraAnimales, BorderLayout.SOUTH);

    }

    private void deleteAnimal() {
        String input = JOptionPane.showInputDialog("Inserta el nombre del animal a borrar");
        if(input!=null && !input.equals("")) {
            BaseDatos bbdd = new BaseDatos();
            if (bbdd.deleteAnimal(input)) {
                rellenaFilasAnimales();
                JOptionPane.showMessageDialog(null, "Animal borrado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ha sido imposible borrar el animal con nombre: "+input, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Introduce un nombre de animal para ser borraado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editAnimal() {
        String input = JOptionPane.showInputDialog("Inserta el nombre del animal a editar");
        if(input!=null && !input.equals("")) {
            BaseDatos bbdd = new BaseDatos();
            List<Animal> listaAnimales = bbdd.getAllAnimals();
            Animal a = null;
            for(Animal as : listaAnimales){
                if(as.getNombre().equals(input)){
                    a = as;
                }
            }

            if(a != null) {
                ImageIcon icon = new ImageIcon("src/images/edit.png");

                JPanel panel = new JPanel(new GridLayout(5, 2));

                JLabel labelNombre = new JLabel("Nombre");
                JLabel labelOjos = new JLabel("Ojos");
                JLabel labelPatas = new JLabel("Patas");
                JLabel labelPeligrosidad = new JLabel("Peligrosidad");

                JTextField inputNombre = new JTextField();
                JTextField inputOjos = new JTextField();
                JTextField inputPatas = new JTextField();
                JTextField inputPeligrosidad = new JTextField();

                inputNombre.setText(a.getNombre());
                inputOjos.setText(a.getOjos().toString());
                inputPatas.setText(a.getPatas().toString());
                inputPeligrosidad.setText(a.getPeligrosidad().toString());

                panel.add(labelNombre);
                panel.add(inputNombre);

                panel.add(labelOjos);
                panel.add(inputOjos);

                panel.add(labelPatas);
                panel.add(inputPatas);

                panel.add(labelPeligrosidad);
                panel.add(inputPeligrosidad);


                UIManager.put("OptionPane.minimumSize", new Dimension(300, 120));
                int input2 = JOptionPane.showOptionDialog(null, panel, "Editar usuario", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
                if(input2 == JOptionPane.OK_OPTION){
                    String newNombre = inputNombre.getText();
                    String newOjos = inputOjos.getText();
                    String newPatas = inputPatas.getText();
                    String newPeligrosidad = inputPeligrosidad.getText();
                    boolean newOjosEsNumero = false;
                    boolean newPatasEsNumero = false;
                    boolean newPeligrosidadEsNumero = false;
                    try{
                        Integer.parseInt(newOjos);
                        newOjosEsNumero = true;
                    }catch(NumberFormatException e){
                        newOjosEsNumero = false;
                    }try{
                        Integer.parseInt(newPatas);
                        newPatasEsNumero = true;
                    }catch(NumberFormatException e){
                        newPatasEsNumero = false;
                    }try{
                        Integer.parseInt(newPeligrosidad);
                        newPeligrosidadEsNumero = true;
                    }catch(NumberFormatException e){
                        newPeligrosidadEsNumero = false;
                    }
                    if(newNombre==null || newNombre.equals("")){
                        JOptionPane.showMessageDialog(null, "Introduzca un nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if(newOjos==null || newOjos.equals("") || !newOjosEsNumero){
                        JOptionPane.showMessageDialog(null, "Introduzca el numero de ojos", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if(newPatas==null || newPatas.equals("") || !newPatasEsNumero){
                        JOptionPane.showMessageDialog(null, "Introduzca el numero de patas", "Error", JOptionPane.ERROR_MESSAGE);
                    }else if(newPeligrosidad==null || newPeligrosidad.equals("") || !newPeligrosidadEsNumero){
                        JOptionPane.showMessageDialog(null, "Introduzca la peligrosidad (1-10)", "Error", JOptionPane.ERROR_MESSAGE);
                    }else{
                        BaseDatos bbddd = new BaseDatos();
                        Animal ax = new Animal();
                        ax.setNombre(newNombre);
                        ax.setOjos(Integer.parseInt(newOjos));
                        ax.setPatas(Integer.parseInt(newPatas));
                        ax.setPeligrosidad(Integer.parseInt(newPeligrosidad));
                        if(bbddd.editAnimal(ax)){
                            rellenaFilasAnimales();
                            JOptionPane.showMessageDialog(null, "Animal editado correctamente");
                        }else{
                            JOptionPane.showMessageDialog(null, "Ha sido imposible editar el animal", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se ha encontrado el animal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Introduce un nombre de animal para ser editado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addAnimal() {
        ImageIcon icon = new ImageIcon("src/images/add.png");

        JPanel panel = new JPanel(new GridLayout(5,2));

        JLabel labelNombre = new JLabel("Nombre");
        JLabel labelOjos = new JLabel("Ojos");
        JLabel labelPatas = new JLabel("Patas");
        JLabel labelPeligrosidad = new JLabel("Peligrosidad");

        JTextField inputNombre = new JTextField();
        JTextField inputOjos = new JTextField();
        JTextField inputPatas = new JTextField();
        JTextField inputPeligrosidad = new JTextField();

        panel.add(labelNombre);
        panel.add(inputNombre);

        panel.add(labelOjos);
        panel.add(inputOjos);

        panel.add(labelPatas);
        panel.add(inputPatas);

        panel.add(labelPeligrosidad);
        panel.add(inputPeligrosidad);


        UIManager.put("OptionPane.minimumSize",new Dimension(300, 120));
        int input = JOptionPane.showOptionDialog(null, panel, "Aniadir animal", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, null);
        if(input == JOptionPane.OK_OPTION){
            String nombre = inputNombre.getText();
            String ojos = inputOjos.getText();
            String patas = inputPatas.getText();
            String peligrosidad = inputPeligrosidad.getText();
            boolean ojosEsNumero = false;
            boolean patasEsNumero = false;
            boolean peligrosidadEsNumero = false;
            try{
                Integer.parseInt(ojos);
                ojosEsNumero = true;
            }catch(NumberFormatException e){
                ojosEsNumero = false;
            }try{
                Integer.parseInt(patas);
                patasEsNumero = true;
            }catch(NumberFormatException e){
                patasEsNumero = false;
            }try{
                Integer.parseInt(peligrosidad);
                peligrosidadEsNumero = true;
            }catch(NumberFormatException e){
                peligrosidadEsNumero = false;
            }
            if(nombre==null || nombre.equals("")){
                JOptionPane.showMessageDialog(null, "Introduzca un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(ojos==null || ojos.equals("") || !ojosEsNumero){
                JOptionPane.showMessageDialog(null, "Introduzca un numero de ojos", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(patas==null || patas.equals("") || !patasEsNumero){
                JOptionPane.showMessageDialog(null, "Introduzca un numero de patas", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(peligrosidad==null || peligrosidad.equals("") || !peligrosidadEsNumero){
                JOptionPane.showMessageDialog(null, "Introduzca la peligrosidad (1-10)", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                BaseDatos bbdd = new BaseDatos();
                Animal a = new Animal();
                a.setNombre(nombre);
                a.setOjos(Integer.parseInt(ojos));
                a.setPatas(Integer.parseInt(patas));
                a.setPeligrosidad(Integer.parseInt(peligrosidad));
                if(bbdd.addAnimal(a)){
                    rellenaFilasAnimales();
                    JOptionPane.showMessageDialog(null, "Animal aniadido correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Ha sido imposible aniadir el animal", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void vaciaTodoMenosPrimeraFila() {
        modeloAnimales.setRowCount(0);
    }

    private void rellenaFilasAnimales() {
        vaciaTodoMenosPrimeraFila();
        List<Animal> animalesBBDD = getAllAnimals();
        if(animalesBBDD!=null && animalesBBDD.size()>0) {
            for(Animal a : animalesBBDD) {
                Object[] fila = new Object[4];
                fila[0] = a.getNombre();
                fila[1] = a.getOjos();
                fila[2] = a.getPatas();
                fila[3] = a.getPeligrosidad();
                modeloAnimales.addRow(fila);
            }
        }
    }

    private List<Animal> getAllAnimals(){
        List<Animal> returnList = null;
        BaseDatos bbdd = new BaseDatos();
        returnList = bbdd.getAllAnimals();
        return returnList;
    }

}
