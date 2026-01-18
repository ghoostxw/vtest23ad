# Sample VLESS Configuration

This document provides a sample configuration for the VLESS protocol used in the v2ray-adguard-android application. The configuration is structured in JSON format and includes essential parameters for establishing a VLESS connection.

```json
{
  "outbounds": [
    {
      "protocol": "vless",
      "settings": {
        "vnext": [
          {
            "address": "your.server.address",
            "port": 443,
            "users": [
              {
                "id": "your-uuid",
                "alterId": 0,
                "security": "none"
              }
            ]
          }
        ],
        "tlsSettings": {
          "allowInsecure": false,
          "serverName": "your.server.name",
          "enable": true,
          "alpn": ["h2", "http/1.1"]
        }
      }
    }
  ],
  "inbounds": [
    {
      "port": 1080,
      "protocol": "socks",
      "settings": {
        "auth": "noauth",
        "udp": true,
        "ip": "127.0.0.1"
      }
    }
  ],
  "dns": {
    "servers": [
      "8.8.8.8",
      "1.1.1.1"
    ]
  },
  "routing": {
    "rules": [
      {
        "type": "field",
        "ip": ["geoip:private"],
        "outboundTag": "direct"
      }
    ]
  }
}
```

## Configuration Parameters

- **outbounds**: Defines the outbound connections for the VLESS protocol.
  - **protocol**: Specifies the protocol type (vless).
  - **settings**: Contains settings for the VLESS connection.
    - **vnext**: List of VLESS servers to connect to.
      - **address**: The address of the VLESS server.
      - **port**: The port number for the VLESS connection.
      - **users**: User credentials for authentication.
        - **id**: UUID for the user.
        - **alterId**: Alter ID for the user (set to 0 for VLESS).
        - **security**: Security method (none for VLESS).
    - **tlsSettings**: TLS configuration for secure connections.
      - **allowInsecure**: Whether to allow insecure connections.
      - **serverName**: Server name for TLS.
      - **enable**: Enable TLS.
      - **alpn**: Application Layer Protocol Negotiation settings.

- **inbounds**: Defines the inbound connections for the application.
  - **port**: The port number for the inbound connection.
  - **protocol**: The protocol type (socks).
  - **settings**: Configuration settings for the inbound connection.
    - **auth**: Authentication method (noauth for no authentication).
    - **udp**: Whether to enable UDP support.
    - **ip**: The IP address to bind the inbound connection.

- **dns**: DNS settings for the application.
  - **servers**: List of DNS servers to use for resolution.

- **routing**: Routing rules for traffic management.
  - **rules**: List of routing rules.
    - **type**: Type of rule (field).
    - **ip**: IP addresses to match for the rule.
    - **outboundTag**: Tag for the outbound connection to use.

This sample configuration can be modified according to your server details and requirements.