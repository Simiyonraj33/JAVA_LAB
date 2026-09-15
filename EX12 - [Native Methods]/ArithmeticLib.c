#include <jni.h>
#include "NativeArithmetic.h"
#include <stdio.h>

JNIEXPORT jint JNICALL Java_NativeArithmetic_add(JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b;
}
JNIEXPORT jint JNICALL Java_NativeArithmetic_sub(JNIEnv *env, jobject obj, jint a, jint b) {
    return a - b;
}
JNIEXPORT jint JNICALL Java_NativeArithmetic_mul(JNIEnv *env, jobject obj, jint a, jint b) {
    return a * b;
}
JNIEXPORT jint JNICALL Java_NativeArithmetic_div(JNIEnv *env, jobject obj, jint a, jint b) {
    return a / b;
}
