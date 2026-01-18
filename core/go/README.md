# v2ray-adguard-android Core Go Implementation

This directory contains the core implementation of the VPN functionality using Go. The main components include support for the VLESS protocol, fallback mechanisms, and multiplexing.

## Directory Structure

- **cmd/singbox_wrapper**: Contains the main entry point for the VPN core.
- **internal**: Contains internal packages for various functionalities:
  - **vless**: Implements the VLESS protocol.
  - **fallback**: Implements fallback functionality for the VPN.
  - **mux**: Implements multiplexing functionality for the VPN.
- **config**: Contains configuration files and examples.

## Building the Project

To build the Go components, navigate to the `core/go` directory and run:

```bash
go build ./cmd/singbox_wrapper
```

Ensure that you have Go installed and properly configured in your environment.

## Sample Configuration

Refer to `config/sample_vless_config.json` for a sample configuration file for the VLESS protocol.

## Integration with Android

This Go core is designed to work seamlessly with the Android application, providing a robust VPN solution with ad-blocking capabilities. The JNI bridge facilitates communication between the Android app and the Go core.

## Dependencies

The dependencies for this module are defined in `go.mod`. Make sure to run `go mod tidy` to ensure all dependencies are correctly fetched.

## Contribution

Contributions are welcome! Please follow the standard Git workflow for submitting changes. Ensure that you adhere to the project's coding standards and include tests for any new features or bug fixes.