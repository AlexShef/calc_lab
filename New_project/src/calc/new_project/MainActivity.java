package calc.new_project;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	
	Button bt_Add;
	Button bt_Sub;
	Button bt_Mul;
	Button bt_Div;
	
	Button bt_Result;
	
	TextView tv_Result;
	EditText et_Display;
	
	// Переменные
	double a = 0.0;
	double b = 0.0;
	double result = 0.0;
	
	enum Operand {Add,Sub,Mul,Div};
	Operand Oper = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Определяю обьекты по их id
        bt_Add = (Button) findViewById(R.id.bt_Add);
        bt_Sub = (Button) findViewById(R.id.bt_Sub);
        bt_Mul = (Button) findViewById(R.id.bt_Mul);
        bt_Div = (Button) findViewById(R.id.bt_Div);
        bt_Result = (Button) findViewById(R.id.bt_Result);
        
        tv_Result = (TextView) findViewById(R.id.tv_Result);
        et_Display = (EditText) findViewById(R.id.et_Display);
        
        // Присваиваю обработчик кнопкам
        bt_Add.setOnClickListener(this);
        bt_Sub.setOnClickListener(this);
        bt_Mul.setOnClickListener(this);
        bt_Div.setOnClickListener(this);
        bt_Result.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
      
        return true;
    }
    @Override
    public void onClick(View v){    	
        // Определяю id нажатой кнопки	
    	switch (v.getId()){
     	// нажата кнопка сложения
     	case(R.id.bt_Add):
     		// проверка на пустоту
     		if (TextUtils.isEmpty(et_Display.getText().toString())) {
   		      return;
   		    }
     		
     		a = Double.parseDouble(et_Display.getText().toString());
     		
     		et_Display.setText("0");
     		tv_Result.setText(a + "+");
     		
     		Oper = Operand.Add;
     		
     		break;
     	// нажата кнопка вычетание
     	case(R.id.bt_Sub):
     		
     		if (TextUtils.isEmpty(et_Display.getText().toString())) {
     		      return;
     		}
     		
     		a = Double.parseDouble(et_Display.getText().toString());
 			
     		et_Display.setText("0");
 			tv_Result.setText(a + "-");
 			
 			Oper = Operand.Sub;
    		
     		break;
     	// нажата кнопка умножения
     	case(R.id.bt_Mul):
     		
     		if (TextUtils.isEmpty(et_Display.getText().toString())) {
     		      return;
  		    }
     		
     		a = Double.parseDouble(et_Display.getText().toString());
     		
     		et_Display.setText("0");
     		tv_Result.setText(a + "*");
     		
     		Oper = Operand.Mul;
     		
     		break;
     	// нажата кнопка деления
     	case(R.id.bt_Div):
     		
     		if (TextUtils.isEmpty(et_Display.getText().toString())) {
     		      return;
     		}
     		
     		a = Double.parseDouble(et_Display.getText().toString());
 			
     		et_Display.setText("0");
 			tv_Result.setText(a + "/");
 			
 			Oper = Operand.Div;
    		
     		break;
     	case(R.id.bt_Result):
     		
     		if (TextUtils.isEmpty(et_Display.getText().toString())) {
     		      return;
     		}
     		
     		b =  Double.parseDouble(et_Display.getText().toString());
     	
     	    tv_Result.setText(a + "  " + b);
     	    // в соответствии со значением переменной Oper
     		switch (Oper){
     		case Add:
     			
     			result = a + b;
     			tv_Result.setText(a + "+" + b + "=" + result);
     			
     			break;
     		case Sub:
     			
     			result = a - b;
     			tv_Result.setText(a + "-" + b + "=" + result);
     			
     			break;
     		case Mul:
     			
     			result = a * b;
     			tv_Result.setText(a + "*" + b + "=" + result);
     			
     			break;
     		case Div:
     			
     			result = a / b;
     			tv_Result.setText(a + "/" + b + "=" + result);
     			
     			break;
     			
     		}
     	
     		et_Display.setText(""+result);
     		break;
     		
    	}
    }
}
