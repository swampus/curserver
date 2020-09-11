CREATE TABLE `logs` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `date` TIMESTAMP,
    `method` varchar(10),
    `url` varchar(2000),
    `request_json` varchar(5000),
    `request_ip_v6` varchar(1000),
    `message` varchar(1000),
    `result` varchar(30),


)ENGINE=InnoDB DEFAULT CHARSET=UTF8;