package frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.ClienteDAO;
import modelo.Arquivos;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaBanco {
    public static void main(String[] args) throws SQLException {
        JFrame telaA = new JFrame("Arquivos");
        JPanel panel = new JPanel();
        DefaultTableModel model = new DefaultTableModel();

        JTable tabela = new JTable(model);
        
        telaA.setSize(800, 500);
        telaA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model.addColumn("Nome");
        model.addColumn("Caminho");
        model.addColumn("Formato");

        try {
            Arquivos arquivos = new Arquivos();
            ArrayList<Arquivos> listaArquivos = ClienteDAO.listarArquivos();
            
            for (int e = 0; e < listaArquivos.size(); e++) {
                arquivos = listaArquivos.get(e);
                Object[] data = {arquivos.getNome(), arquivos.getCaminho(), arquivos.getFormato()};
                model.addRow(data);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        panel.add(new JScrollPane(tabela));
        telaA.add(panel);
        telaA.setVisible(true);
    }
}