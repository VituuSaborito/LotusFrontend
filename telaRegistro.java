package frontend;

//import java.awt.GridBagLayout;
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
//import javax.swing.JRadioButton;

public class TelaRegistro {
	/**
	 * @param args
	 */
	public static void main(String[] args){
		JFrame tela = new JFrame("Registro");
		tela.setSize(500, 700);
		
		JPanel painel = new JPanel();
		painel.setSize(300, 700);
		
		tela.setLayout(null);
		
		JLabel title = new JLabel();
		title.setText("Registre-se: ");
		title.setBounds(215, 50, 200, 70);
		
		JLabel txtNome = new JLabel("Nome: ");
		txtNome.setBounds(100, 130, 50, 30);
		
		JTextField inputNome = new JTextField();
		inputNome.setBounds(150, 130, 200, 30);
		
		JLabel txtEmail = new JLabel("Email: ");
		txtEmail.setBounds(100, 180, 50, 30);
		
		JTextField inputEmail = new JTextField();
		inputEmail.setBounds(150, 180, 200, 30);
		
		JLabel txtSenha = new JLabel("Senha: ");
		txtSenha.setBounds(100, 230, 50, 30);
		
		JPasswordField inputSenha = new JPasswordField();
		inputSenha.setBounds(150, 230, 200, 30);
		
		JLabel txtConfSenha = new JLabel("Confirmar senha: ");
		txtConfSenha.setBounds(40, 280, 110, 30);
		
		JPasswordField inputConfSenha = new JPasswordField();
		inputConfSenha.setBounds(150, 280, 200, 30);
		
		JButton cadastro = new JButton("Registrar");
		cadastro.setBounds(150, 350, 200, 30);
		
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
					} else {
						JOptionPane.showMessageDialog(null, "Sua senha está incorreta");
					}
				}
				
			}
		};
		
		ActionListener limpa = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				inputNome.setText("");
			}
		};
		
		ActionListener sai = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		};
		
		cadastro.addActionListener(cadastrar);
	}
}
