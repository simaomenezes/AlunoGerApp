/**
 * 
 */
package com.simaomenezes.viewservice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author simao
 *
 */
public class ServiceAlunoView extends Activity {
	
	/**
	 * 
	 * */
	private Button btnGravar;

	/**
	 * 
	 */
	public ServiceAlunoView() {
		// TODO Auto-generated constructor stub
	}
	
	public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
		setContentView(R.layout.frm_aluno);
		
		initComponet();
		acionsFrm_aluno();
	}
	
	/**
	 * Inicia todos os componentes
	 **/
	public void initComponet(){
		this.btnGravar = (Button) findViewById(R.id.btnInsert);
	}
	
	/**
	 * Métodos das ações da view frm_aluno.xml
	 **/
	public void acionsFrm_aluno(){
		this.btnGravar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Toast.makeText(ServiceAlunoView.this, "Ola eu sou um btn", Toast.LENGTH_LONG).show();
				
			}
		});
	}
}
