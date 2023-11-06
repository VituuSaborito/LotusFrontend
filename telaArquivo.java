package frontend;

//o bot só ingere documentos após a importação deles

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import backend.DocumentIngestor;
import backend.FuncTelaArquivo;
import dao.ClienteDAO;
import modelo.Arquivos;

import javax.swing.ButtonGroup;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class TelaArquivo {
	//static String username = System.getProperty("user.name");
	public static String nome;
	
	public static String caminho;
	
	public static void main(String[] args) {
		
		JFrame tela = new JFrame("Inserção de Arquivo");
		tela.setSize(500,700);
		
		JPanel painel = new JPanel();
		painel.setSize(300,700);
		
		tela.setLayout(null);
		
		
		JLabel title = new JLabel();
		title.setText("Selecione o formato do arquivo: ");
		title.setBounds(150, 50, 200, 70);

		JRadioButton alternativa1 = new JRadioButton("PDF", false);
		alternativa1.setBounds(100, 150, 60, 70);
		JRadioButton alternativa3 = new JRadioButton("TXT", false);
		alternativa3.setBounds(100, 200, 60, 70);
		
		JLabel recomenda = new JLabel();
		recomenda.setText("* Recomendado o uso de TXT e PDF");
		recomenda.setBounds(100, 320, 300, 20);
		
		
		JRadioButton alternativa2 = new JRadioButton("DOCX", false);
		alternativa2.setBounds(100, 250, 60, 70);
		
		
		ButtonGroup radios = new ButtonGroup();
		radios.add(alternativa1);
		radios.add(alternativa2);
		radios.add(alternativa3);
		
		JButton importar = new JButton("Inserir o arquivo");
		importar.setBounds(145, 400, 200, 30);
		
		JButton pergunta = new JButton("Perguntar ao Assistente");
		pergunta.setBounds(145, 450, 200, 30);
		
		JButton menu = new JButton("Menu");
		menu.setBounds(145, 500, 200, 30);
		
		tela.add(title);
		tela.add(alternativa1);
		tela.add(alternativa2);
		tela.add(alternativa3);
		tela.add(importar);
		tela.add(pergunta);
		tela.add(recomenda);
		tela.add(menu);
		
		tela.setVisible(true);
		
		ActionListener abreArquivo = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boolean[] formatos = {alternativa1.isSelected(), alternativa2.isSelected(), alternativa3.isSelected(), alternativa4.isSelected()};
			    JFileChooser chooser = new JFileChooser();
			    FuncTelaArquivo.escolheFiltro(formatos, chooser);
			    int i = chooser.showOpenDialog(tela);
			    if(i == JFileChooser.APPROVE_OPTION) {
			       File file = chooser.getSelectedFile();
			       String filepath = file.getPath();
			       caminho = filepath;
			       nome = chooser.getName(file);
			       String formato = nome.substring(nome.length() - 4, nome.length());
			       ClienteDAO dao = new ClienteDAO();
			       Arquivos arquivoInsert = new Arquivos(nome, caminho, formato, TelaLogin.username);
			       arquivoInsert.toString();
			       System.out.println(arquivoInsert);
			       dao.adiciona(arquivoInsert);
				   File arquivo = null;
			       
					try {
		    		   FuncTelaArquivo.escolheFormato(formato, arquivo, nome, caminho, file);
			       	} catch (Exception ex) {
			    	   ex.printStackTrace();   
			    	   	}			    	   			    	   
			    }
		}
	};
		
		ActionListener perguntar = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tela.dispose();
				TelaResposta.main(args);
			}
		};
		
		ActionListener voltar = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				tela.dispose();
				TelaMenu.main(args);
			}
		};
		
		importar.addActionListener(abreArquivo);
		pergunta.addActionListener(perguntar);
		menu.addActionListener(voltar);
	}

}
