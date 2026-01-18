# V2Ray + AdGuard Android Application

## Overview
This project combines the functionalities of V2Ray and AdGuard into a single Android application, providing users with a powerful VPN solution that includes ad-blocking capabilities. The application is built using Kotlin and follows the MVVM architecture pattern.

## Features
- **VPN Engine**: Implements VLESS protocol with support for TCP, XTLS, REALITY, WS, and gRPC.
- **Fallback and Multiplexing**: Supports fallback mechanisms and multiplexing for enhanced performance.
- **DNS and Ad Blocking**: Integrates DNS filtering and ad-blocking features.
- **Local DNS Proxy**: Acts as a local DNS proxy with support for DNS-over-HTTPS and DNS-over-TLS.
- **Custom Filters**: Allows users to add custom ad-blocking filters (AdGuard, EasyList).
- **Split Tunneling**: Users can choose which apps or domains to exclude from the VPN.
- **User Interface**: Minimalist UI designed with Material You principles.
- **Statistics and Logging**: Provides traffic statistics and logs for connections and DNS queries.
- **Security Features**: Includes a Kill Switch and auto-connect on system startup.

## Architecture
The application is structured into several modules:
- **App Module**: Contains the Android application code, including UI components, services, and view models.
- **Core Module**: Implements the core VPN functionality using Go.
- **JNI Module**: Manages the integration between Kotlin and Go using JNI.
- **Rust Module**: (Optional) Implements cryptographic functions for enhanced performance.
- **DNS Module**: Handles DNS resolution and filtering.

## Getting Started
1. **Clone the Repository**: 
   ```
   git clone <repository-url>
   cd v2ray-adguard-android
   ```

2. **Build the Project**: 
   Use the provided scripts to build the native components and assemble the release.
   ```
   ./scripts/build_native.sh
   ./scripts/assemble_release.sh
   ```

3. **Run the Application**: 
   Install the APK on your Android device and start using the application.

## Configuration
### Sample VLESS Configuration
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
        ]
      }
    }
  ]
}
```

## Optimization Recommendations
- Ensure the application runs efficiently in the background to minimize battery consumption.
- Implement caching strategies for DNS queries to reduce latency.
- Use native libraries for performance-critical components.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.