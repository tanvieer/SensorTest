package lab1.sensors.tanvir.sensortest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProximitySensor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_sensor);
    }





    public void onBack(View v){
        startActivity(new Intent(this, MainActivity.class));
    }
}
