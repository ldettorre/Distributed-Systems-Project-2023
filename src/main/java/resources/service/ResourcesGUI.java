package resources.service;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import resources.service.resourcesServicesGrpc.resourcesServicesStub;

public class ResourcesGUI implements ActionListener{

	String host = "localhost";
	int port = 50052;
	
	ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
	resourcesServicesStub asyncStub = resourcesServicesGrpc.newStub(channel);
	
	private JTextField printInput;
	private JTextArea printOutput;
	
	private JPanel wifiPrintingJPanel() {
		JPanel panel = new JPanel();

		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);

		JLabel accessLabel = new JLabel("Print Documents")	;
		panel.add(accessLabel);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));
		printInput = new JTextField("",10);
		panel.add(printInput);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		JButton button = new JButton("Request Printing");
		button.addActionListener(this);
		panel.add(button);
		panel.add(Box.createRigidArea(new Dimension(10, 0)));

		printOutput = new JTextArea();
		printOutput.setEditable(false);
		panel.add(printOutput);

		panel.setLayout(boxlayout);

		return panel;

	}
	
	public static void main(String[] args) {

		ResourcesGUI gui = new ResourcesGUI();

		gui.build();
	}

	private void build() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Resources Controller");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the panel to add buttons
		JPanel panel = new JPanel();

		// Set the BoxLayout to be X_AXIS: from left to right
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

		panel.setLayout(boxlayout);

		// Set border for the panel
		panel.setBorder(new EmptyBorder(new Insets(50, 100, 50, 100)));
	
		panel.add(wifiPrintingJPanel() );
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
		
		// wifiPrinting Method
		if(label.equals("Request Printing")) {
			System.out.println("Request Printing Selected");
			StreamObserver<PrintResponse> responseObserver = new StreamObserver<PrintResponse>() {

				@Override
				public void onNext(PrintResponse response) {
					// TODO Auto-generated method stub
					printOutput.append("Document ID: "+ response.getDocId());
					printOutput.append("Print status: "+ response.getIsPrinted());
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Finished requesting documents");
				}
			};
				StreamObserver<PrintRequest> requestObserver = asyncStub.wifiPrinting(responseObserver);
				System.out.println(Integer.parseInt(printInput.getText()));
				try {
					requestObserver.onNext(PrintRequest.newBuilder().setDocId(Integer.parseInt(printInput.getText())).build());
//					Thread.sleep(1000);
//					requestObserver.onNext(PrintRequest.newBuilder().setDocId(2).build());
//					Thread.sleep(1000);
//					requestObserver.onNext(PrintRequest.newBuilder().setDocId(3).build());
//					Thread.sleep(1000);
//					requestObserver.onNext(PrintRequest.newBuilder().setDocId(4).build());
//					Thread.sleep(1000);
//					requestObserver.onNext(PrintRequest.newBuilder().setDocId(5).build());
//					Thread.sleep(1000);
//					
					requestObserver.onCompleted();
					Thread.sleep(1000);
				}
				catch(StatusRuntimeException | InterruptedException q) {
					System.out.println(((StatusRuntimeException) q).getStatus());
				}
			}
		}
	}


