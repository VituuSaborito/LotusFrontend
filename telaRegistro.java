package frontend;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ClienteDAO;
import modelo.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.*;

public class TelaRegistro {
	
	public static void main(String[] args){
		var tela = new JFrame("Registro");
		tela.setSize(500, 700);
		
		var painel = new JPanel();
		painel.setSize(300, 700);
		
		tela.setLayout(null);
		
		JLabel title = new JLabel();
		title.setText("Registre-se: ");
		title.setBounds(215, 50, 200, 70);
		
		var txtNome = new JLabel("Nome: ");
		txtNome.setBounds(100, 130, 50, 30);
		
		var inputNome = new JTextField();
		inputNome.setBounds(150, 130, 200, 30);
		
		var txtEmail = new JLabel("Email: ");
		txtEmail.setBounds(100, 180, 50, 30);
		
		var inputEmail = new JTextField();
		inputEmail.setBounds(150, 180, 200, 30);
		
		var txtSenha = new JLabel("Senha: ");
		txtSenha.setBounds(100, 230, 50, 30);
		
		var inputSenha = new JPasswordField();
		inputSenha.setBounds(150, 230, 200, 30);
		
		var txtConfSenha = new JLabel("Confirmar senha: ");
		txtConfSenha.setBounds(40, 280, 110, 30);
		
		var inputConfSenha = new JPasswordField();
		inputConfSenha.setBounds(150, 280, 200, 30);
		
		var cadastro = new JButton("Registrar");
		cadastro.setBounds(150, 350, 200, 30);
		
		var limpador = new JButton("Limpar");
		limpador.setBounds(50, 400, 200, 30);
		
		var saida = new JButton("Sair");
		saida.setBounds(250, 400, 200, 30);

		var txtLogin = new JLabel("Já tem uma conta?");
		txtLogin.setBounds(150, 450, 150, 30);
		
		var login = new JButton("Entrar");
		login.setBounds(150, 490, 200, 30);
		
		tela.add(title);
		tela.add(txtNome);
		tela.add(inputNome);
		tela.add(txtEmail);
		tela.add(inputEmail);
		tela.add(txtSenha);
		tela.add(inputSenha);
		tela.add(txtConfSenha);
		tela.add(inputConfSenha);
		tela.add(cadastro);
		tela.add(limpador);
		tela.add(saida);
		tela.add(txtLogin);
		tela.add(login);
		
		tela.setVisible(true);
		
		ActionListener cadastrar = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
					String senha = "";
					var car = inputSenha.getPassword();  
					for(int i = 0; i < car.length; i++) {
						senha += car[i];
					}
					
					String senha2 = "";
					var car2 = inputConfSenha.getPassword();  
					for(int i = 0; i < car2.length; i++) {
						senha2 += car2[i];
					}
				
				Usuario user = new Usuario(inputNome.getText(), inputEmail.getText(), senha);
				
				if(inputNome.getText().isEmpty() || inputEmail.getText().isEmpty() || senha.isEmpty() || senha2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo não pode estar vazio");
				} else {
					if(senha2.equals(senha)) {
						ClienteDAO dao = new ClienteDAO();
						dao.adiciona(user);
						JOptionPane.showMessageDialog(null, "Usuario " + inputNome.getText() + " cadastrado com sucesso!");						
						inputNome.setText("");
						inputEmail.setText("");
						inputSenha.setText("");
						inputConfSenha.setText("");
						tela.dispose();
						TelaArquivo.main(args);
					} else {
						JOptionPane.showMessageDialog(null, "Sua senha está incorreta");
					}
				}			
			}
		};
		
		ActionListener limpa = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				inputNome.setText("");
				inputEmail.setText("");
				inputSenha.setText("");
				inputConfSenha.setText("");
			}
		};
		
		ActionListener sai = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		};
		
		cadastro.addActionListener(cadastrar);
		limpador.addActionListener(limpa);
		saida.addActionListener(sai);
	}
}
