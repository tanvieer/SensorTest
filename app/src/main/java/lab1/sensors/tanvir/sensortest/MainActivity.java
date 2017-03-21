package lab1.sensors.tanvir.sensortest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView X,Y,Z;
    private Sensor SN;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        X = (TextView)findViewById(R.id.textX);
        Y = (TextView)findViewById(R.id.textY);
        Z = (TextView)findViewById(R.id.textZ);
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        SN = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this,SN, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        getAccelerometer(event);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //Log.d("testSensor",accuracy.);
    }

   /* @Override
    public void onCreate*/





    private void getAccelerometer(SensorEvent event){
        float[] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        Log.d("testSensor","x= "+x+" ,y= "+y+" ,z= "+z);

        X.setText(Float.toString(x));
        Y.setText(Float.toString(y));
        Z.setText(Float.toString(z));
    }
}
