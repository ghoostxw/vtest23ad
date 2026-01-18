#!/bin/bash

# This script generates JNI bindings for the Go components of the project.

# Set the path to the Go mobile tool
GO_MOBILE_PATH=$(go env GOPATH)/bin/gomobile

# Check if gomobile is installed
if [ ! -f "$GO_MOBILE_PATH" ]; then
    echo "gomobile is not installed. Please install it by running:"
    echo "go get golang.org/x/mobile/cmd/gomobile"
    exit 1
fi

# Initialize gomobile
$GO_MOBILE_PATH init

# Generate bindings
$GO_MOBILE_PATH bind -o ../jni/bridge/go_bindings.aar ./core/go/internal/... 

echo "JNI bindings generated successfully."