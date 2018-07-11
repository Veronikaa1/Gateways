INSERT INTO GATEWAY(NAME, IPV4) VALUES ('gate1', '127.0.0.1'),
									   ('gate2', '127.0.0.2');
									   
INSERT INTO DEVICE(UID,	VENDOR,	CREATION_DATE, STATUS, GATEWAY_ID) VALUES ('X1YT5N0HMZ', 'vendor1', TO_DATE('14-07-2018', 'DD-MM-YYYY'), false, 1),
																			('YT56QZM9GF', 'vendor2', TO_DATE('24-03-2007', 'DD-MM-YYYY'), true, 1),
																			('OZB03G8ZWQ', 'vendor1', TO_DATE('12-09-2013', 'DD-MM-YYYY'), true, 2),
																			('BV96FR39ZZ', 'vendor2', TO_DATE('11-12-2016', 'DD-MM-YYYY'), false, 1);
																			
