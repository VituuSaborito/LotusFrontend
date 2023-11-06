package frontend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMenu {

	public static void main(String[] args) {
		
		JFrame tela = new JFrame("Menu");
		tela.setSize(500,700);
		
		JPanel painel = new JPanel();
		painel.setSize(300,700);
		
		tela.setLayout(null);
		
		Font fonteTitulo = new Font("Arial", Font.BOLD, 20);
		
		JLabel title = new JLabel();
		title.setText("Bem vindo " + TelaLogin.username);
		title.setBounds(170, 50, 200, 70);
		title.setFont(fonteTitulo);
		
		
		JButton bancoDeDados = new JButton("Visualizar o banco de dados");
		bancoDeDados.setBounds(30, 300, 200, 30);
		JLabel descBD = new JLabel();
		descBD.setText("Visualizar os arquivos inseridos");
		descBD.setBounds(40, 325, 200, 30);
		JLabel descBD2 = new JLabel();
		descBD2.setText("no banco de dados");
		descBD2.setBounds(73, 340, 200, 30);
		
		JButton inserirArquivo = new JButton("Inserir arquivo");
		inserirArquivo.setBounds(250, 300, 200, 30);
		JLabel descInserir = new JLabel();
		descInserir.setText("Inserir arquivos ao Assistente");
		descInserir.setBounds(265, 325, 200, 30);
		
		JButton respostas = new JButton("Perguntar ao assistente");
		respostas.setBounds(145, 425, 200, 30);
		JLabel descResp = new JLabel();
		descResp.setText("Perguntar ao assistente sobre");
		descResp.setBounds(155, 450, 200, 30);
		JLabel descResp2 = new JLabel();
		descResp2.setText("os arquivos inseridos");
		descResp2.setBounds(175, 465, 200, 30);
		
		tela.add(title);
		tela.add(respostas);
		tela.add(bancoDeDados);
		tela.add(inserirArquivo);
		tela.add(descBD);
		tela.add(descBD2);
		tela.add(descInserir);
		tela.add(descResp);
		tela.add(descResp2);
		
		tela.setVisible(true);
		
		ActionListener abreBanco = new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				tela.dispose();
				try {
					TelaBanco.main(args);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		ActionListener abreInsercaoArquivo = new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				tela.dispose();
				TelaArquivo.main(args);
			}
		};
		
		ActionListener abrePerguntas = new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				tela.dispose();
				TelaResposta.main(args);
			}
		};
		
		bancoDeDados.addActionListener(abreBanco);
		inserirArquivo.addActionListener(abreInsercaoArquivo);
		respostas.addActionListener(abrePerguntas);

	}

}
