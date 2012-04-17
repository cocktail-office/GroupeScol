
SET DEFINE OFF;

-- 
-- __________________________________________________________
--  /!\ ATTENTION /!\ fichier encodé en UTF-8 sans BOM
-- (il peut contenir des é è ç à î ê ô ...)
-- __________________________________________________________
--
--

--
-- Fichier : 1
-- Type : DDL
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

create or replace view edtscol.v_scol_maquette_ap_ec (map_key, mec_key)
as
select mrap.map_key, mrap.mec_key
from scolarite.scol_maquette_repartition_ap mrap
where mrap_majeur = 'O' or mrap_majeur is null;

--

COMMIT;
