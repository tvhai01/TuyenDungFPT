package app.tdc.edu.com.tuyendung;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import app.tdc.edu.com.tuyendung.Adapter.MyAdapter;
import app.tdc.edu.com.tuyendung.Object.Link;

/**
 * Created by Việt Hải on 4/12/2017.
 */

public class SearchActiviry extends Activity{
    static ArrayList<Link> link = new ArrayList<Link>();
    private MyAdapter adapter;

    String strUrl = "http://careerbuilder.vn/viec-lam/";
    String Url1 = "c";
    String Url2 = "l";
    String Url3 = "-vi.html";
    String keyViecLam = "";
    String keyThanhPho = "";

    private Bundle mappings;
    private HashMap<String, String> hmViecLam;
    private HashMap<String, String> hmThanhPho;
    AutoCompleteTextView edtChucDanh, edtTenViecLam , edtTenTP;
    TextView txtNameOne,txtNameTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);

        Button btnSearch = (Button)findViewById(R.id.btnSearch);
        Button btnHot = (Button)findViewById(R.id.btnHot);
        final AutoCompleteTextView edtTenViecLam = (AutoCompleteTextView) findViewById(R.id.edtNganhNghe);
        final AutoCompleteTextView edtChucDanh = (AutoCompleteTextView) findViewById(R.id.editChucDanh);
        final AutoCompleteTextView edtTenTP = (AutoCompleteTextView) findViewById(R.id.edtDiaDiem);

        txtNameOne = (TextView) findViewById(R.id.textView6);
        txtNameTwo = (TextView) findViewById(R.id.textView7);

        Animation slideright = AnimationUtils.loadAnimation(SearchActiviry.this,R.anim.slider_right);
        Animation slideleft = AnimationUtils.loadAnimation(SearchActiviry.this,R.anim.slider_left);

        txtNameTwo.startAnimation(slideright);
        txtNameOne.startAnimation(slideleft);

        edtTenViecLam
                .setOnEditorActionListener(new EditText.OnEditorActionListener() {

                    @Override
                    public boolean onEditorAction(TextView v, int actionId,
                                                  KeyEvent event) {
                        // TODO Auto-generated method stub
                        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                            performSearch();
                            return true;
                        }
                        return false;
                    }

                    private void performSearch() {
                        // TODO Auto-generated method stub
                    }
                });

        edtTenTP.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                // TODO Auto-generated method stub
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    PerFormSearch();
                    return true;
                }
                return false;
            }

            private void PerFormSearch() {
                // TODO Auto-generated method stub
            }
        });
        // Ten Viec Lam
        String[] TenVL = getResources().getStringArray(R.array.TenViecLam);
        // Create thenadapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, TenVL);
        edtTenViecLam.setAdapter(adapter);
        String[] KeyTenVL = getResources()
                .getStringArray(R.array.KeyTenViecLam);

        // Ten Thanh Pho
        String[] TenTP = getResources().getStringArray(R.array.TenThanhPho);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, TenTP);
        edtTenTP.setAdapter(adapter1);
        String[] KeyTenTP = getResources().getStringArray(R.array.KeyThanhPho);

        hmThanhPho = new HashMap<String, String>();
        hmViecLam = new HashMap<String, String>();

        for (int i = 0; i < TenTP.length; i++) {
            hmThanhPho.put(TenTP[i], KeyTenTP[i]);

        }
        for (int i = 0; i < TenTP.length; i++) {
            hmViecLam.put(TenVL[i], KeyTenVL[i]);
        }
        final Bundle bundle = new Bundle();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String tenVLChon = edtTenViecLam.getText().toString();
                String tenTPChon = edtTenTP.getText().toString();

                // Log.d("testTP",tenVLChon);
                // Log.d("testVL",tenTPChon);
                if(TextUtils.isEmpty(tenVLChon)) {
                    edtTenViecLam.setError("chưa nhập");
                    edtTenTP.setError("chưa nhập");
                    return;
                }

                if(tenTPChon == null && tenVLChon == null && tenTPChon.equals("")){
                    Toast.makeText(getApplicationContext(),"Dữ liệu Trống , hãy nhập lại",
                            Toast.LENGTH_LONG).show();

                }
                if (hmThanhPho.containsKey(tenTPChon))
                    keyThanhPho = hmThanhPho.get(tenTPChon);
                if (hmViecLam.containsKey(tenVLChon))
                    keyViecLam = hmViecLam.get(tenVLChon);
                Log.d("testTP", keyThanhPho);
                Log.d("testVL", keyViecLam);

                buiurl();

                Intent intent = new Intent(SearchActiviry.this,
                        ListViewDSActivity.class);

                bundle.putString("link", buiurl() + "");
                Log.d("aaa", bundle + "");

                intent.putExtra("data", bundle);
                Log.d("aaa", bundle + "");

                startActivity(intent);
                finish();

            }

            private String buiurl() {
                String url = strUrl + Url1 + keyViecLam + Url2 + keyThanhPho
                        + Url3;
                Log.d("testurl", url);
                return url;
            }

        });
        btnHot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActiviry.this,ListViewDSHotActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed(){
        outApp();
    }
    public void onSuperBackPressed(){
        super.onBackPressed();
    }

    public void outApp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                finish();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
