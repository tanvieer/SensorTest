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

public class ProximitySensor extends AppCompatActivity implements SensorEventListener{

    private TextView _value;
    private Sensor proximity;
    private SensorManager SM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);
    }


    @Override
    protected void onResume(){
        super.onResume();
        _value = (TextView)findViewById(R.id.value);


        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        proximity = SM.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SM.registerListener(this,proximity, SensorManager.SENSOR_DELAY_NORMAL);

    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        _value.setText("Value = "+Float.toString(event.values[0]));
        Log.d("testSensor","ProximitySensor Value = "+Float.toString(event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void onBack(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
    @Override
    protected void onStop() {
        super.onStop();
        SM.unregisterListener(this, SM.getDefaultSensor(Sensor.TYPE_PROXIMITY));
    }

}
