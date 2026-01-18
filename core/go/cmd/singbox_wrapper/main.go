package main

import (
    "log"
    "net/http"
    "os"
    "os/signal"
    "syscall"

    "github.com/example/v2rayadguard/core/go/internal/vless"
    "github.com/example/v2rayadguard/core/go/internal/fallback"
    "github.com/example/v2rayadguard/core/go/internal/mux"
)

func main() {
    // Initialize VLESS protocol
    vlessServer := vless.NewServer()
    go func() {
        if err := vlessServer.Start(); err != nil {
            log.Fatalf("Failed to start VLESS server: %v", err)
        }
    }()

    // Initialize fallback mechanism
    fallbackServer := fallback.NewServer()
    go func() {
        if err := fallbackServer.Start(); err != nil {
            log.Fatalf("Failed to start fallback server: %v", err)
        }
    }()

    // Initialize multiplexing
    muxServer := mux.NewServer()
    go func() {
        if err := muxServer.Start(); err != nil {
            log.Fatalf("Failed to start multiplexing server: %v", err)
        }
    }()

    // Handle graceful shutdown
    quit := make(chan os.Signal, 1)
    signal.Notify(quit, syscall.SIGINT, syscall.SIGTERM)
    <-quit

    log.Println("Shutting down servers...")
    vlessServer.Stop()
    fallbackServer.Stop()
    muxServer.Stop()

    log.Println("Servers stopped gracefully.")
}