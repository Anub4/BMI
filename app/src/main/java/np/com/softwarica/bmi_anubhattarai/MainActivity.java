package np.com.softwarica.bmi_anubhattarai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etHeight, etWeight,etBMI;
    private Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        btnClick = findViewById(R.id.btnClick);
        etBMI = findViewById(R.id.etBMI);

        btnClick.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnClick){
            if (validate()){
                Anu_BMI bmi = new Anu_BMI();
                float heightInMeter = Float.parseFloat(etHeight.getText().toString())/100;
                bmi.setHeight(heightInMeter);
                bmi.setWeight(Float.parseFloat(etWeight.getText().toString()));
                float result = bmi.CalculateBMI();

                etBMI.setText(Float.toString(result));
                if (result < 18.5) Toast.makeText(this,"Underweight", Toast.LENGTH_LONG).show();
                if (result> 18.5 && result < 24.9) Toast.makeText(this,"Normal Weight", Toast.LENGTH_LONG).show();
                if (result> 25 && result < 29.9) Toast.makeText(this,"Over Weight", Toast.LENGTH_LONG).show();
                if (result >= 30) Toast.makeText(this,"Obesity", Toast.LENGTH_LONG).show();
            }
        }
    }
    public Boolean validate(){
        boolean validation = true;
        if (TextUtils.isEmpty(etWeight.getText().toString())){
            etWeight.setError("Please enter your weight");
            etWeight.requestFocus();
            validation = false;
        }
        if (TextUtils.isEmpty(etHeight.getText().toString())){
            etHeight.setError("Please enter your height");
            etHeight.requestFocus();
            validation = false;
        }
        return validation;
    }
}