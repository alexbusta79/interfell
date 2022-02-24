DROP TABLE IF EXISTS Interfell cascade;

CREATE TABLE Interfell(
  id INT AUTO_INCREMENT  PRIMARY KEY,
  county_fips VARCHAR(250) NOT NULL, 
  county_name VARCHAR(250) NOT NULL,
  state_name VARCHAR(250),
  date DATE NOT NULL,
  percent_change_from_jan float NOT NULL,
  mean7_county_vmt float NOT NULL
);

INSERT INTO Interfell(county_fips,county_name, state_name,date, percent_change_from_jan, mean7_county_vmt ) VALUES
  (1001,'Autauga', 'Alabama',TO_DATE('05/08/2020', 'DD/MM/YYYY'), -0.6,2790000),
  (1001,'Autauga', 'Alabama',TO_DATE('05/07/2020', 'DD/MM/YYYY'), -16.84,2724285.71),
  (1001,'Autauga', 'Alabama',TO_DATE('05/06/2020', 'DD/MM/YYYY'), -24.96,2644285.71),
  (1001,'Autauga', 'Alabama',TO_DATE('05/05/2020', 'DD/MM/YYYY'), -23.84,2561428.57),
  (1001,'Autauga', 'Alabama',TO_DATE('05/04/2020', 'DD/MM/YYYY'), -33.08,2515714.29),
  (1001,'Autauga', 'Alabama',TO_DATE('05/03/2020', 'DD/MM/YYYY'), -31.96,2490000),
  (1001,'Autauga', 'Alabama',TO_DATE('05/02/2020', 'DD/MM/YYYY'), -21.88,2384285.71),
  (1001,'Autauga', 'Alabama',TO_DATE('05/01/2020', 'DD/MM/YYYY'), -13.48,2264285.71),
  (1001,'Autauga', 'Alabama',TO_DATE('30/04/2020', 'DD/MM/YYYY'), -32.52,2170000),
  (1001,'Autauga', 'Alabama',TO_DATE('29/05/2020', 'DD/MM/YYYY'), -41.2,2082857.14)
  ;
 

 
--