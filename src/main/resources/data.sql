INSERT INTO doctor (name, email, specialization, active, created_at, updated_at) VALUES
('Dr Mehta', 'mehta@test.com', 'CARDIOLOGIST', true, NOW(), NOW()),
('Dr Sharma', 'sharma@test.com', 'DERMATOLOGIST', true, NOW(), NOW()),
('Dr Singh', 'singh@test.com', 'NEUROLOGIST', true, NOW(), NOW()),
('Dr Verma', 'verma@test.com', 'GENERAL', true, NOW(), NOW()),
('Dr Reddy', 'reddy@test.com', 'CARDIOLOGIST', true, NOW(), NOW()),
('Dr Khan', 'khan@test.com', 'GENERAL', true, NOW(), NOW()),
('Dr Patel', 'patel@test.com', 'DERMATOLOGIST', true, NOW(), NOW()),
('Dr Das', 'das@test.com', 'NEUROLOGIST', true, NOW(), NOW()),
('Dr Roy', 'roy@test.com', 'GENERAL', true, NOW(), NOW()),
('Dr Iyer', 'iyer@test.com', 'CARDIOLOGIST', true, NOW(), NOW());


INSERT INTO patient (name, email, disease, blood_group, date_of_birth, active, created_at, updated_at) VALUES
('Amit Kumar', 'amit@test.com', 'Fever', 'O_POS', '1995-05-10', true, NOW(), NOW()),
('Ravi Singh', 'ravi@test.com', 'Diabetes', 'A_POS', '1990-02-15', true, NOW(), NOW()),
('Neha Sharma', 'neha@test.com', 'Skin Allergy', 'B_POS', '1998-07-20', true, NOW(), NOW()),
('Priya Verma', 'priya@test.com', 'Migraine', 'AB_POS', '1993-09-12', true, NOW(), NOW()),
('Rahul Yadav', 'rahul@test.com', 'Heart Pain', 'O_NEG', '1988-11-25', true, NOW(), NOW()),
('Sneha Gupta', 'sneha@test.com', 'Cold', 'A_NEG', '2000-01-05', true, NOW(), NOW()),
('Vikas Patel', 'vikas@test.com', 'Back Pain', 'B_NEG', '1985-06-18', true, NOW(), NOW()),
('Anjali Das', 'anjali@test.com', 'Asthma', 'AB_NEG', '1997-03-22', true, NOW(), NOW()),
('Karan Roy', 'karan@test.com', 'Flu', 'O_POS', '1992-12-30', true, NOW(), NOW()),
('Pooja Iyer', 'pooja@test.com', 'Headache', 'A_POS', '1999-08-14', true, NOW(), NOW());

INSERT INTO appointment (doctor_id, patient_id, date, time, status, active, created_at, updated_at) VALUES
(1, 1, '2026-03-22', '10:00:00', 'BOOKED', true, NOW(), NOW()),
(2, 2, '2026-03-22', '11:00:00', 'COMPLETED', true, NOW(), NOW()),
(3, 3, '2026-03-23', '12:00:00', 'BOOKED', true, NOW(), NOW()),
(4, 4, '2026-03-23', '09:30:00', 'CANCELLED', true, NOW(), NOW()),
(5, 5, '2026-03-24', '14:00:00', 'BOOKED', true, NOW(), NOW()),
(6, 6, '2026-03-24', '15:30:00', 'COMPLETED', true, NOW(), NOW()),
(7, 7, '2026-03-25', '16:00:00', 'BOOKED', true, NOW(), NOW()),
(8, 8, '2026-03-25', '17:00:00', 'BOOKED', true, NOW(), NOW()),
(9, 9, '2026-03-26', '10:30:00', 'COMPLETED', true, NOW(), NOW()),
(10, 10, '2026-03-26', '11:45:00', 'BOOKED', true, NOW(), NOW());

