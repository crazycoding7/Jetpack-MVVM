package com.alex.jetpackmvvm.ext

import java.lang.reflect.ParameterizedType

fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}
