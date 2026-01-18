# Interaction Between VPN and DNS Components

## Overview

This document outlines the interaction between the VPN and DNS components of the v2ray-adguard-android application. The application integrates a VPN service with DNS filtering capabilities to provide enhanced privacy and security while browsing the internet.

## Architecture

The application employs a modular architecture where the VPN and DNS components operate concurrently. The VPN component is responsible for tunneling traffic, while the DNS component handles DNS resolution and filtering.

### Components

1. **VPN Component**:
   - Utilizes Android's `VpnService` to create a secure tunnel for network traffic.
   - Supports various protocols including VLESS (TCP, XTLS, REALITY, WS, gRPC).
   - Implements fallback and multiplexing features to ensure reliable connectivity.

2. **DNS Component**:
   - Acts as a local DNS proxy to intercept DNS queries from applications.
   - Supports DNS-over-HTTPS (DoH) and DNS-over-TLS (DoT) for secure DNS resolution.
   - Implements ad-blocking features using custom filters (AdGuard, EasyList) to block ads, trackers, and malware.

## Interaction Flow

1. **Traffic Flow**:
   - When an application makes a network request, the DNS query is first intercepted by the DNS component.
   - The DNS component resolves the domain name using the configured DNS servers (supporting DoH/DoT).
   - The resolved IP address is then passed to the VPN component, which establishes a secure tunnel to the destination.

2. **Ad Blocking**:
   - The DNS component filters DNS queries against a set of predefined rules (e.g., EasyList, AdGuard).
   - If a query matches a blocking rule, the DNS component returns a predefined IP (e.g., 0.0.0.0) to prevent access to the ad or tracker.

3. **Split Tunneling**:
   - Users can configure split tunneling to allow specific applications or domains to bypass the VPN tunnel while still using DNS filtering.
   - The DNS component ensures that DNS queries from excluded applications are resolved normally, while those from included applications are filtered.

4. **Modes of Operation**:
   - The application supports multiple modes: "Only DNS", "Only VPN", and "VPN + AdBlock".
   - In "Only DNS" mode, the DNS component operates independently without the VPN.
   - In "Only VPN" mode, the VPN component tunnels traffic without DNS filtering.
   - In "VPN + AdBlock" mode, both components work together to provide a secure and ad-free browsing experience.

## Conclusion

The integration of VPN and DNS components in the v2ray-adguard-android application provides users with a powerful tool for enhancing their online privacy and security. By leveraging advanced tunneling protocols and robust DNS filtering capabilities, the application ensures a seamless and secure browsing experience.