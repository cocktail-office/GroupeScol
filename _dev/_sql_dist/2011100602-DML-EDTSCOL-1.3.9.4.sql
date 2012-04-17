
SET DEFINE OFF;

-- 
-- __________________________________________________________
--  /!\ ATTENTION /!\ fichier encodé en UTF-8 sans BOM
-- (il peut contenir des é è ç à î ê ô ...)
-- __________________________________________________________
--
--

--
-- Fichier : 2
-- Type : DML
-- Schéma : EDTSCOL
-- Numéro de version : 1.3.9.4
-- Pré-requis : base version 1.3.9.3 minimum
-- Date de publication : 06/10/2011
-- Auteur(s) : Patrice DE MEYER
-- Licence : CeCILL version 2
--
-- A lancer sous : EDTSCOL ou GRHUM
--
--

insert into edtscol.db_version (db_version, db_date, db_comment)
values ('1.3.9.4', to_date('06/10/2011','dd/mm/yyyy'), '');

--

COMMIT;
