import net.sleepymouse.microprocessor.IMemory;
 
public class Z80Memory implements IMemory
{
    int[]   memory  = new int[] {
                        0x21, 0x0C, 0x00, // ld hl, 0008
            0x06, 0x0F, // ld b,0f
            0x7e, // ld a,(hl)
            0x23, // inc hl
            0xD3, 0x00, // out (00), a
            0x10, 0xFA, // djnz
            0x76, // halt
            0x48, 0x65, 0x6C, 0x6C, 0x6F, // Message ASCII
            0x20, 0x77, 0x6F, 0x72, 0x6C, //
            0x64, 0x21, 0x20, 0x0D, 0x0A };
 
    @Override
    // Read a byte from memory
    public int readByte(int address)
    {
        return memory[address];
    }
 
    @Override
    // Read a word from memory
    public int readWord(int address)
    {
        return readByte(address) + readByte(address + 1)*256;
    }
 
    @Override
    public void writeByte(int address, int data)
    {}
 
    @Override
    public void writeWord(int address, int data)
    {}
        
}