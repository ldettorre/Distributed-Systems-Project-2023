package carpark.service;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import carpark.service.carparkServicesGrpc.carparkServicesBlockingStub;
import carpark.service.carparkServicesGrpc.carparkServicesStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class CarparkGUI implements ActionListener{
	

	
	String host = "localhost";
	int port = 50051;
	
	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	carparkServicesBlockingStub blockingStub = carparkServicesGrpc.newBlockingStub(channel);
	carparkServicesStub asyncStub = carparkServicesGrpc.newStub(channel);

	
	private JTextField accessInput, accessOutput;
	
	
	private JPanel carparkJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel accessLabel = new JLabel("Enter Staff ID No.")	;
		panel.add(accessLabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		accessInput = new JTextField("",10);
		panel.add(accessInput);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Access");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		accessOutput = new JTextField("", 20);
		accessOutput .setEditable(false);
		panel.add(accessOutput );

		panel.setLayout(boxlayout);

		return panel;

	}
	
	
	public static void main(String[] args) {

		CarparkGUI gui = new CarparkGUI();

		gui.build();
	}

	private void build() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Carpark Controller");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add(carparkJPanel() );

		// Set size for the frame
		frame.setSize(300, 300);

		// Set the window to be visible as the default to be false
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		String label = button.getActionCommand();  
		
		if(label.equals("Request Access")) {
			System.out.println("Request Access Selected");
			carpark.service.AccessRequest request = AccessRequest.newBuilder().setIdNumber(accessInput.getText()).build();
			carpark.service.AccessResponse response = blockingStub.accessCarpark(request);
			accessOutput.setText(response.getMessage());
		}
		
	}
}