import gnu.io.*;
import java.io.OutputStream;
import java.io.IOException;

public class Example
{
  public static void main( String[] args ) throws
    NoSuchPortException, IOException, PortInUseException, UnsupportedCommOperationException
    {
      System.out.println("RXTX simplest write to serial line example");
      if( args.length < 1 )
      {
        System.out.println("Invocation: java -cp RXTXcomm.jar:. Example <serial_port_device>");
        return;
      }

      CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier( args[0] );
      CommPort commPort = portIdentifier.open("Test RXTX", 2000);
      SerialPort serialPort = (SerialPort) commPort;
      serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
      OutputStream out = serialPort.getOutputStream();

      out.write(new String("hello, world!\n").getBytes());
      out.write(new String("This is written by example test program\n\n").getBytes());
    }
}
