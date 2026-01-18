module v2ray-adguard-android/core/go

go 1.18

require (
    github.com/v2ray/v2ray-core v4.45.0
    github.com/gorilla/websocket v1.5.0
    github.com/miekg/dns v1.0.0
    github.com/xtaci/kcp-go v1.3.0
    google.golang.org/grpc v1.39.0
)

replace (
    github.com/v2ray/v2ray-core => ../internal/vless
)