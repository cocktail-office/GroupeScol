
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
-- Numéro de version : 1.4.0.1
-- Pré-requis : base version 1.4.0.0
-- Date de publication : 29/11/2011
-- Auteur(s) : Patrice DE MEYER
-- Licence : CeCILL version 2
--
-- A lancer sous : EDTSCOL
--

--

grant delete on edtscol.ctrl_param_ap to scolarite;
grant delete on edtscol.ctrl_param_ap_individu to scolarite;
grant delete on edtscol.ctrl_param_ap_objet to scolarite;
grant delete on edtscol.ctrl_param_ap_salle to scolarite;
grant delete on edtscol.ctrl_param_ap_salle_choix to scolarite;

--

ALTER TABLE EDTSCOL.CTRL_PARAM_AP DROP CONSTRAINT FK_CTRL_PARAM_AP_GGRP_KEY;
ALTER TABLE EDTSCOL.CTRL_PARAM_AP_INDIVIDU DROP CONSTRAINT FK_CTRL_PARAM_AP_IND_CPA_KEY;
ALTER TABLE EDTSCOL.CTRL_PARAM_AP_OBJET DROP CONSTRAINT FK_CTRL_PARAM_AP_OBJ_CPA_KEY;
ALTER TABLE EDTSCOL.CTRL_PARAM_AP_SALLE DROP CONSTRAINT FK_CTRL_PARAM_AP_SAL_CPA_KEY;
ALTER TABLE EDTSCOL.CTRL_PARAM_AP_SALLE_CHOIX DROP CONSTRAINT FK_CTRL_PARAM_AP_SALC_CPA_KEY;
ALTER TABLE SCOLARITE.SCOL_GROUPE_GRP DROP CONSTRAINT GGRP_REF_GCOL;

ALTER TABLE EDTSCOL.CTRL_PARAM_AP ADD (
  CONSTRAINT FK_CTRL_PARAM_AP_GGRP_KEY 
 FOREIGN KEY (GGRP_KEY) 
 REFERENCES SCOLARITE.SCOL_GROUPE_GRP (GGRP_KEY)
 DEFERRABLE INITIALLY DEFERRED);

ALTER TABLE EDTSCOL.CTRL_PARAM_AP_INDIVIDU ADD (
  CONSTRAINT FK_CTRL_PARAM_AP_IND_CPA_KEY 
 FOREIGN KEY (CPA_KEY) 
 REFERENCES EDTSCOL.CTRL_PARAM_AP (CPA_KEY)
 DEFERRABLE INITIALLY DEFERRED);

ALTER TABLE EDTSCOL.CTRL_PARAM_AP_OBJET ADD (
  CONSTRAINT FK_CTRL_PARAM_AP_OBJ_CPA_KEY 
 FOREIGN KEY (CPA_KEY) 
 REFERENCES EDTSCOL.CTRL_PARAM_AP (CPA_KEY)
 DEFERRABLE INITIALLY DEFERRED);

ALTER TABLE EDTSCOL.CTRL_PARAM_AP_SALLE ADD (
  CONSTRAINT FK_CTRL_PARAM_AP_SAL_CPA_KEY 
 FOREIGN KEY (CPA_KEY) 
 REFERENCES EDTSCOL.CTRL_PARAM_AP (CPA_KEY)
 DEFERRABLE INITIALLY DEFERRED);

ALTER TABLE EDTSCOL.CTRL_PARAM_AP_SALLE_CHOIX ADD (
  CONSTRAINT FK_CTRL_PARAM_AP_SALC_CPA_KEY 
 FOREIGN KEY (CPA_KEY) 
 REFERENCES EDTSCOL.CTRL_PARAM_AP (CPA_KEY)
 DEFERRABLE INITIALLY DEFERRED);

ALTER TABLE SCOLARITE.SCOL_GROUPE_GRP ADD (
  CONSTRAINT GGRP_REF_GCOL 
 FOREIGN KEY (GCOL_KEY) 
 REFERENCES SCOLARITE.SCOL_GROUPE_COLLECTION (GCOL_KEY)
 DEFERRABLE INITIALLY DEFERRED);

--

COMMIT;
