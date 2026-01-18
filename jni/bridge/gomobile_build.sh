#!/bin/bash

# This script builds the Go mobile bindings for JNI

set -e

# Set the path to the Go SDK
GO_SDK_PATH=$(go env GOROOT)

# Set the path to the gomobile tool
GOMOBILE_PATH=$(go env GOPATH)/bin/gomobile

# Check if gomobile is installed
if [ ! -f "$GOMOBILE_PATH" ]; then
    echo "gomobile is not installed. Please install it using 'go get golang.org/x/mobile/cmd/gomobile'."
    exit 1
fi

# Initialize gomobile
$GOMOBILE_PATH init

# Build the Go mobile bindings
$GOMOBILE_PATH bind -o ../jni/libs/ -target=android ./go_bindings.go

echo "Go mobile bindings have been successfully built."