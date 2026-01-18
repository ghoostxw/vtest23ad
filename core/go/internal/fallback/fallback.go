package fallback

import (
	"errors"
	"net"
	"time"
)

type Fallback struct {
	Addresses []string
	Timeout   time.Duration
}

func NewFallback(addresses []string, timeout time.Duration) *Fallback {
	return &Fallback{
		Addresses: addresses,
		Timeout:   timeout,
	}
}

func (f *Fallback) Resolve(domain string) (net.IP, error) {
	var lastErr error
	for _, addr := range f.Addresses {
		ip, err := f.resolveWithTimeout(domain, addr)
		if err == nil {
			return ip, nil
		}
		lastErr = err
	}
	return nil, lastErr
}

func (f *Fallback) resolveWithTimeout(domain, addr string) (net.IP, error) {
	d := net.Dialer{Timeout: f.Timeout}
	conn, err := d.Dial("udp", addr)
	if err != nil {
		return nil, err
	}
	defer conn.Close()

	// Implement DNS query logic here...

	return nil, errors.New("failed to resolve domain")
}