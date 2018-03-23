package hk.ust.cse.comp4521.a4521template.action;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;

/**
 * Created by TM on 23-Mar-18.
 */

public class SoundModeAction extends Activity implements Action{
    @Override
    public void turnOn() {
        AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
    }

    @Override
    public void turnOff() {
        AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
    }
}
