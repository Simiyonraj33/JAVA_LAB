#include<jni.h>
#include<string.h>
#include"StringMain.h"

JNIEXPORT jint JNICALL Java_StringMain_StringLength(JNIEnv *env , jobject st,jstring s)
{  
	
}	
	
 JNIEXPORT jstring JNICALL Java_StringMain_Reverse(JNIEnv *env , jobject st,jstring s)
{  
	return strrev(s);
}