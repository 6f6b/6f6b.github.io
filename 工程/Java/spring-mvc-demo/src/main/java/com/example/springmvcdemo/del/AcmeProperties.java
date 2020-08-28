package com.example.springmvcdemo.del;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;

//@Component
@ConstructorBinding
@ConfigurationProperties("acme")
public class AcmeProperties {

    private final boolean enabled;

    private final InetAddress remoteAddress;

//    private final Security security;

    public AcmeProperties(boolean enabled, InetAddress remoteAddress) {
        this.enabled = enabled;
        this.remoteAddress = remoteAddress;
    }

    public boolean isEnabled() { return enabled; }

    public InetAddress getRemoteAddress() { return remoteAddress; }

//    public Security getSecurity() { return security; }

//    public static class Security {
//
//        private final String username;
//
//        private final String password;
//
//        private final List<String> roles;
//
//        public Security(String username, String password,
//                        @DefaultValue("USER") List<String> roles) {
//            this.username = username;
//            this.password = password;
//            this.roles = roles;
//        }
//
//        public String getUsername() { return username; }
//
//        public String getPassword() { return password; }
//
//        public List<String> getRoles() { return roles; }
//
//    }
}
