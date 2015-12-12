import gnu.io.*;

public class Example {
  public static void main( String[] args ) throws NoSuchPortException {
    System.out.println("Hello, World!");
    CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("/dev/tty.usbserial-FTGQUH9U");
  }
}
