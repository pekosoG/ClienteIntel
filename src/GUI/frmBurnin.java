package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Component;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class frmBurnin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Box hBox;
	private JSlider sliderCPU;
	private JSpinner spinnerCPU;
	private Box hBox1;
	private JSlider slider2D;
	private JSpinner spinner2D;
	private Box hBox2;
	private JSlider sliderCD;
	private JSpinner spinnerCD;
	private Box hBox3;
	private JSlider slider3D;
	private JSpinner spinner3D;
	private Box hBox4;
	private JSlider sliderRAM;
	private JSpinner spinnerRAM;
	private Box hBox5;
	private JSlider sliderNET;
	private JSpinner spinnerNET;

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
		setBounds(100, 100, 672, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Parale en");
		header.add(lblNewLabel);
		
		textField = new JTextField();
		header.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("minutos o en");
		header.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		header.add(textField_1);
		textField_1.setColumns(10);
		
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
		hBox1.setEnabled(false);
		controles.add(hBox1);
		
		JLabel lbld = new JLabel("  2D");
		hBox1.add(lbld);
		
		slider2D = new JSlider();
		slider2D.setEnabled(false);
		slider2D.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) slider2D.getValue();
				spinner2D.setValue(valor);
			}
		});
		hBox1.add(slider2D);
		
		spinner2D = new JSpinner();
		spinner2D.setEnabled(false);
		spinner2D.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinner2D.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinner2D.getValue();
				slider2D.setValue(valor);
			}
		});
		hBox1.add(spinner2D);
		
		hBox2 = Box.createHorizontalBox();
		controles.add(hBox2);
		
		JLabel lblCd = new JLabel("  CD");
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
		hBox3.setEnabled(false);
		controles.add(hBox3);
		
		JLabel lbld_1 = new JLabel("  3D");
		hBox3.add(lbld_1);
		
		slider3D = new JSlider();
		slider3D.setEnabled(false);
		slider3D.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int valor= (Integer) slider3D.getValue();
				spinner3D.setValue(valor);
			}
		});
		hBox3.add(slider3D);
		
		spinner3D = new JSpinner();
		spinner3D.setEnabled(false);
		spinner3D.setModel(new SpinnerNumberModel(50, 0, 100, 1));
		spinner3D.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				int valor=(Integer)spinner3D.getValue();
				slider3D.setValue(valor);
			}
		});
		hBox3.add(spinner3D);
		
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
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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

	public void restablecer(){
		sliderCPU.setValue(50);
		spinnerCPU.setValue(50);
		slider2D.setValue(50);
		spinner2D.setValue(50);
		sliderCD.setValue(50);
		spinnerCD.setValue(50);
		slider3D.setValue(50);
		spinner3D.setValue(50);
		sliderRAM.setValue(50);
		spinnerRAM.setValue(50);
		sliderNET.setValue(50);
		spinnerNET.setValue(50);
	}
}
