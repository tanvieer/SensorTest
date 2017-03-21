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

public class LightSensor extends AppCompatActivity  {

    private TextView textLight;
    private Sensor light;
    private SensorManager SM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
    }

    protected void onResume(){
        super.onResume();

        textLight = (TextView)findViewById(R.id.textLight);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        light = SM.getDefaultSensor(Sensor.TYPE_LIGHT);
        SM.registerListener(lightListener,light, SensorManager.SENSOR_DELAY_NORMAL);  // problem




        if(light != null){
            SM.registerListener(lightListener, light, SensorManager.SENSOR_DELAY_NORMAL);

        }else{
            textLight.setText("Sensor.TYPE_LIGHT NOT Available");
        }
    }

    public void onStop() {
        super.onStop();
        SM.unregisterListener(lightListener);
    }

    public SensorEventListener lightListener = new SensorEventListener() {
        public void onAccuracyChanged(Sensor sensor, int acc) { }

        public void onSensorChanged(SensorEvent event) {
            float x = event.values[0];

            textLight.setText("Value = "+(int)x + " lux");
            Log.d("testSensor","LightSensor Value = "+Float.toString(event.values[0]));
        }
    };

    public void onBack(View v){
        startActivity(new Intent(this, MainActivity.class));
    }



}
