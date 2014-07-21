package com.hereshem.loadinganimation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * <p>
 * Descriptons
 * </p>
 * 
 * @Company 深圳市博安达软件开发有限公司
 * @author LuShuWei(卢树伟) Create Date:2014年7月21日
 * @modify
 * 
 * 
 * 
 */

public class ShowLoadingActivity extends Activity {

	private ListView list;
	private List<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
	private Adapter adapter;
	
	private OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			//点击，会从下载和停止下载之间进行切换
			HashMap<String,Object> one = datas.get(position);
			one.put(Adapter.DownLoad, !(Boolean)one.get(Adapter.DownLoad));
			
		  adapter.notifyDataSetChanged();
		}
	};

	@Override
	public void onCreate(Bundle state) {
		super.onCreate(state);
		setContentView(R.layout.loadinglist);
		init();

	}

	private void init() {

		list = (ListView) findViewById(R.id.list);
		generateData();

		adapter = new Adapter(datas, ShowLoadingActivity.this);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(onItemClickListener);

	}

	private void generateData() {

		for (int i = 0; i < 15; i++) {
			HashMap<String, Object> one = new HashMap<String, Object>();
			one.put(Adapter.ItemName, "Item_" + i);
			one.put(Adapter.DownLoad, false);

			datas.add(one);
		}

	}

}
