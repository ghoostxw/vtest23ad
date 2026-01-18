#!/bin/bash

# Set the build directory
BUILD_DIR="./app/build/outputs/apk/release"

# Clean previous builds
echo "Cleaning previous builds..."
./gradlew clean

# Assemble the release build
echo "Assembling the release build..."
./gradlew assembleRelease

# Check if the build was successful
if [ $? -ne 0 ]; then
    echo "Build failed!"
    exit 1
fi

# Create the release directory if it doesn't exist
mkdir -p "$BUILD_DIR"

# Move the APK to the build directory
echo "Moving APK to the build directory..."
mv ./app/build/outputs/apk/release/app-release.apk "$BUILD_DIR/v2ray-adguard-release.apk"

# Print success message
echo "Release build assembled successfully: $BUILD_DIR/v2ray-adguard-release.apk"