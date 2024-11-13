package com.psn.common.security.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDto implements UserDetails {
    private long id;
    private String username;

    private String password;

    private String email;

    private String firstName;
    private String lastName;
    private List<RoleSecurity> roles;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RoleSecurity {
        private long id;
        private String name;
        private String code;
        private String scopes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.roles.isEmpty()) return Collections.emptyList();
        var roleScopes = this.roles.stream().map(RoleSecurity::getScopes).collect(Collectors.joining(","));
        return Stream.of(roleScopes.split(",")).map(SimpleGrantedAuthority::new).toList();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
