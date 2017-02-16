use mydb;

# Base Data

#LOAD DATA LOCAL infile 'C:/JavaWorkSpace/Ragnar/res/base_data/base_data_empty_null_field.csv'
#LOAD DATA LOCAL infile 'C:/Users/C12508463/Dropbox/IdeaProjects/Ragnar/res/base_data/base_data_empty_null_field.csv'
# Carls MBP
LOAD DATA LOCAL infile '/Volumes/Data/Users/carlmccann2/IdeaProjects/Ragnar/res/base_data.csv'
INTO TABLE Base_Data
fields terminated BY ','
lines terminated BY '\n'
IGNORE 1 LINES
(Date_Time,Event_id, Failure_Class, UE_Type, Market, Operator, Cell_id,
Duration,Cause_Code,NE_Version,IMSI,HIER3_ID,HIER32_ID,HER321_ID);


# Event Cause Data

#LOAD DATA LOCAL infile 'C:/JavaWorkSpace/Ragnar/res/event_cause_data.csv'
# Carls DIT pc
#LOAD DATA LOCAL infile 'C:/Users/C12508463/Dropbox/IdeaProjects/Ragnar/res/event_cause_data.csv'
# Carls MBP
LOAD DATA LOCAL infile '/Volumes/Data/Users/carlmccann2/IdeaProjects/Ragnar/res/event_cause_data.csv'

INTO TABLE Event_Cause 
fields terminated BY ','
lines terminated BY '\n'
IGNORE 1 LINES
(Cause_Code,Event_id, Description);

# Failure Class Data
#LOAD DATA LOCAL infile 'C:/JavaWorkSpace/Ragnar/res/failure_class_data.csv'
#LOAD DATA LOCAL infile 'C:/Users/C12508463/Dropbox/IdeaProjects/Ragnar/res/failure_class_data.csv'
# Carls MBP
LOAD DATA LOCAL infile '/Volumes/Data/Users/carlmccann2/IdeaProjects/Ragnar/res/failure_class_data.csv'

INTO TABLE Failure_Class
fields terminated BY ','
lines terminated BY '\n'
IGNORE 1 LINES
(Failure_Class, Description);

# MCC-MNC Data 
#LOAD DATA LOCAL infile 'C:/JavaWorkSpace/Ragnar/res/mcc_mnc_data.csv'
#LOAD DATA LOCAL infile 'C:/Users/C12508463/Dropbox/IdeaProjects/Ragnar/res/mcc_mnc_data.csv'
# Carls MBP
LOAD DATA LOCAL infile '/Volumes/Data/Users/carlmccann2/IdeaProjects/Ragnar/res/mcc_mnc_data.csv'

INTO TABLE MCC_MNC
fields terminated BY ','
lines terminated BY '\n'
IGNORE 1 LINES
(MCC,MNC, Country, Operator);

# UE Data
#LOAD DATA LOCAL infile 'C:/JavaWorkSpace/Ragnar/res/ue_data.csv'
#LOAD DATA LOCAL infile 'C:/Users/C12508463/Dropbox/IdeaProjects/Ragnar/res/ue_data.csv'
# Carls MBP
LOAD DATA LOCAL infile '/Volumes/Data/Users/carlmccann2/IdeaProjects/Ragnar/res/ue_data.csv'
INTO TABLE UE 
fields terminated BY ','
ENCLOSED BY '"'
lines terminated BY '\n'
IGNORE 1 LINES
(TAC,Marketing_Name, Manufacturer, Access_Capability, Model, Vendor_Name, UE_Type,
OS,Input_Mode);
