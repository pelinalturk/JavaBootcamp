package com.inkpenbookspublisher.model;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.inkpenbookspublisher.model.Permission.ADMIN_READ;
import static com.inkpenbookspublisher.model.Permission.ADMIN_CREATE;
import static com.inkpenbookspublisher.model.Permission.ADMIN_UPDATE;
import static com.inkpenbookspublisher.model.Permission.ADMIN_DELETE;
import static com.inkpenbookspublisher.model.Permission.AUTHOR_READ;
import static com.inkpenbookspublisher.model.Permission.AUTHOR_CREATE;
import static com.inkpenbookspublisher.model.Permission.AUTHOR_DELETE;
import static com.inkpenbookspublisher.model.Permission.AUTHOR_UPDATE;



import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum Roles {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    AUTHOR_READ,
                    AUTHOR_UPDATE,
                    AUTHOR_DELETE,
                    AUTHOR_CREATE
            )
    ),
    AUTHOR(
            Set.of(
                    AUTHOR_READ,
                    AUTHOR_UPDATE,
                    AUTHOR_DELETE,
                    AUTHOR_CREATE
            )
    )

    ;

    @Getter
    private final Set<Permission> permissions;

    Roles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
