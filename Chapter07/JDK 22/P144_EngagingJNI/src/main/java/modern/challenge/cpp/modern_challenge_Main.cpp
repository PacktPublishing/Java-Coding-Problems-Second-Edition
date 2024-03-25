#include <iostream>
#include "modern_challenge_Main.h"

JNIEXPORT jlong JNICALL Java_modern_challenge_Main_sumTwoInt
  (JNIEnv* env, jobject thisObject, jint x, jint y) {
    std::cout << "C++: The received arguments are : " << x << " and " << y << std::endl;
    return (long)x + (long)y;
}
