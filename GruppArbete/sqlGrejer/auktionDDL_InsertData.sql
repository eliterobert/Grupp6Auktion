use auktion;

INSERT INTO kategori (Namn) VALUES ('Kläder');
INSERT INTO kategori (Namn) VALUES ('Möbler');
INSERT INTO kategori (Namn) VALUES ('Skor');
INSERT INTO kategori (Namn) VALUES ('Bil');
INSERT INTO kund (personnummer, efternamn, förnamn, gatuadress, postnummer, ort, telefon, epost) VALUES ('199003067683', 'Granqvist', 'Andreas', 'Vasagatan 25B', '12354', 'Sollentuna', '0701232456', 'andreas@granqvist.com');
INSERT INTO kund (personnummer, efternamn, förnamn, gatuadress, postnummer, ort, telefon, epost) VALUES ('197808298349', 'Svensson', 'Björn', 'Grizzlyvägen 7A', '15544', 'Uppsala', '0764087321', 'björn@svensson.com');
INSERT INTO kund (personnummer, efternamn, förnamn, gatuadress, postnummer, ort, telefon, epost) VALUES ('198310024958', 'Andersson', 'Linda', 'Allévägen 19B', '15567', 'Rotebro', '070865639', 'linda@andersson.com');
INSERT INTO kund (personnummer, efternamn, förnamn, gatuadress, postnummer, ort, telefon, epost) VALUES ('199006062859', 'Andersson', 'Kristina', 'Kyrkogatan 2', '18374', 'Stockholm', '070983757', 'kristina@andersson.com');
INSERT INTO kund (personnummer, efternamn, förnamn, gatuadress, postnummer, ort, telefon, epost) VALUES ('199512243853', 'Silverstedt', 'Kim', 'Allévägen 25A', '23852', 'Rotebro', '070234987', 'kim@silverstedt.com');

INSERT INTO leverantör (Namn, Epost, Telefon, gatuadress ,postnummer , ort ,provisionsnivå) VALUES ('Star AB', 'Star@Tosh.com' ,'6059283123', 'Tomtevägen 13', '70213' , 'Lindesberg' , 0.15);
INSERT INTO leverantör (Namn, Epost, Telefon, gatuadress ,postnummer , ort ,provisionsnivå) VALUES ('Creepy Movie', 'Creep@Movie.com' ,'54223102', 'Godaftonsgatan 7', '33260' , 'Kalkudden' , 0.25);
INSERT INTO leverantör (Namn, Epost, Telefon, gatuadress ,postnummer , ort ,provisionsnivå) VALUES ('Today AB', 'Today@Tomorrow.com' ,'906832489', 'Ekvägen 33', '23012' , 'Kaggeboda' , 0.10);
INSERT INTO leverantör (Namn, Epost, Telefon, gatuadress ,postnummer , ort ,provisionsnivå) VALUES ('Vaping AB', 'Vaping@Taping.com' ,'555444222', 'Strömgatan 50', '33441' , 'Lerbäck' , 0.05);
INSERT INTO leverantör (Namn, Epost, Telefon, gatuadress ,postnummer , ort ,provisionsnivå) VALUES ('Bayer AB', 'Bayer@Layer.com' ,'323013200', 'Lokabordsgatan 3', '12345' , 'Laxne' , 0.07);
INSERT INTO leverantör (Namn, Epost, Telefon, gatuadress ,postnummer , ort ,provisionsnivå) VALUES ('PitchPerfect AB', 'Pitch@Perfect.com' ,'987654321', 'Laxforsen 45', '89652' , 'Laxsjö' , 0.15);

INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Tröja', 'BlåTröja',100,1,1);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Byxor', 'Slitna Byxor',50,1,2);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Soffa', 'Vintage Soffa Grön',1000,2,3);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Bord', 'Ek-Bord',100,2,4);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Converse', 'Vita',30,3,5);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Ballerina', 'Svart',10,3,6);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Volvo 740 -00', 'Rosigt Blå',10000,4,6);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Saab 900 -94', 'Vit',5000,4,1);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('T-Shirt', 'Orange',20,1,2);
INSERT INTO produkt (Namn, Beskrivning, utgångspris , kategoriId,leverantörId) VALUES ('Skåp', 'Vintrinskåp',250,2,3);

INSERT INTO auktioner (ProduktId, acceptpris,`start`,slut) VALUES (1,250,'2016-02-15 14:44:00', '2016-02-17 14:44:00');
INSERT INTO auktioner (ProduktId, acceptpris,`start`,slut) VALUES (2,0,'2016-02-16 15:44:00', '2016-02-18 15:44:00');
INSERT INTO auktioner (ProduktId, acceptpris,`start`,slut) VALUES (3,0,'2016-02-17 14:44:00', '2016-02-19 14:44:00');
INSERT INTO auktioner (ProduktId, acceptpris,`start`,slut) VALUES (4,300,'2016-02-15 14:44:00', '2016-02-17 14:44:00');
INSERT INTO auktioner (ProduktId, acceptpris,`start`,slut) VALUES (5,170,'2016-02-19 14:44:00', '2016-02-21 14:44:00');
INSERT INTO auktioner (ProduktId, acceptpris,`start`,slut) VALUES (6,170,'2016-02-16 11:03:00', '2016-02-16 11:05:00');

INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-15 15:00:15', '199003067683', 1, 100);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-16 16:00:15','197808298349', 2, 60);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-16 15:00:15', '198310024958', 1, 110);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-16 18:00:15', '199003067683', 1, 120);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-17 15:00:15', '199006062859', 2, 70);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-17 19:00:15', '199003067683', 3, 1100);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-18 15:00:15','199512243853', 3, 1200);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-16 15:00:15', '198310024958', 4, 260);
INSERT INTO bud (`timestamp`, kundId, auktionId, belopp) VALUES ('2016-02-20 15:00:15', '197808298349', 5, 80);

INSERT INTO epost (innehåll, ämne) VALUES ('Auction 1 är avslutad', 'Avslutad auktion');
INSERT INTO epost (innehåll, ämne) VALUES ('Auction 2 är avslutad', 'Avslutad auktion');
INSERT INTO epost (innehåll, ämne) VALUES ('Auction 3 är avslutad', 'Avslutad auktion');
INSERT INTO epost (innehåll, ämne) VALUES ('Auction 4 är avslutad', 'Avslutad auktion');
INSERT INTO epost (innehåll, ämne) VALUES ('Auction 5 är avslutad', 'Avslutad auktion');
INSERT INTO epost (innehåll, ämne) VALUES ('Auction 6 är avslutad', 'Avslutad auktion');