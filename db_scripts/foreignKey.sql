use mydb;
ALTER TABLE base_data ADD CONSTRAINT event_id_fk FOREIGN KEY (Cause_Code,Event_id) REFERENCES event_cause(Cause_Code,Event_id);
ALTER TABLE base_data ADD CONSTRAINT failure_class_fk FOREIGN KEY (Failure_Class) REFERENCES failure_class(Failure_Class);
