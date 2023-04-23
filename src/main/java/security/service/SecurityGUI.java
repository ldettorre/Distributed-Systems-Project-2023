package security.service;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import security.service.securityServicesGrpc.securityServicesBlockingStub;
import security.service.securityServicesGrpc.securityServicesStub;

public class SecurityGUI implements ActionListener{
	
	String host = "localhost";
	int port = 50053;
	
	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	
	
	securityServicesBlockingStub blockingStub = securityServicesGrpc.newBlockingStub(channel);
	securityServicesStub asyncStub = securityServicesGrpc.newStub(channel);
	
	private JTextField unlockInput, unlockOutput;
	private JTextField emUnlockInput;
	private JTextArea emUnlockOutput;
	private JTextField detailFloor, detailFName, detailLName, detailStaffId, detailsOutput;
	
	private JPanel unlockDoorJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter Security Code.")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		unlockInput = new JTextField("",10);
		panel.add(unlockInput);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Unlock Access");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		unlockOutput = new JTextField("", 22);
		unlockOutput.setEditable(false);
		panel.add(unlockOutput);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel emUnlockDoorJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel label = new JLabel("Enter Security Code.")	;
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		emUnlockInput = new JTextField("",10);
		panel.add(emUnlockInput);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Emergency Unlock");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 250)));
	
		emUnlockOutput = new JTextArea();
		emUnlockOutput.setEditable(false);
		panel.add(emUnlockOutput);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel accessBuildingJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel floorLabel = new JLabel("Enter Your Floor.");
		detailFloor = new JTextField("",10);
		panel.add(floorLabel);
		panel.add(detailFloor);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JLabel fNameLabel = new JLabel("Enter First Name.");
		detailFName = new JTextField("",10);
		panel.add(fNameLabel);
		panel.add(detailFName);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		
		JLabel lNameLabel = new JLabel("Enter Last Name.");
		detailLName = new JTextField("",10);
		panel.add(lNameLabel);
		panel.add(detailLName);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));


		JLabel staffIdLabel = new JLabel("Enter Staff Id.");
		detailStaffId = new JTextField("",10);
		panel.add(staffIdLabel);
		panel.add(detailStaffId);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Building Access");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		detailsOutput= new JTextField("", 22);
		detailsOutput.setEditable(false);
		panel.add(detailsOutput);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	public static void main(String[] args) {

		SecurityGUI gui = new SecurityGUI();

		gui.build();
	}

	private void build() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Security Controller");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add(unlockDoorJPanel() );
		panel.add(emUnlockDoorJPanel() );
		panel.add(accessBuildingJPanel());

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
		
		// unlockDoor Method
		if(label.equals("Request Unlock Access")) {
			System.out.println("Request Unlock Access Selected");
			String codeEntered = unlockInput.getText();
			UnlockRequest request = UnlockRequest.newBuilder().setCodeEntered(codeEntered).build();
			UnlockResponse response = blockingStub.unlockDoor(request);
			System.out.println("Door lock status: "+ response.getLockStatus());
			unlockOutput.setText(response.getLockStatus());
		}
		else if(label.equals("Request Emergency Unlock")) {
			System.out.println("Request Emergency Unlock Selected");
			emUnlockOutput.selectAll();
			emUnlockOutput.replaceSelection("");
			EmUnlockRequest request = EmUnlockRequest.newBuilder().setCodeEntered(emUnlockInput.getText()).build();
			Iterator<EmUnlockResponse> response = blockingStub.emergencyUnlock(request);
			
			while(response.hasNext()) {
				EmUnlockResponse singleResponse = response.next();
				emUnlockOutput.append(singleResponse.getLockStatus()+", \n");
				System.out.println("Emergency Lock Status: "+ singleResponse.getLockStatus());
			}
		}
		else if(label.equals("Request Building Access")) {
			System.out.println("Request Building Access");
			StreamObserver<DetailsResponse> responseObserver = new StreamObserver<DetailsResponse>() {
				@Override
				public void onNext(DetailsResponse response) {
					// TODO Auto-generated method stub
					System.out.println(response.getMessage());
					detailsOutput.setText(response.getMessage());
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Staff Details Sent..");
				}
				
			};
			
			StreamObserver<DetailsRequest> requestObserver = asyncStub.accessBuilding(responseObserver);
			try {
				requestObserver.onNext(DetailsRequest.newBuilder()
						.setStaffID(Integer.parseInt(detailStaffId.getText()))
						.setStaffFName(detailFName.getText())
						.setStaffLName(detailLName.getText())
						.setFloor(Integer.parseInt(detailFloor.getText())).build());
				requestObserver.onNext(DetailsRequest.newBuilder()
						.setStaffID(Integer.parseInt(detailStaffId.getText()))
						.setStaffFName(detailFName.getText())
						.setStaffLName(detailLName.getText())
						.setFloor(Integer.parseInt(detailFloor.getText())).build());
				requestObserver.onNext(DetailsRequest.newBuilder()
						.setStaffID(Integer.parseInt(detailStaffId.getText()))
						.setStaffFName(detailFName.getText())
						.setStaffLName(detailLName.getText())
						.setFloor(Integer.parseInt(detailFloor.getText())).build());
				
				requestObserver.onCompleted();
			}
			finally {
				
			}
		}
	}
	
}