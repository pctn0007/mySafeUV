---
tagline: Website and GitHub Pages
description: Simple Website with GitHub Pages
layout: page
title: index schedule
---

Anthony Pacitto's Hardware Blog - mySafeUV (Descending order of logs)
---------------------------------------------------------------------

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

