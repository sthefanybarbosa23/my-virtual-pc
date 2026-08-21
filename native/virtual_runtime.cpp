// My Virtual PC - ARM64 guest runtime boundary
// Host: Android ARMv7/32-bit
// Guest: Xiaomi 11 / Android 11 / ARM64
//
// This file intentionally does not pretend to be a CPU emulator. A real
// ARM64-on-ARM32 implementation requires a complete full-system emulator.
// The functions below define the JNI/native boundary that the Android UI can
// use once the emulator backend is integrated.

#include <stdint.h>

extern "C" {

int mvpc_runtime_available() {
    // 0 until a complete software ARM64 full-system backend is bundled.
    return 0;
}

int mvpc_start_xiaomi11_guest() {
    // Reserved for the emulator backend.
    return -1;
}

int mvpc_stop_guest() {
    return 0;
}

}
