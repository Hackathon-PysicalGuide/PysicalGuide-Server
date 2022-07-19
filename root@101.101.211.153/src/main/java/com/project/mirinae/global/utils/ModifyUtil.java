package com.project.mirinae.global.utils;

public class ModifyUtil<T> {

    public T getUpdated(T origin, T newValue) {
            return (newValue != null) ? newValue : origin;
    }

}
