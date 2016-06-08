import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;


class ChatProgramClient {

	JButton sendButton, clearButton, setNameButton;
	JTextField typeField;
	JTextArea msgArea;  
	JPanel southPanel;

	String username;
	String userID;
	
	Socket socket;
	BufferedReader input;
	BufferedWriter output;


	public static void main(String[] args) throws NoSuchAlgorithmException { 
		new ChatProgramClient().go();
	}

	public void go() throws NoSuchAlgorithmException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		username = "Anonymous";
		
//		MessageDigest hash = MessageDigest.getInstance("MD5");
//		String timestamp = String.valueOf(System.nanoTime());
//		hash.update(timestamp.getBytes());
//		byte[] digest = hash.digest();
//		
		
		JFrame window = new JFrame("Chat Client");
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(3, 0));
		
		sendButton = new JButton("Send");
		sendButton.addActionListener(new sendButtonListener());
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new clearButtonListener());

		setNameButton = new JButton("Set Name");
		setNameButton.addActionListener(new setNameButtonListener());
		
//		JLabel errorLabel = new JLabel("");
//		JLabel errorLabel2 = new JLabel("");

		typeField = new JTextField(10);
		typeField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
					send();
				else if (arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
					clear();
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});

		msgArea = new JTextArea();
		msgArea.setEditable(false);

		southPanel.add(typeField);
		southPanel.add(sendButton);
		southPanel.add(new JLabel(""));
		southPanel.add(clearButton);
		southPanel.add(new JLabel(""));
		southPanel.add(setNameButton);

		window.add(BorderLayout.CENTER,msgArea);
		window.add(BorderLayout.SOUTH,southPanel);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		window.setVisible(true);

		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					input.close();
					output.close();
					socket.close();
				} catch (Exception ex) {
					System.out.println("Failed to close streams");
				}
				e.getWindow().dispose();
			}
		});

		connect();

		while (true) {
			try {
				if (input.ready()) {

					String message = input.readLine();
					
					// If not sent by same user
					if (!message.substring(0, message.indexOf(":")).equals(username)) {
						System.out.println("Text received: " + message);
						msgArea.append(message.substring(0, message.indexOf(":")) + ": " + message.substring(message.indexOf(":" + 1)) + "\n");
					}

//					output.write("MESSAGE RECEIVED: " + message);
//					output.newLine();
//					output.flush();
				}
			} catch (Exception e) {
			}
		}
		// after connecting loop and keep appending[.append()] to the JTextArea
	}

	public void connect() {
		System.out.println("Attempting to connect...");

		try {
			socket = new Socket("localhost", 5000);

			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println("Connection successful");

		} catch (UnknownHostException e) {
		} catch (IOException e) {
			System.out.println("Connection failed");
		}

	}

	private void send() { 
		try {
			String text = typeField.getText();
			output.write(username + ":" + text);
			output.newLine();
			output.flush();
			
			typeField.setText("");
			System.out.println("Text sent: " + text);
			
			msgArea.append(username + ": " + text + "\n");
		} catch (Exception e) {
			msgArea.append("ERROR: Message was not sent\n       Check your connection\n");
			System.out.println("Error sending message");
		}
	}
	
	private void clear() {
		msgArea.setText("");
	}
	
	private void setName() {
		String s = typeField.getText();
		
		if (s.contains(" ")) 
			username = s.substring(0, s.indexOf(" "));
		
		else username = s;
	}
	
	//****** Inner Classes for Action Listeners ****

	//To complete this you will need to add action listeners to both buttons
	// clear - clears the textfield
	
	private class sendButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			send();
		}
	}
	private class clearButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			clear();
		}
	}
	private class setNameButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setName();
		}
	}

}