package lab1.sensors.tanvir.sensortest;

        import android.content.Intent;
        import android.hardware.Sensor;
        import android.hardware.SensorEvent;
        import android.hardware.SensorEventListener;
        import android.hardware.SensorManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private TextView X,Y,Z;
    private Sensor SN;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
    }

    @Override
    protected void onResume(){
        super.onResume();


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
        //Log.d("AccelerometerTest",accuracy.);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SM.unregisterListener(this, SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }


    private void getAccelerometer(SensorEvent event){
        Log.d("AccelerometerTest","Test1");
        float[] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];

        Log.d("AccelerometerTest","Test2");
        Log.d("testSensor","x= "+x+" ,y= "+y+" ,z= "+z);

        X.setText("X = "+Float.toString(x));
        Y.setText("Y = "+Float.toString(y));
        Z.setText("Z = "+Float.toString(z));
    }

    public void onBack(View v){

        startActivity(new Intent(this, MainActivity.class));
    }


}
