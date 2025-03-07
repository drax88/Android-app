
package com.example.nfcsoundapp;

import android.media.MediaPlayer;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;

public class NfcSoundService extends HostApduService {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize MediaPlayer with the sound file
        mediaPlayer = MediaPlayer.create(this, R.raw.beep);
    }

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle extras) {
        // Play the sound when the reader sends an APDU command
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        // Return a success response (0x9000)
        return new byte[]{(byte) 0x90, 0x00};
    }

    @Override
    public void onDeactivated(int reason) {
        // Reset the MediaPlayer to play the sound again next time
        if (mediaPlayer != null) {
            mediaPlayer.seekTo(0);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Clean up MediaPlayer resources
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
