package kr.hs.emirim.young24.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //다중상속 x, onCLick~인터페이스 상속
    Button butPlus, butMinus, butMultiply,butDivide;
    EditText editNum1, editNum2;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout폴더에 있는 엑티비티에 있는 버튼들의 요소들을 저장해줌
        butPlus = (Button)findViewById(R.id.but_plus);//view가 버튼의 상위클래스라서 형변환하여서 참조값을 넣어준다.
        butMinus = (Button)findViewById(R.id.but_minus);
        butDivide = (Button)findViewById(R.id.but_divide);
        butMultiply = (Button)findViewById(R.id.but_multiply);
        editNum1=(EditText)findViewById(R.id.edit_num1);
        editNum2=(EditText)findViewById(R.id.edit_num2);
        textResult = (TextView)findViewById(R.id.text_result);
        butPlus.setOnClickListener(this);//이벤트 리소스와 핸들러가 연결이 됨
        butMinus.setOnClickListener(this);
        butDivide.setOnClickListener(this);
        butMultiply.setOnClickListener(this);
    }//메모리에 있는 참조값들을 받아서 준비해놓음

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {//이벤트 핸들러 클래스이기도 하다, 이벤트 처리자, 버튼과 이벤트를 연결 (이벤트가 밣생된 객체의 정보를 v가 가지고 있음)
        //2개의 EditText에 입력된 값을 반환받는다.
        String num1Str=editNum1.getText().toString();
        String num2Str=editNum2.getText().toString();//참조변수.텍스트.형변환
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        double result = 0.0;
        switch(v.getId()){//이벤트가 발생된 버튼의 객체가 가지고 있는 id 값
            case R.id.but_plus:
                result = num1+num2;break;
            case R.id.but_minus:
                result = num1-num2;break;
            case R.id.but_divide:
                result = (double)num1/num2;break;
            case R.id.but_multiply:
                result = num1*num2;break;
        }
        textResult.setText("* 계산 결과 : "+result);
    }
}
