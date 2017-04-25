package app.tdc.edu.com.tuyendung.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import app.tdc.edu.com.tuyendung.Object.ThuocTinh;
import app.tdc.edu.com.tuyendung.R;

/**
 * Created by Việt Hải on 4/11/2017.
 */

public class MyAdapter extends ArrayAdapter {
    Activity context = null;
    int itemlayout;
    ArrayList<ThuocTinh> question = null;

    public MyAdapter(Activity context, int resource, ArrayList<ThuocTinh> objects) {
        super(context, resource, objects);
        // TODO Auto-generated constructor stub
        this.context = context;
        itemlayout = resource;
        question = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        convertView = inflater.inflate(itemlayout, null);

        TextView txtTenCV = (TextView) convertView
                .findViewById(R.id.txtTieuDe);
        TextView txtTenCTy = (TextView) convertView
                .findViewById(R.id.txtCongTy);
        TextView txtTenTP = (TextView) convertView
                .findViewById(R.id.txtDiaDiem);
        TextView txtLuong = (TextView) convertView
                .findViewById(R.id.txtLuong);
        TextView txtDate = (TextView) convertView
                .findViewById(R.id.txtThoiGian);

        ThuocTinh jobs = question.get(position);

        if (jobs != null) {

//            Log.d("Hai", jobs.getTieude().toString());

            txtTenCV.setText(jobs.getTieude());
            txtTenCTy.setText(jobs.getCongty());
            txtTenTP.setText(jobs.getDiadiem());
            txtLuong.setText(jobs.getLuong());
            txtDate.setText(jobs.getNgaydang());
        }
        return convertView;
    }

    public ThuocTinh get(int position) {
        // TODO Auto-generated method stub
        return null;
    }

}
