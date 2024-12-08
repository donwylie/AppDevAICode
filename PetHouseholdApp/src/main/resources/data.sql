-- Insert data into household
INSERT INTO household (eircode) VALUES ('D02X123');
INSERT INTO household (eircode) VALUES ('D03Y456');

-- Insert data into pet
INSERT INTO pet (name, type, age, household_eircode) VALUES ('Buddy', 'Dog', 3, 'D02X123');
INSERT INTO pet (name, type, age, household_eircode) VALUES ('Max', 'Cat', 2, 'D03Y456');
INSERT INTO pet (name, type, age, household_eircode) VALUES ('Charlie', 'Bird', 1, 'D02X123');