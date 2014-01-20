package GUI;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.Guest;

public class HostGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel_1;
	private JCheckBox chckbxPrueba4;
	private JCheckBox chckbxPrueba3;
	private JCheckBox chckbxPrueba2;
	private JCheckBox chckbxPrueba1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel;
	private JTabbedPane tabbedPane;
	
	private frmBurnin elBurnin;
	private JButton btnConectarse;
	private JButton btnDesconectar;
	
	private String IP_Server="";
	private int PUERTO_DEFAULT=0;
	private Socket elSocket=null;
	protected ObjectOutputStream elOutput=null;
	protected ObjectInputStream elInput=null;
	protected HashMap<String,Guest>elCatalogo=null;
	private String id="";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HostGUI frame = new HostGUI();
					/*Esto es para darle la aparencia del OS*/
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SwingUtilities.updateComponentTreeUI(frame);

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HostGUI() {
		cargaConfig();
		teConectas();
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("HOST");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 501);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblGuest = new JLabel("# Guest:");
		lblGuest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuest.setBounds(12, 76, 65, 14);
		panel.add(lblGuest);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		comboBox.setBounds(85, 73, 77, 20);
		panel.add(comboBox);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] { //Contenido de prueba...
				{true, "01", "CentOS"},
				{false, "02", "SlackWare"},
				{true, "03", "Debian"},
				{true, "04", "Red-Hat"},
				{false, "05", "Fedora"},
			},
			new String[] { //Headers Sugeridos
				"Select", "Host ID", "OS"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setToolTipText("El contenido de est\u00E1 tabla ser\u00E1 Dinamico (Seg\u00FAn los Host Disponibles)");
		scrollPane.setBounds(12, 131, 388, 100);
		panel.add(scrollPane);
		
		JLabel lblGuestDisponibles = new JLabel("Guest Disponibles:");
		lblGuestDisponibles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGuestDisponibles.setBounds(10, 105, 176, 14);
		panel.add(lblGuestDisponibles);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setToolTipText("Las Pesta\u00F1as se a\u00F1adir\u00E1n dinamicamente, segun la cantidad de Guest seleccionados");
		tabbedPane.setBounds(10, 243, 390, 175);
		panel.add(tabbedPane);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Guest <ID>", null, panel_1, null);
		panel_1.setLayout(null);
		
		chckbxPrueba1 = new JCheckBox("Burnin'");
		chckbxPrueba1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(!chckbxPrueba1.isSelected())
					elBurnin.restablecer();
			}
		});
		chckbxPrueba1.setBounds(6, 23, 97, 23);
		panel_1.add(chckbxPrueba1);
		
		chckbxPrueba2 = new JCheckBox("Prueba2");
		chckbxPrueba2.setBounds(6, 49, 97, 23);
		panel_1.add(chckbxPrueba2);
		
		chckbxPrueba3 = new JCheckBox("Prueba3");
		chckbxPrueba3.setBounds(6, 75, 97, 23);
		panel_1.add(chckbxPrueba3);
		
		chckbxPrueba4 = new JCheckBox("Prueba4");
		chckbxPrueba4.setBounds(6, 101, 97, 23);
		panel_1.add(chckbxPrueba4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_1.setBounds(113, 24, 77, 20);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_2.setBounds(113, 50, 77, 20);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_3.setBounds(113, 76, 77, 20);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_4.setBounds(113, 102, 77, 20);
		panel_1.add(comboBox_4);
		
		JLabel lblPruebas = new JLabel("Pruebas");
		lblPruebas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPruebas.setBounds(8, 5, 93, 14);
		panel_1.add(lblPruebas);
		
		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrioridad.setBounds(113, 7, 77, 14);
		panel_1.add(lblPrioridad);
		
		JButton btnAjustes = new JButton("Ajustes");
		btnAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				elBurnin.setVisible(true);
			}
		});
		btnAjustes.setBounds(200, 25, 90, 20);
		panel_1.add(btnAjustes);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(193, 443, 89, 23);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(311, 443, 89, 23);
		panel.add(btnNewButton_1);
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.setBounds(271, 29, 129, 25);
		panel.add(btnDesconectar);
		
		btnConectarse = new JButton("Conectarse");
		btnConectarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConectarse.setBounds(142, 29, 117, 25);
		panel.add(btnConectarse);
		
		elBurnin= new frmBurnin();
		elBurnin.setVisible(false);
		//this.add(elBurnin);
	}

	/**
	 * Se conecta con el servidor, usando los parametros leidos del XML
	 * @see cargaConfig()
	 */
	private void teConectas() {
		try {
			this.elSocket= new Socket(this.IP_Server,this.PUERTO_DEFAULT);
			elInput = new ObjectInputStream(elSocket.getInputStream());
			elOutput = new ObjectOutputStream(elSocket.getOutputStream());
			
			elHandShake();
		} catch (UnknownHostException e) {
			System.out.println("Error al conectarse con el Host "+this.IP_Server+"\n"+e);
		} catch (IOException e) {
			System.out.println("Erro de IO \n"+e);
		}
	}
	
	/**
	 * Realiza el HandShake con el Servidor
	 */
	private void elHandShake(){
		String entrada="",salida="";
		
		try {
			entrada=(String)elInput.readObject();
			this.id=entrada;
			
			salida="INTEL-Cloud."+this.id;
			elOutput.writeObject(salida);
			
			entrada=(String)elInput.readObject();
			if(entrada.equalsIgnoreCase("INTEL-Cloud.OK")){
				entrada=(String)elInput.readObject();
				if(entrada.equalsIgnoreCase("GetBasicInfo")){
					salida=this.getBasicInfo();
					elOutput.writeObject(salida);
					
					solicitaListado();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void solicitaListado() {
		String salida="INFO-REQ=Guests";
		String entrada="";
		
		try {
			elOutput.writeObject(salida);
			
			//{ID=[ID],IP=[IP],OS=[OS],CORES=[CORES],MEM=[MEM]};*
			entrada=(String)elInput.readObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getBasicInfo() {
		//OS=<Sistema_Operativo>;CORES=<Num_Cores>;MEM=<Memoria_Libre>;Root=[1|0]
		String OS=System.getProperty("os.name"); 
		String CORES=String.valueOf(Runtime.getRuntime().availableProcessors());
		String MEM=String.valueOf(Runtime.getRuntime().freeMemory());
		String ROOT="1";
		return "OS="+OS+";CORES="+CORES+";MEM="+MEM+";Root="+ROOT;
	}

	/**
	 * Este metodo se encarga de cargar los siguientes datos:
	 * <ul>
	 * 		<li>IP del Host</li>
	 * 		<li>Puerto del Host</li>
	 * </ul>
	 * Esto lo pensé asi en caso de que tengamos que cambiar la IP o puerto</br>
	 * de el servicio, entonces solo cambiemos el XML y no tengamos que estar compilando
	 */
	private void cargaConfig() {
		try{
			File elXML = new File("CloudIntel_config.xml");
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(elXML);
			
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("param");
			
			for (int temp = 0; temp < nList.getLength(); temp++) {
				
				Node nNode = nList.item(temp); 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					this.IP_Server=eElement.getElementsByTagName("HOST_IP").item(0).getTextContent();
					this.PUERTO_DEFAULT=Integer.valueOf(eElement.getElementsByTagName("HOST_IP").item(0).getTextContent());
				}
			}
		}catch(Exception e){
			System.out.println("Error al leer el XML de configuracion "+e);
		}
	}
}

class elInput extends Thread{
	private HostGUI elHost=null;
}