/*
  Copyright 1995-2017 Esri

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

  For additional information, contact:
  Environmental Systems Research Institute, Inc.
  Attn: Contracts Dept
  380 New York Street
  Redlands, California, USA 92373

  email: contracts@esri.com
 */
package com.esri.geoevent.transport.azure;

import com.esri.ges.core.property.LabeledValue;
import com.esri.ges.core.property.PropertyDefinition;
import com.esri.ges.core.property.PropertyException;
import com.esri.ges.core.property.PropertyType;
import com.esri.ges.framework.i18n.BundleLogger;
import com.esri.ges.framework.i18n.BundleLoggerFactory;
import com.esri.ges.transport.TransportDefinitionBase;
import com.esri.ges.transport.TransportType;

import java.util.ArrayList;
import java.util.List;

public class AzureAsDeviceOutboundTransportDefinition extends TransportDefinitionBase {
  // logger
  private static final BundleLogger LOGGER = BundleLoggerFactory.getLogger(AzureAsDeviceOutboundTransportDefinition.class);

  private static final String CONNECTION_PROTOCOL_LBL_1 = "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_PROTOCOL_AMQPS_LBL}";
  private static final String CONNECTION_PROTOCOL_VAL_1 = "AMQPS";
  private static final String CONNECTION_PROTOCOL_LBL_2 = "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_PROTOCOL_AMQPS_WS_LBL}";
  private static final String CONNECTION_PROTOCOL_VAL_2 = "AMQPS_WS";
  private static final String CONNECTION_PROTOCOL_LBL_3 = "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_PROTOCOL_HTTPS_LBL}";
  private static final String CONNECTION_PROTOCOL_VAL_3 = "HTTPS";
  private static final String CONNECTION_PROTOCOL_LBL_4 = "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_PROTOCOL_MQTT_LBL}";
  private static final String CONNECTION_PROTOCOL_VAL_4 = "MQTT";
  public  static final String DEFAULT_CONNECTION_PROTOCOL = "AMQPS";

  // property names
  public static final String CONNECTION_STRING_PROPERTY_NAME = "connectionString";
  public static final String CONNECTION_PROTOCOL_PROPERTY_NAME = "connectionProtocol";

  public AzureAsDeviceOutboundTransportDefinition() {
    super(TransportType.OUTBOUND);
    try {
      List<LabeledValue> protocolAllowedValues = new ArrayList<>(4);
      protocolAllowedValues.add(new LabeledValue(CONNECTION_PROTOCOL_LBL_1, CONNECTION_PROTOCOL_VAL_1));
      protocolAllowedValues.add(new LabeledValue(CONNECTION_PROTOCOL_LBL_2, CONNECTION_PROTOCOL_VAL_2));
      protocolAllowedValues.add(new LabeledValue(CONNECTION_PROTOCOL_LBL_3, CONNECTION_PROTOCOL_VAL_3));
      protocolAllowedValues.add(new LabeledValue(CONNECTION_PROTOCOL_LBL_4, CONNECTION_PROTOCOL_VAL_4));

      propertyDefinitions.put(CONNECTION_STRING_PROPERTY_NAME, new PropertyDefinition(CONNECTION_STRING_PROPERTY_NAME, PropertyType.String, null, "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_CONNECTION_STR_LBL}", "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_CONNECTION_STR_DESC}", true, false));
      propertyDefinitions.put(CONNECTION_PROTOCOL_PROPERTY_NAME, new PropertyDefinition(CONNECTION_PROTOCOL_PROPERTY_NAME, PropertyType.String, DEFAULT_CONNECTION_PROTOCOL, "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_PROTOCOL_LBL}", "${com.esri.geoevent.transport.azure-device-transport.AS_DEVICE_PROTOCOL_DESC}", true, false, protocolAllowedValues));
    } catch (PropertyException error) {
      LOGGER.error("ERROR_LOADING_TRANSPORT_DEFINITION", error);
      throw new RuntimeException(error);
    }
  }

  @Override
  public String getName() {
    return "azure-as-device-out";
  }

  @Override
  public String getLabel() {
    return "${com.esri.geoevent.transport.azure-device-transport.TRANSPORT_AS_DEVICE_OUT_LABEL}";
  }

  @Override
  public String getDomain() {
    return "com.esri.geoevent.transport.outbound";
  }

  @Override
  public String getDescription() {
    return "${com.esri.geoevent.transport.azure-device-transport.TRANSPORT_AS_DEVICE_OUT_DESC}";
  }
}
