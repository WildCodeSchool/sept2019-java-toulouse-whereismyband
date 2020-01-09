CREATE DATABASE  IF NOT EXISTS `where_is_my_band` /*!40100 DEFAULT CHARACTER SET latin1 */;
CREATE USER 'h4rryp0tt3r'@'localhost' IDENTIFIED BY 'Horcrux4life!';
GRANT ALL PRIVILEGES ON where_is_my_band.* TO 'h4rryp0tt3r'@'localhost';
USE `where_is_my_band`;
-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: where_is_my_band
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `band`
--

DROP TABLE IF EXISTS `band`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `band` (
  `id_band` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `bio` text NOT NULL,
  `search_type` int(11) DEFAULT NULL,
  `postcode` varchar(45) DEFAULT NULL,
  `id_musician` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_band`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band`
--

LOCK TABLES `band` WRITE;
/*!40000 ALTER TABLE `band` DISABLE KEYS */;
INSERT INTO `band` VALUES (4,'Heavy Kazoo','Un projet mêlant accordéon, Kazoo et tech death',2,'31000',29),(5,'Ultra Demon Accordeon Salsa','Blablabla',2,'31000',30),(6,'The mighty Tacos School of Hip hop','',3,'31000',31),(7,'Top accordeon Quartet','Wouhouhouhou',1,'31500',32),(8,'Homme Ours Porc Trio','frudubu',1,'31170',33),(9,'Big Ban Hammer of The Bronx','Ban Hammer !',1,'31770',34),(10,'The Henri\'s Band','',2,'31400',35),(11,'Tacos corp','',3,'31000',38),(12,'lofofora','',2,'31000',39),(13,'michel and the michel\'s angel','est trop bin',3,'31400',41),(14,'Tagada tsouintsouin','pouet',2,'31000',39),(15,'George George George','',2,'31000',44),(16,'Europe Occitanie les verts','Super green',3,'31000',46),(17,'Grimbergen experience','Glou et glou et glou',1,'31400',47),(18,'Les puppies','c\'est trop mignon',3,'31600',48);
/*!40000 ALTER TABLE `band` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band_style`
--

DROP TABLE IF EXISTS `band_style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `band_style` (
  `id_style` int(11) NOT NULL,
  `id_band` int(11) NOT NULL,
  PRIMARY KEY (`id_style`,`id_band`),
  KEY `band_style_band1_FK` (`id_band`),
  CONSTRAINT `band_style_band1_FK` FOREIGN KEY (`id_band`) REFERENCES `band` (`id_band`),
  CONSTRAINT `band_style_style0_FK` FOREIGN KEY (`id_style`) REFERENCES `style` (`id_style`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band_style`
--

LOCK TABLES `band_style` WRITE;
/*!40000 ALTER TABLE `band_style` DISABLE KEYS */;
INSERT INTO `band_style` VALUES (1,4),(1,5),(6,5),(1,13),(1,14),(3,15),(12,16),(17,17),(1,18);
/*!40000 ALTER TABLE `band_style` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrument`
--

DROP TABLE IF EXISTS `instrument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instrument` (
  `id_instrument` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`id_instrument`)
) ENGINE=InnoDB AUTO_INCREMENT=746 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrument`
--

LOCK TABLES `instrument` WRITE;
/*!40000 ALTER TABLE `instrument` DISABLE KEYS */;
INSERT INTO `instrument` VALUES (1,'aboès'),(2,'accordéon'),(3,'accordéon diatonique'),(4,'accordina'),(5,'adjalin'),(6,'aérophon'),(7,'agogô'),(8,'alboka'),(9,'alghoza'),(10,'allun'),(11,'alto'),(12,'angklung'),(13,'antsiva : conque malgache'),(14,'appeau'),(15,'archiluth'),(16,'arghoul ou argol'),(17,'atabaque'),(18,'autoharpe'),(19,'baglama'),(20,'balafon'),(21,'balalaïka'),(22,'bandola'),(23,'bandonéon'),(24,'bandoura : cithare ukrainienne'),(26,'banjo'),(27,'banshrî'),(28,'barbitos : instrument antique à cordes'),(29,'baryton'),(30,'basson'),(31,'batá : percussions cubaines (3 tailles : okolo, itotele, rya)'),(32,'bâton de pluie'),(33,'batterie'),(34,'batterie électronique'),(35,'bayan : accordéon russe'),(36,'béchonnet : cornemuse auvergnate'),(37,'bendir : tambour à timbre'),(38,'benju ou dulcimer japonais'),(39,'berimbau'),(40,'biniou : cornemuse bretonne'),(41,'birbyne : instrument à vent lituanien'),(42,'biwa : luth japonais'),(43,'bobre'),(44,'bodega : cornemuse du Languedoc'),(45,'bodhrán : tambour irlandais'),(46,'boha : cornemuse de Gascogne'),(47,'bombarde'),(48,'bombardon'),(49,'bombo : percussion d\'Amérique du Sud'),(50,'bongo(s) : percussion d\'Amérique du Sud (2 tailles : hembra et macho)'),(51,'bourdon'),(52,'bouzouki'),(53,'bratsch ou braci ou brace ou contrã : violon à 3 cordes roumain'),(54,'bugle'),(55,'bulbultara : sud de l\'Inde'),(56,'Cabasa'),(57,'cabrette : cornemuse auvergnate'),(58,'caisse claire'),(59,'caixa : percussion brésilienne'),(60,'cajón : percussion d\'Amérique latine'),(61,'calebasse'),(62,'carémère ou caramèra : clarinette de Gascogne'),(63,'carillon'),(64,'carillon à vent'),(65,'carillon tubulaire'),(66,'carnyx'),(67,'castagnettes'),(68,'caval : flûte roumaine'),(69,'cavaquinho'),(70,'caxixi'),(71,'Cécilium'),(72,'célesta'),(73,'cellulophone'),(74,'chabrette : cornemuse du Limousin'),(75,'chalemie'),(76,'chalumeau'),(77,'chapeau chinois'),(78,'chapey'),(79,'charango : 3 tailles : waylacho, charango et ronrocco'),(80,'chitarra battente'),(81,'chitarrone'),(82,'choro'),(83,'cialamella'),(84,'cistre'),(85,'cithare'),(86,'clairon'),(87,'clarinette'),(88,'clarinette basse'),(89,'clavecin : famille de plusieurs instruments dont le clavecin.'),(90,'claves'),(91,'clavi harp'),(92,'clavicorde : a évolué vers le piano-forte'),(93,'clavicytherium : famille des clavecins'),(94,'clavinet'),(95,'cloche'),(96,'cloches tubulaires'),(97,'cobza : luth roumain'),(98,'colachon : luth italien du XVIIe'),(99,'concertina'),(100,'congas (3 tailles : quinto, tumba et conga)'),(101,'conque : instrument à base de coquillage'),(102,'contrebasse'),(103,'contrebasse à vent'),(104,'contrebasson'),(105,'cor anglais'),(106,'cor d\'harmonie ou cor moderne'),(107,'cor de basset'),(108,'cor de chasse'),(109,'cor des Alpes'),(110,'cor naturel'),(111,'cornamuse'),(112,'corne'),(113,'corne de brume'),(114,'cornemuse'),(115,'cornet à bouquin'),(116,'cornet à pistons'),(117,'cornu'),(118,'cosmophone'),(119,'courtaud'),(120,'cricket'),(121,'cristal Baschet'),(122,'cromorne : instrument à vent'),(123,'crouth ou crwth : instrument à cordes'),(124,'cuatro : Venezuela'),(125,'cuica : tambour à friction brésilien'),(126,'cuillers'),(127,'cumbus'),(128,'cura : instrument proche du bouzouki'),(129,'cymbale'),(130,'cymbales antiques'),(131,'cymbalum'),(132,'dabakan : tambour philippin'),(133,'daf'),(134,'dâmâna'),(135,'danbolino'),(136,'danhoun'),(137,'danyen'),(138,'dap : percussion arménienne'),(139,'darbouka ou darbuka ou darbuqqa'),(140,'darvyra'),(141,'def : percussion kurde'),(142,'dehol : tambour caucasien'),(143,'diapason'),(144,'didgeridoo : tube soufflé australien'),(145,'dimplito : caucasien'),(146,'dízi : flûte horizontale chinoise'),(147,'djembé'),(148,'djozé'),(149,'doedelzak'),(150,'dolcian ou dulcian : instrument à vent allemand du XVIe'),(151,'domra'),(153,'dou-co ou cài-nhi'),(154,'doudouçaine : hautbois grave du Moyen Âge'),(155,'doudouk : hautbois arménien'),(156,'Dubreq Stylophone : instrument de musique électronique miniature'),(157,'duda (en) : cornemuse hongroise'),(158,'dulcimer'),(159,'Dulcitone'),(160,'dulzaina ou dultzania : hautbois aragonais'),(161,'dum dum ou dunun : percussion mandingue'),(162,'Eigenharp'),(163,'épinette'),(164,'épinette des Vosges'),(165,'erhu ou èrhú'),(166,'erkencho'),(167,'Euphone'),(168,'euphonium'),(169,'fifre'),(170,'flabuta'),(171,'flageolet ou flajol'),(172,'flaviol'),(173,'flexatone'),(174,'flûte'),(175,'flûte à bec'),(176,'flûte basse'),(177,'flûte de Pan'),(178,'flûte en sol'),(179,'flûte harmonique'),(180,'flûte irlandaise'),(181,'flûte traversière'),(182,'flûte traversière baroque'),(183,'frestel'),(184,'fujara'),(185,'fût'),(186,'gadoulka'),(187,'gaïda : cornemuse bulgare'),(188,'gaita : hautbois du Pays basque, et cornemuse espagnole'),(189,'gaita gallega : cornemuse espagnole'),(190,'galoubet'),(191,'gambri, gumbri, guinbri, guenbri, gembri ou gunbri'),(192,'gamelan'),(193,'ganza'),(194,'gardon : percussion hongroise'),(195,'garmon'),(196,'gasbâ : flûte tunisienne'),(197,'geige'),(198,'gemshorn : flûte en corne'),(199,'gigue'),(200,'gita : calebasse avec cauris'),(201,'glassharmonica'),(202,'glockenspiel'),(203,'gong'),(204,'graïle : hautbois du Languedoc'),(205,'grelots'),(206,'grosse caisse'),(207,'guimbarde'),(208,'güiro'),(209,'guitare'),(210,'guitare acoustique'),(211,'guitare baroque'),(212,'guitare baryton'),(213,'guitare basse'),(214,'guitare classique'),(215,'guitare électrique'),(216,'guitare électro-acoustique'),(217,'guitare flamenca'),(218,'guitare folk'),(219,'guitare hawaïenne'),(220,'guitare portugaise'),(221,'guitare-harpe'),(222,'guitarrón'),(223,'guiterne'),(224,'guqin (cithare chinoise à cordes pincées)'),(225,'gusli ou gusle'),(227,'guzla (vièle yougoslave)'),(228,'hackbrett'),(229,'hang'),(230,'harmonica :'),(231,'Harmonica de verre'),(232,'harmoniflûte'),(233,'harmonium : orgue'),(234,'harpe :'),(235,'harpe à pédales'),(236,'harpe celtique'),(237,'harpe chinoise'),(238,'harpe d\'Afrique'),(239,'harpe des Pahouins'),(241,'harpe paraguayenne'),(242,'harpu : sorte de psaltérion finlandais à cinq cordes'),(243,'hautbois'),(244,'hautbois baryton'),(245,'hautbois d\'amour'),(246,'heckelphone'),(247,'hegelung'),(248,'hélicon'),(249,'héliophone'),(250,'hiachi-riki ou hichiriki'),(251,'hochet'),(252,'hochet à grelots'),(253,'horn bugle'),(254,'hornpipe : corne'),(255,'huayllaca'),(256,'húqín : viole à 2 cordes chinoise'),(257,'hwang chong tché'),(258,'hwang-teih'),(259,'ichigenkin'),(260,'inanga'),(261,'ingomba'),(262,'insibi'),(263,'ja-kin\'rh'),(264,'jabisen'),(265,'jagajhampa'),(266,'jaleika : hautbois touareg'),(267,'jamblock'),(268,'jarana'),(269,'jejy voatavo'),(270,'jenbe : tambour à une peau'),(271,'jeu de timbre'),(272,'jouhikko'),(273,'ka : tambour des Caraïbes'),(274,'kabosse (appelé aussi kabossy ou kabosa) : guitare malgache'),(275,'kacapi'),(276,'kacha-vînâbossy'),(277,'kachapî-vînâ'),(278,'kagoura-fouye'),(279,'kaïrâta-vînâ'),(280,'kalimba'),(281,'kamalen kòni'),(282,'kamanja'),(283,'kandang indien'),(284,'kânih : de la Sierra Leone'),(285,'kankangui : trompette du Bénin'),(286,'kanoun : cithare du Proche-Orient'),(287,'kantele : cithare finlandaise'),(288,'kanyahte\'ka\'nowa ou hochet-tortue'),(289,'kao kao javanais'),(290,'kara : soudanais'),(291,'karabid'),(292,'karkabet'),(293,'karna'),(294,'kass : égyptien'),(295,'kasso : harpe du Sénégal et de Gambie à vingt cordes'),(296,'kattyauma-vînâ'),(297,'kaval : flûte oblique bulgare'),(298,'kayamb : des Mascareignes ou maravane de l\'île Maurice'),(299,'kazoo ou mirliton : instrument membranophone'),(300,'kemaçe : violine kurde'),(301,'kemângeh à gouz'),(302,'kemângeh-roumy'),(303,'kena : flûte'),(304,'kesbate : algérien'),(305,'kese kese'),(306,'keseng keseng'),(307,'kétipoeng : javanais'),(308,'kétjapi'),(309,'kette drums : tambours rastas nyabinghi jamaïcains (funde, repeater, bass drum)'),(310,'kharatala'),(311,'khên : laosien'),(312,'khol'),(313,'khoradah'),(314,'khurdra kattyauna-vînâ'),(315,'kîn'),(316,'kin-kon'),(317,'kinan : harpe chinoise'),(318,'king ou pien king'),(319,'kinnari-vînâ'),(320,'kinnery'),(321,'kîringie : Sierra Leone'),(322,'kissar : lyre éthiopienne'),(323,'klaxon'),(324,'klentony'),(325,'koant-tsé : genre de flûte de Pan chinoise'),(326,'kobza : type bandoura, (Ukraine)'),(327,'koholo : genre de trompette indienne'),(328,'kokiou : genre de violon chinois'),(329,'kònkòni'),(330,'kora ou cora : harpe africaine'),(331,'kotek'),(332,'koto : cithare japonaise'),(333,'kou'),(334,'koundyeh'),(335,'kousser'),(336,'kpanouhoun'),(337,'kpézin'),(338,'krar : lyre éthiopienne et érythréenne'),(339,'kuitra : genre de guitare arabe à quatre cordes'),(340,'kulintang : gong'),(341,'kunjerry'),(342,'langeleik : cithare / épinette des Vosges norvégienne'),(343,'lapa'),(344,'laya bansi'),(345,'lira da braccio'),(346,'lirone ou lira da gamba'),(347,'lithophone'),(348,'lituus'),(349,'lo kou : chinois'),(350,'lo ou yang'),(351,'lokombi : congolais'),(352,'loure'),(353,'lu tchun'),(354,'lung-tao-ty'),(355,'luth'),(356,'lyre : lyre antique, lyre éthiopienne, lyre du Moyen Âge'),(357,'lyro-guitare (en)'),(358,'lyrone'),(359,'m\'bira : piano à pouce africain'),(360,'ma-ca-doi'),(361,'madiumba : congolais'),(362,'magondi'),(363,'magrouna'),(364,'maha-mandira'),(365,'mahati-vînâ'),(366,'mainty kely'),(367,'malakat'),(368,'mandira : indien'),(369,'mandoline'),(370,'mandoline country'),(371,'mandoloncelle'),(372,'mandolute'),(373,'mandore'),(374,'mandurria : indien'),(375,'manichordion'),(376,'maracas : hochet d\'Amérique du Sud'),(377,'maravanne : de l\'île Maurice ou kayamb des Mascareignes'),(378,'marddala ou madala'),(379,'marimba'),(380,'marouvané'),(381,'Matrémine'),(382,'mattauphone'),(383,'mayuri ou tayuc'),(384,'mazhar : instrument arabe'),(385,'medylenara'),(386,'megyoung'),(387,'meia-lua'),(388,'mellophone'),(389,'mellotron'),(390,'mélodica'),(391,'merline'),(392,'métronome'),(393,'mezoued : cornemuse tunisienne'),(394,'mina-sarangi'),(395,'mirliton ou kazoo : instrument membranophone'),(396,'mizmar : égyptien'),(397,'mochanga'),(398,'mon yu ou mon ye'),(399,'moraharpa'),(400,'Morin khuur'),(401,'mridang'),(402,'mridangam'),(403,'muselaar : famille des clavecins'),(404,'musette'),(405,'n\'goni : Afrique de l\'Ouest'),(406,'n\'tama'),(407,'nacaire'),(408,'nadeshvara-vînà'),(409,'nafir'),(410,'nagara : indien du Bengale'),(411,'nagelgeige Allemagne ou nail violin Angleterre ou'),(412,'nagelharmonica ou violon de fer France'),(413,'nagharats : Tunisie'),(414,'naï ou muscal : flûte de Pan roumaine'),(415,'nanga'),(416,'napura'),(417,'nay ou nay châch ou ney : flûte orientale'),(418,'néo-cor'),(419,'nhac'),(420,'nicolo'),(421,'nihoîhagi'),(422,'nimfali ou ninfali'),(423,'nira'),(424,'nixenharfe ou nickelharfe : suédoise'),(425,'nkwanga ou swanga'),(426,'noordische balk'),(427,'nyâstaranga'),(428,'nyckelharpa : vièle suédoise'),(429,'ocarina'),(430,'ocean drum'),(431,'octobasse'),(432,'octoblock'),(433,'olifant'),(434,'ombi'),(435,'omerti'),(436,'omni'),(437,'ondes Martenot'),(438,'ongo : trompe centrafricaine'),(439,'ophicléide'),(440,'organistrum'),(441,'orgue'),(442,'orgue de Barbarie'),(443,'orgue électronique'),(444,'orgue numérique'),(445,'orphéon'),(446,'orphica'),(447,'otamatone'),(448,'ottavino'),(449,'oud : luth arabe'),(450,'pakhâwaj'),(451,'pandeiro'),(452,'pandereta'),(453,'pandore'),(454,'pandurina'),(455,'patola'),(456,'pedal steel'),(457,'pee : siamois'),(458,'pennywhistle'),(459,'percuphone'),(460,'perroquette'),(461,'phorminx'),(462,'piano'),(463,'piano à queue'),(464,'piano à tangentes'),(465,'piano droit'),(466,'piano électrique'),(467,'piano numérique'),(468,'piano-forte'),(469,'pibrock'),(470,'piccolo'),(471,'Pipa (instrument) ou pípa : luth chinois'),(472,'pipeau'),(473,'planche à laver'),(474,'psaltérion'),(476,'pung'),(477,'pungi'),(478,'pyrophone'),(479,'qanun'),(480,'qarnay : ouzbek'),(481,'qilaut : tambour'),(482,'qin'),(483,'quena'),(484,'Quinton'),(485,'rabâb : vièles et luths'),(486,'rauschpfeife'),(487,'ravanastron'),(488,'reactable'),(489,'rebec (instrument)'),(490,'régale'),(491,'repinique'),(492,'rhombe (bull-roarer en anglais)'),(493,'riqq : percussion basque ou arabe'),(494,'roulèr'),(495,'sabar'),(496,'sacqueboute : Moyen Âge'),(497,'sagat : égyptien'),(498,'salamouri : caucasien'),(499,'salpinx : sorte de trompette utilisée en Grèce antique'),(500,'sambucca ou sambuque'),(501,'san-heen ou samm-jin ou samm-sinn ou samhine'),(502,'sânâi ou sani'),(503,'sangé'),(504,'santir'),(505,'santour'),(506,'sanyogi'),(507,'sanza : piano à pouces africain'),(508,'sarala-bensi'),(509,'sârangî : vièle indienne'),(510,'sarciros'),(511,'sarod'),(512,'sarou : Sierra Leone'),(513,'sarrussophone'),(514,'satârâ'),(515,'sato : percussion'),(516,'saung : birman'),(517,'saw dorang : siamois'),(518,'saw-duang'),(519,'saw-tai'),(520,'saxhorn'),(521,'saxophone'),(522,'saxophone alto'),(523,'saxophone baryton'),(524,'saxophone basse'),(525,'saxophone contrebasse'),(526,'saxophone piccolo'),(527,'saxophone sopranino'),(528,'saxophone soprano'),(529,'saxophone ténor'),(530,'saxotromba'),(531,'saz : luth turc et caucasien'),(532,'Scabellum'),(533,'schalmey : instrument à vent allemand'),(534,'schiguene : instrument à cordes pincées japonais'),(535,'schiti-gekkin ou schikenkin'),(536,'schlagzither'),(537,'scho ou Scho-no-fouge : japonais'),(538,'schofar'),(539,'schoko'),(540,'schounga'),(541,'scie musicale'),(542,'sciotang ou lebel'),(543,'seaou-po : chinois'),(544,'selantan'),(545,'selompret'),(546,'serdam'),(547,'serinette'),(548,'serpent'),(549,'setâr'),(550,'shakuhachi ou siaku-hachi : flûte japonaise'),(551,'shamisen'),(552,'sharadiya-vina ou sharode'),(553,'shehnai'),(554,'shekere'),(555,'sheng : orgue à bouche et à anche chinois'),(556,'shophar'),(557,'showktica-vina'),(558,'shuang-kin'),(559,'siao'),(560,'sifflet'),(561,'sigou-mbarva'),(562,'sigou-nihou'),(563,'siku : 4 tailles : tayka, malta, liku et chuli'),(564,'silbote'),(565,'sinbi ou sinbiòw'),(566,'sira ou yabara'),(567,'sistre : à ne pas confondre avec cistre'),(568,'sitar : sorte de grand luth indien'),(569,'siyotantka (le bâton qui chante) : flûte d\'amour des Indiens des plaines'),(570,'sodina, sody, soly, antsoly ou antsody : flûte malgache'),(571,'sona'),(572,'sonaja'),(573,'sopilka : flûte ukrainienne'),(574,'sorna'),(575,'soubassophone ou sousaphone'),(576,'soudzou'),(577,'souffârrah'),(578,'soug'),(579,'souma-koto : japonais'),(580,'soung-king'),(581,'sounnaïa : Turkestan'),(582,'souqqarah'),(583,'sourdine'),(584,'sousounou'),(585,'souzabone'),(586,'spitzharfe'),(587,'sringa'),(588,'sruti-vina'),(589,'stamentien-pfeiffe'),(590,'Steel tongue drum'),(591,'steel-drum'),(592,'stick'),(593,'stock-horn'),(594,'stopf-trumpet'),(595,'streich-zither : autrichien'),(596,'stretch machine'),(597,'suka'),(598,'suling ou souling : flûte indonésienne'),(600,'sur-bahara : indien'),(601,'sur-vâhâra : indien'),(602,'sur-vina : indien'),(603,'surdo'),(604,'swedish bagpipe : suédois'),(605,'synthétiseur'),(606,'syntophone'),(607,'sze-hou-hsien'),(608,'ta huang hou kin : chinois'),(609,'taakan'),(610,'taarija'),(611,'tablâ : percussion'),(612,'tablat'),(613,'taiko : percussion'),(614,'taïsene'),(615,'taki-koto'),(616,'talain ou talan'),(617,'tam-tam'),(618,'tama : percussion'),(619,'tambin'),(620,'tamborim : percussion, brésilien'),(621,'tambour : tambour baghlamah, tambour basque ou panderoa, tambour d\'eau'),(622,'tambourin : tambourin à cordes (ou ttun-ttun au Pays basque et tamborin en Gascogne), orsater ou tambourin béarnais, tambourin provençal'),(623,'Tambûr'),(624,'tan-tan'),(625,'tao-kou'),(626,'tapan : percussion'),(627,'târ : luth Iran'),(628,'tarambouka'),(629,'tarogato'),(630,'tarole'),(631,'tarqa (ou tarka)'),(632,'tasa'),(633,'tashepoto : apparenté à une cithare, indien et peut-être japonais'),(634,'tatchoota'),(635,'tawaya : Vanuatu'),(636,'tbal : tambour'),(637,'tchang-kou : tambourin japonais'),(638,'tché : flûte chinoise'),(639,'tchengue : harpe double persane'),(640,'tchogor ou tchoger : mandoline persane'),(641,'tchong'),(642,'tchong-tou'),(643,'tchou'),(644,'té-tchong : chinois'),(645,'tebashoul : algérien'),(646,'tebilats'),(647,'tebloun ou tebol : touareg'),(648,'telharmonium : instrument électromécanique'),(649,'tembour : luth kurde'),(650,'tenora : hautbois espagnol'),(651,'terab-enguiz'),(652,'terpodion : anglais'),(653,'terr'),(654,'tet-jer : Java'),(655,'thar'),(656,'thari : caucasien'),(657,'théorbe'),(658,'thérémine : instrument de musique électronique'),(659,'thumgo-tuapan'),(660,'thurnerhorn'),(661,'ti-kin : chinois'),(662,'tien-kou : chinois'),(663,'tilinca : flûte roumaine'),(664,'timba'),(665,'timbale'),(666,'timbales, et timbalitos et timbalon'),(667,'timple'),(668,'tin whistle'),(669,'tiple'),(670,'tjé-tjé : japonais'),(672,'tohona'),(673,'tom'),(674,'tombah : Sierra Leone'),(675,'tombak : iranien'),(676,'toumourah'),(677,'tournebout'),(678,'tourti ou tourryi'),(679,'toutsoumi : japonais'),(680,'trawanga'),(681,'tres'),(682,'triangle'),(683,'tritantri-vina : indien'),(684,'tritare'),(685,'troccola : italien Sicile'),(686,'trombone'),(687,'trompe de chasse'),(688,'trompette'),(689,'trompette de poche'),(690,'trompette marine'),(691,'trompette piccolo'),(692,'tseng'),(693,'tsikadraha ou faray ou racle'),(694,'tsou toung hou-kin'),(695,'tsou-kou'),(696,'tsouma-koto'),(697,'tsouzoumi'),(698,'tuba'),(699,'tuba corva'),(700,'tuba wagnérien'),(701,'tubilattes ou tobillets'),(702,'tubri'),(703,'tubular bells'),(704,'tumburu-vina'),(705,'turi'),(706,'turr'),(707,'txalaparta : Pays basque'),(708,'txanbela'),(709,'txirula : flûte du Pays basque, utilisée en Soule'),(710,'txistu : flûte du Pays basque'),(711,'ty'),(712,'tympanon'),(713,'udu'),(714,'ukulélé'),(715,'venu : flûte traversière indienne'),(716,'veuze : cornemuse de Haute-Bretagne'),(717,'vibraphone'),(718,'vibraslap, fouet vobrant'),(719,'vièle'),(720,'vielle à roue'),(721,'vihuela'),(722,'vînâ : indien'),(723,'viole'),(724,'viole d\'amour'),(725,'viole de gambe'),(726,'violon'),(727,'violon à pavillon : roumain'),(728,'violoncelle'),(729,'violone'),(730,'virginal : famille des clavecins'),(731,'voix'),(732,'Vuvuzela'),(733,'wakrapuku : trompe péruvienne'),(734,'waterphone'),(735,'wood-block'),(736,'xaphoon'),(737,'xiao'),(738,'xun'),(739,'xylophone'),(740,'yabara ou sira'),(741,'yang ou Lo'),(742,'yueqin'),(743,'zampoña'),(744,'zarb : tambour persan'),(745,'zurna');
/*!40000 ALTER TABLE `instrument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level_instrument`
--

DROP TABLE IF EXISTS `level_instrument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `level_instrument` (
  `id_musician` int(11) NOT NULL,
  `id_instrument` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id_musician`,`id_instrument`),
  KEY `level_instrument_instrument1_FK` (`id_instrument`),
  CONSTRAINT `level_instrument_instrument1_FK` FOREIGN KEY (`id_instrument`) REFERENCES `instrument` (`id_instrument`),
  CONSTRAINT `level_instrument_musician0_FK` FOREIGN KEY (`id_musician`) REFERENCES `musician` (`id_musician`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level_instrument`
--

LOCK TABLES `level_instrument` WRITE;
/*!40000 ALTER TABLE `level_instrument` DISABLE KEYS */;
INSERT INTO `level_instrument` VALUES (29,1,1),(29,2,2),(30,1,3),(30,2,4),(31,1,2),(31,2,3),(32,1,4),(32,2,1),(33,1,3),(33,2,1),(34,1,3),(34,2,3),(35,1,1),(35,2,4),(36,1,4),(36,2,4),(37,1,2),(37,2,2),(38,1,2),(38,2,2),(38,17,3),(39,209,2),(40,2,2),(41,144,2),(42,209,2),(44,1,1),(44,207,2),(45,209,2),(45,297,2),(45,739,1),(46,209,2),(47,209,2),(48,115,4),(49,2,2),(50,2,2);
/*!40000 ALTER TABLE `level_instrument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musician`
--

DROP TABLE IF EXISTS `musician`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `musician` (
  `id_musician` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(250) NOT NULL,
  `alias` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `postcode` varchar(25) NOT NULL,
  `bio` text NOT NULL,
  `avatar` varchar(250) NOT NULL,
  `availability` varchar(7) NOT NULL,
  `search_type` int(11) NOT NULL,
  PRIMARY KEY (`id_musician`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musician`
--

LOCK TABLES `musician` WRITE;
/*!40000 ALTER TABLE `musician` DISABLE KEYS */;
INSERT INTO `musician` VALUES (29,'michel','michel@michel.com','michel@michel.com','31000','J\'aime beaucoup le heavy metal et le kazoo.','','1110111',2),(30,'joe','joe@joe.com','joe@joe.com','31000','','','1011111',3),(31,'jack','jack@jack.com','jack@jack.com','31000','','','1111111',3),(32,'vero','vero@vero.com','vero@vero.com','31500','','','1111111',3),(33,'bob','bob@bob.com','bob@bob.com','31170','','','1111111',3),(34,'will','will@will.com','will@will.com','31770','','','1111111',3),(35,'henri','henri@henri.com','henri@henri.com','31400','','','1111111',3),(36,'dd','dd@dd.com','dd@dd.com','31000','','','1111111',3),(37,'raoul','raoul@rosita.fr','raoul@rosita.fr','31300','','','1111111',3),(38,'coucou','mam@gmail.com','mam@gmail.com','31000','','','1100111',3),(39,'lol','Hubert Bonnisseur de la batte','test@final.fr','31000','','','1111111',3),(40,'lol','test@final.fr','test@final.fr','31000','','','1111111',3),(41,'lol','loulou@oui.fr','loulou@oui.fr','24000','','','1111111',3),(42,'lol','Hubert Bonnisseur de la batte','coucou@gmail.fr','31400','lol','','1111111',3),(43,'george','george@george.com','george@george.com','31000','','','1111111',3),(44,'george','george@george.com','george@george.com','31000','Lulz, TL:DR','','0111111',3),(45,'bobby','bobby@gmail.fr','bobby@gmail.fr','31000','','','1111111',3),(46,'coucou','michel@coucou.fr','michel@coucou.fr','31000','coucou','','0000000',3),(47,'lolo','lolo','lolo@coucou.fr','31400','','','1111111',3),(48,'lol','Vive le cornet à bouquin','recherche@gmail.com','31600','','','1111111',3),(49,'raoul','Tacos Raoul','eaoul@raoul.com','31100','','','0001110',3),(50,'leon','tacos master leon','leon@leon.com','31000','je s\'appel leon','','0001110',3);
/*!40000 ALTER TABLE `musician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `need`
--

DROP TABLE IF EXISTS `need`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `need` (
  `id_need` int(11) NOT NULL AUTO_INCREMENT,
  `id_instrument` int(11) DEFAULT NULL,
  `id_band` int(11) DEFAULT NULL,
  `availability` varchar(7) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `encours` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_need`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `need`
--

LOCK TABLES `need` WRITE;
/*!40000 ALTER TABLE `need` DISABLE KEYS */;
INSERT INTO `need` VALUES (1,209,4,'1000111',2,'1'),(2,210,5,'1111111',1,'1'),(3,1,6,'1111111',2,'1'),(4,2,6,'1111111',2,'1'),(5,144,13,'1111000',2,'1'),(6,209,13,'0001111',2,'0'),(7,299,14,'0111000',1,'0'),(8,27,14,'0111000',2,'1'),(9,14,14,'0110000',3,'0'),(10,14,14,'1110000',2,'1'),(11,207,15,'0111110',2,'1'),(12,299,16,'0000110',1,'1'),(13,209,17,'0000011',2,'1'),(14,2,18,'0000111',2,'1');
/*!40000 ALTER TABLE `need` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search`
--

DROP TABLE IF EXISTS `search`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search` (
  `id_search` int(11) NOT NULL AUTO_INCREMENT,
  `postcode` varchar(150) NOT NULL,
  `availability` varchar(7) NOT NULL,
  `search_type` int(11) NOT NULL,
  `id_instrument` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `id_style` int(11) NOT NULL,
  `id_musician` int(11) NOT NULL,
  `id_instrument2` int(11) DEFAULT NULL,
  `level2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_search`),
  UNIQUE KEY `search_musician0_AK` (`id_musician`),
  CONSTRAINT `search_musician0_FK` FOREIGN KEY (`id_musician`) REFERENCES `musician` (`id_musician`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search`
--

LOCK TABLES `search` WRITE;
/*!40000 ALTER TABLE `search` DISABLE KEYS */;
INSERT INTO `search` VALUES (1,'31000','1100111',3,1,2,0,38,2,'2'),(2,'31000','1111111',3,209,2,1,39,0,'0'),(3,'31000','1111111',3,2,2,0,40,2,'0'),(4,'24000','1111111',3,144,2,0,41,0,'0'),(5,'31400','1111111',3,209,2,1,42,0,'0'),(6,'31000','0111111',3,1,1,0,44,207,'2'),(7,'31000','1110000',3,209,2,1,45,297,'2'),(8,'31000','0000100',3,209,2,1,46,0,'0'),(9,'31400','1111111',3,299,1,1,47,0,'0'),(10,'31600','1111111',3,115,4,0,48,0,'0'),(11,'31100','0001110',3,2,2,0,49,0,'0'),(12,'31000','0001110',3,2,2,0,50,0,'0');
/*!40000 ALTER TABLE `search` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search_instrument`
--

DROP TABLE IF EXISTS `search_instrument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search_instrument` (
  `id_search` int(11) NOT NULL,
  `id_instrument` int(11) NOT NULL,
  PRIMARY KEY (`id_search`,`id_instrument`),
  KEY `search_instrument_instrument1_FK` (`id_instrument`),
  CONSTRAINT `search_instrument_instrument1_FK` FOREIGN KEY (`id_instrument`) REFERENCES `instrument` (`id_instrument`),
  CONSTRAINT `search_instrument_search0_FK` FOREIGN KEY (`id_search`) REFERENCES `search` (`id_search`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_instrument`
--

LOCK TABLES `search_instrument` WRITE;
/*!40000 ALTER TABLE `search_instrument` DISABLE KEYS */;
/*!40000 ALTER TABLE `search_instrument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style`
--

DROP TABLE IF EXISTS `style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `style` (
  `id_style` int(11) NOT NULL AUTO_INCREMENT,
  `style` varchar(250) NOT NULL,
  PRIMARY KEY (`id_style`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style`
--

LOCK TABLES `style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
INSERT INTO `style` VALUES (1,'Tous les styles'),(2,'Pop Rock'),(3,'Metal'),(4,'Jazz'),(5,'Hip Hop'),(6,'Electro'),(7,'Classique'),(8,'World'),(9,'Folk'),(10,'Chorale'),(11,'Flamenco'),(12,'Musiques traditionnelles'),(13,'Dub Step'),(14,'Rock progressif'),(15,'Hardcore'),(16,'Punk rock'),(17,'Math rock'),(18,'Dub'),(19,'Reggae'),(20,'Swing');
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-09 16:46:19