
# NFC Sound App

This Android app plays a specific sound when the phone detects an NFC reader that selects the registered AID.

## Setup

1. **Add Sound File:**
   - Place a sound file named `beep.mp3` in the `app/src/main/res/raw` directory.

2. **Build and Run:**
   - Open the project in Android Studio.
   - Build the project using Gradle.
   - Run the app on an NFC-enabled Android device (API 19+).

3. **Test:**
   - Ensure NFC is enabled on the device.
   - Use an NFC reader that selects the AID `F0010203040506`. When the reader interacts with the phone, the sound should play.

## Notes
- The app uses Host-based Card Emulation (HCE) to detect NFC reader interactions.
- The AID can be modified in `app/src/main/res/xml/apduservice.xml` if needed.
