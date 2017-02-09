LOAD DATA LOCAL infile 'C:/Users/C12508463/Dropbox/IdeaProjects/Ragnar/res/base_data/base_data_sahar_empty_null.csv'
INTO TABLE base_data 
fields terminated BY ','
lines terminated BY '\n'
IGNORE 1 LINES
(Date_Time,Event_id, Failure_Class, UE_Type, Market, Operator, Cell_id,
Duration,Course_Code,NE_Version,IMSI,HIER3_ID,HIER32_ID,HER321_ID);
