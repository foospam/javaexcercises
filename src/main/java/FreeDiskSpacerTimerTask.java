import java.util.TimerTask;
import java.util.Timer;

public class FreeDiskSpacerTimerTask extends TimerTask {

    public static void main(String[] args) {
        int PERIOD = 2000; // ms
        Timer timer = new Timer();
        TimerTask freeDiskSpace = new FreeDiskSpacerTimerTask();
        timer.schedule(freeDiskSpace, 0, PERIOD);
    }

    @Override
    public void run() {
        final double MIN_DISK_SPACE = 1000_000_000L;

        long freeDiskSpace = java.io.File.listRoots()[0].getFreeSpace();
        if (freeDiskSpace < MIN_DISK_SPACE) {
            System.out.printf("Free disk space lower than %s!", MIN_DISK_SPACE);
        }

    }
}
