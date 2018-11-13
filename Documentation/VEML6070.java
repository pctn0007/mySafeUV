import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

public class VEML6070
{
        public static void main(String args[]) throws Exception
        {

                while(true)
                {

                // Create I2CBus
                I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
                // Get I2C device, VEML6070 I2C address is 0x38(56)
                I2CDevice device = bus.getDevice(0x38);

                // Select command register
                // Integration time = 0.5T, shutdown mode disabled
                device.write((byte)0x02);
                Thread.sleep(500);

                // Read 2 bytes of data
                // uvlight msb, uvlight lsb
                byte[] data = new byte[2];
                data[0] = (byte)device.read(0x73);
                data[1] = (byte)device.read(0x71);

                // Convert the data
                int uvlight = (((data[0] & 0xFF) * 256) + data[1] & 0xFF);

                // Output data to screen
               System.out.printf("UV Light of The Device : %d %n", uvlight);
                }
        }
