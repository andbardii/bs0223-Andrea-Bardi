  DROP TABLE IF EXISTS fatture;
  DROP TABLE IF EXISTS fornitori;
  DROP TABLE IF EXISTS prodotti;
  DROP TABLE IF EXISTS clienti;
  
  CREATE TABLE clienti (
 	numeroCliente SERIAL,
	nome VARCHAR NOT NULL, 
	cognome VARCHAR NOT NULL,
	dataNascita DATE NOT NULL,
	regiorneResidenza VARCHAR NOT NULL,
	 
	 CONSTRAINT clientePK PRIMARY KEY (numeroCliente)
 );
 
  CREATE TABLE fornitori (
 	numeroFornitore SERIAL,
	denominazione VARCHAR NOT NULL, 
	regioneResidenza VARCHAR NOT NULL,
	   
	   CONSTRAINT fornitorePK PRIMARY KEY (numeroFornitore)
 );
 
  CREATE TABLE fatture (
 	numeroFattura SERIAL,
	tipologia VARCHAR NOT NULL, 
	importo INTEGER NOT NULL,
	iva INTEGER NOT NULL,
	idCliente INTEGER NOT NULL,
	dataFattura DATE NOT NULL,
	numeroFornitore INTEGER NOT NULL,
	  
	  CONSTRAINT fatturaPK PRIMARY KEY (numeroFattura),
	  CONSTRAINT fatturaClienteFK FOREIGN KEY (idCliente) REFERENCES clienti (numeroCliente),
	  CONSTRAINT fatturaFornitoriFK FOREIGN KEY (numeroFornitore) REFERENCES fornitori (numeroFornitore) 
 );
 
   CREATE TABLE prodotti (
 	idProdotto SERIAL,
	descrizione VARCHAR NOT NULL, 
	inProduzione BOOLEAN NOT NULL DEFAULT false,
	inCommercio BOOLEAN NOT NULL DEFAULT false,
	dataAttivazione DATE,
	dataDisattivazione DATE,
	   
	   CONSTRAINT prodottoPK PRIMARY KEY (idProdotto)
 );
 
 /* DML */
 INSERT INTO clienti(nome, cognome, dataNascita, regiorneResidenza) 
 VALUES ('Andrea', 'Bardi', '2002-10-28', 'Emilia-Romagna'),
 		('Federico', 'Verdi', '1995-11-12', 'Campania'),
		('Gianluca', 'Rossi', '1982-12-27', 'Lombardia');

		
 INSERT INTO fornitori(denominazione, regioneResidenza) 
 VALUES ('Apple', 'Emilia-Romagna'),
 		('Tesla', 'Campania'),
		('Amazon', 'Lombardia');
		
		
 INSERT INTO prodotti(descrizione, inProduzione, inCommercio, dataAttivazione, dataDisattivazione) 
 VALUES ('Fantastico', true, true, '2022-10-28', '2025-01-01'),
 		('Miglior qualità prezzo', true, false, '2022-10-28', '2025-01-01');
		
 INSERT INTO prodotti(descrizione, inProduzione, inCommercio) 
 VALUES ('Lussuoso', false, false);
		
 INSERT INTO fatture(tipologia, importo, iva, idCliente, dataFattura, numeroFornitore) 
 VALUES ('Servizio', 1000, 22, 1, '2022-10-15', 1),
 		('Prodotto', 100, 22, 2, '2023-06-04', 2),
		('Consulenza', 500, 22, 3, '2023-07-10',3);
		
		/* SELECT * FROM clienti, fornitori, fatture, prodotti; */
		/* SELECT numeroCliente, nome, cognome, dataNascita, regioneResidenza FROM clienti WHERE EXTRACT(YEAR FROM DataNascita) = 1982; */
		