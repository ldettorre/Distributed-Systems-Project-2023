package carpark.service;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import carpark.service.carparkServicesGrpc.carparkServicesBlockingStub;
import carpark.service.carparkServicesGrpc.carparkServicesStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class CarparkGUI implements ActionListener{
	

	
	String host = "localhost";
	int port = 50051;
	
	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	carparkServicesBlockingStub blockingStub = carparkServicesGrpc.newBlockingStub(channel);
	carparkServicesStub asyncStub = carparkServicesGrpc.newStub(channel);

	
	private JTextField accessInput, accessOutput;
	private JTextField leaveOutput;
	private JTextArea spacesOutput;
	private JTextField sumAvailOutput;
	
	
	
	private JPanel accessCarparkJPanel() {
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
		accessOutput.setEditable(false);
		panel.add(accessOutput);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel leaveCarparkJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel spacesLabel = new JLabel("Request Exit.")	;
		panel.add(spacesLabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Leave");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		leaveOutput = new JTextField("", 20);
		leaveOutput.setEditable(false);
		panel.add(leaveOutput);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getAvailSpacesJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel leaveLabel = new JLabel("Show Available Parking Bays.")	;
		panel.add(leaveLabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Space Locations");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 290)));

		spacesOutput = new JTextArea();
		spacesOutput.setEditable(false);
		spacesOutput.setLineWrap(true);
		panel.add(spacesOutput);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	private JPanel getSumAvailSpacesJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel getAvailLabel = new JLabel("Get No. Avail Spaces")	;
		panel.add(getAvailLabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Sum Avail");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		sumAvailOutput = new JTextField("", 20);
		sumAvailOutput.setEditable(false);
		panel.add(sumAvailOutput);

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
	
		panel.add(accessCarparkJPanel() );
		panel.add(leaveCarparkJPanel() );
		panel.add(getAvailSpacesJPanel());
		panel.add(getSumAvailSpacesJPanel());
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
		
		// accessCarpark Method
		if(label.equals("Request Access")) {
			System.out.println("Request Access Selected");
			carpark.service.AccessRequest request = AccessRequest.newBuilder().setIdNumber(accessInput.getText()).build();
			carpark.service.AccessResponse response = blockingStub.accessCarpark(request);
			accessOutput.setText(response.getMessage());
		}
		// leaveCarpark Method
		else if(label.equals("Request Leave")) {
			System.out.println("Request Leave Selected");
			carpark.service.LeaveRequest request = LeaveRequest.newBuilder().build();
			carpark.service.LeaveResponse response = blockingStub.leaveCarpark(request);
			leaveOutput.setText(response.getMessage());
		}
		// getAvailSpaces Method
		else if(label.equals("Request Space Locations")) {
			System.out.println("Request Space Locations Selected");
			spacesOutput.selectAll();
			spacesOutput.replaceSelection("");
			SpacesRequest request = SpacesRequest.newBuilder().build();
			Iterator<SpacesResponse> response = blockingStub.getAvailSpaces(request);
			
			while (response.hasNext()) {
				SpacesResponse singleResponse = response.next();
				System.out.println(singleResponse.getMessage());
			    spacesOutput.append(singleResponse.getMessage()+", \n");
			}
		}
		// getSumAvailSpaces Method
		else if(label.equals("Request Sum Avail")){
			System.out.println("Requesting Sum Of Available Spaces");
			StreamObserver<AvailResponse> responseObserver = new StreamObserver<AvailResponse>() {
				
				@Override
				public void onNext(AvailResponse response) {
					// TODO Auto-generated method stub
					System.out.println("Number of available parking spaces: " + response.getSumAvail());
				}
		
				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					System.out.println("Error with getSumAvailSpaces client stream method");
				}
				
				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Finished client streaming sum of available spaces.");
					sumAvailOutput.setText("Finished Streaming To Server.");
				}
			};
			
			StreamObserver<AvailRequest> requestObserver = asyncStub.getSumAvailSpaces(responseObserver);
			Boolean[] availStatuses = {true, true, false, false, true, false, true, true};
			try {
				for(int i=0;i<availStatuses.length;i++) {
					AvailRequest request = AvailRequest.newBuilder().setIsAvail(availStatuses[i]).build();
					requestObserver.onNext(request);
					Thread.sleep(500);
				}
				requestObserver.onCompleted();
				Thread.sleep(1000);
			}
			catch(StatusRuntimeException | InterruptedException q) {
				System.out.println(((StatusRuntimeException) q).getStatus());
			}
		}
		
	}
}