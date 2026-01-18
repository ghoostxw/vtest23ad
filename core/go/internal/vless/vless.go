package vless

import (
	"context"
	"fmt"
	"net"
	"time"

	"github.com/v2ray/v2ray-core/v4/common/log"
	"github.com/v2ray/v2ray-core/v4/proxy/vless"
	"github.com/v2ray/v2ray-core/v4/transport/internet"
)

type VLESSServer struct {
	config *vless.Config
}

func NewVLESSServer(config *vless.Config) *VLESSServer {
	return &VLESSServer{
		config: config,
	}
}

func (s *VLESSServer) Start(ctx context.Context) error {
	listener, err := net.Listen("tcp", s.config.Address)
	if err != nil {
		return fmt.Errorf("failed to listen on %s: %v", s.config.Address, err)
	}
	defer listener.Close()

	log.Info("VLESS server started on %s", s.config.Address)

	for {
		select {
		case <-ctx.Done():
			return nil
		default:
			conn, err := listener.Accept()
			if err != nil {
				log.Error("failed to accept connection: %v", err)
				continue
			}
			go s.handleConnection(conn)
		}
	}
}

func (s *VLESSServer) handleConnection(conn net.Conn) {
	defer conn.Close()
	// Handle the VLESS connection here
	log.Info("New connection from %s", conn.RemoteAddr().String())
	// Implement VLESS protocol handling logic
}

func (s *VLESSServer) Stop() {
	// Implement stop logic if needed
	log.Info("VLESS server stopped")
}