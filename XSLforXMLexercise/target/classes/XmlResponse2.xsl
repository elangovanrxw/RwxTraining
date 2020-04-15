<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
				xmlns:reply="http://fedex.com/ws/ship/v17">
				
<xsl:output method="xml" indent="yes" encoding="UTF-8" />				
	<xsl:template match="/">
		<xsl:element name="ShipReply">
		
			<xsl:element name="Notification">
				<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/reply:Notifications/reply:Severity" />
			</xsl:element>
			
			<xsl:element name="Code">
				<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/reply:Notifications/reply:Code" />
			</xsl:element>
			
			<xsl:element name="Message">
				<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/reply:Notifications/reply:Message" />
			</xsl:element>
			
			<xsl:element name="CompletedShipmentDetail">
				<xsl:element name="Carrier">
					<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:MasterTrackingId/reply:TrackingIdType" />
				</xsl:element>
				
				<xsl:if test="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:OperationalDetail/reply:ServiceType">
					<xsl:element name="ServiceType">
						<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:OperationalDetail/reply:ServiceType" />
					</xsl:element>
				</xsl:if>
				
				<xsl:if test="not(//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:OperationalDetail/reply:ServiceType)">
					<xsl:element name="ServiceType">Only Service code is available</xsl:element>
				</xsl:if>
				
				
				<xsl:element name="CommitDetails">
					<xsl:element name="CommitTimestamp">
						<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:OperationalDetail/reply:TransitTime" />
					</xsl:element>
				</xsl:element>
				
				<xsl:element name="SequenceNumber">
					<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:CompletedPackageDetails/reply:SequenceNumber" />
				</xsl:element>
				
				<xsl:element name="MasterTrackingId">
					<xsl:if test="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:MasterTrackingId/reply:TrackingId">
						<xsl:element name="TrackingNumber">
							<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
									reply:CompletedShipmentDetail/reply:MasterTrackingId/reply:TrackingId" />
						</xsl:element>
					</xsl:if>
					
					<xsl:if test="not(//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:MasterTrackingId/reply:TrackingId)">
						<xsl:element name="TrackingNumber">No MasterTrackingId</xsl:element>		
					</xsl:if>
				</xsl:element>
				
				
				<xsl:element name="TrackingIds">
					<xsl:element name="TrackingNumber">
						<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:CompletedPackageDetails/reply:TrackingIds/reply:TrackingNumber" />
					</xsl:element>
				</xsl:element>
				
				<xsl:if test="not(//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:ManifestMsn)">
							<xsl:element name="ManifestMsn">Not Available</xsl:element>	
				</xsl:if>
				
				<xsl:if test="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:ManifestMsn">
							<xsl:element name="ManifestMsn">
								<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
										reply:CompletedShipmentDetail/reply:ManifestMsn" />
							</xsl:element>	
				</xsl:if>
				
				<xsl:element name="Label">
				
					<xsl:element name="Type">
						<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:CompletedPackageDetails/reply:Label/reply:Type" />
					</xsl:element>
					
					<xsl:element name="ImageType">
						<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:CompletedPackageDetails/reply:Label/reply:ImageType" />
					</xsl:element>
					
					<xsl:element name="Resolution">
						<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:CompletedPackageDetails/reply:Label/reply:Resolution" />
					</xsl:element>
					
					<xsl:element name="Image">
						<xsl:value-of select="//SOAP-ENV:Envelope/SOAP-ENV:Body/reply:ProcessShipmentReply/
						reply:CompletedShipmentDetail/reply:CompletedPackageDetails/reply:Label/reply:Parts/reply:Image" />
					</xsl:element>
					
				</xsl:element>
			</xsl:element>
		</xsl:element>
	</xsl:template>
</xsl:stylesheet>