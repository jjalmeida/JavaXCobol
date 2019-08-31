package br.com.fujitsu.cobol;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

interface libcob extends Library {
	libcob INSTANCE = (libcob) Native.loadLibrary("dll/libcob-4", libcob.class);
	void cob_init(int argc, Pointer argv);
}