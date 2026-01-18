# Architecture of v2ray-adguard-android

## Overview
The v2ray-adguard-android application integrates VPN functionality using the VLESS protocol with ad-blocking capabilities powered by AdGuard. The architecture is designed to ensure seamless interaction between the VPN and DNS components while maintaining a user-friendly interface and efficient performance.

## Architecture Components

### 1. **User Interface (UI)**
- **MainActivity**: The entry point of the application, managing the main user interface and navigation.
- **QuickToggleFragment**: Provides a simple interface for users to toggle VPN and ad-blocking features.

### 2. **ViewModel**
- **MainViewModel**: Manages the application state and business logic, facilitating communication between the UI and data layers.

### 3. **Data Layer**
- **ConfigRepository**: Handles configuration data for both VPN and ad-blocking features, including import/export functionality.
- **PreferencesStore**: Manages local storage of user preferences and settings.

### 4. **Services**
- **VpnTunnelService**: Implements the VPN functionality using Android's VpnService, supporting VLESS protocols (TCP, XTLS, REALITY, WS, gRPC) with fallback and multiplexing.
- **DnsProxyService**: Manages the local DNS proxy for filtering and resolving DNS queries, supporting DNS-over-HTTPS and DNS-over-TLS.

### 5. **Ad-Blocking**
- **AdBlockManager**: Handles ad-blocking logic, manages custom filters (AdGuard, EasyList), and provides options for excluding applications and domains.

### 6. **DNS Engine**
- **DnsEngine**: Implements DNS resolution and filtering capabilities, ensuring that DNS queries are processed according to user-defined rules.

### 7. **Core Functionality**
- **Go-based VPN Core**: The core VPN functionality is implemented in Go, utilizing the sing-box framework for handling VLESS connections and multiplexing.
- **JNI Bridge**: Facilitates communication between Kotlin and Go components, allowing for efficient data exchange and function calls.

### 8. **Optimization and Security**
- The application is designed to run in the background without leaks, with minimal battery consumption. It includes features like Kill Switch and auto-connect on system startup.

## Interaction Between VPN and DNS
The VPN and DNS components work together to provide a secure and ad-free browsing experience. When a user connects to the VPN, all network traffic is routed through the VpnTunnelService, which also communicates with the DnsProxyService to resolve DNS queries locally. The DnsEngine filters these queries based on user-defined rules, blocking ads and trackers before they reach the network.

## Conclusion
The architecture of v2ray-adguard-android is structured to provide a robust and efficient solution for users seeking privacy and ad-blocking capabilities on Android devices. By leveraging modern technologies and best practices, the application aims to deliver a seamless user experience while maintaining high performance and security standards.