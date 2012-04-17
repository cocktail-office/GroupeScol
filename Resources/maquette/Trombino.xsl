<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE xsl:stylesheet
[
<!ENTITY  nbsp  "&#160;">
<!ENTITY  space  "&#x20;">
<!ENTITY  br  "&#x2028;">
]>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <!-- définition des patterns pour la fonction format-number -->
    <xsl:decimal-format decimal-separator="," grouping-separator=" "/>
    <!-- TPL INFO PLAN-->
    <xsl:template name="InfoTrombino" match="InfoTrombino">
        <xsl:for-each select="Ligne">
            <fo:table inline-progression-dimension="280mm" height="45mm">
                <fo:table-column/>
                <fo:table-body>
                    <fo:table-row>
                        <fo:table-cell>
                            <fo:block>
                                <fo:table inline-progression-dimension="100%" height="40mm">
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-column widht="25mm"/>
                                    <fo:table-body>
                                        <fo:table-row>
                                            <xsl:for-each select="Etudiant">
                                                <fo:table-cell>
                                                  <fo:block>
                                                      <fo:table inline-progression-dimension="25mm" height="40mm">
                                                          <fo:table-column />
                                                          <fo:table-body>
                                                              <fo:table-row>
                                                                  <fo:table-cell>
                                                                      <fo:block>
                                                                          <fo:table inline-progression-dimension="25mm" height="35mm">
                                                                              <fo:table-column />
                                                                              <fo:table-body>
                                                                                  <fo:table-row>
                                                                                       <fo:table-cell >
                                                                                          <fo:block>
                                                                                              <xsl:element name="fo:external-graphic">
                                                                                                  <xsl:attribute name="src">url('<xsl:value-of select="Photo"/>')
                                                                                                  </xsl:attribute>
                                                                                              </xsl:element>
                                                                                          </fo:block>
                                                                                      </fo:table-cell>
                                                                                  </fo:table-row>
                                                                               </fo:table-body>
                                                                            </fo:table>
                                                                      </fo:block>
                                                                  </fo:table-cell>
                                                              </fo:table-row>
                                                              <fo:table-row>
                                                                  <fo:table-cell>
                                                                      <fo:block text-align="center" font-size="9pt">
                                                                          <xsl:value-of select="Nom"/>
                                                                      </fo:block>
                                                                  </fo:table-cell>
                                                              </fo:table-row>
                                                              <fo:table-row>
                                                                  <fo:table-cell>
                                                                      <fo:block text-align="center" font-size="8pt">
                                                                          <xsl:value-of select="Prenom"/>
                                                                      </fo:block>
                                                                  </fo:table-cell>
                                                              </fo:table-row>
                                                          </fo:table-body>
                                                      </fo:table>
                                                  </fo:block>
                                                </fo:table-cell>
                                            </xsl:for-each>
                                        </fo:table-row>
                                    </fo:table-body>
                                </fo:table>
                            </fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>
        </xsl:for-each>
    </xsl:template>
    <!-- TPL Entete-->
    <xsl:template name="Entete" match="Entete">
        <fo:table inline-progression-dimension="100%" height="35mm">
            <fo:table-column column-width="30mm"/>
            <fo:table-column column-width="1mm"/>
            <fo:table-column column-width="250mm"/>
            <fo:table-body>
                <fo:table-row>
                    <fo:table-cell>
                        <fo:block>
                            <fo:external-graphic src="url('logo_ulr.jpg')"/>
                        </fo:block>
                    </fo:table-cell>
                    <fo:table-cell>
                        <fo:block/>
                    </fo:table-cell>
                    <fo:table-cell border-width="0.5pt" border-style="solid">
                        <fo:table>
                            <fo:table-column column-width="2mm"/>
                            <fo:table-column column-width="25mm"/>
                            <fo:table-column column-width="130mm"/>
                            <fo:table-column column-width="45mm"/>
                            <fo:table-column/>
                            <fo:table-body>
                                <fo:table-row height="5mm">
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block text-align="center">&nbsp;</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left" font-weight="bold">Diplôme :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left">
                                            <xsl:value-of select="Diplome"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left" font-weight="bold">Année
                                            Universitaire :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left">
                                            <xsl:value-of select="Annee"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row height="5mm">
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block text-align="center">&nbsp;</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left" font-weight="bold">Spécialité :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left">
                                            <xsl:value-of select="Specialite"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row height="5mm">
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block text-align="center">&nbsp;</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left" font-weight="bold">Semestre :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left">
                                            <xsl:value-of select="semestre"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left" font-weight="bold">Groupe :</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="left">
                                            <xsl:value-of select="Groupe"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
    </xsl:template>
    <!-- TPL piedDePage-->
    <xsl:template name="piedDePage" match="piedDePage">
        <fo:table width="100%" table-layout="fixed" space-before="0pt" padding="0pt">
            <fo:table-column/>
            <fo:table-body>
                <fo:table-row text-align="center" display-align="center">
                    <fo:table-cell>
                        <fo:block font-size="8pt" text-align="center">- <fo:page-number/>- </fo:block>
                    </fo:table-cell>
                </fo:table-row>
            </fo:table-body>
        </fo:table>
    </xsl:template>
    <!-- TPL PlanFormation-->
    <xsl:template name="PlanTrombino" match="PlanTrombino">
        <fo:static-content flow-name="xsl-region-end"/>
        <fo:static-content flow-name="xsl-region-after">
            <xsl:call-template name="piedDePage"/>
        </fo:static-content>
        <fo:static-content flow-name="xsl-region-before">
            <xsl:apply-templates select="Entete"/>
        </fo:static-content>
        <fo:static-content flow-name="xsl-region-start"/>
        <fo:flow flow-name="xsl-region-body">
            <xsl:apply-templates select="InfoTrombino"/>
        </fo:flow>
    </xsl:template>
    <xsl:template name="toto" match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" margin-top="1cm" margin-bottom="1cm"
                    page-width="297mm" page-height="210mm" margin-left="1cm" margin-right="1cm">
                    <fo:region-before extent="3.5cm"/>
                    <fo:region-after extent="5mm"/>
                    <fo:region-start/>
                    <fo:region-end/>
                    <fo:region-body margin-bottom="10mm" margin-top="40mm" margin-left="0cm" margin-right="0cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="page">
                <xsl:apply-templates select="PlanTrombino"/>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
