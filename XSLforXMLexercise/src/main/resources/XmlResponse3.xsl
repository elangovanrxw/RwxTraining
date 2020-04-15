<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" 
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
				xmlns:key="http://schemas.datacontract.org/2004/07/Key2Act.OnPremiseServices.TTTrx.eTimeTrackService"
				xmlns:tem="http://tempuri.org/">

<xsl:output method="xml" indent="yes" encoding="UTF-8" />

	<xsl:template match="/">
		<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
				xmlns:key="http://schemas.datacontract.org/2004/07/Key2Act.OnPremiseServices.TTTrx.eTimeTrackService"
				xmlns:tem="http://tempuri.org/">
			<xsl:element name="soap:Header"/>
				<xsl:element name="soap:Body">
					<xsl:element name="tem:InsertTransaction">
						<xsl:element name="tem:Tenant">
							<xsl:value-of select="//InsertTransaction/Tenant" />
						</xsl:element>
						<xsl:element name="tem:Companydbname">
							<xsl:value-of select="//InsertTransaction/Companydbname" />
						</xsl:element>
						<xsl:element name="tem:trx">

								<xsl:apply-templates select="//trx/*" />

						</xsl:element>
					</xsl:element>
					
				</xsl:element>
		</soap:Envelope>
	</xsl:template>
	
	
	<xsl:template match="*" >
		<xsl:element name="key:{name()}" namespace="http://schemas.datacontract.org/2004/07/Key2Act.OnPremiseServices.TTTrx.eTimeTrackService">
			<xsl:copy-of select="namespace::*" />
			<xsl:apply-templates select="node()"/>
		</xsl:element>
	</xsl:template>
	
</xsl:stylesheet>