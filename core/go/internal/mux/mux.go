package mux

import (
	"errors"
	"net"
	"sync"
)

type Mux struct {
	connections map[string]net.Conn
	mu          sync.Mutex
}

func NewMux() *Mux {
	return &Mux{
		connections: make(map[string]net.Conn),
	}
}

func (m *Mux) AddConnection(key string, conn net.Conn) error {
	m.mu.Lock()
	defer m.mu.Unlock()

	if _, exists := m.connections[key]; exists {
		return errors.New("connection already exists")
	}

	m.connections[key] = conn
	return nil
}

func (m *Mux) RemoveConnection(key string) error {
	m.mu.Lock()
	defer m.mu.Unlock()

	if _, exists := m.connections[key]; !exists {
		return errors.New("connection does not exist")
	}

	delete(m.connections, key)
	return nil
}

func (m *Mux) GetConnection(key string) (net.Conn, error) {
	m.mu.Lock()
	defer m.mu.Unlock()

	conn, exists := m.connections[key]
	if !exists {
		return nil, errors.New("connection does not exist")
	}

	return conn, nil
}

func (m *Mux) CloseAll() {
	m.mu.Lock()
	defer m.mu.Unlock()

	for key, conn := range m.connections {
		conn.Close()
		delete(m.connections, key)
	}
}