package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class frmBurnin extends JFrame {

	private JPanel contentPane;
	private JTextField txtMins;
	private JTextField txtCiclos;
	private Box hBox;
	private JSlider sliderCPU;
	private JSpinner spinnerCPU;
	private Box hBox1;
	private JSlider sliderSerial;
	private JSpinner spinnerSerial;
	private Box hBox2;
	private JSlider sliderCD;
	private JSpinner spinnerCD;
	private Box hBox3;
	private JSlider sliderParal;
	private JSpinner spinnerParal;
	private Box hBox4;
	private JSlider sliderRAM;
	private JSpinner spinnerRAM;
	private Box hBox5;
	private JSlider sliderNET;
	private JSpinner spinnerNET;
	private Box hBox6;
	private JLabel lblDisco;
	private JSlider sliderDisk;
	private JSpinner spinnerDisk;
	private Component horizontalStrut_3;
	private Box hBox7;
	private JLabel lblUsb;
	private JSlider sliderUSB;
	private JSpinner spinnerUSB;

	/**
	 * Create the frame.
	 */
	
	public frmBurnin() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		
		
		setTitle("el Burnin'");
		setAlwaysOnTop(true);
		setBounds(100, 100, 745, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Parale en");
		header.add(lblNewLabel);
		
		txtMins = new JTextField();
		header.add(txtMins);
		txtMins.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("minutos o en");
		header.add(lblNewLabel_1);
		
		txtCiclos = new JTextField();
		header.add(txtCiclos);
		txtCiclos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ciclos (0 = forever)");
		header.add(lblNewLabel_2);
		
		JPanel controles = new JPanel();
		contentPane.add(controles, BorderLayout.CENTER);
		
		hBox = Box.createHorizontalBox();
		controles.add(hBox);
		
		JLabel lblNewLabel_3 = new JLabel("CPU");
		hBox.add(lblNewLabel_3);
		
		sliderCPU = new JSlider();
		sliderCPU.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderCPU.getValue();
				spinnerCPU.setValue(valor);
			}
		});
		hBox.add(sliderCPU);
		
		spinnerCPU = new JSpinner();
		spinnerCPU.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerCPU.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerCPU.getValue();
				sliderCPU.setValue(valor);
			}
		});		
		hBox.add(spinnerCPU);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		controles.add(horizontalStrut);
		
		hBox1 = Box.createHorizontalBox();
		controles.add(hBox1);
		
		JLabel lbld = new JLabel("Serial");
		hBox1.add(lbld);
		
		sliderSerial = new JSlider();
		sliderSerial.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderSerial.getValue();
				spinnerSerial.setValue(valor);
			}
		});
		hBox1.add(sliderSerial);
		
		spinnerSerial = new JSpinner();
		spinnerSerial.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerSerial.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerSerial.getValue();
				sliderSerial.setValue(valor);
			}
		});
		hBox1.add(spinnerSerial);
		
		hBox2 = Box.createHorizontalBox();
		controles.add(hBox2);
		
		JLabel lblCd = new JLabel("CD");
		hBox2.add(lblCd);
		
		sliderCD = new JSlider();
		sliderCD.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderCD.getValue();
				spinnerCD.setValue(valor);
			}
		});
		hBox2.add(sliderCD);
		
		spinnerCD = new JSpinner();
		spinnerCD.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerCD.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerCD.getValue();
				sliderCD.setValue(valor);
			}
		});
		hBox2.add(spinnerCD);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		controles.add(horizontalStrut_1);
		
		hBox3 = Box.createHorizontalBox();
		controles.add(hBox3);
		
		JLabel lbld_1 = new JLabel("Paralelo");
		hBox3.add(lbld_1);
		
		sliderParal = new JSlider();
		sliderParal.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderParal.getValue();
				spinnerParal.setValue(valor);
			}
		});
		hBox3.add(sliderParal);
		
		spinnerParal = new JSpinner();
		spinnerParal.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerParal.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerParal.getValue();
				sliderParal.setValue(valor);
			}
		});
		hBox3.add(spinnerParal);
		
		hBox4 = Box.createHorizontalBox();
		controles.add(hBox4);
		
		JLabel lblRam = new JLabel("RAM");
		hBox4.add(lblRam);
		
		sliderRAM = new JSlider();
		sliderRAM.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderRAM.getValue();
				spinnerRAM.setValue(valor);
			}
		});
		hBox4.add(sliderRAM);
		
		spinnerRAM = new JSpinner();
		spinnerRAM.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerRAM.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerRAM.getValue();
				sliderRAM.setValue(valor);
			}
		});
		hBox4.add(spinnerRAM);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		controles.add(horizontalStrut_2);
		
		hBox5 = Box.createHorizontalBox();
		controles.add(hBox5);
		
		JLabel lblNet = new JLabel("NET");
		hBox5.add(lblNet);
		
		sliderNET = new JSlider();
		sliderNET.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderNET.getValue();
				spinnerNET.setValue(valor);
			}
		});
		hBox5.add(sliderNET);
		
		spinnerNET = new JSpinner();
		spinnerNET.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerNET.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerNET.getValue();
				sliderNET.setValue(valor);
			}
		});
		hBox5.add(spinnerNET);
		
		hBox6 = Box.createHorizontalBox();
		controles.add(hBox6);
		
		lblDisco = new JLabel("Disco");
		hBox6.add(lblDisco);
		
		sliderDisk = new JSlider();
		sliderDisk.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderDisk.getValue();
				spinnerDisk.setValue(valor);
			}
		});
		hBox6.add(sliderDisk);
		
		spinnerDisk = new JSpinner();
		spinnerDisk.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerDisk.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerDisk.getValue();
				sliderDisk.setValue(valor);
			}
		});
		hBox6.add(spinnerDisk);
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		controles.add(horizontalStrut_3);
		
		hBox7 = Box.createHorizontalBox();
		controles.add(hBox7);
		
		lblUsb = new JLabel("USB");
		hBox7.add(lblUsb);
		
		sliderUSB = new JSlider();
		hBox7.add(sliderUSB);
		sliderUSB.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) sliderUSB.getValue();
				spinnerUSB.setValue(valor);
			}
		});
		
		spinnerUSB = new JSpinner();
		spinnerUSB.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinnerUSB.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinnerUSB.getValue();
				sliderUSB.setValue(valor);
			}
		});
		hBox7.add(spinnerUSB);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					GeneraXMLBurnin();
					dispose();
					JOptionPane.showMessageDialog(null,"Archivo de Configuracion Guardado!");
			}
		});
		panel.add(btnOk);
		
		JButton btnRest = new JButton("Restaurar");
		btnRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restablecer();
			}
		});
		panel.add(btnRest);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(btnCancelar);
	}

	protected void GeneraXMLBurnin() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docFactory.newDocumentBuilder();
			
			// root
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("test");
			doc.appendChild(rootElement);
			
			Element programName = doc.createElement("program_name");
			programName.setTextContent("BurninTest");
			rootElement.appendChild(programName);
			
			Element config= doc.createElement("archivo_configuracion");
			rootElement.appendChild(config);
			
			Element autoStop= doc.createElement("parametro");
			autoStop.setAttribute("nombre", "AutoStopMinutes");
			autoStop.setTextContent(this.txtMins.getText());
			config.appendChild(autoStop);
			
			Element autoStopC= doc.createElement("parametro");
			autoStopC.setAttribute("nombre", "AutoStopCycles");
			autoStopC.setTextContent(this.txtCiclos.getText());
			config.appendChild(autoStopC);
			
			Element CPU=doc.createElement("parametro");
			CPU.setAttribute("nombre", "CPU");
			CPU.setTextContent(String.valueOf(this.spinnerCPU.getValue()));
			config.appendChild(CPU);
			
			Element DVD=doc.createElement("parametro");
			DVD.setAttribute("nombre", "CDDVD");
			DVD.setTextContent(String.valueOf(this.spinnerCD.getValue()));
			config.appendChild(DVD);
			
			Element MEM=doc.createElement("parametro");
			MEM.setAttribute("nombre","Memory");
			MEM.setTextContent(String.valueOf(this.spinnerRAM.getValue()));
			config.appendChild(MEM);
			
			Element SER= doc.createElement("parametro");
			SER.setAttribute("nombre","Serial");
			SER.setTextContent(String.valueOf(this.spinnerSerial.getValue()));
			config.appendChild(SER);
			
			Element PAR=doc.createElement("parametro");
			PAR.setAttribute("nombre","Parallel");
			PAR.setTextContent(String.valueOf(this.spinnerParal.getValue()));
			config.appendChild(PAR);
			
			Element Disk=doc.createElement("parametro");
			Disk.setAttribute("nombre","Disk");
			Disk.setTextContent(String.valueOf(this.spinnerDisk.getValue()));
			config.appendChild(Disk);
			
			Element NET= doc.createElement("parametro");
			NET.setAttribute("nombre","Network");
			NET.setTextContent(String.valueOf(this.spinnerNET.getValue()));
			config.appendChild(NET);
			
			Element USB=doc.createElement("parametro");
			USB.setAttribute("nombre","USB");
			USB.setTextContent(String.valueOf(this.spinnerUSB.getValue()));
			config.appendChild(USB);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("xml_template.xml"));
	 
			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);
	 
			transformer.transform(source, result);
	 
			System.out.println("Archivo Guardado!!");
	 
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

	public void restablecer(){
		sliderCPU.setValue(50);
		spinnerCPU.setValue(50);
		sliderSerial.setValue(50);
		spinnerSerial.setValue(50);
		sliderCD.setValue(50);
		spinnerCD.setValue(50);
		sliderParal.setValue(50);
		spinnerParal.setValue(50);
		sliderRAM.setValue(50);
		spinnerRAM.setValue(50);
		sliderNET.setValue(50);
		spinnerNET.setValue(50);
		sliderDisk.setValue(50);
		spinnerDisk.setValue(50);
		sliderUSB.setValue(50);
		spinnerUSB.setValue(50);
	}
}
