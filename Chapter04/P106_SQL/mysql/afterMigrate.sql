/* START */

SET SESSION group_concat_max_len = 100000;

/* Data for the table `office` */

insert into `office`(`office_code`, `city`, `phone`, `address_line_first`, `address_line_second`, `state`, `country`, `postal_code`, `territory`, `internal_budget`) values 

('1', 'San Francisco', '+1 650 219 4782', '100 Market Street', 'Suite 300', 'CA', 'USA', 'AZ934VB', 'NA', 90000), 

('2', 'Boston', '+1 215 837 0825', '1550 Court Place', 'Suite 102', 'MA', 'USA', 'XX021SS', 'NA', 85000), 

('3', 'NYC', '+1 212 555 3000', '523 East 53rd Street', 'apt. 5A', 'NY', 'USA', 'AA100CV', 'NA', 100000), 

('4', 'Paris', '+33 14 723 4404', '43 Rue Jouffroy D''abbans', NULL, NULL, 'France', 'MN750CV', 'EMEA', 35000), 

('5', 'Tokyo', '+81 33 224 5000', '4-1 Kioicho', NULL, 'Chiyoda-Ku', 'Japan', 'RT102TT', 'Japan', 90000), 

('6', 'Sydney', '+61 2 9264 2451', '5-11 Wentworth Avenue', 'Floor --2', NULL, 'Australia', 'XC344VD', 'APAC', 45500), 

('7', 'London', '+44 20 7877 2041', '25 Old Broad Street', 'Level 7', 'N/A', 'UK', 'CV555RR', 'EMEA', 50000), 

('8', NULL, '+44 20 1827 21411', '25 Hum Street', 'Level 2', NULL, 'USA', 'CV556RR', 'EMEA', 95000), 

('9', 'Bucharest', '+44 20 1827 21411', '22 DN1', 'Level 12', NULL, '', 'CV557RR', 'NA', 120000), 

('10', NULL, '+44 20 1827 21411', '12 Home', 'Level 22', NULL, NULL, 'CV558RR', 'NA', 110000), 

('11', 'Paris', '+32 12 713 4304', '43 Rue 2', NULL, NULL, 'France', 'DT975HH', 'EMEA', 78000), 

('12', 'Tokyo', '+81 33 224 3444', '4-2 Kioicho', NULL, 'Koil-Ku', 'Japan', 'DD578YU', 'Japan', 55000), 

('13', 'Los Angeles', '+3 223 7995', '110 Only Street', 'Alio 0', 'CA', 'USA', 'AZ944VB', 'NA', 40000), 

('14', 'San Diego', '+1 222 4345 5553', '220 Ternary Street', 'Alio 73', 'CA', 'USA', 'AZ948VB', 'NA', 65000), 

('15', 'Springfield', '+1 0009 9000 777', '155 Market Place', 'Suite 107', 'MA', 'USA', 'XX521SS', 'NA', 55000) ON DUPLICATE KEY UPDATE `office_code`=`office_code`;

/* Data for the table `department` */

insert into `department`(`department_id`, `name`, `phone`, `code`, `office_code`, `topic`, `local_budget`, `profit`, `forecast_profit`, `cash`, `accounts_receivable`, `inventories`, `accounts_payable`, `st_borrowing`, `accrued_liabilities`) values 

('1', 'Advertising', '-int 4782', '1333', '1', 'publicity, promotion', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL), 

('2', 'Sales', '-int 41233', '1441', '1', 'commerce, trade, sellout, transaction', 650000, 900000, 800000, 20000, NULL, 10000, NULL, NULL, NULL), 

('3', 'Accounting', '-int 8233', '2311', '2', 'monetary, business', NULL, 450000, NULL, 25000, NULL, NULL, NULL, NULL, NULL), 

('4', 'Finance', '-int 4421', '3229', '3', 'commerce, fiscal, monetary, business', 120000, 90000, NULL, NULL, NULL, NULL, 40000, 10000, NULL), 

('5', 'Sales', '-int 34443', '6554', '2', 'commerce, sellout, transaction', 345000, 350000, 450000, 11000, 25000, 5000, 10000, 85000, 12000), 

('6', 'Sales', '-int 7664', '1234', '4', NULL, NULL, 100000, NULL, NULL, NULL, NULL, 50000, NULL, NULL), 

('7', 'Marketing', '-int 1266', '9090', '4', 'market, research, advertising', NULL, 500000, 250000, NULL, 11000, NULL, 5000, NULL, 1000), 

('8', 'Marketing', '-int 4543', '4544', '5', 'market, research, advertising', NULL, 430000, 900000, NULL, NULL, NULL, NULL, NULL, NULL), 

('9', 'Assembly', '-int 8777', '5455', '6', 'gathering, construction, joining', 500000, 500000, 450000, NULL, NULL, NULL, 7000, NULL, NULL), 

('10', 'Accounting', '-int 6765', '4555', '6', 'monetary, business', NULL, NULL, 100000, 10000, NULL, NULL, 4000, NULL, NULL), 

('11', 'Finance', '-int 1111', '7876', '7', 'commerce, fiscal, monetary, business', 450000, NULL, 450000, NULL, NULL, NULL, NULL, NULL, NULL), 

('12', 'Logistics', '-int 4421', '3222', '8', 'facilities, supplies', NULL, 120000, 300000, 10000, NULL, 11000, NULL, 16000, NULL), 

('13', 'Logistics', '-int 7453', '7884', '9', 'facilities, supplies', NULL, 80000, 100000, 9000, NULL, 6000, 2300, 4400, NULL), 

('14', 'Logistics', '-int 3433', '6777', '12', 'facilities, supplies', 235000, 233000, NULL, NULL, NULL, 1000, NULL, NULL, 9000), 

('15', 'HR', '-int 2323', '7888', '12', 'people, interview, hiring', NULL, 120000, 120000, NULL, 544, NULL, NULL, 2300, NULL) ON DUPLICATE KEY UPDATE `department_id`=`department_id`;

/* Data for the table `manager` */

insert into `manager` (`manager_id`, `manager_name`, `manager_evaluation`, `manager_detail`) values 

('1', 'Joana Nimar', '67, 34, 33, 66', '{"firstName":"Joana", "lastName":"Nimar", "gender":"Female", "dob":"1983-01-01", "email":"joananimar@gmail.com", "age":30, "address":{"streetAddress":"21 Fake Street", "city":"New York City", "state":"NY", "zipOrPostal":"10021"}, "phoneNumber":[{"type":"home", "number":["212 555-1234", "212 543-0933"]}, {"type":"mobile", "number":["646 555-4567", "644 153-3527", "626 231-6743"]}], "summary":"6 years of management experience", "computerSkills":[{"OS":["Linux"], "Office":["MS Word", "Excel"], "Management":["X10Mangement", "ManPlat1", "AllCeo"], "Tools":["GMail", "Meet"]}], "shareholder":"5%", "projects":[{"name":"SBS (aka. Shared Business Services)", "start":"2015-08-01", "end":"2019-11-21", "type":"development", "role":"Sr. Manager", "details":"Develop a powerful team in a short time"}, {"name":"RLCM (aka. Role Lifecycle Management)", "start":"2011-03-01", "end":"2015-07-01", "type":"development", "role":"Manager Leader", "details":"Increase income"}, {"name":"Member-Provider Portal Enhancement", "start":"2009-03-01", "end":"2011-03-01", "type":"enhancement", "role":"Technical Leader", "details":"Managing the enhancement and defects fixing team"}]}'), 

('2', 'Mark Janel', '99, 23, 11, 23', '{"firstName":"Mark", "lastName":"Janel", "gender":"Male", "dob":"1985-03-07", "email":"markjanel@yahoo.com", "age":37, "address":{"streetAddress":"24 Red Street", "city":"Banesti", "state":"Prahova", "zipOrPostal":"506734"}, "phoneNumber":[{"type":"home", "number":["0727 823 989", "0723 621 723", "0712 212 676"]}, {"type":"mobile", "number":["378 555 233", "678 154 227"]}], "summary":"4 years of management experience", "computerSkills":[{"OS":["Windows"], "Office":["Power Point", "Access", "FoxPro"], "Management":["AllCeo", "ManagementTools Suite"], "Tools":["Skype", "GMail", "Meet", "Google Calendar"]}], "projects":[{"name":"Business Retail", "start":"2012-02-05", "end":"2014-10-11", "type":"retail", "role":"General Manager", "details":"Expand retail business"}, {"name":"Selling Point", "start":"2011-01-01", "end":"2012-02-05", "type":"selling", "role":"Manager Leader", "details":"Manager of selling department"}]}'), 

('3', 'Olivia Goy', '99, 34, 11, 78', '{"firstName":"Olivia", "lastName":"Goy", "gender":"Female", "dob":"1978-08-04", "email":"oliviagoy@gmail.com", "age":42, "address":{"streetAddress":"118 National Street", "city":"Barcelona", "state":"Catalonia", "zipOrPostal":"660933"}, "phoneNumber":[{"type":"home", "number":["0999 3844 3333", "0223 1333 4455", "0265 7883 4422"]}, {"type":"mobile", "number":["980 992 122", "112 644 212", "322 323 642"]}], "summary":"10 years of management experience", "computerSkills":[{"OS":["Linux", "Windows"], "Office":["MS Word", "Power Point"], "Management":["ManPlat1", "AllCeo", "TeamManagement"], "Tools":["Slack"]}], "projects":[{"name":"Marketing Share", "start":"2016-08-02", "end":"2021-06-02", "type":"administrator", "role":"Principal Manager", "details":"Marketing share for small companies"}, {"name":"Draft Management", "start":"2014-06-06", "end":"2016-08-02", "type":"development", "role":"Manager Leader", "details":"First e-management platform"}, {"name":"Car Management", "start":"2005-03-21", "end":"2014-06-06", "type":"enhancement", "role":"Leader of retail", "details":"Enhancement of cars management"}]}') ON DUPLICATE KEY UPDATE `manager_id`=`manager_id`;

/* Data for the table `office_has_manager` */

insert into `office_has_manager` (`offices_office_code`, `managers_manager_id`) values 

('1', '1'), 

('2', '1'), 

('1', '3'), 

('3', '1'), 

('4', '2'), 

('5', '3'), 

('5', '2'), 

('6', '3'), 

('6', '2'), 

('6', '1'), 

('7', '2') ON DUPLICATE KEY UPDATE `offices_office_code`=`offices_office_code`;

/* Data for the table `employee` */

insert into `employee`(`employee_number`, `last_name`, `first_name`, `extension`, `email`, `office_code`, `salary`, `commission`, `reports_to`, `job_title`, `employee_of_year`, `monthly_bonus`) values 

(1002, 'Murphy', 'Diane', 'x5800', 'dmurphy@classicmodelcars.com', '1', 120000, 10000, NULL, 'President', NULL, '450, 210, 222, 123, 110, 0, 0, 0, 560, 440, 315, 125, 0, 900'), 

(1056, 'Patterson', 'Mary', 'x4611', 'mpatterso@classicmodelcars.com', '1', 100000, 5000, 1002, 'VP Sales', NULL, NULL), 

(1076, 'Firrelli', 'Jeff', 'x9273', 'jfirrelli@classicmodelcars.com', '1', 100000, 3500, 1002, 'VP Marketing', NULL, '0, 0, 0, 125, 125, 150, 232, 100, 0'), 

(1088, 'Patterson', 'William', 'x4871', 'wpatterson@classicmodelcars.com', '6', 80000, NULL, 1056, 'Sales Manager (APAC)', NULL, '560, 120, 440, 320, 315, 0, 0, 100, 125, 0, 900'), 

(1102, 'Bondur', 'Gerard', 'x5408', 'gbondur@classicmodelcars.com', '4', 80000, NULL, 1056, 'Sales Manager (EMEA)', NULL, NULL), 

(1143, 'Bow', 'Anthony', 'x5428', 'abow@classicmodelcars.com', '1', 75000, 5000, 1056, 'Sales Manager (NA)', NULL, NULL), 

(1165, 'Jennings', 'Leslie', 'x3291', 'ljennings@classicmodelcars.com', '1', 60000, NULL, 1143, 'Sales Rep', '2003, 2004', NULL), 

(1166, 'Thompson', 'Leslie', 'x4065', 'lthompson@classicmodelcars.com', '1', 60000, NULL, 1143, 'Sales Rep', '2003, 2005', NULL), 

(1188, 'Firrelli', 'Julie', 'x2173', 'jfirrelli@classicmodelcars.com', '2', 60000, NULL, 1143, 'Sales Rep', '2004, 2005', NULL), 

(1216, 'Patterson', 'Steve', 'x4334', 'spatterson@classicmodelcars.com', '2', 55000, 1000, 1143, 'Sales Rep', '2005, 2006', NULL), 

(1286, 'Tseng', 'Foon Yue', 'x2248', 'ftseng@classicmodelcars.com', '3', 55000, 2000, 1143, 'Sales Rep', '2002, 2003, 2004', NULL), 

(1323, 'Vanauf', 'George', 'x4102', 'gvanauf@classicmodelcars.com', '3', 55000, 1500, 1143, 'Sales Rep', '2000, 2001, 2005', NULL), 

(1337, 'Bondur', 'Loui', 'x6493', 'lbondur@classicmodelcars.com', '4', 60000, NULL, 1102, 'Sales Rep', '2004, 2007', NULL), 

(1370, 'Hernandez', 'Gerard', 'x2028', 'ghernande@classicmodelcars.com', '4', 65000, NULL, 1102, 'Sales Rep', '2000, 2001', NULL), 

(1401, 'Castillo', 'Pamela', 'x2759', 'pcastillo@classicmodelcars.com', '4', 55000, NULL, 1102, 'Sales Rep', '2000, 2001, 2003, 2005', NULL), 

(1501, 'Bott', 'Larry', 'x2311', 'lbott@classicmodelcars.com', '7', 50000, 1000, 1102, 'Sales Rep', '2004, 2008', NULL), 

(1504, 'Jones', 'Barry', 'x102', 'bjones@classicmodelcars.com', '7', 50000, 500, 1102, 'Sales Rep', '2002, 2003, 2005', NULL), 

(1611, 'Fixter', 'Andy', 'x101', 'afixter@classicmodelcars.com', '6', 50000, 1000, 1088, 'Sales Rep', '2002, 2005', NULL), 

(1612, 'Marsh', 'Peter', 'x102', 'pmarsh@classicmodelcars.com', '6', 55000, NULL, 1088, 'Sales Rep', '2003, 2005, 2006, 2007', NULL), 

(1619, 'King', 'Tom', 'x103', 'tking@classicmodelcars.com', '6', 60000, 1000, 1088, 'Sales Rep', '2002, 2004', NULL), 

(1621, 'Nishi', 'Mami', 'x101', 'mnishi@classicmodelcars.com', '5', 55000, 2000, 1056, 'Sales Rep', '2003, 2005', NULL), 

(1625, 'Kato', 'Yoshimi', 'x102', 'ykato@classicmodelcars.com', '5', 60000, 2500, 1621, 'Sales Rep', '2004, 2005, 2006', NULL), 

(1702, 'Gerard', 'Martin', 'x2312', 'mgerard@classicmodelcars.com', '4', 50000, 3400, 1102, 'Sales Rep', '2005, 2007', NULL) ON DUPLICATE KEY UPDATE `employee_number`=`employee_number`;

/* Data for the table `customer` */

insert into `customer`(`customer_number`, `customer_name`, `contact_last_name`, `contact_first_name`, `phone`, `sales_rep_employee_number`, `credit_limit`, `first_buy_date`) values 

(99, 'Australian Home', 'Paoule', 'Sart ', '40.11.2555', 1370, '21000.00', 20210), 

(100, 'Joliyon', 'Schmitt', 'Rue ', '10.22.2535', 1370, '21000.00', 20201), 

(101, 'Marquez Xioa', 'Calor', 'Sar ', '`11.12.2525', 1370, '21000.00', 21805), 

(102, 'Falafel 3', 'Hor', 'Carine ', '20.12.2525', 1370, '21000.00', 21805), 

(103, 'Atelier graphique', 'Schmitt', 'Carine ', '40.32.2555', 1370, '21000.00', 20186), 

(112, 'Signal Gift Stores', 'King', 'Jean', '7025551838', 1166, '71800.00', 21803), 

(114, 'Australian Collectors, Co.', 'Ferguson', 'Peter', '03 9520 4555', 1611, '117300.00', 20105), 

(119, 'La Rochelle Gifts', 'Labrune', 'Janine ', '40.67.8555', 1370, '118200.00', 20140), 

(121, 'Baane Mini Imports', 'Bergulfsen', 'Jonas ', '07-98 9555', 1504, '81700.00', 21403), 

(124, 'Mini Gifts Distributors Ltd.', 'Nelson', 'Susan', '4155551450', 1165, '210500.00', 20143), 

(125, 'Havel & Zbyszek Co', 'Piestrzeniewicz', 'Zbyszek ', '(26) 642-7555', NULL, '0.00', NULL), 

(128, 'Blauer See Auto, Co.', 'Keitel', 'Roland', '+49 69 66 90 2555', 1504, '59700.00', 20101), 

(129, 'Mini Wheels Co.', 'Murphy', 'Julie', '6505555787', 1165, '64600.00', 20190), 

(131, 'Land of Toys Inc.', 'Lee', 'Kwai', '2125557818', 1323, '114900.00', 20903), 

(141, 'Euro+ Shopping Channel', 'Freyre', 'Diego ', '(91) 555 94 44', 1370, '227600.00', 20191), 

(144, 'Volvo Model Replicas, Co', 'Berglund', 'Christina ', '0921-12 3555', 1504, '53100.00', 20192), 

(145, 'Danish Wholesale Imports', 'Petersen', 'Jytte ', '31 12 3555', 1401, '83400.00', 20405), 

(146, 'Saveley & Henriot, Co.', 'Saveley', 'Mary ', '78.32.5555', 1337, '123900.00', 20407), 

(148, 'Dragon Souveniers, Ltd.', 'Natividad', 'Eric', '+65 221 7555', 1621, '103800.00', 20505), 

(151, 'Muscle Machine Inc', 'Young', 'Jeff', '2125557413', 1286, '138500.00', 20409), 

(157, 'Diecast Classics Inc.', 'Leong', 'Kelvin', '2155551555', 1216, '100600.00', 20410), 

(161, 'Technics Stores Inc.', 'Hashimoto', 'Juri', '6505556809', 1165, '84600.00', 21407), 

(166, 'Handji Gifts& Co', 'Victorino', 'Wendy', '+65 224 1555', 1612, '97900.00', 20143), 

(167, 'Herkku Gifts', 'Oeztan', 'Veysel', '+47 2267 3215', 1504, '96800.00', 20147), 

(168, 'American Souvenirs Inc', 'Franco', 'Keith', '2035557845', 1286, '0.00', 20103), 

(169, 'Porto Imports Co.', 'de Castro', 'Isabel ', '(1) 356-5555', NULL, '0.00', NULL), 

(171, 'Daedalus Designs Imports', 'Rancé', 'Martine ', '20.16.1555', 1370, '82900.00', 20045), 

(172, 'La Corne D''abondance, Co.', 'Bertrand', 'Marie', '(1) 42.34.2555', 1337, '84300.00', 20405), 

(173, 'Cambridge Collectables Co.', 'Tseng', 'Jerry', '6175555555', 1188, '43400.00', 20110), 

(175, 'Gift Depot Inc.', 'King', 'Julie', '2035552570', 1323, '84300.00', 20011), 

(177, 'Osaka Souveniers Co.', 'Kentary', 'Mory', '+81 06 6342 5555', 1621, '81200.00', 20102), 

(181, 'Vitachrome Inc.', 'Frick', 'Michael', '2125551500', 1286, '76400.00', 20092), 

(186, 'Toys of Finland, Co.', 'Karttunen', 'Matti', '90-224 8555', 1501, '96500.00', 20002), 

(187, 'AV Stores, Co.', 'Ashworth', 'Rachel', '(171) 555-1555', 1501, '136800.00', 20002), 

(189, 'Clover Collections, Co.', 'Cassidy', 'Dean', '+353 1862 1555', 1504, '69400.00', 20903), 

(198, 'Auto-Moto Classics Inc.', 'Taylor', 'Leslie', '6175558428', 1216, '23000.00', 20094), 

(201, 'UK Collectables, Ltd.', 'Devon', 'Elizabeth', '(171) 555-2282', 1501, '92700.00', 20905), 

(202, 'Canadian Gift Exchange Network', 'Tamuri', 'Yoshi ', '(604) 555-3392', 1323, '90300.00', 20908), 

(204, 'Online Mini Collectables', 'Barajas', 'Miguel', '6175557555', 1188, '68700.00', 20503), 

(205, 'Toys4GrownUps.com', 'Young', 'Julie', '6265557265', 1166, '90700.00', 20504), 

(206, 'Asian Shopping Network, Co', 'Walker', 'Brydey', '+612 9411 1555', NULL, '0.00', NULL), 

(209, 'Mini Caravy', 'Citeaux', 'Frédérique ', '88.60.1555', 1370, '53800.00', 20506), 

(211, 'King Kong Collectables, Co.', 'Gao', 'Mike', '+852 2251 1555', 1621, '58600.00', 20143), 

(216, 'Enaco Distributors', 'Saavedra', 'Eduardo ', '(93) 203 4555', 1702, '60300.00', 20003), 

(219, 'Boards & Toys Co.', 'Young', 'Mary', '3105552373', 1166, '11000.00', 20003), 

(223, 'Natürlich Autos', 'Kloss', 'Horst ', '0372-555188', NULL, '0.00', NULL), 

(227, 'Heintze Collectables', 'Ibsen', 'Palle', '86 21 3555', 1401, '120800.00', 20103), 

(233, 'Québec Home Shopping Network', 'Fresnière', 'Jean ', '(514) 555-8054', 1286, '48700.00', 20012), 

(237, 'ANG Resellers', 'Camino', 'Alejandra ', '(91) 745 6555', NULL, '0.00', NULL), 

(239, 'Collectable Mini Designs Co.', 'Thompson', 'Valarie', '7605558146', 1166, '105000.00', 20111), 

(240, 'giftsbymail.co.uk', 'Bennett', 'Helen ', '(198) 555-8888''UK', 1501, '93900.00', 20103), 

(242, 'Alpha Cognac', 'Roulet', 'Annette ', '61.77.6555', 1370, '61100.00', 20121), 

(247, 'Messner Shopping Network', 'Messner', 'Renate ', '069-0555984', NULL, '0.00', NULL), 

(249, 'Amica Models & Co.', 'Accorti', 'Paolo ', '011-4988555', 1401, '113000.00', 20161), 

(250, 'Lyon Souveniers', 'Da Silva', 'Daniel', '+33 1 46 62 7555', 1337, '68100.00', 20102), 

(256, 'Auto Associés & Cie.', 'Tonini', 'Daniel ', '30.59.8555', 1370, '77900.00', 20163), 

(259, 'Toms Spezialitäten, Ltd', 'Pfalzheim', 'Henriette ', '0221-5554327', 1504, '120400.00', 20104), 

(260, 'Royal Canadian Collectables, Ltd.', 'Lincoln', 'Elizabeth ', '(604) 555-4555', 1323, '89600.00', 20165), 

(273, 'Franken Gifts, Co', 'Franken', 'Peter ', '089-0877555', NULL, '0.00', NULL), 

(276, 'Anna''s Decorations, Ltd', 'O''Hara', 'Anna', '02 9936 8555', 1611, '107800.00', 21604), 

(278, 'Rovelli Gifts', 'Rovelli', 'Giovanni ', '035-640555', 1401, '119600.00', 21611), 

(282, 'Souveniers And Things Co.', 'Huxley', 'Adrian', '+61 2 9495 8555', 1611, '93300.00', 20106), 

(286, 'Marta''s Replicas Co.', 'Hernandez', 'Marta', '6175558555', 1216, '123700.00', 20607), 

(293, 'BG&E Collectables', 'Harrison', 'Ed', '+41 26 425 50 01', NULL, '0.00', NULL), 

(298, 'Vida Sport, Ltd', 'Holz', 'Mihael', '0897-034555', 1702, '141300.00', 20161), 

(299, 'Norway Gifts By Mail, Co.', 'Klaeboe', 'Jan', '+47 2212 1555', 1504, '95100.00', 20161), 

(303, 'Schuyler Imports', 'Schuyler', 'Bradley', '+31 20 491 9555', NULL, '0.00', NULL), 

(307, 'Der Hund Imports', 'Andersen', 'Mel', '030-0074555', NULL, '0.00', NULL), 

(311, 'Oulu Toy Supplies, Inc.', 'Koskitalo', 'Pirkko', '981-443655', 1501, '90500.00', 20161), 

(314, 'Petit Auto', 'Dewey', 'Catherine ', '(02) 5554 67', 1401, '79900.00', 20160), 

(319, 'Mini Classics', 'Frick', 'Steve', '9145554562', 1323, '102700.00', 20001), 

(320, 'Mini Creations Ltd.', 'Huang', 'Wing', '5085559555', 1188, '94500.00', 20002), 

(321, 'Corporate Gift Ideas Co.', 'Brown', 'Julie', '6505551386', 1165, '105000.00', 20003), 

(323, 'Down Under Souveniers, Inc', 'Graham', 'Mike', '+64 9 312 5555', 1612, '88000.00', 20004), 

(324, 'Stylish Desk Decors, Co.', 'Brown', 'Ann ', '(171) 555-0297', 1501, '77000.00', 20005), 

(328, 'Tekni Collectables Inc.', 'Brown', 'William', '2015559350', 1323, '43000.00', 20006), 

(333, 'Australian Gift Network, Co', 'Calaghan', 'Ben', '61-7-3844-6555', 1611, '51600.00', 20101), 

(334, 'Suominen Souveniers', 'Suominen', 'Kalle', '+358 9 8045 555', 1501, '98800.00', 20103), 

(335, 'Cramer Spezialitäten, Ltd', 'Cramer', 'Philip ', '0555-09555', NULL, '0.00', NULL), 

(339, 'Classic Gift Ideas, Inc', 'Cervantes', 'Francisca', '2155554695', 1188, '81100.00', 20007), 

(344, 'CAF Imports', 'Fernandez', 'Jesus', '+34 913 728 555', 1702, '59600.00', 20001), 

(347, 'Men ''R'' US Retailers, Ltd.', 'Chandler', 'Brian', '2155554369', 1166, '57700.00', 20001), 

(348, 'Asian Treasures, Inc.', 'McKenna', 'Patricia ', '2967 555', NULL, '0.00', NULL), 

(350, 'Marseille Mini Autos', 'Lebihan', 'Laurence ', '91.24.4555', 1337, '65000.00', 20030), 

(353, 'Reims Collectables', 'Henriot', 'Paul ', '26.47.1555', 1337, '81100.00', 20030), 

(356, 'SAR Distributors, Co', 'Kuger', 'Armand', '+27 21 550 3555', NULL, '0.00', NULL), 

(357, 'GiftsForHim.com', 'MacKinlay', 'Wales', '64-9-3763555', 1612, '77700.00', 20038), 

(361, 'Kommission Auto', 'Josephs', 'Karin', '0251-555259', NULL, '0.00', NULL), 

(362, 'Gifts4AllAges.com', 'Yoshido', 'Juri', '6175559555', 1216, '41900.00', 20010), 

(363, 'Online Diecast Creations Co.', 'Young', 'Dorothy', '6035558647', 1216, '114200.00', 20310), 

(369, 'Lisboa Souveniers, Inc', 'Rodriguez', 'Lino ', '(1) 354-2555', NULL, '0.00', NULL), 

(376, 'Precious Collectables', 'Urs', 'Braun', '0452-076555', 1702, '0.00', 20310), 

(379, 'Collectables For Less Inc.', 'Nelson', 'Allen', '6175558555', 1188, '70700.00', 20310), 

(381, 'Royale Belge', 'Cartrain', 'Pascale ', '(071) 23 67 2555', 1401, '23500.00', 20310), 

(382, 'Salzburg Collectables', 'Pipps', 'Georg ', '6562-9555', 1401, '71700.00', 20030), 

(385, 'Cruz & Sons Co.', 'Cruz', 'Arnold', '+63 2 555 3587', 1621, '81500.00', 20310), 

(386, 'L''ordine Souveniers', 'Moroni', 'Maurizio ', '0522-556555', 1401, '121400.00', 20310), 

(398, 'Tokyo Collectables, Ltd', 'Shimamura', 'Akiko', '+81 3 3584 0555', 1621, '94400.00', 20311), 

(406, 'Auto Canal+ Petit', 'Perrier', 'Dominique', '(1) 47.55.6555', 1337, '95000.00', 23312), 

(409, 'Stuttgart Collectable Exchange', 'Müller', 'Rita ', '0711-555361', NULL, '0.00', NULL), 

(412, 'Extreme Desk Decorations, Ltd', 'McRoy', 'Sarah', '04 499 9555', 1612, '86800.00', 20311), 

(415, 'Bavarian Collectables Imports, Co.', 'Donnermeyer', 'Michael', ' +49 89 61 08 9555', 1504, '77000.00', 20012), 

(424, 'Classic Legends Inc.', 'Hernandez', 'Maria', '2125558493', 1286, '67500.00', 21010), 

(443, 'Feuer Online Stores, Inc', 'Feuer', 'Alexander ', '0342-555176', NULL, '0.00', NULL), 

(447, 'Gift Ideas Corp.', 'Lewis', 'Dan', '2035554407', 1323, '49700.00', 20111), 

(448, 'Scandinavian Gift Ideas', 'Larsson', 'Martha', '0695-34 6555', 1504, '116400.00', 20102), 

(450, 'The Sharp Gifts Warehouse', 'Frick', 'Sue', '4085553659', 1165, '77600.00', 20104), 

(452, 'Mini Auto Werke', 'Mendel', 'Roland ', '7675-3555', 1401, '45300.00', 20104), 

(455, 'Super Scale Inc.', 'Murphy', 'Leslie', '2035559545', 1286, '95400.00', 20125), 

(456, 'Microscale Inc.', 'Choi', 'Yu', '2125551957', 1286, '39800.00', 20120), 

(458, 'Corrida Auto Replicas, Ltd', 'Sommer', 'Martín ', '(91) 555 22 82', 1702, '104600.00', 20109), 

(459, 'Warburg Exchange', 'Ottlieb', 'Sven ', '0241-039123', NULL, '0.00', NULL), 

(462, 'FunGiftIdeas.com', 'Benitez', 'Violeta', '5085552555', 1216, '85800.00', 20112), 

(465, 'Anton Designs, Ltd.', 'Anton', 'Carmen', '+34 913 728555', NULL, '0.00', NULL), 

(471, 'Australian Collectables, Ltd', 'Clenahan', 'Sean', '61-9-3844-6555', 1611, '60300.00', 20107), 

(473, 'Frau da Collezione', 'Ricotti', 'Franco', '+39 022515555', 1401, '34800.00', 21502), 

(475, 'West Coast Collectables Co.', 'Thompson', 'Steve', '3105553722', 1166, '55400.00', 20104), 

(477, 'Mit Vergnügen & Co.', 'Moos', 'Hanna ', '0621-08555', NULL, '0.00', NULL), 

(480, 'Kremlin Collectables, Co.', 'Semenov', 'Alexander ', '+7 812 293 0521', NULL, '0.00', NULL), 

(481, 'Raanan Stores, Inc', 'Altagar, G M', 'Raanan', '+ 972 9 959 8555', NULL, '0.00', NULL), 

(484, 'Iberia Gift Imports, Corp.', 'Roel', 'José Pedro ', '(95) 555 82 82', 1702, '65700.00', 20154), 

(486, 'Motor Mint Distributors Inc.', 'Salazar', 'Rosa', '2155559857', 1323, '72600.00', 20154), 

(487, 'Signal Collectibles Ltd.', 'Taylor', 'Sue', '4155554312', 1165, '60300.00', 21504), 

(489, 'Double Decker Gift Stores, Ltd', 'Smith', 'Thomas ', '(171) 555-7555', 1501, '43300.00', 20103), 

(495, 'Diecast Collectables', 'Franco', 'Valarie', '6175552555', 1188, '85100.00', 20409), 

(496, 'Kelly''s Gift Shop', 'Snowden', 'Tony', '+64 9 5555500', 1612, '110000.00', 20142) ON DUPLICATE KEY UPDATE `customer_number`=`customer_number`;

/* Data for the table `customerdetail` */

insert into `customerdetail`(`customer_number`, `address_line_first`, `address_line_second`, `city`, `state`, `postal_code`, `country`) values 

(99, '43 Rue 2', NULL, 'Paris' , NULL, '25017', 'France'), 

(100, '51, Avenue 3', NULL, NULL , NULL, '43000', NULL), 

(101, '51, St 5', NULL, NULL , NULL, '44000', 'USA'), 

(102, '51, St AQ', NULL, 'Bucharest' , NULL, '12000', NULL), 

(103, '54, rue Royale', NULL, 'Nantes', NULL, '44000', 'France'), 

(112, '8489 Strong St.', NULL, 'Las Vegas', 'NV', '75017', 'USA'), 

(114, '636 St Kilda Road', 'Level 3', 'Melbourne', 'Victoria', '3004', 'Australia'), 

(119, '67, rue des Cinquante Otages', NULL, 'Nantes', NULL, '44000', 'France'), 

(121, 'Erling Skakkes gate 78', NULL, 'Stavern', NULL, '4110', 'Norway'), 

(124, '5677 Strong St.', NULL, 'San Rafael', 'CA', '97562', 'USA'), 

(125, 'ul. Filtrowa 68', NULL, 'Warszawa', NULL, '01-012', 'Poland'), 

(128, 'Lyonerstr. 34', NULL, 'Frankfurt', NULL, '60528', 'Germany'), 

(129, '5557 North Pendale Street', NULL, 'San Francisco', 'CA', 'AZ934VB', 'USA'), 

(131, '897 Long Airport Avenue', NULL, 'NYC', 'NY', 'AA100CV', 'USA'), 

(141, 'C/ Moralzarzal, 86', NULL, 'Madrid', NULL, '28034', 'Spain'), 

(144, 'Berguvsvägen 8', NULL, 'Luleå', NULL, 'S-958 22', 'Sweden'), 

(145, 'Vinbæltet 34', NULL, 'Kobenhavn', NULL, '1734', 'Denmark'), 

(146, '2, rue du Commerce', NULL, 'Lyon', NULL, '69004', 'France'), 

(148, 'Bronz Sok.', 'Bronz Apt. 3/6 Tesvikiye', 'Singapore', NULL, '079903', 'Singapore'), 

(151, '4092 Furth Circle', 'Suite 400', 'NYC', 'NY', 'AA100CV', 'USA'), 

(157, '7586 Pompton St.', NULL, 'Allentown', 'PA', '70267', 'USA'), 

(161, '9408 Furth Circle', NULL, 'Burlingame', 'CA', '94217', 'USA'), 

(166, '106 Linden Road Sandown', '2nd Floor', 'Singapore', NULL, '069045', 'Singapore'), 

(167, 'Brehmen St. 121', 'PR 334 Sentrum', 'Bergen', NULL, 'N 5804', 'Norway '), 

(168, '149 Spinnaker Dr.', 'Suite 101', 'New Haven', 'CT', '97823', 'USA'), 

(169, 'Estrada da saúde n. 58', NULL, 'Lisboa', NULL, '1756', 'Portugal'), 

(171, '184, chaussée de Tournai', NULL, 'Lille', NULL, '59000', 'France'), 

(172, '265, boulevard Charonne', NULL, 'Paris', NULL, '75012', 'France'), 

(173, '4658 Baden Av.', NULL, 'Cambridge', 'MA', '51247', 'USA'), 

(175, '25593 South Bay Ln.', NULL, 'Bridgewater', 'CT', '97562', 'USA'), 

(177, '1-6-20 Dojima', NULL, 'Kita-ku', 'Osaka', ' 530-0003', 'Japan'), 

(181, '2678 Kingston Rd.', 'Suite 101', 'NYC', 'NY', 'AA100CV', 'USA'), 

(186, 'Keskuskatu 45', NULL, 'Helsinki', NULL, '21240', 'Finland'), 

(187, 'Fauntleroy Circus', NULL, 'Manchester', NULL, 'EC2 5NT', 'UK'), 

(189, '25 Maiden Lane', 'Floor No. 4', 'Dublin', NULL, '2', 'Ireland'), 

(198, '16780 Pompton St.', NULL, 'Brickhaven', 'MA', '58339', 'USA'), 

(201, '12, Berkeley Gardens Blvd', NULL, 'Liverpool', NULL, 'WX1 6LT', 'UK'), 

(202, '1900 Oak St.', NULL, 'Vancouver', 'BC', 'V3F 2K1', 'Canada'), 

(204, '7635 Spinnaker Dr.', NULL, 'Brickhaven', 'MA', '58339', 'USA'), 

(205, '78934 Hillside Dr.', NULL, 'Pasadena', 'CA', '90003', 'USA'), 

(206, 'Suntec Tower Three', '8 Temasek', 'Singapore', NULL, '038988', 'Singapore'), 

(209, '24, place Kléber', NULL, 'Strasbourg', NULL, '67000', 'France'), 

(211, 'Bank of China Tower', '1 Garden Road', 'Central Hong Kong', NULL, NULL, 'Hong Kong'), 

(216, 'Rambla de Cataluña, 23', NULL, 'Barcelona', NULL, '08022', 'Spain'), 

(219, '4097 Douglas Av.', NULL, 'Glendale', 'CA', '92561', 'USA'), 

(223, 'Taucherstraße 10', NULL, 'Cunewalde', NULL, '01307', 'Germany'), 

(227, 'Smagsloget 45', NULL, 'Århus', NULL, '8200', 'Denmark'), 

(233, '43 rue St. Laurent', NULL, 'Montréal', 'Québec', 'H1J 1C3', 'Canada'), 

(237, 'Gran Vía, 1', NULL, 'Madrid', NULL, '28001', 'Spain'), 

(239, '361 Furth Circle', NULL, 'San Diego', 'CA', '91217', 'USA'), 

(240, 'Garden House', 'Crowther Way 23', 'Cowes', 'Isle of Wight', 'PO31 7PJ', 'UK'), 

(242, '1 rue Alsace-Lorraine', NULL, 'Toulouse', NULL, '31000', 'France'), 

(247, 'Magazinweg 7', NULL, 'Frankfurt', NULL, '60528', 'Germany'), 

(249, 'Via Monte Bianco 34', NULL, 'Torino', NULL, '10100', 'Italy'), 

(250, '27 rue du Colonel Pierre Avia', NULL, 'Paris', NULL, '75508', 'France'), 

(256, '67, avenue de l''Europe', NULL, 'Versailles', NULL, '78000', 'France'), 

(259, 'Mehrheimerstr. 369', NULL, 'Köln', NULL, '50739', 'Germany'), 

(260, '23 Tsawassen Blvd.', NULL, 'Tsawassen', 'BC', 'T2F 8M4', 'Canada'), 

(273, 'Berliner Platz 43', NULL, 'München', NULL, '80805', 'Germany'), 

(276, '201 Miller Street', 'Level 15', 'North Sydney', 'NSW', '2060', 'Australia'), 

(278, 'Via Ludovico il Moro 22', NULL, 'Bergamo', NULL, '24100', 'Italy'), 

(282, 'Monitor Money Building', '815 Pacific Hwy', 'Chatswood', 'NSW', '2067', 'Australia'), 

(286, '39323 Spinnaker Dr.', NULL, 'Cambridge', 'MA', '51247', 'USA'), 

(293, 'Rte des Arsenaux 41 ', NULL, 'Fribourg', NULL, '1700', 'Switzerland'), 

(298, 'Grenzacherweg 237', NULL, 'Genève', NULL, '1203', 'Switzerland'), 

(299, 'Drammensveien 126A', 'PB 211 Sentrum', 'Oslo', NULL, 'N 0106', 'Norway '), 

(303, 'Kingsfordweg 151', NULL, 'Amsterdam', NULL, '1043 GR', 'Netherlands'), 

(307, 'Obere Str. 57', NULL, 'Berlin', NULL, '12209', 'Germany'), 

(311, 'Torikatu 38', NULL, 'Oulu', NULL, '90110', 'Finland'), 

(314, 'Rue Joseph-Bens 532', NULL, 'Bruxelles', NULL, 'B-1180', 'Belgium'), 

(319, '3758 North Pendale Street', NULL, 'White Plains', 'NY', '24067', 'USA'), 

(320, '4575 Hillside Dr.', NULL, 'New Bedford', 'MA', '50553', 'USA'), 

(321, '7734 Strong St.', NULL, 'San Francisco', 'CA', 'AZ934VB', 'USA'), 

(323, '162-164 Grafton Road', 'Level 2', 'Auckland ', NULL, NULL, 'New Zealand'), 

(324, '25 Old Broad Street', 'Level 7', 'Bristol', 'N/A', 'CV555RR', 'UK'), 

(328, '7476 Moss Rd.', NULL, 'Newark', 'NJ', '94019', 'USA'), 

(333, '31 Duncan St. West End', NULL, 'South Brisbane', 'Queensland', '4101', 'Australia'), 

(334, 'Software Engineering Center', 'SEC Oy', 'Espoo', NULL, 'FIN-02271', 'Finland'), 

(335, 'Maubelstr. 90', NULL, 'Brandenburg', NULL, '14776', 'Germany'), 

(339, '782 First Street', NULL, 'Philadelphia', 'PA', '71270', 'USA'), 

(344, 'Merchants House', '27-30 Merchant''s Quay', 'Madrid', NULL, '28023', 'Spain'), 

(347, '6047 Douglas Av.', NULL, 'Los Angeles', 'CA', '91003', 'USA'), 

(348, '8 Johnstown Road', NULL, 'Cork', 'Co. Cork', NULL, 'Ireland'), 

(350, '12, rue des Bouchers', NULL, 'Marseille', NULL, '13008', 'France'), 

(353, '59 rue de l''Abbaye', NULL, 'Reims', NULL, '51100', 'France'), 

(356, '1250 Pretorius Street', NULL, 'Hatfield', 'Pretoria', '0028', 'South Africa'), 

(357, '199 Great North Road', NULL, 'Auckland', NULL, NULL, 'New Zealand'), 

(361, 'Luisenstr. 48', NULL, 'Münster', NULL, '44087', 'Germany'), 

(362, '8616 Spinnaker Dr.', NULL, 'Boston', 'MA', 'XX021SS', 'USA'), 

(363, '2304 Long Airport Avenue', NULL, 'Nashua', 'NH', '62005', 'USA'), 

(369, 'Jardim das rosas n. 32', NULL, 'Lisboa', NULL, '1675', 'Portugal'), 

(376, 'Hauptstr. 29', NULL, 'Bern', NULL, '3012', 'Switzerland'), 

(379, '7825 Douglas Av.', NULL, 'Brickhaven', 'MA', '58339', 'USA'), 

(381, 'Boulevard Tirou, 255', NULL, 'Charleroi', NULL, 'B-6000', 'Belgium'), 

(382, 'Geislweg 14', NULL, 'Salzburg', NULL, '5020', 'Austria'), 

(385, '15 McCallum Street', 'NatWest Center #13-03', 'Makati City', NULL, '1227 MM', 'Philippines'), 

(386, 'Strada Provinciale 124', NULL, 'Reggio Emilia', NULL, '42100', 'Italy'), 

(398, '2-2-8 Roppongi', NULL, 'Minato-ku', 'Tokyo', '106-0032', 'Japan'), 

(406, '25, rue Lauriston', NULL, 'Paris', NULL, '75016', 'France'), 

(409, 'Adenauerallee 900', NULL, 'Stuttgart', NULL, '70563', 'Germany'), 

(412, '101 Lambton Quay', 'Level 11', 'Wellington', NULL, NULL, 'New Zealand'), 

(415, 'Hansastr. 15', NULL, 'Munich', NULL, '80686', 'Germany'), 

(424, '5905 Pompton St.', 'Suite 750', 'NYC', 'NY', 'AA100CV', 'USA'), 

(443, 'Heerstr. 22', NULL, 'Leipzig', NULL, '04179', 'Germany'), 

(447, '2440 Pompton St.', NULL, 'Glendale', 'CT', '97561', 'USA'), 

(448, 'Åkergatan 24', NULL, 'Bräcke', NULL, 'S-844 67', 'Sweden'), 

(450, '3086 Ingle Ln.', NULL, 'San Jose', 'CA', '94217', 'USA'), 

(452, 'Kirchgasse 6', NULL, 'Graz', NULL, '8010', 'Austria'), 

(455, '567 North Pendale Street', NULL, 'New Haven', 'CT', '97823', 'USA'), 

(456, '5290 North Pendale Street', 'Suite 200', 'NYC', 'NY', 'AA100CV', 'USA'), 

(458, 'C/ Araquil, 67', NULL, 'Madrid', NULL, '28023', 'Spain'), 

(459, 'Walserweg 21', NULL, 'Aachen', NULL, '52066', 'Germany'), 

(462, '1785 First Street', NULL, 'New Bedford', 'MA', '50553', 'USA'), 

(465, 'c/ Gobelas, 19-1 Urb. La Florida', NULL, 'Madrid', NULL, '28023', 'Spain'), 

(471, '7 Allen Street', NULL, 'Glen Waverly', 'Victoria', '3150', 'Australia'), 

(473, '20093 Cologno Monzese', 'Alessandro Volta 16', 'Milan', NULL, NULL, 'Italy'), 

(475, '3675 Furth Circle', NULL, 'Burbank', 'CA', '94019', 'USA'), 

(477, 'Forsterstr. 57', NULL, 'Mannheim', NULL, '68306', 'Germany'), 

(480, '2 Pobedy Square', NULL, 'Saint Petersburg', NULL, '196143', 'Russia'), 

(481, '3 Hagalim Blv.', NULL, 'Herzlia', NULL, '47625', 'Israel'), 

(484, 'C/ Romero, 33', NULL, 'Sevilla', NULL, '41101', 'Spain'), 

(486, '11328 Douglas Av.', NULL, 'Philadelphia', 'PA', '71270', 'USA'), 

(487, '2793 Furth Circle', NULL, 'Brisbane', 'CA', '94217', 'USA'), 

(489, '120 Hanover Sq.', NULL, 'London', NULL, 'WA1 1DP', 'UK'), 

(495, '6251 Ingle Ln.', NULL, 'Boston', 'MA', 'XX021SS', 'USA'), 

(496, 'Arenales 1938 3''A''', NULL, 'Auckland ', NULL, NULL, 'New Zealand') ON DUPLICATE KEY UPDATE `customer_number`=`customer_number`;

/* Data for the table `productline` */

insert into `productline`(`product_line`, `code`, `text_description`, `html_description`, `image`) values 

('Classic Cars', 599302, 'Attention car enthusiasts: Make your wildest car ownership dreams come true. Whether you are looking for classic muscle cars, dream sports cars or movie-inspired miniatures, you will find great choices in this category. These replicas feature superb attention to detail and craftsmanship and offer features such as working steering system, opening forward compartment, opening rear trunk with removable spare wheel, 4-wheel independent spring suspension, and so on. The models range in size from 1:10 to 1:24 scale and include numerous limited edition and several out-of-production vehicles. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.', NULL, NULL), 

('Motorcycles', 599302, 'Our motorcycles are state of the art replicas of classic as well as contemporary motorcycle legends such as Harley Davidson, Ducati and Vespa. Models contain stunning details such as official logos, rotating wheels, working kickstand, front suspension, gear-shift lever, footbrake lever, and drive chain. Materials used include diecast and plastic. The models range in size from 1:10 to 1:50 scale and include numerous limited edition and several out-of-production vehicles. All models come fully assembled and ready for display in the home or office. Most include a certificate of authenticity.', NULL, NULL), 

('Planes', 433823, 'Unique, diecast airplane and helicopter replicas suitable for collections, as well as home, office or classroom decorations. Models contain stunning details such as official logos and insignias, rotating jet engines and propellers, retractable wheels, and so on. Most come fully assembled and with a certificate of authenticity from their manufacturers.', NULL, NULL), 

('Ships', 433823, 'The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value.', NULL, NULL), 

('Trains', 123333, 'Model trains are a rewarding hobby for enthusiasts of all ages. Whether you are looking for collectible wooden trains, electric streetcars or locomotives, you will find a number of great choices for any budget within this category. The interactive aspect of trains makes toy trains perfect for young children. The wooden train sets are ideal for children under the age of 5.', NULL, NULL), 

('Trucks and Buses', 569331, 'The Truck and Bus models are realistic replicas of buses and specialized trucks produced from the early 1920s to present. The models range in size from 1:12 to 1:50 scale and include numerous limited edition and several out-of-production vehicles. Materials used include tin, diecast and plastic. All models include a certificate of authenticity from their manufacturers and are a perfect ornament for the home and office.', NULL, NULL), 

('Vintage Cars', 223113, 'Our Vintage Car models realistically portray automobiles produced from the early 1900s through the 1940s. Materials used include Bakelite, diecast, plastic and wood. Most of the replicas are in the 1:18 and 1:24 scale sizes, which provide the optimum in detail and accuracy. Prices range from $30.00 up to $180.00 for some special limited edition replicas. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.', NULL, NULL) ON DUPLICATE KEY UPDATE `product_line`=`product_line`;

/* Data for the table `productlinedetail` */

insert into `productlinedetail`(`product_line`, `code`, `line_capacity`, `line_type`) values 

('Classic Cars', 599302, '200A', 1), 

('Motorcycles', 599302, '150B', 1), 

('Planes', 433823, '450C', 2), 

('Ships', 433823, '100A', 3), 

('Trains', 123333, '150A', 2), 

('Trucks and Buses', 569331, '566C', 2), 

('Vintage Cars', 223113, '1000A', 3) ON DUPLICATE KEY UPDATE `product_line`=`product_line`;

/* Data for the table `product` */

insert into `product`(`product_id`, `product_name`, `product_line`, `code`, `product_scale`, `product_vendor`, `product_description`, `quantity_in_stock`, `buy_price`, `msrp`) values 

(1, '1969 Harley Davidson Ultimate Chopper', 'Motorcycles', 599302, '1:10', 'Min Lin Diecast', 'PENDING', 7933, '48.81', '95.70'), 

(2, '1952 Alpine Renault 1300', 'Classic Cars', 599302, '1:10', 'Classic Metal Creations', 'PENDING', 7305, '98.58', '214.30'), 

(3, '1996 Moto Guzzi 1100i', 'Motorcycles', 599302, '1:10', 'Highway 66 Mini Classics', 'PENDING', 6625, '68.99', '118.94'), 

(4, '2003 Harley-Davidson Eagle Drag Bike', 'Motorcycles', 599302, '1:10', 'Red Start Diecast', 'PENDING', 5582, '91.02', '193.66'), 

(5, '1972 Alfa Romeo GTA', 'Classic Cars', 599302, '1:10', 'Motor City Art Classics', 'PENDING', 3252, '85.68', '136.00'), 

(6, '1962 LanciaA Delta 16V', 'Classic Cars', 599302, '1:10', 'Welly Diecast Productions', 'PENDING', 6791, '103.42', '147.74'), 

(7, '1968 Ford Mustang', 'Classic Cars', 599302, '1:12', 'Autoart Studio Design', 'Hood, doors and trunk all open to reveal highly detailed interior features. Steering wheel actually turns the front wheels. Color dark green.', 68, '95.34', '194.57'), 

(8, '2001 Ferrari Enzo', 'Classic Cars', 599302, '1:12', 'Second Gear Diecast', 'Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.', 3619, '95.59', '207.80'), 

(9, '1958 Setra Bus', 'Trucks and Buses', 569331, '1:12', 'Welly Diecast Productions', 'Model features 30 windows, skylights & glare resistant glass, working steering system, original logos', 1579, '77.90', '136.67'), 

(10, '2002 Suzuki XREO', 'Motorcycles', 599302, '1:12', 'Unimax Art Galleries', 'Official logos and insignias, saddle bags located on side of motorcycle, detailed engine, working steering, working suspension, two leather seats, luggage rack, dual exhaust pipes, small saddle bag located on handle bars, two-tone paint with chrome accents, superior die-cast detail , rotating wheels , working kick stand, diecast metal with plastic parts and baked enamel finish.', 9997, '66.27', '150.62'), 

(11, '1969 Corvair Monza', 'Classic Cars', 599302, '1:18', 'Welly Diecast Productions', '1:18 scale die-cast about 10" long doors open, hood opens, trunk opens and wheels roll', 6906, '89.14', '151.08'), 

(12, '1968 Dodge Charger', 'Classic Cars', 599302, '1:12', 'Welly Diecast Productions', '1:12 scale model of a 1968 Dodge Charger. Hood, doors and trunk all open to reveal highly detailed interior features. Steering wheel actually turns the front wheels. Color black', 9123, '75.16', '117.44'), 

(13, '1969 Ford Falcon', 'Classic Cars', 599302, '1:12', 'Second Gear Diecast', 'Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.', 1049, '83.05', '173.02'), 

(14, '1970 Plymouth Hemi Cuda', 'Classic Cars', 599302, '1:12', 'Studio M Art Models', 'Very detailed 1970 Plymouth Cuda model in 1:12 scale. The Cuda is generally accepted as one of the fastest original muscle cars from the 1970s. This model is a reproduction of one of the orginal 652 cars built in 1970. Red color.', 5663, '31.92', '79.80'), 

(15, '1957 Chevy Pickup', 'Trucks and Buses', 569331, '1:12', 'Exoto Designs', '1:12 scale die-cast about 20" long Hood opens, Rubber wheels', 6125, '55.70', '118.50'), 

(16, '1969 Dodge Charger', 'Classic Cars', 599302, '1:12', 'Welly Diecast Productions', 'Detailed model of the 1969 Dodge Charger. This model includes finely detailed interior and exterior features. Painted in red and white.', 7323, '58.73', '115.16'), 

(17, '1940 Ford Pickup Truck', 'Trucks and Buses', 569331, '1:18', 'Studio M Art Models', 'This model features soft rubber tires, working steering, rubber mud guards, authentic Ford logos, detailed undercarriage, opening doors and hood,  removable split rear gate, full size spare mounted in bed, detailed interior with opening glove box', 2613, '58.33', '116.67'), 

(18, '1993 Mazda RX-7', 'Classic Cars', 599302, '1:18', 'Highway 66 Mini Classics', 'This model features, opening hood, opening doors, detailed engine, rear spoiler, opening trunk, working steering, tinted windows, baked enamel finish. Color red.', 3975, '83.51', '141.54'), 

(19, '1937 Lincoln Berline', 'Vintage Cars', 223113, '1:18', 'Motor City Art Classics', 'Features opening engine cover, doors, trunk, and fuel filler cap. Color black', 8693, '60.62', '102.74'), 

(20, '1936 Mercedes-Benz 500K Special Roadster', 'Vintage Cars', 223113, '1:18', 'Studio M Art Models', 'This 1:18 scale replica is constructed of heavy die-cast metal and has all the features of the original: working doors and rumble seat, independent spring suspension, detailed interior, working steering system, and a bifold hood that reveals an engine so accurate that it even includes the wiring. All this is topped off with a baked enamel finish. Color white.', 8635, '24.26', '53.91'), 

(21, '1965 Aston Martin DB5', 'Classic Cars', 599302, '1:18', 'Classic Metal Creations', 'Die-cast model of the silver 1965 Aston Martin DB5 in silver. This model includes full wire wheels and doors that open with fully detailed passenger compartment. In 1:18 scale, this model measures approximately 10 inches/20 cm long.', 9042, '65.96', '124.44'), 

(22, '1980s Black Hawk Helicopter', 'Planes', 433823, '1:18', 'Red Start Diecast', '1:18 scale replica of actual Army''s UH-60L BLACK HAWK Helicopter. 100% hand-assembled. Features rotating rotor blades, propeller blades and rubber wheels.', 5330, '77.27', '157.69'), 

(23, '1917 Grand Touring Sedan', 'Vintage Cars', 223113, '1:18', 'Welly Diecast Productions', 'This 1:18 scale replica of the 1917 Grand Touring car has all the features you would expect from museum quality reproductions: all four doors and bi-fold hood opening, detailed engine and instrument panel, chrome-look trim, and tufted upholstery, all topped off with a factory baked-enamel finish.', 2724, '86.70', '170.00'), 

(24, '1948 Porsche 356-A Roadster', 'Classic Cars', 599302, '1:18', 'Gearbox Collectibles', 'This precision die-cast replica features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish.', 8826, '53.90', '77.00'), 

(25, '1995 Honda Civic', 'Classic Cars', 599302, '1:18', 'Min Lin Diecast', 'This model features, opening hood, opening doors, detailed engine, rear spoiler, opening trunk, working steering, tinted windows, baked enamel finish. Color yellow.', 9772, '93.89', '142.25'), 

(26, '1998 Chrysler Plymouth Prowler', 'Classic Cars', 599302, '1:18', 'Gearbox Collectibles', 'Turnable front wheels; steering create function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.', 4724, '101.51', '163.73'), 

(27, '1911 Ford Town Car', 'Vintage Cars', 223113, '1:18', 'Motor City Art Classics', 'Features opening hood, opening doors, opening trunk, wide white wall tires, front door arm rests, working steering system.', 540, '33.30', '60.54'), 

(28, '1964 Mercedes Tour Bus', 'Trucks and Buses', 569331, '1:18', 'Unimax Art Galleries', 'Exact replica. 100+ parts. working steering system, original logos', 8258, '74.86', '122.73'), 

(29, '1932 Model A Ford J-Coupe', 'Vintage Cars', 223113, '1:18', 'Autoart Studio Design', 'This model features grille-mounted chrome horn, lift-up louvered hood, fold-down rumble seat, working steering system, chrome-covered spare, opening doors, detailed and wired engine', 9354, '58.48', '127.13'), 

(30, '1926 Ford Fire Engine', 'Trucks and Buses', 569331, '1:18', 'Carousel DieCast Legends', 'Gleaming red handsome appearance. Everything is here the fire hoses, ladder, axes, bells, lanterns, ready to fight any inferno.', 2018, '24.92', '60.77'), 

(31, 'P-51-D Mustang', 'Planes', 433823, '1:72', 'Gearbox Collectibles', 'Has retractable wheels and comes with a stand', 992, '49.00', '84.48'), 

(32, '1936 Harley Davidson El Knucklehead', 'Motorcycles', 599302, '1:18', 'Welly Diecast Productions', 'Intricately detailed with chrome accents and trim, official die-struck logos and baked enamel finish.', 4357, '24.23', '60.57'), 

(33, '1928 Mercedes-Benz SSK', 'Vintage Cars', 223113, '1:18', 'Gearbox Collectibles', 'This 1:18 replica features grille-mounted chrome horn, lift-up louvered hood, fold-down rumble seat, working steering system, chrome-covered spare, opening doors, detailed and wired engine. Color black.', 548, '72.56', '168.75'), 

(34, '1999 Indy 500 Monte Carlo SS', 'Classic Cars', 599302, '1:18', 'Red Start Diecast', 'Features include opening and closing doors. Color: Red', 8164, '56.76', '132.00'), 

(35, '1913 Ford Model T Speedster', 'Vintage Cars', 223113, '1:18', 'Carousel DieCast Legends', 'This 250 part reproduction includes moving handbrakes, clutch, throttle and foot pedals, squeezable horn, detailed wired engine, removable water, gas, and oil cans, pivoting monocle windshield, all topped with a baked enamel red finish. Each replica comes with an Owners Title and Certificate of Authenticity. Color red.', 4189, '60.78', '101.31'), 

(36, '1934 Ford V8 Coupe', 'Vintage Cars', 223113, '1:18', 'Min Lin Diecast', 'Chrome Trim, Chrome Grille, Opening Hood, Opening Doors, Opening Trunk, Detailed Engine, Working Steering System', 5649, '34.35', '62.46'), 

(37, '1999 Yamaha Speed Boat', 'Ships', 433823, '1:18', 'Min Lin Diecast', 'Exact replica. Wood and Metal. Many extras including rigging, long boats, pilot house, anchors, etc. Comes with three masts, all square-rigged.', 4259, '51.61', '86.02'), 

(38, '18th Century Vintage Horse Carriage', 'Vintage Cars', 223113, '1:18', 'Red Start Diecast', 'Hand crafted diecast-like metal horse carriage is re-created in about 1:18 scale of antique horse carriage. This antique style metal Stagecoach is all hand-assembled with many different parts.rnrnThis collectible metal horse carriage is painted in classic Red, and features turning steering wheel and is entirely hand-finished.', 5992, '60.74', '104.72'), 

(39, '1903 Ford Model A', 'Vintage Cars', 223113, '1:18', 'Unimax Art Galleries', 'Features opening trunk,  working steering system', 3913, '68.30', '136.59'), 

(40, '1992 Ferrari 360 Spider red', 'Classic Cars', 599302, '1:18', 'Unimax Art Galleries', 'his replica features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish.', 8347, '77.90', '169.34'), 

(41, '1985 Toyota Supra', 'Classic Cars', 599302, '1:18', 'Highway 66 Mini Classics', 'This model features soft rubber tires, working steering, rubber mud guards, authentic Ford logos, detailed undercarriage, opening doors and hood, removable split rear gate, full size spare mounted in bed, detailed interior with opening glove box', 7733, '57.01', '107.57'), 

(42, 'Collectable Wooden Train', 'Trains', 123333, '1:18', 'Carousel DieCast Legends', 'Hand crafted wooden toy train set is in about 1:18 scale, 25 inches in total length including 2 additional carts, of actual vintage train. This antique style wooden toy train model set is all hand-assembled with 100% wood.', 6450, '67.56', '100.84'), 

(43, '1969 Dodge Super Bee', 'Classic Cars', 599302, '1:18', 'Min Lin Diecast', 'This replica features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish.', 1917, '49.05', '80.41'), 

(44, '1917 Maxwell Touring Car', 'Vintage Cars', 223113, '1:18', 'Exoto Designs', 'Features Gold Trim, Full Size Spare Tire, Chrome Trim, Chrome Grille, Opening Hood, Opening Doors, Opening Trunk, Detailed Engine, Working Steering System', 7913, '57.54', '99.21'), 

(45, '1976 Ford Gran Torino', 'Classic Cars', 599302, '1:18', 'Gearbox Collectibles', 'Highly detailed 1976 Ford Gran Torino "Starsky and Hutch" diecast model. Very well constructed and painted in red and white patterns.', 9127, '73.49', '146.99'), 

(46, '1948 Porsche Type 356 Roadster', 'Classic Cars', 599302, '1:18', 'Gearbox Collectibles', 'This model features working front and rear suspension on accurately replicated and actuating shock absorbers as well as opening engine cover, rear stabilizer flap,  and 4 opening doors.', 8990, '62.16', '141.28'), 

(47, '1957 Vespa GS150', 'Motorcycles', 599302, '1:18', 'Studio M Art Models', 'Features rotating wheels , working kick stand. Comes with stand.', 7689, '32.95', '62.17'), 

(48, '1941 Chevrolet Special Deluxe Cabriolet', 'Vintage Cars', 223113, '1:18', 'Exoto Designs', 'Features opening hood, opening doors, opening trunk, wide white wall tires, front door arm rests, working steering system, leather upholstery. Color black.', 2378, '64.58', '105.87'), 

(49, '1970 Triumph Spitfire', 'Classic Cars', 599302, '1:18', 'Min Lin Diecast', 'Features include opening and closing doors. Color: White.', 5545, '91.92', '143.62'), 

(50, '1932 Alfa Romeo 8C2300 Spider Sport', 'Vintage Cars', 223113, '1:18', 'Exoto Designs', 'This 1:18 scale precision die cast replica features the 6 front headlights of the original, plus a detailed version of the 142 horsepower straight 8 engine, dual spares and their famous comprehensive dashboard. Color black.', 6553, '43.26', '92.03'), 

(51, '1904 Buick Runabout', 'Vintage Cars', 223113, '1:18', 'Exoto Designs', 'Features opening trunk,  working steering system', 8290, '52.66', '87.77'), 

(52, '1940s Ford truck', 'Trucks and Buses', 569331, '1:18', 'Motor City Art Classics', 'This 1940s Ford Pick-Up truck is re-created in 1:18 scale of original 1940s Ford truck. This antique style metal 1940s Ford Flatbed truck is all hand-assembled. This collectible 1940''s Pick-Up truck is painted in classic dark green color, and features rotating wheels.', 3128, '84.76', '121.08'), 

(53, '1939 Cadillac Limousine', 'Vintage Cars', 223113, '1:18', 'Studio M Art Models', 'Features completely detailed interior including Velvet flocked drapes, deluxe wood grain floor, and a wood grain casket with seperate chrome handles', 6645, '23.14', '50.31'), 

(54, '1957 Corvette Convertible', 'Classic Cars', 599302, '1:18', 'Classic Metal Creations', '1957 die cast Corvette Convertible in Roman Red with white sides and whitewall tires. 1:18 scale quality die-cast with detailed engine and underbvody. Now you can own The Classic Corvette.', 1249, '69.93', '148.80'), 

(55, '1957 Ford Thunderbird', 'Classic Cars', 599302, '1:18', 'Studio M Art Models', 'This 1:18 scale precision die-cast replica, with its optional porthole hardtop and factory baked-enamel Thunderbird Bronze finish, is a 100% accurate rendition of this American classic.', 3209, '34.21', '71.27'), 

(56, '1970 Chevy Chevelle SS 454', 'Classic Cars', 599302, '1:24', 'Unimax Art Galleries', 'This model features rotating wheels, working streering system and opening doors. All parts are particularly delicate due to their precise scale and require special care and attention. It should not be picked up by the doors, roof, hood or trunk.', 1005, '49.24', '73.49'), 

(57, '1970 Dodge Coronet', 'Classic Cars', 599302, '1:24', 'Highway 66 Mini Classics', '1:24 scale die-cast about 18" long doors open, hood opens and rubber wheels', 4074, '32.37', '57.80'), 

(58, '1997 BMW R 1100 S', 'Motorcycles', 599302, '1:24', 'Autoart Studio Design', 'Detailed scale replica with working suspension and constructed from over 70 parts', 7003, '60.86', '112.70'), 

(59, '1966 Shelby Cobra 427 S/C', 'Classic Cars', 599302, '1:24', 'Carousel DieCast Legends', 'This diecast model of the 1966 Shelby Cobra 427 S/C includes many authentic details and operating parts. The 1:24 scale model of this iconic lighweight sports car from the 1960s comes in silver and it''s own display case.', 8197, '29.18', '50.31'), 

(60, '1928 British Royal Navy Airplane', 'Planes', 433823, '1:24', 'Classic Metal Creations', 'Official logos and insignias', 3627, '66.74', '109.42'), 

(61, '1939 Chevrolet Deluxe Coupe', 'Vintage Cars', 223113, '1:24', 'Motor City Art Classics', 'This 1:24 scale die-cast replica of the 1939 Chevrolet Deluxe Coupe has the same classy look as the original. Features opening trunk, hood and doors and a showroom quality baked enamel finish.', 7332, '22.57', '33.19'), 

(62, '1960 BSA Gold Star DBD34', 'Motorcycles', 599302, '1:24', 'Highway 66 Mini Classics', 'Detailed scale replica with working suspension and constructed from over 70 parts', 15, '37.32', '76.17'), 

(63, '18th century schooner', 'Ships', 433823, '1:24', 'Carousel DieCast Legends', 'All wood with canvas sails. Many extras including rigging, long boats, pilot house, anchors, etc. Comes with 4 masts, all square-rigged.', 1898, '82.34', '122.89'), 

(64, '1938 Cadillac V-16 Presidential Limousine', 'Vintage Cars', 223113, '1:24', 'Classic Metal Creations', 'This 1:24 scale precision die cast replica of the 1938 Cadillac V-16 Presidential Limousine has all the details of the original, from the flags on the front to an opening back seat compartment complete with telephone and rifle. Features factory baked-enamel black finish, hood goddess ornament, working jump seats.', 2847, '20.61', '44.80'), 

(65, '1962 Volkswagen Microbus', 'Trucks and Buses', 569331, '1:24', 'Autoart Studio Design', 'This 1:18 scale die cast replica of the 1962 Microbus is loaded with features: A working steering system, opening front doors and tailgate, and famous two-tone factory baked enamel finish, are all topped of by the sliding, real fabric, sunroof.', 2327, '61.34', '127.79'), 

(66, '1982 Ducati 900 Monster', 'Motorcycles', 599302, '1:24', 'Highway 66 Mini Classics', 'Features two-tone paint with chrome accents, superior die-cast detail , rotating wheels , working kick stand', 6840, '47.10', '69.26'), 

(67, '1949 Jaguar XK 120', 'Classic Cars', 599302, '1:24', 'Classic Metal Creations', 'Precision-engineered from original Jaguar specification in perfect scale ratio. Features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish.', 2350, '47.25', '90.87'), 

(68, '1958 Chevy Corvette Limited Edition', 'Classic Cars', 599302, '1:24', 'Carousel DieCast Legends', 'The operating parts of this 1958 Chevy Corvette Limited Edition are particularly delicate due to their precise scale and require special care and attention. Features rotating wheels, working streering, opening doors and trunk. Color dark green.', 2542, '15.91', '35.36'), 

(69, '1900s Vintage Bi-Plane', 'Planes', 433823, '1:24', 'Autoart Studio Design', 'Hand crafted diecast-like metal bi-plane is re-created in about 1:24 scale of antique pioneer airplane. All hand-assembled with many different parts. Hand-painted in classic yellow and features correct markings of original airplane.', 5942, '34.25', '68.51'), 

(70, '1952 Citroen-15CV', 'Classic Cars', 599302, '1:24', 'Exoto Designs', 'Precision crafted hand-assembled 1:18 scale reproduction of the 1952 15CV, with its independent spring suspension, working steering system, opening doors and hood, detailed engine and instrument panel, all topped of with a factory fresh baked enamel finish.', 1452, '72.82', '117.44'), 

(71, '1982 Lamborghini Diablo', 'Classic Cars', 599302, '1:24', 'Second Gear Diecast', 'This replica features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish.', 7723, '16.24', '37.76'), 

(72, '1912 Ford Model T Delivery Wagon', 'Vintage Cars', 223113, '1:24', 'Min Lin Diecast', 'This model features chrome trim and grille, opening hood, opening doors, opening trunk, detailed engine, working steering system. Color white.', 9173, '46.91', '88.51'), 

(73, '1969 Chevrolet Camaro Z28', 'Classic Cars', 599302, '1:24', 'Exoto Designs', '1969 Z/28 Chevy Camaro 1:24 scale replica. The operating parts of this limited edition 1:24 scale diecast model car 1969 Chevy Camaro Z28- hood, trunk, wheels, streering, suspension and doors- are particularly delicate due to their precise scale and require special care and attention.', 4695, '50.51', '85.61'), 

(74, '1971 Alpine Renault 1600s', 'Classic Cars', 599302, '1:24', 'Welly Diecast Productions', 'This 1971 Alpine Renault 1600s replica Features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish.', 7995, '38.58', '61.23'), 

(75, '1937 Horch 930V Limousine', 'Vintage Cars', 223113, '1:24', 'Autoart Studio Design', 'Features opening hood, opening doors, opening trunk, wide white wall tires, front door arm rests, working steering system', 2902, '26.30', '65.75'), 

(76, '2002 Chevy Corvette', 'Classic Cars', 599302, '1:24', 'Gearbox Collectibles', 'The operating parts of this limited edition Diecast 2002 Chevy Corvette 50th Anniversary Pace car Limited Edition are particularly delicate due to their precise scale and require special care and attention. Features rotating wheels, poseable streering, opening doors and trunk.', 9446, '62.11', '107.08'), 

(77, '1940 Ford Delivery Sedan', 'Vintage Cars', 223113, '1:24', 'Carousel DieCast Legends', 'Chrome Trim, Chrome Grille, Opening Hood, Opening Doors, Opening Trunk, Detailed Engine, Working Steering System. Color black.', 6621, '48.64', '83.86'), 

(78, '1956 Porsche 356A Coupe', 'Classic Cars', 599302, '1:18', 'Classic Metal Creations', 'Features include: Turnable front wheels; steering create function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.', 6600, '98.30', '140.43'), 

(79, 'Corsair F4U ( Bird Cage)', 'Planes', 433823, '1:24', 'Second Gear Diecast', 'Has retractable wheels and comes with a stand. Official logos and insignias.', 6812, '29.34', '68.24'), 

(80, '1936 Mercedes Benz 500k Roadster', 'Vintage Cars', 223113, '1:24', 'Red Start Diecast', 'This model features grille-mounted chrome horn, lift-up louvered hood, fold-down rumble seat, working steering system and rubber wheels. Color black.', 2081, '21.75', '41.03'), 

(81, '1992 Porsche Cayenne Turbo Silver', 'Classic Cars', 599302, '1:24', 'Exoto Designs', 'This replica features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish.', 6582, '69.78', '118.28'), 

(82, '1936 Chrysler Airflow', 'Vintage Cars', 223113, '1:24', 'Second Gear Diecast', 'Features opening trunk,  working steering system. Color dark green.', 4710, '57.46', '97.39'), 

(83, '1900s Vintage Tri-Plane', 'Planes', 433823, '1:24', 'Unimax Art Galleries', 'Hand crafted diecast-like metal Triplane is Re-created in about 1:24 scale of antique pioneer airplane. This antique style metal triplane is all hand-assembled with many different parts.', 2756, '36.23', '72.45'), 

(84, '1961 Chevrolet Impala', 'Classic Cars', 599302, '1:18', 'Classic Metal Creations', 'This 1:18 scale precision die-cast reproduction of the 1961 Chevrolet Impala has all the features-doors, hood and trunk that open; detailed 409 cubic-inch engine; chrome dashboard and stick shift, two-tone interior; working steering system; all topped of with a factory baked-enamel finish.', 7869, '32.33', '80.84'), 

(85, '1980’s GM Manhattan Express', 'Trucks and Buses', 569331, '1:32', 'Motor City Art Classics', 'This 1980’s era new look Manhattan express is still active, running from the Bronx to mid-town Manhattan. Has 35 opeining windows and working lights. Needs a battery.', 5099, '53.93', '96.31'), 

(86, '1997 BMW F650 ST', 'Motorcycles', 599302, '1:32', 'Exoto Designs', 'Features official die-struck logos and baked enamel finish. Comes with stand.', 178, '66.92', '99.89'), 

(87, '1982 Ducati 996 R', 'Motorcycles', 599302, '1:32', 'Gearbox Collectibles', 'Features rotating wheels , working kick stand. Comes with stand.', 9241, '24.14', '40.23'), 

(88, '1954 Greyhound Scenicruiser', 'Trucks and Buses', 569331, '1:32', 'Classic Metal Creations', 'Model features bi-level seating, 50 windows, skylights & glare resistant glass, working steering system, original logos', 2874, '25.98', '54.11'), 

(89, '1950''s Chicago Surface Lines Streetcar', 'Trains', 123333, '1:32', 'Gearbox Collectibles', 'This streetcar is a joy to see. It has 80 separate windows, electric wire guides, detailed interiors with seats, poles and drivers controls, rolling and turning wheel assemblies, plus authentic factory baked-enamel finishes (Green Hornet for Chicago and Cream and Crimson for Boston).', 8601, '26.72', '62.14'), 

(90, '1996 Peterbilt 379 Stake Bed with Outrigger', 'Trucks and Buses', 569331, '1:32', 'Red Start Diecast', 'This model features, opening doors, detailed engine, working steering, tinted windows, detailed interior, die-struck logos, removable stakes operating outriggers, detachable second trailer, functioning 360-degree self loader, precision molded resin trailer and trim, baked enamel finish on cab', 814, '33.61', '64.64'), 

(91, '1928 Ford Phaeton Deluxe', 'Vintage Cars', 223113, '1:32', 'Highway 66 Mini Classics', 'This model features grille-mounted chrome horn, lift-up louvered hood, fold-down rumble seat, working steering system', 136, '33.02', '68.79'), 

(92, '1974 Ducati 350 Mk3 Desmo', 'Motorcycles', 599302, '1:32', 'Second Gear Diecast', 'This model features two-tone paint with chrome accents, superior die-cast detail , rotating wheels , working kick stand', 3341, '56.13', '102.05'), 

(93, '1930 Buick Marquette Phaeton', 'Vintage Cars', 223113, '1:50', 'Studio M Art Models', 'Features opening trunk,  working steering system', 7062, '27.06', '43.64'), 

(94, 'Diamond T620 Semi-Skirted Tanker', 'Trucks and Buses', 569331, '1:50', 'Highway 66 Mini Classics', 'This limited edition model is licensed and perfectly scaled for Lionel Trains. The Diamond T620 has been produced in solid precision diecast and painted with a fire baked enamel finish. It comes with a removable tanker and is a perfect model to add authenticity to your static train or car layout or to just have on display.', 1016, '68.29', '115.75'), 

(95, '1962 City of Detroit Streetcar', 'Trains', 123333, '1:50', 'Classic Metal Creations', 'This streetcar is a joy to see. It has 99 separate windows, electric wire guides, detailed interiors with seats, poles and drivers controls, rolling and turning wheel assemblies, plus authentic factory baked-enamel finishes (Green Hornet for Chicago and Cream and Crimson for Boston).', 1645, '37.49', '58.58'), 

(96, '2002 Yamaha YZR M1', 'Motorcycles', 599302, '1:50', 'Autoart Studio Design', 'Features rotating wheels , working kick stand. Comes with stand.', 600, '34.17', '81.36'), 

(97, 'The Schooner Bluenose', 'Ships', 433823, '1:700', 'Autoart Studio Design', 'All wood with canvas sails. Measures 31 1/2 inches in Length, 22 inches High and 4 3/4 inches Wide. Many extras.rnThe schooner Bluenose was built in Nova Scotia in 1921 to fish the rough waters off the coast of Newfoundland. Because of the Bluenose racing prowess she became the pride of all Canadians. Still featured on stamps and the Canadian dime, the Bluenose was lost off Haiti in 1946.', 1897, '34.00', '66.67'), 

(98, 'American Airlines: B767-300', 'Planes', 433823, '1:700', 'Min Lin Diecast', 'Exact replia with official logos and insignias and retractable wheels', 5841, '51.15', '91.34'), 

(99, 'The Mayflower', 'Ships', 433823, '1:700', 'Studio M Art Models', 'Measures 31 1/2 inches Long x 25 1/2 inches High x 10 5/8 inches WidernAll wood with canvas sail. Extras include long boats, rigging, ladders, railing, anchors, side cannons, hand painted, etc.', 737, '43.30', '86.61'), 

(100, 'HMS Bounty', 'Ships', 433823, '1:700', 'Unimax Art Galleries', 'Measures 30 inches Long x 27 1/2 inches High x 4 3/4 inches Wide. rnMany extras including rigging, long boats, pilot house, anchors, etc. Comes with three masts, all square-rigged.', 3501, '39.83', '90.52'), 

(101, 'America West Airlines B757-200', 'Planes', 433823, '1:700', 'Motor City Art Classics', 'Official logos and insignias. Working steering system. Rotating jet engines', 9653, '68.80', '99.72'), 

(102, 'The USS Constitution Ship', 'Ships', 433823, '1:700', 'Red Start Diecast', 'All wood with canvas sails. Measures 31 1/2" Length x 22 3/8" High x 8 1/4" Width. Extras include 4 boats on deck, sea sprite on bow, anchors, copper railing, pilot houses, etc.', 7083, '33.97', '72.28'), 

(103, '1982 Camaro Z28', 'Classic Cars', 599302, '1:18', 'Carousel DieCast Legends', 'Features include opening and closing doors. Color: White. rnMeasures approximately 9 1/2" Long.', 6934, '46.53', '101.15'), 

(104, 'ATA: B757-300', 'Planes', 433823, '1:700', 'Highway 66 Mini Classics', 'Exact replia with official logos and insignias and retractable wheels', 7106, '59.33', '118.65'), 

(105, 'F/A 18 Hornet 1/72', 'Planes', 433823, '1:72', 'Motor City Art Classics', '10" Wingspan with retractable landing gears.Comes with pilot', 551, '54.40', '80.00'), 

(106, 'The Titanic', 'Ships', 433823, '1:700', 'Carousel DieCast Legends', 'Completed model measures 19 1/2 inches long, 9 inches high, 3inches wide and is in barn red/black. All wood and metal.', 1956, '51.09', '100.17'), 

(107, 'The Queen Mary', 'Ships', 433823, '1:700', 'Welly Diecast Productions', 'Exact replica. Wood and Metal. Many extras including rigging, long boats, pilot house, anchors, etc. Comes with three masts, all square-rigged.', 5088, '53.63', '99.31'), 

(108, 'American Airlines: MD-11S', 'Planes', 433823, '1:700', 'Second Gear Diecast', 'Polished finish. Exact replia with official logos and insignias and retractable wheels', 8820, '36.27', '74.03'), 

(109, 'Boeing X-32A JSF', 'Planes', 433823, '1:72', 'Motor City Art Classics', '10" Wingspan with retractable landing gears.Comes with pilot', 4857, '32.77', '49.66'), 

(110, 'Pont Yacht', 'Ships', 433823, '1:72', 'Unimax Art Galleries', 'Measures 38 inches Long x 33 3/4 inches High. Includes a stand.rnMany extras including rigging, long boats, pilot house, anchors, etc. Comes with 2 masts, all square-rigged', 414, '33.30', '54.60') ON DUPLICATE KEY UPDATE `product_id`=`product_id`;

/* Data for the table `order` */

insert into `order`(`order_id`, `order_date`, `required_date`, `shipped_date`, `status`, `comments`, `customer_number`, `amount`) values 

(10100, '2003-01-06', '2003-01-13', '2003-01-10', 'Shipped', NULL, 363, 301.84), 

(10101, '2003-01-09', '2003-01-18', '2003-01-11', 'Shipped', 'Check on availability.', 128, 352), 

(10102, '2003-01-10', '2003-01-18', '2003-01-14', 'Shipped', NULL, 181, 138.68), 

(10103, '2003-01-29', '2003-02-07', '2003-02-02', 'Shipped', NULL, 121, 1520.37), 

(10104, '2003-01-31', '2003-02-09', '2003-02-01', 'Shipped', NULL, 141, 1198.58), 

(10105, '2003-02-11', '2003-02-21', '2003-02-12', 'Shipped', NULL, 145, 1479.71), 

(10106, '2003-02-17', '2003-02-24', '2003-02-21', 'Shipped', NULL, 278, 1427.28), 

(10107, '2003-02-24', '2003-03-03', '2003-02-26', 'Shipped', 'Difficult to negotiate with customer. We need more marketing materials', 131, 793.21), 

(10108, '2003-03-03', '2003-03-12', '2003-03-08', 'Shipped', NULL, 385, 1267.48), 

(10109, '2003-03-10', '2003-03-19', '2003-03-11', 'Shipped', 'Customer requested that FedEx Ground is used for this shipping', 486, 700.89), 

(10110, '2003-03-18', '2003-03-24', '2003-03-20', 'Shipped', NULL, 187, 1338.47), 

(10111, '2003-03-25', '2003-03-31', '2003-03-30', 'Shipped', NULL, 129, 460.16), 

(10112, '2003-03-24', '2003-04-03', '2003-03-29', 'Shipped', 'Customer requested that ad materials (such as posters, pamphlets) be included in the shippment', 144, 282.26), 

(10113, '2003-03-26', '2003-04-02', '2003-03-27', 'Shipped', NULL, 124, 325.23), 

(10114, '2003-04-01', '2003-04-07', '2003-04-02', 'Shipped', NULL, 172, 909.72), 

(10115, '2003-04-04', '2003-04-12', '2003-04-07', 'Shipped', NULL, 424, 515.99), 

(10116, '2003-04-11', '2003-04-19', '2003-04-13', 'Shipped', NULL, 381, 60.28), 

(10117, '2003-04-16', '2003-04-24', '2003-04-17', 'Shipped', NULL, 148, 1307.47), 

(10118, '2003-04-21', '2003-04-29', '2003-04-26', 'Shipped', 'Customer has worked with some of our vendors in the past and is aware of their MSRP', 216, 86.15), 

(10119, '2003-04-28', '2003-05-05', '2003-05-02', 'Shipped', NULL, 382, 1007.21), 

(10120, '2003-04-29', '2003-05-08', '2003-05-01', 'Shipped', NULL, 114, 1322.67), 

(10121, '2003-05-07', '2003-05-13', '2003-05-13', 'Shipped', NULL, 353, 439.17), 

(10122, '2003-05-08', '2003-05-16', '2003-05-13', 'Shipped', NULL, 350, 1598.27), 

(10123, '2003-05-20', '2003-05-29', '2003-05-22', 'Shipped', NULL, 103, 396.08), 

(10124, '2003-05-21', '2003-05-29', '2003-05-25', 'Shipped', 'Customer very concerned about the exact color of the models. There is high risk that he may dispute the order because there is a slight color mismatch', 112, 976.44), 

(10125, '2003-05-21', '2003-05-27', '2003-05-24', 'Shipped', NULL, 114, 227.76), 

(10126, '2003-05-28', '2003-06-07', '2003-06-02', 'Shipped', NULL, 458, 1623.71), 

(10127, '2003-06-03', '2003-06-09', '2003-06-06', 'Shipped', 'Customer requested special shippment. The instructions were passed along to the warehouse', 151, 1601.39), 

(10128, '2003-06-06', '2003-06-12', '2003-06-11', 'Shipped', NULL, 141, 350.86), 

(10129, '2003-06-12', '2003-06-18', '2003-06-14', 'Shipped', NULL, 324, 754.23), 

(10130, '2003-06-16', '2003-06-24', '2003-06-21', 'Shipped', NULL, 198, 168.34), 

(10131, '2003-06-16', '2003-06-25', '2003-06-21', 'Shipped', NULL, 447, 577.67), 

(10132, '2003-06-25', '2003-07-01', '2003-06-28', 'Shipped', NULL, 323, 80.00), 

(10133, '2003-06-27', '2003-07-04', '2003-07-03', 'Shipped', NULL, 141, 628.49), 

(10134, '2003-07-01', '2003-07-10', '2003-07-05', 'Shipped', NULL, 250, 747.93), 

(10135, '2003-07-02', '2003-07-12', '2003-07-03', 'Shipped', NULL, 124, 1494.89), 

(10136, '2003-07-04', '2003-07-14', '2003-07-06', 'Shipped', 'Customer is interested in buying more Ferrari models', 242, 407.73), 

(10137, '2003-07-10', '2003-07-20', '2003-07-14', 'Shipped', NULL, 353, 385.54), 

(10138, '2003-07-07', '2003-07-16', '2003-07-13', 'Shipped', NULL, 496, 970.09), 

(10139, '2003-07-16', '2003-07-23', '2003-07-21', 'Shipped', NULL, 282, 714.16), 

(10140, '2003-07-24', '2003-08-02', '2003-07-30', 'Shipped', NULL, 161, 992.83), 

(10141, '2003-08-01', '2003-08-09', '2003-08-04', 'Shipped', NULL, 334, 857.52), 

(10142, '2003-08-08', '2003-08-16', '2003-08-13', 'Shipped', NULL, 124, 1570.77), 

(10143, '2003-08-10', '2003-08-18', '2003-08-12', 'Shipped', 'Can we deliver the new Ford Mustang models by end-of-quarter?', 320, 1227.49), 

(10144, '2003-08-13', '2003-08-21', '2003-08-14', 'Shipped', NULL, 381, 56.41), 

(10145, '2003-08-25', '2003-09-02', '2003-08-31', 'Shipped', NULL, 205, 1412.17), 

(10146, '2003-09-03', '2003-09-13', '2003-09-06', 'Shipped', NULL, 447, 191.24), 

(10147, '2003-09-05', '2003-09-12', '2003-09-09', 'Shipped', NULL, 379, 997.5), 

(10148, '2003-09-11', '2003-09-21', '2003-09-15', 'Shipped', 'They want to reevaluate their terms agreement with Finance.', 276, 1374.9), 

(10149, '2003-09-12', '2003-09-18', '2003-09-17', 'Shipped', NULL, 487, 925.52), 

(10150, '2003-09-19', '2003-09-27', '2003-09-21', 'Shipped', 'They want to reevaluate their terms agreement with Finance.', 148, 1096.9), 

(10151, '2003-09-21', '2003-09-30', '2003-09-24', 'Shipped', NULL, 311, 976.09), 

(10152, '2003-09-25', '2003-10-03', '2003-10-01', 'Shipped', NULL, 333, 336.44), 

(10153, '2003-09-28', '2003-10-05', '2003-10-03', 'Shipped', NULL, 141, 304.98), 

(10154, '2003-10-02', '2003-10-12', '2003-10-08', 'Shipped', NULL, 219, 134.5), 

(10155, '2003-10-06', '2003-10-13', '2003-10-07', 'Shipped', NULL, 186, 1084.82), 

(10156, '2003-10-08', '2003-10-17', '2003-10-11', 'Shipped', NULL, 141, 121.28), 

(10157, '2003-10-09', '2003-10-15', '2003-10-14', 'Shipped', NULL, 473, 475.12), 

(10158, '2003-10-10', '2003-10-18', '2003-10-15', 'Shipped', NULL, 121, 67.79), 

(10159, '2003-10-10', '2003-10-19', '2003-10-16', 'Shipped', NULL, 321, 1687.12), 

(10160, '2003-10-11', '2003-10-17', '2003-10-17', 'Shipped', NULL, 347, 562.16), 

(10161, '2003-10-17', '2003-10-25', '2003-10-20', 'Shipped', NULL, 227, 1068.37), 

(10162, '2003-10-18', '2003-10-26', '2003-10-19', 'Shipped', NULL, 321, 782.94), 

(10163, '2003-10-20', '2003-10-27', '2003-10-24', 'Shipped', NULL, 424, 651.79), 

(10164, '2003-10-21', '2003-10-30', '2003-10-23', 'Resolved', 'This order was disputed, but resolved on 11/1/2003; Customer does not like the colors and precision of the models.', 452, 758.85), 

(10165, '2003-10-22', '2003-10-31', '2003-12-26', 'Shipped', 'This order was on hold because customers credit limit had been exceeded. Order will ship when payment is received', 148, 1674.66), 

(10166, '2003-10-21', '2003-10-30', '2003-10-27', 'Shipped', NULL, 462, 361.88), 

(10167, '2003-10-23', '2003-10-30', NULL, 'Cancelled', 'Customer called to cancel. The warehouse was notified in time and the order did not ship. They have a new VP of Sales and are shifting their sales model. Our VP of Sales should contact them.', 448, 1271.62), 

(10168, '2003-10-28', '2003-11-03', '2003-11-01', 'Shipped', NULL, 161, 1472.5), 

(10169, '2003-11-04', '2003-11-14', '2003-11-09', 'Shipped', NULL, 276, 1130.7), 

(10170, '2003-11-04', '2003-11-12', '2003-11-07', 'Shipped', NULL, 452, 410.22), 

(10171, '2003-11-05', '2003-11-13', '2003-11-07', 'Shipped', NULL, 233, 463.18), 

(10172, '2003-11-05', '2003-11-14', '2003-11-11', 'Shipped', NULL, 175, 716.82), 

(10173, '2003-11-05', '2003-11-15', '2003-11-09', 'Shipped', 'Cautious optimism. We have happy customers here, if we can keep them well stocked. I need all the information I can get on the planned shippments of Porches', 278, 1310.96), 

(10174, '2003-11-06', '2003-11-15', '2003-11-10', 'Shipped', NULL, 333, 530.11), 

(10175, '2003-11-06', '2003-11-14', '2003-11-09', 'Shipped', NULL, 324, 1074.91), 

(10176, '2003-11-06', '2003-11-15', '2003-11-12', 'Shipped', NULL, 386, 1133.56), 

(10177, '2003-11-07', '2003-11-17', '2003-11-12', 'Shipped', NULL, 344, 878.84), 

(10178, '2003-11-08', '2003-11-16', '2003-11-10', 'Shipped', 'Custom shipping instructions sent to warehouse', 242, 989.95), 

(10179, '2003-11-11', '2003-11-17', '2003-11-13', 'Cancelled', 'Customer cancelled due to urgent budgeting issues. Must be cautious when dealing with them in the future. Since order shipped already we must discuss who would cover the shipping charges.', 496, 702.84), 

(10180, '2003-11-11', '2003-11-19', '2003-11-14', 'Shipped', NULL, 171, 1226.65), 

(10181, '2003-11-12', '2003-11-19', '2003-11-15', 'Shipped', NULL, 167, 1760.39), 

(10182, '2003-11-12', '2003-11-21', '2003-11-18', 'Shipped', NULL, 124, 1360.43), 

(10183, '2003-11-13', '2003-11-22', '2003-11-15', 'Shipped', 'We need to keep in close contact with their Marketing VP. He is the decision maker for all their purchases.', 339, 1143.9), 

(10184, '2003-11-14', '2003-11-22', '2003-11-20', 'Shipped', NULL, 484, 1205.41), 

(10185, '2003-11-14', '2003-11-21', '2003-11-20', 'Shipped', NULL, 320, 1605.19), 

(10186, '2003-11-14', '2003-11-20', '2003-11-18', 'Shipped', 'They want to reevaluate their terms agreement with the VP of Sales', 489, 729.73), 

(10187, '2003-11-15', '2003-11-24', '2003-11-16', 'Shipped', NULL, 211, 1440.52), 

(10188, '2003-11-18', '2003-11-26', '2003-11-24', 'Shipped', NULL, 167, 777.15), 

(10189, '2003-11-18', '2003-11-25', '2003-11-24', 'Shipped', 'They want to reevaluate their terms agreement with Finance.', 205, 138.57), 

(10190, '2003-11-19', '2003-11-29', '2003-11-20', 'Shipped', NULL, 141, 254.82), 

(10191, '2003-11-20', '2003-11-30', '2003-11-24', 'Shipped', 'We must be cautions with this customer. Their VP of Sales resigned. Company may be heading down.', 259, 853.76), 

(10192, '2003-11-20', '2003-11-29', '2003-11-25', 'Shipped', NULL, 363, 1541.08), 

(10193, '2003-11-21', '2003-11-28', '2003-11-27', 'Shipped', NULL, 471, 1294.46), 

(10194, '2003-11-25', '2003-12-02', '2003-11-26', 'Shipped', NULL, 146, 1110.74), 

(10195, '2003-11-25', '2003-12-01', '2003-11-28', 'Shipped', NULL, 319, 911.46), 

(10196, '2003-11-26', '2003-12-03', '2003-12-01', 'Shipped', NULL, 455, 978.59), 

(10197, '2003-11-26', '2003-12-02', '2003-12-01', 'Shipped', 'Customer inquired about remote controlled models and gold models.', 216, 1109.13), 

(10198, '2003-11-27', '2003-12-06', '2003-12-03', 'Shipped', NULL, 385, 506.86), 

(10199, '2003-12-01', '2003-12-10', '2003-12-06', 'Shipped', NULL, 475, 189.66), 

(10200, '2003-12-01', '2003-12-09', '2003-12-06', 'Shipped', NULL, 211, 505.54), 

(10201, '2003-12-01', '2003-12-11', '2003-12-02', 'Shipped', NULL, 129, 725.37), 

(10202, '2003-12-02', '2003-12-09', '2003-12-06', 'Shipped', NULL, 357, 506.36), 

(10203, '2003-12-02', '2003-12-11', '2003-12-07', 'Shipped', NULL, 141, 1107.92), 

(10204, '2003-12-02', '2003-12-10', '2003-12-04', 'Shipped', NULL, 151, 1619.73), 

(10205, '2003-12-03', '2003-12-09', '2003-12-07', 'Shipped', ' I need all the information I can get on our competitors.', 141, 347.45), 

(10206, '2003-12-05', '2003-12-13', '2003-12-08', 'Shipped', 'Can we renegotiate this one?', 202, 1065.55), 

(10207, '2003-12-09', '2003-12-17', '2003-12-11', 'Shipped', 'Check on availability.', 495, 1560.08), 

(10208, '2004-01-02', '2004-01-11', '2004-01-04', 'Shipped', NULL, 146, 1438.31), 

(10209, '2004-01-09', '2004-01-15', '2004-01-12', 'Shipped', NULL, 347, 646.57), 

(10210, '2004-01-12', '2004-01-22', '2004-01-20', 'Shipped', NULL, 177, 1443.06), 

(10211, '2004-01-15', '2004-01-25', '2004-01-18', 'Shipped', NULL, 406, 1399.57), 

(10212, '2004-01-16', '2004-01-24', '2004-01-18', 'Shipped', NULL, 141, 1541.83), 

(10213, '2004-01-22', '2004-01-28', '2004-01-27', 'Shipped', 'Difficult to negotiate with customer. We need more marketing materials', 489, 240.59), 

(10214, '2004-01-26', '2004-02-04', '2004-01-29', 'Shipped', NULL, 458, 623.43), 

(10215, '2004-01-29', '2004-02-08', '2004-02-01', 'Shipped', 'Customer requested that FedEx Ground is used for this shipping', 475, 916.49), 

(10216, '2004-02-02', '2004-02-10', '2004-02-04', 'Shipped', NULL, 256, 133.94), 

(10217, '2004-02-04', '2004-02-14', '2004-02-06', 'Shipped', NULL, 166, 638.71), 

(10218, '2004-02-09', '2004-02-16', '2004-02-11', 'Shipped', 'Customer requested that ad materials (such as posters, pamphlets) be included in the shippment', 473, 262.87), 

(10219, '2004-02-10', '2004-02-17', '2004-02-12', 'Shipped', NULL, 487, 306.16), 

(10220, '2004-02-12', '2004-02-19', '2004-02-16', 'Shipped', NULL, 189, 982.07), 

(10221, '2004-02-18', '2004-02-26', '2004-02-19', 'Shipped', NULL, 314, 490.22), 

(10222, '2004-02-19', '2004-02-27', '2004-02-20', 'Shipped', NULL, 239, 1389.51), 

(10223, '2004-02-20', '2004-02-29', '2004-02-24', 'Shipped', NULL, 114, 1304.29), 

(10224, '2004-02-21', '2004-03-02', '2004-02-26', 'Shipped', 'Customer has worked with some of our vendors in the past and is aware of their MSRP', 171, 472.32), 

(10225, '2004-02-22', '2004-03-01', '2004-02-24', 'Shipped', NULL, 298, 1392.48), 

(10226, '2004-02-26', '2004-03-06', '2004-03-02', 'Shipped', NULL, 239, 694.52), 

(10227, '2004-03-02', '2004-03-12', '2004-03-08', 'Shipped', NULL, 146, 1220.54), 

(10228, '2004-03-10', '2004-03-18', '2004-03-13', 'Shipped', NULL, 173, 658.67), 

(10229, '2004-03-11', '2004-03-20', '2004-03-12', 'Shipped', NULL, 124, 1246.31), 

(10230, '2004-03-15', '2004-03-24', '2004-03-20', 'Shipped', 'Customer very concerned about the exact color of the models. There is high risk that he may dispute the order because there is a slight color mismatch', 128, 788.41), 

(10231, '2004-03-19', '2004-03-26', '2004-03-25', 'Shipped', NULL, 344, 340.32), 

(10232, '2004-03-20', '2004-03-30', '2004-03-25', 'Shipped', NULL, 240, 723.9), 

(10233, '2004-03-29', '2004-04-04', '2004-04-02', 'Shipped', 'Customer requested special shippment. The instructions were passed along to the warehouse', 328, 204.75), 

(10234, '2004-03-30', '2004-04-05', '2004-04-02', 'Shipped', NULL, 412, 775.05), 

(10235, '2004-04-02', '2004-04-12', '2004-04-06', 'Shipped', NULL, 260, 926.24), 

(10236, '2004-04-03', '2004-04-11', '2004-04-08', 'Shipped', NULL, 486, 224.07), 

(10237, '2004-04-05', '2004-04-12', '2004-04-10', 'Shipped', NULL, 181, 809.92), 

(10238, '2004-04-09', '2004-04-16', '2004-04-10', 'Shipped', NULL, 145, 794.15), 

(10239, '2004-04-12', '2004-04-21', '2004-04-17', 'Shipped', NULL, 311, 471.61), 

(10240, '2004-04-13', '2004-04-20', '2004-04-20', 'Shipped', NULL, 177, 396.75), 

(10241, '2004-04-13', '2004-04-20', '2004-04-19', 'Shipped', NULL, 209, 1097.13), 

(10242, '2004-04-20', '2004-04-28', '2004-04-25', 'Shipped', 'Customer is interested in buying more Ferrari models', 456, 36.52), 

(10243, '2004-04-26', '2004-05-03', '2004-04-28', 'Shipped', NULL, 495, 142.74), 

(10244, '2004-04-29', '2004-05-09', '2004-05-04', 'Shipped', NULL, 141, 744.69), 

(10245, '2004-05-04', '2004-05-12', '2004-05-09', 'Shipped', NULL, 455, 956.28), 

(10246, '2004-05-05', '2004-05-13', '2004-05-06', 'Shipped', NULL, 141, 1006.78), 

(10247, '2004-05-05', '2004-05-11', '2004-05-08', 'Shipped', NULL, 334, 757.24), 

(10248, '2004-05-07', '2004-05-14', NULL, 'Cancelled', 'Order was mistakenly placed. The warehouse noticed the lack of documentation.', 131, 1263.34), 

(10249, '2004-05-08', '2004-05-17', '2004-05-11', 'Shipped', 'Can we deliver the new Ford Mustang models by end-of-quarter?', 173, 344.64), 

(10250, '2004-05-11', '2004-05-19', '2004-05-15', 'Shipped', NULL, 450, 1146.61), 

(10251, '2004-05-18', '2004-05-24', '2004-05-24', 'Shipped', NULL, 328, 660.49), 

(10252, '2004-05-26', '2004-06-04', '2004-05-29', 'Shipped', NULL, 406, 733.69), 

(10253, '2004-06-01', '2004-06-09', '2004-06-02', 'Cancelled', 'Customer disputed the order and we agreed to cancel it. We must be more cautions with this customer going forward, since they are very hard to please. We must cover the shipping fees.', 201, 1469.39), 

(10254, '2004-06-03', '2004-06-13', '2004-06-04', 'Shipped', 'Customer requested that DHL is used for this shipping', 323, 983.52), 

(10255, '2004-06-04', '2004-06-12', '2004-06-09', 'Shipped', NULL, 209, 172.63), 

(10256, '2004-06-08', '2004-06-16', '2004-06-10', 'Shipped', NULL, 145, 146.32), 

(10257, '2004-06-14', '2004-06-24', '2004-06-15', 'Shipped', NULL, 450, 408.39), 

(10258, '2004-06-15', '2004-06-25', '2004-06-23', 'Shipped', NULL, 398, 624.48), 

(10259, '2004-06-15', '2004-06-22', '2004-06-17', 'Shipped', NULL, 166, 1259.09), 

(10260, '2004-06-16', '2004-06-22', NULL, 'Cancelled', 'Customer heard complaints from their customers and called to cancel this order. Will notify the Sales Manager.', 357, 1152.26), 

(10261, '2004-06-17', '2004-06-25', '2004-06-22', 'Shipped', NULL, 233, 726.83), 

(10262, '2004-06-24', '2004-07-01', NULL, 'Cancelled', 'This customer found a better offer from one of our competitors. Will call back to renegotiate.', 141, 1217.38), 

(10263, '2004-06-28', '2004-07-04', '2004-07-02', 'Shipped', NULL, 175, 1078.64), 

(10264, '2004-06-30', '2004-07-06', '2004-07-01', 'Shipped', 'Customer will send a truck to our local warehouse on 7/1/2004', 362, 526.81), 

(10265, '2004-07-02', '2004-07-09', '2004-07-07', 'Shipped', NULL, 471, 198.25), 

(10266, '2004-07-06', '2004-07-14', '2004-07-10', 'Shipped', NULL, 386, 1556.31), 

(10267, '2004-07-07', '2004-07-17', '2004-07-09', 'Shipped', NULL, 151, 495.98), 

(10268, '2004-07-12', '2004-07-18', '2004-07-14', 'Shipped', NULL, 412, 924.64), 

(10269, '2004-07-16', '2004-07-22', '2004-07-18', 'Shipped', NULL, 382, 152.9), 

(10270, '2004-07-19', '2004-07-27', '2004-07-24', 'Shipped', 'Can we renegotiate this one?', 282, 1088.2), 

(10271, '2004-07-20', '2004-07-29', '2004-07-23', 'Shipped', NULL, 124, 1054.03), 

(10272, '2004-07-20', '2004-07-26', '2004-07-22', 'Shipped', NULL, 157, 696.54), 

(10273, '2004-07-21', '2004-07-28', '2004-07-22', 'Shipped', NULL, 314, 1309.01), 

(10274, '2004-07-21', '2004-07-29', '2004-07-22', 'Shipped', NULL, 379, 376.05), 

(10275, '2004-07-23', '2004-08-02', '2004-07-29', 'Shipped', NULL, 119, 1455.41), 

(10276, '2004-08-02', '2004-08-11', '2004-08-08', 'Shipped', NULL, 204, 1285.44), 

(10277, '2004-08-04', '2004-08-12', '2004-08-05', 'Shipped', NULL, 148, 93.28), 

(10278, '2004-08-06', '2004-08-16', '2004-08-09', 'Shipped', NULL, 112, 920.21), 

(10279, '2004-08-09', '2004-08-19', '2004-08-15', 'Shipped', 'Cautious optimism. We have happy customers here, if we can keep them well stocked. I need all the information I can get on the planned shippments of Porches', 141, 494.03), 

(10280, '2004-08-17', '2004-08-27', '2004-08-19', 'Shipped', NULL, 249, 1518.1), 

(10281, '2004-08-19', '2004-08-28', '2004-08-23', 'Shipped', NULL, 157, 1224.88), 

(10282, '2004-08-20', '2004-08-26', '2004-08-22', 'Shipped', NULL, 124, 1426.43), 

(10283, '2004-08-20', '2004-08-30', '2004-08-23', 'Shipped', NULL, 260, 1107.44), 

(10284, '2004-08-21', '2004-08-29', '2004-08-26', 'Shipped', 'Custom shipping instructions sent to warehouse', 299, 985.48), 

(10285, '2004-08-27', '2004-09-04', '2004-08-31', 'Shipped', NULL, 286, 1170.23), 

(10286, '2004-08-28', '2004-09-06', '2004-09-01', 'Shipped', NULL, 172, 51.60), 

(10287, '2004-08-30', '2004-09-06', '2004-09-01', 'Shipped', NULL, 298, 1801.52), 

(10288, '2004-09-01', '2004-09-11', '2004-09-05', 'Shipped', NULL, 166, 1144.49), 

(10289, '2004-09-03', '2004-09-13', '2004-09-04', 'Shipped', 'We need to keep in close contact with their Marketing VP. He is the decision maker for all their purchases.', 167, 320.19), 

(10290, '2004-09-07', '2004-09-15', '2004-09-13', 'Shipped', NULL, 198, 164.12), 

(10291, '2004-09-08', '2004-09-17', '2004-09-14', 'Shipped', NULL, 448, 1348.49), 

(10292, '2004-09-08', '2004-09-18', '2004-09-11', 'Shipped', 'They want to reevaluate their terms agreement with Finance.', 131, 1074.32), 

(10293, '2004-09-09', '2004-09-18', '2004-09-14', 'Shipped', NULL, 249, 1004.59), 

(10294, '2004-09-10', '2004-09-17', '2004-09-14', 'Shipped', NULL, 204, 98.32), 

(10295, '2004-09-10', '2004-09-17', '2004-09-14', 'Shipped', 'They want to reevaluate their terms agreement with Finance.', 362, 446.8), 

(10296, '2004-09-15', '2004-09-22', '2004-09-16', 'Shipped', NULL, 415, 1079.12), 

(10297, '2004-09-16', '2004-09-22', '2004-09-21', 'Shipped', 'We must be cautions with this customer. Their VP of Sales resigned. Company may be heading down.', 189, 594.71), 

(10298, '2004-09-27', '2004-10-05', '2004-10-01', 'Shipped', NULL, 103, 166.43), 

(10299, '2004-09-30', '2004-10-10', '2004-10-01', 'Shipped', NULL, 186, 976.32), 

(10300, '2003-10-04', '2003-10-13', '2003-10-09', 'Shipped', NULL, 128, 798.48), 

(10301, '2003-10-05', '2003-10-15', '2003-10-08', 'Shipped', NULL, 299, 1084.81), 

(10302, '2003-10-06', '2003-10-16', '2003-10-07', 'Shipped', NULL, 201, 574.41), 

(10303, '2004-10-06', '2004-10-14', '2004-10-09', 'Shipped', 'Customer inquired about remote controlled models and gold models.', 484, 92.61), 

(10304, '2004-10-11', '2004-10-20', '2004-10-17', 'Shipped', NULL, 256, 1479.94), 

(10305, '2004-10-13', '2004-10-22', '2004-10-15', 'Shipped', 'Check on availability.', 286, 1378.68), 

(10306, '2004-10-14', '2004-10-21', '2004-10-17', 'Shipped', NULL, 187, 1612.26), 

(10307, '2004-10-14', '2004-10-23', '2004-10-20', 'Shipped', NULL, 339, 741.25), 

(10308, '2004-10-15', '2004-10-24', '2004-10-20', 'Shipped', 'Customer requested that FedEx Ground is used for this shipping', 319, 1334.48), 

(10309, '2004-10-15', '2004-10-24', '2004-10-18', 'Shipped', NULL, 121, 563.75), 

(10310, '2004-10-16', '2004-10-24', '2004-10-18', 'Shipped', NULL, 259, 1656.26), 

(10311, '2004-10-16', '2004-10-23', '2004-10-20', 'Shipped', 'Difficult to negotiate with customer. We need more marketing materials', 141, 1033.82), 

(10312, '2004-10-21', '2004-10-27', '2004-10-23', 'Shipped', NULL, 124, 1494.19), 

(10313, '2004-10-22', '2004-10-28', '2004-10-25', 'Shipped', 'Customer requested that FedEx Ground is used for this shipping', 202, 1088.17), 

(10314, '2004-10-22', '2004-11-01', '2004-10-23', 'Shipped', NULL, 227, 1549.34), 

(10315, '2004-10-29', '2004-11-08', '2004-10-30', 'Shipped', NULL, 119, 568.27), 

(10316, '2004-11-01', '2004-11-09', '2004-11-07', 'Shipped', 'Customer requested that ad materials (such as posters, pamphlets) be included in the shippment', 240, 1375.59), 

(10317, '2004-11-02', '2004-11-12', '2004-11-08', 'Shipped', NULL, 161, 69.55), 

(10318, '2004-11-02', '2004-11-09', '2004-11-07', 'Shipped', NULL, 157, 846.35), 

(10319, '2004-11-03', '2004-11-11', '2004-11-06', 'Shipped', 'Customer requested that DHL is used for this shipping', 456, 742.37), 

(10320, '2004-11-03', '2004-11-13', '2004-11-07', 'Shipped', NULL, 144, 551.11), 

(10321, '2004-11-04', '2004-11-12', '2004-11-07', 'Shipped', NULL, 462, 1397.94), 

(10322, '2004-11-04', '2004-11-12', '2004-11-10', 'Shipped', 'Customer has worked with some of our vendors in the past and is aware of their MSRP', 363, 1345.23), 

(10323, '2004-11-05', '2004-11-12', '2004-11-09', 'Shipped', NULL, 128, 185.16), 

(10324, '2004-11-05', '2004-11-11', '2004-11-08', 'Shipped', NULL, 181, 1319.42), 

(10325, '2004-11-05', '2004-11-13', '2004-11-08', 'Shipped', NULL, 121, 955.8), 

(10326, '2004-11-09', '2004-11-16', '2004-11-10', 'Shipped', NULL, 144, 517.7), 

(10327, '2004-11-10', '2004-11-19', '2004-11-13', 'Resolved', 'Order was disputed and resolved on 12/1/04. The Sales Manager was involved. Customer claims the scales of the models do not match what was discussed.', 145, 665.06), 

(10328, '2004-11-12', '2004-11-21', '2004-11-18', 'Shipped', 'Customer very concerned about the exact color of the models. There is high risk that he may dispute the order because there is a slight color mismatch', 278, 1054.8), 

(10329, '2004-11-15', '2004-11-24', '2004-11-16', 'Shipped', NULL, 131, 1445.1), 

(10330, '2004-11-16', '2004-11-25', '2004-11-21', 'Shipped', NULL, 385, 385.78), 

(10331, '2004-11-17', '2004-11-23', '2004-11-23', 'Shipped', 'Customer requested special shippment. The instructions were passed along to the warehouse', 486, 1451.43), 

(10332, '2004-11-17', '2004-11-25', '2004-11-18', 'Shipped', NULL, 187, 1347.08), 

(10333, '2004-11-18', '2004-11-27', '2004-11-20', 'Shipped', NULL, 129, 811.28), 

(10334, '2004-11-19', '2004-11-28', NULL, 'On Hold', 'The outstaniding balance for this customer exceeds their credit limit. Order will be shipped when a payment is received.', 144, 657.49), 

(10335, '2004-11-19', '2004-11-29', '2004-11-23', 'Shipped', NULL, 124, 159.71), 

(10336, '2004-11-20', '2004-11-26', '2004-11-24', 'Shipped', 'Customer requested that DHL is used for this shipping', 172, 1357.7), 

(10337, '2004-11-21', '2004-11-30', '2004-11-26', 'Shipped', NULL, 424, 813.03), 

(10338, '2004-11-22', '2004-12-02', '2004-11-27', 'Shipped', NULL, 381, 311.22), 

(10339, '2004-11-23', '2004-11-30', '2004-11-30', 'Shipped', NULL, 398, 1274.96), 

(10340, '2004-11-24', '2004-12-01', '2004-11-25', 'Shipped', 'Customer is interested in buying more Ferrari models', 216, 580.85), 

(10341, '2004-11-24', '2004-12-01', '2004-11-29', 'Shipped', NULL, 382, 1003.19), 

(10342, '2004-11-24', '2004-12-01', '2004-11-29', 'Shipped', NULL, 114, 1063.74), 

(10343, '2004-11-24', '2004-12-01', '2004-11-26', 'Shipped', NULL, 353, 514.45), 

(10344, '2004-11-25', '2004-12-02', '2004-11-29', 'Shipped', NULL, 350, 573.86), 

(10345, '2004-11-25', '2004-12-01', '2004-11-26', 'Shipped', NULL, 103, 38.98), 

(10346, '2004-11-29', '2004-12-05', '2004-11-30', 'Shipped', NULL, 112, 515.95), 

(10347, '2004-11-29', '2004-12-07', '2004-11-30', 'Shipped', 'Can we deliver the new Ford Mustang models by end-of-quarter?', 114, 1240.73), 

(10348, '2004-11-01', '2004-11-08', '2004-11-05', 'Shipped', NULL, 458, 817.43), 

(10349, '2004-12-01', '2004-12-07', '2004-12-03', 'Shipped', NULL, 151, 1083.64), 

(10350, '2004-12-02', '2004-12-08', '2004-12-05', 'Shipped', NULL, 141, 1412.81), 

(10351, '2004-12-03', '2004-12-11', '2004-12-07', 'Shipped', NULL, 324, 434.87), 

(10352, '2004-12-03', '2004-12-12', '2004-12-09', 'Shipped', NULL, 198, 271.25), 

(10353, '2004-12-04', '2004-12-11', '2004-12-05', 'Shipped', NULL, 447, 685.32), 

(10354, '2004-12-04', '2004-12-10', '2004-12-05', 'Shipped', NULL, 323, 1285.99), 

(10355, '2004-12-07', '2004-12-14', '2004-12-13', 'Shipped', NULL, 141, 796.66), 

(10356, '2004-12-09', '2004-12-15', '2004-12-12', 'Shipped', NULL, 250, 795.62), 

(10357, '2004-12-10', '2004-12-16', '2004-12-14', 'Shipped', NULL, 124, 1060.42), 

(10358, '2004-12-10', '2004-12-16', '2004-12-16', 'Shipped', 'Customer requested that DHL is used for this shipping', 141, 1297.97), 

(10359, '2004-12-15', '2004-12-23', '2004-12-18', 'Shipped', NULL, 353, 829.24), 

(10360, '2004-12-16', '2004-12-22', '2004-12-18', 'Shipped', NULL, 496, 1524.68), 

(10361, '2004-12-17', '2004-12-24', '2004-12-20', 'Shipped', NULL, 282, 1052.87), 

(10362, '2005-01-05', '2005-01-16', '2005-01-10', 'Shipped', NULL, 161, 458.28), 

(10363, '2005-01-06', '2005-01-12', '2005-01-10', 'Shipped', NULL, 334, 1352.37), 

(10364, '2005-01-06', '2005-01-17', '2005-01-09', 'Shipped', NULL, 350, 38.22), 

(10365, '2005-01-07', '2005-01-18', '2005-01-11', 'Shipped', NULL, 320, 267.06), 

(10366, '2005-01-10', '2005-01-19', '2005-01-12', 'Shipped', NULL, 381, 376.35), 

(10367, '2005-01-12', '2005-01-21', '2005-01-16', 'Resolved', 'This order was disputed and resolved on 2/1/2005. Customer claimed that container with shipment was damaged. FedEx investigation proved this wrong.', 205, 1072.73), 

(10368, '2005-01-19', '2005-01-27', '2005-01-24', 'Shipped', 'Can we renegotiate this one?', 124, 401.41), 

(10369, '2005-01-20', '2005-01-28', '2005-01-24', 'Shipped', NULL, 379, 746.8), 

(10370, '2005-01-20', '2005-02-01', '2005-01-25', 'Shipped', NULL, 276, 898.11), 

(10371, '2005-01-23', '2005-02-03', '2005-01-25', 'Shipped', NULL, 124, 1116.35), 

(10372, '2005-01-26', '2005-02-05', '2005-01-28', 'Shipped', NULL, 398, 941.08), 

(10373, '2005-01-31', '2005-02-08', '2005-02-06', 'Shipped', NULL, 311, 1316.57), 

(10374, '2005-02-02', '2005-02-09', '2005-02-03', 'Shipped', NULL, 333, 617.75), 

(10375, '2005-02-03', '2005-02-10', '2005-02-06', 'Shipped', NULL, 119, 1299.1), 

(10376, '2005-02-08', '2005-02-18', '2005-02-13', 'Shipped', NULL, 219, 98.65), 

(10377, '2005-02-09', '2005-02-21', '2005-02-12', 'Shipped', 'Cautious optimism. We have happy customers here, if we can keep them well stocked. I need all the information I can get on the planned shippments of Porches', 186, 633.58), 

(10378, '2005-02-10', '2005-02-18', '2005-02-11', 'Shipped', NULL, 141, 847.09), 

(10379, '2005-02-10', '2005-02-18', '2005-02-11', 'Shipped', NULL, 141, 503.79), 

(10380, '2005-02-16', '2005-02-24', '2005-02-18', 'Shipped', NULL, 141, 1034.1), 

(10381, '2005-02-17', '2005-02-25', '2005-02-18', 'Shipped', NULL, 321, 923.04), 

(10382, '2005-02-17', '2005-02-23', '2005-02-18', 'Shipped', 'Custom shipping instructions sent to warehouse', 124, 1426.01), 

(10383, '2005-02-22', '2005-03-02', '2005-02-25', 'Shipped', NULL, 141, 1155.3), 

(10384, '2005-02-23', '2005-03-06', '2005-02-27', 'Shipped', NULL, 321, 386.2), 

(10385, '2005-02-28', '2005-03-09', '2005-03-01', 'Shipped', NULL, 124, 140.83), 

(10386, '2005-03-01', '2005-03-09', '2005-03-06', 'Resolved', 'Disputed then Resolved on 3/15/2005. Customer does not like the craftsmaship of the models.', 141, 1352.06), 

(10387, '2005-03-02', '2005-03-09', '2005-03-06', 'Shipped', 'We need to keep in close contact with their Marketing VP. He is the decision maker for all their purchases.', 148, 79.91), 

(10388, '2005-03-03', '2005-03-11', '2005-03-09', 'Shipped', NULL, 462, 667.12), 

(10389, '2005-03-03', '2005-03-09', '2005-03-08', 'Shipped', NULL, 448, 747.53), 

(10390, '2005-03-04', '2005-03-11', '2005-03-07', 'Shipped', 'They want to reevaluate their terms agreement with Finance.', 124, 1479.36), 

(10391, '2005-03-09', '2005-03-20', '2005-03-15', 'Shipped', NULL, 276, 911.23), 

(10392, '2005-03-10', '2005-03-18', '2005-03-12', 'Shipped', NULL, 452, 263.1), 

(10393, '2005-03-11', '2005-03-22', '2005-03-14', 'Shipped', 'They want to reevaluate their terms agreement with Finance.', 323, 1067.87), 

(10394, '2005-03-15', '2005-03-25', '2005-03-19', 'Shipped', NULL, 141, 556.06), 

(10395, '2005-03-17', '2005-03-24', '2005-03-23', 'Shipped', 'We must be cautions with this customer. Their VP of Sales resigned. Company may be heading down.', 250, 487.22), 

(10396, '2005-03-23', '2005-04-02', '2005-03-28', 'Shipped', NULL, 124, 778.38), 

(10397, '2005-03-28', '2005-04-09', '2005-04-01', 'Shipped', NULL, 242, 351.72), 

(10398, '2005-03-30', '2005-04-09', '2005-03-31', 'Shipped', NULL, 353, 1355.03), 

(10399, '2005-04-01', '2005-04-12', '2005-04-03', 'Shipped', NULL, 496, 787.39), 

(10400, '2005-04-01', '2005-04-11', '2005-04-04', 'Shipped', 'Customer requested that DHL is used for this shipping', 450, 741.11), 

(10401, '2005-04-03', '2005-04-14', NULL, 'On Hold', 'Customer credit limit exceeded. Will ship when a payment is received.', 328, 886.7), 

(10402, '2005-04-07', '2005-04-14', '2005-04-12', 'Shipped', NULL, 406, 238.79), 

(10403, '2005-04-08', '2005-04-18', '2005-04-11', 'Shipped', NULL, 201, 793.27), 

(10404, '2005-04-08', '2005-04-14', '2005-04-11', 'Shipped', NULL, 323, 771.8), 

(10405, '2005-04-14', '2005-04-24', '2005-04-20', 'Shipped', NULL, 209, 500.04), 

(10406, '2005-04-15', '2005-04-25', '2005-04-21', 'Disputed', 'Customer claims container with shipment was damaged during shipping and some items were missing. I am talking to FedEx about this.', 145, 375.54), 

(10407, '2005-04-22', '2005-05-04', NULL, 'On Hold', 'Customer credit limit exceeded. Will ship when a payment is received.', 450, 1074.29), 

(10408, '2005-04-22', '2005-04-29', '2005-04-27', 'Shipped', NULL, 398, 41.03), 

(10409, '2005-04-23', '2005-05-05', '2005-04-24', 'Shipped', NULL, 166, 132.13), 

(10410, '2005-04-29', '2005-05-10', '2005-04-30', 'Shipped', NULL, 357, 743.35), 

(10411, '2005-05-01', '2005-05-08', '2005-05-06', 'Shipped', NULL, 233, 946.47), 

(10412, '2005-05-03', '2005-05-13', '2005-05-05', 'Shipped', NULL, 141, 1034.15), 

(10413, '2005-05-05', '2005-05-14', '2005-05-09', 'Shipped', 'Customer requested that DHL is used for this shipping', 175, 763.06), 

(10414, '2005-05-06', '2005-05-13', NULL, 'On Hold', 'Customer credit limit exceeded. Will ship when a payment is received.', 362, 1163.89), 

(10415, '2005-05-09', '2005-05-20', '2005-05-12', 'Disputed', 'Customer claims the scales of the models do not match what was discussed. I keep all the paperwork though to prove otherwise', 471, 324.13), 

(10416, '2005-05-10', '2005-05-16', '2005-05-14', 'Shipped', NULL, 386, 1084.51), 

(10417, '2005-05-13', '2005-05-19', '2005-05-19', 'Disputed', 'Customer does not like the colors and precision of the models.', 141, 671.33), 

(10418, '2005-05-16', '2005-05-24', '2005-05-20', 'Shipped', NULL, 412, 727.23), 

(10419, '2005-05-17', '2005-05-28', '2005-05-19', 'Shipped', NULL, 382, 1471.49), 

(10420, '2005-05-29', '2005-06-07', NULL, 'In Process', NULL, 282, 1014.01), 

(10421, '2005-05-29', '2005-06-06', NULL, 'In Process', 'Custom shipping instructions were sent to warehouse', 124, 211.86), 

(10422, '2005-05-30', '2005-06-11', NULL, 'In Process', NULL, 157, 138.88), 

(10423, '2005-05-30', '2005-06-05', NULL, 'In Process', NULL, 314, 403.05), 

(10424, '2005-05-31', '2005-06-08', NULL, 'In Process', NULL, 141, 612.75), 

(10425, '2005-05-31', '2005-06-07', NULL, 'In Process', NULL, 119, 1231.98) ON DUPLICATE KEY UPDATE `order_id`=`order_id`;

/* Data for the table `orderdetail` */

insert into `orderdetail`(`order_id`, `product_id`, `quantity_ordered`, `price_each`, `order_line_number`) values 

(10100, 23, 30, '136.00', 3), 

(10100, 27, 50, '55.09', 2), 

(10100, 50, 22, '75.46', 4), 

(10100, 80, 49, '35.29', 1), 

(10101, 29, 25, '108.06', 4), 

(10101, 33, 26, '167.06', 1), 

(10101, 61, 45, '32.53', 3), 

(10101, 64, 46, '44.35', 2), 

(10102, 19, 39, '95.55', 2), 

(10102, 20, 41, '43.13', 1), 

(10103, 2, 26, '214.30', 11), 

(10103, 6, 42, '119.67', 4), 

(10103, 9, 27, '121.64', 8), 

(10103, 17, 35, '94.50', 10), 

(10103, 30, 22, '58.34', 2), 

(10103, 35, 27, '92.19', 12), 

(10103, 36, 35, '61.84', 14), 

(10103, 38, 25, '86.92', 13), 

(10103, 44, 46, '86.31', 16), 

(10103, 52, 36, '98.07', 5), 

(10103, 53, 41, '40.75', 9), 

(10103, 65, 36, '107.34', 1), 

(10103, 82, 25, '88.62', 15), 

(10103, 85, 31, '92.46', 3), 

(10103, 90, 45, '63.35', 7), 

(10103, 103, 42, '94.07', 6), 

(10104, 11, 34, '131.44', 1), 

(10104, 15, 41, '111.39', 9), 

(10104, 26, 24, '135.90', 8), 

(10104, 28, 29, '122.73', 12), 

(10104, 40, 23, '165.95', 13), 

(10104, 49, 38, '119.20', 3), 

(10104, 57, 35, '52.02', 6), 

(10104, 68, 44, '30.41', 10), 

(10104, 81, 26, '106.45', 5), 

(10104, 88, 35, '51.95', 11), 

(10104, 89, 49, '56.55', 4), 

(10104, 94, 33, '114.59', 7), 

(10104, 95, 32, '53.31', 2), 

(10105, 5, 50, '127.84', 2), 

(10105, 8, 41, '205.72', 15), 

(10105, 13, 29, '141.88', 14), 

(10105, 39, 22, '136.59', 11), 

(10105, 42, 38, '87.73', 13), 

(10105, 51, 41, '75.48', 10), 

(10105, 63, 43, '117.97', 9), 

(10105, 72, 44, '73.46', 4), 

(10105, 77, 50, '75.47', 1), 

(10105, 97, 41, '54.00', 5), 

(10105, 99, 29, '86.61', 12), 

(10105, 102, 31, '60.72', 3), 

(10105, 106, 39, '92.16', 6), 

(10105, 107, 22, '99.31', 7), 

(10105, 110, 25, '44.77', 8), 

(10106, 22, 36, '134.04', 12), 

(10106, 31, 34, '81.10', 2), 

(10106, 37, 41, '80.86', 18), 

(10106, 48, 41, '94.22', 17), 

(10106, 60, 28, '107.23', 4), 

(10106, 69, 49, '65.77', 13), 

(10106, 75, 31, '55.89', 14), 

(10106, 79, 50, '55.96', 11), 

(10106, 83, 26, '71.00', 3), 

(10106, 91, 33, '65.35', 5), 

(10106, 93, 39, '35.78', 6), 

(10106, 98, 31, '91.34', 7), 

(10106, 100, 30, '85.09', 16), 

(10106, 101, 34, '99.72', 9), 

(10106, 104, 32, '113.90', 1), 

(10106, 105, 44, '76.00', 8), 

(10106, 108, 48, '70.33', 10), 

(10106, 109, 48, '43.70', 15), 

(10107, 1, 30, '81.35', 2), 

(10107, 3, 39, '105.86', 5), 

(10107, 4, 27, '172.36', 4), 

(10107, 10, 21, '122.00', 1), 

(10107, 32, 29, '52.70', 6), 

(10107, 58, 25, '96.92', 3), 

(10107, 62, 38, '73.12', 7), 

(10107, 86, 20, '88.90', 8), 

(10108, 7, 33, '165.38', 6), 

(10108, 12, 45, '96.30', 4), 

(10108, 14, 39, '75.81', 7), 

(10108, 16, 36, '107.10', 3), 

(10108, 24, 38, '67.76', 2), 

(10108, 43, 26, '73.17', 9), 

(10108, 45, 29, '132.29', 8), 

(10108, 47, 43, '52.84', 12), 

(10108, 54, 44, '139.87', 11), 

(10108, 66, 35, '64.41', 15), 

(10108, 74, 30, '60.01', 5), 

(10108, 78, 40, '132.00', 1), 

(10108, 84, 31, '67.10', 10), 

(10108, 87, 27, '36.21', 13), 

(10108, 92, 31, '87.76', 16), 

(10108, 96, 34, '74.85', 14), 

(10109, 18, 26, '117.48', 4), 

(10109, 25, 38, '137.98', 3), 

(10109, 34, 26, '126.72', 1), 

(10109, 40, 46, '160.87', 5), 

(10109, 46, 47, '125.74', 2), 

(10109, 71, 29, '32.10', 6), 

(10110, 21, 37, '118.22', 16), 

(10110, 23, 42, '153.00', 7), 

(10110, 27, 32, '51.46', 6), 

(10110, 29, 33, '115.69', 4), 

(10110, 33, 31, '163.69', 1), 

(10110, 50, 28, '81.91', 8), 

(10110, 55, 42, '62.00', 9), 

(10110, 56, 36, '72.02', 13), 

(10110, 59, 29, '43.27', 15), 

(10110, 61, 20, '28.88', 3), 

(10110, 64, 39, '40.77', 2), 

(10110, 67, 43, '82.69', 11), 

(10110, 70, 46, '112.74', 10), 

(10110, 73, 27, '80.47', 12), 

(10110, 76, 37, '96.37', 14), 

(10110, 80, 48, '35.29', 5), 

(10111, 19, 33, '87.33', 6), 

(10111, 20, 48, '48.52', 5), 

(10111, 36, 28, '53.09', 2), 

(10111, 38, 43, '94.25', 1), 

(10111, 44, 39, '91.27', 4), 

(10111, 82, 26, '85.70', 3), 

(10112, 2, 29, '197.16', 1), 

(10112, 35, 23, '85.10', 2), 

(10113, 9, 21, '121.64', 2), 

(10113, 17, 49, '101.50', 4), 

(10113, 53, 50, '43.27', 3), 

(10113, 90, 23, '58.82', 1), 

(10114, 6, 31, '128.53', 8), 

(10114, 28, 39, '106.78', 3), 

(10114, 30, 45, '53.48', 6), 

(10114, 40, 48, '169.34', 4), 

(10114, 52, 41, '105.34', 9), 

(10114, 65, 21, '102.23', 5), 

(10114, 68, 24, '28.64', 1), 

(10114, 85, 32, '88.61', 7), 

(10114, 88, 28, '43.83', 2), 

(10114, 103, 42, '82.94', 10), 

(10115, 15, 46, '111.39', 5), 

(10115, 26, 46, '140.81', 4), 

(10115, 57, 47, '56.64', 2), 

(10115, 81, 44, '106.45', 1), 

(10115, 94, 27, '100.70', 3), 

(10116, 89, 27, '60.28', 1), 

(10117, 8, 33, '195.33', 9), 

(10117, 11, 43, '148.06', 10), 

(10117, 13, 39, '173.02', 8), 

(10117, 39, 26, '121.57', 5), 

(10117, 42, 21, '81.68', 7), 

(10117, 49, 22, '122.08', 12), 

(10117, 51, 23, '73.73', 4), 

(10117, 63, 41, '119.20', 3), 

(10117, 95, 21, '55.65', 11), 

(10117, 99, 38, '75.35', 6), 

(10117, 107, 45, '89.38', 1), 

(10117, 110, 50, '52.42', 2), 

(10118, 106, 36, '86.15', 1), 

(10119, 5, 46, '112.88', 11), 

(10119, 22, 43, '151.38', 3), 

(10119, 37, 21, '74.84', 9), 

(10119, 48, 27, '95.28', 8), 

(10119, 69, 41, '64.40', 4), 

(10119, 72, 35, '72.58', 13), 

(10119, 75, 20, '63.12', 5), 

(10119, 77, 35, '82.18', 10), 

(10119, 79, 28, '62.10', 2), 

(10119, 97, 25, '57.34', 14), 

(10119, 100, 29, '74.23', 7), 

(10119, 102, 38, '67.22', 12), 

(10119, 108, 26, '63.67', 1), 

(10119, 109, 28, '40.22', 6), 

(10120, 3, 29, '118.94', 3), 

(10120, 4, 46, '158.80', 2), 

(10120, 31, 29, '82.79', 8), 

(10120, 32, 46, '57.54', 4), 

(10120, 58, 35, '110.45', 1), 

(10120, 60, 39, '93.01', 10), 

(10120, 62, 34, '72.36', 5), 

(10120, 83, 29, '71.73', 9), 

(10120, 86, 22, '94.90', 6), 

(10120, 91, 29, '68.79', 11), 

(10120, 93, 49, '41.46', 12), 

(10120, 98, 47, '91.34', 13), 

(10120, 101, 24, '81.77', 15), 

(10120, 104, 24, '106.79', 7), 

(10120, 105, 43, '72.00', 14), 

(10121, 1, 34, '86.13', 5), 

(10121, 10, 50, '126.52', 4), 

(10121, 66, 32, '58.18', 2), 

(10121, 92, 25, '95.93', 3), 

(10121, 96, 44, '72.41', 1), 

(10122, 7, 42, '155.66', 10), 

(10122, 12, 37, '113.92', 8), 

(10122, 14, 32, '65.44', 11), 

(10122, 16, 20, '104.80', 7), 

(10122, 18, 34, '114.65', 2), 

(10122, 24, 43, '62.37', 6), 

(10122, 25, 31, '113.80', 1), 

(10122, 40, 25, '137.17', 3), 

(10122, 43, 21, '69.15', 13), 

(10122, 45, 21, '133.76', 12), 

(10122, 47, 35, '59.06', 16), 

(10122, 54, 28, '145.82', 15), 

(10122, 71, 39, '34.74', 4), 

(10122, 74, 34, '50.82', 9), 

(10122, 78, 43, '136.22', 5), 

(10122, 84, 29, '67.10', 14), 

(10122, 87, 31, '33.79', 17), 

(10123, 21, 26, '120.71', 2), 

(10123, 34, 46, '114.84', 3), 

(10123, 46, 34, '117.26', 4), 

(10123, 59, 50, '43.27', 1), 

(10124, 23, 21, '153.00', 6), 

(10124, 27, 42, '58.12', 5), 

(10124, 29, 42, '111.87', 3), 

(10124, 50, 36, '75.46', 7), 

(10124, 55, 23, '66.28', 8), 

(10124, 56, 22, '62.47', 12), 

(10124, 61, 45, '30.53', 2), 

(10124, 64, 22, '36.29', 1), 

(10124, 67, 32, '74.51', 10), 

(10124, 70, 25, '93.95', 9), 

(10124, 73, 49, '76.19', 11), 

(10124, 76, 43, '101.73', 13), 

(10124, 80, 46, '36.11', 4), 

(10125, 19, 32, '89.38', 1), 

(10125, 33, 34, '138.38', 2), 

(10126, 2, 38, '205.73', 11), 

(10126, 6, 22, '122.62', 4), 

(10126, 9, 21, '135.30', 8), 

(10126, 17, 38, '116.67', 10), 

(10126, 20, 42, '51.21', 17), 

(10126, 30, 43, '51.05', 2), 

(10126, 35, 31, '93.21', 12), 

(10126, 36, 46, '61.84', 14), 

(10126, 38, 30, '93.20', 13), 

(10126, 44, 38, '94.25', 16), 

(10126, 52, 50, '102.92', 5), 

(10126, 53, 43, '47.29', 9), 

(10126, 65, 27, '122.68', 1), 

(10126, 82, 34, '83.76', 15), 

(10126, 85, 43, '82.83', 3), 

(10126, 90, 26, '62.05', 7), 

(10126, 103, 45, '97.10', 6), 

(10127, 8, 46, '193.25', 2), 

(10127, 11, 46, '140.50', 3), 

(10127, 13, 42, '169.56', 1), 

(10127, 15, 24, '100.73', 11), 

(10127, 26, 45, '140.81', 10), 

(10127, 28, 45, '114.14', 14), 

(10127, 40, 22, '149.02', 15), 

(10127, 49, 25, '126.39', 5), 

(10127, 57, 20, '50.86', 8), 

(10127, 68, 39, '34.30', 12), 

(10127, 81, 20, '107.63', 7), 

(10127, 88, 45, '46.53', 13), 

(10127, 89, 29, '60.90', 6), 

(10127, 94, 46, '111.12', 9), 

(10127, 95, 46, '55.65', 4), 

(10128, 39, 41, '120.20', 2), 

(10128, 42, 41, '80.67', 4), 

(10128, 51, 43, '77.24', 1), 

(10128, 99, 32, '72.75', 3), 

(10129, 5, 33, '123.76', 2), 

(10129, 63, 45, '113.06', 9), 

(10129, 72, 41, '81.43', 4), 

(10129, 77, 50, '76.31', 1), 

(10129, 97, 31, '58.67', 5), 

(10129, 102, 45, '72.28', 3), 

(10129, 106, 42, '90.15', 6), 

(10129, 107, 30, '94.34', 7), 

(10129, 110, 32, '44.23', 8), 

(10130, 37, 40, '68.82', 2), 

(10130, 48, 33, '99.52', 1), 

(10131, 22, 21, '141.92', 4), 

(10131, 69, 35, '60.97', 5), 

(10131, 75, 29, '52.60', 6), 

(10131, 79, 50, '54.59', 3), 

(10131, 100, 22, '76.94', 8), 

(10131, 101, 40, '86.76', 1), 

(10131, 108, 26, '63.67', 2), 

(10131, 109, 21, '40.22', 7), 

(10132, 105, 36, '80.00', 1), 

(10133, 31, 49, '80.26', 3), 

(10133, 60, 41, '109.42', 5), 

(10133, 83, 46, '61.58', 4), 

(10133, 86, 23, '80.91', 1), 

(10133, 91, 49, '67.41', 6), 

(10133, 93, 27, '37.09', 7), 

(10133, 98, 24, '76.73', 8), 

(10133, 104, 27, '115.09', 2), 

(10134, 1, 41, '90.92', 2), 

(10134, 3, 27, '116.56', 5), 

(10134, 4, 31, '187.85', 4), 

(10134, 10, 20, '131.04', 1), 

(10134, 32, 30, '51.48', 6), 

(10134, 58, 35, '94.67', 3), 

(10134, 62, 43, '75.41', 7), 

(10135, 7, 42, '173.17', 7), 

(10135, 12, 48, '110.39', 5), 

(10135, 14, 24, '72.62', 8), 

(10135, 16, 29, '103.64', 4), 

(10135, 24, 48, '66.99', 3), 

(10135, 43, 45, '65.94', 10), 

(10135, 45, 42, '139.64', 9), 

(10135, 47, 45, '49.74', 13), 

(10135, 54, 31, '133.92', 12), 

(10135, 66, 29, '67.18', 16), 

(10135, 71, 20, '34.36', 1), 

(10135, 74, 27, '52.05', 6), 

(10135, 78, 47, '139.03', 2), 

(10135, 84, 23, '76.80', 11), 

(10135, 87, 33, '38.62', 14), 

(10135, 92, 30, '91.85', 17), 

(10135, 96, 44, '78.92', 15), 

(10136, 18, 25, '117.48', 2), 

(10136, 25, 36, '120.91', 1), 

(10136, 40, 41, '169.34', 3), 

(10137, 21, 44, '115.73', 2), 

(10137, 34, 37, '110.88', 3), 

(10137, 46, 31, '118.68', 4), 

(10137, 59, 26, '40.25', 1), 

(10138, 23, 33, '149.60', 6), 

(10138, 27, 22, '51.46', 5), 

(10138, 29, 38, '114.42', 3), 

(10138, 50, 47, '79.15', 7), 

(10138, 55, 23, '64.86', 8), 

(10138, 56, 45, '59.53', 12), 

(10138, 61, 22, '33.19', 2), 

(10138, 64, 33, '38.53', 1), 

(10138, 67, 28, '73.60', 10), 

(10138, 70, 30, '96.30', 9), 

(10138, 73, 49, '77.05', 11), 

(10138, 76, 21, '99.58', 13), 

(10138, 80, 29, '32.82', 4), 

(10139, 19, 31, '89.38', 7), 

(10139, 20, 49, '52.83', 6), 

(10139, 33, 41, '151.88', 8), 

(10139, 35, 46, '91.18', 1), 

(10139, 36, 20, '52.47', 3), 

(10139, 38, 20, '101.58', 2), 

(10139, 44, 30, '81.35', 5), 

(10139, 82, 29, '93.49', 4), 

(10140, 2, 37, '186.44', 11), 

(10140, 6, 26, '131.49', 4), 

(10140, 9, 38, '118.90', 8), 

(10140, 17, 32, '95.67', 10), 

(10140, 30, 46, '51.05', 2), 

(10140, 52, 40, '100.50', 5), 

(10140, 53, 29, '40.25', 9), 

(10140, 65, 47, '118.84', 1), 

(10140, 85, 26, '87.64', 3), 

(10140, 90, 28, '62.05', 7), 

(10140, 103, 36, '101.15', 6), 

(10141, 15, 21, '114.95', 5), 

(10141, 26, 39, '160.46', 4), 

(10141, 28, 47, '103.09', 8), 

(10141, 40, 34, '143.94', 9), 

(10141, 57, 20, '50.86', 2), 

(10141, 68, 21, '32.18', 6), 

(10141, 81, 40, '104.09', 1), 

(10141, 88, 24, '53.03', 7), 

(10141, 94, 44, '94.92', 3), 

(10142, 8, 33, '166.24', 12), 

(10142, 11, 33, '140.50', 13), 

(10142, 13, 46, '167.83', 11), 

(10142, 39, 47, '129.76', 8), 

(10142, 42, 22, '95.80', 10), 

(10142, 49, 24, '122.08', 15), 

(10142, 51, 24, '79.87', 7), 

(10142, 63, 33, '114.29', 6), 

(10142, 72, 49, '74.35', 1), 

(10142, 89, 42, '60.90', 16), 

(10142, 95, 42, '56.24', 14), 

(10142, 97, 41, '55.34', 2), 

(10142, 99, 43, '77.08', 9), 

(10142, 106, 21, '92.16', 3), 

(10142, 107, 38, '91.37', 4), 

(10142, 110, 39, '46.96', 5), 

(10143, 5, 49, '133.28', 15), 

(10143, 22, 32, '126.15', 7), 

(10143, 37, 46, '70.54', 13), 

(10143, 48, 34, '99.52', 12), 

(10143, 69, 27, '63.71', 8), 

(10143, 75, 33, '59.83', 9), 

(10143, 77, 23, '74.64', 14), 

(10143, 79, 28, '55.96', 6), 

(10143, 93, 34, '34.91', 1), 

(10143, 98, 36, '86.77', 2), 

(10143, 100, 26, '87.80', 11), 

(10143, 101, 26, '79.78', 4), 

(10143, 102, 31, '69.39', 16), 

(10143, 105, 28, '70.40', 3), 

(10143, 108, 34, '65.15', 5), 

(10143, 109, 37, '49.66', 10), 

(10144, 91, 20, '56.41', 1), 

(10145, 1, 45, '76.56', 6), 

(10145, 3, 37, '104.67', 9), 

(10145, 4, 33, '154.93', 8), 

(10145, 10, 49, '146.10', 5), 

(10145, 31, 30, '71.81', 14), 

(10145, 32, 30, '52.70', 10), 

(10145, 58, 43, '103.68', 7), 

(10145, 60, 40, '87.54', 16), 

(10145, 62, 47, '63.98', 11), 

(10145, 66, 27, '56.10', 3), 

(10145, 83, 33, '71.73', 15), 

(10145, 86, 33, '99.89', 12), 

(10145, 87, 31, '39.43', 1), 

(10145, 92, 27, '95.93', 4), 

(10145, 96, 38, '73.22', 2), 

(10145, 104, 20, '113.90', 13), 

(10146, 47, 47, '60.30', 2), 

(10146, 54, 29, '130.94', 1), 

(10147, 7, 48, '161.49', 7), 

(10147, 12, 31, '110.39', 5), 

(10147, 14, 21, '74.21', 8), 

(10147, 16, 33, '97.89', 4), 

(10147, 24, 26, '70.84', 3), 

(10147, 43, 36, '74.78', 10), 

(10147, 45, 37, '129.35', 9), 

(10147, 71, 25, '33.23', 1), 

(10147, 74, 30, '48.98', 6), 

(10147, 78, 23, '123.58', 2), 

(10147, 84, 31, '72.76', 11), 

(10148, 18, 23, '114.65', 13), 

(10148, 21, 47, '108.26', 9), 

(10148, 25, 25, '136.56', 12), 

(10148, 34, 27, '113.52', 10), 

(10148, 40, 32, '143.94', 14), 

(10148, 46, 28, '135.63', 11), 

(10148, 50, 34, '83.75', 1), 

(10148, 55, 29, '66.28', 2), 

(10148, 56, 25, '65.41', 6), 

(10148, 59, 47, '46.29', 8), 

(10148, 67, 21, '77.24', 4), 

(10148, 70, 34, '115.09', 3), 

(10148, 73, 31, '71.91', 5), 

(10148, 76, 27, '96.37', 7), 

(10149, 19, 50, '87.33', 4), 

(10149, 20, 30, '48.52', 3), 

(10149, 23, 34, '156.40', 11), 

(10149, 27, 24, '50.85', 10), 

(10149, 29, 33, '125.86', 8), 

(10149, 33, 23, '167.06', 5), 

(10149, 44, 42, '89.29', 2), 

(10149, 61, 36, '31.20', 7), 

(10149, 64, 49, '39.87', 6), 

(10149, 80, 26, '38.57', 9), 

(10149, 82, 20, '90.57', 1), 

(10150, 2, 45, '182.16', 8), 

(10150, 6, 20, '121.15', 1), 

(10150, 9, 30, '135.30', 5), 

(10150, 17, 34, '95.67', 7), 

(10150, 35, 47, '93.21', 9), 

(10150, 36, 30, '56.21', 11), 

(10150, 38, 26, '97.39', 10), 

(10150, 52, 49, '111.39', 2), 

(10150, 53, 30, '47.29', 6), 

(10150, 90, 49, '62.05', 4), 

(10150, 103, 20, '95.08', 3), 

(10151, 15, 24, '114.95', 3), 

(10151, 26, 43, '152.27', 2), 

(10151, 28, 49, '106.78', 6), 

(10151, 30, 39, '58.34', 9), 

(10151, 40, 21, '167.65', 7), 

(10151, 65, 42, '109.90', 8), 

(10151, 68, 30, '29.35', 4), 

(10151, 85, 27, '84.75', 10), 

(10151, 88, 41, '43.29', 5), 

(10151, 94, 26, '108.81', 1), 

(10152, 49, 35, '117.77', 1), 

(10152, 57, 25, '49.13', 4), 

(10152, 81, 23, '112.37', 3), 

(10152, 89, 33, '57.17', 2), 

(10153, 8, 20, '201.57', 11), 

(10153, 11, 42, '128.42', 12), 

(10153, 13, 49, '155.72', 10), 

(10153, 39, 31, '125.66', 7), 

(10153, 42, 29, '82.69', 9), 

(10153, 51, 22, '82.50', 6), 

(10153, 63, 40, '111.83', 5), 

(10153, 95, 31, '53.31', 13), 

(10153, 97, 43, '58.00', 1), 

(10153, 99, 31, '80.55', 8), 

(10153, 106, 50, '87.15', 2), 

(10153, 107, 20, '85.41', 3), 

(10153, 110, 50, '51.87', 4), 

(10154, 72, 31, '75.23', 2), 

(10154, 102, 36, '59.27', 1), 

(10155, 5, 32, '129.20', 13), 

(10155, 22, 38, '138.77', 5), 

(10155, 37, 44, '83.44', 11), 

(10155, 48, 29, '105.87', 10), 

(10155, 69, 23, '62.34', 6), 

(10155, 75, 34, '56.55', 7), 

(10155, 77, 37, '76.31', 12), 

(10155, 79, 44, '58.69', 4), 

(10155, 100, 32, '89.61', 9), 

(10155, 101, 20, '87.75', 2), 

(10155, 105, 43, '76.80', 1), 

(10155, 108, 44, '70.33', 3), 

(10155, 109, 34, '49.16', 8), 

(10156, 93, 20, '43.64', 1), 

(10156, 98, 48, '77.64', 2), 

(10157, 31, 33, '69.27', 3), 

(10157, 60, 40, '89.72', 5), 

(10157, 83, 33, '66.65', 4), 

(10157, 86, 34, '83.91', 1), 

(10157, 91, 28, '56.41', 6), 

(10157, 104, 48, '109.16', 2), 

(10158, 62, 22, '67.79', 1), 

(10159, 1, 49, '81.35', 14), 

(10159, 3, 37, '101.10', 17), 

(10159, 4, 22, '170.42', 16), 

(10159, 7, 41, '188.73', 2), 

(10159, 10, 38, '131.04', 13), 

(10159, 14, 24, '67.03', 3), 

(10159, 32, 42, '51.48', 18), 

(10159, 43, 21, '66.74', 5), 

(10159, 45, 25, '129.35', 4), 

(10159, 47, 21, '54.71', 8), 

(10159, 54, 32, '142.85', 7), 

(10159, 58, 44, '100.30', 15), 

(10159, 66, 27, '67.18', 11), 

(10159, 74, 50, '49.60', 1), 

(10159, 84, 23, '80.84', 6), 

(10159, 87, 35, '39.43', 9), 

(10159, 92, 23, '86.74', 12), 

(10159, 96, 31, '78.11', 10), 

(10160, 12, 46, '96.30', 6), 

(10160, 16, 50, '93.28', 5), 

(10160, 24, 38, '70.84', 4), 

(10160, 40, 20, '140.55', 1), 

(10160, 71, 42, '30.59', 2), 

(10160, 78, 35, '130.60', 3), 

(10161, 18, 28, '121.72', 12), 

(10161, 21, 43, '102.04', 8), 

(10161, 25, 48, '139.41', 11), 

(10161, 34, 23, '125.40', 9), 

(10161, 46, 36, '132.80', 10), 

(10161, 55, 25, '62.72', 1), 

(10161, 56, 37, '73.49', 5), 

(10161, 59, 23, '47.29', 7), 

(10161, 67, 20, '82.69', 3), 

(10161, 70, 25, '108.04', 2), 

(10161, 73, 20, '72.77', 4), 

(10161, 76, 30, '94.23', 6), 

(10162, 19, 48, '87.33', 2), 

(10162, 20, 45, '45.28', 1), 

(10162, 23, 29, '141.10', 9), 

(10162, 27, 27, '53.28', 8), 

(10162, 29, 38, '113.15', 6), 

(10162, 33, 48, '156.94', 3), 

(10162, 50, 39, '86.51', 10), 

(10162, 61, 37, '27.55', 5), 

(10162, 64, 43, '38.98', 4), 

(10162, 80, 37, '32.82', 7), 

(10163, 2, 21, '212.16', 1), 

(10163, 35, 31, '101.31', 2), 

(10163, 36, 48, '59.96', 4), 

(10163, 38, 40, '101.58', 3), 

(10163, 44, 43, '80.36', 6), 

(10163, 82, 42, '96.42', 5), 

(10164, 6, 21, '143.31', 2), 

(10164, 9, 49, '121.64', 6), 

(10164, 17, 36, '103.84', 8), 

(10164, 52, 45, '107.76', 3), 

(10164, 53, 25, '46.29', 7), 

(10164, 85, 24, '91.49', 1), 

(10164, 90, 49, '57.53', 5), 

(10164, 103, 39, '86.99', 4), 

(10165, 8, 44, '168.32', 3), 

(10165, 11, 34, '123.89', 4), 

(10165, 13, 27, '152.26', 2), 

(10165, 15, 48, '109.02', 12), 

(10165, 26, 29, '134.26', 11), 

(10165, 28, 46, '120.28', 15), 

(10165, 30, 31, '60.77', 18), 

(10165, 40, 47, '154.10', 16), 

(10165, 42, 50, '84.71', 1), 

(10165, 49, 28, '123.51', 6), 

(10165, 57, 25, '46.82', 9), 

(10165, 65, 32, '117.57', 17), 

(10165, 68, 27, '31.12', 13), 

(10165, 81, 24, '106.45', 8), 

(10165, 88, 48, '50.86', 14), 

(10165, 89, 44, '55.30', 7), 

(10165, 94, 48, '106.49', 10), 

(10165, 95, 38, '49.21', 5), 

(10166, 39, 43, '136.59', 2), 

(10166, 51, 26, '72.85', 1), 

(10166, 99, 29, '76.22', 3), 

(10167, 5, 44, '123.76', 9), 

(10167, 22, 43, '141.92', 1), 

(10167, 37, 46, '69.68', 7), 

(10167, 48, 34, '84.70', 6), 

(10167, 63, 33, '110.60', 16), 

(10167, 69, 21, '54.81', 2), 

(10167, 72, 20, '77.00', 11), 

(10167, 75, 32, '64.44', 3), 

(10167, 77, 29, '73.80', 8), 

(10167, 97, 43, '66.00', 12), 

(10167, 100, 29, '87.80', 5), 

(10167, 102, 46, '62.16', 10), 

(10167, 106, 24, '85.14', 13), 

(10167, 107, 28, '83.42', 14), 

(10167, 109, 40, '42.71', 4), 

(10167, 110, 38, '43.68', 15), 

(10168, 1, 36, '94.74', 1), 

(10168, 3, 27, '97.53', 4), 

(10168, 4, 20, '160.74', 3), 

(10168, 31, 21, '75.19', 9), 

(10168, 32, 46, '49.06', 5), 

(10168, 58, 50, '103.68', 2), 

(10168, 60, 49, '93.01', 11), 

(10168, 62, 29, '72.36', 6), 

(10168, 79, 27, '57.32', 18), 

(10168, 83, 48, '68.10', 10), 

(10168, 86, 28, '89.90', 7), 

(10168, 91, 31, '57.78', 12), 

(10168, 93, 48, '39.71', 13), 

(10168, 98, 28, '91.34', 14), 

(10168, 101, 31, '87.75', 16), 

(10168, 104, 36, '94.92', 8), 

(10168, 105, 48, '72.00', 15), 

(10168, 108, 39, '67.37', 17), 

(10169, 7, 30, '163.44', 2), 

(10169, 10, 35, '126.52', 13), 

(10169, 14, 36, '71.82', 3), 

(10169, 43, 32, '65.13', 5), 

(10169, 45, 36, '136.70', 4), 

(10169, 47, 38, '52.84', 8), 

(10169, 54, 33, '120.53', 7), 

(10169, 66, 38, '66.49', 11), 

(10169, 74, 34, '53.27', 1), 

(10169, 84, 24, '77.61', 6), 

(10169, 87, 26, '37.01', 9), 

(10169, 92, 34, '83.68', 12), 

(10169, 96, 48, '75.66', 10), 

(10170, 12, 47, '116.27', 4), 

(10170, 16, 41, '93.28', 3), 

(10170, 24, 20, '70.07', 2), 

(10170, 78, 34, '130.60', 1), 

(10171, 18, 35, '134.46', 2), 

(10171, 25, 35, '128.03', 1), 

(10171, 40, 39, '165.95', 3), 

(10171, 71, 36, '34.74', 4), 

(10172, 21, 42, '109.51', 6), 

(10172, 34, 39, '117.48', 7), 

(10172, 46, 48, '139.87', 8), 

(10172, 56, 32, '61.00', 3), 

(10172, 59, 34, '43.27', 5), 

(10172, 67, 22, '79.97', 1), 

(10172, 73, 24, '77.91', 2), 

(10172, 76, 22, '87.81', 4), 

(10173, 19, 43, '101.71', 6), 

(10173, 20, 48, '51.75', 5), 

(10173, 23, 24, '168.30', 13), 

(10173, 27, 26, '55.09', 12), 

(10173, 29, 31, '127.13', 10), 

(10173, 33, 22, '140.06', 7), 

(10173, 36, 28, '56.84', 2), 

(10173, 38, 31, '86.92', 1), 

(10173, 44, 29, '90.28', 4), 

(10173, 50, 21, '77.31', 14), 

(10173, 55, 39, '58.44', 15), 

(10173, 61, 31, '29.87', 9), 

(10173, 64, 27, '39.42', 8), 

(10173, 70, 23, '98.65', 16), 

(10173, 80, 35, '35.70', 11), 

(10173, 82, 22, '93.49', 3), 

(10174, 2, 34, '207.87', 4), 

(10174, 9, 43, '113.44', 1), 

(10174, 17, 48, '108.50', 3), 

(10174, 35, 46, '100.30', 5), 

(10174, 53, 49, '44.27', 2), 

(10175, 6, 33, '119.67', 9), 

(10175, 15, 26, '109.02', 1), 

(10175, 28, 48, '101.87', 4), 

(10175, 30, 41, '59.55', 7), 

(10175, 40, 29, '150.71', 5), 

(10175, 52, 47, '102.92', 10), 

(10175, 65, 28, '121.40', 6), 

(10175, 68, 37, '32.18', 2), 

(10175, 85, 22, '89.57', 8), 

(10175, 88, 50, '50.86', 3), 

(10175, 90, 29, '56.24', 12), 

(10175, 103, 42, '80.92', 11), 

(10176, 8, 33, '166.24', 2), 

(10176, 11, 47, '145.04', 3), 

(10176, 13, 50, '160.91', 1), 

(10176, 26, 20, '139.17', 10), 

(10176, 49, 36, '140.75', 5), 

(10176, 57, 27, '55.49', 8), 

(10176, 81, 29, '101.72', 7), 

(10176, 89, 22, '62.14', 6), 

(10176, 94, 23, '109.96', 9), 

(10176, 95, 38, '52.14', 4), 

(10177, 39, 23, '113.37', 9), 

(10177, 42, 29, '92.77', 11), 

(10177, 51, 35, '82.50', 8), 

(10177, 63, 50, '115.52', 7), 

(10177, 72, 45, '79.66', 2), 

(10177, 97, 24, '58.67', 3), 

(10177, 99, 31, '77.95', 10), 

(10177, 102, 32, '64.33', 1), 

(10177, 106, 44, '88.15', 4), 

(10177, 107, 24, '83.42', 5), 

(10177, 110, 40, '52.96', 6), 

(10178, 5, 24, '131.92', 12), 

(10178, 22, 42, '127.73', 4), 

(10178, 37, 41, '70.54', 10), 

(10178, 48, 48, '104.81', 9), 

(10178, 69, 34, '67.82', 5), 

(10178, 75, 27, '65.75', 6), 

(10178, 77, 21, '68.77', 11), 

(10178, 79, 30, '64.15', 3), 

(10178, 100, 34, '86.90', 8), 

(10178, 101, 22, '91.74', 1), 

(10178, 108, 45, '68.11', 2), 

(10178, 109, 45, '41.71', 7), 

(10179, 31, 24, '82.79', 3), 

(10179, 60, 47, '105.04', 5), 

(10179, 83, 27, '66.65', 4), 

(10179, 86, 45, '86.90', 1), 

(10179, 91, 24, '63.97', 6), 

(10179, 93, 34, '43.20', 7), 

(10179, 98, 23, '75.81', 8), 

(10179, 104, 25, '98.48', 2), 

(10179, 105, 39, '80.00', 9), 

(10180, 1, 29, '76.56', 9), 

(10180, 3, 42, '99.91', 12), 

(10180, 4, 41, '164.61', 11), 

(10180, 10, 40, '131.04', 8), 

(10180, 32, 25, '48.46', 13), 

(10180, 47, 21, '59.06', 3), 

(10180, 54, 44, '147.31', 2), 

(10180, 58, 48, '98.05', 10), 

(10180, 62, 28, '61.70', 14), 

(10180, 66, 35, '60.95', 6), 

(10180, 84, 28, '68.71', 1), 

(10180, 87, 34, '33.39', 4), 

(10180, 92, 22, '102.05', 7), 

(10180, 96, 21, '74.85', 5), 

(10181, 7, 27, '155.66', 14), 

(10181, 12, 28, '113.92', 12), 

(10181, 14, 20, '67.03', 15), 

(10181, 16, 36, '107.10', 11), 

(10181, 18, 44, '124.56', 6), 

(10181, 21, 42, '124.44', 2), 

(10181, 24, 22, '74.69', 10), 

(10181, 25, 21, '129.45', 5), 

(10181, 34, 27, '130.68', 3), 

(10181, 40, 45, '147.33', 7), 

(10181, 43, 30, '73.17', 17), 

(10181, 45, 22, '120.53', 16), 

(10181, 46, 39, '137.04', 4), 

(10181, 59, 34, '45.28', 1), 

(10181, 71, 37, '32.85', 8), 

(10181, 74, 23, '54.49', 13), 

(10181, 78, 25, '122.17', 9), 

(10182, 19, 25, '83.22', 3), 

(10182, 20, 32, '44.21', 2), 

(10182, 23, 44, '159.80', 10), 

(10182, 27, 38, '54.49', 9), 

(10182, 29, 20, '105.52', 7), 

(10182, 33, 21, '135.00', 4), 

(10182, 44, 33, '86.31', 1), 

(10182, 50, 36, '88.35', 11), 

(10182, 55, 44, '61.29', 12), 

(10182, 56, 47, '63.20', 16), 

(10182, 61, 39, '31.86', 6), 

(10182, 64, 31, '39.87', 5), 

(10182, 67, 36, '87.24', 14), 

(10182, 70, 20, '116.27', 13), 

(10182, 73, 33, '73.62', 15), 

(10182, 76, 49, '95.30', 17), 

(10182, 80, 23, '34.88', 8), 

(10183, 2, 23, '180.01', 8), 

(10183, 6, 28, '127.06', 1), 

(10183, 9, 41, '114.80', 5), 

(10183, 17, 21, '108.50', 7), 

(10183, 35, 37, '91.18', 9), 

(10183, 36, 39, '51.22', 11), 

(10183, 38, 22, '90.06', 10), 

(10183, 52, 21, '118.66', 2), 

(10183, 53, 40, '42.26', 6), 

(10183, 82, 47, '81.81', 12), 

(10183, 90, 49, '52.36', 4), 

(10183, 103, 23, '85.98', 3), 

(10184, 15, 37, '105.47', 6), 

(10184, 26, 46, '145.72', 5), 

(10184, 28, 46, '119.05', 9), 

(10184, 30, 44, '60.77', 12), 

(10184, 40, 28, '165.95', 10), 

(10184, 57, 31, '57.22', 3), 

(10184, 65, 24, '117.57', 11), 

(10184, 68, 42, '30.06', 7), 

(10184, 81, 49, '114.73', 2), 

(10184, 85, 46, '84.75', 13), 

(10184, 88, 33, '52.49', 8), 

(10184, 89, 48, '59.03', 1), 

(10184, 94, 45, '92.60', 4), 

(10185, 8, 21, '195.33', 13), 

(10185, 11, 33, '146.55', 14), 

(10185, 13, 43, '147.07', 12), 

(10185, 39, 28, '124.30', 9), 

(10185, 42, 49, '94.79', 11), 

(10185, 49, 39, '127.82', 16), 

(10185, 51, 47, '87.77', 8), 

(10185, 63, 30, '105.69', 7), 

(10185, 72, 33, '83.20', 2), 

(10185, 95, 20, '46.86', 15), 

(10185, 97, 21, '64.67', 3), 

(10185, 99, 30, '79.68', 10), 

(10185, 102, 39, '61.44', 1), 

(10185, 106, 37, '99.17', 4), 

(10185, 107, 22, '93.35', 5), 

(10185, 110, 28, '47.50', 6), 

(10186, 5, 26, '108.80', 9), 

(10186, 22, 32, '137.19', 1), 

(10186, 37, 32, '73.12', 7), 

(10186, 48, 46, '98.46', 6), 

(10186, 69, 22, '60.29', 2), 

(10186, 75, 21, '59.83', 3), 

(10186, 77, 36, '68.77', 8), 

(10186, 100, 24, '80.56', 5), 

(10186, 109, 28, '42.71', 4), 

(10187, 31, 45, '70.12', 1), 

(10187, 60, 46, '96.29', 3), 

(10187, 79, 43, '55.96', 10), 

(10187, 83, 33, '64.48', 2), 

(10187, 91, 31, '61.22', 4), 

(10187, 93, 41, '39.71', 5), 

(10187, 98, 34, '84.95', 6), 

(10187, 101, 44, '95.73', 8), 

(10187, 105, 34, '72.00', 7), 

(10187, 108, 44, '70.33', 9), 

(10188, 1, 48, '95.70', 1), 

(10188, 3, 38, '111.80', 4), 

(10188, 4, 45, '182.04', 3), 

(10188, 32, 32, '52.09', 5), 

(10188, 58, 25, '95.80', 2), 

(10188, 62, 40, '61.70', 6), 

(10188, 86, 44, '81.91', 7), 

(10188, 104, 29, '96.11', 8), 

(10189, 10, 28, '138.57', 1), 

(10190, 66, 42, '58.87', 3), 

(10190, 87, 46, '38.62', 1), 

(10190, 92, 42, '89.80', 4), 

(10190, 96, 40, '67.53', 2), 

(10191, 7, 21, '155.66', 3), 

(10191, 12, 40, '104.52', 1), 

(10191, 14, 30, '70.22', 4), 

(10191, 43, 36, '75.59', 6), 

(10191, 45, 23, '119.06', 5), 

(10191, 47, 43, '60.93', 9), 

(10191, 54, 32, '136.90', 8), 

(10191, 74, 48, '53.27', 2), 

(10191, 84, 44, '77.61', 7), 

(10192, 16, 27, '99.04', 16), 

(10192, 18, 22, '140.12', 11), 

(10192, 21, 29, '100.80', 7), 

(10192, 24, 45, '70.84', 15), 

(10192, 25, 47, '128.03', 10), 

(10192, 34, 38, '110.88', 8), 

(10192, 40, 26, '137.17', 12), 

(10192, 46, 45, '125.74', 9), 

(10192, 56, 37, '72.02', 4), 

(10192, 59, 47, '49.30', 6), 

(10192, 67, 46, '86.33', 2), 

(10192, 70, 23, '112.74', 1), 

(10192, 71, 30, '33.23', 13), 

(10192, 73, 32, '69.34', 3), 

(10192, 76, 46, '93.16', 5), 

(10192, 78, 45, '112.34', 14), 

(10193, 19, 28, '92.47', 7), 

(10193, 20, 46, '46.36', 6), 

(10193, 23, 21, '153.00', 14), 

(10193, 27, 42, '60.54', 13), 

(10193, 29, 44, '115.69', 11), 

(10193, 33, 22, '143.44', 8), 

(10193, 35, 28, '87.13', 1), 

(10193, 36, 24, '53.09', 3), 

(10193, 38, 23, '97.39', 2), 

(10193, 44, 32, '79.37', 5), 

(10193, 50, 24, '92.03', 15), 

(10193, 55, 25, '66.28', 16), 

(10193, 61, 26, '32.19', 10), 

(10193, 64, 20, '44.80', 9), 

(10193, 80, 22, '38.16', 12), 

(10193, 82, 20, '92.52', 4), 

(10194, 2, 42, '203.59', 11), 

(10194, 6, 26, '134.44', 4), 

(10194, 9, 38, '124.37', 8), 

(10194, 17, 21, '103.84', 10), 

(10194, 30, 45, '51.05', 2), 

(10194, 52, 32, '113.82', 5), 

(10194, 53, 41, '47.79', 9), 

(10194, 65, 49, '112.46', 1), 

(10194, 85, 37, '77.05', 3), 

(10194, 90, 39, '61.41', 7), 

(10194, 103, 26, '80.92', 6), 

(10195, 15, 49, '118.50', 6), 

(10195, 26, 27, '139.17', 5), 

(10195, 28, 35, '112.91', 9), 

(10195, 40, 50, '150.71', 10), 

(10195, 57, 44, '54.33', 3), 

(10195, 68, 32, '31.82', 7), 

(10195, 81, 34, '95.81', 2), 

(10195, 88, 32, '51.95', 8), 

(10195, 89, 33, '59.03', 1), 

(10195, 94, 49, '97.23', 4), 

(10196, 8, 47, '203.64', 5), 

(10196, 11, 24, '151.08', 6), 

(10196, 13, 38, '147.07', 4), 

(10196, 39, 49, '127.03', 1), 

(10196, 42, 35, '81.68', 3), 

(10196, 49, 27, '126.39', 8), 

(10196, 95, 46, '56.82', 7), 

(10196, 99, 50, '84.88', 2), 

(10197, 5, 45, '118.32', 6), 

(10197, 37, 46, '83.44', 4), 

(10197, 48, 22, '85.75', 3), 

(10197, 51, 50, '78.99', 14), 

(10197, 63, 41, '109.37', 13), 

(10197, 72, 47, '83.20', 8), 

(10197, 77, 22, '67.93', 5), 

(10197, 97, 23, '60.00', 9), 

(10197, 100, 24, '78.75', 2), 

(10197, 102, 50, '66.50', 7), 

(10197, 106, 27, '100.17', 10), 

(10197, 107, 35, '88.39', 11), 

(10197, 109, 29, '39.73', 1), 

(10197, 110, 42, '48.59', 12), 

(10198, 22, 42, '149.81', 4), 

(10198, 69, 48, '60.97', 5), 

(10198, 75, 27, '61.81', 6), 

(10198, 79, 43, '65.51', 3), 

(10198, 101, 42, '94.73', 1), 

(10198, 108, 40, '74.03', 2), 

(10199, 93, 29, '37.97', 1), 

(10199, 98, 48, '81.29', 2), 

(10199, 105, 38, '70.40', 3), 

(10200, 31, 28, '74.34', 3), 

(10200, 60, 33, '99.57', 5), 

(10200, 83, 39, '70.28', 4), 

(10200, 86, 35, '80.91', 1), 

(10200, 91, 27, '65.35', 6), 

(10200, 104, 39, '115.09', 2), 

(10201, 1, 22, '82.30', 2), 

(10201, 3, 24, '116.56', 5), 

(10201, 4, 49, '191.72', 4), 

(10201, 10, 25, '126.52', 1), 

(10201, 32, 30, '48.46', 6), 

(10201, 58, 39, '93.54', 3), 

(10201, 62, 25, '66.27', 7), 

(10202, 47, 30, '55.33', 3), 

(10202, 54, 43, '124.99', 2), 

(10202, 66, 50, '56.10', 6), 

(10202, 84, 50, '75.18', 1), 

(10202, 87, 27, '33.39', 4), 

(10202, 92, 31, '81.64', 7), 

(10202, 96, 40, '79.73', 5), 

(10203, 7, 20, '161.49', 8), 

(10203, 12, 20, '111.57', 6), 

(10203, 14, 44, '63.84', 9), 

(10203, 16, 47, '115.16', 5), 

(10203, 24, 45, '73.15', 4), 

(10203, 40, 48, '157.49', 1), 

(10203, 43, 33, '66.74', 11), 

(10203, 45, 32, '127.88', 10), 

(10203, 71, 21, '33.23', 2), 

(10203, 74, 34, '56.94', 7), 

(10203, 78, 47, '140.43', 3), 

(10204, 18, 42, '114.65', 17), 

(10204, 21, 40, '113.24', 13), 

(10204, 23, 33, '153.00', 4), 

(10204, 25, 38, '133.72', 16), 

(10204, 27, 23, '59.33', 3), 

(10204, 29, 26, '119.50', 1), 

(10204, 34, 27, '106.92', 14), 

(10204, 46, 35, '132.80', 15), 

(10204, 50, 29, '83.75', 5), 

(10204, 55, 45, '69.84', 6), 

(10204, 56, 20, '69.82', 10), 

(10204, 59, 45, '46.79', 12), 

(10204, 67, 47, '79.06', 8), 

(10204, 70, 42, '112.74', 7), 

(10204, 73, 40, '84.75', 9), 

(10204, 76, 48, '104.94', 11), 

(10204, 80, 39, '34.88', 2), 

(10205, 19, 36, '98.63', 2), 

(10205, 20, 48, '45.82', 1), 

(10205, 33, 40, '138.38', 3), 

(10205, 61, 32, '27.88', 5), 

(10205, 64, 24, '36.74', 4), 

(10206, 2, 47, '203.59', 6), 

(10206, 9, 28, '109.34', 3), 

(10206, 17, 34, '115.50', 5), 

(10206, 35, 37, '98.27', 7), 

(10206, 36, 28, '51.84', 9), 

(10206, 38, 30, '102.63', 8), 

(10206, 44, 28, '99.21', 11), 

(10206, 53, 21, '45.78', 4), 

(10206, 82, 33, '95.44', 10), 

(10206, 90, 36, '54.94', 2), 

(10206, 103, 33, '89.01', 1), 

(10207, 6, 31, '125.58', 15), 

(10207, 15, 34, '95.99', 7), 

(10207, 26, 44, '140.81', 6), 

(10207, 28, 43, '109.23', 10), 

(10207, 30, 37, '60.77', 13), 

(10207, 40, 25, '140.55', 11), 

(10207, 49, 40, '143.62', 1), 

(10207, 52, 47, '119.87', 16), 

(10207, 57, 49, '57.80', 4), 

(10207, 65, 46, '127.79', 12), 

(10207, 68, 42, '30.76', 8), 

(10207, 81, 28, '108.82', 3), 

(10207, 85, 49, '84.75', 14), 

(10207, 88, 27, '51.95', 9), 

(10207, 89, 45, '55.30', 2), 

(10207, 94, 28, '106.49', 5), 

(10208, 8, 46, '176.63', 13), 

(10208, 11, 26, '128.42', 14), 

(10208, 13, 20, '152.26', 12), 

(10208, 39, 24, '117.47', 9), 

(10208, 42, 48, '96.81', 11), 

(10208, 51, 45, '72.85', 8), 

(10208, 63, 35, '122.89', 7), 

(10208, 72, 20, '80.54', 2), 

(10208, 95, 30, '57.99', 15), 

(10208, 97, 38, '56.67', 3), 

(10208, 99, 40, '73.62', 10), 

(10208, 102, 46, '63.61', 1), 

(10208, 106, 37, '95.16', 4), 

(10208, 107, 33, '95.34', 5), 

(10208, 110, 42, '48.05', 6), 

(10209, 5, 39, '129.20', 8), 

(10209, 37, 28, '82.58', 6), 

(10209, 48, 20, '97.40', 5), 

(10209, 69, 43, '66.45', 1), 

(10209, 75, 36, '56.55', 2), 

(10209, 77, 22, '79.67', 7), 

(10209, 100, 33, '90.52', 4), 

(10209, 109, 48, '44.20', 3), 

(10210, 3, 23, '112.99', 2), 

(10210, 4, 34, '189.79', 1), 

(10210, 22, 31, '141.92', 17), 

(10210, 31, 50, '68.43', 7), 

(10210, 32, 40, '51.48', 3), 

(10210, 60, 27, '100.67', 9), 

(10210, 62, 30, '63.22', 4), 

(10210, 79, 29, '56.64', 16), 

(10210, 83, 40, '68.10', 8), 

(10210, 86, 46, '84.91', 5), 

(10210, 91, 39, '57.10', 10), 

(10210, 93, 43, '43.20', 11), 

(10210, 98, 21, '87.69', 12), 

(10210, 101, 26, '93.74', 14), 

(10210, 104, 25, '98.48', 6), 

(10210, 105, 31, '64.00', 13), 

(10210, 108, 42, '60.70', 15), 

(10211, 1, 41, '90.92', 14), 

(10211, 7, 41, '171.22', 2), 

(10211, 10, 36, '126.52', 13), 

(10211, 14, 28, '79.80', 3), 

(10211, 43, 35, '73.17', 5), 

(10211, 45, 28, '138.17', 4), 

(10211, 47, 46, '60.30', 8), 

(10211, 54, 41, '148.80', 7), 

(10211, 58, 25, '109.32', 15), 

(10211, 66, 21, '62.33', 11), 

(10211, 74, 48, '52.66', 1), 

(10211, 84, 22, '80.84', 6), 

(10211, 87, 41, '39.83', 9), 

(10211, 92, 37, '94.91', 12), 

(10211, 96, 40, '70.78', 10), 

(10212, 12, 39, '99.82', 16), 

(10212, 16, 33, '110.55', 15), 

(10212, 18, 29, '117.48', 10), 

(10212, 21, 38, '105.77', 6), 

(10212, 24, 20, '64.68', 14), 

(10212, 25, 41, '133.72', 9), 

(10212, 34, 40, '117.48', 7), 

(10212, 40, 40, '155.79', 11), 

(10212, 46, 45, '115.85', 8), 

(10212, 56, 41, '61.73', 3), 

(10212, 59, 45, '43.27', 5), 

(10212, 67, 45, '81.78', 1), 

(10212, 71, 34, '37.38', 12), 

(10212, 73, 27, '77.91', 2), 

(10212, 76, 46, '100.66', 4), 

(10212, 78, 49, '117.96', 13), 

(10213, 50, 38, '84.67', 1), 

(10213, 55, 25, '58.44', 2), 

(10213, 70, 27, '97.48', 3), 

(10214, 23, 30, '166.60', 7), 

(10214, 27, 21, '53.28', 6), 

(10214, 29, 27, '125.86', 4), 

(10214, 33, 50, '167.06', 1), 

(10214, 61, 20, '32.19', 3), 

(10214, 64, 49, '39.87', 2), 

(10214, 80, 44, '38.57', 5), 

(10215, 2, 35, '205.73', 3), 

(10215, 17, 46, '100.34', 2), 

(10215, 19, 27, '92.47', 10), 

(10215, 20, 33, '53.91', 9), 

(10215, 35, 49, '97.26', 4), 

(10215, 36, 31, '56.21', 6), 

(10215, 38, 49, '89.01', 5), 

(10215, 44, 41, '84.33', 8), 

(10215, 53, 46, '42.76', 1), 

(10215, 82, 39, '94.47', 7), 

(10216, 9, 43, '133.94', 1), 

(10217, 6, 48, '132.97', 4), 

(10217, 30, 35, '58.34', 2), 

(10217, 52, 38, '118.66', 5), 

(10217, 65, 28, '103.51', 1), 

(10217, 85, 21, '78.97', 3), 

(10217, 90, 39, '56.24', 7), 

(10217, 103, 31, '90.02', 6), 

(10218, 28, 22, '110.46', 1), 

(10218, 40, 34, '152.41', 2), 

(10219, 15, 48, '94.80', 2), 

(10219, 26, 43, '132.62', 1), 

(10219, 68, 21, '31.12', 3), 

(10219, 88, 35, '47.62', 4), 

(10220, 8, 32, '189.10', 2), 

(10220, 11, 30, '151.08', 3), 

(10220, 13, 27, '166.10', 1), 

(10220, 49, 50, '126.39', 5), 

(10220, 57, 26, '48.55', 8), 

(10220, 81, 37, '101.72', 7), 

(10220, 89, 20, '49.71', 6), 

(10220, 94, 37, '92.60', 9), 

(10220, 95, 30, '56.82', 4), 

(10221, 39, 33, '133.86', 3), 

(10221, 42, 23, '89.75', 5), 

(10221, 51, 39, '84.26', 2), 

(10221, 63, 49, '113.06', 1), 

(10221, 99, 23, '69.29', 4), 

(10222, 5, 49, '133.28', 12), 

(10222, 22, 49, '137.19', 4), 

(10222, 37, 49, '79.14', 10), 

(10222, 48, 45, '88.93', 9), 

(10222, 69, 32, '56.86', 5), 

(10222, 72, 47, '74.35', 14), 

(10222, 75, 43, '61.15', 6), 

(10222, 77, 46, '77.99', 11), 

(10222, 79, 48, '55.27', 3), 

(10222, 97, 31, '58.67', 15), 

(10222, 100, 26, '80.56', 8), 

(10222, 101, 37, '90.75', 1), 

(10222, 102, 36, '69.39', 13), 

(10222, 106, 38, '84.14', 16), 

(10222, 107, 31, '81.43', 17), 

(10222, 108, 43, '66.63', 2), 

(10222, 109, 31, '45.19', 7), 

(10222, 110, 36, '48.59', 18), 

(10223, 1, 37, '80.39', 1), 

(10223, 3, 47, '110.61', 4), 

(10223, 4, 49, '189.79', 3), 

(10223, 31, 47, '67.58', 9), 

(10223, 32, 28, '58.75', 5), 

(10223, 58, 32, '104.81', 2), 

(10223, 60, 34, '87.54', 11), 

(10223, 62, 38, '60.94', 6), 

(10223, 83, 23, '68.10', 10), 

(10223, 86, 21, '90.90', 7), 

(10223, 91, 20, '66.73', 12), 

(10223, 93, 41, '41.02', 13), 

(10223, 98, 25, '84.03', 14), 

(10223, 104, 29, '113.90', 8), 

(10223, 105, 26, '79.20', 15), 

(10224, 10, 43, '141.58', 6), 

(10224, 47, 38, '57.20', 1), 

(10224, 66, 37, '60.26', 4), 

(10224, 87, 43, '37.01', 2), 

(10224, 92, 30, '94.91', 5), 

(10224, 96, 50, '81.36', 3), 

(10225, 7, 27, '157.60', 9), 

(10225, 12, 25, '101.00', 7), 

(10225, 14, 37, '64.64', 10), 

(10225, 16, 21, '100.19', 6), 

(10225, 18, 32, '116.06', 1), 

(10225, 24, 47, '71.61', 5), 

(10225, 40, 43, '162.57', 2), 

(10225, 43, 37, '69.96', 12), 

(10225, 45, 27, '119.06', 11), 

(10225, 54, 35, '135.41', 14), 

(10225, 71, 42, '34.74', 3), 

(10225, 74, 24, '51.43', 8), 

(10225, 78, 40, '130.60', 4), 

(10225, 84, 46, '77.61', 13), 

(10226, 21, 38, '108.26', 4), 

(10226, 25, 24, '129.45', 7), 

(10226, 34, 24, '125.40', 5), 

(10226, 46, 46, '122.91', 6), 

(10226, 56, 21, '65.41', 1), 

(10226, 59, 36, '47.79', 3), 

(10226, 76, 48, '95.30', 2), 

(10227, 19, 25, '85.27', 3), 

(10227, 20, 31, '50.14', 2), 

(10227, 23, 26, '136.00', 10), 

(10227, 27, 28, '59.93', 9), 

(10227, 29, 46, '118.23', 7), 

(10227, 33, 29, '146.81', 4), 

(10227, 44, 33, '99.21', 1), 

(10227, 50, 34, '87.43', 11), 

(10227, 55, 37, '70.56', 12), 

(10227, 61, 42, '27.22', 6), 

(10227, 64, 24, '39.42', 5), 

(10227, 67, 47, '84.51', 14), 

(10227, 70, 33, '102.17', 13), 

(10227, 73, 40, '78.76', 15), 

(10227, 80, 27, '34.88', 8), 

(10228, 2, 29, '214.30', 2), 

(10228, 17, 32, '100.34', 1), 

(10228, 35, 24, '101.31', 3), 

(10228, 36, 45, '57.46', 5), 

(10228, 38, 31, '100.53', 4), 

(10228, 82, 33, '84.73', 6), 

(10229, 6, 50, '138.88', 9), 

(10229, 9, 25, '110.70', 13), 

(10229, 15, 36, '95.99', 1), 

(10229, 28, 26, '104.32', 4), 

(10229, 30, 28, '53.48', 7), 

(10229, 40, 22, '157.49', 5), 

(10229, 52, 41, '119.87', 10), 

(10229, 53, 39, '43.77', 14), 

(10229, 65, 48, '115.01', 6), 

(10229, 68, 33, '34.65', 2), 

(10229, 85, 25, '78.97', 8), 

(10229, 88, 23, '49.78', 3), 

(10229, 90, 30, '52.36', 12), 

(10229, 103, 50, '91.04', 11), 

(10230, 11, 43, '128.42', 1), 

(10230, 26, 49, '153.91', 8), 

(10230, 49, 42, '142.18', 3), 

(10230, 57, 36, '47.40', 6), 

(10230, 81, 45, '99.36', 5), 

(10230, 89, 46, '59.03', 4), 

(10230, 94, 34, '100.70', 7), 

(10230, 95, 43, '57.41', 2), 

(10231, 8, 42, '193.25', 2), 

(10231, 13, 49, '147.07', 1), 

(10232, 39, 22, '133.86', 6), 

(10232, 42, 48, '97.81', 8), 

(10232, 51, 23, '78.12', 5), 

(10232, 63, 46, '113.06', 4), 

(10232, 99, 26, '84.88', 7), 

(10232, 106, 48, '86.15', 1), 

(10232, 107, 35, '81.43', 2), 

(10232, 110, 24, '48.59', 3), 

(10233, 72, 40, '70.81', 2), 

(10233, 97, 36, '66.00', 3), 

(10233, 102, 29, '67.94', 1), 

(10234, 5, 48, '118.32', 9), 

(10234, 22, 50, '146.65', 1), 

(10234, 37, 48, '84.30', 7), 

(10234, 48, 39, '85.75', 6), 

(10234, 69, 44, '67.14', 2), 

(10234, 75, 25, '65.09', 3), 

(10234, 77, 31, '78.83', 8), 

(10234, 100, 29, '83.28', 5), 

(10234, 109, 40, '45.69', 4), 

(10235, 31, 24, '81.95', 3), 

(10235, 60, 23, '89.72', 5), 

(10235, 79, 33, '55.27', 12), 

(10235, 83, 40, '63.03', 4), 

(10235, 86, 41, '90.90', 1), 

(10235, 91, 34, '66.73', 6), 

(10235, 93, 41, '37.09', 7), 

(10235, 98, 25, '88.60', 8), 

(10235, 101, 38, '92.74', 10), 

(10235, 104, 25, '116.28', 2), 

(10235, 105, 32, '73.60', 9), 

(10235, 108, 34, '70.33', 11), 

(10236, 3, 22, '105.86', 1), 

(10236, 32, 23, '52.70', 2), 

(10236, 62, 36, '65.51', 3), 

(10237, 1, 23, '91.87', 7), 

(10237, 4, 39, '158.80', 9), 

(10237, 10, 32, '129.53', 6), 

(10237, 47, 26, '49.74', 1), 

(10237, 58, 20, '109.32', 8), 

(10237, 66, 26, '62.33', 4), 

(10237, 87, 26, '35.00', 2), 

(10237, 92, 27, '94.91', 5), 

(10237, 96, 20, '78.92', 3), 

(10238, 7, 28, '161.49', 3), 

(10238, 12, 29, '104.52', 1), 

(10238, 14, 20, '73.42', 4), 

(10238, 43, 41, '68.35', 6), 

(10238, 45, 49, '144.05', 5), 

(10238, 54, 44, '120.53', 8), 

(10238, 74, 47, '53.88', 2), 

(10238, 84, 22, '67.91', 7), 

(10239, 16, 21, '100.19', 5), 

(10239, 24, 46, '70.07', 4), 

(10239, 40, 47, '135.47', 1), 

(10239, 71, 20, '32.47', 2), 

(10239, 78, 29, '133.41', 3), 

(10240, 18, 41, '125.97', 3), 

(10240, 25, 37, '136.56', 2), 

(10240, 46, 37, '134.22', 1), 

(10241, 21, 21, '119.46', 11), 

(10241, 23, 41, '153.00', 2), 

(10241, 27, 33, '55.70', 1), 

(10241, 34, 44, '126.72', 12), 

(10241, 50, 42, '77.31', 3), 

(10241, 55, 30, '62.72', 4), 

(10241, 56, 22, '72.02', 8), 

(10241, 59, 21, '47.29', 10), 

(10241, 67, 47, '89.05', 6), 

(10241, 70, 28, '117.44', 5), 

(10241, 73, 26, '69.34', 7), 

(10241, 76, 27, '107.08', 9), 

(10242, 80, 46, '36.52', 1), 

(10243, 29, 47, '111.87', 2), 

(10243, 61, 33, '30.87', 1), 

(10244, 19, 40, '99.66', 7), 

(10244, 20, 20, '48.52', 6), 

(10244, 33, 43, '141.75', 8), 

(10244, 35, 30, '87.13', 1), 

(10244, 36, 24, '54.96', 3), 

(10244, 38, 29, '85.87', 2), 

(10244, 44, 36, '87.30', 5), 

(10244, 64, 39, '42.11', 9), 

(10244, 82, 40, '97.39', 4), 

(10245, 2, 34, '195.01', 9), 

(10245, 6, 28, '147.74', 2), 

(10245, 9, 38, '120.27', 6), 

(10245, 17, 29, '114.34', 8), 

(10245, 52, 21, '111.39', 3), 

(10245, 53, 45, '48.80', 7), 

(10245, 85, 37, '81.86', 1), 

(10245, 90, 44, '54.94', 5), 

(10245, 103, 44, '81.93', 4), 

(10246, 15, 46, '99.54', 5), 

(10246, 26, 40, '144.08', 4), 

(10246, 28, 22, '100.64', 8), 

(10246, 30, 30, '57.73', 11), 

(10246, 40, 36, '145.63', 9), 

(10246, 57, 44, '46.24', 2), 

(10246, 65, 29, '118.84', 10), 

(10246, 68, 49, '34.65', 6), 

(10246, 81, 46, '100.54', 1), 

(10246, 88, 35, '45.45', 7), 

(10246, 94, 22, '113.44', 3), 

(10247, 8, 44, '195.33', 2), 

(10247, 11, 25, '140.50', 3), 

(10247, 13, 27, '167.83', 1), 

(10247, 49, 48, '143.62', 5), 

(10247, 89, 40, '58.41', 6), 

(10247, 95, 49, '51.55', 4), 

(10248, 5, 20, '126.48', 3), 

(10248, 37, 21, '80.86', 1), 

(10248, 39, 32, '133.86', 12), 

(10248, 42, 42, '95.80', 14), 

(10248, 51, 42, '87.77', 11), 

(10248, 63, 48, '122.89', 10), 

(10248, 72, 30, '85.85', 5), 

(10248, 77, 23, '83.02', 2), 

(10248, 97, 36, '66.00', 6), 

(10248, 99, 40, '81.41', 13), 

(10248, 102, 32, '69.39', 4), 

(10248, 106, 30, '84.14', 7), 

(10248, 107, 35, '92.36', 8), 

(10248, 110, 23, '53.51', 9), 

(10249, 48, 46, '88.93', 5), 

(10249, 69, 20, '54.81', 1), 

(10249, 75, 25, '65.75', 2), 

(10249, 100, 40, '85.99', 4), 

(10249, 109, 32, '49.16', 3), 

(10250, 22, 45, '148.23', 14), 

(10250, 31, 27, '84.48', 4), 

(10250, 60, 31, '95.20', 6), 

(10250, 62, 32, '63.22', 1), 

(10250, 79, 40, '61.42', 13), 

(10250, 83, 37, '72.45', 5), 

(10250, 86, 31, '99.89', 2), 

(10250, 91, 50, '62.60', 7), 

(10250, 93, 36, '36.66', 8), 

(10250, 98, 31, '91.34', 9), 

(10250, 101, 35, '90.75', 11), 

(10250, 104, 44, '98.48', 3), 

(10250, 105, 44, '76.00', 10), 

(10250, 108, 38, '65.89', 12), 

(10251, 1, 59, '93.79', 2), 

(10251, 3, 44, '115.37', 5), 

(10251, 4, 43, '172.36', 4), 

(10251, 10, 46, '129.53', 1), 

(10251, 32, 44, '58.15', 6), 

(10251, 58, 50, '91.29', 3), 

(10252, 43, 20, '74.78', 2), 

(10252, 45, 41, '145.52', 1), 

(10252, 47, 31, '50.36', 5), 

(10252, 54, 26, '127.97', 4), 

(10252, 66, 47, '63.03', 8), 

(10252, 84, 38, '69.52', 3), 

(10252, 87, 36, '36.21', 6), 

(10252, 92, 25, '93.89', 9), 

(10252, 96, 48, '72.41', 7), 

(10253, 7, 24, '157.60', 13), 

(10253, 12, 22, '102.17', 11), 

(10253, 14, 25, '67.03', 14), 

(10253, 16, 41, '109.40', 10), 

(10253, 18, 26, '130.22', 5), 

(10253, 21, 24, '103.29', 1), 

(10253, 24, 23, '67.76', 9), 

(10253, 25, 33, '130.87', 4), 

(10253, 34, 37, '114.84', 2), 

(10253, 40, 40, '145.63', 6), 

(10253, 46, 31, '139.87', 3), 

(10253, 71, 40, '34.74', 7), 

(10253, 74, 24, '50.82', 12), 

(10253, 78, 39, '115.15', 8), 

(10254, 23, 49, '137.70', 5), 

(10254, 27, 36, '55.09', 4), 

(10254, 29, 41, '102.98', 2), 

(10254, 50, 34, '80.99', 6), 

(10254, 55, 30, '59.87', 7), 

(10254, 56, 34, '66.88', 11), 

(10254, 59, 32, '43.27', 13), 

(10254, 61, 38, '28.88', 1), 

(10254, 67, 31, '85.42', 9), 

(10254, 70, 33, '111.57', 8), 

(10254, 73, 42, '69.34', 10), 

(10254, 76, 49, '101.73', 12), 

(10254, 80, 20, '39.80', 3), 

(10255, 33, 24, '135.00', 1), 

(10255, 64, 37, '37.63', 2), 

(10256, 19, 34, '93.49', 2), 

(10256, 20, 29, '52.83', 1), 

(10257, 35, 50, '92.19', 1), 

(10257, 36, 49, '59.34', 3), 

(10257, 38, 37, '83.78', 2), 

(10257, 44, 26, '91.27', 5), 

(10257, 82, 46, '81.81', 4), 

(10258, 2, 32, '177.87', 6), 

(10258, 9, 41, '133.94', 3), 

(10258, 17, 41, '113.17', 5), 

(10258, 53, 21, '49.81', 4), 

(10258, 90, 20, '62.70', 2), 

(10258, 103, 45, '86.99', 1), 

(10259, 6, 26, '121.15', 12), 

(10259, 15, 46, '117.32', 4), 

(10259, 26, 30, '134.26', 3), 

(10259, 28, 34, '120.28', 7), 

(10259, 30, 30, '59.55', 10), 

(10259, 40, 27, '152.41', 8), 

(10259, 52, 41, '107.76', 13), 

(10259, 57, 28, '46.82', 1), 

(10259, 65, 47, '121.40', 9), 

(10259, 68, 31, '31.47', 5), 

(10259, 85, 45, '95.35', 11), 

(10259, 88, 40, '45.99', 6), 

(10259, 94, 29, '105.33', 2), 

(10260, 8, 46, '180.79', 5), 

(10260, 11, 30, '140.50', 6), 

(10260, 13, 44, '169.56', 4), 

(10260, 39, 32, '121.57', 1), 

(10260, 42, 29, '92.77', 3), 

(10260, 49, 23, '137.88', 8), 

(10260, 81, 23, '117.10', 10), 

(10260, 89, 27, '55.30', 9), 

(10260, 95, 21, '56.24', 7), 

(10260, 99, 33, '80.55', 2), 

(10261, 5, 27, '116.96', 1), 

(10261, 51, 20, '80.75', 9), 

(10261, 63, 36, '105.69', 8), 

(10261, 72, 22, '79.66', 3), 

(10261, 97, 34, '64.00', 4), 

(10261, 102, 44, '58.55', 2), 

(10261, 106, 25, '89.15', 5), 

(10261, 107, 50, '88.39', 6), 

(10261, 110, 29, '43.68', 7), 

(10262, 22, 49, '157.69', 9), 

(10262, 37, 32, '81.72', 15), 

(10262, 48, 34, '85.75', 14), 

(10262, 60, 34, '98.48', 1), 

(10262, 69, 24, '63.71', 10), 

(10262, 75, 46, '65.75', 11), 

(10262, 77, 49, '82.18', 16), 

(10262, 79, 48, '58.69', 8), 

(10262, 91, 40, '63.97', 2), 

(10262, 93, 49, '35.78', 3), 

(10262, 98, 40, '87.69', 4), 

(10262, 100, 44, '83.28', 13), 

(10262, 101, 33, '81.77', 6), 

(10262, 105, 27, '64.80', 5), 

(10262, 108, 35, '64.41', 7), 

(10262, 109, 21, '41.71', 12), 

(10263, 1, 34, '89.00', 2), 

(10263, 3, 40, '107.05', 5), 

(10263, 4, 41, '193.66', 4), 

(10263, 10, 48, '123.51', 1), 

(10263, 31, 33, '67.58', 10), 

(10263, 32, 34, '50.27', 6), 

(10263, 58, 42, '109.32', 3), 

(10263, 62, 37, '67.03', 7), 

(10263, 83, 24, '59.41', 11), 

(10263, 86, 31, '93.90', 8), 

(10263, 104, 47, '117.46', 9), 

(10264, 47, 48, '58.44', 3), 

(10264, 54, 20, '124.99', 2), 

(10264, 66, 37, '61.64', 6), 

(10264, 84, 47, '75.18', 1), 

(10264, 87, 20, '39.02', 4), 

(10264, 92, 34, '100.01', 7), 

(10264, 96, 47, '67.53', 5), 

(10265, 43, 45, '74.78', 2), 

(10265, 45, 49, '123.47', 1), 

(10266, 7, 44, '188.73', 14), 

(10266, 12, 22, '110.39', 12), 

(10266, 14, 35, '67.83', 15), 

(10266, 16, 40, '112.86', 11), 

(10266, 18, 21, '131.63', 6), 

(10266, 21, 36, '99.55', 2), 

(10266, 24, 33, '77.00', 10), 

(10266, 25, 49, '139.41', 5), 

(10266, 34, 20, '113.52', 3), 

(10266, 40, 29, '137.17', 7), 

(10266, 46, 33, '127.15', 4), 

(10266, 59, 28, '40.25', 1), 

(10266, 71, 34, '35.12', 8), 

(10266, 74, 47, '56.33', 13), 

(10266, 78, 24, '119.37', 9), 

(10267, 55, 36, '71.27', 1), 

(10267, 56, 40, '72.02', 5), 

(10267, 67, 38, '76.33', 3), 

(10267, 70, 43, '93.95', 2), 

(10267, 73, 44, '83.90', 4), 

(10267, 76, 43, '98.51', 6), 

(10268, 19, 49, '93.49', 3), 

(10268, 20, 26, '45.82', 2), 

(10268, 23, 34, '164.90', 10), 

(10268, 27, 31, '60.54', 9), 

(10268, 29, 50, '124.59', 7), 

(10268, 33, 35, '148.50', 4), 

(10268, 44, 39, '96.23', 1), 

(10268, 50, 35, '84.67', 11), 

(10268, 61, 33, '31.86', 6), 

(10268, 64, 40, '36.29', 5), 

(10268, 80, 30, '37.75', 8), 

(10269, 36, 32, '57.46', 1), 

(10269, 82, 48, '95.44', 2), 

(10270, 2, 21, '171.44', 9), 

(10270, 6, 32, '124.10', 2), 

(10270, 9, 28, '135.30', 6), 

(10270, 17, 43, '94.50', 8), 

(10270, 35, 31, '81.05', 10), 

(10270, 38, 38, '85.87', 11), 

(10270, 52, 38, '107.76', 3), 

(10270, 53, 44, '40.25', 7), 

(10270, 85, 32, '93.42', 1), 

(10270, 90, 21, '52.36', 5), 

(10270, 103, 46, '101.15', 4), 

(10271, 15, 31, '99.54', 5), 

(10271, 26, 50, '147.36', 4), 

(10271, 28, 50, '121.50', 8), 

(10271, 30, 25, '59.55', 11), 

(10271, 40, 20, '169.34', 9), 

(10271, 57, 45, '49.71', 2), 

(10271, 65, 43, '122.68', 10), 

(10271, 68, 38, '28.64', 6), 

(10271, 81, 22, '110.00', 1), 

(10271, 88, 35, '51.95', 7), 

(10271, 94, 34, '93.76', 3), 

(10272, 8, 35, '187.02', 2), 

(10272, 11, 27, '123.89', 3), 

(10272, 13, 39, '148.80', 1), 

(10272, 49, 25, '126.39', 5), 

(10272, 89, 45, '56.55', 6), 

(10272, 95, 43, '53.89', 4), 

(10273, 5, 30, '136.00', 4), 

(10273, 37, 34, '84.30', 2), 

(10273, 39, 40, '117.47', 13), 

(10273, 42, 47, '87.73', 15), 

(10273, 48, 50, '105.87', 1), 

(10273, 51, 33, '72.85', 12), 

(10273, 63, 22, '103.23', 11), 

(10273, 72, 27, '84.08', 6), 

(10273, 77, 48, '83.86', 3), 

(10273, 97, 21, '66.00', 7), 

(10273, 99, 21, '77.95', 14), 

(10273, 102, 42, '57.82', 5), 

(10273, 106, 40, '91.15', 8), 

(10273, 107, 26, '89.38', 9), 

(10273, 110, 37, '51.32', 10), 

(10274, 22, 41, '129.31', 1), 

(10274, 69, 40, '56.86', 2), 

(10274, 75, 24, '65.09', 3), 

(10274, 100, 24, '75.13', 5), 

(10274, 109, 32, '49.66', 4), 

(10275, 1, 45, '81.35', 1), 

(10275, 2, 22, '115.37', 4), 

(10275, 40, 36, '154.93', 3), 

(10275, 31, 35, '70.12', 9), 

(10275, 32, 37, '52.09', 5), 

(10275, 58, 21, '105.94', 2), 

(10275, 60, 25, '97.38', 11), 

(10275, 62, 30, '61.70', 6), 

(10275, 79, 41, '58.00', 18), 

(10275, 83, 27, '67.38', 10), 

(10275, 86, 23, '89.90', 7), 

(10275, 91, 28, '58.47', 12), 

(10275, 93, 38, '40.15', 13), 

(10275, 98, 32, '85.86', 14), 

(10275, 101, 39, '82.77', 16), 

(10275, 104, 48, '102.04', 8), 

(10275, 105, 43, '72.00', 15), 

(10275, 108, 31, '59.96', 17), 

(10276, 7, 50, '184.84', 3), 

(10276, 10, 43, '150.62', 14), 

(10276, 12, 47, '104.52', 1), 

(10276, 14, 38, '67.83', 4), 

(10276, 43, 38, '78.00', 6), 

(10276, 45, 30, '139.64', 5), 

(10276, 47, 33, '54.71', 9), 

(10276, 54, 48, '120.53', 8), 

(10276, 66, 46, '61.64', 12), 

(10276, 74, 20, '58.17', 2), 

(10276, 84, 48, '67.10', 7), 

(10276, 87, 27, '35.40', 10), 

(10276, 92, 38, '94.91', 13), 

(10276, 96, 21, '67.53', 11), 

(10277, 16, 28, '93.28', 1), 

(10278, 18, 34, '114.65', 6), 

(10278, 21, 23, '107.02', 2), 

(10278, 24, 29, '73.15', 10), 

(10278, 25, 29, '118.07', 5), 

(10278, 34, 39, '117.48', 3), 

(10278, 40, 42, '167.65', 7), 

(10278, 46, 31, '114.44', 4), 

(10278, 59, 35, '48.80', 1), 

(10278, 71, 31, '37.38', 8), 

(10278, 78, 25, '136.22', 9), 

(10279, 55, 26, '68.42', 1), 

(10279, 56, 32, '68.35', 5), 

(10279, 67, 49, '76.33', 3), 

(10279, 70, 48, '106.87', 2), 

(10279, 73, 33, '78.76', 4), 

(10279, 76, 48, '95.30', 6), 

(10280, 2, 34, '205.73', 2), 

(10280, 17, 24, '98.00', 1), 

(10280, 19, 50, '87.33', 9), 

(10280, 20, 27, '47.44', 8), 

(10280, 23, 26, '161.50', 16), 

(10280, 27, 25, '53.28', 15), 

(10280, 29, 37, '109.33', 13), 

(10280, 33, 22, '158.63', 10), 

(10280, 35, 46, '82.06', 3), 

(10280, 36, 43, '54.34', 5), 

(10280, 38, 29, '102.63', 4), 

(10280, 44, 34, '99.21', 7), 

(10280, 50, 35, '77.31', 17), 

(10280, 61, 20, '29.87', 12), 

(10280, 64, 45, '36.29', 11), 

(10280, 80, 33, '35.29', 14), 

(10280, 82, 21, '79.86', 6), 

(10281, 6, 44, '132.97', 9), 

(10281, 9, 25, '127.10', 13), 

(10281, 15, 41, '98.36', 1), 

(10281, 28, 48, '114.14', 4), 

(10281, 30, 29, '56.52', 7), 

(10281, 40, 25, '135.47', 5), 

(10281, 52, 25, '96.86', 10), 

(10281, 53, 44, '42.76', 14), 

(10281, 65, 25, '112.46', 6), 

(10281, 68, 20, '33.95', 2), 

(10281, 85, 29, '80.90', 8), 

(10281, 88, 31, '44.91', 3), 

(10281, 90, 36, '59.47', 12), 

(10281, 103, 27, '89.01', 11), 

(10282, 8, 41, '176.63', 5), 

(10282, 11, 27, '142.02', 6), 

(10282, 13, 24, '169.56', 4), 

(10282, 26, 23, '147.36', 13), 

(10282, 39, 43, '122.93', 1), 

(10282, 42, 36, '88.74', 3), 

(10282, 49, 31, '132.13', 8), 

(10282, 57, 29, '49.71', 11), 

(10282, 81, 39, '96.99', 10), 

(10282, 89, 36, '51.58', 9), 

(10282, 94, 38, '114.59', 12), 

(10282, 95, 37, '56.24', 7), 

(10282, 99, 43, '77.95', 2), 

(10283, 5, 25, '130.56', 6), 

(10283, 37, 21, '78.28', 4), 

(10283, 48, 46, '100.58', 3), 

(10283, 51, 34, '71.97', 14), 

(10283, 63, 42, '99.54', 13), 

(10283, 72, 34, '80.54', 8), 

(10283, 77, 33, '77.15', 5), 

(10283, 97, 45, '62.00', 9), 

(10283, 100, 20, '74.23', 2), 

(10283, 102, 47, '68.67', 7), 

(10283, 106, 22, '88.15', 10), 

(10283, 107, 38, '85.41', 11), 

(10283, 109, 43, '41.22', 1), 

(10283, 110, 33, '49.14', 12), 

(10284, 22, 45, '137.19', 11), 

(10284, 31, 31, '68.43', 1), 

(10284, 60, 22, '101.76', 3), 

(10284, 69, 30, '65.08', 12), 

(10284, 75, 39, '59.83', 13), 

(10284, 79, 21, '65.51', 10), 

(10284, 83, 21, '66.65', 2), 

(10284, 91, 50, '60.54', 4), 

(10284, 93, 33, '35.78', 5), 

(10284, 98, 24, '87.69', 6), 

(10284, 101, 45, '95.73', 8), 

(10284, 105, 25, '68.00', 7), 

(10284, 108, 32, '73.29', 9), 

(10285, 1, 36, '95.70', 6), 

(10285, 3, 47, '110.61', 9), 

(10285, 4, 27, '166.55', 8), 

(10285, 10, 49, '131.04', 5), 

(10285, 32, 20, '50.88', 10), 

(10285, 58, 34, '91.29', 7), 

(10285, 62, 39, '61.70', 11), 

(10285, 66, 38, '64.41', 3), 

(10285, 86, 37, '82.91', 12), 

(10285, 87, 37, '36.61', 1), 

(10285, 92, 26, '100.01', 4), 

(10285, 96, 39, '76.48', 2), 

(10285, 104, 45, '102.04', 13), 

(10286, 47, 38, '51.60', 1), 

(10287, 7, 21, '190.68', 12), 

(10287, 12, 45, '117.44', 10), 

(10287, 14, 41, '74.21', 13), 

(10287, 16, 23, '107.10', 9), 

(10287, 18, 41, '113.23', 4), 

(10287, 24, 44, '61.60', 8), 

(10287, 25, 24, '123.76', 3), 

(10287, 34, 44, '114.84', 1), 

(10287, 40, 36, '137.17', 5), 

(10287, 43, 43, '68.35', 15), 

(10287, 45, 40, '127.88', 14), 

(10287, 46, 27, '139.87', 2), 

(10287, 54, 34, '119.04', 17), 

(10287, 71, 36, '31.34', 6), 

(10287, 74, 20, '58.17', 11), 

(10287, 78, 36, '137.62', 7), 

(10287, 84, 40, '79.22', 16), 

(10288, 21, 20, '120.71', 14), 

(10288, 23, 32, '168.30', 5), 

(10288, 27, 28, '50.25', 4), 

(10288, 29, 31, '102.98', 2), 

(10288, 50, 35, '90.19', 6), 

(10288, 55, 23, '57.02', 7), 

(10288, 56, 36, '66.88', 11), 

(10288, 59, 50, '49.30', 13), 

(10288, 61, 29, '32.19', 1), 

(10288, 67, 35, '81.78', 9), 

(10288, 70, 48, '109.22', 8), 

(10288, 73, 34, '76.19', 10), 

(10288, 76, 41, '101.73', 12), 

(10288, 80, 33, '37.75', 3), 

(10289, 19, 38, '92.47', 2), 

(10289, 20, 24, '44.75', 1), 

(10289, 33, 43, '141.75', 3), 

(10289, 64, 45, '41.22', 4), 

(10290, 44, 26, '80.36', 2), 

(10290, 82, 45, '83.76', 1), 

(10291, 2, 37, '210.01', 11), 

(10291, 6, 30, '141.83', 4), 

(10291, 9, 41, '123.00', 8), 

(10291, 17, 41, '96.84', 10), 

(10291, 30, 26, '52.26', 2), 

(10291, 35, 47, '99.28', 12), 

(10291, 36, 37, '56.21', 14), 

(10291, 38, 23, '93.20', 13), 

(10291, 52, 48, '96.86', 5), 

(10291, 53, 29, '45.28', 9), 

(10291, 65, 48, '109.90', 1), 

(10291, 85, 26, '82.83', 3), 

(10291, 90, 32, '53.00', 7), 

(10291, 103, 28, '86.99', 6), 

(10292, 15, 21, '94.80', 8), 

(10292, 26, 26, '140.81', 7), 

(10292, 28, 41, '103.09', 11), 

(10292, 40, 21, '147.33', 12), 

(10292, 49, 44, '114.90', 2), 

(10292, 57, 40, '48.55', 5), 

(10292, 68, 39, '34.30', 9), 

(10292, 81, 27, '113.55', 4), 

(10292, 88, 50, '54.11', 10), 

(10292, 89, 31, '59.65', 3), 

(10292, 94, 41, '113.44', 6), 

(10292, 95, 35, '49.79', 1), 

(10293, 8, 46, '187.02', 8), 

(10293, 11, 24, '129.93', 9), 

(10293, 13, 45, '171.29', 7), 

(10293, 39, 24, '110.64', 4), 

(10293, 42, 22, '91.76', 6), 

(10293, 51, 49, '72.85', 3), 

(10293, 63, 21, '111.83', 2), 

(10293, 99, 29, '77.95', 5), 

(10293, 110, 32, '51.32', 1), 

(10294, 107, 45, '98.32', 1), 

(10295, 5, 24, '136.00', 1), 

(10295, 72, 46, '84.08', 3), 

(10295, 97, 26, '62.00', 4), 

(10295, 102, 44, '71.56', 2), 

(10295, 106, 34, '93.16', 5), 

(10296, 22, 36, '146.65', 7), 

(10296, 37, 21, '69.68', 13), 

(10296, 48, 22, '105.87', 12), 

(10296, 69, 21, '60.97', 8), 

(10296, 75, 31, '63.78', 9), 

(10296, 77, 22, '83.02', 14), 

(10296, 79, 32, '63.46', 6), 

(10296, 93, 26, '41.02', 1), 

(10296, 98, 42, '75.81', 2), 

(10296, 100, 34, '89.61', 11), 

(10296, 101, 24, '96.73', 4), 

(10296, 105, 22, '74.40', 3), 

(10296, 108, 47, '61.44', 5), 

(10296, 109, 21, '46.68', 10), 

(10297, 31, 25, '81.95', 4), 

(10297, 60, 32, '107.23', 6), 

(10297, 62, 32, '70.08', 1), 

(10297, 83, 23, '71.73', 5), 

(10297, 86, 26, '88.90', 2), 

(10297, 91, 28, '63.29', 7), 

(10297, 104, 35, '111.53', 3), 

(10298, 3, 39, '105.86', 1), 

(10298, 32, 32, '60.57', 2), 

(10299, 1, 23, '76.56', 9), 

(10299, 4, 29, '164.61', 11), 

(10299, 10, 24, '123.51', 8), 

(10299, 47, 39, '62.17', 3), 

(10299, 54, 49, '119.04', 2), 

(10299, 58, 47, '107.07', 10), 

(10299, 66, 33, '58.87', 6), 

(10299, 84, 32, '66.29', 1), 

(10299, 87, 24, '36.21', 4), 

(10299, 92, 38, '84.70', 7), 

(10299, 96, 44, '77.29', 5), 

(10300, 7, 33, '184.84', 5), 

(10300, 12, 29, '116.27', 3), 

(10300, 14, 22, '76.61', 6), 

(10300, 16, 23, '95.58', 2), 

(10300, 24, 41, '63.14', 1), 

(10300, 43, 49, '65.94', 8), 

(10300, 45, 23, '144.05', 7), 

(10300, 74, 31, '52.05', 4), 

(10301, 18, 37, '114.65', 8), 

(10301, 21, 32, '118.22', 4), 

(10301, 25, 47, '119.49', 7), 

(10301, 34, 22, '113.52', 5), 

(10301, 40, 23, '135.47', 9), 

(10301, 46, 39, '137.04', 6), 

(10301, 56, 27, '64.67', 1), 

(10301, 59, 22, '40.75', 3), 

(10301, 71, 48, '32.10', 10), 

(10301, 76, 22, '86.73', 2), 

(10301, 78, 50, '122.17', 11), 

(10302, 23, 43, '166.60', 1), 

(10302, 50, 38, '82.83', 2), 

(10302, 55, 23, '70.56', 3), 

(10302, 67, 49, '75.42', 5), 

(10302, 70, 45, '104.52', 4), 

(10302, 73, 48, '74.48', 6), 

(10303, 27, 46, '56.91', 2), 

(10303, 80, 24, '35.70', 1), 

(10304, 2, 47, '201.44', 6), 

(10304, 9, 39, '117.54', 3), 

(10304, 17, 46, '106.17', 5), 

(10304, 19, 37, '95.55', 13), 

(10304, 20, 37, '46.90', 12), 

(10304, 29, 24, '102.98', 17), 

(10304, 33, 20, '141.75', 14), 

(10304, 35, 46, '98.27', 7), 

(10304, 36, 24, '54.34', 9), 

(10304, 38, 26, '90.06', 8), 

(10304, 44, 38, '95.24', 11), 

(10304, 53, 34, '44.27', 4), 

(10304, 61, 23, '29.21', 16), 

(10304, 64, 44, '42.11', 15), 

(10304, 82, 33, '80.83', 10), 

(10304, 90, 36, '52.36', 2), 

(10304, 103, 40, '80.92', 1), 

(10305, 6, 38, '130.01', 13), 

(10305, 15, 38, '107.84', 5), 

(10305, 26, 27, '132.62', 4), 

(10305, 28, 36, '117.82', 8), 

(10305, 30, 41, '58.95', 11), 

(10305, 40, 37, '160.87', 9), 

(10305, 52, 22, '112.60', 14), 

(10305, 57, 45, '48.55', 2), 

(10305, 65, 24, '107.34', 10), 

(10305, 68, 48, '30.76', 6), 

(10305, 81, 36, '118.28', 1), 

(10305, 85, 28, '94.38', 12), 

(10305, 88, 40, '48.70', 7), 

(10305, 94, 42, '109.96', 3), 

(10306, 8, 31, '182.86', 13), 

(10306, 11, 34, '145.04', 14), 

(10306, 13, 20, '145.34', 12), 

(10306, 39, 32, '114.74', 9), 

(10306, 42, 40, '83.70', 11), 

(10306, 49, 23, '126.39', 16), 

(10306, 51, 39, '85.14', 8), 

(10306, 63, 29, '109.37', 7), 

(10306, 72, 31, '76.12', 2), 

(10306, 89, 46, '60.28', 17), 

(10306, 95, 34, '51.55', 15), 

(10306, 97, 50, '61.34', 3), 

(10306, 99, 38, '73.62', 10), 

(10306, 102, 43, '62.16', 1), 

(10306, 106, 32, '99.17', 4), 

(10306, 107, 30, '87.39', 5), 

(10306, 110, 35, '48.05', 6), 

(10307, 5, 22, '118.32', 9), 

(10307, 22, 39, '135.61', 1), 

(10307, 37, 31, '71.40', 7), 

(10307, 48, 48, '92.11', 6), 

(10307, 69, 25, '58.23', 2), 

(10307, 75, 22, '64.44', 3), 

(10307, 77, 22, '75.47', 8), 

(10307, 100, 34, '81.47', 5), 

(10307, 109, 34, '44.20', 4), 

(10308, 3, 34, '115.37', 2), 

(10308, 4, 20, '187.85', 1), 

(10308, 31, 27, '81.95', 7), 

(10308, 32, 34, '48.46', 3), 

(10308, 60, 31, '99.57', 9), 

(10308, 62, 47, '68.55', 4), 

(10308, 79, 43, '58.00', 16), 

(10308, 83, 44, '71.73', 8), 

(10308, 86, 24, '99.89', 5), 

(10308, 91, 46, '61.22', 10), 

(10308, 93, 47, '37.09', 11), 

(10308, 98, 21, '73.07', 12), 

(10308, 101, 35, '88.75', 14), 

(10308, 104, 31, '100.85', 6), 

(10308, 105, 21, '79.20', 13), 

(10308, 108, 39, '62.93', 15), 

(10309, 1, 41, '94.74', 5), 

(10309, 10, 26, '144.60', 4), 

(10309, 58, 21, '96.92', 6), 

(10309, 66, 24, '59.56', 2), 

(10309, 92, 50, '93.89', 3), 

(10309, 96, 28, '74.04', 1), 

(10310, 7, 33, '165.38', 10), 

(10310, 12, 24, '105.70', 8), 

(10310, 14, 49, '77.41', 11), 

(10310, 16, 25, '101.34', 7), 

(10310, 18, 37, '128.80', 2), 

(10310, 24, 20, '66.99', 6), 

(10310, 25, 24, '129.45', 1), 

(10310, 40, 48, '159.18', 3), 

(10310, 43, 27, '70.76', 13), 

(10310, 45, 49, '122.00', 12), 

(10310, 47, 42, '59.06', 16), 

(10310, 54, 40, '133.92', 15), 

(10310, 71, 33, '33.23', 4), 

(10310, 74, 38, '50.21', 9), 

(10310, 78, 45, '139.03', 5), 

(10310, 84, 49, '75.18', 14), 

(10310, 87, 36, '38.62', 17), 

(10311, 21, 29, '124.44', 9), 

(10311, 34, 43, '114.84', 10), 

(10311, 46, 32, '134.22', 11), 

(10311, 50, 41, '92.03', 1), 

(10311, 55, 25, '66.99', 2), 

(10311, 56, 26, '70.55', 6), 

(10311, 59, 45, '48.80', 8), 

(10311, 67, 28, '89.05', 4), 

(10311, 70, 43, '116.27', 3), 

(10311, 73, 25, '85.61', 5), 

(10311, 76, 46, '91.02', 7), 

(10312, 2, 48, '214.30', 3), 

(10312, 17, 32, '101.50', 2), 

(10312, 19, 43, '102.74', 10), 

(10312, 20, 25, '43.67', 9), 

(10312, 23, 48, '146.20', 17), 

(10312, 27, 30, '48.43', 16), 

(10312, 29, 31, '111.87', 14), 

(10312, 33, 25, '150.19', 11), 

(10312, 35, 37, '91.18', 4), 

(10312, 36, 35, '54.34', 6), 

(10312, 38, 38, '93.20', 5), 

(10312, 44, 33, '84.33', 8), 

(10312, 53, 39, '44.27', 1), 

(10312, 61, 39, '27.88', 13), 

(10312, 64, 23, '43.46', 12), 

(10312, 80, 31, '40.21', 15), 

(10312, 82, 44, '96.42', 7), 

(10313, 6, 40, '141.83', 7), 

(10313, 9, 21, '131.20', 11), 

(10313, 28, 29, '109.23', 2), 

(10313, 30, 34, '52.87', 5), 

(10313, 40, 25, '143.94', 3), 

(10313, 52, 28, '110.18', 8), 

(10313, 65, 42, '102.23', 4), 

(10313, 85, 27, '96.31', 6), 

(10313, 88, 38, '48.70', 1), 

(10313, 90, 34, '55.59', 10), 

(10313, 103, 30, '96.09', 9), 

(10314, 8, 38, '176.63', 5), 

(10314, 11, 46, '125.40', 6), 

(10314, 13, 36, '169.56', 4), 

(10314, 15, 45, '95.99', 14), 

(10314, 26, 42, '135.90', 13), 

(10314, 39, 20, '129.76', 1), 

(10314, 42, 23, '84.71', 3), 

(10314, 49, 29, '129.26', 8), 

(10314, 57, 44, '51.44', 11), 

(10314, 68, 39, '31.82', 15), 

(10314, 81, 38, '111.18', 10), 

(10314, 89, 35, '58.41', 9), 

(10314, 94, 28, '115.75', 12), 

(10314, 95, 38, '50.38', 7), 

(10314, 99, 23, '83.15', 2), 

(10315, 51, 36, '78.12', 7), 

(10315, 63, 35, '111.83', 6), 

(10315, 72, 24, '78.77', 1), 

(10315, 97, 41, '60.67', 2), 

(10315, 106, 31, '99.17', 3), 

(10315, 107, 37, '88.39', 4), 

(10315, 110, 40, '51.32', 5), 

(10316, 5, 33, '126.48', 17), 

(10316, 22, 27, '140.34', 9), 

(10316, 37, 21, '72.26', 15), 

(10316, 48, 47, '89.99', 14), 

(10316, 60, 25, '93.01', 1), 

(10316, 69, 34, '67.14', 10), 

(10316, 75, 47, '55.23', 11), 

(10316, 77, 25, '77.15', 16), 

(10316, 79, 30, '67.56', 8), 

(10316, 91, 24, '59.16', 2), 

(10316, 93, 34, '36.66', 3), 

(10316, 98, 34, '74.90', 4), 

(10316, 100, 45, '73.32', 13), 

(10316, 101, 23, '85.76', 6), 

(10316, 102, 48, '67.22', 18), 

(10316, 105, 48, '77.60', 5), 

(10316, 108, 44, '68.11', 7), 

(10316, 109, 34, '43.70', 12), 

(10317, 83, 35, '69.55', 1), 

(10318, 1, 46, '84.22', 1), 

(10318, 2, 45, '102.29', 4), 

(10318, 40, 37, '189.79', 3), 

(10318, 31, 31, '81.95', 9), 

(10318, 32, 42, '49.67', 5), 

(10318, 58, 48, '93.54', 2), 

(10318, 62, 26, '60.94', 6), 

(10318, 86, 47, '81.91', 7), 

(10318, 104, 50, '102.04', 8), 

(10319, 10, 30, '134.05', 9), 

(10319, 43, 46, '77.19', 1), 

(10319, 47, 44, '54.71', 4), 

(10319, 54, 45, '120.53', 3), 

(10319, 66, 31, '65.80', 7), 

(10319, 84, 43, '78.41', 2), 

(10319, 87, 29, '35.00', 5), 

(10319, 92, 22, '96.95', 8), 

(10319, 96, 45, '79.73', 6), 

(10320, 7, 31, '184.84', 3), 

(10320, 12, 35, '102.17', 1), 

(10320, 14, 38, '63.84', 4), 

(10320, 45, 25, '139.64', 5), 

(10320, 74, 26, '60.62', 2), 

(10321, 16, 24, '105.95', 15), 

(10321, 18, 41, '123.14', 10), 

(10321, 21, 44, '120.71', 6), 

(10321, 24, 37, '73.92', 14), 

(10321, 25, 25, '142.25', 9), 

(10321, 34, 27, '126.72', 7), 

(10321, 40, 33, '164.26', 11), 

(10321, 46, 28, '138.45', 8), 

(10321, 56, 30, '68.35', 3), 

(10321, 59, 48, '42.76', 5), 

(10321, 67, 30, '74.51', 1), 

(10321, 71, 37, '31.72', 12), 

(10321, 73, 39, '81.33', 2), 

(10321, 76, 21, '103.87', 4), 

(10321, 78, 26, '137.62', 13), 

(10322, 2, 40, '180.01', 1), 

(10322, 6, 46, '141.83', 8), 

(10322, 9, 27, '136.67', 9), 

(10322, 17, 22, '101.50', 10), 

(10322, 19, 43, '92.47', 14), 

(10322, 20, 41, '44.21', 5), 

(10322, 29, 50, '120.77', 6), 

(10322, 30, 35, '57.12', 11), 

(10322, 33, 36, '158.63', 2), 

(10322, 35, 33, '100.30', 12), 

(10322, 36, 41, '54.34', 13), 

(10322, 38, 48, '90.06', 7), 

(10322, 61, 20, '26.55', 3), 

(10322, 64, 30, '40.77', 4), 

(10323, 44, 33, '88.30', 2), 

(10323, 52, 47, '96.86', 1), 

(10324, 11, 27, '148.06', 1), 

(10324, 15, 26, '100.73', 7), 

(10324, 26, 47, '142.45', 8), 

(10324, 28, 33, '105.55', 10), 

(10324, 40, 27, '137.17', 12), 

(10324, 49, 49, '120.64', 13), 

(10324, 53, 38, '49.81', 6), 

(10324, 57, 25, '49.71', 14), 

(10324, 65, 31, '107.34', 2), 

(10324, 68, 30, '29.35', 9), 

(10324, 82, 33, '95.44', 3), 

(10324, 85, 20, '91.49', 11), 

(10324, 90, 48, '60.76', 4), 

(10324, 103, 34, '80.92', 5), 

(10325, 5, 47, '111.52', 6), 

(10325, 8, 42, '193.25', 8), 

(10325, 13, 24, '166.10', 1), 

(10325, 39, 24, '114.74', 9), 

(10325, 81, 44, '114.73', 5), 

(10325, 88, 38, '44.37', 3), 

(10325, 89, 28, '55.30', 2), 

(10325, 94, 38, '99.55', 4), 

(10325, 95, 44, '56.24', 7), 

(10326, 42, 32, '94.79', 6), 

(10326, 51, 50, '73.73', 5), 

(10326, 63, 41, '120.43', 4), 

(10326, 72, 41, '86.74', 3), 

(10326, 77, 20, '81.34', 2), 

(10326, 97, 39, '60.67', 1), 

(10327, 22, 25, '154.54', 6), 

(10327, 31, 45, '74.34', 8), 

(10327, 37, 25, '74.84', 5), 

(10327, 99, 20, '79.68', 7), 

(10327, 102, 21, '65.05', 1), 

(10327, 106, 43, '85.14', 2), 

(10327, 107, 37, '83.42', 3), 

(10327, 110, 37, '48.05', 4), 

(10328, 48, 34, '104.81', 6), 

(10328, 60, 47, '87.54', 14), 

(10328, 69, 48, '67.82', 1), 

(10328, 75, 20, '56.55', 2), 

(10328, 79, 35, '55.96', 3), 

(10328, 83, 43, '69.55', 4), 

(10328, 91, 24, '57.10', 5), 

(10328, 93, 34, '42.33', 7), 

(10328, 98, 27, '84.03', 8), 

(10328, 100, 41, '75.13', 9), 

(10328, 101, 37, '95.73', 10), 

(10328, 104, 33, '117.46', 11), 

(10328, 105, 33, '71.20', 13), 

(10328, 108, 39, '69.59', 12), 

(10329, 1, 42, '80.39', 1), 

(10329, 3, 20, '109.42', 2), 

(10329, 4, 26, '164.61', 3), 

(10329, 7, 41, '182.90', 5), 

(10329, 10, 24, '128.03', 6), 

(10329, 12, 46, '117.44', 13), 

(10329, 14, 33, '74.21', 14), 

(10329, 16, 39, '102.49', 15), 

(10329, 24, 29, '66.22', 9), 

(10329, 32, 38, '55.72', 12), 

(10329, 43, 38, '65.13', 10), 

(10329, 58, 30, '104.81', 7), 

(10329, 62, 37, '71.60', 4), 

(10329, 86, 45, '80.91', 11), 

(10329, 109, 44, '41.22', 8), 

(10330, 45, 37, '136.70', 3), 

(10330, 47, 29, '59.06', 2), 

(10330, 54, 50, '133.92', 4), 

(10330, 66, 42, '56.10', 1), 

(10331, 18, 46, '120.31', 6), 

(10331, 21, 44, '99.55', 14), 

(10331, 23, 44, '154.70', 7), 

(10331, 25, 30, '135.14', 8), 

(10331, 34, 26, '130.68', 10), 

(10331, 40, 27, '169.34', 11), 

(10331, 46, 26, '132.80', 12), 

(10331, 71, 27, '37.00', 13), 

(10331, 74, 25, '55.11', 9), 

(10331, 78, 21, '139.03', 1), 

(10331, 84, 41, '70.33', 2), 

(10331, 87, 28, '33.39', 3), 

(10331, 92, 32, '100.01', 4), 

(10331, 96, 20, '74.04', 5), 

(10332, 19, 46, '89.38', 15), 

(10332, 20, 27, '51.21', 16), 

(10332, 27, 38, '53.88', 9), 

(10332, 29, 35, '116.96', 8), 

(10332, 33, 24, '138.38', 1), 

(10332, 36, 26, '53.09', 17), 

(10332, 38, 40, '100.53', 18), 

(10332, 50, 50, '92.03', 2), 

(10332, 55, 21, '70.56', 3), 

(10332, 56, 23, '61.73', 4), 

(10332, 59, 20, '47.29', 5), 

(10332, 61, 45, '29.87', 6), 

(10332, 64, 26, '43.01', 10), 

(10332, 67, 39, '84.51', 7), 

(10332, 70, 44, '108.04', 11), 

(10332, 73, 45, '77.91', 12), 

(10332, 76, 31, '94.23', 13), 

(10332, 80, 41, '34.47', 14), 

(10333, 2, 26, '188.58', 3), 

(10333, 9, 33, '121.64', 6), 

(10333, 17, 29, '110.84', 7), 

(10333, 35, 31, '95.23', 5), 

(10333, 44, 46, '95.24', 2), 

(10333, 53, 24, '42.26', 8), 

(10333, 82, 39, '95.44', 1), 

(10333, 90, 33, '62.05', 4), 

(10334, 6, 26, '130.01', 2), 

(10334, 28, 46, '108.00', 6), 

(10334, 30, 34, '52.87', 1), 

(10334, 40, 20, '147.33', 3), 

(10334, 52, 49, '101.71', 4), 

(10334, 65, 42, '117.57', 5), 

(10335, 68, 33, '32.88', 2), 

(10335, 85, 44, '77.05', 1), 

(10335, 88, 40, '49.78', 3), 

(10336, 8, 33, '176.63', 10), 

(10336, 11, 33, '126.91', 11), 

(10336, 13, 49, '141.88', 1), 

(10336, 15, 38, '95.99', 3), 

(10336, 26, 49, '153.91', 6), 

(10336, 39, 48, '135.22', 12), 

(10336, 42, 21, '100.84', 7), 

(10336, 57, 45, '49.71', 4), 

(10336, 81, 31, '113.55', 5), 

(10336, 89, 31, '59.03', 9), 

(10336, 94, 23, '109.96', 8), 

(10336, 103, 46, '94.07', 2), 

(10337, 5, 25, '131.92', 8), 

(10337, 49, 36, '140.75', 3), 

(10337, 51, 29, '76.36', 2), 

(10337, 63, 29, '119.20', 4), 

(10337, 95, 21, '54.48', 6), 

(10337, 99, 36, '73.62', 9), 

(10337, 106, 31, '84.14', 1), 

(10337, 107, 36, '83.42', 7), 

(10337, 110, 42, '49.14', 5), 

(10338, 22, 41, '137.19', 1), 

(10338, 37, 28, '80.86', 3), 

(10338, 48, 45, '93.17', 2), 

(10339, 3, 40, '117.75', 4), 

(10339, 4, 39, '178.17', 3), 

(10339, 31, 27, '79.41', 2), 

(10339, 32, 30, '48.46', 1), 

(10339, 58, 27, '96.92', 10), 

(10339, 60, 21, '106.14', 7), 

(10339, 69, 55, '67.82', 12), 

(10339, 72, 55, '73.46', 13), 

(10339, 75, 29, '57.86', 14), 

(10339, 77, 42, '72.96', 16), 

(10339, 79, 45, '57.32', 11), 

(10339, 97, 22, '53.34', 5), 

(10339, 100, 55, '86.90', 15), 

(10339, 102, 50, '62.16', 9), 

(10339, 108, 50, '66.63', 8), 

(10339, 109, 27, '49.66', 6), 

(10340, 62, 55, '62.46', 8), 

(10340, 83, 40, '63.76', 1), 

(10340, 86, 55, '95.89', 2), 

(10340, 91, 39, '67.41', 3), 

(10340, 93, 40, '37.09', 4), 

(10340, 98, 30, '73.99', 5), 

(10340, 101, 55, '81.77', 7), 

(10340, 104, 29, '98.48', 6), 

(10341, 1, 41, '84.22', 9), 

(10341, 7, 45, '192.62', 2), 

(10341, 10, 55, '120.50', 8), 

(10341, 12, 44, '111.57', 1), 

(10341, 14, 36, '77.41', 10), 

(10341, 16, 55, '109.40', 7), 

(10341, 66, 32, '63.03', 6), 

(10341, 92, 31, '95.93', 4), 

(10341, 96, 38, '78.11', 3), 

(10341, 105, 34, '70.40', 5), 

(10342, 18, 40, '118.89', 2), 

(10342, 24, 55, '63.14', 1), 

(10342, 25, 22, '115.22', 3), 

(10342, 40, 30, '167.65', 4), 

(10342, 43, 25, '76.39', 5), 

(10342, 45, 55, '136.70', 7), 

(10342, 47, 26, '57.82', 8), 

(10342, 54, 38, '124.99', 11), 

(10342, 71, 39, '30.59', 9), 

(10342, 74, 48, '60.01', 10), 

(10342, 78, 42, '112.34', 6), 

(10343, 21, 36, '109.51', 4), 

(10343, 34, 25, '118.80', 3), 

(10343, 46, 44, '127.15', 2), 

(10343, 59, 27, '44.78', 6), 

(10343, 84, 30, '76.80', 1), 

(10343, 87, 29, '37.41', 5), 

(10344, 23, 45, '168.30', 1), 

(10344, 27, 40, '49.04', 2), 

(10344, 29, 30, '118.23', 3), 

(10344, 50, 21, '80.99', 4), 

(10344, 55, 26, '68.42', 5), 

(10344, 56, 29, '61.00', 7), 

(10344, 61, 20, '27.88', 6), 

(10345, 64, 43, '38.98', 1), 

(10346, 19, 42, '88.36', 3), 

(10346, 67, 25, '87.24', 1), 

(10346, 70, 24, '117.44', 5), 

(10346, 73, 24, '80.47', 2), 

(10346, 76, 26, '103.87', 6), 

(10346, 80, 22, '38.57', 4), 

(10347, 2, 30, '188.58', 1), 

(10347, 6, 27, '132.97', 2), 

(10347, 9, 29, '132.57', 3), 

(10347, 17, 42, '113.17', 5), 

(10347, 20, 21, '46.36', 7), 

(10347, 30, 50, '51.05', 8), 

(10347, 33, 21, '136.69', 6), 

(10347, 35, 48, '84.09', 9), 

(10347, 36, 34, '60.59', 10), 

(10347, 38, 45, '95.30', 11), 

(10347, 44, 26, '84.33', 12), 

(10347, 52, 45, '115.03', 4), 

(10348, 8, 48, '207.80', 8), 

(10348, 11, 47, '122.37', 4), 

(10348, 53, 29, '43.77', 6), 

(10348, 65, 37, '107.34', 1), 

(10348, 82, 39, '82.78', 2), 

(10348, 85, 42, '90.53', 3), 

(10348, 90, 31, '62.70', 5), 

(10348, 103, 32, '100.14', 7), 

(10349, 13, 26, '166.10', 10), 

(10349, 15, 48, '114.95', 9), 

(10349, 26, 38, '142.45', 8), 

(10349, 28, 38, '117.82', 7), 

(10349, 40, 48, '164.26', 6), 

(10349, 49, 34, '140.75', 5), 

(10349, 57, 48, '50.29', 4), 

(10349, 68, 36, '31.47', 3), 

(10349, 81, 23, '111.18', 2), 

(10349, 88, 33, '44.37', 1), 

(10350, 5, 26, '110.16', 5), 

(10350, 37, 43, '84.30', 6), 

(10350, 39, 44, '135.22', 1), 

(10350, 42, 41, '94.79', 2), 

(10350, 51, 30, '70.22', 3), 

(10350, 63, 34, '98.31', 7), 

(10350, 72, 30, '86.74', 9), 

(10350, 77, 25, '77.15', 10), 

(10350, 89, 27, '61.52', 14), 

(10350, 94, 31, '104.18', 8), 

(10350, 95, 44, '56.82', 17), 

(10350, 97, 46, '56.00', 11), 

(10350, 99, 28, '76.22', 4), 

(10350, 102, 29, '68.67', 12), 

(10350, 106, 31, '87.15', 13), 

(10350, 107, 25, '97.32', 16), 

(10350, 110, 20, '48.05', 15), 

(10351, 22, 39, '143.50', 1), 

(10351, 48, 20, '104.81', 2), 

(10351, 69, 25, '64.40', 5), 

(10351, 75, 38, '53.92', 4), 

(10351, 79, 34, '68.24', 3), 

(10352, 100, 23, '75.13', 3), 

(10352, 101, 49, '87.75', 2), 

(10352, 108, 22, '62.19', 1), 

(10352, 109, 49, '46.18', 4), 

(10353, 31, 27, '71.81', 1), 

(10353, 60, 28, '107.23', 2), 

(10353, 83, 35, '69.55', 3), 

(10353, 86, 46, '86.90', 5), 

(10353, 91, 40, '68.10', 7), 

(10353, 93, 40, '35.78', 8), 

(10353, 98, 39, '73.07', 9), 

(10353, 104, 48, '98.48', 4), 

(10353, 105, 43, '74.40', 6), 

(10354, 1, 42, '84.22', 6), 

(10354, 3, 20, '95.15', 2), 

(10354, 4, 42, '178.17', 3), 

(10354, 7, 31, '157.60', 9), 

(10354, 10, 35, '141.58', 4), 

(10354, 12, 29, '98.65', 11), 

(10354, 14, 23, '76.61', 12), 

(10354, 16, 28, '100.19', 13), 

(10354, 24, 21, '76.23', 8), 

(10354, 32, 28, '49.06', 10), 

(10354, 43, 36, '69.15', 7), 

(10354, 58, 21, '96.92', 5), 

(10354, 62, 28, '62.46', 1), 

(10355, 45, 23, '117.59', 7), 

(10355, 47, 31, '60.30', 1), 

(10355, 54, 25, '124.99', 2), 

(10355, 66, 41, '56.10', 3), 

(10355, 71, 36, '37.38', 4), 

(10355, 74, 44, '60.62', 6), 

(10355, 78, 32, '137.62', 8), 

(10355, 84, 28, '75.18', 9), 

(10355, 87, 38, '32.99', 10), 

(10355, 92, 40, '93.89', 5), 

(10356, 18, 43, '120.31', 8), 

(10356, 19, 50, '82.19', 9), 

(10356, 20, 22, '44.75', 6), 

(10356, 25, 27, '130.87', 2), 

(10356, 29, 29, '106.79', 3), 

(10356, 33, 30, '158.63', 1), 

(10356, 61, 48, '31.86', 5), 

(10356, 64, 26, '42.11', 7), 

(10356, 96, 26, '78.11', 4), 

(10357, 2, 32, '199.30', 10), 

(10357, 6, 43, '135.92', 9), 

(10357, 9, 49, '109.34', 8), 

(10357, 17, 39, '112.00', 1), 

(10357, 30, 41, '58.95', 7), 

(10357, 35, 41, '91.18', 6), 

(10357, 36, 49, '59.34', 5), 

(10357, 38, 44, '104.72', 4), 

(10357, 44, 25, '84.33', 3), 

(10357, 52, 28, '105.34', 2), 

(10358, 11, 49, '129.93', 5), 

(10358, 15, 42, '98.36', 9), 

(10358, 26, 20, '142.45', 10), 

(10358, 28, 20, '99.41', 11), 

(10358, 40, 32, '137.17', 12), 

(10358, 49, 25, '117.77', 13), 

(10358, 53, 30, '46.29', 8), 

(10358, 57, 44, '56.07', 14), 

(10358, 65, 41, '127.79', 7), 

(10358, 68, 36, '33.59', 4), 

(10358, 82, 41, '88.62', 6), 

(10358, 85, 41, '82.83', 1), 

(10358, 90, 36, '51.71', 2), 

(10358, 103, 27, '85.98', 3), 

(10359, 5, 48, '122.40', 6), 

(10359, 8, 42, '180.79', 8), 

(10359, 13, 49, '162.64', 5), 

(10359, 81, 22, '108.82', 7), 

(10359, 88, 36, '45.45', 3), 

(10359, 89, 22, '62.14', 1), 

(10359, 94, 46, '99.55', 2), 

(10359, 95, 25, '47.45', 4), 

(10360, 22, 50, '126.15', 12), 

(10360, 31, 41, '68.43', 13), 

(10360, 37, 46, '71.40', 14), 

(10360, 39, 29, '122.93', 8), 

(10360, 42, 29, '94.79', 18), 

(10360, 48, 40, '101.64', 15), 

(10360, 51, 40, '76.36', 1), 

(10360, 60, 22, '106.14', 17), 

(10360, 63, 31, '100.77', 2), 

(10360, 69, 49, '55.49', 16), 

(10360, 72, 36, '70.81', 3), 

(10360, 77, 22, '78.83', 4), 

(10360, 97, 32, '64.67', 5), 

(10360, 99, 26, '86.61', 6), 

(10360, 102, 30, '70.11', 7), 

(10360, 106, 35, '83.14', 9), 

(10360, 107, 31, '92.36', 10), 

(10360, 110, 31, '54.05', 11), 

(10361, 1, 20, '92.83', 13), 

(10361, 3, 26, '114.18', 8), 

(10361, 75, 34, '62.46', 6), 

(10361, 79, 26, '61.42', 7), 

(10361, 83, 25, '68.83', 1), 

(10361, 91, 49, '56.41', 2), 

(10361, 93, 33, '35.78', 3), 

(10361, 98, 20, '88.60', 4), 

(10361, 100, 24, '85.99', 14), 

(10361, 101, 26, '91.74', 9), 

(10361, 104, 44, '107.97', 5), 

(10361, 105, 44, '76.80', 10), 

(10361, 108, 35, '62.19', 11), 

(10361, 109, 23, '47.67', 12), 

(10362, 4, 22, '182.04', 4), 

(10362, 10, 22, '131.04', 1), 

(10362, 32, 23, '53.91', 3), 

(10362, 58, 50, '91.29', 2), 

(10363, 7, 33, '180.95', 3), 

(10363, 12, 34, '106.87', 4), 

(10363, 14, 34, '68.63', 5), 

(10363, 16, 46, '103.64', 6), 

(10363, 24, 22, '61.60', 7), 

(10363, 43, 46, '69.15', 10), 

(10363, 45, 24, '124.94', 11), 

(10363, 47, 32, '52.22', 12), 

(10363, 54, 28, '123.50', 13), 

(10363, 62, 21, '70.08', 8), 

(10363, 66, 43, '56.10', 14), 

(10363, 74, 21, '52.05', 15), 

(10363, 78, 31, '113.75', 1), 

(10363, 84, 43, '75.99', 9), 

(10363, 86, 50, '92.90', 2), 

(10364, 87, 48, '38.22', 1), 

(10365, 18, 30, '116.06', 1), 

(10365, 92, 22, '82.66', 3), 

(10365, 96, 44, '68.34', 2), 

(10366, 25, 34, '116.65', 3), 

(10366, 34, 49, '105.60', 2), 

(10366, 40, 34, '154.10', 1), 

(10367, 21, 49, '105.77', 1), 

(10367, 23, 37, '144.50', 3), 

(10367, 27, 45, '50.25', 4), 

(10367, 29, 27, '124.59', 5), 

(10367, 33, 32, '140.06', 7), 

(10367, 46, 46, '131.39', 6), 

(10367, 50, 43, '77.31', 8), 

(10367, 55, 44, '66.99', 9), 

(10367, 56, 21, '72.76', 10), 

(10367, 59, 38, '50.31', 11), 

(10367, 61, 23, '29.54', 13), 

(10367, 64, 28, '43.01', 12), 

(10367, 71, 36, '36.25', 2), 

(10368, 67, 40, '73.60', 2), 

(10368, 70, 31, '115.09', 5), 

(10368, 73, 46, '83.04', 1), 

(10368, 76, 20, '93.16', 4), 

(10368, 80, 46, '36.52', 3), 

(10369, 2, 41, '195.01', 2), 

(10369, 19, 44, '89.38', 8), 

(10369, 20, 32, '46.36', 7), 

(10369, 35, 42, '100.30', 1), 

(10369, 36, 28, '51.84', 6), 

(10369, 38, 21, '90.06', 5), 

(10369, 44, 45, '80.36', 4), 

(10369, 82, 40, '93.49', 3), 

(10370, 6, 35, '128.53', 4), 

(10370, 9, 49, '128.47', 8), 

(10370, 17, 27, '100.34', 1), 

(10370, 28, 22, '101.87', 5), 

(10370, 30, 22, '60.16', 7), 

(10370, 40, 27, '167.65', 9), 

(10370, 52, 29, '105.34', 6), 

(10370, 53, 20, '41.76', 2), 

(10370, 90, 25, '63.99', 3), 

(10371, 8, 32, '178.71', 6), 

(10371, 15, 49, '104.28', 4), 

(10371, 26, 25, '160.46', 7), 

(10371, 57, 25, '53.75', 12), 

(10371, 65, 20, '126.51', 5), 

(10371, 68, 45, '35.01', 8), 

(10371, 81, 28, '95.81', 9), 

(10371, 85, 26, '82.83', 1), 

(10371, 88, 20, '44.37', 2), 

(10371, 89, 30, '53.44', 11), 

(10371, 94, 48, '97.23', 10), 

(10371, 103, 34, '83.95', 3), 

(10372, 11, 40, '146.55', 4), 

(10372, 13, 34, '140.15', 1), 

(10372, 39, 28, '131.13', 3), 

(10372, 42, 25, '91.76', 5), 

(10372, 49, 48, '119.20', 6), 

(10372, 51, 41, '78.99', 7), 

(10372, 63, 37, '102.00', 8), 

(10372, 95, 24, '56.82', 9), 

(10372, 99, 44, '74.48', 2), 

(10373, 5, 39, '118.32', 3), 

(10373, 22, 28, '143.50', 4), 

(10373, 37, 22, '75.70', 5), 

(10373, 48, 50, '99.52', 6), 

(10373, 69, 38, '58.92', 7), 

(10373, 72, 33, '82.31', 12), 

(10373, 75, 46, '53.92', 11), 

(10373, 77, 23, '83.86', 10), 

(10373, 79, 39, '62.10', 13), 

(10373, 97, 44, '58.00', 14), 

(10373, 100, 32, '76.94', 15), 

(10373, 102, 41, '69.39', 16), 

(10373, 106, 34, '94.16', 2), 

(10373, 107, 37, '83.42', 8), 

(10373, 108, 45, '68.11', 17), 

(10373, 109, 25, '44.20', 9), 

(10373, 110, 29, '48.05', 1), 

(10374, 3, 39, '115.37', 5), 

(10374, 4, 22, '158.80', 1), 

(10374, 31, 42, '75.19', 2), 

(10374, 32, 22, '48.46', 4), 

(10374, 58, 38, '112.70', 6), 

(10374, 60, 46, '107.23', 3), 

(10375, 1, 21, '76.56', 12), 

(10375, 7, 45, '184.84', 7), 

(10375, 10, 49, '150.62', 13), 

(10375, 62, 23, '67.03', 9), 

(10375, 66, 20, '60.26', 14), 

(10375, 83, 43, '60.13', 2), 

(10375, 86, 37, '87.90', 3), 

(10375, 91, 44, '59.85', 4), 

(10375, 92, 41, '96.95', 15), 

(10375, 93, 49, '36.22', 5), 

(10375, 96, 49, '69.16', 8), 

(10375, 98, 37, '86.77', 6), 

(10375, 101, 33, '94.73', 1), 

(10375, 104, 25, '98.48', 10), 

(10375, 105, 44, '69.60', 11), 

(10376, 12, 35, '98.65', 1), 

(10377, 14, 24, '65.44', 5), 

(10377, 16, 50, '112.86', 1), 

(10377, 18, 35, '124.56', 2), 

(10377, 24, 31, '61.60', 4), 

(10377, 25, 36, '125.18', 6), 

(10377, 40, 39, '143.94', 3), 

(10378, 21, 34, '121.95', 5), 

(10378, 43, 22, '66.74', 4), 

(10378, 45, 43, '146.99', 10), 

(10378, 47, 28, '60.30', 9), 

(10378, 54, 49, '122.02', 8), 

(10378, 71, 41, '30.59', 7), 

(10378, 74, 46, '52.66', 6), 

(10378, 78, 33, '129.20', 3), 

(10378, 84, 41, '80.84', 2), 

(10378, 87, 40, '35.80', 1), 

(10379, 23, 39, '156.40', 2), 

(10379, 27, 27, '50.85', 1), 

(10379, 34, 29, '113.52', 5), 

(10379, 46, 32, '134.22', 4), 

(10379, 59, 32, '48.80', 3), 

(10380, 19, 27, '88.36', 13), 

(10380, 29, 40, '119.50', 10), 

(10380, 33, 21, '156.94', 8), 

(10380, 50, 32, '78.23', 1), 

(10380, 55, 24, '66.99', 2), 

(10380, 56, 34, '66.88', 3), 

(10380, 61, 32, '29.87', 4), 

(10380, 64, 27, '37.63', 5), 

(10380, 67, 36, '77.24', 6), 

(10380, 70, 44, '111.57', 7), 

(10380, 73, 44, '77.05', 9), 

(10380, 76, 34, '91.02', 11), 

(10380, 80, 43, '32.82', 12), 

(10381, 2, 36, '182.16', 3), 

(10381, 6, 37, '138.88', 6), 

(10381, 9, 20, '132.57', 1), 

(10381, 17, 48, '114.34', 2), 

(10381, 20, 25, '49.60', 9), 

(10381, 30, 35, '60.77', 7), 

(10381, 35, 41, '100.30', 8), 

(10381, 36, 40, '51.22', 4), 

(10381, 38, 35, '93.20', 5), 

(10382, 8, 34, '166.24', 10), 

(10382, 11, 37, '145.04', 11), 

(10382, 13, 34, '143.61', 12), 

(10382, 15, 32, '103.10', 13), 

(10382, 26, 25, '160.46', 5), 

(10382, 44, 50, '84.33', 7), 

(10382, 52, 39, '115.03', 1), 

(10382, 53, 39, '46.29', 2), 

(10382, 65, 20, '120.12', 3), 

(10382, 82, 33, '97.39', 4), 

(10382, 85, 26, '85.72', 6), 

(10382, 90, 48, '57.53', 8), 

(10382, 103, 34, '101.15', 9), 

(10383, 28, 27, '119.05', 11), 

(10383, 39, 24, '125.66', 9), 

(10383, 40, 47, '155.79', 6), 

(10383, 42, 26, '83.70', 12), 

(10383, 49, 38, '137.88', 1), 

(10383, 51, 28, '77.24', 7), 

(10383, 57, 22, '52.60', 2), 

(10383, 68, 40, '33.24', 3), 

(10383, 81, 21, '117.10', 4), 

(10383, 88, 32, '53.57', 5), 

(10383, 89, 44, '55.93', 8), 

(10383, 94, 29, '94.92', 13), 

(10383, 95, 38, '48.62', 10), 

(10384, 5, 34, '129.20', 4), 

(10384, 63, 28, '114.29', 3), 

(10384, 72, 43, '71.69', 2), 

(10384, 99, 49, '71.02', 1), 

(10385, 77, 37, '78.83', 2), 

(10385, 97, 25, '62.00', 1), 

(10386, 22, 25, '130.88', 7), 

(10386, 31, 21, '72.65', 18), 

(10386, 37, 37, '73.12', 5), 

(10386, 48, 22, '100.58', 6), 

(10386, 60, 33, '101.76', 11), 

(10386, 69, 39, '56.86', 1), 

(10386, 75, 35, '54.57', 9), 

(10386, 79, 41, '55.96', 12), 

(10386, 83, 50, '71.73', 8), 

(10386, 100, 29, '85.09', 13), 

(10386, 101, 37, '90.75', 14), 

(10386, 102, 37, '67.22', 10), 

(10386, 105, 32, '68.00', 17), 

(10386, 106, 45, '83.14', 2), 

(10386, 107, 30, '80.44', 3), 

(10386, 108, 44, '59.22', 15), 

(10386, 109, 50, '47.67', 16), 

(10386, 110, 43, '52.42', 4), 

(10387, 86, 44, '79.91', 1), 

(10388, 1, 42, '80.39', 4), 

(10388, 3, 50, '118.94', 5), 

(10388, 4, 21, '156.86', 7), 

(10388, 10, 44, '125.01', 6), 

(10388, 91, 35, '58.47', 8), 

(10388, 93, 27, '41.02', 1), 

(10388, 98, 46, '74.90', 2), 

(10388, 104, 50, '111.53', 3), 

(10389, 7, 26, '182.90', 4), 

(10389, 12, 25, '95.13', 6), 

(10389, 14, 36, '76.61', 7), 

(10389, 16, 47, '102.49', 8), 

(10389, 24, 49, '63.91', 3), 

(10389, 32, 39, '52.09', 5), 

(10389, 58, 45, '112.70', 1), 

(10389, 62, 49, '61.70', 2), 

(10390, 18, 36, '117.48', 14), 

(10390, 25, 34, '132.29', 15), 

(10390, 29, 31, '102.98', 16), 

(10390, 33, 26, '162.00', 7), 

(10390, 43, 40, '75.59', 9), 

(10390, 45, 50, '135.23', 1), 

(10390, 47, 36, '54.09', 2), 

(10390, 54, 49, '122.02', 3), 

(10390, 66, 35, '67.87', 4), 

(10390, 71, 37, '35.87', 5), 

(10390, 74, 46, '51.43', 6), 

(10390, 78, 45, '134.81', 8), 

(10390, 84, 30, '66.29', 10), 

(10390, 87, 41, '39.02', 11), 

(10390, 92, 45, '101.03', 12), 

(10390, 96, 22, '81.36', 13), 

(10391, 2, 24, '195.01', 4), 

(10391, 6, 37, '121.15', 7), 

(10391, 9, 39, '110.70', 9), 

(10391, 17, 29, '114.34', 10), 

(10391, 19, 35, '102.74', 2), 

(10391, 20, 42, '47.44', 3), 

(10391, 30, 44, '57.73', 5), 

(10391, 35, 32, '99.28', 6), 

(10391, 61, 33, '26.55', 8), 

(10391, 64, 24, '36.29', 1), 

(10392, 36, 37, '61.21', 3), 

(10392, 38, 29, '103.67', 2), 

(10392, 44, 36, '98.22', 1), 

(10393, 11, 35, '145.04', 8), 

(10393, 15, 32, '99.54', 10), 

(10393, 26, 20, '137.53', 11), 

(10393, 28, 38, '104.32', 7), 

(10393, 52, 30, '106.55', 9), 

(10393, 53, 44, '41.76', 1), 

(10393, 65, 33, '112.46', 2), 

(10393, 82, 33, '88.62', 3), 

(10393, 85, 38, '84.75', 4), 

(10393, 90, 31, '63.35', 5), 

(10393, 103, 21, '83.95', 6), 

(10394, 40, 22, '135.47', 5), 

(10394, 49, 37, '124.95', 1), 

(10394, 57, 31, '53.18', 2), 

(10394, 68, 46, '35.36', 6), 

(10394, 81, 37, '104.09', 7), 

(10394, 88, 36, '47.08', 3), 

(10394, 89, 30, '55.93', 4), 

(10395, 5, 32, '125.12', 2), 

(10395, 8, 33, '205.72', 1), 

(10395, 94, 46, '98.39', 4), 

(10395, 95, 45, '57.99', 3), 

(10396, 13, 33, '155.72', 3), 

(10396, 39, 33, '129.76', 2), 

(10396, 42, 24, '91.76', 4), 

(10396, 51, 45, '83.38', 5), 

(10396, 63, 49, '100.77', 6), 

(10396, 72, 27, '77.00', 7), 

(10396, 77, 37, '77.99', 8), 

(10396, 97, 39, '62.00', 1), 

(10397, 99, 32, '69.29', 5), 

(10397, 102, 22, '62.88', 4), 

(10397, 106, 48, '86.15', 3), 

(10397, 107, 36, '80.44', 2), 

(10397, 110, 34, '52.96', 1), 

(10398, 22, 33, '130.88', 11), 

(10398, 31, 34, '82.79', 15), 

(10398, 37, 28, '70.54', 18), 

(10398, 48, 45, '92.11', 17), 

(10398, 60, 43, '100.67', 16), 

(10398, 69, 28, '60.29', 3), 

(10398, 75, 34, '61.15', 13), 

(10398, 79, 41, '56.64', 2), 

(10398, 83, 45, '65.93', 14), 

(10398, 91, 22, '60.54', 4), 

(10398, 93, 49, '38.84', 5), 

(10398, 98, 47, '78.55', 6), 

(10398, 100, 36, '75.13', 7), 

(10398, 101, 22, '98.72', 8), 

(10398, 104, 23, '102.04', 9), 

(10398, 105, 29, '76.80', 10), 

(10398, 108, 36, '62.19', 12), 

(10398, 109, 34, '41.22', 1), 

(10399, 1, 40, '77.52', 8), 

(10399, 3, 51, '99.91', 7), 

(10399, 4, 22, '156.86', 6), 

(10399, 10, 29, '123.51', 5), 

(10399, 32, 30, '51.48', 4), 

(10399, 58, 57, '104.81', 3), 

(10399, 62, 58, '75.41', 2), 

(10399, 86, 32, '97.89', 1), 

(10400, 5, 64, '134.64', 9), 

(10400, 22, 34, '129.31', 1), 

(10400, 37, 30, '74.84', 7), 

(10400, 48, 58, '88.93', 6), 

(10400, 69, 24, '55.49', 2), 

(10400, 75, 38, '59.18', 3), 

(10400, 77, 42, '74.64', 8), 

(10400, 100, 46, '82.37', 5), 

(10400, 109, 20, '41.71', 4), 

(10401, 31, 42, '75.19', 3), 

(10401, 60, 38, '87.54', 5), 

(10401, 79, 64, '59.37', 12), 

(10401, 83, 52, '65.93', 4), 

(10401, 86, 49, '81.91', 1), 

(10401, 91, 62, '62.60', 6), 

(10401, 93, 56, '41.46', 7), 

(10401, 98, 11, '77.64', 8), 

(10401, 101, 85, '98.72', 10), 

(10401, 104, 21, '96.11', 2), 

(10401, 105, 77, '73.60', 9), 

(10401, 108, 40, '66.63', 11), 

(10402, 3, 45, '118.94', 1), 

(10402, 32, 55, '58.15', 2), 

(10402, 62, 59, '61.70', 3), 

(10403, 1, 24, '85.17', 7), 

(10403, 4, 66, '174.29', 9), 

(10403, 10, 66, '122.00', 6), 

(10403, 47, 36, '55.33', 1), 

(10403, 58, 46, '109.32', 8), 

(10403, 66, 27, '57.49', 4), 

(10403, 87, 30, '35.80', 2), 

(10403, 92, 45, '88.78', 5), 

(10403, 96, 31, '65.09', 3), 

(10404, 7, 64, '163.44', 3), 

(10404, 12, 43, '102.17', 1), 

(10404, 14, 77, '67.03', 4), 

(10404, 43, 90, '67.54', 6), 

(10404, 45, 28, '127.88', 5), 

(10404, 54, 48, '124.99', 8), 

(10404, 74, 49, '53.27', 2), 

(10404, 84, 48, '65.48', 7), 

(10405, 16, 97, '115.16', 5), 

(10405, 24, 61, '72.38', 4), 

(10405, 40, 55, '147.33', 1), 

(10405, 71, 47, '37.38', 2), 

(10405, 78, 76, '127.79', 3), 

(10406, 18, 61, '124.56', 3), 

(10406, 25, 48, '133.72', 2), 

(10406, 46, 65, '117.26', 1), 

(10407, 21, 59, '114.48', 11), 

(10407, 23, 76, '141.10', 2), 

(10407, 27, 42, '58.12', 1), 

(10407, 34, 41, '132.00', 12), 

(10407, 50, 6, '91.11', 3), 

(10407, 55, 66, '64.14', 4), 

(10407, 56, 26, '68.35', 8), 

(10407, 59, 64, '45.78', 10), 

(10407, 67, 76, '81.78', 6), 

(10407, 70, 59, '98.65', 5), 

(10407, 73, 13, '77.05', 7), 

(10407, 76, 43, '101.73', 9), 

(10408, 80, 15, '41.03', 1), 

(10409, 29, 6, '104.25', 2), 

(10409, 61, 61, '27.88', 1), 

(10410, 19, 65, '99.66', 7), 

(10410, 20, 44, '51.21', 6), 

(10410, 33, 56, '145.13', 8), 

(10410, 35, 47, '93.21', 1), 

(10410, 36, 53, '49.97', 3), 

(10410, 38, 34, '84.82', 2), 

(10410, 44, 44, '81.35', 5), 

(10410, 64, 31, '42.56', 9), 

(10410, 82, 50, '95.44', 4), 

(10411, 2, 23, '205.73', 9), 

(10411, 6, 27, '144.79', 2), 

(10411, 9, 40, '110.70', 6), 

(10411, 17, 27, '109.67', 8), 

(10411, 52, 46, '106.55', 3), 

(10411, 53, 35, '41.25', 7), 

(10411, 85, 26, '78.01', 1), 

(10411, 90, 27, '60.76', 5), 

(10411, 103, 34, '89.01', 4), 

(10412, 15, 54, '100.73', 5), 

(10412, 26, 41, '150.63', 4), 

(10412, 28, 56, '120.28', 8), 

(10412, 30, 47, '49.83', 11), 

(10412, 40, 60, '157.49', 9), 

(10412, 57, 21, '47.40', 2), 

(10412, 65, 70, '109.90', 10), 

(10412, 68, 30, '32.88', 6), 

(10412, 81, 31, '108.82', 1), 

(10412, 88, 19, '50.86', 7), 

(10412, 94, 26, '105.33', 3), 

(10413, 8, 36, '201.57', 2), 

(10413, 11, 47, '145.04', 3), 

(10413, 13, 22, '173.02', 1), 

(10413, 49, 49, '133.57', 5), 

(10413, 89, 24, '56.55', 6), 

(10413, 95, 51, '53.31', 4), 

(10414, 5, 49, '114.24', 3), 

(10414, 37, 44, '77.42', 1), 

(10414, 39, 41, '128.39', 12), 

(10414, 42, 48, '85.71', 14), 

(10414, 51, 56, '83.38', 11), 

(10414, 63, 43, '108.14', 10), 

(10414, 72, 60, '72.58', 5), 

(10414, 77, 51, '72.96', 2), 

(10414, 97, 37, '62.00', 6), 

(10414, 99, 34, '74.48', 13), 

(10414, 102, 31, '61.44', 4), 

(10414, 106, 28, '84.14', 7), 

(10414, 107, 40, '84.41', 8), 

(10414, 110, 47, '54.60', 9), 

(10415, 48, 51, '86.81', 5), 

(10415, 69, 21, '60.97', 1), 

(10415, 75, 18, '59.83', 2), 

(10415, 100, 32, '73.32', 4), 

(10415, 109, 42, '43.20', 3), 

(10416, 22, 24, '129.31', 14), 

(10416, 31, 15, '70.96', 4), 

(10416, 60, 47, '90.82', 6), 

(10416, 62, 32, '62.46', 1), 

(10416, 79, 18, '64.83', 13), 

(10416, 83, 48, '70.28', 5), 

(10416, 86, 45, '86.90', 2), 

(10416, 91, 26, '68.10', 7), 

(10416, 93, 37, '39.71', 8), 

(10416, 98, 23, '88.60', 9), 

(10416, 101, 22, '84.76', 11), 

(10416, 104, 41, '98.48', 3), 

(10416, 105, 39, '65.60', 10), 

(10416, 108, 43, '63.67', 12), 

(10417, 1, 66, '79.43', 2), 

(10417, 3, 45, '116.56', 5), 

(10417, 4, 56, '162.67', 4), 

(10417, 10, 21, '144.60', 1), 

(10417, 32, 36, '58.75', 6), 

(10417, 58, 35, '109.32', 3), 

(10418, 43, 16, '70.76', 2), 

(10418, 45, 27, '139.64', 1), 

(10418, 47, 33, '56.57', 5), 

(10418, 54, 28, '120.53', 4), 

(10418, 66, 52, '64.41', 8), 

(10418, 84, 10, '66.29', 3), 

(10418, 87, 43, '36.61', 6), 

(10418, 92, 50, '100.01', 9), 

(10418, 96, 40, '72.41', 7), 

(10419, 7, 12, '182.90', 13), 

(10419, 12, 10, '111.57', 11), 

(10419, 14, 34, '64.64', 14), 

(10419, 16, 32, '99.04', 10), 

(10419, 18, 38, '117.48', 5), 

(10419, 21, 37, '100.80', 1), 

(10419, 24, 39, '67.76', 9), 

(10419, 25, 34, '133.72', 4), 

(10419, 34, 55, '116.16', 2), 

(10419, 40, 35, '165.95', 6), 

(10419, 46, 43, '114.44', 3), 

(10419, 71, 15, '32.10', 7), 

(10419, 74, 55, '52.66', 12), 

(10419, 78, 70, '112.34', 8), 

(10420, 23, 37, '153.00', 5), 

(10420, 27, 36, '52.06', 4), 

(10420, 29, 45, '116.96', 2), 

(10420, 50, 66, '73.62', 6), 

(10420, 55, 36, '68.42', 7), 

(10420, 56, 60, '60.26', 11), 

(10420, 59, 37, '48.80', 13), 

(10420, 61, 45, '32.19', 1), 

(10420, 67, 39, '76.33', 9), 

(10420, 70, 55, '115.09', 8), 

(10420, 73, 35, '77.05', 10), 

(10420, 76, 26, '104.94', 12), 

(10420, 80, 15, '35.29', 3), 

(10421, 33, 35, '167.06', 1), 

(10421, 64, 40, '44.80', 2), 

(10422, 19, 51, '91.44', 2), 

(10422, 20, 25, '47.44', 1), 

(10423, 35, 10, '89.15', 1), 

(10423, 36, 31, '56.21', 3), 

(10423, 38, 21, '98.44', 2), 

(10423, 44, 21, '80.36', 5), 

(10423, 82, 28, '78.89', 4), 

(10424, 2, 50, '201.44', 6), 

(10424, 9, 49, '121.64', 3), 

(10424, 17, 54, '108.50', 5), 

(10424, 53, 26, '40.25', 4), 

(10424, 90, 44, '54.94', 2), 

(10424, 103, 46, '85.98', 1), 

(10425, 6, 38, '131.49', 12), 

(10425, 15, 33, '95.99', 4), 

(10425, 26, 28, '147.36', 3), 

(10425, 28, 38, '117.82', 7), 

(10425, 30, 19, '48.62', 10), 

(10425, 40, 28, '140.55', 8), 

(10425, 52, 38, '107.76', 13), 

(10425, 57, 55, '53.75', 1), 

(10425, 65, 49, '127.79', 9), 

(10425, 68, 31, '31.82', 5), 

(10425, 85, 41, '83.79', 11), 

(10425, 88, 11, '50.32', 6), 

(10425, 94, 18, '94.92', 2) ON DUPLICATE KEY UPDATE `orderdetail_id`=`orderdetail_id`;

/* Data for the table `payment` */

insert into `payment`(`customer_number`, `check_number`, `payment_date`, `invoice_amount`, `caching_date`) values 

(103, 'HQ336336', '2004-10-19 12:00:01', '6066.78', '2004-10-19 12:30:15'), 

(103, 'JM555205', '2003-06-05 11:25:25', '14571.44', '2003-06-05 12:34:15'), 

(103, 'OM314933', '2004-12-18 15:10:25', '1676.14', '2004-12-18 16:30:15'), 

(112, 'BO864823', '2004-12-17 12:30:15', '14191.12', '2004-12-17 12:32:15'), 

(112, 'HQ55022', '2003-06-06 04:10:15', '32641.98', '2003-06-06 19:22:45'), 

(112, 'ND748579', '2004-08-20 07:10:15', '33347.88', '2004-08-20 09:09:09'), 

(114, 'GG31455', '2003-05-20 08:10:45', '45864.03', '2003-05-20 08:30:09'), 

(114, 'MA765515', '2004-12-15 16:12:15', '82261.22', '2004-12-15 18:30:15'), 

(114, 'NP603840', '2003-05-31 18:32:15', '7565.08', '2003-05-31 20:31:31'), 

(114, 'NR27552', '2004-03-10 07:20:21', '44894.74', '2004-03-10 12:33:34'), 

(119, 'DB933704', '2004-11-14 11:10:15', '19501.82', '2004-11-14 11:43:27'), 

(119, 'LN373447', '2004-08-08 09:30:15', '47924.19', '2004-08-08 10:30:15'), 

(119, 'NG94694', '2005-02-22 23:20:15', '49523.67', '2005-02-22 01:22:22'), 

(121, 'DB889831', '2003-02-16 06:30:15', '50218.95', '2003-02-16 08:30:15'), 

(121, 'FD317790', '2003-10-28 11:37:35', '1491.38', '2003-10-28 11:38:15'), 

(121, 'KI831359', '2004-11-04 11:20:22', '17876.32', '2004-11-04 11:45:13'), 

(121, 'MA302151', '2004-11-28 15:01:15', '34638.14', '2004-11-28 17:03:16'), 

(124, 'AE215433', '2005-03-05 09:01:03', '101244.59', '2005-03-05 10:00:15'), 

(124, 'BG255406', '2004-08-28 18:22:32', '85410.87', '2004-08-28 19:30:15'), 

(124, 'CQ287967', '2003-04-11 17:04:11', '11044.30', '2003-04-11 17:30:22'), 

(124, 'ET64396', '2005-04-16 19:18:15', '83598.04', '2005-04-16 21:30:15'), 

(124, 'HI366474', '2004-12-27 21:33:42', '47142.70', '2004-12-27 23:10:11'), 

(124, 'HR86578', '2004-11-02 18:32:15', '55639.66', '2004-11-02 19:30:15'), 

(124, 'KI131716', '2003-08-15 10:02:15', '111654.40', '2003-08-15 12:30:15'), 

(124, 'LF217299', '2004-03-26 10:34:22', '43369.30', '2004-03-26 10:38:56'), 

(124, 'NT141748', '2003-11-25 08:30:15', '45084.38', '2003-11-25 09:30:15'), 

(128, 'DI925118', '2003-01-28 11:10:15', '10549.01', '2003-01-28 12:30:15'), 

(128, 'FA465482', '2003-10-18 18:22:25', '24101.81', '2003-10-18 22:03:12'), 

(128, 'FH668230', '2004-03-24 13:12:15', '33820.62', '2004-03-24 14:30:15'), 

(128, 'IP383901', '2004-11-18 14:30:15', '7466.32', '2004-11-18 15:30:15'), 

(129, 'DM826140', '2004-12-08 14:30:15', '26248.78', '2004-12-08 15:30:15'), 

(129, 'ID449593', '2003-12-11 14:30:15', '23923.93', '2003-12-11 15:30:15'), 

(129, 'PI42991', '2003-04-09 09:21:25', '16537.85', '2003-04-09 12:30:15'), 

(131, 'CL442705', '2003-03-12 10:10:15', '22292.62', '2003-03-12 12:30:15'), 

(131, 'MA724562', '2004-12-02 16:33:44', '50025.35', '2004-12-02 17:31:15'), 

(131, 'NB445135', '2004-09-11 12:30:15', '35321.97', '2004-09-11 12:32:15'), 

(141, 'AU364101', '2003-07-19 01:32:15', '36251.03', '2003-07-19 03:03:22'), 

(141, 'DB583216', '2004-11-01 05:20:15', '36140.38', '2004-11-01 07:30:15'), 

(141, 'DL460618', '2005-05-19 12:30:15', '46895.48', '2005-05-19 16:30:15'), 

(141, 'HJ32686', '2004-01-30 12:55:15', '59830.55', '2004-01-30 13:30:15'), 

(141, 'ID10962', '2004-12-31 10:01:02', '116208.40', '2004-12-31 11:11:25'), 

(141, 'IN446258', '2005-03-25 11:12:22', '65071.26', '2005-03-25 12:04:22'), 

(141, 'JE105477', '2005-03-18 11:55:15', '120166.58', '2005-03-18 12:30:15'), 

(141, 'JN355280', '2003-10-26 12:36:15', '49539.37', '2003-10-26 12:39:15'), 

(141, 'JN722010', '2003-02-25 17:11:33', '40206.20', '2003-02-25 18:33:27'), 

(141, 'KT52578', '2003-12-09 08:30:15', '63843.55', '2003-12-09 12:22:43'), 

(141, 'MC46946', '2004-07-09 16:12:22', '35420.74', '2004-07-09 16:30:15'), 

(141, 'MF629602', '2004-08-16 11:21:22', '20009.53', '2004-08-16 12:36:05'), 

(141, 'NU627706', '2004-05-17 12:30:15', '26155.91', '2004-05-17 19:30:15'), 

(144, 'IR846303', '2004-12-12 10:22:21', '36005.71', '2004-12-12 12:38:15'), 

(144, 'LA685678', '2003-04-09 12:38:15', '7674.94', '2003-04-09 12:39:15'), 

(145, 'CN328545', '2004-07-03 11:22:15', '4710.73', '2004-07-03 12:30:15'), 

(145, 'ED39322', '2004-04-26 22:32:15', '28211.70', '2004-04-26 22:30:33'), 

(145, 'HR182688', '2004-12-01 22:36:15', '20564.86', '2004-12-01 23:30:15'), 

(145, 'JJ246391', '2003-02-20 12:30:15', '53959.21', '2003-02-20 19:30:15'), 

(146, 'FP549817', '2004-03-18 11:30:15', '40978.53', '2004-03-18 12:30:15'), 

(146, 'FU793410', '2004-01-16 08:30:15', '49614.72', '2004-01-16 12:30:15'), 

(146, 'LJ160635', '2003-12-10 11:31:02', '39712.10', '2003-12-10 12:02:15'), 

(148, 'BI507030', '2003-04-22 09:30:15', '44380.15', '2003-04-22 10:30:15'), 

(148, 'DD635282', '2004-08-11 10:10:12', '2611.84', '2004-08-11 10:10:22'), 

(148, 'KM172879', '2003-12-26 12:32:15', '105743.00', '2003-12-26 12:41:15'), 

(148, 'ME497970', '2005-03-27 12:42:15', '3516.04', '2005-03-27 12:55:15'), 

(151, 'BF686658', '2003-12-22 05:30:15', '58793.53', '2003-12-22 09:21:02'), 

(151, 'GB852215', '2004-07-26 14:14:15', '20314.44', '2004-07-26 15:32:15'), 

(151, 'IP568906', '2003-06-18 15:30:15', '58841.35', '2003-06-18 15:30:33'), 

(151, 'KI884577', '2004-12-14 12:30:15', '39964.63', '2004-12-14 14:30:15'), 

(157, 'HI618861', '2004-11-19 14:12:15', '35152.12', '2004-11-19 15:30:15'), 

(157, 'NN711988', '2004-09-07 12:30:15', '63357.13', '2004-09-07 12:31:15'), 

(161, 'BR352384', '2004-11-14 15:02:12', '2434.25', '2004-11-14 15:40:25'), 

(161, 'BR478494', '2003-11-18 15:55:15', '50743.65', '2003-11-18 16:30:15'), 

(161, 'KG644125', '2005-02-02 16:30:15', '12692.19', '2005-02-02 18:01:00'), 

(161, 'NI908214', '2003-08-05 18:00:00', '38675.13', '2003-08-05 19:00:03'), 

(166, 'BQ327613', '2004-09-16 21:01:15', '38785.48', '2004-09-16 22:30:22'), 

(166, 'DC979307', '2004-07-07 12:30:15', '44160.92', '2004-07-07 17:30:15'), 

(166, 'LA318629', '2004-02-28 08:30:15', '22474.17', '2004-02-28 09:30:15'), 

(167, 'ED743615', '2004-09-19 13:00:15', '12538.01', '2004-09-19 14:36:44'), 

(167, 'GN228846', '2003-12-03 16:02:02', '85024.46', '2003-12-03 17:11:15'), 

(171, 'GB878038', '2004-03-15 01:30:15', '18997.89', '2004-03-15 02:32:15'), 

(171, 'IL104425', '2003-11-22 09:08:15', '42783.81', '2003-11-22 11:30:15'), 

(172, 'AD832091', '2004-09-09 10:10:11', '1960.80', '2004-09-09 11:10:11'), 

(172, 'CE51751', '2004-12-04 11:11:15', '51209.58', '2004-12-04 12:30:15'), 

(172, 'EH208589', '2003-04-20 13:33:13', '33383.14', '2003-04-20 13:17:15'), 

(173, 'GP545698', '2004-05-13 12:30:15', '11843.45', '2004-05-13 12:32:15'), 

(173, 'IG462397', '2004-03-29 12:30:15', '20355.24', '2004-03-29 12:33:15'), 

(175, 'CITI3434344', '2005-05-19 12:30:15', '28500.78', '2005-05-19 12:34:15'), 

(175, 'IO448913', '2003-11-19 11:02:15', '24879.08', '2003-11-19 12:30:15'), 

(175, 'PI15215', '2004-07-10 15:33:15', '42044.77', '2004-07-10 15:38:33'), 

(177, 'AU750837', '2004-04-17 17:21:21', '15183.63', '2004-04-17 17:22:23'), 

(177, 'CI381435', '2004-01-19 17:20:15', '47177.59', '2004-01-19 18:12:12'), 

(181, 'CM564612', '2004-04-25 16:06:15', '22602.36', '2004-04-25 16:20:15'), 

(181, 'GQ132144', '2003-01-30 11:21:25', '5494.78', '2003-01-30 12:30:15'), 

(181, 'OH367219', '2004-11-16 11:11:11', '44400.50', '2004-11-16 12:50:15'), 

(186, 'AE192287', '2005-03-10 12:43:45', '23602.90', '2005-03-10 13:31:15'), 

(186, 'AK412714', '2003-10-27 11:11:12', '37602.48', '2003-10-27 12:39:15'), 

(186, 'KA602407', '2004-10-21 17:22:22', '34341.08', '2004-10-21 17:31:12'), 

(187, 'AM968797', '2004-11-03 18:32:10', '52825.29', '2004-11-03 18:30:01'), 

(187, 'BQ39062', '2004-12-08 13:55:33', '47159.11', '2004-12-08 13:22:22'), 

(187, 'KL124726', '2003-03-27 12:08:15', '48425.69', '2003-03-27 12:10:15'), 

(189, 'BO711618', '2004-10-03 08:30:15', '17359.53', '2004-10-03 09:30:15'), 

(189, 'NM916675', '2004-03-01 11:31:15', '32538.74', '2004-03-01 12:04:15'), 

(198, 'FI192930', '2004-12-06 10:21:12', '9658.74', '2004-12-06 10:30:59'), 

(198, 'HQ920205', '2003-07-06 13:33:15', '6036.96', '2003-07-06 17:31:15'), 

(198, 'IS946883', '2004-09-21 17:33:15', '5858.56', '2004-09-21 02:30:15'), 

(201, 'DP677013', '2003-10-20 18:29:22', '23908.24', '2003-10-20 18:47:12'), 

(201, 'OO846801', '2004-06-15 15:32:15', '37258.94', '2004-06-15 15:39:15'), 

(202, 'HI358554', '2003-12-18 09:30:05', '36527.61', '2003-12-18 12:30:45'), 

(202, 'IQ627690', '2004-11-08 07:09:15', '33594.58', '2004-11-08 12:34:15'), 

(204, 'GC697638', '2004-08-13 14:30:15', '51152.86', '2004-08-13 15:30:15'), 

(204, 'IS150005', '2004-09-24 12:30:15', '4424.40', '2004-09-24 12:30:15'), 

(205, 'GL756480', '2003-12-04 11:11:44', '3879.96', '2003-12-04 12:44:44'), 

(205, 'LL562733', '2003-09-05 15:34:33', '50342.74', '2003-09-05 16:37:15'), 

(205, 'NM739638', '2005-02-06 15:36:25', '39580.60', '2005-02-06 16:36:13'), 

(209, 'BOAF82044', '2005-05-03 15:32:15', '35157.75', '2005-05-03 16:30:15'), 

(209, 'ED520529', '2004-06-21 22:31:15', '4632.31', '2004-06-21 23:30:15'), 

(209, 'PH785937', '2004-05-04 22:12:12', '36069.26', '2004-05-04 22:31:15'), 

(211, 'BJ535230', '2003-12-09 23:30:15', '45480.79', '2003-12-09 23:59:35'), 

(216, 'BG407567', '2003-05-09 21:02:15', '3101.40', '2003-05-09 23:09:05'), 

(216, 'ML780814', '2004-12-06 12:33:15', '24945.21', '2004-12-06 22:30:15'), 

(216, 'MM342086', '2003-12-14 03:30:15', '40473.86', '2003-12-14 04:30:15'), 

(219, 'BN17870', '2005-03-02 12:22:02', '3452.75', '2005-03-02 13:30:33'), 

(219, 'BR941480', '2003-10-18 06:22:15', '4465.85', '2003-10-18 08:33:22'), 

(227, 'MQ413968', '2003-10-31 16:12:12', '36164.46', '2003-10-31 17:30:15'), 

(227, 'NU21326', '2004-11-02 06:02:02', '53745.34', '2004-11-02 06:32:05'), 

(233, 'BOFA23232', '2005-05-20 06:32:12', '29070.38', '2005-05-20 12:30:22'), 

(233, 'II180006', '2004-07-01 04:32:15', '22997.45', '2004-07-01 07:03:25'), 

(233, 'JG981190', '2003-11-18 07:08:22', '16909.84', '2003-11-18 10:31:25'), 

(239, 'NQ865547', '2004-03-15 15:12:12', '80375.24', '2004-03-15 15:41:00'), 

(240, 'IF245157', '2004-11-16 13:43:13', '46788.14', '2004-11-16 13:46:13'), 

(240, 'JO719695', '2004-03-28 17:55:15', '24995.61', '2004-03-28 18:30:15'), 

(242, 'AF40894', '2003-11-22 12:30:15', '33818.34', '2003-11-22 12:50:15'), 

(242, 'HR224331', '2005-06-03 02:32:00', '12432.32', '2005-06-03 11:30:00'), 

(242, 'KI744716', '2003-07-21 04:44:45', '14232.70', '2003-07-21 06:33:25'), 

(249, 'IJ399820', '2004-09-19 04:02:15', '33924.24', '2004-09-19 04:22:15'), 

(249, 'NE404084', '2004-09-04 12:30:15', '48298.99', '2004-09-04 12:30:56'), 

(250, 'EQ12267', '2005-05-17 09:32:15', '17928.09', '2005-05-17 10:11:15'), 

(250, 'HD284647', '2004-12-30 10:30:15', '26311.63', '2004-12-30 10:38:35'), 

(250, 'HN114306', '2003-07-18 11:20:25', '23419.47', '2003-07-18 12:39:15'), 

(256, 'EP227123', '2004-02-10 16:32:25', '5759.42', '2004-02-10 17:32:15'), 

(256, 'HE84936', '2004-10-22 17:31:25', '53116.99', '2004-10-22 17:37:15'), 

(259, 'EU280955', '2004-11-06 10:02:15', '61234.67', '2004-11-06 12:30:15'), 

(259, 'GB361972', '2003-12-07 10:22:02', '27988.47', '2003-12-07 11:30:15'), 

(260, 'IO164641', '2004-08-30 11:02:22', '37527.58', '2004-08-30 14:33:13'), 

(260, 'NH776924', '2004-04-24 14:11:23', '29284.42', '2004-04-24 14:38:00'), 

(276, 'EM979878', '2005-02-09 15:32:22', '27083.78', '2005-02-09 17:33:15'), 

(276, 'KM841847', '2003-11-13 01:00:15', '38547.19', '2003-11-13 03:12:00'), 

(276, 'LE432182', '2003-09-28 12:30:15', '41554.73', '2003-09-28 12:44:15'), 

(276, 'OJ819725', '2005-04-30 03:33:15', '29848.52', '2005-04-30 03:37:12'), 

(278, 'BJ483870', '2004-12-05 02:02:02', '37654.09', '2004-12-05 06:30:43'), 

(278, 'GP636783', '2003-03-02 11:32:12', '52151.81', '2003-03-02 12:32:00'), 

(278, 'NI983021', '2003-11-24 16:10:15', '37723.79', '2003-11-24 16:22:12'), 

(282, 'IA793562', '2003-08-03 16:23:12', '24013.52', '2003-08-03 18:37:17'), 

(282, 'JT819493', '2004-08-02 12:30:15', '35806.73', '2004-08-02 12:30:45'), 

(282, 'OD327378', '2005-01-03 22:30:15', '31835.36', '2005-01-03 23:30:15'), 

(286, 'DR578578', '2004-10-28 12:34:15', '47411.33', '2004-10-28 12:39:15'), 

(286, 'KH910279', '2004-09-05 11:32:15', '43134.04', '2004-09-05 11:36:12'), 

(298, 'AJ574927', '2004-03-13 17:30:15', '47375.92', '2004-03-13 20:30:15'), 

(298, 'LF501133', '2004-09-18 14:33:15', '61402.00', '2004-09-18 16:30:15'), 

(299, 'AD304085', '2003-10-24 19:19:15', '36798.88', '2003-10-24 19:30:13'), 

(299, 'NR157385', '2004-09-05 19:02:10', '32260.16', '2004-09-05 20:02:12'), 

(311, 'DG336041', '2005-02-15 18:37:15', '46770.52', '2005-02-15 18:38:15'), 

(311, 'FA728475', '2003-10-06 11:32:12', '32723.04', '2003-10-06 18:53:12'), 

(311, 'NQ966143', '2004-04-25 09:20:22', '16212.59', '2004-04-25 11:37:22'), 

(314, 'LQ244073', '2004-08-09 06:12:12', '45352.47', '2004-08-09 12:30:15'), 

(314, 'MD809704', '2004-03-03 02:30:15', '16901.38', '2004-03-03 12:30:15'), 

(319, 'HL685576', '2004-11-06 14:34:45', '42339.76', '2004-11-06 19:32:15'), 

(319, 'OM548174', '2003-12-07 12:44:15', '36092.40', '2003-12-07 13:30:15'), 

(320, 'GJ597719', '2005-01-18 17:12:12', '8307.28', '2005-01-18 18:32:00'), 

(320, 'HO576374', '2003-08-20 16:30:12', '41016.75', '2003-08-20 17:10:15'), 

(320, 'MU817160', '2003-11-24 14:37:13', '52548.49', '2003-11-24 16:10:00'), 

(321, 'DJ15149', '2003-11-03 13:11:11', '85559.12', '2003-11-12 14:30:15'), 

(321, 'LA556321', '2005-03-15 09:44:12', '46781.66', '2005-03-15 09:46:15'), 

(323, 'AL493079', '2005-05-23 09:23:25', '75020.13', '2005-05-23 09:30:00'), 

(323, 'ES347491', '2004-06-24 08:32:12', '37281.36', '2004-06-24 09:11:15'), 

(323, 'HG738664', '2003-07-05 12:39:00', '2880.00', '2003-07-05 13:00:00'), 

(323, 'PQ803830', '2004-12-24 02:45:15', '39440.59', '2004-12-24 02:55:15'), 

(324, 'DQ409197', '2004-12-13 01:01:25', '13671.82', '2004-12-13 03:30:00'), 

(324, 'FP443161', '2003-07-07 12:30:15', '29429.14', '2003-07-07 12:35:15'), 

(324, 'HB150714', '2003-11-23 11:30:15', '37455.77', '2003-11-23 12:30:15'), 

(328, 'EN930356', '2004-04-16 20:02:15', '7178.66', '2004-04-16 21:45:10'), 

(328, 'NR631421', '2004-05-30 20:12:05', '31102.85', '2004-05-30 20:34:35'), 

(333, 'HL209210', '2003-11-15 12:30:15', '23936.53', '2003-11-15 12:30:17'), 

(333, 'JK479662', '2003-10-17 09:32:15', '9821.32', '2003-10-17 12:30:15'), 

(333, 'NF959653', '2005-03-01 19:10:01', '21432.31', '2005-03-01 19:32:56'), 

(334, 'CS435306', '2005-01-27 16:20:25', '45785.34', '2005-01-27 16:39:15'), 

(334, 'HH517378', '2003-08-16 16:30:12', '29716.86', '2003-08-16 16:30:35'), 

(334, 'LF737277', '2004-05-22 16:33:13', '28394.54', '2004-05-22 16:39:25'), 

(339, 'AP286625', '2004-10-24 02:02:33', '23333.06', '2004-10-24 04:33:21'), 

(339, 'DA98827', '2003-11-28 12:30:15', '34606.28', '2003-11-28 12:30:15'), 

(344, 'AF246722', '2003-11-24 14:33:15', '31428.21', '2003-11-24 15:03:00'), 

(344, 'NJ906924', '2004-04-02 12:32:15', '15322.93', '2004-04-02 12:34:15'), 

(347, 'DG700707', '2004-01-18 12:30:15', '21053.69', NULL), 

(347, 'LG808674', '2003-10-24 11:56:15', '20452.50', '2003-10-24 12:33:15'), 

(350, 'BQ602907', '2004-12-11 02:22:15', '18888.31', '2004-12-11 12:30:15'), 

(350, 'CI471510', '2003-05-25 12:30:12', '50824.66', '2003-05-25 12:30:19'), 

(350, 'OB648482', '2005-01-29 12:34:15', '1834.56', '2005-01-29 12:38:15'), 

(353, 'CO351193', '2005-01-10 14:10:15', '49705.52', '2005-01-10 14:30:15'), 

(353, 'ED878227', '2003-07-21 13:21:12', '13920.26', '2003-07-21 13:30:15'), 

(353, 'GT878649', '2003-05-21 13:02:15', '16700.47', '2003-05-21 13:05:15'), 

(353, 'HJ618252', '2005-06-09 12:55:25', '46656.94', '2005-06-09 13:31:25'), 

(357, 'AG240323', '2003-12-16 11:54:15', '20220.04', '2003-12-16 12:02:15'), 

(357, 'NB291497', '2004-05-15 11:02:12', '36442.34', '2004-05-15 11:30:25'), 

(362, 'FP170292', '2004-07-11 12:30:15', '18473.71', '2004-07-11 21:30:15'), 

(362, 'OG208861', '2004-09-21 11:31:15', '15059.76', '2004-09-21 14:14:15'), 

(363, 'HL575273', '2004-11-17 19:21:12', '50799.69', '2004-11-17 21:20:12'), 

(363, 'IS232033', '2003-01-16 19:11:11', '10223.83', '2003-01-16 19:30:22'), 

(363, 'PN238558', '2003-12-05 18:20:15', '55425.77', '2003-12-05 19:30:15'), 

(379, 'CA762595', '2005-02-12 11:30:15', '28322.83', '2005-02-12 14:30:15'), 

(379, 'FR499138', '2003-09-16 15:31:15', '32680.31', '2003-09-16 17:02:22'), 

(379, 'GB890854', '2004-08-02 11:22:33', '12530.51', '2004-08-02 12:30:15'), 

(381, 'BC726082', '2004-12-03 22:32:15', '12081.52', '2004-12-03 04:30:15'), 

(381, 'CC475233', '2003-04-19 01:02:15', '1627.56', '2003-04-19 02:31:15'), 

(381, 'GB117430', '2005-02-03 12:37:15', '14379.90', '2005-03-05 12:44:15'), 

(381, 'MS154481', '2003-08-22 02:30:15', '1128.20', '2003-08-22 03:30:15'), 

(382, 'CC871084', '2003-05-12 23:01:15', '35826.33', '2003-05-12 23:30:15'), 

(382, 'CT821147', '2004-08-01 21:02:15', '6419.84', '2004-08-01 22:30:15'), 

(382, 'PH29054', '2004-11-27 17:03:05', '42813.83', '2004-11-27 21:22:58'), 

(385, 'BN347084', '2003-12-02 02:22:02', '20644.24', '2003-12-02 06:30:15'), 

(385, 'CP804873', '2004-11-19 10:30:15', '15822.84', '2004-11-19 12:30:15'), 

(385, 'EK785462', '2003-03-09 11:11:15', '51001.22', '2003-03-09 13:45:21'), 

(386, 'DO106109', '2003-11-18 11:32:22', '38524.29', '2003-11-18 12:30:15'), 

(386, 'HG438769', '2004-07-18 09:30:15', '51619.02', '2004-07-18 10:30:15'), 

(398, 'AJ478695', '2005-02-14 08:08:02', '33967.73', '2005-02-14 12:09:15'), 

(398, 'DO787644', '2004-06-21 05:32:15', '22037.91', '2004-06-21 09:31:01'), 

(398, 'JPMR4544', '2005-05-18 04:30:25', '615.45', '2005-05-18 11:30:15'), 

(398, 'KB54275', '2004-11-29 21:21:21', '48927.64', '2004-11-29 22:30:15'), 

(406, 'BJMPR4545', '2005-04-23 16:21:21', '12190.85', '2005-04-23 16:32:08'), 

(406, 'HJ217687', '2004-01-28 14:03:05', '49165.16', '2004-01-28 14:30:45'), 

(406, 'NA197101', '2004-06-17 17:20:15', '25080.96', '2004-06-17 18:02:25'), 

(412, 'GH197075', '2004-07-25 13:05:02', '35034.57', '2004-07-25 14:54:25'), 

(412, 'PJ434867', '2004-04-14 12:39:15', '31670.37', '2004-04-14 13:33:15'), 

(415, 'ER54537', '2004-09-28 11:21:25', '31310.09', '2004-09-28 12:37:15'), 

(424, 'KF480160', '2004-12-07 19:03:15', '25505.98', '2004-12-07 20:30:45'), 

(424, 'LM271923', '2003-04-16 19:11:12', '21665.98', '2003-04-18 20:32:35'), 

(424, 'OA595449', '2003-10-31 17:12:22', '22042.37', '2003-10-31 17:30:15'), 

(447, 'AO757239', '2003-09-15 17:21:15', '6631.36', '2003-09-15 18:22:54'), 

(447, 'ER615123', '2003-06-25 12:30:15', '17032.29', '2003-06-25 17:30:15'), 

(447, 'OU516561', '2004-12-17 15:05:33', '26304.13', '2004-12-17 16:45:22'), 

(448, 'FS299615', '2005-04-18 12:30:15', '27966.54', '2005-04-18 15:30:15'), 

(448, 'KR822727', '2004-09-30 08:30:15', '48809.90', '2004-09-30 09:30:15'), 

(450, 'EF485824', '2004-06-21 22:30:15', '59551.38', '2004-06-21 22:31:15'), 

(452, 'ED473873', '2003-11-15 11:11:15', '27121.90', '2003-11-15 11:11:21'), 

(452, 'FN640986', '2003-11-20 18:22:22', '15130.97', '2003-11-20 18:30:15'), 

(452, 'HG635467', '2005-05-03 11:44:04', '8807.12', '2005-05-03 12:03:21'), 

(455, 'HA777606', '2003-12-05 02:30:15', '38139.18', '2003-12-05 03:30:15'), 

(455, 'IR662429', '2004-05-12 16:16:15', '32239.47', '2004-05-12 17:30:15'), 

(456, 'GJ715659', '2004-11-13 16:21:22', '27550.51', '2004-11-13 16:23:22'), 

(456, 'MO743231', '2004-04-30 12:30:15', '1679.92', '2004-04-30 13:33:15'), 

(458, 'DD995006', '2004-11-15 05:34:44', '33145.56', '2004-11-15 05:47:21'), 

(458, 'NA377824', '2004-02-06 06:21:15', '22162.61', '2004-02-06 06:30:15'), 

(458, 'OO606861', '2003-06-13 04:31:15', '57131.92', '2003-06-13 12:12:15'), 

(462, 'ED203908', '2005-04-15 12:32:15', '30293.77' , '2005-04-25 12:34:15'), 

(462, 'GC60330', '2003-11-08 17:21:15', '9977.85', '2003-11-08 18:57:25'), 

(462, 'PE176846', '2004-11-27 13:05:15', '48355.87', '2004-11-27 14:30:22'), 

(471, 'AB661578', '2004-07-28 06:30:15', '9415.13', '2004-07-28 08:33:15'), 

(471, 'CO645196', '2003-12-10 10:20:15', '35505.63', '2003-12-10 10:30:15'), 

(473, 'LL427009', '2004-02-17 13:33:44', '7612.06', '2004-02-17 14:31:00'), 

(473, 'PC688499', '2003-10-27 07:07:07', '17746.26', '2003-10-27 08:22:15'), 

(475, 'JP113227', '2003-12-09 16:02:15', '7678.25', '2003-12-09 16:30:33'), 

(475, 'PB951268', '2004-02-13 07:30:15', '36070.47', '2004-02-13 12:30:15'), 

(484, 'GK294076', '2004-10-26 08:08:15', '3474.66', '2004-10-26 12:11:15'), 

(484, 'JH546765', '2003-11-29 11:55:25', '47513.19', '2003-11-29 11:57:15'), 

(486, 'BL66528', '2004-04-14 04:20:12', '5899.38', '2004-04-14 12:45:01'), 

(486, 'HS86661', '2004-11-23 21:21:15', '45994.07', '2004-11-23 21:30:15'), 

(486, 'JB117768', '2003-03-20 14:02:15', '25833.14', '2003-03-20 16:21:21'), 

(487, 'AH612904', '2003-09-28 11:10:11', '29997.09', '2003-09-28 16:32:15'), 

(487, 'PT550181', '2004-02-29 09:30:15', '12573.28', NULL), 

(489, 'OC773849', '2003-12-04 22:06:15', '22275.73', '2003-12-04 22:08:12'), 

(489, 'PO860906', '2004-01-31 05:20:15', '7310.42', '2004-01-31 07:30:25'), 

(495, 'BH167026', '2003-12-26 13:33:13', '59265.14', '2003-12-26 15:38:09'), 

(495, 'FN155234', '2004-05-14 12:37:35', '6276.60', '2004-05-14 12:39:25'), 

(496, 'EU531600', '2005-05-25 02:47:35', '30253.75', '2005-05-25 03:30:15'), 

(496, 'MB342426', '2003-07-16 21:10:15', '32077.44', '2003-07-16 23:04:15'), 

(496, 'MN89921', '2004-12-31 09:02:11', '52166.00', '2004-12-31 09:02:11') ON DUPLICATE KEY UPDATE `customer_number`=`customer_number`;

/* Data for the table `bank_transaction` */

insert into `bank_transaction`(`transaction_id`, `bank_name`, `bank_iban`, `transfer_amount`, `customer_number`, `check_number`, `caching_date`, `card_type`, `status`) values 

(1, 'Bank Ltd. US', 'DN44398834N34', '6631.36', 447, 'AO757239', '2003-09-15 18:22:54', 'VisaElectron', 'SUCCESS'), 

(2, 'Bank Ltd. US', '348398H3493HG93', '26304.13', 447, 'OU516561', '2004-12-17 16:45:22', 'VisaElectron', 'FAILED'), 

(3, 'Transilvania Bank', '8TVN598N454VN84T', '9977.85', 462, 'GC60330', '2003-11-08 18:57:25', 'VisaElectron', 'SUCCESS'), 

(4, '5 Stars Bank', '8VN8UNT5U45T8', '48355.87', 462, 'PE176846', '2004-11-27 14:30:22', 'VisaElectron', 'SUCCESS'), 

(5, '5 Stars Bank', 'TVU58NU58U84N4YUG', '33967.73', 398, 'AJ478695', '2005-02-14 12:09:15', 'VisaElectron', 'FAILED'), 

(6, 'Optimus Bank', '8V34VN5U435334', '4588.36', 333, 'NF959653', '2005-03-01 12:12:00', 'VisaElectron', 'UNAUTHORIZED'), 

(7, 'Optimus Bank', '8V34VN5U435334', '8987.36', 333, 'NF959653', '2005-03-01 14:00:00', 'MasterCard', 'UNAUTHORIZED'), 

(8, 'Optimus Bank', '8V34VN5U435334', '2544.36', 333, 'NF959653', '2005-03-01 18:20:10', 'VisaElectron', 'FAILED'), 

(9, 'Optimus Bank', '8V34VN5U435334', '5312.23', 333, 'NF959653', '2005-03-01 19:32:56', 'MasterCard', 'RETRIED'), 

(10, '5 Stars Bank', '8VN8UNT5U45T8', '3382.13', 462, 'GC60330', '2004-07-01 12:31:56', 'VisaElectron', 'SUCCESS'), 

(11, '5 Stars Bank', '8VN8UNT5U45T8', '2566.17', 462, 'GC60330', '2004-07-03 11:21:16', 'VisaElectron', 'SUCCESS'), 

(12, 'Bank Ltd. US', '348398H3493HG93', '12304.13', 447, 'OU516561', '2004-12-27 16:15:22', 'VisaElectron', 'SUCCESS'), 

(13, 'BRT Bank', 'TVNU343T38TUNU3T', '52151.81', 278, 'GP636783', '2003-03-02 12:32:00', 'MasterCard', 'FAILED'), 

(14, 'Optimus Bank', 'GH390439i344F', '56321.33', 124, 'AE215433', '2005-03-05 12:32:56', 'VisaElectron', 'SUCCESS'), 

(15, 'Optimus Bank', 'GH390439i344F', '9866.21', 124, 'AE215433', '2005-03-05 13:00:00', 'VisaElectron', 'SUCCESS'), 

(16, 'Optimus Bank', 'GH390439i344F', '35057.05', 124, 'AE215433', '2005-03-05 14:12:00', 'VisaElectron', 'SUCCESS'), 

(17, '5 Stars Bank', 'QQQ333330944', '6522.99', 141, 'IN446258', '2005-03-25 13:44:11', 'VisaElectron', 'SUCCESS'), 

(18, '5 Stars Bank', 'QQQ333330944', '2566.17', 141, 'IN446258', '2005-03-25 14:00:05', 'VisaElectron', 'SUCCESS'), 

(19, '5 Stars Bank', 'QQQ333330944', '15800.30', 141, 'IN446258', '2005-03-25 14:03:05', 'VisaElectron', 'SUCCESS'), 

(20, '5 Stars Bank', 'QQQ333330944', '21455.32', 141, 'IN446258', '2005-03-25 15:13:05', 'VisaElectron', 'SUCCESS'), 

(21, '5 Stars Bank', 'QQQ333330944', '9883.22', 141, 'IN446258', '2005-03-25 15:25:05', 'VisaElectron', 'SUCCESS'), 

(22, '5 Stars Bank', 'QQQ333330944', '8843.26', 141, 'IN446258', '2005-03-25 16:00:05', 'VisaElectron', 'SUCCESS') ON DUPLICATE KEY UPDATE `transaction_id`=`transaction_id`;

/* Data for the table `sale` */

insert into `sale`(`sale_id`, `fiscal_year`, `sale`, `employee_number`, `fiscal_month`, `revenue_growth`, `trend`) values 

(1, 2003, 5282.64, 1370, 1, 0, 'CONSTANT'), 

(2, 2004, 1938.24, 1370, 2, 0, 'CONSTANT'), 

(3, 2004, 1676.14, 1370, 3, -13.52, 'DOWN'), 

(4, 2003, 3213, 1166, 1, -39.17, 'DOWN'), 

(5, 2004, 2121.35, 1166, 4, 26.56, 'UP'), 

(6, 2004, 3711.12, 1166, 4, 74.94, 'UP'), 

(7, 2003, 3449.26, 1611, 3, 7.35, 'UP'), 

(8, 2003, 4704.92, 1611, 4, 36.40, 'UP'), 

(9, 2004, 2974.43, 1611, 5, -19.85, 'DOWN'), 

(10, 2004, 4755.6, 1611, 6, 59.88, 'UP'), 

(11, 2004, 5657.4, 1611, 6, 18.96, 'UP'), 

(12, 2004, 3660.75, 1370, 7, -35.29, 'DOWN'), 

(13, 2004, 2812.32, 1370, 8, -23.17, 'DOWN'), 

(14, 2005, 1607.76, 1370, 2, 0, 'CONSTANT'), 

(15, 2005, 4996.62, 1370, 3, 210.78, 'UP'), 

(16, 2003, 5571.8, 1504, 4, 18.42, 'UP'), 

(17, 2003, 1491.38, 1504, 6, -73.23, 'DOWN'), 

(18, 2004, 3884.34, 1504, 9, 38.11, 'UP'), 

(19, 2004, 5241.44, 1504, 10, 34.93, 'UP'), 

(20, 2004, 51241.54, 1143, 11, 877.62, 'UP'), 

(21, 2003, 25241.43, 1143, 8, 1592.48, 'UP'), 

(22, 2000, 12434.22, 1370, 11, 0, 'CONSTANT'), 

(23, 2007, 9008.22, 1504, 3, 0, 'CONSTANT'), 

(24, 2007, 150399.34, 1611, 7, 1569.57, 'UP'), 

(25, 2005, 52343.12, 1102, 5, 947.57, 'UP')

ON DUPLICATE KEY UPDATE `sale_id`=`sale_id`;

/* Data for the table `top3product` */

insert into `top3product`(`product_id`, `product_name`) values 

(40, '1992 Ferrari 360 Spider red'), 

(1, '1969 Harley Davidson Ultimate Chopper'), 

(2, '1952 Alpine Renault 1300') ON DUPLICATE KEY UPDATE `product_id`=`product_id`;

/* Data for the table `token` */

insert into `token`(`token_id`, `sale_id`, `amount`) values 

(1, 1, 1500), 

(2, 1, 2687.55), 

(3, 1, 1095.09) ON DUPLICATE KEY UPDATE `token_id`=`token_id`;

/* Data for the table `employee_status` */

insert into `employee_status`(`id`, `employee_number`, `status`, `acquired_date`) values 

(1, 1002, 'REGULAR', '2004-04-14'), 

(2, 1056, 'REGULAR', '2003-06-10'), 

(3, 1076, 'REGULAR', '2005-01-10'), 

(4, 1088, 'REGULAR', '2005-04-10'), 

(5, 1102, 'REGULAR', '2003-07-12'), 

(6, 1143, 'REGULAR', '2003-05-12'), 

(7, 1143, 'AVERAGE', '2004-12-05'), 

(8, 1165, 'REGULAR', '2005-11-15'), 

(9, 1166, 'REGULAR', '2003-06-15'), 

(10, 1166, 'AVERAGE', '2004-11-15'), 

(11, 1188, 'REGULAR', '2003-10-25'), 

(12, 1216, 'REGULAR', '2003-11-25'), 

(13, 1286, 'REGULAR', '2004-09-25'), 

(14, 1323, 'REGULAR', '2006-01-25'), 

(15, 1337, 'REGULAR', '2003-02-23'), 

(16, 1370, 'REGULAR', '2000-02-23'), 

(17, 1370, 'AVERAGE', '2002-06-21'), 

(18, 1370, 'GOOD', '2004-01-11'), 

(19, 1370, 'EXCELLENT', '2005-11-11'), 

(20, 1401, 'REGULAR', '2005-10-11'), 

(21, 1401, 'AVERAGE', '2006-02-12'), 

(22, 1501, 'REGULAR', '2004-02-12'), 

(23, 1501, 'AVERAGE', '2005-02-12'), 

(24, 1504, 'REGULAR', '2003-02-12'), 

(25, 1504, 'AVERAGE', '2006-02-12'), 

(26, 1504, 'GOOD', '2007-06-10'), 

(27, 1611, 'REGULAR', '2003-01-10'), 

(28, 1611, 'AVERAGE', '2004-05-17'), 

(29, 1611, 'GOOD', '2005-03-22'), 

(30, 1611, 'EXCELLENT', '2007-03-20'), 

(31, 1612, 'REGULAR', '2003-01-22'), 

(32, 1612, 'AVERAGE', '2004-05-11'), 

(33, 1619, 'REGULAR', '2000-05-11'), 

(34, 1619, 'AVERAGE', '2001-05-11'), 

(35, 1619, 'GOOD', '2004-01-15'), 

(36, 1621, 'REGULAR', '2004-03-15'), 

(37, 1621, 'AVERAGE', '2005-12-15'), 

(38, 1625, 'REGULAR', '2002-12-15'), 

(39, 1702, 'REGULAR', '2002-11-25'), 

(40, 1702, 'AVERAGE', '2004-09-02') ON DUPLICATE KEY UPDATE `id`=`id`;

/* Data for the table `daily_activity` */

insert into `daily_activity`(`day_id`, `day_date`, `sales`, `visitors`, `conversion`) values 

(1, '2004-01-01', 21, 3373, 0.62), 

(2, '2004-01-02', 50, 3820, 1.31), 

(3, '2004-01-03', 50, 3175, 1.57), 

(4, '2004-01-04', 33, 4013, 0.82), 

(5, '2004-01-05', 58, 4022, 1.44), 

(6, '2004-01-06', 5, 4873, 0.25), 

(7, '2004-01-07', 36, 1924, 1.87), 

(8, '2004-01-08', 44, 3867, 1.14), 

(9, '2004-01-09', 28, 3621, 0.77), 

(10, '2004-01-10', 50, 1722, 2.90) ON DUPLICATE KEY UPDATE `day_id`=`day_id`;

/* Data for the table `office_flights` */

insert into `office_flights`(`depart_town`, `arrival_town`, `distance_km`) values 

('Paris', 'Los Angeles', 9080), 

('Los Angeles', 'Paris', 9080), 

('Paris', 'Boston', 5528), 

('Boston', 'Paris', 5528), 

('Paris', 'Sydney', 16950), 

('Sydney', 'Paris', 16950), 

('Paris', 'London', 344), 

('London', 'Paris', 344), 

('Paris', 'Bucharest', 1871), 

('Bucharest', 'Paris', 1871), 

('Los Angeles', 'San Diego', 180), 

('San Diego', 'Los Angeles', 180), 

('Los Angeles', 'Sydney', 12073), 

('Sydney', 'Los Angeles', 12073), 

('San Diego', 'Boston', 4150), 

('Boston', 'San Diego', 4150), 

('Boston', 'New York', 305), 

('New York', 'Boston', 305), 

('Boston', 'Springfield', 1580), 

('Springfield', 'Boston', 1580), 

('New York', 'Springfield', 1329), 

('Springfield', 'New York', 1329), 

('New York', 'Sydney', 15979), 

('Sydney', 'New York', 15979), 

('New York', 'London', 5567), 

('London', 'New York', 5567), 

('Sydney', 'Tokyo', 7819), 

('Tokyo', 'Sydney', 7819), 

('Sydney', 'London', 16983), 

('London', 'Sydney', 16983), 

('London', 'Tokyo', 9559), 

('Tokyo', 'London', 9559) ON DUPLICATE KEY UPDATE `depart_town`=`depart_town`;

/* END */

/*
*********************************************************************
http://www.mysqltutorial.org
*********************************************************************
Name: MySQL Sample Database classicmodels
Link: http://www.mysqltutorial.org/mysql-sample-database.aspx
*********************************************************************

This is a modified version of the original schema
*/