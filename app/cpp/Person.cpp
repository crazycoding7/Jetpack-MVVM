//
// Created by qishuai on 2020/12/17.
//
#include <jni.h>
#include "Person.h"

Person::Person() {}

int Person::getAge() {
    return this->age;
}

void Person::setAge(int age) {
    this->age = age;
}


extern "C" JNIEXPORT jlong JNICALL
Java_com_alex_androidjetpack_ui_ndk_JniPerson_createNativeObject(JNIEnv *env, jobject thiz) {
    jlong result;
    result = (jlong)new Person();
    return result;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_alex_androidjetpack_ui_ndk_JniPerson_setAge(JNIEnv *env, jobject thiz, jlong addr,
                                                     jint age) {
    //对象指针调用方法
    ((Person*)addr)->setAge(age);
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_alex_androidjetpack_ui_ndk_JniPerson_getAge(JNIEnv *env, jobject thiz, jlong addr) {
    return ((Person*)addr)->getAge();
}