<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:output method="xml" indent="yes" />
	
	<xsl:template match="/">
		<soapenv:Envelope 
						xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
						xmlns="http://fedex.com/ws/ship/v17">
			<soapenv:Body>
				<ProcessShipmentRequest>
					<WebAuthenticationDetail>
						<UserCredential>
							<Key>
								<xsl:value-of select="//Shipment/WebAuthenticationDetail/UserCredential/Key" />
							</Key>
							<Password>
								<xsl:value-of select="//Shipment/WebAuthenticationDetail/UserCredential/Password" />
							</Password>
						</UserCredential>
					</WebAuthenticationDetail>
				</ProcessShipmentRequest>
				<ClientDetail>
					<AccountNumber>
						<xsl:value-of select="//Shipment/ClientDetail/AccountNumber" />
					</AccountNumber>
					<MeterNumber>
						<xsl:value-of select="//Shipment/ClientDetail/MeterNumber" />
					</MeterNumber>
				</ClientDetail>
				<Version>
					<ServiceId>
						<xsl:value-of select="//Shipment/Version/ServiceId" />
					</ServiceId>
					<Major>
						<xsl:value-of select="//Shipment/Version/Major" />
					</Major>
					<Intermediate>
						<xsl:value-of select="//Shipment/Version/Intermediate" />
					</Intermediate>
					<Minor>
						<xsl:value-of select="//Shipment/Version/Minor" />
					</Minor>
				</Version>
				<RequestedShipment>
					<ShipTimestamp>
						<xsl:value-of select="//Shipment/RequestedShipment/ShipTimestamp" />
					</ShipTimestamp>
					<DropoffType>
						<xsl:value-of select="//Shipment/RequestedShipment/DropoffType" />
					</DropoffType>
					<ServiceType>
						<xsl:value-of select="//ServiceVal/HostServiceType/HostNaming/HostName/Service" />
					</ServiceType>
					<PackagingType>
						<xsl:value-of select="//Shipment/RequestedShipment/PackagingType" />
					</PackagingType>
				</RequestedShipment>
				<Shipper>
					<Contact>
						<PersonName>
							<xsl:value-of select="//Sender/Contact/PersonName" />
						</PersonName>
						<CompanyName>
							<xsl:value-of select="//Sender/Contact/CompanyName" />
						</CompanyName>
						<PhoneNumber>
							<xsl:value-of select="//Sender/Contact/PhoneNumber" />
						</PhoneNumber>
					</Contact>
					<Address>
						<StreetLines>
							<xsl:value-of select="//Sender/Address/StreetLine1" />
						</StreetLines>
						<StreetLines>
							<xsl:value-of select="//Sender/Address/StreetLine2" />
						</StreetLines>
						<City>
							<xsl:value-of select="//Sender/Address/City" />
						</City>
						<StateOrProvinceCode>
							<xsl:value-of select="//Sender/Address/StateOrProvinceCode" />
						</StateOrProvinceCode>
						<PostalCode>
							<xsl:value-of select="//Sender/Address/PostalCode" />
						</PostalCode>
						<CountryCode>
							<xsl:value-of select="//Sender/Address/CountryCode" />
						</CountryCode>
					</Address>
				</Shipper>
				<Recipient>
					<Contact>
						<PersonName>
							<xsl:value-of select="//Recipient/Contact/PersonName" />
						</PersonName>
						<CompanyName>
							<xsl:value-of select="//Recipient/Contact/CompanyName" />
						</CompanyName>
						<PhoneNumber>
							<xsl:value-of select="//Recipient/Contact/PhoneNumber" />
						</PhoneNumber>
					</Contact>
					<Address>
						<StreetLine1>
							<xsl:value-of select="//Recipient/Address/StreetLine1" />
						</StreetLine1>
						<StreetLine2>
							<xsl:value-of select="//Recipient/Address/StreetLine2" />
						</StreetLine2>
						<City>
							<xsl:value-of select="//Recipient/Address/City" />
						</City>
						<StateOrProvinceCode>
							<xsl:value-of select="//Recipient/Address/StateOrProvinceCode" />
						</StateOrProvinceCode>
						<PostalCode>
							<xsl:value-of select="//Recipient/Address/PostalCode" />
						</PostalCode>
						<CountryCode>
							<xsl:value-of select="//Recipient/Address/CountryCode" />
						</CountryCode>
						<ResidentialAddressIndicator>
							<xsl:value-of select="//Recipient/Address/ResidentialAddressIndicator" />
						</ResidentialAddressIndicator>
					</Address>
				</Recipient>
				<ShippingChargesPayment>
					<PaymentType>
						<xsl:value-of select="//ShippingChargesPayment/PaymentType" />
					</PaymentType>
					<Payor>
						<ResponsibleParty>
							<AccountNumber>
								<xsl:value-of select="//ClientDetail/AccountNumber" />
							</AccountNumber>
							<Address>
								<PostalCode/>
								<CountryCode>
									<xsl:value-of select="//Recipient/Address/CountryCode" />
								</CountryCode>
							</Address>
						</ResponsibleParty>
					</Payor>
				</ShippingChargesPayment>	
				<LabelSpecification>
					<LabelFormatType>
						<xsl:value-of select="//LabelSpecification/LabelFormatType" />
					</LabelFormatType>
					<ImageType>
						<xsl:value-of select="//LabelSpecification/ImageType" />
					</ImageType>
				</LabelSpecification>
				<PackageCount>
					<xsl:value-of select="//Packages/PackageCount" />
				</PackageCount>
				<RequestedPackageLineItems>
					<xsl:for-each select="//Packages/Package">
					<Weight>
						<Units>
							<xsl:value-of select="Weight/Units" />
						</Units>
						<Value>
							<xsl:value-of select="Weight/Value" />
						</Value>
					</Weight>
					<Dimensions>
						<Length>
							<xsl:value-of select="Dimensions/Length" />
						</Length>
						<Width>
							<xsl:value-of select="Dimensions/Width" />
						</Width>
						<Height>
							<xsl:value-of select="Dimensions/Height" />
						</Height>
						<Units>
							<xsl:value-of select="Dimensions/Units" />
						</Units>
					</Dimensions>
					</xsl:for-each>
				</RequestedPackageLineItems>
			</soapenv:Body>
		</soapenv:Envelope>
	</xsl:template>
	
</xsl:stylesheet>