import net.sleepymouse.microprocessor.IBaseDevice;
 
public class Z80IO implements IBaseDevice
{
    /**
     * Do nothing
     */
    @Override
    public int IORead(int address)
    {
        return 0;
    }
 
    /**
     * Print a character
     */
    @Override
    public void IOWrite(int address, int data)
    {
        System.out.print((char) data);
    }
}