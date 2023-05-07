package com.inkpenbookspublisher.model;

import lombok.Getter;

public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    AUTHOR_READ("author:read"),
    AUTHOR_UPDATE("author:update"),
    AUTHOR_CREATE("author:create"),
    AUTHOR_DELETE("author:delete")
    ;

    @Getter
    private final String permission;


    Permission(String permission) {
        this.permission = permission;
    }
}
