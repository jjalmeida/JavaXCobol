package br.com.fujitsu.cobol;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface cobsoma extends Library {
	cobsoma INSTANCE = (cobsoma) Native.loadLibrary("dll/soma",cobsoma.class);
	int SOMA(Pointer aValue, Pointer bValue, Pointer cValue);
}
