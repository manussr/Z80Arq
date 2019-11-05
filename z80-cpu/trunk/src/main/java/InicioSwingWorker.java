import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.SwingWorker;

import net.sleepymouse.microprocessor.ProcessorException;
import net.sleepymouse.microprocessor.Z80.Z80Core;

public class InicioSwingWorker extends AbstractAction {
	public UI gui;
	public InicioSwingWorker(UI gui)
	{
		this.gui=gui;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		final SwingWorker worker = new SwingWorker(){
 
			@Override
			protected Object doInBackground() throws Exception {
				Z80Core z80 = new Z80Core(new Z80Memory(),
                        new Z80IO());
					z80.reset();
					while (!z80.getHalt())
					{
					try
					{
					z80.executeOneInstruction();
					//reg principal
					gui.regA_t.setText(z80.getRegA().toUpperCase());
					
					gui.regB_t.setText(z80.getRegB().toUpperCase());
					gui.regC_t.setText(z80.getRegC().toUpperCase());
					gui.regD_t.setText(z80.getRegD().toUpperCase());
					gui.regE_t.setText(z80.getRegE().toUpperCase());
					gui.regF_t.setText(z80.getRegF().toUpperCase());
					gui.regH_t.setText(z80.getRegH().toUpperCase());
					gui.regL_t.setText(z80.getRegL().toUpperCase());
					//reg sec
					gui.regAx_t.setText(z80.getRegA_ALT().toUpperCase());
					gui.regBx_t.setText(z80.getRegB_ALT().toUpperCase());
					gui.regCx_t.setText(z80.getRegC_ALT().toUpperCase());
					gui.regDx_t.setText(z80.getRegD_ALT().toUpperCase());
					gui.regEx_t.setText(z80.getRegE_ALT().toUpperCase());
					gui.regHx_t.setText(z80.getRegH_ALT().toUpperCase());
					gui.regLx_t.setText(z80.getRegL_ALT().toUpperCase());
					//reg 16 b
					gui.regIX_t.setText(z80.getRegIX());
					gui.regIY_t.setText(z80.getRegIY());
					gui.regPC_t.setText(Integer.toHexString(z80.getProgramCounter()).toUpperCase());
					gui.regSP_t.setText(Integer.toHexString(z80.getSP()).toUpperCase());
					gui.regDE_t.setText(z80.mgetDE().toUpperCase());
					gui.regBC_t.setText(z80.mgetBC().toUpperCase());
					gui.regHL_t.setText(z80.mgetHL().toUpperCase());
					gui.regDEx_t.setText(z80.mgetDE_ALT().toUpperCase());
					gui.regBCx_t.setText(z80.mgetBC_ALT().toUpperCase());
					gui.regHLx_t.setText(z80.mgetHL_ALT().toUpperCase());
					//clock
					//tstates_t.setText(Long.toHexString(z80.getTStates()).toUpperCase());
					gui.tstates_t.setText(""+z80.getTStates());
					//System.out.println(z80.getHL());
					//System.out.println(z80.getMem());
					//Reg especiales 
					gui.regI_t.setText(z80.getI().toUpperCase());
					gui.regR_t.setText(z80.getR().toUpperCase());
					//Interrupt control
					gui.iff1_t.setText(""+z80.getIFF1());
					gui.iff2_t.setText(""+z80.getIFF2());
					Thread.sleep(500);
					
					}
					catch (ProcessorException e)
					{
					System.out.println("Hardware crash, oops! "
					                 + e.getMessage());
					}
					}	
				return null;
			}	
		};
		worker.execute();
	}

}
