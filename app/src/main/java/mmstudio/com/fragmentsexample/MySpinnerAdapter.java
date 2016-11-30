package mmstudio.com.fragmentsexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MM studio on 11/23/2016.
 */

public class MySpinnerAdapter extends BaseAdapter implements android.widget.SpinnerAdapter {

    List<String> items = new ArrayList<>();

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int positon) {
        return items.get(positon);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItems(List<String> strings){
        items.addAll(strings);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            Context context = viewGroup.getContext();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.spinner_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }

        viewHolder.mSpinnerItem.setText(items.get(position));

        return view;
    }

     static class ViewHolder {

        TextView mSpinnerItem;

        ViewHolder(View view) {
            mSpinnerItem = (TextView) view.findViewById(R.id.lbl_spinner_text);
        }
    }
}
