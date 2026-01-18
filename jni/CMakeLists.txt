cmake_minimum_required(VERSION 3.4.1)

# Set the path to the Go mobile bindings
set(GO_BINDINGS_PATH ${CMAKE_CURRENT_SOURCE_DIR}/bridge)

# Include the Go mobile bindings
include_directories(${GO_BINDINGS_PATH})

# Add the JNI library
add_library(v2ray_adguard_jni SHARED
    ${GO_BINDINGS_PATH}/go_bindings.go
)

# Specify the libraries to link against
target_link_libraries(v2ray_adguard_jni
    log
    jnigraphics
)

# Set the output directory for the shared library
set_target_properties(v2ray_adguard_jni PROPERTIES
    LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/libs/${ANDROID_ABI}
)