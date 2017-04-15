package app.tdc.edu.com.tuyendung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

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
    ImageView btnSearch;
    AutoCompleteTextView edtChucDanh, edtTenViecLam , edtTenTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);

        btnSearch = (ImageView)findViewById(R.id.btnSearch);
        final AutoCompleteTextView edtTenViecLam = (AutoCompleteTextView) findViewById(R.id.edtNganhNghe);
        final AutoCompleteTextView edtChucDanh = (AutoCompleteTextView) findViewById(R.id.editChucDanh);
        final AutoCompleteTextView edtTenTP = (AutoCompleteTextView) findViewById(R.id.edtDiaDiem);

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
    }
}
