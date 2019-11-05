/**
 * Very simple Z80 computer
 */
import net.sleepymouse.microprocessor.ProcessorException;
import net.sleepymouse.microprocessor.Z80.Z80Core;
 
public class Z80Demo
{
    /**
     * Create CPU and run a program
     */
	/*
    public static void main(String[] args)
    {
    	//UI gui=new UI();
        //Z80Demo z80Demo = new Z80Demo();
        //z80Demo.run();
    }
 	*/
    // Create CPU and loop through program
    public void run()
    {
        Z80Core z80 = new Z80Core(new Z80Memory(),
                                          new Z80IO());
        z80.reset();
        while (!z80.getHalt())
        {
            try
            {
                z80.executeOneInstruction();
            }
            catch (ProcessorException e)
            {
                System.out.println("Hardware crash, oops! "
                                   + e.getMessage());
            }
        }
    }
}