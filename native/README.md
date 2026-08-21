# ARM64 Android guest runtime

This directory is the native-runtime layer for the Xiaomi 11 virtual device.

## Target
- Host: Android ARMv7 / 32-bit
- Guest: ARM64 / arm64-v8a
- Guest OS target: Android 11 / API 30
- Virtual device profile: Xiaomi 11

## Important
A 32-bit Android host cannot execute a 64-bit Android guest through normal Android app APIs. A real implementation therefore needs a complete software CPU emulator/full-system virtual machine and an ARM64 Android 11 guest image. This repository does not redistribute proprietary Xiaomi firmware or Google apps.

## Runtime phases
1. Detect host CPU and memory.
2. Load the Xiaomi 11 virtual hardware profile.
3. Initialize the software ARM64 CPU backend.
4. Initialize virtual RAM, storage, display and input.
5. Boot a legally obtained ARM64 Android 11 guest image.
6. Expose touch/display to the Android app.

The current project contains the integration boundary and configuration, but the full ARM64 CPU/full-system emulator is not yet bundled. It must be implemented or integrated from a compatible open-source emulator and built for the 32-bit Android host.
