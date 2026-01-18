#!/bin/bash

# Build the Go mobile bindings for JNI
cd jni/bridge
bash gomobile_build.sh

# Build the core Go components
cd ../../core/go
go build ./cmd/singbox_wrapper

# Move the built binaries to the appropriate location
mv singbox_wrapper ../../../../app/src/main/assets/

# Clean up
cd ../../..
rm -rf core/go/bin
rm -rf jni/bridge/*.so

echo "Native components built successfully."