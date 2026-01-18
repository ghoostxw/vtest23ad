package bridge

/*
#cgo CFLAGS: -I${SRCDIR}/include
#cgo LDFLAGS: -L${SRCDIR}/lib -lv2ray
#include <jni.h>
#include "v2ray.h"
*/

import "C"
import (
	"runtime"
	"unsafe"
)

// Exported functions for JNI integration

// StartVPN initializes and starts the VPN service
func StartVPN(config string) error {
	cConfig := C.CString(config)
	defer C.free(unsafe.Pointer(cConfig))

	result := C.start_vpn(cConfig)
	if result != 0 {
		return fmt.Errorf("failed to start VPN: %d", result)
	}
	return nil
}

// StopVPN stops the VPN service
func StopVPN() error {
	result := C.stop_vpn()
	if result != 0 {
		return fmt.Errorf("failed to stop VPN: %d", result)
	}
	return nil
}

// GetVPNStatus retrieves the current status of the VPN service
func GetVPNStatus() (string, error) {
	status := C.get_vpn_status()
	return C.GoString(status), nil
}

// Exported function to handle garbage collection
func init() {
	runtime.LockOSThread()
}