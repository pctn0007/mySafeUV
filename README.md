# mySafeUV - Introduction to the development
In today's society, there are many UVI detection devices. However, many skin cancer patience have very minimal knowledge on the various UVI values and their associated index rating (i.e. extreme, very high, high, normal, etc.). Moreso, the availability of a small, yet portable detection devices have only recently been used by general public. With respect cancer patients, the only tangible item that are used to warn/express concerns regarding skin cancer and UVI are standard brochures and standard online information provided by cancer-based foundations.

In this build instruction set, we will learn how to develop a simple, but effective UV Index sensing device that will not only detect the UV index of various light sources, it will display them in a readable format for any doctor, scientist, average Joe or student to recognize and interpret.


# Step 1 - Planning and Design:

To start, it is important to get an idea and make note of all the required hardware and/or material you may need. For this project, I have included the required components, as well as a potential aquiring source and total pricing (CAD):

-----------------------------------------------------------------------------------
 PRIMARY HARDWARE:
-----------------------------------------------------------------------------------
  1) Raspberry Pi of your choice (I used 3 B+)
        --> Amazon.ca ($119.00 CAD)
  2) VEML6070 UV Index sensor (0x039) 
        --> Adafruit.ca ($15.37 CAD)
-----------------------------------------------------------------------------------
 ADDITIONAL PARTS:
-----------------------------------------------------------------------------------
  1) Acrylic 3D printing material of your choise.
        --> Provided by post-secondary school (i.e. you may want to outsource this).
  2) Safety goggles (Safety first!)
  3) Ribon cables with both male and female contact ends
        --> Amazon.ca (Included with Pi kit)
  4) Standard breadboard (for testing purposes)
  
  Next, you may want to attempt to read and interpret the sensor's datasheet to get an idea for the various setups and programming of the device. Please see below for an example setup using a testing breadboard surface, wire leads and a 3.3V to 5V (your choice) power supply:
  
![VEML6070 UV Index Breadboarding Prints](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/mySafeUV_Breadboard_bb.jpg)

* The software used to build the structure in the image above is called: Fritzing (Beta).

# Step 2 - Building an efficient circuit:

Now that you have all your parts and you have determined how to connect your sensor device, it is time to build an actual PCB structure. First, planning is important. I recommend using Fritzing (Beta) once again by switching over to the PCB view on the top display tabs. It is important here to make sure that all copper leads are placed in the most efficient manner and are connected on the propper sides of the PCB. Moreso, Yellow lines in the tool indicate the top view of the board, while the orange lines indicate the bottom. To connect the both surfaces together, use VIA's to link them together. Below is an example PCB design before printing. Keep in mind its not the most efficient layout; however, all linings are place on the correct sides of the board. Note: It is a good idea to label all pins on your sensor using CHOPPER labels.

![PCB Diagram - Fritzing](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/mySafeUV_Breadboard_pcb.jpg)

# Step 3 - Printing your boards and Soldering a Sensor:

During this stage of development, it is important to focus much attention to detail and your fine motor skills, as soldering these smaller devices can be a challenge. Before soldering, I recommend making sure that all connections are seperated with no possilbe shorts (i.e. solding two or more sensor pins on one soldering line). To make this step a little easier, a youtube link below may assist in understanding how to start soldering. Note, you should always wear your saefty glasses and have a standard first aid kit near by. To solder, I recommend a temperature no more than 750 degrees C. Please see the link below for further help, as well as the provided image of a succesful (but newbie) soldering job.

 [![YouTube Soldering for Beginners](https://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg)](https://www.youtube.com/watch?v=oqV2xU1fee8)


![mySafeUV PCB](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/20181120_124350_HDR.jpg)

# Step 4 - Connecting Our Device to a Pi:

In order to get an actual reading via the sensor we have just soldered to out PCB, we must connect to an input/output source, such as your new Raspberry Pi! First, you want to make sure that the sensors male pins are aligned properly with a set of female stubs connecting to your Pi's male pins. Once you have mounted the sensor to your pi and your pi to an output (i.e. monitor or tv), youre ready to program. Now, keep in mind this step could be performed in Step 1 after receiving a testing breadboard and sensor (i.e. this will help you detect a faulty sensor before soldering it to anything; saves some time and avoids error which may inflict a lag in a Critical Path). 

The first step you should take in programming your device is to detect the appropriate address that your sensor might require. For example, the VEML6070 uses addresses 0x38 and 0x39, as indicated in the example output below:

![VEML6070 UV Index I2C Detection](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/VEML6070_I2C_Detect.jpg)

In order to detect your device, you can use the terminal commands:

	```
sudo shutdown -h now
sudo apt-get install i2c-tools
sudo i2cdetect -y 1
	```


DETECT ACTUAL READINGS

In order to detect actual readable values, the follow source code will provide you with a generic UV intensity values. Note, the output values are NOT actual UV index readings. It is important to read the VEML6070 datasheet in order to understand how to convert these values accordingly. For this instruction set, we are NOT using any additional resistors to lag the output.

VEML6070.java sample source code:

	```
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
	```
After using the code above, you should see something that looks more like this on your display/output:

![mySafeUV output](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/mySafeUV_output.jpg)

# Step 5 - Enclosure Design and Cutting:

![mySafeUV Case](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/case1.jpg)

![mySafeUV Enclosure](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/Pi2CaseX6.pdf)
