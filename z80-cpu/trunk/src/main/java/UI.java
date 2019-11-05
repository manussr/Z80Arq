import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import net.sleepymouse.microprocessor.ProcessorException;
import net.sleepymouse.microprocessor.Z80.Z80Core;

public class UI extends JFrame{
	//Parte gráfica
		JPanel south_panel, p, mainR, secR, reg16b, regEsp;
		JLabel regA, regB, regC, regD, regE, regH, regL;
		JLabel regIX, regIY, regSP, regPC;
		JTextField regIX_t, regIY_t, regSP_t, regPC_t;
		JTextField regA_t, regB_t, regC_t, regD_t, regE_t, regH_t, regL_t,tstates_t;
		JLabel regAx, regBx, regCx, regDx, regEx, regHx, regLx, tstates;
		JTextField regAx_t, regBx_t, regCx_t, regDx_t, regEx_t, regHx_t, regLx_t;
		JLabel regHL, regBC, regDE;
		JTextField regHL_t, regBC_t, regDE_t;
		JLabel regHLx, regBCx, regDEx;
		JTextField regHLx_t, regBCx_t, regDEx_t;
		JTextField regF_t, regFx_t;
		JLabel regF, regFx;
		//Registros especiales
		JLabel iff1, iff2;
		JTextField iff1_t, iff2_t;
		JLabel regI, regR;
		JTextField regI_t, regR_t;
		//Toolbar
		JToolBar toolbar; 
		//Z80Demo z80Demo;
		//Botones
		static JButton iniciar;
		JButton stop;
		JButton reset;
		
		public UI() {
			setLayout(new BorderLayout());
			p=new JPanel();
			south_panel=new JPanel();
			south_panel.setLayout(new GridLayout(0,2));
			reg16b=crearReg16b();
			regEsp=crearRegEsp();
			p.setLayout(new GridLayout());
			p.add(crearRegPrincipal());
			p.add(crearRegSecundario());
			south_panel.add(reg16b);
			south_panel.add(regEsp);
			p.add(south_panel);
			toolbar=getToolBar();
			add(p, BorderLayout.CENTER);
			add(south_panel,BorderLayout.SOUTH );
			add(toolbar, BorderLayout.NORTH);
		
			//add(regEsp, BorderLayout.NORTH);
			setSize(650, 600);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Simulacion Z80");
			//procesador
			//z80Demo=this.z80Demo;
		}
		
		public JPanel crearRegPrincipal() {
			mainR=new JPanel();
			regA=new JLabel("A"); regB=new JLabel("B"); regC=new JLabel("C"); regD=new JLabel("D"); regE=new JLabel("E"); regH=new JLabel("H"); regL=new JLabel("L");
			regA_t=new JTextField(""); regB_t=new JTextField(""); regC_t=new JTextField(""); regD_t=new JTextField(""); regE_t=new JTextField(""); regH_t=new JTextField(""); regL_t=new JTextField("");
			mainR.setLayout(new GridLayout(7,2));
			regA_t.setEditable(false); regB_t.setEditable(false); regC_t.setEditable(false); regD_t.setEditable(false); regE_t.setEditable(false); regH_t.setEditable(false); regL_t.setEditable(false);
			regA_t.setBackground(Color.white); regB_t.setBackground(Color.white); regC_t.setBackground(Color.white); regD_t.setBackground(Color.white); regE_t.setBackground(Color.white); regH_t.setBackground(Color.white); regL_t.setBackground(Color.white);
			//Reg principal
			mainR.add(regA); mainR.add(regA_t); mainR.add(regB); mainR.add(regB_t); mainR.add(regC); mainR.add(regC_t); mainR.add(regD); mainR.add(regD_t); 
			mainR.add(regE); mainR.add(regE_t); mainR.add(regH); mainR.add(regH_t); mainR.add(regL); mainR.add(regL_t);
			
			return mainR;
		}
		
		public JPanel crearRegSecundario() {
			secR=new JPanel();
			regAx=new JLabel("A\'"); regBx=new JLabel("B\'"); regCx=new JLabel("C\'"); regDx=new JLabel("D\'"); regEx=new JLabel("E\'"); regHx=new JLabel("H\'"); regLx=new JLabel("L\'");
			regAx_t=new JTextField(""); regBx_t=new JTextField(""); regCx_t=new JTextField(""); regDx_t=new JTextField(""); regEx_t=new JTextField(""); regHx_t=new JTextField(""); regLx_t=new JTextField("");
			secR.setLayout(new GridLayout(7,2));
			regAx_t.setEditable(false); regBx_t.setEditable(false); regCx_t.setEditable(false); regDx_t.setEditable(false); regEx_t.setEditable(false); regHx_t.setEditable(false); regLx_t.setEditable(false);
			regAx_t.setBackground(Color.white); regBx_t.setBackground(Color.white); regCx_t.setBackground(Color.white); regDx_t.setBackground(Color.white); regEx_t.setBackground(Color.white); regHx_t.setBackground(Color.white); regLx_t.setBackground(Color.white);
			//Reg secundario
			secR.add(regAx); secR.add(regAx_t); secR.add(regBx); secR.add(regBx_t); secR.add(regCx); secR.add(regCx_t); secR.add(regDx); secR.add(regDx_t); 
			secR.add(regEx); secR.add(regEx_t); secR.add(regHx); secR.add(regHx_t); secR.add(regLx); secR.add(regLx_t);
			return secR;
		}
		
		public JPanel crearReg16b() {
			reg16b=new JPanel();
			reg16b.setLayout(new GridLayout(4,6));
			regIX=new JLabel("IX"); regIY=new JLabel("IY"); regSP=new JLabel("SP"); regPC=new JLabel("PC");
			tstates=new JLabel("Clock"); tstates_t=new JTextField("");
			regIX_t=new JTextField(""); regIY_t=new JTextField(""); regSP_t=new JTextField(""); regPC_t=new JTextField("");
			regIX_t.setEditable(false); regIY_t.setEditable(false); regSP_t.setEditable(false); regPC_t.setEditable(false);
			regIX_t.setBackground(Color.white); regIY_t.setBackground(Color.white); regSP_t.setBackground(Color.white); regPC_t.setBackground(Color.white);
			tstates_t.setEditable(false); tstates_t.setBackground(Color.white);
			//F y F alt
			regF=new JLabel("F"); regFx=new JLabel("F\'");
			regF_t=new JTextField(""); regFx_t=new JTextField("");
			regF_t.setEditable(false); regFx_t.setEditable(false);
			regF_t.setBackground(Color.white); regFx_t.setBackground(Color.white);
			//Reg 16Bits
			regBC=new JLabel("BC"); regDE=new JLabel("DE"); regHL=new JLabel("HL");
			regBCx=new JLabel("BC\'"); regDEx=new JLabel("DE\'"); regHLx=new JLabel("HL\'");
			regBC_t=new JTextField(""); regDE_t=new JTextField(""); regHL_t=new JTextField("");
			regBCx_t=new JTextField(""); regDEx_t=new JTextField(""); regHLx_t=new JTextField("");
			regBC_t.setEditable(false); regDE_t.setEditable(false); regHL_t.setEditable(false);
			regBCx_t.setEditable(false); regDEx_t.setEditable(false); regHLx_t.setEditable(false);
			regBC_t.setBackground(Color.white); regDE_t.setBackground(Color.white); regHL_t.setBackground(Color.white);
			regBCx_t.setBackground(Color.white); regDEx_t.setBackground(Color.white); regHLx_t.setBackground(Color.white);
			//Añadiendo al panel
			reg16b.add(regIX); reg16b.add(regIX_t); reg16b.add(regIY); reg16b.add(regIY_t); 
			reg16b.add(regSP); reg16b.add(regSP_t); reg16b.add(regPC); reg16b.add(regPC_t);
			reg16b.add(regBC); reg16b.add(regBC_t); reg16b.add(regDE); reg16b.add(regDE_t);
			reg16b.add(regHL); reg16b.add(regHL_t);reg16b.add(regBCx); reg16b.add(regBCx_t); 
			
			reg16b.add(regDEx); reg16b.add(regDEx_t); reg16b.add(regHLx); reg16b.add(regHLx_t);
			reg16b.add(regIX); reg16b.add(regIX_t); reg16b.add(regIY); reg16b.add(regIY_t); 
			reg16b.add(regSP); reg16b.add(regSP_t); reg16b.add(regPC); reg16b.add(regPC_t); 
			reg16b.add(tstates); reg16b.add(tstates_t); 
			
			reg16b.add(regF); reg16b.add(regF_t);
			/*
			reg16b.add(regFx); reg16b.add(regFx_t);
			*/
			return reg16b;
		}
		
		public JPanel crearRegEsp() {
			regEsp=new JPanel();
			regEsp.setLayout(new GridLayout(2,4));
			regR=new JLabel("R"); regI=new JLabel("I");
			iff1=new JLabel("IFF1"); iff2=new JLabel("IFF2");
			//
			regR_t=new JTextField(""); regI_t=new JTextField("");
			iff1_t=new JTextField(""); iff2_t=new JTextField("");
			//
			regR_t.setEditable(false); regI_t.setEditable(false);
			regR_t.setBackground(Color.white); regI_t.setBackground(Color.white);
			//
			iff1_t.setEditable(false); iff2_t.setEditable(false);
			iff1_t.setBackground(Color.white); iff2_t.setBackground(Color.white);
			//
			regR.setSize(50,50);
			regEsp.add(regR); regEsp.add(regR_t); regEsp.add(regI); regEsp.add(regI_t); 
			regEsp.add(iff1); regEsp.add(iff1_t); regEsp.add(iff2); regEsp.add(iff2_t);
			return regEsp;
		}
		
		public JToolBar getToolBar() {
	        toolbar = new JToolBar();
	        iniciar=new JButton();
	        reset=new JButton("Reiniciar simulacion");
	        stop=new JButton("Parar simulacion");
	        toolbar.add(iniciar);
	        toolbar.add(reset);
	       // toolbar.add(stop);
	        //Añadiendo los action listener
	        iniciar.setAction(new InicioSwingWorker(this));
	        iniciar.setText("Iniciar simulacion");
	        reset.setAction(new ResetSwingWorker(this));
	        reset.setText("Reiniciar simulacion");
	        //reset.setAction();
	        //stop.setAction();
	        return toolbar;
	    }
}
