<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="xml" indent="yes" encoding="UTF-8" />

	<xsl:template match="/">
		<Shipment>
			<ServiceVal>
				<HostServiceType>
					<HostNaming>
						<HostName>
							<Carrier>
								<xsl:value-of select="//Carrier" />
							</Carrier>
							<Service>
								<xsl:value-of select="//Service//HostName/Service"/>
							</Service>
							<Type/>
							<AncillaryEndorsement/>
							<HubId/>
						</HostName>
					</HostNaming>
				</HostServiceType>
			</ServiceVal>
		
		
		<Shipper>
			<shipper_id>
				<xsl:value-of select="//shipper_id"/>
			</shipper_id>
		</Shipper>
		
		<Sender>
		<Contact>
			<CompanyName>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/CompanyName" />
			</CompanyName>
			<PersonName>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/PersonName" />
			</PersonName>
			<PhoneNumber>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/PhoneNumber" />
			</PhoneNumber>
		</Contact>
		<Address>
			<StreetLine1>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/StreetLine1" />
			</StreetLine1>
			<StreetLine2>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/StreetLine2" />
			</StreetLine2>
			<City>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/City" />
			</City>
			<StateOrProvinceCode>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/StateOrProvinceCode" />
			</StateOrProvinceCode>
			<PostalCode>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/PostalCode" />
			</PostalCode>
			<CountryCode>
				<xsl:value-of select="//ShipFromAddress/FromContactAndAddress/CountryCode" />
			</CountryCode>
			<ResidentialAddressIndicator/>
		</Address>
	</Sender>
	
	<Recipient>
		<Contact>
			<PersonName>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/PersonName" />
			</PersonName>
			<CompanyName>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/CompanyName" />
			</CompanyName>
			<PhoneNumber>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/PhoneNumber" />
			</PhoneNumber>
		</Contact>
		<Address>
			<StreetLine1>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/StreetLine1" />
			</StreetLine1>
			<StreetLine2>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/StreetLine2" />
			</StreetLine2>
			<City>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/City" />
			</City>
			<StateOrProvinceCode>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/StateOrProvinceCode" />
			</StateOrProvinceCode>
			<PostalCode>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/PostalCode" />
			</PostalCode>
			<CountryCode>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/CountryCode" />
			</CountryCode>
			<ResidentialAddressIndicator>
				<xsl:value-of select="//ShipToAddress/ToContactAndAddress/ResidentialAddressIndicator" />
			</ResidentialAddressIndicator>
		</Address>
	</Recipient>
	
	
	<Packages>
		<PackageCount>
			<xsl:value-of select="//Packages/PackageCount" />
		</PackageCount>
		<xsl:for-each select="//Packages/Package">	
		<Package>
			<DropOffTime>
				<xsl:value-of select="DropOffTime" />
			</DropOffTime>
			<ShipDate>
				<xsl:value-of select="ShipDate" />
			</ShipDate>
			<PackagingType>
				<PackagingTypeCode>
					<xsl:value-of select="PackagingType/PackagingTypeCode" />
				</PackagingTypeCode>
			</PackagingType>
			<PackageCount>
				<xsl:value-of select="PackageCount" />
			</PackageCount>
			<Weight>
				<Units>
					<xsl:value-of select="Weight/WeightUnitOfMeasurement/WeightCode" />
				</Units>
				<Value>
					<xsl:value-of select="Weight/Weight" />
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
		</Package>
		</xsl:for-each>
	</Packages>
	
	<PaymentInformation>
		<ShipmentCharge>
			<Type>
				<xsl:value-of select="//PaymentInformation/ShipmentCharge/Type" />
			</Type>
			<BillShipper>
				<AccountNumber>
					<xsl:value-of select="//PaymentInformation/ShipmentCharge/BillShipper/AccountNumber" />
				</AccountNumber>
				<ShipperAddress>
					<PostalCode/>
					<CountryCode>
						<xsl:value-of select="//PaymentInformation/ShipmentCharge/BillShipper/CreditCard/ShipperAddress/CountryCode" />
					</CountryCode>
				</ShipperAddress>
			</BillShipper>
			<BillThirdParty>
				<AccountNumber/>
				<ThirdPartyAddress>
					<PostalCode/>
					<CountryCode>
						<xsl:value-of select="//PaymentInformation/ShipmentCharge/BillThirdParty/ThirdPartyAddress/CountryCode" />
					</CountryCode>
				</ThirdPartyAddress>
			</BillThirdParty>
			<BillReceiver>
				<AccountNumber/>
				<ReceiverAddress>
					<PostalCode/>
				</ReceiverAddress>
			</BillReceiver>
		</ShipmentCharge>
	</PaymentInformation>
	
	<LabelSpecification>
		<ImageType>
			<xsl:value-of select="/Shipment/LabelSpecification/ImageType" />
		</ImageType>
	</LabelSpecification>
	</Shipment>
	</xsl:template>
	
</xsl:stylesheet>