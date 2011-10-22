package com.simaomenezes.viewservice;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListaMain extends Activity {
	/**
	 * Declaração dos widgets
	 */
	private ListView listViewAlunos;
	private List<String> alunos;
	private ArrayAdapter<String> adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		// CHAMA O MÉTODO QUE INICIA TODOS OS COMPONENTES
		initComponent();
     // CHAMA O MÉTODO QUE LISTA TODOS OS ALUNOS
		getListaAlunos();
		// CHAMA O MÉTODO COM AS AÇÕES DA LISTVIEW
		actionListaMain();
    }
    
    /**
     * Chama a lista de alunos
     * */
    public void getListaAlunos(){
    	this.alunos = Arrays.asList("Simão Neto","Sara Moura Menezes","Ana Paula Moura");
    	this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
    }
    
    /**
     * Este método inicia todos os componentes da class ListaMain.java
     * 
     * */
    public void initComponent(){
    	this.listViewAlunos = (ListView) findViewById(R.id.listaAluno);
    	this.listViewAlunos.setLongClickable(true);
    }
    
    /**
	 * @Método para chamar as actions de cada fomulario.
	 */
    public void actionListaMain(){
    	this.listViewAlunos.setAdapter(adapter);
    	this.listViewAlunos.setClickable(true);
    	
    	this.listViewAlunos.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(ListaMain.this, "Posição Selecionada: " + posicao, Toast.LENGTH_LONG).show();				
			}
		});
    
    	this.listViewAlunos.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				// TODO Auto-generated method stub
				registerForContextMenu(listViewAlunos);
				return false;
			}
		});
    }
    
    
    /**
	 * Criação do menu para add um novo aluno
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem menuAddAluno = menu.add(0, 0, 0, "Novo Aluno");
		menuAddAluno.setIcon(R.drawable.addaluno);
		return true;
	}

	/**
	 * Tratando o click do item do menu addaluno
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		if (menuItem.getItemId() == 0) {
			// Toast.makeText(ListaAlunos.this, "Você clicou no novo aluno",
			// Toast.LENGTH_LONG).show();
			startActivity(new Intent(this, ServiceAlunoView.class));// chama a tela de cadasro de alunos
		}
		return true;
	}

	/**
	 * Criando menu de contexto
	 * 
	 */
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	/**
	 * 
	 */
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return super.onContextItemSelected(item);
	}
}