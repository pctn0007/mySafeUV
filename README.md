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

During this stage of development, it is important to focus much attention to detail and your fine motor skills, as soldering these smaller devices can be a challenge. Before soldering, I recommend making sure that all connections are seperated with no possilbe shorts (i.e. solding two or more sensor pins on one soldering line). To make this step a little easier, a youtube link below may assist in understanding how to start soldering. Note, you should always wear your saefty glasses and have a standard first aid kit near by. To solder, I recommend a temperature no more than 750 degrees C. Please see link below for further help:

 [![YouTube Soldering for Beginners](https://img.youtube.com/vi/YOUTUBE_VIDEO_ID_HERE/0.jpg)](https://www.youtube.com/watch?v=oqV2xU1fee8)



