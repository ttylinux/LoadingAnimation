package com.hereshem.loadinganimation;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * <p>
 * Descriptons
 * </p>
 * 
 * @Company 深圳市博安达软件开发有限公司
 * @author LuShuWei(卢树伟) Create Date:2014年7月18日
 * @modify
 * 
 * 
 * 
 */

public class Adapter extends BaseAdapter {

	private List<HashMap<String, Object>> list;
	private Context mContext;

	public static final String DownLoad = "DownLoadStateKey";
	public static final String ItemName = "ItemNameKey";

	
	public Adapter(List<HashMap<String,Object>> datas, Context context)
	{
		this.list = datas;
		this.mContext = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (list != null) {
			return list.size();

		} else {
			return 0;
		}

	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if (list != null && list.size() > 0) {
			return list.get(position);

		} else {
			return null;
		}

	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolder view = null;
//		if (convertView == null) {
//
//			convertView = View.inflate(mContext, R.layout.one_item, null);
//
//			view = new ViewHolder();
//
//			view.imageView = (LoaderAnimation) convertView
//					.findViewById(R.id.loadingAnimation);
//			view.tv = (TextView) convertView.findViewById(R.id.ItemName);
//			convertView.setTag(view);
//		} else {
//
//			view = (ViewHolder) convertView.getTag();
//
//		}
		
		convertView = View.inflate(mContext, R.layout.one_item, null);
		view = new ViewHolder();
		view.imageView = (LoaderAnimation) convertView
				.findViewById(R.id.loadingAnimation);
		view.tv = (TextView) convertView.findViewById(R.id.ItemName);

		
		//设置状态
		HashMap<String, Object> one = list.get(position);
		//某个Item的数据，是要下载的，它对应的ImageView,有两种状态:一种是已经在laoding，那么，就无需再开启；一种是，没有在loading,那么，就要开启
		if ((Boolean) (one.get(DownLoad)) && !view.imageView.getLoadingState()) {

			view.imageView.startAnimation();
			view.imageView.setLoadingState(true);
			view.imageView.setVisibility(View.VISIBLE);
		} else {
			view.imageView.stopAnimation();
			view.imageView.setLoadingState(false);
			view.imageView.setVisibility(View.INVISIBLE);
		}
		view.tv.setText(one.get(ItemName)+"");
		

		return convertView;
	}

	class ViewHolder {

		private TextView tv;
		private LoaderAnimation imageView;

	}

}
