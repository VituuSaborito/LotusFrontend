package frontend;

//import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

import dao.ClienteDAO;
import modelo.Usuario;

//import javax.swing.JRadioButton;

public class TelaLogin {
	public static String username = "usuário";
	public static void main(String[] args){
		JFrame tela = new JFrame("Login");
		tela.setSize(500, 700);
		
		JPanel painel = new JPanel();
		painel.setSize(300, 700);
		
		tela.setLayout(null);
		
		JLabel title = new JLabel();
		title.setText("Login: ");
		title.setBounds(230, 50, 200, 70);
		
		JLabel textoNome = new JLabel("Nome: ");
		textoNome.setBounds(100, 130, 50, 30);
		
		JTextField nome = new JTextField();
		nome.setBounds(150, 130, 200, 30);
		
		JLabel textoEmail = new JLabel("Email: ");
		textoEmail.setBounds(100, 180, 50, 30);
		
		JTextField email = new JTextField();
		email.setBounds(150, 180, 200, 30);
		
		JLabel textoSenha = new JLabel("Senha: ");
		textoSenha.setBounds(100, 230, 50, 30);
		
		JPasswordField senha = new JPasswordField();
		senha.setBounds(150, 230, 200, 30);
		
		JButton entrar = new JButton("Entrar");
		entrar.setBounds(150, 300, 200, 30);
		
		JLabel textoRegistro = new JLabel();
		textoRegistro.setText("Não tem uma conta?");
		textoRegistro.setBounds(200, 370, 200, 70);
		
		JButton registrar = new JButton("Registrar-se");
		registrar.setBounds(150, 420, 200, 30);

		ClienteDAO clienteDAO = new ClienteDAO();

		entrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String login = nome.getText();
				String mail = email.getText();
				String password = new String(senha.getPassword());

				Usuario user = new Usuario(login, mail, password);

				if(login.contains("@") && login.contains(".")) {
					try {
						username = ClienteDAO.usuarioMenu(mail, password);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {
					username = login;
				}
				
				try {
					if (ClienteDAO.login(user)) {
						JOptionPane.showMessageDialog(null, "Login efetuado com sucesso.");
						TelaMenu.main(args);
						tela.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Os dados inseridos são inválidos. Tente novamente.");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		 });
		
		
		registrar.addActionListener (new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				tela.dispose();
				
				telaRegistro telaRegistro = new telaRegistro();
				telaRegistro.setVisible(true);
			}
		});
				
		
		tela.add(title);
		tela.add(textoNome);
		tela.add(nome);
		tela.add(textoEmail);
		tela.add(email);
		tela.add(textoSenha);
		tela.add(senha);
		tela.add(entrar);
		tela.add(textoRegistro);
		tela.add(registrar);
		
		tela.setVisible(true);
	}
}
