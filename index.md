---
tagline: Website and GitHub Pages
description: Simple Website with GitHub Pages
layout: page
title: index schedule
---

Anthony Pacitto's Hardware Blog - mySafeUV (Descending order of logs)
---------------------------------------------------------------------
### Week 13 - November 27, 2018

Today, I prepared all information regarding mySafeUV hardware project in preperation for the final presentation due on December 4, 2018. As of now I am currently finishing up converting all UV intensity values to actual readable values with respect to UV index readings (i.e. Low, High, Extreme, etc.) which are then displayed as the sensors output throught the Pi's terminal console (see week 10 image for default UV intensity values that must be converted to a more meaningful output). In addition, I have started creating a Powerpoint presentation file that includes all required documents (per slide; 5 in total) as stated over the course website.

### Week 12 - November 20, 2018

This week I was able to complete the PCB enclosure for the mySafeUV and it was successfully sent off to the Prototype lab for printing. Unfortunetly, a majority of the enclosure file was produced off campus (i.e. with 1 lab period) and therefore, I am using my own judgement, as well as visual confirmation from other students in order to determine if dimension layout looked correct in order to minimize the risk for error and reducing the possiblity of having to re-print a second time. Unfortunatly, the future tasks of next semester is still pending since I am not sure if I will be returning as a student to Humber College. 


### Week 11 - November 13th, 2018

As explained in prior posts, due to illness I had switched the tasks from week 10 to 1 and vice-verca. In this week I submitted my PCB following its printing from the prototype lab.
However, in order to accomodate a more compact case, I have decided to mount the PCB onto the Raspberry Pi in a different direction (flipping the PCB 180 degrees). This allowed for the planned case dimensions to be reduced by ~1 inch in width when comapred to original planned dimensions. 

![mySafeUV PCB](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/20181120_124350_HDR.jpg)

### Week 10 - November 6th, 2018

Due to illness this past week, I was not able to attend the class in-person and therefore, was not able to retrieve my PCB via prototype lab. However, in order to make up for this, I have used additional time over the past week at home to create simple source code for the VEML6070 in order to detect sample UV index readings that can change when a tinted visor (i.e. sunglasses) are applied over the sensor. As a result, by doing this while I was away from Humber College, it allowed me to keep on track with respect to my Critical Path (only difference is the source code for the sensor started before PCB wwas obtained). Upon my return, I plan to pick-up my board and solder my sensor to it and continue finishing up the source code for UV detection. Below is an example of both a sample output and source code for the VEML6070 sensor UV intensity readings.

![mySafeUV output](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/mySafeUV_output.jpg)

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
### Week 9 - October 30th, 2018

The PCB diagram was created in Fritzing Beta. Copper wire labels, Via placement and wire organization was modified prior to being advised by the Instructor. The current budget still remains with a $40.32 "emergency fund" that will allow for any misc. parts (if needed). The image file below indicates the all final PCB components prior to cutting:

![PCB Diagram - Fritzing](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/mySafeUV_Breadboard_pcb.jpg)


### Week 8 - October 23th, 2018

To start, minor changes were made to the breadboard diagram using Fritzing Beta software. All wire colors were altered as well as a correction that required altering the connection between the SCL on the sensor with the correct pin on the Pi 3. In accordance to the original Gantt documentation, I am now on track with both the budget, parts aquirements and breadboard assembly (i.e. due for Oct 23, 2018). In addition, I was able to successfully connect my Pi 3 to the Lab PC in order to detect both addresses of 0x38 and 0x39 as stated in the sensor data specifications. Please refer to the image below:


![VEML6070 UV Index I2C Detection](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/VEML6070_I2C_Detect.jpg)

### Week 7 cont. - October 17th, 2018

Currently, the purchasing of all required hardware is slightyl under budget by $40.32. A standard breadboarding diagram was created using Fritzing software application. The diagram contains the basic connections between the Raspberry Pi 3 and the VEML6070 sensor, using the VIN (5V), SCL, GND and SDA pins. However, to form a ACK connection (outputs warnings of very High UV index readings) is still to be determined: Please refer to the Fritzing diagram file below:

![VEML6070 UV Index Breadboarding Prints](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/mySafeUV_Breadboard_bb.jpg)

### Week 6 - October 16th, 2018

Due to certain personal financial constraints, alterations were made to the parts orderlist (i.e. contacting vendors to reduce delivery times).
In addition, further discussions occured between myself and the supervising instructor in order to maintain a stable development process by meeting all critical path requirements and future milestone/module due dates (as displayed in the Gantt Chart).

### Week 5 - October 2nd, 2018

Alterations were made to the original Budget sheet (i.e. the source of puchases) in order to produce a lower total budget cost. Instead of using common USA based sources, additional Canadian based companies were found that helped reduce my overal shipping costs by $53.
Please note the invoices below are strictly based on mandatory items (eg. Raspberry Pi 3 and VEML6070 sensor purchases). Additional purchases may be made from local hardware/computer stores for cables if reuired. Please refer to the links below:

[Raspberry Pi 3 Invoice](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/raspberry_invoice.png)

[VEML6070 UV Index Sensor Invoice](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/sensor_invoice.png)

### Week 4 - September 25th, 2018

The Budget document was created in the form of a Microsoft Excel document. This excel sheet includes all cost details and description of any and all parts that are to be ordered by October 2nd, 2018. All subtotals, taxes, grand totals, shipping costs and currency exchange rates based on USD to CAD have been provide per item.

[mySafeUV Budget Sheet](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/Hardware_budget.xlsx)

### Week 3 - September 18th, 2018

The mySafeUV Project Schedule (i.e. Gantt Chart via Microsoft Project) was created and committed. This document will provide a detailed approach on a week-to-week critical path that establishes deadlines, tasks and timeframe of development. Please refer to the link below:

[mySafeUV Project Schedule](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/mySafeUVProject.mpp)

### Week 2 - September 11th, 2018

The mySafeUV GitHub public Repository was created for storing and modification of all hardware-based documentation.
The mySafeUV project proposal was submitted and comitted for review. Please refer to the specified link below:

[mySafeUV Hardware Proposol](https://github.com/pctn0007/mySafeUV/blob/master/Documentation/ProposalContentStudentNameRev02.xlsx)


### Week 1 - September 6th, 2018

The selection of a address 0x39, also known as the VEML6070 UV Index Sensor was selected via the specification list provided by our supervising instructor. An discussion board submission was logged to claim the address/sensor and the creation of mySafeUV project name was assigned. Please refer to the link below for Fall 2018 I2C slave device and list item 24. with the assigned name Anthony:

[mySafeUV Sensor Selection 0x39](https://six0four.github.io/ceng317/)
