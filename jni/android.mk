LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

# Define the module name and source files
MODULE_NAME := v2ray_adguard
SRC_FILES := \
    bridge/go_bindings.go

# Specify the module's shared library
include $(BUILD_SHARED_LIBRARY)

# Include the Go mobile bindings
include $(LOCAL_PATH)/bridge/gomobile_build.sh

# Add any additional flags or dependencies if needed
LOCAL_CFLAGS := -I$(LOCAL_PATH)/bridge

# Specify the output directory for the shared library
LOCAL_MODULE := $(MODULE_NAME)

# Include the shared library in the build
include $(BUILD_SHARED_LIBRARY)