package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		
		JLabel title = new JLabel();
		title.setText("MENU");
		title.setBounds(215, 50, 200, 70);
		
		JButton bancoDeDados = new JButton("Visualizar o banco de dados");
		bancoDeDados.setBounds(145, 350, 200, 30);
		
		JButton inserirArquivo = new JButton("Inserir arquivo");
		inserirArquivo.setBounds(145, 400, 200, 30);
		
		JButton respostas = new JButton("Perguntar ao assistente");
		respostas.setBounds(145, 450, 200, 30);
		
		tela.add(title);
		tela.add(respostas);
		tela.add(bancoDeDados);
		tela.add(inserirArquivo);
		
		
		tela.setVisible(true);
		
		ActionListener abreBanco = new ActionListener(){
			public void actionPerformed(ActionEvent evento) {
				tela.dispose();
				TelaBanco.main(args);
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
